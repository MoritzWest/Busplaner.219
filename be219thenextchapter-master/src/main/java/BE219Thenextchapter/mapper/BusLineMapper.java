package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusLineMapper {

    @Mapping(target = "busPlanIds", source = "busPlans")
    BusLineDTO busRouteToBusLineDTO(BusLine busLine);
    List<BusLineDTO> busLineToBusLineDTOs(List<BusLine> busLines);

    BusLine busLineDTOToBusLine(BusLineDTO busLineDTO);
    List<BusLine> busLineDTOsToBusLine(List<BusLineDTO> busLineDTOS);

    default Long map(BusPlan busPlan) {
        return busPlan.getId();
    }



}


