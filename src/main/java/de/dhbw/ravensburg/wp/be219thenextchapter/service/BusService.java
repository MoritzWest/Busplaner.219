
package de.dhbw.ravensburg.wp.be219thenextchapter.service;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusRouteDTO;

import java.util.List;


public interface BusService {
    //Read
    List<BusDTO> getAll();
    BusDTO getBusById(long id);

    //Create
    BusDTO addBus(BusDTO busDTO) ; //bekommt DTO wird mit Mapper in Objekt umgew. und gespeichert

    //Update
    BusDTO updateBus(BusDTO busDTO);

    //Delete
    void removeBusById(long id) ;
}

