package br.com.avinicius.viewmodelfirebase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.avinicius.viewmodelfirebase.LanguagesRepository.FirebaseDatabaseRepositoryCallback


class LanguagesViewModel : ViewModel() {
    private var mLanguages: MutableLiveData<List<Language>>? = null
    private val mRepository = LanguagesRepository()

    fun getLanguages(): LiveData<List<Language>> {
        if (mLanguages == null) {
            mLanguages = MutableLiveData()
            languages()
        }
        return mLanguages as LiveData<List<Language>>
    }

    override fun onCleared() {
        mRepository.removeListener()
    }

    private fun languages() {
        mRepository.addListener(object : FirebaseDatabaseRepositoryCallback<Language> {
            override fun onSuccess(result: List<Language>) {
                mLanguages?.value = result
            }

            override fun onError(e: Exception) {
                mLanguages?.value = null
            }
        })
    }
}