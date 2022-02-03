package com.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public Optional<Country> findByCountryName(String countryName);
}
