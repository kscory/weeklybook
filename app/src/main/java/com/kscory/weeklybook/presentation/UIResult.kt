package com.kscory.weeklybook.presentation

sealed class UIResult<T>(val inProgress: Boolean) {

    class InProgress<T>: UIResult<T>(true) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            return true
        }

        override fun hashCode(): Int = javaClass.hashCode()
    }

    data class Success<T>(var data: T): UIResult<T>(false)
    data class Failure<T>(var errorMsg: String?, val e: Throwable): UIResult<T>(false)

    companion object {
        fun <T> inProgress(): UIResult<T> = InProgress()
        fun <T> success(data: T): UIResult<T> = Success(data)
        fun <T> failure(errorMsg: String?, e: Throwable): UIResult<T> = Failure(errorMsg, e)
    }
}