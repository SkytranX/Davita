package com.example.davita

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataObject(
    val title: String? = null,
    val subTitle: String? = null
) : Parcelable
