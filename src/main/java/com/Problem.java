package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.data.ZoneTimerEntry;
import com.data.HeatingSettings;
import com.data.ZoneSetting;

@Component
public class Problem {
	
	private HeatingRepository repo;

	@Autowired
	public Problem(HeatingRepository repo) {
		this.repo = repo;
		repo.createInitial();
	}
	
//	@Transactional
//	public void problem() {
//		System.out.println(repo.findAll());		
//		int zone = 0;
//		ZoneTimerEntry z = ZoneTimerEntry.create("1:23" /*, "11:34", "Monday", "December"*/);
//		com.data.HeatingSettings fromDb = repo.findOne(1L); //repo.getOne(1L);
//		
//		System.out.println("Adding: fromDb.getZones().get("+zone+").getAutomaticModeSettings().add(z);");
//		System.out.println("  where z: " + z);
//		
//		fromDb.getZones().get(zone).getAutomaticModeSettings().add(z);
//		repo.save(fromDb);
//		
//		fromDb = repo.findOne(1L); //repo.getOne(1L);
//		System.out.println("fromDb:" + fromDb);		
//		
//		if (fromDb.getZones().size() != 3) {
//			throw new RuntimeException("There should be 3 zones! Found: " + fromDb.getZones().size());
//		}
//		
//	}
	
	@Transactional
	public void problem() {
		System.out.println(repo.findAll());		
		int zone = 0;
		ZoneTimerEntry z = ZoneTimerEntry.create("1:23");
		com.data.HeatingSettings fromDb = repo.getOne(1L); //repo.getOne(1L);
		
		System.out.println("Adding: fromDb.getZones().get("+zone+").getAutomaticModeSettings().add(z);");
		System.out.println("  where z: " + z);
		
		ZoneSetting zs = fromDb.getZones().get(zone); 
		z.setZoneSetting(zs);
		zs.getAutomaticModeSettings().add(z);
		fromDb = repo.save(fromDb);
		
		fromDb = repo.getOne(1L); //repo.getOne(1L);
		System.out.println("fromDb:" + fromDb);		
		
		if (fromDb.getZones().size() != 3) {
			throw new RuntimeException("There should be 3 zones! Found: " + fromDb.getZones().size());
		}
	}
	
	@Transactional
	public void read() {
		
		// Delete:
		//HeatingSettings fromDb = repo.findOne(1L);
		com.data.HeatingSettings fromDb = repo.getOne(1L);
		
		List<ZoneSetting> zones = fromDb.getZones();
		
		//ZoneSetting zs = fromDb.getZones().get(0);
//		System.out.println(fromDb);
//		
//		System.out.println("Deleting...");
//		zs.getAutomaticModeSettings().clear();
//		repo.save(fromDb);
//		
//		// Retrieve
//		fromDb = repo.getOne(1L); //repo.getOne(1L);
//		System.out.println("After deleting:");
//		System.out.println("fromDb:" + fromDb);		
		
		// Print:
//		if (fromDb.getZones().size() != 3) {
//			throw new RuntimeException("There should be 3 zones! Found: " + fromDb.getZones().size());
//		}
		
	}	
	
}
