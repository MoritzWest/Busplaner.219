package BE219Thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusPlan {

    @Id
    @GeneratedValue
    private long id;

    //Jeder Busfahrplan ist einer Buslinie zugeordnet
    @ManyToOne(cascade = CascadeType.PERSIST)
    private BusLine busLine;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bus bus;

    @OneToOne(cascade = CascadeType.ALL)
    private ArrivingTime arrivingTimeEntry;


    //Konstruktor
    public BusPlan(BusLine busLine, Bus bus, ArrivingTime arrivingTimeEntry) {
        this.busLine = busLine;
        this.bus = bus;
        this.arrivingTimeEntry = arrivingTimeEntry;
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
    private List<Timestamp> arrivalTime; //Liste mit den Ankunftszeiten der Buslinie an den versch. Haltestellen
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
