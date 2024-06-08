package fr.epf.projet_android_guilhem_nils;

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
        private val _allCountries = MutableLiveData<List<Country>>()
        private val _countries = MutableLiveData<List<Country>>()
        val countries: LiveData<List<Country>> get() = _countries

        private val _errorMessage = MutableLiveData<String>()
        val errorMessage: LiveData<String> get() = _errorMessage

        fun loadAllCountries() {
                viewModelScope.launch {
                        try {
                                val countries = RestCountriesApiService.api.getAllCountries()
                                Log.d("CountryViewModel", "Fetched countries: ${countries.size}")
                                _allCountries.postValue(countries)
                                _countries.postValue(countries) // Initialiser la liste visible
                        } catch (e: Exception) {
                                _errorMessage.postValue("Failed to load countries: ${e.message}")
                        }
                }
        }

        fun filterCountries(query: String) {
                val filteredCountries = _allCountries.value?.filter {
                        it.name.common.contains(query, ignoreCase = true) ||
                                it.capital.any { capital -> capital.contains(query, ignoreCase = true) }
                } ?: listOf()
                Log.d("CountryViewModel", "Filtered countries: ${filteredCountries.size}")
                _countries.postValue(filteredCountries)
        }
}
