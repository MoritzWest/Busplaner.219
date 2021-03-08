package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.mapper.BusLineMapper;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.repository.BusLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * @Author Moritz Westhäußer
 */
@Service
public class BusLineServiceImpl implements BusLineService {

    BusLineMapper busLineMapper;

    BusLineRepository busLineRepository;

    public BusLineServiceImpl(BusLineMapper busLineMapper, BusLineRepository busLineRepository) {
        this.busLineMapper = busLineMapper;
        this.busLineRepository = busLineRepository;
    }

    //Read
    @Override
    public List<BusLineDTO> getAll() {
        List<BusLine> busLines = this.busLineRepository.findAll(); //liefert alle Buslinien aus der DB
        List<BusLineDTO> busLineDTOs = this.busLineMapper.busLinesToBusLineDTOs(busLines); // wandelt erste liste in eine liste von dtos um
        return busLineDTOs;
    }

    //Read
   @Override
    public BusLineDTO getBusLineById(long id) {
       if (!busLineRepository.findById(id).isPresent()) {
           throw new NoSuchElementException();
       }
        BusLine busLine = this.busLineRepository.findById(id).get(); //holt busRoute Objekt aus der DB anhand der ID
        BusLineDTO busLineDTO = this.busLineMapper.busLineToBusLineDTO(busLine); // wandelt es in DTO um
        return busLineDTO;
    }

    //Create
    @Override
    public BusLineDTO addBusLine(BusLineDTO busLineDTO) {
        BusLine busLine = this.busLineMapper.busLineDTOToBusLine(busLineDTO); //Umwandlung
        this.busLineRepository.save(busLine); // das Repository kann nur ein konkretes Objekt abstpeichern, erst hierdurch bekommt das Objekt eine Id
        return this.busLineMapper.busLineToBusLineDTO(busLine); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Update
    @Override
    public BusLineDTO updateBusLine(long busLineId, BusLineDTO busLineDTO) { //dieses DTO besitzt schon eine Id, daran erkennt das Repsitory dass es schon existert und geuptdated werdem muss
        if (!busLineRepository.findById(busLineId).isPresent()) {
            throw new NoSuchElementException();
        }
        BusLine busLine = this.busLineMapper.busLineDTOToBusLine(busLineDTO);
        busLine.setBusLineId(busLineId);
        this.busLineRepository.save(busLine);
        return this.busLineMapper.busLineToBusLineDTO(busLine); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Delete
    @Override
    public void removeBusLineById(long id) {
        if (!busLineRepository.findById(id).isPresent()) {
            throw new NoSuchElementException();
        }
        this.busLineRepository.deleteById(id);
    }
}
