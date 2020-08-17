package com.example.sihteeriyhdistys.classes.communityData

import com.example.sihteeriyhdistys.classes.address.Address

data class CommunityData(
    val abbreviation: String,
    val address: Address,
    val description: String,
    val domain: String,
    val email: String,
    val facebook: String,
    val google: String,
    val id: String,
    val name: String,
    val phone: String,
    val twitter: String
)