package com.example.dilyanayankova.listview

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listView)

        listView.adapter = MyCustomAdapter(this) //my custom adapter, telling my view what to render
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {
        private val mContext:Context
        private val names = arrayListOf<String>(
                "Yarema", "German", "MarathonOfPlovediv", "Pancharevorun", "Ludogorie", "Vitosha"
        )

        init {
            mContext= context //represent which activity we are
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
//responsible for how many rows
        override fun getCount(): Int {
          return  5
        }

        override fun getItem(p0: Int): Any {
            return "test string"
        }

        //respondible for rendering each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflator = LayoutInflater.from(mContext)
            val rowMain = layoutInflator.inflate(R.layout.main_row, viewGroup, false)//gives me the view

            val positionTextView = rowMain.findViewById<TextView>(R.id.position_texView)
            positionTextView.text = "Row number : $position"

            val namesTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            namesTextView.text = names.get(position)
            return  rowMain

        }
    }
}
