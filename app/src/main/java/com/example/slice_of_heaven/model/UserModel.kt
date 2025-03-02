package com.example.slice_of_heaven.model

import android.os.Parcel
import android.os.Parcelable

    data class UserModel(
        var userId: String = "",
        var Username: String = "",
        var contact: String = "",
        var email: String = "",
    ): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(userId)
            parcel.writeString(Username)
            parcel.writeString(contact)
            parcel.writeString(email)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<UserModel> {
            override fun createFromParcel(parcel: Parcel): UserModel {
                return UserModel(parcel)
            }

            override fun newArray(size: Int): Array<UserModel?> {
                return arrayOfNulls(size)
            }
        }
    }
