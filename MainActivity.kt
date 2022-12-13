package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wishList = ArrayList()
        recyclerView = findViewById(R.id.rvWishes)
        btnSubmit = findViewById(R.id.btnSubmit)
        adapter = WishListAdapter(this,wishList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val Name = findViewById<EditText>(R.id.etName)
        val Price = findViewById<EditText>(R.id.etPrice)
        val Link = findViewById<EditText>(R.id.etLink)
        Submit_btn.setOnClickListener {
            val name = Name.text.toString()
            val price = Price.text.toString().toDouble()
            val link = Link.text.toString()
            wishList.add(Wish("Name: $name","Price: $price", "$link"))
            adapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
            Link.setText("")
            Price.setText("")
            Name.setText("")
        }
    }
}