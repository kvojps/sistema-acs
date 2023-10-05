package br.upe.acs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Activity;
import br.upe.acs.model.enums.AxleEnum;
import org.springframework.data.jpa.repository.Query;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT activitie FROM activities activitie " +
            "WHERE :axle IS NULL OR activitie.axle = :axle")
    List<Activity> findWithFilters(AxleEnum axle);
}
