package com.springboot.export.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.export.app.model.dao.AppDAO;
import com.springboot.export.app.model.entity.App;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppDAO appDAO;

	@Override
	public List<App> getApps() {

		return (List<App>) appDAO.findAll();
	}

}
