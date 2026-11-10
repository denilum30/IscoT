package iscot.events;

import iscot.enums.Areas;

//útil para eventos de ordem de alto nível como 
// a ordem de abrir ou fechar uma porta.
public abstract class HighLevelOrderEvent extends Event{

protected HighLevelOrderEvent (Areas area) {
    super(area); //registar area e hora exata       

}

}
