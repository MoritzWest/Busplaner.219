package BE219Thenextchapter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusLineServiceImpl implements BusLineService {

    /*BusLineMapper busLineMapper;

    BusLineRepository busLineRepository;

    public BusLineServiceImpl(BusLineMapper busLineMapper, BusLineRepository busLineRepository) {
        this.busLineMapper = busLineMapper;
        this.busLineRepository = busLineRepository;
    }

    //Read
    @Override
    public List<BusLineDTO> getAll() {
        List<BusLine> busLines = this.busLineRepository.findAll(); //liefert alle Buslinien aus der DB
        List<BusLineDTO> busLineDTOS = this.busLineMapper.busLinesToBusLineDTOs(busLines); // wandelt erste liste in eine liste von dtos um
        return busLineDTOS;
    }

    //Read
   @Override
    public BusLinesDTO getBusLineById(long id) {
        BusLine busLine = this.busLineRepository.findBusLineById(id); //holt busRoute Objekt aus der DB anhand der ID
        BusLineDTO busLineDTO = this.busLineMapper.busLineToBusLineDTO(busRoute); // wandelt es in DTO um
        return busLineDTO;
    }

    //Create
    @Override
    public BusLinesDTO addBusLine(BusLineDTO busLineDTO) {
        BusLine busLine = this.busLineMapper.busLineDTOToBusLine(busLineDTO); //umwandlung
        this.busLineRepository.save(busLine); // das Repository kann nur ein konkretes Objekt abstpeichern, erst hierdurch bekommt das Objekt eine Id
        return this.busLineMapper.busLineToBusLineDTO(busLine); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Update
    @Override
    public BusLineDTO updateBusLine(BusLineDTO busLineDTO) { //dieses DTO besitzt schon eine Id, daran erkennt das Repsitory dass es schon existert und geuptdated werdem muss
        BusLine busLine = this.busLineMapper.busLineDTOToBusLine(busLineDTO);
        this.busLineRepository.save(busLine);
        return this.busLineMapper.busLineToBusLineDTO(busLine); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Delete
    @Override
    public void removeBusLineById(long id) {
        this.busLineRepository.deleteById(id);
    }*/
}
