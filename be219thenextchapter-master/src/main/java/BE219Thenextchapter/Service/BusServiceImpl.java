
package BE219Thenextchapter.Service;

import BE219Thenextchapter.repository.BusRepository;
import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.mapper.BusMapper;
import BE219Thenextchapter.model.Bus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    BusMapper busMapper;
    BusRepository busRepository;

    public BusServiceImpl(BusMapper busMapper, BusRepository busRepository) {
        this.busMapper = busMapper;
        this.busRepository = busRepository;
    }

    //Read all
    @Override
    public List<BusDTO> getAll() {
        List<Bus> busses = this.busRepository.findAll();
        List<BusDTO> busDTOS = this.busMapper.busToBusDTOs(busses);
        return busDTOS;
    }



    //Read by id
    @Override
    public BusDTO getBusById(long id) {
        Bus bus = this.busRepository.findById(id);
        BusDTO busDTO = this.busMapper.busToBusDTO(bus);
        return busDTO;
    }

    //Create
    @Override
    public BusDTO addBus(BusDTO busDTO) {
        Bus bus = this.busMapper.busDTOToBus(busDTO);
        this.busRepository.save(bus);
        return this.busMapper.busToBusDTO(bus);
    }


    @Override
    public BusDTO updateBus(BusDTO busDTO) {
        Bus bus = this.busMapper.busDTOToBus(busDTO);
        this.busRepository.save(bus);
        return this.busMapper.busToBusDTO(bus); 
    }

    //Delete
    @Override
    public void removeBusById(long id) {
        this.busRepository.deleteById(id);
    }
}

