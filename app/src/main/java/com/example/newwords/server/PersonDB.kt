package com.example.newwords.server

import com.example.newwords.domain.PersonEntity

class PersonDB {
    fun getAllPerson() : ArrayList<PersonEntity> {
        val personData: ArrayList<PersonEntity> = arrayListOf()
        personData.add(PersonEntity("1", "Max", 12, 32))
        personData.add(PersonEntity("2", "Jak", 22, 43))
        personData.add(PersonEntity("3", "Bob", 14, 39))
        return personData
    }
}



