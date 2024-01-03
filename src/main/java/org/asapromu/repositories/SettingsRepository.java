package org.asapromu.repositories;

import java.util.Optional;

import org.asapromu.entities.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long>{

	Optional<Settings> findByNamesetting(String name);
}
