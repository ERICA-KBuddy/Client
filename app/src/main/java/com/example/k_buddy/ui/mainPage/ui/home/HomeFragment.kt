package com.example.k_buddy.ui.mainPage.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.k_buddy.R
import com.example.k_buddy.data.recyclerviewData.allPlaceItem
import com.example.k_buddy.data.recyclerviewData.recommendItem
import com.example.k_buddy.databinding.FragmentHomeBinding
import com.example.k_buddy.recyclerviewAdapter.AllPlaceAdapter
import com.example.k_buddy.recyclerviewAdapter.RecommendAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var recommendDataList= ArrayList<recommendItem>()
    private var allPlaceDataList= ArrayList<allPlaceItem>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recommendDataList.apply {
            add(recommendItem("temp","temp","4.5","(15 reviews)", R.drawable.temp3))
            add(recommendItem("temp","temp","4.5","(15 reviews)", R.drawable.temp3))
            add(recommendItem("temp","temp","4.5","(15 reviews)", R.drawable.temp3))
            add(recommendItem("temp","temp","4.5","(15 reviews)", R.drawable.temp3))
        }
        allPlaceDataList.apply {
            add(allPlaceItem("Place 1", R.drawable.temp3))
            add(allPlaceItem("Place 2", R.drawable.temp3))
            add(allPlaceItem("Place 3", R.drawable.temp3))
        }
        val recommend_adapter =  RecommendAdapter(recommendDataList)
        val allPlace_adapter = AllPlaceAdapter(allPlaceDataList)
        binding.recommendRecyclerview.adapter = recommend_adapter
        binding.allPlaceRecyclerview.adapter = allPlace_adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}