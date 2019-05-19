package com.kscory.weeklybook.presentation.home

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.kscory.weeklybook.R
import com.kscory.weeklybook.domain.interactor.ChangeFavoriteUseCase
import com.kscory.weeklybook.domain.interactor.GetBookRecUseCase
import com.kscory.weeklybook.model.Recommendation
import com.kscory.weeklybook.presentation.UIResult
import com.kscory.weeklybook.presentation.common.mapper.toResult
import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import com.kscory.weeklybook.presentation.common.viewmodel.BaseRxAACViewModel
import com.kscory.weeklybook.presentation.home.viewusecase.ChangeFavoriteViewUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getBookRecommendedUseCase: GetBookRecUseCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase,
    private val changeFavoriteViewUseCase: ChangeFavoriteViewUseCase,
    private val schedulerProvider: SchedulerProvider
) : BaseRxAACViewModel(), LifecycleObserver {
    override val layoutId: Int
        get() = R.layout.fragment_home

    val recommendation: MutableLiveData<Recommendation> = MutableLiveData<Recommendation>()
    val isFavorite: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        getBookRecommendedUseCase.execute()
            .toResult(schedulerProvider)
            .subscribe {
                isLoading.value = it.inProgress

                when (it) {
                    is UIResult.Success -> {
                        recommendation.postValue(it.data)
                        isFavorite.value = it.data.isFavorite
//                        recommendation.set(it.data)
                    }
                    is UIResult.Failure -> {
                        // Todo Loading 실패시 메시지 작성
                    }
                }
            }
            .bindUtilDestroy()
    }

    fun onFavoriteClick() {
        recommendation.value?.let { rec: Recommendation ->
            changeFavoriteUseCase.execute(Pair(rec.id, isFavorite.value!!))
                .toResult(schedulerProvider)
                .subscribe {
                    isLoading.value = it.inProgress

                    when (it) {
                        is UIResult.Success -> {
                            isFavorite.value = it.data
                            changeFavoriteViewUseCase.changeFavorite(it.data)
                        }
                        is UIResult.Failure -> {
                            // Todo Favorite 실패시 메시지 작성
                        }
                    }
                }
                .bindUtilDestroy()
        }
    }
}