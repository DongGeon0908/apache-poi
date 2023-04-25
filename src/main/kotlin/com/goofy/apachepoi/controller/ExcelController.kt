package com.goofy.apachepoi.controller

import com.goofy.apachepoi.service.ExcelService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/excels")
class ExcelController(
    private val excelService: ExcelService
) {
    companion object {
        private const val filename = "test.xlsx"
    }

    @GetMapping
    fun download(): ResponseEntity<ByteArray> {
        val excelResource = excelService.download()

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$filename")
            .body(excelResource)
    }
}
