package com.tasneem.newsapp.data.remote.network

import com.tasneem.newsapp.data.exception.BadRequestException
import com.tasneem.newsapp.data.exception.NoInternetException
import com.tasneem.newsapp.data.exception.NotFoundException
import com.tasneem.newsapp.data.exception.ServerException
import com.tasneem.newsapp.data.exception.UnknownException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.util.network.UnresolvedAddressException
import okio.IOException

internal suspend inline fun <reified T> safeApiCall(
    apiCall: suspend () -> HttpResponse
): T {
    val result = try {
        apiCall()
    } catch (_: IOException) {
        throw NoInternetException()
    } catch (_: UnresolvedAddressException) {
        throw NoInternetException()
    } catch (exception: Exception) {
        throw exception
    }

    return mapStatusCodeToException(result)
}

private suspend inline fun <reified T> mapStatusCodeToException(result: HttpResponse): T {
    return when (result.status.value) {
        in 200..299 -> {
            result.body<T>()
        }

        400 -> throw BadRequestException()
        404 -> throw NotFoundException()
        in 500..599 -> throw ServerException()
        else -> throw UnknownException()
    }
}