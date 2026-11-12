package iscot.events;

import iscot.enums.Areas;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {

private final boolean on; //true se for ligar a luz, false se for desligar

public AreaLightingOrderEvent(Areas area, boolean on){
super(area);
this.on = on;
}

public boolean isOn() {
    return on;

}

@Override 

public String toString() {
    return "AreaLightingOrderEvent[" + getArea() + ", on=" + on + "]";

}
}
