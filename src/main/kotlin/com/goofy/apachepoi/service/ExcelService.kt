package com.goofy.apachepoi.service

import com.goofy.apachepoi.util.PoiUtil.Companion.cell
import com.goofy.apachepoi.util.PoiUtil.Companion.toByteArray
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service

@Service
class ExcelService {
    companion object {
        private val EXCEL_HEADERS = listOf("header1", "header2", "header3", "header4")
    }

    fun download(): ByteArray {
        val workbook = XSSFWorkbook()
        val sheet = workbook.createSheet()

        sheet.createRow(0).apply {
            EXCEL_HEADERS.forEachIndexed { index, header ->
                cell(index, header)
            }
        }

        (0..100).forEachIndexed { index, row ->
            sheet.createRow(index + 1).apply {
                cell(0, "body / 0 / $row")
                cell(1, "body / 1 / $row")
                cell(2, "body / 2 / $row")
                cell(3, "body / 3 / $row")
            }
        }

        return workbook.toByteArray()
    }
}
