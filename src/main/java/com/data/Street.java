package com.data;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ZoneTimerEntry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9026775956199581651L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="ZONE_TIMER_ENTRY_ID")
	private long id = 0;	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional=false)
	private ZoneSetting zoneSetting;  
	
	/**
	 * @return the zoneSetting
	 */
	public ZoneSetting getZoneSetting() {
		return zoneSetting;
	}


	/**
	 * @param zoneSetting the zoneSetting to set
	 */
	public void setZoneSetting(ZoneSetting zoneSetting) {
		this.zoneSetting = zoneSetting;
	}

/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ZoneTimerEntry [id=" + id + ", startingTime=" + startingTime + "]"; /*, endTime=" + endTime + ", days=" + days
				+ ", months=" + months + "]";*/
	}


	//	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//	private LocalTime startingTime;
	private String startingTime;

	/*
//	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//	private LocalTime endTime;
	private String endTime;
	
//	@ElementCollection(targetClass=DayOfWeek.class, fetch=FetchType.EAGER)
//	@JoinTable(name="tblDayOfWeek", joinColumns = @JoinColumn(name="zoneTimerEntry_id"))
//	@Column(name="days", nullable=false)
//	@Enumerated(EnumType.STRING)
//	private Set<DayOfWeek> days = new HashSet<>();
	private String days;	
	
//	@ElementCollection(targetClass=Month.class, fetch=FetchType.EAGER)
//	@JoinTable(name="tblMonth", joinColumns = @JoinColumn(name="zoneTimerEntry_id"))
//	@Column(name="months", nullable=false)
//	@Enumerated(EnumType.STRING)
//	private Set<Month> months = new HashSet<>();
	private String months;
*/
	
	private ZoneTimerEntry() {}
	

	public static ZoneTimerEntry createRandom() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		LocalTime startingTime = LocalTime.of(rand.nextInt(24), rand.nextInt(60));
/*		LocalTime endTime = LocalTime.of(rand.nextInt(24), rand.nextInt(60));
		
		Set<DayOfWeek> days = new HashSet<>();
		Arrays.asList(DayOfWeek.values()).stream().filter(x -> (Math.random() < 1./7)).forEach(d -> days.add(d));
		
		Set<Month> months = new HashSet<>();
		Arrays.asList(Month.values()).stream().filter(x->(Math.random() < 1./12)).forEach(m -> months.add(m));*/
		
		return new ZoneTimerEntry(startingTime.toString() /*, endTime.toString(), days.toString(), months.toString()*/);
	}	
	
	// Convenience method.
	/**
	 * 
	 * @param startHour - e.g. "17:03"
	 * @param endHour - e.g. "22:03"
	 * @param days - "Monday, Tuesday, Friday"
	 * @param months - "JANUARY, February, March"
	 */
	public static ZoneTimerEntry create(String startHour /*, String endHour, String days, String months*/) {
		return new ZoneTimerEntry(startHour /*, endHour, days, months*/);
	}

	public ZoneTimerEntry(String startingTime /*, String endTime, String days, String months*/) {
		super();
		this.startingTime = startingTime;
/*		this.endTime = endTime;
		this.days = days;
		this.months = months;*/
	}
	
	// TODO: Remove copying constructor
	public ZoneTimerEntry(ZoneTimerEntry z) {
		this(z.startingTime /*, z.endTime, z.days, z.months*/);
	}

	/**
	 * @return the startingTime
	 */
	public String getStartingTime() {
		return startingTime;
	}

	/**
	 * @param startingTime the startingTime to set
	 */
	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

//	/**
//	 * @return the endTime
//	 */
//	public String getEndTime() {
//		return endTime;
//	}
//
//	/**
//	 * @param endTime the endTime to set
//	 */
//	public void setEndTime(String endTime) {
//		this.endTime = endTime;
//	}
//
//	/**
//	 * @return the days
//	 */
//	public String getDays() {
//		return days;
//	}
//
//	/**
//	 * @param days the days to set
//	 */
//	public void setDays(String days) {
//		this.days = days;
//	}
//
//	/**
//	 * @return the months
//	 */
//	public String getMonths() {
//		return months;
//	}
//
//	/**
//	 * @param months the months to set
//	 */
//	public void setMonths(String months) {
//		this.months = months;
//	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id");
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id");
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}