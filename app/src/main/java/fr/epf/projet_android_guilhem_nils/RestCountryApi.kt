package fr.epf.projet_android_guilhem_nils

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestCountryApi {
        @GET("v3.1/all")
        suspend fun getAllCountries(): List<Country>

        @GET("v3.1/name/{name}")
        fun searchCountries(@Query("name") name: String): Call<List<Country>>
}
