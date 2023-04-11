package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context){

//  variável que representa o nosso banco de dados
    private val db = TripDb.getDataBase(context)

//   responsavel por encontrar um usuario no banco
    fun save(user: User):Long{
        return db.userDao().save(user)
    }

//    responsavel por encontrar um usuario por e-mail
    fun findUserByEmail(email: String): User{
        return db.userDao().findUserByEmail(email)
    }

//    reponsavel pela autenticaçao do usuario
    fun authenticate(email: String, password: String): User {
        return db.userDao().authenticate(email,password)
    }

}