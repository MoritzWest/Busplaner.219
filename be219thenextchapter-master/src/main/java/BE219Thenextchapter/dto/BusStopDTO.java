package BE219Thenextchapter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BusStopDTO {

    private long id;
    private String street;
    private BusLineDTO startBusStop;
    private BusLineDTO endBusStop;
    private List<ArrivingTimeDTO> arrivingTimes;


    public BusStopDTO(long id, String street, BusLineDTO startBusStop, BusLineDTO endBusStop, List<ArrivingTimeDTO> arrivingTimes) {
        this.id = id;
        this.street = street;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.arrivingTimes = arrivingTimes;
    }
}

