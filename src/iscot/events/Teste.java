package iscot.events;
import iscot.enums.Areas;

public class Teste {
    public static void main(String[] args) {
        Event e = new HumiditySensorEvent(Areas.Kitchen, 63.0); 
        System.out.println(e);
        System.out.println(e instanceof SensorEvent);          // true
        System.out.println(e instanceof HighLevelOrderEvent);  // false
        System.out.println(e.getTimestamp());
    }
}
