package com;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.data.Street;
import com.data.Country;
import com.data.City;

@Component
public class Problem {
	
	private ARepository repo;

	@Autowired
	public Problem(ARepository repo) {
		this.repo = repo;
		repo.createInitial();
	}
	
	@Transactional
	public void addStreet() {
		com.data.Country ukFromDb = repo.getOne(1L); //repo.getOne(1L);
		
		City cambridge = ukFromDb.getCities().get(0);
		
		Street cattleStreet = new Street();
		cattleStreet.setName("Cattle Street");
		
		cambridge.getStreets().add(cattleStreet);		
		ukFromDb = repo.save(ukFromDb);
		
		if (ukFromDb.getCities().size() != 1) {
			throw new RuntimeException("There should be 3 zones! Found: " + ukFromDb.getCities().size());
		}
	}
	
	@Transactional
	public void read() {
		com.data.Country ukFromDb = repo.getOne(1L);
		List<City> cities = ukFromDb.getCities();
		System.out.println(cities);
		
		if (ukFromDb.getCities().size() != 1) {
			throw new RuntimeException("There should be 1 zone! Found: " + ukFromDb.getCities().size());
		}
		System.out.println("read: " + repo.getOne(1L));
		
	}
	
	@Transactional
	public void remove() {
		com.data.Country ukFromDb = repo.getOne(1L);
		List<City> cities = ukFromDb.getCities();
		City city = cities.get(0);
		System.out.println("Removed?: " + city.getStreets().removeIf(s -> s.getName().equals("Adeplhi")));
		repo.save(ukFromDb);
		
		if (ukFromDb.getCities().size() != 1) {
			throw new RuntimeException("There should be 3 zones! Found: " + ukFromDb.getCities().size());
		}		
	}
	
}
