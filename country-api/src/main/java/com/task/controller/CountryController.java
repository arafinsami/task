package com.task.controller;

import static com.task.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.CountryDto;
import com.task.entity.Country;
import com.task.service.CountryService;
import com.task.utils.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "country")
@Api(tags = "country info")
@RequiredArgsConstructor
public class CountryController {

	private final CountryService countryService;

	@GetMapping("/{countryName}")
	@PreAuthorize("hasAuthority('READ_COUNTRY_DETAILS')")
	@ApiOperation(value = "Get Advertisement Prequalification by id", response = CountryDto.class)
	public ResponseEntity<JSONObject> findById(@PathVariable String countryName) {

		Country country = countryService.findByCountryName(countryName).orElseThrow(ResourceNotFoundException::new);
		return ok(success(CountryDto.from(country)).getJson());
	}

}
