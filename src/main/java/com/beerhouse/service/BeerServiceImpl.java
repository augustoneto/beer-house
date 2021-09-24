package com.beerhouse.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.exception.BeerNotFoundException;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;

@Service
public class BeerServiceImpl implements BeerService {
	
	@Autowired
	private BeerRepository beerRepository;

	@Override
	public List<Beer> findAll() {
		return beerRepository.findAll();
	}

	@Override
	public Beer findById(Integer id) {
		return beerRepository.findById(id)
				.orElseThrow(() -> new BeerNotFoundException(id));
	}

	@Override
	public Beer save(Beer beer) {
		return beerRepository.save(beer);
	}

	@Override
	public Beer update(Integer id, Beer newBeer) {
		return beerRepository.findById(id) 
				.map(beer -> {
					beer.setName(newBeer.getName());
					beer.setIngredients(newBeer.getIngredients());
					beer.setAlcoholContent(newBeer.getAlcoholContent());
					beer.setCategory(newBeer.getCategory());
					beer.setPrice(newBeer.getPrice());
					return save(beer);
				}).orElseThrow(() -> new BeerNotFoundException(id));
	}
	
	@Override
	public Beer updatePartial(Integer id, Map<String, String> beerMap) {
		Beer beer = findById(id);
		
		beerMap.forEach((key, value) -> setFieldsUpdatePartial(key, value, beer));
		
		return save(beer);
	}
	
	private void setFieldsUpdatePartial(String key, String value, Beer beer) {
		if (key.equals("name")) {
        	beer.setName(value);
        } else if (key.equals("ingredients")) {
        	beer.setIngredients(value);
        } else if (key.equals("alcohol_content")) {
        	beer.setAlcoholContent(value);
        } else if (key.equals("price")) {
        	beer.setPrice(new BigDecimal(value));
        } else if (key.equals("category")) {
        	beer.setCategory(value);
        }
	}

	@Override
	public void delete(Integer id) {
		Beer beer = findById(id);
		
		beerRepository.delete(beer);
	}

}
