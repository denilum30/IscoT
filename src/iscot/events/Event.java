package iscot.events;

import java.io.Serializable; //necessária para converter o objeto em bytes
import java.time.LocalDateTime; //Lidar com datas e hnoras
import iscot.enums.Areas; //enumerador que contém as áreas válidas do sistema (vai estar noutro ficheiro)

public abstract class Event implements Serializable {

  private final Areas area; //guardar a área do evento. uma vez atribuída, não pode ser modificada (final)
  private final LocalDateTime timestamp = LocalDateTime.now(); //momento em que o evento é criado na memória.
  
  //construtor protegido, só classes do mesmo pactote ou subclasses de Event podem aceder a este construtor. 
  //A ideia é que só subclasses de Event possam ser instanciadas, e não Event diretamente.

  protected Event(Areas area) { //recebe area como argumento e guarda na variavel da classe
    this.area = area;

  }
//getters que permitem ler a area e o momento do evento a partir do exterior

  public Areas getArea() { return area; }

  public LocalDateTime getTimestamp() {return timestamp;}

}
