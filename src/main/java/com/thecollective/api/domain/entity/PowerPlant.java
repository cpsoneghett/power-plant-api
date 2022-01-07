package com.thecollective.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plant")
public class PowerPlant {

	@Id
	@Column(name = "SEQGEN19")
	private Long id;

	@Column(name = "YEAR")
	private Integer year;

	@Column(name = "PSTATABB")
	private String state;

	@Column(name = "PNAME")
	private String name;

	@Column(name = "GENID")
	private String generatorId;

	@Column(name = "GENSTAT")
	private String generatorStatus;

	@Column(name = "GENNTAN")
	private Double netGeneration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeneratorId() {
		return generatorId;
	}

	public void setGeneratorId(String generatorId) {
		this.generatorId = generatorId;
	}

	public String getGeneratorStatus() {
		return generatorStatus;
	}

	public void setGeneratorStatus(String generatorStatus) {
		this.generatorStatus = generatorStatus;
	}

	public Double getNetGeneration() {
		return netGeneration;
	}

	public void setNetGeneration(Double netGeneration) {
		this.netGeneration = netGeneration;
	}

	@Override
	public String toString() {
		return "Plant [id=" + id + ", year=" + year + ", state=" + state + ", name=" + name + ", generatorId="
				+ generatorId + ", generatorStatus=" + generatorStatus + ", netGeneration=" + netGeneration + "]";
	}

}
