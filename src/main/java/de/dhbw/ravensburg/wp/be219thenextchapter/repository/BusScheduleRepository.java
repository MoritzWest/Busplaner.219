package de.dhbw.ravensburg.wp.be219thenextchapter.repository;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
    //BusSchedule findBusScheduleById( long id);
}
