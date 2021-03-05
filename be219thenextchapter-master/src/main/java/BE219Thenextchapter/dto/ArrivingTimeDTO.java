package BE219Thenextchapter.dto;

import BE219Thenextchapter.model.BusPlan;
import BE219Thenextchapter.model.BusStop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ArrivingTimeDTO {

    private long id;
    private LocalTime arrivingTime;
    private BusStop busStop;
    private BusPlan busPlan;

    public ArrivingTimeDTO(long id, LocalTime arrivingTime, BusStop busStop, BusPlan busPlan) {
        this.id = id;
        this.arrivingTime = arrivingTime;
        this.busStop = busStop;
        this.busPlan = busPlan;
    }
}
