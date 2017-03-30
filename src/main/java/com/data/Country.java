package com.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Country implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 253595098289219101L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	private long id = 0;
	
	@OneToMany(cascade = CascadeType.ALL, /*fetch=FetchType.EAGER,*/ orphanRemoval=true)
	@JoinColumn(name="COUNTRY_ID")
	private List<City> cities;
	
	public Country() { 
	}
	
	/**
	 * @return the zones
	 */
	public List<City> getCities() {
		return cities;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Country id=\""+ id +"\":\n"); 
		if (cities == null) {
			sb.append("cities == null\n");
		} else {
			for (int i=0; i<cities.size(); i++) {
				sb.append((i + ": " + cities.get(i).toString()) .replaceAll("(?m)^", "    "));
				if (i < cities.size())
					sb.append("\n");
			}
			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
		return sb.toString();
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

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id");
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id");
	}
}
