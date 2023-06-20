package com.sample.utils

interface Mapper <T,R> {
    fun map(t: T): R
}