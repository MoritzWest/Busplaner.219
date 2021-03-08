package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.ArrivingTime;
import BE219Thenextchapter.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivingTimeRepository extends JpaRepository<ArrivingTime, Long> {

}
