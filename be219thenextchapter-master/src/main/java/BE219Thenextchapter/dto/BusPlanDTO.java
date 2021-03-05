package BE219Thenextchapter.dto;

import BE219Thenextchapter.model.ArrivingTime;
import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class BusPlanDTO {
    private long id;
    private BusLine busLine;
    private Bus bus;
    private ArrivingTime arrivingTimeEntry;

    public BusPlanDTO(long id, BusLine busLine, Bus bus, ArrivingTime arrivingTimeEntry) {
        this.id = id;
        this.busLine = busLine;
        this.bus = bus;
        this.arrivingTimeEntry = arrivingTimeEntry;
    }
}

