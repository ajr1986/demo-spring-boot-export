package com.springboot.export.app.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.export.app.model.entity.App;

@Component(value = "index.pdf")
public class PDFView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<App> apps = (List<App>) model.get("apps");

		PdfPTable table = new PdfPTable(4);
		
		table.setWidths(new float[] {1, 5, 5, 2});
		
		PdfPCell cell = new PdfPCell(new Phrase("#"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("App name"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Domain"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Version"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(10f);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		table.addCell(cell);

		for (App app : apps) {

			table.addCell(app.getId().toString());
			table.addCell(app.getAppName());
			table.addCell(app.getDomain());
			table.addCell(app.getVersion());
		}

		document.add(table);
	}

}
