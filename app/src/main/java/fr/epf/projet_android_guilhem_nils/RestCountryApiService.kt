package fr.epf.projet_android_guilhem_nils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RestCountriesApiService {

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val api: RestCountryApi by lazy {
        retrofit.create(RestCountryApi::class.java)
    }
}