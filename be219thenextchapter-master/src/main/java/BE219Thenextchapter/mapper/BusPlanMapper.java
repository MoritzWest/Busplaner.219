package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusPlanDTO;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusPlanMapper {

    BusPlanDTO busPlanToBusPlanDTO(BusPlan busPlan);
    List<BusPlanDTO> busPlanToBusPlanDTOs(List<BusPlan> busPlan);

    @InheritInverseConfiguration
    BusPlan busPlanDTOToBusPlan(BusPlanDTO BusPlanDTO);
    List<BusPlan> busPlanDTOsToBusPlan(List<BusPlanDTO> BusPlanDTO);
}
