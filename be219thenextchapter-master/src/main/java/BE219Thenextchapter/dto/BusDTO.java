package BE219Thenextchapter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusDTO {

    private long id;
    private List<Long> busPlanIds;

    public BusDTO(long id, List<Long> busPlanIds) {
        this.id = id;
        this.busPlanIds = busPlanIds;
    }
}



