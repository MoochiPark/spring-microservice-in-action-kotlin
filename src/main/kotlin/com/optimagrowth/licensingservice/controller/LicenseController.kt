package com.optimagrowth.licensingservice.controller

import com.optimagrowth.licensingservice.model.License
import com.optimagrowth.licensingservice.service.LicenseService
import java.net.URI
import java.util.Locale
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/organization/{organizationId}/license")
class LicenseController(
    private val licenseService: LicenseService,
) {
    @GetMapping("/{licenseId}")
    fun getLicense(
        @PathVariable("organizationId") organizationId: String,
        @PathVariable("licenseId") licenseId: String,
    ): ResponseEntity<License> {
        val license = licenseService.getLicense(licenseId, organizationId)
        license.add(
            linkTo<LicenseController> {
                getLicense(organizationId, licenseId)
            }.withSelfRel(),
            linkTo<LicenseController> {
                createLicense(organizationId, license, null)
            }.withRel("createLicense")
        )
        return ResponseEntity.ok(license)
    }

    @PostMapping
    fun createLicense(
        @PathVariable("organizationId") organizationId: String,
        @RequestBody license: License,
        @RequestHeader(value = "Accept-Language", required = false, defaultValue = "ko") locale: Locale?,
    ): ResponseEntity<String> =
        ResponseEntity.created(URI.create(""))
            .body(licenseService.createLicense(license, organizationId, locale!!))
}