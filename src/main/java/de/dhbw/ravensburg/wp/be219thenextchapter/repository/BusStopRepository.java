package de.dhbw.ravensburg.wp.be219thenextchapter.repository;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    BusStop findBusStopById(long id);

    //Gibt zu einer Buslinie die Haltestellen zurück
    @Query("SELECT DISTINCT bs FROM BusStop bs, BusRoute br, BusSchedule bsc, ArrivalTime at WHERE bs.id = at.busStop.id AND at.id = bsc.arrivalTimeEntry.id" +
            " AND bsc.busRoute.busRouteId  = :param1")
    List<BusStop> findAllBusStopsByBusRouteId(@Param("param1") long id);



    //JPQL Abfrage: Bei Eingabe einer konkreten Haltestelle werden alle Busse, die als nächstes an dem Tag die Haltestelle anfahren
    //samt deren Buslinie und deren Ankunftszeit zurückgegeben
  /*  @Query("Select s.stoppingBusRoutes FROM BusStops s WHERE s.id = :param1") */
   /* List<BusRoute> findAllBusRoutesById(
            @Param("param1") long id
    );*/

    //abgeleitete Abfrage!!

   // @Query("SELECT FROM BusStop s WHERE s.Id = :param1 AND s.BusRoute.BusSchedule ") //bei from hinschr. von welchen models

}
