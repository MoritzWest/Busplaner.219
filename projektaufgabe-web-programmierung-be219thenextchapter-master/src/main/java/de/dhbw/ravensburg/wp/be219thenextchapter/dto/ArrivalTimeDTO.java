package de.dhbw.ravensburg.wp.be219thenextchapter.dto;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ArrivalTimeDTO {

    private long id;
    private LocalTime arrivalTime;
    private BusStop busStop;
    private BusSchedule busSchedule;

    public ArrivalTimeDTO(long id, LocalTime arrivalTime, BusStop busStop, BusSchedule busSchedule) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.busStop = busStop;
        this.busSchedule = busSchedule;
    }
}
