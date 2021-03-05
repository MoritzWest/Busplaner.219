package de.dhbw.ravensburg.wp.be219thenextchapter.repository;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.ArrivalTime;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalTimeRepository extends JpaRepository<ArrivalTime, Long> {

    @Query("SELECT at.busStop FROM ArrivalTime at, BusSchedule bsc WHERE at.id = bsc.arrivalTimeEntry.id " +
            "AND bsc.bus.id = :param1 AND at.arrivalTime < CURRENT_TIME ORDER BY at.arrivalTime desc ")
    BusStop findBusStopByArrivalTime(@Param("param1") long id);


}
