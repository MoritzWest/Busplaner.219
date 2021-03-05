package de.dhbw.ravensburg.wp.be219thenextchapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusStop {
    @Id
    @GeneratedValue
    private long id;
    private String street;

    @OneToMany(mappedBy= "startBusStop", cascade = CascadeType.ALL)
    private List<BusRoute> busRouteStarts;

    @OneToMany(mappedBy = "endBusStop", cascade = CascadeType.ALL)
    private List<BusRoute> busRouteEnds;

    //Eine Haltestelle kann von mehreren Buslinien bedient werden
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.ALL) //Tabellendef:Bushaltestelle ist der Eigner der Beziehung mit BusRoute
    private List<ArrivalTime> arrivalTimes;

    //Konstruktor
    public BusStop (String street){
        this.street = street;
 }

}
