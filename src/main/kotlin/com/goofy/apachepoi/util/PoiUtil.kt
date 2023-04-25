package com.goofy.apachepoi.util

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.ByteArrayOutputStream

class PoiUtil {
    companion object {
        fun XSSFRow.cell(index: Int, value: String): XSSFCell {
            return this.createCell(index).apply {
                this.setCellValue(value)
            }
        }

        fun XSSFWorkbook.toByteArray(): ByteArray {
            return ByteArrayOutputStream().use { stream ->
                this.use { book -> book.write(stream) }
                stream.toByteArray()
            }
        }
    }
}
