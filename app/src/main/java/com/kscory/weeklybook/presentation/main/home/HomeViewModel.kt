package com.kscory.weeklybook.presentation.main.home

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.kscory.weeklybook.R
import com.kscory.weeklybook.domain.interactor.ChangeFavoriteUseCase
import com.kscory.weeklybook.domain.interactor.GetBookRecUseCase
import com.kscory.weeklybook.model.Recommendation
import com.kscory.weeklybook.presentation.UIResult
import com.kscory.weeklybook.presentation.common.mapper.toResult
import com.kscory.weeklybook.presentation.common.resource.ResourceProvider
import com.kscory.weeklybook.presentation.common.resource.ToastProvider
import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import com.kscory.weeklybook.presentation.common.viewmodel.BaseRxAACViewModel
import com.kscory.weeklybook.presentation.main.home.viewusecase.ChangeFavoriteViewUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getBookRecommendedUseCase: GetBookRecUseCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase,
    private val changeFavoriteViewUseCase: ChangeFavoriteViewUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val toastProvider: ToastProvider,
    private val resourceProvider: ResourceProvider
) : BaseRxAACViewModel(), LifecycleObserver {
    override val layoutId: Int
        get() = R.layout.fragment_home

    val recommendation: MutableLiveData<Recommendation> = MutableLiveData<Recommendation>()
    val isLoadingRec: MutableLiveData<Boolean> = MutableLiveData()
    val isFailingLoadRec: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }

    val isFavorite: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    val isLoadingFavorite: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }

    init {
        getBookRecommendedUseCase.execute()
            .toResult(schedulerProvider)
            .subscribe {
                isLoadingRec.value = it.inProgress

                when (it) {
                    is UIResult.Success -> {
                        recommendation.postValue(it.data)
                        isFavorite.value = it.data.isFavorite
                    }
                    is UIResult.Failure -> {
                        isFailingLoadRec.value = true
                    }
                }
            }
            .bindUtilDestroy()
    }

    fun onFavoriteClick() {
        if (isFailingLoadRec.value == true || isLoadingRec.value == true) return

        // Todo 나중에 rxBinding 으로 이중 클릭 방지할 수 있으면 하자 !!
        if (isLoadingFavorite.value == false) {
            recommendation.value?.let { rec: Recommendation ->
                changeFavoriteUseCase.execute(Pair(rec.id, isFavorite.value!!))
                    .toResult(schedulerProvider)
                    .subscribe {
                        isLoadingFavorite.value = it.inProgress

                        when (it) {
                            is UIResult.Success -> {
                                isFavorite.value = it.data
                                changeFavoriteViewUseCase.changeFavorite(it.data)
                            }
                            is UIResult.Failure -> {
                                Log.e("fail", resourceProvider.string(R.string.failure_home_change_favorite))
                                toastProvider.makeToast(resourceProvider.string(R.string.failure_home_change_favorite))
                            }
                        }
                    }
                    .bindUtilDestroy()
            }
        }
    }
}