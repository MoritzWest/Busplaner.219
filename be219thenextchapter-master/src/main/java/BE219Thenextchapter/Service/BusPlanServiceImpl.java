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
public class BusPlanServiceImpl implements BusPlanService{

    BusPlanMapper busPlanMapper;
    BusPlanRepository busPlanRepository;

    public BusPlanServiceImpl(BusPlanMapper busPlanMapper, BusPlanRepository busPlanRepository) {
        this.busPlanMapper = busPlanMapper;
        this.busPlanRepository = busPlanRepository;
    }

    @Override
    public List<BusPlanDTO> getAll() {
    List<BusPlan> busPlan = this.busPlanRepository.findAll(); //liefert alle Buslinien aus der DB
    List<BusPlanDTO> busPlanDTOS = this.busPlanMapper.busPlanToBusPlanDTOs(busPlan); // wandelt erste liste in eine liste von dtos um
    return busPlanDTOS;
}

    @Override
    public BusPlanDTO getBusPlanById(long id) {
    BusPlan busPlan = this.busPlanRepository.findBusPlanById(id); //holt busLine Objekt aus der DB anhand der ID
    BusPlanDTO busPlanDTO = this.busPlanMapper.busPlanToBusPlanDTO(busPlan); // wandelt es in DTO um
    return busPlanDTO;
}

    @Override
    public BusPlanDTO addBusPlan(BusPlanDTO busPlanDTO) {
    BusPlan busPlan = this.busPlanMapper.busPlanDTOToBusPlan(busPlanDTO); //umwandlung
    this.busPlanRepository.save(busPlan); // das Repository kann nur ein konkretes Objekt abstpeichern, erst hierdurch bekommt das Objekt eine Id
    return this.busPlanMapper.busPlanToBusPlanDTO(busPlan); //wollen DTO zurückgeben deshalb in DTO umwandeln
}

    @Override
    public BusPlanDTO updateBusPlan(BusPlanDTO busPlanDTO) { //dieses DTO besitzt schon eine Id, daran erkennt das Repsitory dass es schon existert und geuptdated werdem muss
    BusPlan busPlan = this.busPlanMapper.busPlanDTOToBusPlan(busPlanDTO);
    this.busPlanRepository.save(busPlan);
    return this.busPlanMapper.busPlanToBusPlanDTO(busPlan); //wollen DTO zurückgeben deshalb in DTO umwandeln
}

    @Override
    public void removeBusPlanById(long id) {
    this.busPlanRepository.deleteById(id);
}


}
*/
