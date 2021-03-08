package BE219Thenextchapter.dto;

import BE219Thenextchapter.model.BusPlan;
import BE219Thenextchapter.model.BusStop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

//werden zur Laufzeit erstellt
@Setter
@Getter
@NoArgsConstructor //erstellt leeren Konstruktor

public class BusLineDTO {

    private long busLineId;
    private int busLineNumber;
    private int frequency;
    private LocalTime startTimeAtFirstStop;
    private LocalTime endTimeAtFirstStop;
    private BusStopDTO startBusStop;
    private BusStopDTO endBusStop;
    private  List<BusPlanDTO> busPlans;

    public BusLineDTO(long busLineId, int busLineNumber, int frequency, LocalTime startTimeAtFirstStop, LocalTime endTimeAtFirstStop, BusStopDTO startBusStop, BusStopDTO endBusStop, List<BusPlanDTO> busPlans) {
        this.busLineId = busLineId;
        this.busLineNumber = busLineNumber;
        this.frequency = frequency;
        this.startTimeAtFirstStop = startTimeAtFirstStop;
        this.endTimeAtFirstStop = endTimeAtFirstStop;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.busPlans = busPlans;
    }
}

