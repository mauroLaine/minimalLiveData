package com.laine.mauro.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.laine.mauro.users.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(UserViewModel::class.java)
        model.user.observe(this, Observer<User> { user ->
            binding.user = user
        })
        model.getNextUser()

        binding.nextButton.setOnClickListener {
            model.getNextUser()
        }
    }
}
