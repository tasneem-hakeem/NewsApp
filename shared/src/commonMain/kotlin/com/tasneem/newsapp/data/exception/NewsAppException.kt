package com.tasneem.newsapp.data.exception

open class NewsAppException(message: String = "") : Exception(message)

class NoInternetException(message: String = "") : NewsAppException(message)

class BadRequestException(message: String = "") : NewsAppException(message)
class NotFoundException(message: String = "") : NewsAppException(message = "Not Found: $message")

open class ServerException(message: String = "") : NewsAppException(message)

class UnknownException(message: String = "") : NewsAppException(message)