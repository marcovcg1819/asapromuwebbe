package org.asapromu.repositories;

import java.util.List;

import org.asapromu.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Query(value = "SELECT p FROM Project p WHERE active = :status ORDER BY id DESC LIMIT :top")
	List<Project> findByActiveAndTop(@Param("status") Integer status, @Param("top") Integer top);
	
	List<Project> findByActive(Integer status);
}
