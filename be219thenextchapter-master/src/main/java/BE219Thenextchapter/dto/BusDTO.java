package BE219Thenextchapter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BusDTO {

    private Long id;
    private List<Long> busPlanIds;

    public BusDTO(Long id, List<Long> busPlanIds) {
        this.id = id;
        this.busPlanIds = busPlanIds;
    }
}



