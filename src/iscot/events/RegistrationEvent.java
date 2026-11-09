package iscot.events;

import iscot.enums.Areas; 
import iscot.enums.Type; //define o tipo de registo (sensor ou atuador) que está a ser registado no sistema

public class RegistrationEvent extends Event {
private final Type type; //tipo de registo

//construtor que recebe a area e o tipo de registo como argumentos. O tipo de registo 
// é guardado na variavel type da classe.

    public RegistrationEvent(Areas area, Type type) {
        super(area); //chama o construtor da superclasse Event. LocalDateTime é automaticamente atribuido na superclasse neste momento, 
        // não é necessário passar como argumento.
        this.type = type; //guarda o tipo
    }

    //getter para permitir a letirua do tipo
    public Type getType() { return type;}

    @Override 

    //junta o nome da classe, a area, o momento do evento e o tipo de registo numa string para ser impressa no ecrã.
    public String toString() {
        return "RegistrationEvent{" +
                "area=" + getArea() +
                ", timestamp=" + getTimestamp() +
                ", type=" + type +
                '}';
    }
}


