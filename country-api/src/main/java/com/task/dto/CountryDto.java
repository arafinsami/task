package com.task.dto;

import java.util.List;

import com.task.entity.Country;
import com.task.entity.Currency;

import lombok.Data;

@Data
public class CountryDto {

	private String countryName;

	private String countryFullName;

	private int population;

	private List<Currency> currencies;

	public static CountryDto from(Country country) {
		CountryDto dto = new CountryDto();
		dto.setCountryName(country.getCountryName());
		dto.setCountryFullName(country.getCountryFullName());
		dto.setPopulation(country.getPopulation());
		dto.setCurrencies(country.getCurrencies());
		return dto;
	}
}
