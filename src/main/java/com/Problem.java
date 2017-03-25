package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.data.ZoneTimerEntry;
import com.data.HeatingSettings;

@Component
public class Problem {
	
	private HeatingRepository repo;

	@Autowired
	public Problem(HeatingRepository repo) {
		this.repo = repo;
		
		repo.createInitial();
		problem();
	}
	
	@Transactional
	public void problem() {
		System.out.println(repo.findAll());		
		int zone = 0;
		ZoneTimerEntry z = ZoneTimerEntry.create("1:23", "11:34", "Monday", "December");
		com.data.HeatingSettings fromDb = repo.findOne(1L); //repo.getOne(1L);
		
		System.out.println("Adding: fromDb.getZones().get("+zone+").getAutomaticModeSettings().add(z);");
		System.out.println("  where z: " + z);
		
		fromDb.getZones().get(zone).getAutomaticModeSettings().add(z);
		//repo.save(fromDb);
		
		fromDb = repo.findOne(1L); //repo.getOne(1L);
		System.out.println("fromDb:" + fromDb);		
		
		if (fromDb.getZones().size() != 3) {
			throw new RuntimeException("There should be 3 zones! Found: " + fromDb.getZones().size());
		}
		
	}
}
