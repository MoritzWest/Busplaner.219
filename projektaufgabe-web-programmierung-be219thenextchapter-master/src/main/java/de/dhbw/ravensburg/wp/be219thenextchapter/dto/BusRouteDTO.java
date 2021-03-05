package de.dhbw.ravensburg.wp.be219thenextchapter.dto;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter //werden zur Laufzeit erstellt
@Setter
@NoArgsConstructor //erstellt leeren Konstruktor

public class BusRouteDTO {

    private long busRouteId;
    private int busRouteNumber;
    private int frequency;
    private BusStop startBusStopId;
    private long busSchedule;
    private BusStop endBusStop;
    private List<Long> busScheduleIds;

    public BusRouteDTO(long busRouteId, int busRouteNumber, int frequency, BusStop startBusStopId, long busSchedule, BusStop endBusStop, List<Long> busScheduleIds) {
        this.busRouteId = busRouteId;
        this.busRouteNumber = busRouteNumber;
        this.frequency = frequency;
        this.startBusStopId = startBusStopId;
        this.busSchedule = busSchedule;
        this.endBusStop = endBusStop;
        this.busScheduleIds = busScheduleIds;
    }
}

