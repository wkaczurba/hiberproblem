package com.data;

import java.util.HashSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class City implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 985658386797337594L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)		
	@Column(name="CITY_ID")
	private long id = 0;
	
	@OneToMany(cascade = CascadeType.ALL, /*fetch=FetchType.EAGER,*/ orphanRemoval=true)	
	@JoinColumn(name="CITY_ID")	
	private Set<Street> streets;
		
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional=false)
//	@JoinColumn(name = "COUNTRY_ID", nullable = false)	
//	Country country;  // parent
	
	public City() {
	}
	
//	public Country getCountry() {
//		return country;
//	}	
//	public void setCountry(Country a) {
//		this.country = a;
//	}
		
	public Set<Street> getStreets() {
		return streets;
	}

	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("City id=" + id + ", cs=\n");
		streets.forEach(x -> {
			sb.append(x.toString().replaceAll("(?m)^", "\t"));
			sb.append("\n");
		});
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id");
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id");

	}

	
}
