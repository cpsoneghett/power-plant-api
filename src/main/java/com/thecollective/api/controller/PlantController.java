package com.thecollective.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thecollective.api.domain.dto.FilterDto;
import com.thecollective.api.domain.dto.PowerPlantAmountInfoDto;
import com.thecollective.api.domain.entity.PowerPlant;
import com.thecollective.api.enums.ResultType;
import com.thecollective.api.service.PowerPlantService;

@RestController
@RequestMapping(value = "power-plants")
public class PlantController {

	@Autowired
	private PowerPlantService powerPlantService;

	@GetMapping("/all")
	public Iterable<PowerPlant> findAll() {
		return powerPlantService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<PowerPlant> getInfoById(@PathVariable Long id) {
		return powerPlantService.getInfoById(id);
	}

	@PostMapping("/search")
	public List<PowerPlant> search(final Pageable pageable, @RequestBody FilterDto filter) {
		return powerPlantService.search(pageable, filter);
	}

	@GetMapping("/results/{resultType}")
	public Page<PowerPlant> limit(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@PathVariable ResultType resultType) {
		return powerPlantService.getResults(size, resultType);
	}

	@GetMapping("/percentageData")
	public ResponseEntity<List<PowerPlantAmountInfoDto>> getPowerPlantData() {
		return ResponseEntity.status(HttpStatus.OK).body(powerPlantService.getPowerPlantData());
	}

}
