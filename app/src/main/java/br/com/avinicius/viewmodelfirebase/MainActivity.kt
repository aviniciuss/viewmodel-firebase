package br.com.avinicius.viewmodelfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(LanguagesViewModel::class.java)
        viewModel.getLanguages().observe(this, Observer {
            Log.i("LOL", it.toString())
        })
    }
}
