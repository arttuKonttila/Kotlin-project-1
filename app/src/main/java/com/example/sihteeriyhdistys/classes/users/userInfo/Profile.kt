package com.example.sihteeriyhdistys.classes.users.userInfo

data class Profile(
    val address: com.example.sihteeriyhdistys.classes.address.Address,
    val email: String,
    val firstName: String,
    val lastName: String,
    val phone: String
)