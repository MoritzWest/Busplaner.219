package BE219Thenextchapter.repository;

import BE219Thenextchapter.model.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Long> {


}
