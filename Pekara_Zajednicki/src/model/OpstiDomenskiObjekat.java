package model;

import java.sql.ResultSet;

public interface OpstiDomenskiObjekat {

    String vratiVrednostiAtributa();
    String postaviVrednostiAtributa();
    String vratiImeKlase();
    boolean napuni(ResultSet rs, ResultSet rs1);
    boolean napuni(ResultSet rs);
    String vratiUslovZaNadjiSlog();
    String vratiUslovZaNadjiSlogove();
    String vratiAtributPretrazivanja();
    String vratiUslovZaJednog();
    String vratiNaziveAtributa();
    void postaviID(int ID);
    String vratiAlijas();
    String vratiJoin();
    String vratiSelectZaSlozeniSlog();
}

