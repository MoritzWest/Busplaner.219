package BE219Thenextchapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author Stefanie Grösch
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Jeder Busfahrplan ist einer Buslinie zugeordnet
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "busLine")
    @JsonIgnoreProperties("busPlans")
    private BusLine busLine;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bus")
    @JsonIgnoreProperties("busPlans")
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
