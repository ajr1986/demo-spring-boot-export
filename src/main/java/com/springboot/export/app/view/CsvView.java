package com.springboot.export.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.springboot.export.app.model.entity.App;

@Component(value = "index.csv")
public class CsvView extends AbstractView {

	public CsvView() {

		setContentType("text/csv");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"index.csv\"");
		response.setContentType(getContentType());

		List<App> apps = (List<App>) model.get("apps");

		CsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "id", "appName", "domain", "version" };

		beanWriter.writeHeader(header);

		for (App app : apps) {

			beanWriter.write(app, header);
		}

		beanWriter.close();
	}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}

}
