package com.test.data

import org.springframework.data.repository.CrudRepository
import java.awt.print.Book


interface PersonRepository : CrudRepository<Person, Long> {
    fun findByName(name: String?): List<Person?>?
}