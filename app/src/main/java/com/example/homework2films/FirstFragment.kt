package com.example.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacknav.R
import com.example.jetpacknav.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), FilmAdapter.Listener {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var films = ArrayList<Film>()
    lateinit var adapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var film1 = Film("Furious 7", "thriller","2015",getString(R.string.fullDescFilm1) , getString(R.string.urlFilm1))
        var film2 = Film("Shotgun Wedding", "comedy","2022",getString(R.string.fullDescFilm2) , getString(R.string.urlFilm2))
        var film3 = Film("Emancipation", "drama","2022",getString(R.string.fullDescFilm3) , getString(R.string.urlFilm3))
        var film4 = Film("Scream 6", "horror","2023",getString(R.string.fullDescFilm4) , getString(R.string.urlFilm4))
        var film5 = Film("Murder Mystery", "detective","2019",getString(R.string.fullDescFilm5) , getString(R.string.urlFilm5))

        films.add(film1)
        films.add(film2)
        films.add(film3)
        films.add(film4)
        films.add(film5)

        adapter = FilmAdapter(this ,films, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(SecondFragment.numberInArray to itemView,
            SecondFragment.name to films.get(itemView).name,
            SecondFragment.desc to films.get(itemView).shortDescription,
            SecondFragment.year to films.get(itemView).year,
            SecondFragment.fullDesc to films.get(itemView).fullDesc,
            SecondFragment.url to films.get(itemView).urlPhoto)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }


}

