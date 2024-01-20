package network

import io.ktor.client.HttpClient
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import models.ApiResponse

object ApiService {
    suspend fun HttpClient.getProducts(page: Int = 1) =
        getResults<ApiResponse> {
            url("https://dummyjson.com/products?limit=10&page-$page")
            method = HttpMethod.Get
        }
}