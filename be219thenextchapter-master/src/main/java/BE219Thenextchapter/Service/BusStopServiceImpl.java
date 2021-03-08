
package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusStopDTO;
import BE219Thenextchapter.mapper.BusStopMapper;
import BE219Thenextchapter.model.BusStop;
import BE219Thenextchapter.repository.BusStopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BusStopServiceImpl implements BusStopService{

    BusStopMapper busStopMapper;
    BusStopRepository busStopRepository;

    public BusStopServiceImpl(BusStopMapper busStopMapper, BusStopRepository busStopRepository){
        this.busStopMapper = busStopMapper;
        this.busStopRepository = busStopRepository;
    }


    //Implementierung der CRUD-Methoden

    //Read all
    @Override
    public List<BusStopDTO> getAll() {
        List<BusStop> busStops = this.busStopRepository.findAll();
        List<BusStopDTO> busStopDTOS = this.busStopMapper.busStopsToBusStopDTOs(busStops);
        return busStopDTOS;
    }

    //Read by Id
    @Override
    public BusStopDTO getBusStopById(long id) {
        if (!busStopRepository.findById(id).isPresent()) {
            throw new NoSuchElementException();
        }
        BusStop busStop = this.busStopRepository.findById(id).get();
        BusStopDTO busStopDTO = this.busStopMapper.busStopToBusStopDTO(busStop);
        return busStopDTO;
    }

    //Create
    @Override
    public BusStopDTO addBusStop(BusStopDTO busStopDTO) {
        BusStop busStop = this.busStopMapper.busStopDTOToBusStop(busStopDTO);
        this.busStopRepository.save(busStop);
        return this.busStopMapper.busStopToBusStopDTO(busStop);

    }

    //Update
    @Override
    public BusStopDTO updateBusStop(long busStopId, BusStopDTO busStopDTO) {
        if (!busStopRepository.findById(busStopId).isPresent()) {
            throw new NoSuchElementException();
        }
        BusStop busStop = this.busStopMapper.busStopDTOToBusStop(busStopDTO);
        busStop.setId(busStopId);
        this.busStopRepository.save(busStop);
        return this.busStopMapper.busStopToBusStopDTO(busStop);
        }


    //Delete
    @Override
    public void removeBusStopById(long id) {
        if (!busStopRepository.findById(id).isPresent()) {
            throw new NoSuchElementException();
        }
        this.busStopRepository.deleteById(id);
    }
}