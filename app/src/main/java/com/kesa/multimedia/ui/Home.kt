package com.kesa.multimedia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kesa.multimedia.R
import com.kesa.multimedia.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.bnvHome.setOnItemReselectedListener {menuItem ->

            when (menuItem.itemId){
                R.id.home ->{

                    loadFragment(HomeFragment())

                }

                R.id.games ->{

                    loadFragment(GameFragment())

                }

                R.id.settings ->{

                    loadFragment(SettingsFragment())

                }

                R.id.profile ->{

                    loadFragment(ProfileFragment())

                }

                else -> {
                    loadFragment(HomeFragment())
                }
            }
        }
    }

    fun loadFragment(fragment: Fragment):Boolean{
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fcvHome, fragment)
        fragmentTransaction.commit()
        return true
    }
}