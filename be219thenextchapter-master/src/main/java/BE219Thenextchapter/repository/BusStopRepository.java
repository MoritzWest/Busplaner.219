package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Long> {

    BusStop findBusStopById(long id);


    @Query("SELECT DISTINCT bs FROM BusStop bs, BusLine br, BusPlan bsc, ArrivingTime at WHERE bs.id = at.busStop.id AND at.id = bsc.arrivalTimeEntry.id" +
            " AND bsc.busLine.busLineId  = :param1")
    List<BusStop> findAllBusStopsByBusLineId(@Param("param1") long id);

    List<BusStop> findAllBusStopsByBusRouteId(long busLineId);



   @Query("Select s.stoppingBusLines FROM BusStops s WHERE s.id = :param1")
   List<BusStop> findAllBusLineById(
            @Param("param1") long id
    );

   //@Query("SELECT FROM BusStop s WHERE s.Id = :param1 AND s.BusLine.BusPlan ") ;


}
