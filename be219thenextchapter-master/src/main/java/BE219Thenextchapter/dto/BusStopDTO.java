package BE219Thenextchapter.dto;

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
    private List<Long> busLineStartIds;
    private List<Long> busLineEndIds;
    private List<Long> arrivingTimeIds;


    public BusStopDTO(long id, String street, List<Long> busLineStartIds, List<Long> busLineEndIds, List<Long> arrivalTimeIds) {
        this.id = id;
        this.street = street;
        this.busLineStartIds = busLineStartIds;
        this.busLineEndIds = busLineEndIds;
        this.arrivingTimeIds = arrivingTimeIds;
    }
}

