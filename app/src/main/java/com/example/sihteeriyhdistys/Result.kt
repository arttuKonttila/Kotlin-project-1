package com.example.sihteeriyhdistys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sihteeriyhdistys.classes.users.Users
import com.example.sihteeriyhdistys.classes.users.UsersItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_logged_in.*
import java.io.File


class Result() : AppCompatActivity() {

    private val controller = ApiController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        val actionBar = supportActionBar
        actionBar!!.title = "Haku"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        //fetches all required user data
        val currentUsersData : UsersItem = findCurrentUsersData(controller.fetchUsersJson())
        currentUserName.text = currentUsersData.firstName + " " + currentUsersData.lastName

        //saveSearch(currentUserName.text.toString())

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //saves the current search
    /*private fun saveSearch(userName : String) {
        val fileName = "searchResult.json"
        var fileCheck = File(fileName)
        var fileExists = fileCheck.exists()

        if(fileExists) {
            fileCheck.delete()
            var searchResult = SearchResult(userName)
            var gson = Gson()
            var jsonString:String = gson.toJson(searchResult)
            val file = File("searchResult.json")
            file.writeText(jsonString)
        }
        else {
            var searchResult = SearchResult(userName)
            var gson = Gson()
            var jsonString:String = gson.toJson(searchResult)
            val file = File("searchResult.json")
            file.writeText(jsonString)
        }
    }*/

    //finds current users data
    private fun findCurrentUsersData(usersData : Users) : UsersItem {
        var userData = UsersItem("", "", "")
        val currentUsersName = intent.getStringExtra("usersName")

        for(index:Int in usersData.indices) {
            val tempName = usersData[index].firstName + " " + usersData[index].lastName
            if(currentUsersName == tempName) {
                userData = usersData[index]
            }

        }
        return userData
    }
}

