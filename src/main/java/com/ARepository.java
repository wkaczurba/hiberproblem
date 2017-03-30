package com;

import com.data.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

//READ THIS ONE:
//	- http://stackoverflow.com/questions/14130041/jpa-persist-entities-with-one-to-many-relation

public interface ARepository extends JpaRepository<Country, Long> {
	
	/**
	 * Creates initial heating 
	 * @return
	 */
	default Country createInitial() {
		Country uk = new Country();
		
		List<City> cities = new ArrayList<>();
		
		City aberdeen = new City();
//		aberdeen.setCountry(uk);
		
		Set<Street> aberdeenStreets = new HashSet<Street>();
		Street adelphi = new Street("Adeplhi");
//		adelphi.setCity(aberdeen);
		aberdeenStreets.add(adelphi);
		aberdeen.setStreets(aberdeenStreets);
		
/*		City bristol = new City();
//		bristol.setCountry(uk);
		Set<Street> bristolStreets = new HashSet<Street>();
		Street broadmead = new Street("Broadmead");
//		broadmead.setCity(bristol);
		bristolStreets.add(broadmead);
		bristol.setStreets(bristolStreets);
		
		City cambridge = new City();
//		cambridge.setCountry(uk);
		Set<Street> cambridgeStreets = new HashSet<Street>();
		Street castleStreet = new Street("Castle Street");
//		castleStreet.setCity(cambridge);
		cambridgeStreets.add(castleStreet);
		cambridge.setStreets(cambridgeStreets); */
		
		cities.add(aberdeen);
		/*cities.add(bristol);
		cities.add(cambridge);*/

		uk.setCities(cities);
		uk = this.save(uk);
		
		System.out.println("uk: " + uk);
		
		/*List<Country> countries = this.findAll();
		System.out.println("countries.size()=="+countries.size()+": " + countries);
		System.out.println("----");*/
		return uk;
//		return null;
	}	
}
