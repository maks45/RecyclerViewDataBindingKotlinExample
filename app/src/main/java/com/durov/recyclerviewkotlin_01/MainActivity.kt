package com.durov.recyclerviewkotlin_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.durov.recyclerviewkotlin_01.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val list: ArrayList<Person> = ArrayList()
    private lateinit var myItemViewAdapter: MyItemViewAdapter
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initList()

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerView.setHasFixedSize(true)


        myItemViewAdapter = MyItemViewAdapter(
            list, this
        ) { itemClick ->
            Unit
            Toast.makeText(this, itemClick.id.toString(), Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = myItemViewAdapter
    }

    private fun initList() {
        for (i in 0..100) {
            list.add(Person("Maksim", "Durov", i))
        }
    }
}
