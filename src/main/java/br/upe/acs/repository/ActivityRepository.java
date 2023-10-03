package br.upe.acs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Activity;
import br.upe.acs.model.enums.AxleEnum;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	List<Activity> findByAxle(AxleEnum axle);
}
