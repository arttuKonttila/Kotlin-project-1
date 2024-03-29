package com.example.sihteeriyhdistys

import com.example.sihteeriyhdistys.classes.users.Users
import com.example.sihteeriyhdistys.classes.users.UsersItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class ApiController {

    //fetches basic user data
    fun fetchUsersJson():Users {
        println("Attempting to fetch Json")

        var tempUser : Users = Users()

        val completeUrl = "####### - blocked for security reasons"

        val request = Request.Builder().url(completeUrl).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body : String = response.body.toString()
                val gSon = GsonBuilder().create()
                tempUser = gSon.fromJson(body, Users::class.java)
            }

        })

        return tempUser

    }
}

