package com.developer.kotlinrecylerviewexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (recyclerV != null) {
            recyclerV.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
            recyclerV.adapter = FamousAdapter(getFamous())

        }
    }



    private fun getFamous(): MutableList<Famous> {
        val companies = mutableListOf(

            Famous("https://cdn.bolgegundem.com/d/other/5-259.jpg","Kemal Sunal"),
            Famous("https://blog.sinematv.com.tr/wp-content/uploads/2018/07/%C5%9Fener-%C5%9Fennnn-770x513.jpg","Şener Şen"),
            Famous("https://m.media-amazon.com/images/M/MV5BYjMxZGVmZWItMWZkMy00YjZjLTg4OWYtY2EyYWNhMGJhZTY2XkEyXkFqcGdeQXVyMjc2Mzk3ODA@._V1_UY317_CR9,0,214,317_AL_.jpg","Adile Naşit"),
            Famous("https://m.media-amazon.com/images/M/MV5BNWZiNmM1ZGEtNmNjNi00YTdiLTk1ZDItOTdjNWI2NjA5ODdiXkEyXkFqcGdeQXVyMjc2Mzk3ODA@._V1_UY317_CR26,0,214,317_AL_.jpg","Munir Ozkul")
        )

        return companies
    }

}
