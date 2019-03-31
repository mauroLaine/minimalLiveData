package com.laine.mauro.users

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private var position: Int = 0

    private val users = listOf<User>(
        User("Miguel De Izaca", "Mexico City", "Xamarin"),
        User("Hector Garcia Molina", "Nuevo Leon", "Yahoo"),
        User("Federico Mena", "Mexico City", "Novell")
    )

    val test: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getNextUser(): User {
        position++
        return users[getNextPosition()]
    }

    fun setNewValue(newTest: String) {
        test.value = newTest
    }

    private fun getNextPosition(): Int {
        return position.rem(users.size)
    }
}