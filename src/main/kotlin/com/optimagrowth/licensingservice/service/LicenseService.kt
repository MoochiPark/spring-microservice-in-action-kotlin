package com.optimagrowth.licensingservice.service

import com.optimagrowth.licensingservice.model.License
import java.util.Locale
import kotlin.random.Random
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service

@Service
class LicenseService(
    private val messageSource: MessageSource,
) {
    fun getLicense(licenseId: String, organizationId: String): License =
        License(
            id = Random.nextInt(1_000),
            licenseId = licenseId,
            organizationId = organizationId,
            description = "Software product",
            productName = "O-stock",
            licenseType = "full"
        )

    fun createLicense(license: License?, organizationId: String, locale: Locale): String {
        license?.let {
            it.organizationId = organizationId
            return messageSource.getMessage("license.message.create", arrayOf(license), locale)
        }
        return ""
    }
}