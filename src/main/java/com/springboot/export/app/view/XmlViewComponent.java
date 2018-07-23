package com.springboot.export.app.view;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.springboot.export.app.model.entity.App;

@XmlRootElement(name = "apps")
public class XmlViewComponent {

	@XmlElement(name = "app" )
	private List<App> apps;

	public XmlViewComponent() {

	}

	public XmlViewComponent(List<App> apps) {
		this.apps = apps;
	}

	public List<App> getApps() {
		return apps;
	}

}
