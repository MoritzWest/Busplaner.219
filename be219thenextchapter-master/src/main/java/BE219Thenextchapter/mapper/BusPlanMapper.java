package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusPlanDTO;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusPlanMapper {

    @Mapping(target = "busPlanIds", source = "busPlans")
    BusPlanDTO busPlanToBusPlanDTO(BusPlan busPlan);
    List<BusPlanDTO> busPlanToBusPlanDTOs(List<BusPlan> busPlan);

    BusPlan busPlanDTOToBusPlan(BusPlanDTO busPlanDTO);
    List<BusPlan> busPlanDTOsToBusPlan(List<BusPlanDTO> busPlanDTOS);

    default Long map(BusPlan busPlan) {
        return busPlan.getId();
    }



}