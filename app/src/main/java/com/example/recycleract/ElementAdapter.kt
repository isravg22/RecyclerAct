package com.example.recycleract

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ElementAdapter (
    var context:Context,
    var pokemons:List<Pokemon>,
    private val itemClickListener:onItemListener):RecyclerView.Adapter<ElementAdapter.ViewHolder>() {
        interface onItemListener {
            fun onImagenItinerationClick(image: String)
            fun onItemClick(albumId: String)
        }

        inner class ViewHolder(val view: View) :
            RecyclerView.ViewHolder(view) {
                var id = view.findViewById<TextView>(R.id.id)
                var albumId = view.findViewById<TextView>(R.id.albumId)
                var title = view.findViewById<TextView>(R.id.title)
                var image = view.findViewById<ImageView>(R.id.image)
                var icon = view.findViewById<ImageView>(R.id.icon)

                fun bind(pokemon: Pokemon, context: Context) {
                    id.text = pokemon.id
                    albumId.text = pokemon.albumId
                    title.text = pokemon.title

                    Log.i("IMAGEN", "Imagen: ${pokemon.image}")
                    Log.i("ICONO", "Icono: ${pokemon.icon}")
                    Glide.with(context).load(pokemon.image).into(image)

                    Glide.with(context).load(pokemon.icon).into(icon)
                    view.setOnClickListener{
                        itemClickListener.onItemClick(pokemon.albumId)

                            Toast.makeText(view.context,"Elemento listado pulsado",Toast.LENGTH_SHORT).show()
                        }
                    image.setOnClickListener{
                        itemClickListener.onImagenItinerationClick(pokemon.image)
                    }
                }
            }
        override  fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ViewHolder{
            val view=LayoutInflater
                .from(parent.context)
                .inflate(R.layout.activity_main,parent,false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder:ViewHolder,position:Int){
            var pokemon=pokemons[position]
            holder.bind(pokemon, context)
        }
        override fun getItemCount():Int{
            return pokemons.size
        }
}

