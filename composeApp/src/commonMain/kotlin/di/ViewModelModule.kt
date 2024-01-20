package di

import org.koin.dsl.module
import viewmodel.HomeViewModel

val provideviewModelModule = module {
    single {
        HomeViewModel(get())
    }
}