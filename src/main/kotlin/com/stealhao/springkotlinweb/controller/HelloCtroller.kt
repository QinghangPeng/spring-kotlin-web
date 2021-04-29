package com.stealhao.springkotlinweb.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloCtroller {

    @GetMapping("hello")
    fun hello(): Greeting {
        return Greeting("hello","world")
    }

    data class Greeting(
        val name: String,
        val greeting: String
    )
}