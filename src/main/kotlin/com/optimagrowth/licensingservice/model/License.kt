package com.optimagrowth.licensingservice.model

import org.springframework.hateoas.RepresentationModel

data class License(
    val id: Int,
    val licenseId: String,
    val description: String,
    var organizationId: String,
    val productName: String,
    val licenseType: String,
) : RepresentationModel<License>()