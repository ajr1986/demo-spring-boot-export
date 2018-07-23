package com.springboot.export.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.export.app.model.entity.App;

public interface AppDAO extends CrudRepository<App, Long> {

}
