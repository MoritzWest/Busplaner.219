package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @Author Moritz Westhäußer
 */

@Mapper(componentModel = "spring")
public interface BusLineMapper {

    BusLineDTO busLineToBusLineDTO(BusLine busLine);
    List<BusLineDTO> busLinesToBusLineDTOs(List<BusLine> busLines);

    BusLine busLineDTOToBusLine(BusLineDTO busLineDTO);
    List<BusLine> busLineDTOsToBusLine(List<BusLineDTO> busLineDTOS);

}


