package com.sample.data.networking

import com.google.gson.annotations.Expose

open class Resource<T> (
    @Expose val data : T? = null,
    @Expose val message : String? = null,
){
    class Success<T>(data: T) : Resource<T>(data = data)
    class Loading<T>(data : T? = null) : Resource<T>(data = data)
    class Error<T>(message : String) : Resource<T>(message = message)
}