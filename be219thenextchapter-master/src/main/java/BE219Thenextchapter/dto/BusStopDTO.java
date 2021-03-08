package BE219Thenextchapter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
/**
 * @Author Moritz Westhäußer
 */

@Setter
@Getter
@NoArgsConstructor
public class BusStopDTO {

    private long id;
    private String street;
    private List<BusLineDTO> busLineStarts;
    private List<BusLineDTO> busLineEnds;
    private List<ArrivingTimeDTO> arrivingTimes;



    public BusStopDTO(long id, String street, List<BusLineDTO> busLineStarts, List<BusLineDTO> busLineEnds, List<ArrivingTimeDTO> arrivingTimes) {
        this.id = id;
        this.street = street;
        this.busLineStarts = busLineStarts;
        this.busLineEnds = busLineEnds;
        this.arrivingTimes = arrivingTimes;
    }
}

