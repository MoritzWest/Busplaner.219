package de.dhbw.ravensburg.wp.be219thenextchapter.dto;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.ArrivalTime;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class BusScheduleDTO {
    private long id;
    private BusRoute busRoute;
    private Bus bus;
    private ArrivalTime arrivalTimeEntry;

    public BusScheduleDTO(long id, BusRoute busRoute, Bus bus, ArrivalTime arrivalTimeEntry) {
        this.id = id;
        this.busRoute = busRoute;
        this.bus = bus;
        this.arrivalTimeEntry = arrivalTimeEntry;
    }
}

