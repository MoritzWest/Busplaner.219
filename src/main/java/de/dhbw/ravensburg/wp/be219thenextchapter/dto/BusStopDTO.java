package de.dhbw.ravensburg.wp.be219thenextchapter.dto;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.ArrivalTime;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusStopDTO {

    private long id;
    private String street;
    private List<Long> busRouteStartIds;
    private List<Long> busRouteEndIds;
    private List<Long> arrivalTimeIds;


    public BusStopDTO(long id, String street, List<Long> busRouteStartIds, List<Long> busRouteEndIds, List<Long> arrivalTimeIds) {
        this.id = id;
        this.street = street;
        this.busRouteStartIds = busRouteStartIds;
        this.busRouteEndIds = busRouteEndIds;
        this.arrivalTimeIds = arrivalTimeIds;
    }
}

