package org.asapromu.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.asapromu.entities.Payhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayhistoryRepository extends JpaRepository<Payhistory, Long>{
	@Query(value = "SELECT d.donationname, p.amount, p.datepay, '' as datea FROM asapromu.payhistory p INNER JOIN asapromu.donation d ON d.id=p.id_donation WHERE datepay BETWEEN :start AND :end", nativeQuery = true)
	List<Object[]> findByTwoDates(@Param("start") Timestamp start, @Param("end") Timestamp end);
}
