/*
package de.dhbw.ravensburg.wp.be219thenextchapter.service;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusRouteDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusStopDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.mapper.BusStopMapper;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;
import de.dhbw.ravensburg.wp.be219thenextchapter.repository.BusStopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<BusStopDTO> busStopDTOS = this.busStopMapper.busStopsToBusStopDTOs(busStops); //übergibt die darüber angelegte busStop Liste an die Methode im Mapper
        return busStopDTOS;
    }

    //Read by Id
    @Override
    public BusStopDTO getBusStopById(long id) {
        BusStop busStop = this.busStopRepository.findBusStopById(id);
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
    public BusStopDTO updateBusStop(BusStopDTO busStopDTO) {
        BusStop busStop = this.busStopMapper.busStopDTOToBusStop(busStopDTO);
        this.busStopRepository.save(busStop);
        return this.busStopMapper.busStopToBusStopDTO(busStop); //Umwandlung und Rückgabe des Objekts in DTO über die Mapper-Methode
        }


    //Delete
    @Override
    public void removeBusStopById(long id) {
        this.busStopRepository.deleteById(id);
    }
}
*/
