package kz.android.androidlab2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.androidlab2.adapters.FigureAdapter
import kz.android.androidlab2.databinding.FragmentMainBinding
import kz.android.androidlab2.models.Figure
import kz.android.androidlab2.network.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = FigureAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())


        binding.searchBtn.setOnClickListener {
            search(binding.searchEt.text.toString())
        }


    }
    private fun search(name: String) {
        Repository.service.getFiguresByName(name).enqueue(object : Callback<List<Figure>> {
            override fun onResponse(call: Call<List<Figure>>, response: Response<List<Figure>>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                }
            }
            override fun onFailure(call: Call<List<Figure>>, t: Throwable) {
                Log.e("Network", t.message.toString())
            }

        })
    }
}