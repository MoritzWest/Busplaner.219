package de.dhbw.ravensburg.wp.be219thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusSchedule {

    @Id
    @GeneratedValue
    private long id;

    //Jeder Busfahrplan ist einer Buslinie zugeordnet
    @ManyToOne(cascade = CascadeType.PERSIST)
    private BusRoute busRoute;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bus bus;

    @OneToOne(cascade = CascadeType.ALL)
    private ArrivalTime arrivalTimeEntry;


    //Konstruktor
    public BusSchedule(BusRoute busRoute, Bus bus, ArrivalTime arrivalTimeEntry) {
        this.busRoute = busRoute;
        this.bus = bus;
        this.arrivalTimeEntry = arrivalTimeEntry;
    }


    //public void addArrivalTime(Timestamp time){ // alle arrivaltimes addiert ergeben die Ankunftszeit an letzen Haltestelle
    // arrivalTime.add(time);
    //}
    /*public BusSchedule(Timestamp startTimeAtFirstStop) {
        this.startTimeAtFirstStop = startTimeAtFirstStop;
    }

  /*  @Id
    @GeneratedValue
    private long id;

    private Timestamp startTimeAtFirstStop; // Timestamp: Tag/Std/Min  //raus?
    private List<Timestamp> arrivalTime; //Liste mit den Ankunftszeiten der Bulinie an den versch. Haltestellen
    private List<BusStop> routeStops;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "busRoute_id")
    private BusRoute busRoute;

    //public void addArrivalTime(Timestamp time){ // alle arrivaltimes addiert ergeben die Ankunftszeit an letzen Haltestelle
       // arrivalTime.add(time);
    //}

    public BusSchedule(Timestamp startTimeAtFirstStop) {
        this.startTimeAtFirstStop = startTimeAtFirstStop;
    } */
}
