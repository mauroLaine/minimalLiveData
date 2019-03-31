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

    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    fun getNextUser() {
        user.value = users[getNextPosition()]
        position++
    }

    private fun getNextPosition(): Int {
        return position.rem(users.size)
    }
}