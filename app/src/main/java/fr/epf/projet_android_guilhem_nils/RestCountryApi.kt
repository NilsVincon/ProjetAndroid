package fr.epf.projet_android_guilhem_nils

import retrofit2.http.GET


interface RestCountryApi {
        @GET("v3.1/all")
        suspend fun getAllCountries(): List<Country>
}
