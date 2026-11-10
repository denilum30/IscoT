package iscot.events;
import iscot.enums.Areas;

public class Teste {
    public static void main(String[] args) {
        Event e = new AreaLightingOrderEvent(Areas.Garden, true); 
        System.out.println(e);
        System.out.println(e instanceof SensorEvent);          // deve dar false
        System.out.println(e instanceof HighLevelOrderEvent);  // 
        System.out.println(e.getTimestamp());
    }
}
