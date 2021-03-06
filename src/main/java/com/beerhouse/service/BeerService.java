package com.beerhouse.service;

import java.util.List;
import java.util.Map;

import com.beerhouse.model.Beer;

public interface BeerService {
	
	List<Beer> findAll();
	Beer findById(Integer id);
	Beer save(Beer beer);
	Beer update(Integer id, Beer beer);
	void delete(Integer id);
	Beer updatePartial(Integer id, Map<String, String> beerMap);

}
