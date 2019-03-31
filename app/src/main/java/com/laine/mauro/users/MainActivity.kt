package com.laine.mauro.users

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.laine.mauro.users.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var position: Int = 0
    val users = listOf<User>(
        User("Miguel De Izaca", "Mexico City", "Xamarin"),
        User("Hector Garcia Molina", "Nuevo Leon", "Yahoo"),
        User("Federico Mena", "Mexico City", "Novell"))
    val user:User = users[position]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = user

        binding.nextButton.setOnClickListener {
            position++
            binding.user = users[getNextPosition()]
        }
    }

    private fun getNextPosition(): Int{
        return position.rem(users.size)
    }
}
