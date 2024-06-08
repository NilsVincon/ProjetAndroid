package fr.epf.projet_android_guilhem_nils;

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class CountryViewModel : ViewModel() {
        var allCountries: List<Country> = emptyList()
        var countries: List<Country> = emptyList()

        fun loadAllCountries(onCountriesLoaded: (List<Country>) -> Unit, onError: (String) -> Unit) {
                viewModelScope.launch {
                        try {
                                val countriesResponse = RestCountriesApiService.api.getAllCountries()
                                Log.d("CountryViewModel", "Fetched countries: ${countriesResponse.size}")
                                allCountries = countriesResponse
                                countries = countriesResponse
                                onCountriesLoaded(countries)
                        } catch (e: Exception) {
                                Log.e("CountryViewModel", "Failed to load countries", e)
                                onError("Failed to load countries: ${e.message}")
                        }
                }
        }

        fun filterCountries(query: String, onCountriesFiltered: (List<Country>) -> Unit) {
                val filteredCountries = allCountries.filter {
                        it.name.common.contains(query, ignoreCase = true) ||
                                (it.capital != null && it.capital.any { capital -> capital.contains(query, ignoreCase = true) })
                }
                Log.d("CountryViewModel", "Filtered countries: ${filteredCountries.size}")
                countries = filteredCountries
                onCountriesFiltered(countries)
        }}
