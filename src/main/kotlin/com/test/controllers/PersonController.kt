package com.test.controllers

import com.test.data.Person
import com.test.data.PersonRepository
import net.logstash.logback.argument.StructuredArguments.kv
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class PersonController(
    private val repository: PersonRepository
){
    private val log = LoggerFactory.getLogger(PersonController::class.java)


    @PostMapping("/add")
    fun add(@RequestBody request: PersonRequest): Long {
        val person = Person(name = request.name)
        repository.save(person)

        log.info("New Person created, {}", kv("person", person))
        log.debug("New Person created, {}", kv("person", person))
        log.warn("New Person created, {}", kv("person", person))
        log.error("New Person created, {}", kv("person", person))

        return person.id
    }

    @GetMapping("/getAll")
    fun getAll(): MutableIterable<Person> {

        val allPersons = repository.findAll()
        log.info("Retrieving all persons {}", kv("persons", allPersons))
        log.debug("Retrieving all persons {}", kv("persons", allPersons))
        log.warn("Retrieving all persons {}", kv("persons", allPersons))
        log.error("Retrieving all persons {}", kv("persons", allPersons))
        return repository.findAll()
    }
}

class PersonRequest(
    var name: String
)