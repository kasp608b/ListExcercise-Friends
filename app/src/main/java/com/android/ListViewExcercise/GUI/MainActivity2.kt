package com.android.ListViewExcercise.GUI

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import com.android.ListViewExcercise.Model.BEFriend
import com.android.ListViewExcercise.Model.Friends
import com.android.ListViewExcercise.R

class MainActivity2 : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter = SimpleAdapter(
            this,
            asListMap(Friends().getAll()),
            R.layout.cell,
            arrayOf("name", "phone"),
            intArrayOf(R.id.name, R.id.phone)
        )
    }

    /* Input: an array of friend objects
       Return: a list of hashmaps, where each hashmap represent a friend object from input
     */
    private fun asListMap(src: Array<BEFriend>): List<Map<String, String?>> {

        return src.map{ person -> hashMapOf("name" to person.name, "phone" to person.phone) }
    }


    override fun onListItemClick(
        parent: ListView?,
        v: View?, position: Int, id: Long
    ) {
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