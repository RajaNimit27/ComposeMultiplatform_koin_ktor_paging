package di

import network.NetworkRepository
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<NetworkRepository> { NetworkRepository(get()) }
}