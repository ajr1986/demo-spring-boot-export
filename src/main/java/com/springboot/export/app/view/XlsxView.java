package com.springboot.export.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.springboot.export.app.model.entity.App;

@Component(value = "index.xlsx")
public class XlsxView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<App> apps = (List<App>) model.get("apps");

		Sheet sheet = workbook.createSheet("Apps");

		int rowIndex = 0;
		Row row = sheet.createRow(rowIndex);

		sheet.setColumnWidth(0, 1500);
		sheet.setColumnWidth(1, 8000);
		sheet.setColumnWidth(2, 8000);
		sheet.setColumnWidth(3, 2500);

		CellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);

		Cell cell = row.createCell(0);
		cell.setCellValue("#");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("App name");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("Domain");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("Version");
		cell.setCellStyle(style);

		for (App app : apps) {

			rowIndex++;
			row = sheet.createRow(rowIndex);

			cell = row.createCell(0);
			cell.setCellValue(app.getId());

			cell = row.createCell(1);
			cell.setCellValue(app.getAppName());

			cell = row.createCell(2);
			cell.setCellValue(app.getDomain());

			cell = row.createCell(3);
			cell.setCellValue(app.getVersion());
		}
	}

}
