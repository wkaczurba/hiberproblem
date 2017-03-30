package com.data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Street implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9026775956199581651L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="STREET_ID")
	private long id = 0;	

	private String name;

	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional=false)
//TRY INVERTED ORDER -> Use @ManyToOne but not @OneToMany; (backwards) 
//    @ManyToOne
//	@JoinColumn(name="city")
//	private City city;  

	public Street() {}
	
//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City b) {
//		this.city = b;
//	}

	public Street(String name) {
		super();
		this.name = name;
	}
	
	public Street(Street z) {
		this(z.name /*, z.endTime, z.days, z.months*/);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String s) {
		this.name = s;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id");
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id");
	}
	
	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + "]";
	}
	
}