package com.optimagrowth.licensingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class LicensingServiceApplication

fun main(args: Array<String>) {
    runApplication<LicensingServiceApplication>(*args)
}
