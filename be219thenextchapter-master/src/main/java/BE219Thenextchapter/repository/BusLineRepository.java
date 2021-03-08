package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Long> {

    //BusRoute findBusLineById(long id); // bekommen immer nur eine BusRouteId deshalb keine Liste

   /* @Query("SELECT b.BusStop FROM BusLine b")
    List<BusStop> findBusStopsById(@Param("param1")long id);*/




   /* //JPQL Abfrage: Bei Eingabe einer Buslinie, sollen die angefahrenen Haltestellen dieser zurückgegeben werden
    @Query("Select r.involvedStops FROM Busline r WHERE r.id = :param1")
    List<BusStop> findStopsById(
                @Param("param1") long id);

    //JPQL Abfrage: Bei Eingabe einer Buslinie, sollen alle Busse welche dieser zugeordnet sind zurückgegeben werden
    @Query("SELECT r.busses FROM BusRoute r WHERE r.id = :param1")
    List<Bus> findBussesById(
            @Param("param1") long id); */

}
