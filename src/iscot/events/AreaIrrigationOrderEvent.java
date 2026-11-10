package iscot.events;

import iscot.enums.Areas;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent {

    private final boolean on; //true se for ligar a irrigação, false se for desligar

    public AreaIrrigationOrderEvent(Areas area, boolean on) {
        super(area);
        this.on = on;
    }
public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return "AreaIrrigationOrderEvent[" + getArea() + ", on=" + on + "]";
    }
}
