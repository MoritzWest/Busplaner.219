package de.dhbw.ravensburg.wp.be219thenextchapter.service;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusRouteDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.mapper.BusRouteMapper;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService{

    /*BusRouteMapper busRouteMapper;

    BusRouteRepository busRouteRepository;

    public BusRouteServiceImpl(BusRouteMapper busRouteMapper, BusRouteRepository busRouteRepository) {
        this.busRouteMapper = busRouteMapper;
        this.busRouteRepository = busRouteRepository;
    }

    //Read
    @Override
    public List<BusRouteDTO> getAll() {
        List<BusRoute> busRoutes = this.busRouteRepository.findAll(); //liefert alle Buslinien aus der DB
        List<BusRouteDTO> busRouteDTOS = this.busRouteMapper.busRoutesToBusRouteDTOs(busRoutes); // wandelt erste liste in eine liste von dtos um
        return busRouteDTOS;
    }

    //Read
   @Override
    public BusRouteDTO getBusRouteById(long id) {
        BusRoute busRoute = this.busRouteRepository.findBusRouteById(id); //holt busRoute Objekt aus der DB anhand der ID
        BusRouteDTO busRouteDTO = this.busRouteMapper.busRouteToBusRouteDTO(busRoute); // wandelt es in DTO um
        return busRouteDTO;
    }

    //Create
    @Override
    public BusRouteDTO addBusRoute(BusRouteDTO busRouteDTO) {
        BusRoute busRoute = this.busRouteMapper.busRouteDTOToBusRoute(busRouteDTO); //umwandlung
        this.busRouteRepository.save(busRoute); // das Repository kann nur ein konkretes Objekt abstpeichern, erst hierdurch bekommt das Objekt eine Id
        return this.busRouteMapper.busRouteToBusRouteDTO(busRoute); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Update
    @Override
    public BusRouteDTO updateBusRoute(BusRouteDTO busRouteDTO) { //dieses DTO besitzt schon eine Id, daran erkennt das Repsitory dass es schon existert und geuptdated werdem muss
        BusRoute busRoute = this.busRouteMapper.busRouteDTOToBusRoute(busRouteDTO);
        this.busRouteRepository.save(busRoute);
        return this.busRouteMapper.busRouteToBusRouteDTO(busRoute); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Delete
    @Override
    public void removeBusRouteById(long id) {
        this.busRouteRepository.deleteById(id);
    }*/
}
