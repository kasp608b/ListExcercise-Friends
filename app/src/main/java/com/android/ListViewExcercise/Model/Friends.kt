package com.android.ListViewExcercise.Model

class Friends {

    val mFriends = arrayOf<BEFriend>(
        BEFriend("Jonas", "123", "Cirk Road 23", true),
        BEFriend("Anders", "1234", "Cullen Strasse 88",false),
        BEFriend("Nikolaj", "12345", "Order road 48",true),
        BEFriend("Nadia", "12345678", "Funk street 77",true),
        BEFriend("Michael", "23456789", "Spork way 90",true),
        BEFriend("Kacper", "87654321", "Ornithopter road 65",false),
        BEFriend("Rocio", "12121212", "Jolly place 3",true),
        BEFriend("Alan", "12876543", "Corniver street 5",false),
        BEFriend("Rado", "14755432", "Percival way 12",true),
        BEFriend("Cecilia", "21212121", "Latham road 39",true),
        BEFriend("Alan", "12876543", "Bento street 99",false),
        BEFriend("Christina", "12344321", "Queen's road 87",false),
        BEFriend("Anne", "12876543", "King's road 78",false),
        BEFriend("Kim", "12876543", "Herod way 58",true)
    )

    fun getAll(): Array<BEFriend> = mFriends


    fun getAllNames(): Array<String>  =  mFriends.map { aFriend -> aFriend.name }.toTypedArray()


}