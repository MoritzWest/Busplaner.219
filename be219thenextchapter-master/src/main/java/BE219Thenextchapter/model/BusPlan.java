package BE219Thenextchapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


    public BusPlan(BusLine busLine, Bus bus, ArrivingTime arrivingTimeEntry) {
        this.busLine = busLine;
        this.bus = bus;
        this.arrivingTimeEntry = arrivingTimeEntry;
    }
}


