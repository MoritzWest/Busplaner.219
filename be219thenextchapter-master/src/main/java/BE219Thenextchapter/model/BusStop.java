package BE219Thenextchapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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
    private List<BusLine> busLineStarts;

    @OneToMany(mappedBy = "endBusStop", cascade = CascadeType.ALL)
    private List<BusLine> busLineEnds;

    //Eine Haltestelle kann von mehreren Buslinien bedient werden
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.ALL) //Tabellendef:Bushaltestelle ist der Eigner der Beziehung mit BusRoute
    private List<ArrivingTime> arrivingTimes;

    //Konstruktor
    public BusStop (String street){
        this.street = street;
 }

}
