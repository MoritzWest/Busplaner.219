/*
package de.dhbw.ravensburg.wp.be219thenextchapter.service;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusRouteDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusScheduleDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.mapper.BusRouteMapper;
import de.dhbw.ravensburg.wp.be219thenextchapter.mapper.BusScheduleMapper;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import de.dhbw.ravensburg.wp.be219thenextchapter.repository.BusRouteRepository;
import de.dhbw.ravensburg.wp.be219thenextchapter.repository.BusScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService{

    BusScheduleMapper busScheduleMapper;
    BusScheduleRepository busScheduleRepository;

    public BusScheduleServiceImpl(BusScheduleMapper busscheduleMapper, BusScheduleRepository busScheduleRepository) {
        this.busScheduleMapper = busscheduleMapper;
        this.busScheduleRepository = busScheduleRepository;
    }

    @Override
    public List<BusScheduleDTO> getAll() {
    List<BusSchedule> busSchedules = this.busScheduleRepository.findAll(); //liefert alle Buslinien aus der DB
    List<BusScheduleDTO> busScheduleDTOS = this.busScheduleMapper.busSchedulesToBusScheduleDTOs(busSchedules); // wandelt erste liste in eine liste von dtos um
    return busScheduleDTOS;
}

    @Override
    public BusScheduleDTO getBusScheduleById(long id) {
    BusSchedule busSchedule = this.busScheduleRepository.findBusScheduleById(id); //holt busRoute Objekt aus der DB anhand der ID
    BusScheduleDTO busScheduleDTO = this.busScheduleMapper.busScheduleToBusScheduleDTO(busSchedule); // wandelt es in DTO um
    return busScheduleDTO;
}

    @Override
    public BusScheduleDTO addBusSchedule(BusScheduleDTO busScheduleDTO) {
    BusSchedule busSchedule = this.busScheduleMapper.busScheduleDTOToBusSchedule(busScheduleDTO); //umwandlung
    this.busScheduleRepository.save(busSchedule); // das Repository kann nur ein konkretes Objekt abstpeichern, erst hierdurch bekommt das Objekt eine Id
    return this.busScheduleMapper.busScheduleToBusScheduleDTO(busSchedule); //wollen DTO zurückgeben deshalb in DTO umwandeln
}

    @Override
    public BusScheduleDTO updateBusSchedule(BusScheduleDTO busScheduleDTO) { //dieses DTO besitzt schon eine Id, daran erkennt das Repsitory dass es schon existert und geuptdated werdem muss
    BusSchedule busSchedule = this.busScheduleMapper.busScheduleDTOToBusSchedule(busScheduleDTO);
    this.busScheduleRepository.save(busSchedule);
    return this.busScheduleMapper.busScheduleToBusScheduleDTO(busSchedule); //wollen DTO zurückgeben deshalb in DTO umwandeln
}

    @Override
    public void removeBusScheduleById(long id) {
    this.busScheduleRepository.deleteById(id);
}


}
*/
