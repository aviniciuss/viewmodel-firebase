package br.com.avinicius.viewmodelfirebase

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Language(var name: String = "") : Serializable