package com.task.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.task.entity.Country;
import com.task.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

	private final CountryRepository countryRepository;

	public Optional<Country> findByCountryName(String countryName) {
		Optional<Country> country = countryRepository.findByCountryName(countryName);
		return country;
	}

}
