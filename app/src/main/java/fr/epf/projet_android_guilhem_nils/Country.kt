package fr.epf.projet_android_guilhem_nils

import com.squareup.moshi.Json

data class Country(
    @Json(name = "name") val name: Name,
    @Json(name = "capital") val capital: List<String>,
    @Json(name = "flags") val flags: Flags
)

data class Name(
    @Json(name = "common") val common: String
)

data class Flags(
    @Json(name = "png") val png: String
)