package com.springboot.export.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.springboot.export.app.model.entity.App;

@Component(value = "index.xml")
public class XmlView extends MarshallingView {
	
	@Autowired
	public XmlView(Jaxb2Marshaller marshaller) {
		super(marshaller);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<App> apps = (List<App>) model.get("apps");
		
		model.put("apps", new XmlViewComponent(apps));
		
		super.renderMergedOutputModel(model, request, response);
	}

	
}
