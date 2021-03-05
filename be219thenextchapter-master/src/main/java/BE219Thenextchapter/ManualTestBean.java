package BE219Thenextchapter;

import BE219Thenextchapter.model.*;
import BE219Thenextchapter.repository.*;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.*;
import de.dhbw.ravensburg.wp.be219thenextchapter.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

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

        //Bushaltestellen
        BusStop busStop_1 = new BusStop("Gartenweg");
        BusStop busStop_2 = new BusStop("Bahnhof");
        BusStop busStop_3 = new BusStop("Robert-Bosch-Straße");

        //Buslinien anlegen
        BusLine busLine_1 = new BusLine(1, 15, LocalTime.of(7,00,00), LocalTime.of(21,00,00), busStop_1, busStop_3);
        BusLine busLine_2 = new BusLine(2, 60, LocalTime.of(5,00,00), LocalTime.of(23,00,00), busStop_1, busStop_2);
        BusLine busLine_3 = new BusLine(3, 45, LocalTime.of(9, 20, 00), LocalTime.of(22, 00,00), busStop_3, busStop_2);

        //Busse
        Bus bus_1 = new Bus();
        Bus bus_2 = new Bus();
        Bus bus_3 = new Bus();

        //Ankunftszeiten
        ArrivingTime arrivingTime_1 = new ArrivingTime(LocalTime.of(7,30, 00));
        arrivingTime_1.setBusStop(busStop_1);
        ArrivingTime arrivingTime_2 = new ArrivingTime(LocalTime.of(9,30, 00));
        ArrivingTime arrivingTime_3 = new ArrivingTime(LocalTime.of(10,20, 00));

        //Busfahrpläne
        BusPlan busPlan_1 = new BusPlan(busLine_1, bus_1, arrivingTime_1);
        BusPlan busPlan_2 = new BusPlan(busLine_1, bus_1, arrivingTime_2);
        BusPlan busPlan_3 = new BusPlan(busLine_1, bus_1, arrivingTime_3);

        //Zuweisung einer Buslinie zu den Fahrplaneinträgen
        busLine_1.setBusPlan(Arrays.asList(busPlan_1, busPlan_2));
        busLine_2.setBusPlan(Arrays.asList(busPlan_2, busPlan_3));
        busLine_3.setBusPlan(Arrays.asList(busPlan_1, busPlan_2, busPlan_3));

        //Zuweisung der Busse zum Busfahrplan
        bus_1.setBusPlan(Arrays.asList(busPlan_1, busPlan_2));
        bus_2.setBusPlan(Arrays.asList(busPlan_1, busPlan_3));
        bus_3.setBusPlan(Arrays.asList(busPlan_2, busPlan_3));

        //List<BusStop> stops = busStopRepository.saveAll(Arrays.asList(busStop_1, busStop_2,busStop_3));
        //busRoute_1.setInvolvedStops(Arrays.asList(busStop_1, busStop_2,busStop_3));
        /*busStop_1.getStoppingBusRoutes().add(busRoute_1);
        busStop_2.getStoppingBusRoutes().add(busRoute_1);
        busStop_3.getStoppingBusRoutes().add(busRoute_1);*/


        //Abspeichern aller Daten in den Repositories
        //this.busStopRepository.saveAll(Arrays.asList(busStop_1, busStop_2, busStop_3));
        this.busLineRepository.saveAll(Arrays.asList(busLine_1, busLine_2, busLine_3));
      //  this.arrivalTimeRepository.saveAll(Arrays.asList(arrivalTime_1, arrivalTime_2, arrivalTime_3));
        //this.busScheduleRepository.saveAll(Arrays.asList(busSchedule_1, busSchedule_2, busSchedule_3));
       // this.busRepository.saveAll(Arrays.asList(bus_1, bus_2, bus_3));



        //log.info(String.valueOf(busScheduleRepository.findAll()));

        List<BusStop> busStops = this.busStopRepository.findAllBusStopsByBusRouteId(busLine_1.getBusLineId());

        for (BusStop bs : busStops) {
            log.info(bs.getStreet());
        }

        List<Bus> busses = this.busRepository.findBussesByBusLine(busLine_1.getBusLineId());

        for (Bus b : busses) {
            log.info(b.toString());
        }

        BusStop busStop = this.arrivingTimeRepository.findBusStopByArrivingTime(bus_1.getId());

        log.info(busStop.getStreet());

       //busRouteRepository.findBusStopsById(3).forEach(BusStop->log.info(BusStop.getName()));
    }
}
