package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BusMapper {

    @Mapping(target = "busPlanIds", source = "busPlans")
    BusDTO busToBusDTO(Bus bus);

    List<BusDTO> busToBusDTOs(List<Bus> bus);

    Bus busDTOToBus(BusDTO busDTO);

    List<Bus> busDTOsToBus(List<BusDTO> busDTOS);

    default Long map(BusPlan busPlan) {
        return busPlan.getId();
    }
}
