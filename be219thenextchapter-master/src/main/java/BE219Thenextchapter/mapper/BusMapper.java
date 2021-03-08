package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface BusMapper {
@Mapping(target = "busPlanIds", source = "busPlans")


    default List<Long> map(List<BusPlan> BusPlan) {
        List<Long> Result = new ArrayList<>();
      if(BusPlan!=null){
            BusPlan.forEach(busPlan -> Result.add(busPlan.getId()));
       }
        return Result;
    }


    BusDTO busToBusDTO(Bus bus);
    List<BusDTO> busToBusDTOs(List<Bus> bus);

    Bus busDTOToBus(BusDTO busDTO);
    List<Bus> busDTOsToBus(List<BusDTO> busDTOs);
}
