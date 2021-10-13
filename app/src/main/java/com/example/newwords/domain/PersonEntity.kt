package com.example.newwords.domain

import java.io.Serializable

data class PersonEntity(
    val id: String,
    val name: String,
    val age: Int,
    val power: Int
) : Serializable
