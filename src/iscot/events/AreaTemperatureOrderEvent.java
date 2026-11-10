package iscot.events;

import iscot.enums.Areas;
import iscot.enums.AirConditioningMode;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private final AirConditioningMode mode;
    private final double targetTemperature;

    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, double targetTemperature) {
        super(area);
        this.mode = mode;
        this.targetTemperature = targetTemperature;
    }

    public AirConditioningMode getMode() { return mode; }
    public double getTargetTemperature() { return targetTemperature; }

    @Override
    public String toString() {
        return "AreaTemperatureOrderEvent[" + getArea() + ", " + mode + ", " + targetTemperature + "]";
    }
}