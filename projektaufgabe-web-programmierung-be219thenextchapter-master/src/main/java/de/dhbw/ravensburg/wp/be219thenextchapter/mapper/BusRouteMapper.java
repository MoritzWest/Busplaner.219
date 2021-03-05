package de.dhbw.ravensburg.wp.be219thenextchapter.mapper;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusRouteDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusRouteMapper {

    @Mapping(target = "busScheduleIds", source = "busSchedules")
    BusRouteDTO busRouteToBusRouteDTO(BusRoute busRoute);
    List<BusRouteDTO> busRoutesToBusRouteDTOs(List<BusRoute> busRoutes);

    BusRoute busRouteDTOToBusRoute(BusRouteDTO busRouteDTO);
    List<BusRoute> busRouteDTOsToBusRoutes(List<BusRouteDTO> busRouteDTOS);

    default Long map(BusSchedule busSchedule) {
        return busSchedule.getId();
    }



}


