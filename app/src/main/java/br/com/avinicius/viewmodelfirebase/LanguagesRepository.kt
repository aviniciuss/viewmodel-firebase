package br.com.avinicius.viewmodelfirebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LanguagesRepository {
    private lateinit var mListener: BaseValueEventListener

    private val mDatabaseReference: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().getReference("languages")
    }

    fun addListener(callback: FirebaseDatabaseRepositoryCallback<Language>) {
        mListener = BaseValueEventListener(callback)
        mDatabaseReference.addValueEventListener(mListener)
    }

    fun removeListener() {
        mDatabaseReference.removeEventListener(mListener)
    }

    interface FirebaseDatabaseRepositoryCallback<T> {
        fun onSuccess(result: List<T>)

        fun onError(e: Exception)
    }
}