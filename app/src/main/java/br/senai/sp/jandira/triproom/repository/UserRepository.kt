package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context){

//  variável que representa o nosso banco de dados
    private val db = TripDb.getDataBase(context)

    fun save(user: User):Long{
        return db.userDao().save(user)
    }

}