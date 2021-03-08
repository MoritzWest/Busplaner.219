package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusPlanDTO;
import BE219Thenextchapter.mapper.BusPlanMapper;
import BE219Thenextchapter.model.BusPlan;
import BE219Thenextchapter.repository.BusPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusPlanServiceImpl implements BusPlanService{

    BusPlanMapper busPlanMapper;
    BusPlanRepository busPlanRepository;

    public BusPlanServiceImpl(BusPlanMapper busPlanMapper, BusPlanRepository busPlanRepository) {
        this.busPlanMapper = busPlanMapper;
        this.busPlanRepository = busPlanRepository;
    }

    @Override
    public List<BusPlanDTO> getAll() {
    List<BusPlan> busPlan = this.busPlanRepository.findAll();
    List<BusPlanDTO> busPlanDTOS = this.busPlanMapper.busPlanToBusPlanDTOs(busPlan);
    return busPlanDTOS;
}

    @Override
    public BusPlanDTO getBusPlanById(long id) {
    BusPlan busPlan = this.busPlanRepository.findById(id).get();
    BusPlanDTO busPlanDTO = this.busPlanMapper.busPlanToBusPlanDTO(busPlan);
    return busPlanDTO;
}

    @Override
    public BusPlanDTO addBusPlan(BusPlanDTO busPlanDTO) {
    BusPlan busPlan = this.busPlanMapper.busPlanDTOToBusPlan(busPlanDTO);
    this.busPlanRepository.save(busPlan);
    return this.busPlanMapper.busPlanToBusPlanDTO(busPlan);
}

    @Override
    public BusPlanDTO updateBusPlan(BusPlanDTO busPlanDTO) {
    BusPlan busPlan = this.busPlanMapper.busPlanDTOToBusPlan(busPlanDTO);
    this.busPlanRepository.save(busPlan);
    return this.busPlanMapper.busPlanToBusPlanDTO(busPlan);
}

    @Override
    public void removeBusPlanById(long id) {
    this.busPlanRepository.deleteById(id);
}


}

