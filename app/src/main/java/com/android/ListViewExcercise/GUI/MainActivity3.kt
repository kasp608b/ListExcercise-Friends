package com.android.ListViewExcercise.GUI

import android.app.Activity
import android.app.ListActivity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.ListViewExcercise.Model.BEFriend
import com.android.ListViewExcercise.Model.Friends
import com.android.ListViewExcercise.R

class MainActivity3 : Activity() {
    var isToggle = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        isToggle = false
        val adapter = FriendAdapter(this, Friends().getAll())

        val lv = findViewById<ListView>(R.id.listView)
        val tg = findViewById<ToggleButton>(R.id.toggleButton)
        lv.setOnItemClickListener{_, _, position, _ ->  handleClick(position)}
        tg.setOnClickListener{ v -> handleToggleClick()}

        lv.adapter = adapter
    }

     fun handleClick(position: Int) {
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

    fun handleToggleClick(){

        if (isToggle) {
            isToggle = false
            val lv = findViewById<ListView>(R.id.listView)
            val adapter = FriendAdapter(this, Friends().getAll())
            lv.adapter = adapter
        }
        else
        {
            isToggle = true
            val lv = findViewById<ListView>(R.id.listView)
            val adapter = FriendAdapter(this, Friends().getAll().filter { f -> f.isFavorite == true  }.toTypedArray())
            lv.adapter = adapter

        }


    }

    internal class FriendAdapter(context: Context,
                                 private val friends: Array<BEFriend>
    ) : ArrayAdapter<BEFriend>(context, 0, friends)
    {
        private val colours = intArrayOf(
            Color.parseColor("#AAAAAA"),
            Color.parseColor("#CCCCCC")
        )

        override fun getView(position: Int, v: View?, parent: ViewGroup): View {
            var v1: View? = v
            if (v1 == null) {
                val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                        as LayoutInflater
                v1 = li.inflate(R.layout.cell_extended, null)

            }
            val resView: View = v1!!
            resView.setBackgroundColor(colours[position % colours.size])
            val f = friends[position]
            val nameView = resView.findViewById<TextView>(R.id.tvNameExt)
            val phoneView = resView.findViewById<TextView>(R.id.tvPhoneExt)
            val addressView = resView.findViewById<TextView>(R.id.tvAddressExt)
            val favoriteView = resView.findViewById<ImageView>(R.id.imgFavoriteExt)
            nameView.text = f.name
            phoneView.text = f.phone
            addressView.text = f.address

            favoriteView.setImageResource(if (f.isFavorite) R.drawable.ok else R.drawable.notok)
            return resView
        }
    }

}