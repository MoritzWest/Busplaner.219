package de.dhbw.ravensburg.wp.be219thenextchapter.repository;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Bus findBusById(long id);

    //JPQL Abfrage: Bei Eingabe einer konkreten BusId werden alle Buslinien zurückgegeben (welche der Bus an dem Tag bedient? -alle?
    // fehlt: Ankunftszeit an der ersten Haltestelle der entsprechenden Buslinie

    @Query("SELECT DISTINCT b FROM Bus b, BusSchedule bsc WHERE b.id = bsc.bus.id AND bsc.busRoute.busRouteId = :param1")
    List<Bus> findBussesByBusRoute(@Param("param1") long id);


}
