package iscot.events;

import iscot.enums.Areas;

public abstract class SensorEvent extends Event{
private final double value; //valor do sensor

protected SensorEvent (Areas area, double value) {
    super(area); //registar area e hora exata
    this.value = value; // guarda o valor
}

 //permite ler o valor do sensor a partir do exterior
public double getValue() { return value;}

@Override 

//vai buscar o nome exato da classe que está a ser executada
public String toString() {
    return getClass().getSimpleName() + "[" 
    + getArea() + ", " + value + "]";

}
}
