package com.thecollective.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.thecollective.api.domain.dto.PowerPlantAmountInfoDto;
import com.thecollective.api.domain.entity.PowerPlant;

@Repository
public interface PowerPlantRepository
		extends PagingAndSortingRepository<PowerPlant, Long>, PowerPlantRepositoryQueries {

	@Query(value = "select new com.thecollective.api.domain.dto.PowerPlantAmountInfoDto(p.state, count(p.state)) from PowerPlant p group by p.state")
	List<PowerPlantAmountInfoDto> getPowerPlantAmountInfo();
}
