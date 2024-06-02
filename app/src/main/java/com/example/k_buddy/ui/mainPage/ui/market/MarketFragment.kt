package com.example.k_buddy.ui.mainPage.ui.market

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.k_buddy.R
import com.example.k_buddy.data.recyclerviewData.marketItem
import com.example.k_buddy.data.recyclerviewData.recommendItem
import com.example.k_buddy.databinding.FragmentMarketBinding
import com.example.k_buddy.recyclerviewAdapter.MarketAdapter
import com.example.k_buddy.recyclerviewAdapter.RecommendAdapter

class MarketFragment : Fragment() {

    private var _binding: FragmentMarketBinding? = null
    private var dataList= ArrayList<marketItem>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(MarketViewModel::class.java)

        _binding = FragmentMarketBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
////        dashboardViewModel.text.observe(viewLifecycleOwner) {
////            textView.text = it
////        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataList.apply {
            add(marketItem("Item 1", "@Seller1", "4.5", "#Hashtag1 #Hashtag2", "1 day", "15,000 won", R.drawable.sample_place_3))
            add(marketItem("Item 2", "@Seller2", "4.0", "#Hashtag3 #Hashtag4", "2 days", "20,000 won", R.drawable.sample_place_2))
            add(marketItem("Item 3", "@Seller3", "4.7", "#Hashtag5 #Hashtag6", "3 days", "25,000 won", R.drawable.sample_place_9))
            add(marketItem("Item 3", "@Seller3", "4.7", "#Hashtag5 #Hashtag6", "3 days", "25,000 won", R.drawable.sample_place_4))
            add(marketItem("Item 3", "@Seller3", "4.7", "#Hashtag5 #Hashtag6", "3 days", "25,000 won", R.drawable.sample_place_5))
        }
        val market_adapter =  MarketAdapter(dataList) { item ->
            val intent = Intent(activity, ConnectionActivity::class.java)
            intent.putExtra("itemName", item.name)
            intent.putExtra("itemSellerId", item.sellerId)
            intent.putExtra("itemRating", item.rating)
            intent.putExtra("itemHashtags", item.hashtags)
            intent.putExtra("itemDay", item.day)
            intent.putExtra("itemPrice", item.price)
            intent.putExtra("itemImageUrl", item.imageUrl)
            startActivity(intent)
        }
        binding.marketRecyclerView.adapter = market_adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}