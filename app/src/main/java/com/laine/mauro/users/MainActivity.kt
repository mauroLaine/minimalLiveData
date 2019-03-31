package com.laine.mauro.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.laine.mauro.users.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model = ViewModelProviders.of(this).get(UserViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = model.getNextUser()

        val nameObserver = Observer<String> { test ->
            Toast.makeText(this, test, Toast.LENGTH_SHORT).show()
        }
        model.test.observe(this, nameObserver)

        binding.nextButton.setOnClickListener {
            val user = model.getNextUser()
            binding.user = user
            model.setNewValue(user.name)
        }
    }
}
