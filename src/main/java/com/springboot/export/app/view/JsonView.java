package com.springboot.export.app.view;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component(value = "index.json")
public class JsonView extends MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		model.remove("title");

		return super.filterModel(model);
	}

}
