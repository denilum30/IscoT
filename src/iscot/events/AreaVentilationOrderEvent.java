package iscot.events;

import iscot.enums.Areas;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent {

private final boolean on; //true se for ligar a ventilação, false se for desligar

public AreaVentilationOrderEvent(Areas area, boolean on){
super(area);
this.on = on;   
}

public boolean isOn() {
    return on;
}

@Override 

public String toString() {
    return "AreaVentilationOrderEvent[" + getArea() + ", on=" + on + "]";
}
}
