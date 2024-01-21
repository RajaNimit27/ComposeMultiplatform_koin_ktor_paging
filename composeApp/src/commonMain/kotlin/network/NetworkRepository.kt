package network

import app.cash.paging.Pager
import app.cash.paging.PagingData
import app.cash.paging.PagingConfig
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import models.Products
import network.ApiService.getProducts

class NetworkRepository(private val httpClient: HttpClient) {
    fun getProducts(): Flow<PagingData<Products>> = Pager(
        config = PagingConfig(pageSize = 10, initialLoadSize = 10, enablePlaceholders = false,),
        pagingSourceFactory = {
            ResultPagingSource { page, _ ->
                delay(500)
                httpClient.getProducts(page).map { it.list }
            }
        }
    ).flow
}