package com.thecollective.api.domain.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.thecollective.api.domain.dto.FilterDto;
import com.thecollective.api.domain.entity.PowerPlant;

public interface PowerPlantRepositoryQueries {

	List<PowerPlant> findByCriteria(Pageable pageable, FilterDto filter);
}
