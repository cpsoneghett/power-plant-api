package com.thecollective.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.thecollective.api.domain.dto.FilterDto;
import com.thecollective.api.domain.dto.PowerPlantAmountInfoDto;
import com.thecollective.api.domain.entity.PowerPlant;
import com.thecollective.api.domain.repository.PowerPlantRepository;
import com.thecollective.api.enums.ResultType;

@Service
public class PowerPlantService {

	@Autowired
	private PowerPlantRepository powerPlantRepository;

	public Iterable<PowerPlant> findAll() {

		return powerPlantRepository.findAll();
	}

	public Optional<PowerPlant> getInfoById(Long id) {
		return powerPlantRepository.findById(id);
	}

	public List<PowerPlant> search(Pageable pageable, @RequestBody FilterDto filter) {

		if (isFilterValid(filter)) {
			return powerPlantRepository.findByCriteria(pageable, filter);
		} else {
			return powerPlantRepository.findAll(pageable).getContent();
		}

	}

	public Page<PowerPlant> getResults(int size, ResultType resultType) {

		Sort.Direction direction = ResultType.BOTTOM.equals(resultType) ? Sort.Direction.DESC : Sort.Direction.ASC;

		var pageRequest = PageRequest.of(0, size, direction, "id");

		return powerPlantRepository.findAll(pageRequest);
	}

	public List<PowerPlantAmountInfoDto> getPowerPlantData() {
		Long total = powerPlantRepository.count();
		List<PowerPlantAmountInfoDto> result = powerPlantRepository.getPowerPlantAmountInfo();

		result.forEach(info -> info.setPercentage(info.getCount() / (double) total * 100));

		return result;
	}

	private boolean isFilterValid(FilterDto filter) {
		return filter.getState() != null && !filter.getState().isBlank();
	}

}
