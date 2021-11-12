package com.example.lesson7

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson7.FragmentAction.*
import com.example.lesson7.databinding.FragmentFirstBinding
import kotlin.random.Random

class FirstFragment : Fragment() {

    private lateinit var bind: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentFirstBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.createFragment.setOnClickListener {
            if (requireActivity() is FragmentAction) {
                val backstack = bind.backstack.isChecked
                val rnd = Random.Default
                val color = Color.argb(
                    255, rnd.nextInt(0, 255), rnd.nextInt(0, 255),
                    rnd.nextInt(0, 255)
                )

                val addMethod =
                    if (bind.radioGroup.checkedRadioButtonId == bind.add.id)
                        AddMethod.Add
                    else AddMethod.Replace

                (requireActivity() as FragmentAction).addFragment(backstack, color, addMethod)
            }
        }
    }
}