package com.taxi.management.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taxi.management.data.TripsData;

@Repository
public interface TripsDataRepository extends JpaRepository<TripsData, Integer> {

	public List<TripsData> findByCustomerId(int customerId);

	public List<TripsData> findByCabId(int cabId);

	public List<TripsData> findByTripDate(Timestamp tripDate);
	
	public TripsData findByCustomerIdAndTripStatus(int customerId,String tripStatus);
	
	@Modifying
	@Query("UPDATE trips_data t SET t.tripStatus = :tripstatus WHERE t.tripId = :tripid")
    public int updateTripStatus(@Param("tripid") int tripid, @Param("tripstatus") String tripStatus);
	
	@Modifying
	@Query("UPDATE trips_data t SET t.tripKms = :tripkms,t.totalFare = :totalfare,t.tripStatus = :tripstatus WHERE t.tripId = :tripid")
    public int updateCompletedTripInfo(@Param("tripid") int tripid,@Param("tripkms") int tripkms,@Param("totalfare") int totalfare, @Param("tripstatus") String tripStatus);
	
}
