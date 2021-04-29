package com.stealhao.springkotlinweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinWebApplication

fun main(args: Array<String>) {
    runApplication<SpringKotlinWebApplication>(*args)
}
