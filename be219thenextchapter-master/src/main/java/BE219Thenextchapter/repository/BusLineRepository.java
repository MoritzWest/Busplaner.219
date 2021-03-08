package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Long> {

    BusLine findBusLineById(long id);

   @Query("SELECT b.BusStop FROM BusLine b")
   List<BusStop> findBusStopsById(@Param("param1")long id);





    @Query("Select r.involvedStops FROM Busline r WHERE r.id = :param1")
    List<BusStop> findStopsById(
                @Param("param1") long id);


    @Query("SELECT r.busses FROM BusRoute r WHERE r.id = :param1")
    List<Bus> findBussesById(
            @Param("param1") long id);

}
