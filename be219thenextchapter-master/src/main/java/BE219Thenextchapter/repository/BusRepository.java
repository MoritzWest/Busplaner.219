package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Bus findById(long id);

    //JPQL Abfrage: Bei Eingabe einer konkreten BusId werden alle Buslinien zurückgegeben (welche der Bus an dem Tag bedient? -alle?
    // fehlt: Ankunftszeit an der ersten Haltestelle der entsprechenden Buslinie
/*
    @Query("SELECT DISTINCT b FROM Bus b, BusPlan bsc WHERE b.id = bsc.bus.id AND bsc.busLine.busLineId = :param1")
    List<Bus> findBussesByBusLine(@Param("param1") long id);


 */

}
