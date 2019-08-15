package br.com.avinicius.viewmodelfirebase

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class BaseValueEventListener(
    private val callback: LanguagesRepository.FirebaseDatabaseRepositoryCallback<Language>
) : ValueEventListener {

    override fun onCancelled(databaseError: DatabaseError) {
        callback.onError(databaseError.toException());
    }

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        Log.i("LOL", "onDataChange")
        val list = mutableListOf<Language>()

        for (item in dataSnapshot.children) {
            val language = item.getValue(Language::class.java) as Language
            list.add(language)
        }
        callback.onSuccess(list)
    }
}