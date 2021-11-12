package com.example.lesson7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentAction {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        val view = bind.root
        setContentView(view)

    }

    override fun addFragment(
        needBackstack: Boolean, rColor: Int, addMethod:
        FragmentAction.AddMethod) {
        val transaction = supportFragmentManager.beginTransaction()

        when (addMethod) {
            FragmentAction.AddMethod.Replace -> transaction.replace(
                bind.containerSecond.id,
                SecondFragment.new(rColor)
            )
            FragmentAction.AddMethod.Add -> transaction.add(
                bind.containerSecond.id,
                SecondFragment.new(rColor)
            )
        }
                if(needBackstack){
                    transaction.addToBackStack(null)
                }
            transaction.commit()
    }
}