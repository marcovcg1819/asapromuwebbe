package org.asapromu.repositories;

import java.util.Optional;

import org.asapromu.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByUsername(String usr);
	Optional<Users> findByTokenuser(String token);
}
