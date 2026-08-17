package com.example.core.domain.model.result
import com.example.core.domain.model.error.Error
typealias DomainError = Error

sealed interface  Result<out T,out E: DomainError>{
    data class Success<out T, out E : DomainError>(val data: T) : Result<T, E>
    data class Error<out T, out E : DomainError>(val error: E) : Result<T, E>

}
inline  fun <T, E : DomainError, R> Result<T, E>.map(mapper: (T) -> R): Result<R, E>{
    return when (this) {
        is Result.Success -> Result.Success(mapper(data))
        is Result.Error -> Result.Error(error)
    }
    }
inline fun <T, E : DomainError, R> Result<T, E>.flatMap(transform: (T) -> Result<R, E>): Result<R, E> {
    return when (this) {
        is Result.Success -> transform(data)
        is Result.Error -> Result.Error(error)
    }
}
inline  fun <T,E: DomainError> Result <T,E>.onSuccess(action: (T) -> Unit): Result<T,E>{
    return when (this) {
        is Result.Success->{
            action(data)
            this
        }
        is Result.Error -> this
    }
}
inline  fun <T,E: DomainError> Result <T,E>.onError(action: (E) -> Unit): Result<T,E>{
    return when (this) {
        is Result.Success -> {
            this
        }

        is Result.Error -> {
            action(error)
            this
        }
    }
}

