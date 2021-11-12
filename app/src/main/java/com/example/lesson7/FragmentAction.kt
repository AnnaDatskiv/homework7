package com.example.lesson7

interface FragmentAction {
    fun addFragment(needBackstack: Boolean, rColor: Int, addMethod: AddMethod)

    enum class AddMethod {
        Add, Replace
    }
}