package com.example.vktest.domain

sealed class Response {

    data object Error: Response()

    data object Loading: Response()

    data object Success: Response()

}