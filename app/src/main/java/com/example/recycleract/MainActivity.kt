package com.example.recycleract

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(),ElementAdapter.onItemListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_RecyclerAct)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView1()
    }
    private fun setupRecyclerView1(){
        var pokemons:List<Pokemon> =listOf(
            Pokemon("1","Itinerario 1","Vista de Cadiz","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvrnvIC_rGwgj1NNj_4IhLt4Ak9TtaQQiR5Q&usqp=CAU","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvrnvIC_rGwgj1NNj_4IhLt4Ak9TtaQQiR5Q&usqp=CAU")
        )
        PicassoFun(pokemons.get(1).image)
    }

    override fun onImagenItinerationClick(image: String) {
        val intent= Intent(this,imagenRecyclerView::class.java)
    }

    override fun onItemClick(albumId: String) {
        Toast.makeText(this,"Funciona el nuevo Toast",Toast.LENGTH_LONG).show()
    }
    fun PicassoFun(url:String){
        Picasso.with(this).load(url)
    }
}