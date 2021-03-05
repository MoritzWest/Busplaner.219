package de.dhbw.ravensburg.wp.be219thenextchapter.dto;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusDTO {

    private long id;
    private List<Long> busScheduleIds;

    public BusDTO(long id, List<Long> busScheduleIds) {
        this.id = id;
        this.busScheduleIds = busScheduleIds;
    }
}



