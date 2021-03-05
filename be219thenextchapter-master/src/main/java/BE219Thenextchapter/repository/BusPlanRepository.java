package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.BusPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusPlanRepository extends JpaRepository<BusPlan, Long> {
    //BusSchedule findBusScheduleById( long id);
}
