package fr.epf.projet_android_guilhem_nils

import com.squareup.moshi.Json
import java.io.Serializable

data class Country(
    @Json(name = "name") val name: Name,
    @Json(name = "capital") val capital: List<String>,
    @Json(name = "flags") val flags: Flags,
    @Json(name = "population") val population: Long,
    @Json(name = "area") val area: Double,
    @Json(name = "languages") val languages: Map<String, String>
):Serializable

data class Name(
    @Json(name = "common") val common: String
):Serializable

data class Flags(
    @Json(name = "png") val png: String
):Serializable