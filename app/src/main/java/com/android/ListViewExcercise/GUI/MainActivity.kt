package com.android.ListViewExcercise.GUI

import android.app.ListActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.ListViewExcercise.Model.Friends
import com.android.ListViewExcercise.R

class MainActivity : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // NO setContent because it is only a Listview

        val friends = Friends()

        val friendNames = friends.getAllNames()

        val adapter: ListAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, friendNames
        )

        listAdapter = adapter
    }


    override fun onListItemClick(parent: ListView?,
                                 v: View?, position: Int, id: Long) {
        // position is in the list!
        // first get the name of the person clicked
        val name = Friends().getAll()[position].name
        // and a greeting
        Toast.makeText(
            this,
            "Hi $name! Have you done your homework?",
            Toast.LENGTH_LONG
        ).show()
    }

}