package com.kscory.weeklybook.presentation.home

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.kscory.weeklybook.R
import com.kscory.weeklybook.domain.interactor.GetBookRecUseCase
import com.kscory.weeklybook.model.Recommendation
import com.kscory.weeklybook.presentation.UIResult
import com.kscory.weeklybook.presentation.common.mapper.toResult
import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import com.kscory.weeklybook.presentation.common.viewmodel.BaseRxAACViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getBookRecommendedUseCase: GetBookRecUseCase,
    private val schedulerProvider: SchedulerProvider
) : BaseRxAACViewModel(), LifecycleObserver {
    override val layoutId: Int
        get() = R.layout.fragment_home

    val recommendation: MutableLiveData<Recommendation> = MutableLiveData<Recommendation>()
    val title = MutableLiveData<String>()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        getBookRecommendedUseCase.execute()
            .toResult(schedulerProvider)
            .subscribe {
                isLoading.value = it.inProgress

                when (it) {
                    is UIResult.Success -> {
                        title.value = it.data.title
                        recommendation.postValue(it.data)
//                        recommendation.set(it.data)
                    }
                    is UIResult.Failure -> {
                    }
                }
            }
            .bindUtilDestroy()
    }

    fun onFavoriteClick() {

    }
}