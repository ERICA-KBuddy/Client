package com.example.k_buddy.ui.createItinerary

import CreateItineraryViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityCreateItineraryBinding
import com.example.k_buddy.ui.ReviewItinerary.ReviewItineraryActivity

class CreateItineraryActivity : AppCompatActivity() {
    private val createItineraryViewModel: CreateItineraryViewModel by viewModels()
    private lateinit var binding: ActivityCreateItineraryBinding
    private lateinit var itineraryAdapter: ItineraryAdapter
    private lateinit var intent: Intent
    private var isFirstLoad = true // 플래그 추가

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateItineraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner 설정
        val placeSpinner = binding.placeSpinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.add_button_item,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        placeSpinner.adapter = adapter
        placeSpinner.isFocusable = false // 초기화 시 선택 이벤트가 발생하지 않도록 설정
        placeSpinner.isFocusableInTouchMode = false

        // RecyclerView 설정
        itineraryAdapter = ItineraryAdapter()
        binding.recyclerView.adapter = itineraryAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // ViewModel의 items 관찰하여 RecyclerView 업데이트
        createItineraryViewModel.items.observe(this, Observer { items ->
            itineraryAdapter.updateItems(items)
            if (items.isNotEmpty()) {
                binding.recyclerView.visibility = View.VISIBLE
            }
        })

        // Spinner 선택 리스너 설정
        placeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (isFirstLoad) {
                    isFirstLoad = false // 첫 로드 시에는 선택 이벤트를 무시
                    return
                }

                val selectedItem = parent.getItemAtPosition(position).toString()
                Log.e("hyunsu", "선택리스너 $selectedItem")
                when (selectedItem) {
                    "Add a place" -> {
                        createItineraryViewModel.addPlace(Place("", "", ""))
                        Log.e("hyunsu", "Place 추가됨")
                    }
                    "Add a transportation" -> {
                        createItineraryViewModel.addTransport(Transport(0,"", 0, ""))
                        Log.e("hyunsu", "Transportation 추가됨")
                    }
                }
                placeSpinner.isFocusable = true // 선택 이벤트 발생 후 다시 포커스를 설정
                placeSpinner.setSelection(0) // 선택 후 스피너 초기화
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Log.e("hyunsu", "onNothingSelected $parent")
            }
        }

        /*
            뒤로가기 버튼 클릭
         */
        binding.btnSaveExit.setOnClickListener {
            finish()
        }

        /*
        여행기 작성 버튼 클릭
        */
        binding.nextButton.setOnClickListener {
            intent = Intent(this, ReviewItineraryActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*
            add 버튼
         */
        binding.addPlaceButton.setOnClickListener {
            placeSpinner.performClick()
        }

        /*
            add 박스
         */
        binding.addItineraryBox.setOnClickListener {
            createItineraryViewModel.toggleContainerVisibility()
        }
    }

    private fun containerVisibility(bool: Boolean) {
        binding.recyclerView.visibility = if (bool) View.VISIBLE else View.GONE
    }
}
