package fr.epf.projet_android_guilhem_nils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.projet_android_guilhem_nils.RestCountriesApiService.api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val searchButton = findViewById<ImageButton>(R.id.search_county_button)

        searchButton.setOnClickListener {
            val searchText = findViewById<EditText>(R.id.home_search_country).text.toString()
            performSearch(searchText)
        }
    }

    private fun performSearch(searchText: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val countries = RestCountriesApiService.api.getAllCountries()
                val filteredCountries = countries.filter {
                    it.name.common.contains(searchText, ignoreCase = true) ||
                            it.capital.any { capital -> capital.contains(searchText, ignoreCase = true) }
                }
                withContext(Dispatchers.Main) {
                    updateUI(filteredCountries)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun updateUI(countries: List<Country>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(countries)
    }

}