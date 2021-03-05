package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BusMapper {

   //die Ids der BusLinien werden in die Variable BusRouteIds geschrieben -> mapping
    @Mapping(target = "busLineIds", source = "busLines") //Ids aus source werden auf target also DTO gemapped, target kommt aus DTO, source aus model
    BusDTO busToBusDTO(Bus bus);
    List<BusDTO> bussesToBusDTOs(List<Bus> busses);

    Bus busDTOToBus (BusDTO busDTO);
    List<Bus> busDTOsToBusses (List<BusDTO> busDTOs);

    //holt die Ids des Busfahrplans
    default Long map(BusPlan busPlan){
        return busPlan.getId();
     }

}
