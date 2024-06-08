package fr.epf.projet_android_guilhem_nils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private lateinit var countryAdapter: CountryAdapter
    private val viewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val searchButton = findViewById<ImageButton>(R.id.search_county_button)
        val searchEditText = findViewById<EditText>(R.id.home_search_country)

        searchButton.setOnClickListener {
            val searchText = searchEditText.text.toString()
            performSearch(searchText)
        }

        setupRecyclerView()
        observeViewModel()

        // Charger les pays au démarrage
        viewModel.loadAllCountries()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        countryAdapter = CountryAdapter()
        recyclerView.adapter = countryAdapter
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this) { countries ->
            Log.d("HomeActivity", "Updating RecyclerView with ${countries.size} countries")
            countryAdapter.updateCountries(countries)
        }
        viewModel.errorMessage.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun performSearch(query: String) {
        viewModel.filterCountries(query)
    }
}
