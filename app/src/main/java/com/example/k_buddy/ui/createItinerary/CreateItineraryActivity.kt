package com.example.k_buddy.ui.createItinerary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityCreateItineraryBinding

class CreateItineraryActivity : AppCompatActivity() {
    private val createItineraryViewModel: CreateItineraryViewModel by viewModels()
    private lateinit var binding: ActivityCreateItineraryBinding
    private lateinit var intent: Intent
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

        // Spinner 선택 리스너 설정
        placeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // 선택된 항목을 ViewModel에 저장
                val selectedItem = parent.getItemAtPosition(position).toString()
                createItineraryViewModel.selectAddItem(selectedItem)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // 아무 항목도 선택되지 않은 경우
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
            intent = Intent(this, ActivityCreateItineraryBinding::class.java)
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
        binding.addItineraryBox.setOnClickListener{
            placeSpinner.performClick()
        }
    }
}