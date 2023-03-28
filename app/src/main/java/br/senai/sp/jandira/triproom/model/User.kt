package br.senai.sp.jandira.triproom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0, //pode fazer anotaçoes abaixo ou acima
    @ColumnInfo(name = "user_name") var userName: String = "",
    var email: String = "",
    var password: String = "",
    var phone: String = "",
    @ColumnInfo(name = "is_over_18") var isOver18: Boolean = false
)
