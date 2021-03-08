package BE219Thenextchapter;

import BE219Thenextchapter.model.*;
import BE219Thenextchapter.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
//test

@Component
@Slf4j
public class ManualTestBean {

    private BusLineRepository busLineRepository;
    private BusRepository busRepository;
    private BusStopRepository busStopRepository;
    private BusPlanRepository busPlanRepository;
    private ArrivingTimeRepository arrivingTimeRepository;


    ManualTestBean(BusLineRepository busLineRepository, BusRepository busRepository, BusStopRepository busStopRepository, BusPlanRepository busPlanRepository, ArrivingTimeRepository arrivingTimeRepository) {
        this.busLineRepository = busLineRepository;
        this.busRepository = busRepository;
        this.busStopRepository = busStopRepository;
        this.busPlanRepository = busPlanRepository;
        this.arrivingTimeRepository = arrivingTimeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController() {

        //BusStops
        BusStop busStop_1 = new BusStop("Gartenweg");
        BusStop busStop_2 = new BusStop("Bahnhof");
        BusStop busStop_3 = new BusStop("Robert-Bosch-Straße");

        //Create BusLine
        BusLine busLine_1 = new BusLine(1, 15, LocalTime.of(6,00,00), LocalTime.of(20,00,00), busStop_1, busStop_3);
        BusLine busLine_2 = new BusLine(2, 30, LocalTime.of(8,00,00), LocalTime.of(22,00,00), busStop_1, busStop_2);
        BusLine busLine_3 = new BusLine(3, 60, LocalTime.of(10, 30, 00), LocalTime.of(23, 55,00), busStop_3, busStop_2);

        //Busses
        Bus bus_1 = new Bus();
        Bus bus_2 = new Bus();
        Bus bus_3 = new Bus();

        //ArrvivingTime
        ArrivingTime arrivingTime_1 = new ArrivingTime(LocalTime.of(6,30, 00));
        arrivingTime_1.setBusStop(busStop_1);
        ArrivingTime arrivingTime_2 = new ArrivingTime(LocalTime.of(10,30, 00));
        ArrivingTime arrivingTime_3 = new ArrivingTime(LocalTime.of(11,20, 00));

        //Busplan
        BusPlan busPlan_1 = new BusPlan(busLine_1, bus_1, arrivingTime_1);
        BusPlan busPlan_2 = new BusPlan(busLine_1, bus_1, arrivingTime_2);
        BusPlan busPlan_3 = new BusPlan(busLine_1, bus_1, arrivingTime_3);

        //BusLine to Busplan
        busLine_1.setBusPlans(Arrays.asList(busPlan_1, busPlan_2));
        busLine_2.setBusPlans(Arrays.asList(busPlan_2, busPlan_3));
        busLine_3.setBusPlans(Arrays.asList(busPlan_1, busPlan_2, busPlan_3));

        //Bus to BusPlan
        bus_1.setBusPlans(Arrays.asList(busPlan_1, busPlan_2));
        bus_2.setBusPlans(Arrays.asList(busPlan_1, busPlan_3));
        bus_3.setBusPlans(Arrays.asList(busPlan_2, busPlan_3));


        busPlanRepository.saveAll(Arrays.asList(busPlan_1,busPlan_2,busPlan_3));

    }
}
