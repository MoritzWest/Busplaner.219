package de.dhbw.ravensburg.wp.be219thenextchapter.repository;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {

    //BusRoute findBusRouteById(long id); // bekommen immer nur eine BusRouteId deshalb keine Liste

   /* @Query("SELECT b.BusStop FROM BusRoute b")
    List<BusStop> findBusStopsById(@Param("param1")long id);*/




   /* //JPQL Abfrage: Bei Eingabe einer Buslinie, sollen die angefahrenen Haltestellen dieser zurückgegeben werden
    @Query("Select r.involvedStops FROM BusRoute r WHERE r.id = :param1")
    List<BusStop> findStopsById(
                @Param("param1") long id);

    //JPQL Abfrage: Bei Eingabe einer Buslinie, sollen alle Busse welche dieser zugeordnet sind zurückgegeben werden
    @Query("SELECT r.busses FROM BusRoute r WHERE r.id = :param1")
    List<Bus> findBussesById(
            @Param("param1") long id); */

}
