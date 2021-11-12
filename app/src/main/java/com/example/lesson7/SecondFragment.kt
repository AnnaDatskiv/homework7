package com.example.lesson7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson7.databinding.FragmentSecondBinding

const val newColor = "Color"

class SecondFragment : Fragment() {

    private lateinit var bind: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentSecondBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rColor = arguments?.getInt(newColor)
        rColor?.let { bind.second.setBackgroundColor(it) }
    }


    companion object {

        @JvmStatic
        fun new(rColor: Int) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(newColor, rColor)
                }
            }
    }
}
