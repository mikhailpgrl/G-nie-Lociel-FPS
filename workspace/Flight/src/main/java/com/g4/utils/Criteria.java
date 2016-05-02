package com.g4.utils;

public enum Criteria {

	DEP_DATE("departure_date"),
	ARR_DATE("arrival_date"),
	ARR_AIRPORT("arrival_airport"),
	DEP_AIRPORT("departure_airport"),
	COM_NUMBER("commercial_number"),
	ATC("atc_number");

	private String criteria = null;

	private Criteria(String criteria) {
		this.criteria = criteria;
	}

	public String getCriteria() {
		return criteria;
	}

}
