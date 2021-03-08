package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusStopDTO;
import BE219Thenextchapter.model.BusStop;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author Moritz Westhäußer
 */

@Mapper(componentModel = "spring")
public interface BusStopMapper {

    BusStopDTO busStopToBusStopDTO(BusStop busStop);
    List<BusStopDTO> busStopsToBusStopDTOs(List<BusStop> busStops);

    @InheritInverseConfiguration
    BusStop busStopDTOToBusStop(BusStopDTO busStopDTO);
    List<BusStop> busStopDTOsToBusStops(List<BusStopDTO> busStopDTOs);
}
