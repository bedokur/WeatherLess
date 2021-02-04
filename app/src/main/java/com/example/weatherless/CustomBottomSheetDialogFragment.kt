package com.example.weatherless

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherless.databinding.LayoutModalBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {


    companion object {
        const val TAG = "CustomBottomSheetDialogFragment"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_modal_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.firstButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "First Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//        binding.secondButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "Second Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//        binding.thirdButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "Third Button Clicked", Toast.LENGTH_SHORT).show()
//        }
    }
}