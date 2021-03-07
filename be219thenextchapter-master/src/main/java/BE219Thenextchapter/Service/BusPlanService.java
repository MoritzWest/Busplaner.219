package BE219Thenextchapter.Service;


import BE219Thenextchapter.dto.BusPlanDTO;

import java.util.List;

public interface BusPlanService {

    //Read
    List<BusPlanDTO> getAll();
    BusPlanDTO getBusPlanById(long id);

    //Create
    BusPlanDTO addBusPlan(BusPlanDTO busPlanDTO);

    //Update
    BusPlanDTO updateBusPlan(BusPlanDTO busPlanDTO);

    //Delete
    void removeBusPlanById(long id);


}
