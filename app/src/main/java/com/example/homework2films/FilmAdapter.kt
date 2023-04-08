package com.example.jetpacknav
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacknav.R

class FilmAdapter(
    val fragment: FirstFragment,
    var films: ArrayList<Film>,
    val listner: Listener
) :RecyclerView.Adapter<FilmAdapter.FilmViewHolder>()  {

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewFilmName : TextView = itemView.findViewById(R.id.nameOfFilm)
        var textViewFilmShortDescription : TextView = itemView.findViewById(R.id.shortDesciption)
        var yearOfFilm : TextView = itemView.findViewById(R.id.year)
        var image : ImageView = itemView.findViewById(R.id.imageFilm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.film_card,parent,false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return films.size
    }


    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listner.onClick(position)
        }
        Glide.with(fragment)
            .load(films.get(position).urlPhoto).fitCenter().into(holder.image)
        holder.textViewFilmName.text = films.get(position).name
        holder.textViewFilmShortDescription.text = films.get(position).shortDescription
        holder.yearOfFilm.text = films.get(position).year
    }

    interface Listener {
        fun onClick(itemView: Int)
    }
}