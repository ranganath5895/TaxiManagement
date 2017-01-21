package com.taxi.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taxi.management.data.CabData;

@Repository
public interface CabDataRepository extends JpaRepository<CabData, Integer>{

	public List<CabData> findByAvailabilityStatus(boolean availabilityStatus);
	public List<CabData> findByCabDriverName(String cabDriverName);
	public CabData findByCabRegnNumber(String cabRegnNumber);
	
	@Modifying
	@Query("update cab_data c set c.availabilityStatus = :availabilitystatus where c.cabId = :cabid")
    public int updateAvailabilityStatus(@Param("cabid") int cabid, @Param("availabilitystatus") boolean availabilitystatus);
	
}
