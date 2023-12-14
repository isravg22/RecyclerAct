package com.example.recycleract

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class imagenRecyclerView : AppCompatActivity(), PokemonAdapter.OnItemListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var elementAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val pokemons = obtenerDatos()
        elementAdapter = PokemonAdapter(this, pokemons, this)
        recyclerView.adapter = elementAdapter
    }

    private fun obtenerDatos(): List<Pokemon> {
        return listOf(
            Pokemon("Charmander", "https://www.esimagenes.com/pimagen/pokemon-charmander.png", "1.80m", "20kg", "1"),
            Pokemon("Bulbasaur", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS_aCHshN4mQMzG9ZroZcum2Yr6xEOX9AG6w&usqp=CAU", "2.0m", "5kg", "2"),
            Pokemon("Squirtle", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtMG42ggrqHA6LsGjZGWeUqHM8GJHuHleNMQ&usqp=CAU", "1.50m", "15kg", "3"),
            Pokemon("Pikachu", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUEK7npV9DOLmXsFS3TAZxa1N3bY2eXehNJg&usqp=CAU", "0.60m", "6kg", "4"),
            Pokemon("Jigglypuff", "https://seeklogo.com/images/J/jigglypuff-logo-04F3B79EB3-seeklogo.com.png", "0.50m", "5kg", "5"),
            Pokemon("Eevee", "https://seeklogo.com/images/E/eevee-logo-D6A54F96A5-seeklogo.com.png", "0.30m", "3kg", "6"),
            Pokemon("Snorlax", "https://seeklogo.com/images/S/snorlax-logo-4B47B6B547-seeklogo.com.png", "2.50m", "500kg", "7"),
            Pokemon("Mewtwo", "https://seeklogo.com/images/M/mewtwo-logo-A5488767D0-seeklogo.com.png", "2.00m", "150kg", "8"),
            Pokemon("Gengar", "https://seeklogo.com/images/G/gengar-logo-51B23095D0-seeklogo.com.png", "1.60m", "40kg", "9"),
            Pokemon("Magikarp", "https://seeklogo.com/images/M/magikarp-logo-C65DFE76BE-seeklogo.com.png", "0.25m", "2kg", "10")
        )
    }

    override fun onImagenItinerationClick(image: String) {
        val intent = Intent(this, AmpliarImagen::class.java)

        startActivity(intent)
    }

    override fun onItemClick(pokemonNombre: String) {
        Toast.makeText(this, "Pokemon pulsado: $pokemonNombre", Toast.LENGTH_SHORT).show()
    }
}
