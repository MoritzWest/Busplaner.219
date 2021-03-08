package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.ArrivingTime;
import BE219Thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivingTimeRepository extends JpaRepository<ArrivingTime, Long> {

    /*
    @Query("SELECT at.busStop FROM ArrivingTime at, BusPlan bsc WHERE at.id = bsc.arrivingTimeEntry.id " +
            "AND bsc.bus.id = :param1 AND at.arrivingTime < CURRENT_TIME ORDER BY at.arrivingTime desc ")
    BusStop findBusStopByArrivalTime(@Param("param1") long id);
*/

}
