package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.mapper.BusLineMapper;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.repository.BusLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        List<BusLine> busLines = this.busLineRepository.findAll();
        List<BusLineDTO> busLineDTOs = this.busLineMapper.busLinesToBusLineDTOs(busLines);
        return busLineDTOs;
    }

    //Read
   @Override
    public BusLineDTO getBusLineById(long id) {
       if (!busLineRepository.findById(id).isPresent()) {
           throw new NoSuchElementException();
       }
        BusLine busLine = this.busLineRepository.findById(id).get();
        BusLineDTO busLineDTO = this.busLineMapper.busLineToBusLineDTO(busLine);
        return busLineDTO;
    }

    //Create
    @Override
    public BusLineDTO addBusLine(BusLineDTO busLineDTO) {
        BusLine busLine = this.busLineMapper.busLineDTOToBusLine(busLineDTO);
        this.busLineRepository.save(busLine);
        return this.busLineMapper.busLineToBusLineDTO(busLine);
    }

    //Update
    @Override
    public BusLineDTO updateBusLine(long busLineId, BusLineDTO busLineDTO) {
        if (!busLineRepository.findById(busLineId).isPresent()) {
            throw new NoSuchElementException();
        }
        BusLine busLine = this.busLineMapper.busLineDTOToBusLine(busLineDTO);
        busLine.setBusLineId(busLineId);
        this.busLineRepository.save(busLine);
        return this.busLineMapper.busLineToBusLineDTO(busLine);
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
