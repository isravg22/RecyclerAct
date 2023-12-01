package com.example.recycleract

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
class PokemonAdapter(
    private val context: Context,
    private val pokemons: List<Pokemon>,
    private val itemClickListener: OnItemListener
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    interface OnItemListener {
        fun onImagenItinerationClick(image: String)
        fun onItemClick(albumId: String)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var nombre = view.findViewById<TextView>(R.id.nombre)
        var image = view.findViewById<ImageView>(R.id.image)
        var altura = view.findViewById<TextView>(R.id.altura)
        var peso = view.findViewById<TextView>(R.id.peso)
        var nId = view.findViewById<TextView>(R.id.nId)

        fun bind(pokemon: Pokemon) {
            nId.text = pokemon.nId
            nombre.text = pokemon.nombre
            altura.text = pokemon.altura
            peso.text=pokemon.peso
            Glide.with(context)
                .load(pokemon.imagen)
                .into(image)

            view.setOnClickListener {
                itemClickListener.onItemClick(pokemon.nombre)
            }

            image.setOnClickListener {
                itemClickListener.onImagenItinerationClick(pokemon.imagen)
                val intent= Intent(context,AmpliarImagen::class.java)
                intent.putExtra("imagenUrl",pokemon.imagen)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_pokemon, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }
    override fun getItemCount(): Int {
        return pokemons.size
    }
}
