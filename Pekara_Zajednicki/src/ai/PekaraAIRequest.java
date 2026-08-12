package ai;

import java.io.Serializable;
import java.util.List;

public class PekaraAIRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> imenaPeciva;
    private String tipDogadjaja;
    private int brojGostiju;

    public PekaraAIRequest() {}

    public PekaraAIRequest(List<String> imenaPeciva, String tipDogadjaja, int brojGostiju) {
        this.imenaPeciva = imenaPeciva;
        this.tipDogadjaja = tipDogadjaja;
        this.brojGostiju = brojGostiju;
    }

    public List<String> getImenaPeciva() {
        return imenaPeciva;
    }

    public void setImenaPeciva(List<String> imenaPeciva) {
        this.imenaPeciva = imenaPeciva;
    }

    public String getTipDogadjaja() {
        return tipDogadjaja;
    }

    public void setTipDogadjaja(String tipDogadjaja) {
        this.tipDogadjaja = tipDogadjaja;
    }

    public int getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(int brojGostiju) {
        this.brojGostiju = brojGostiju;
    }

    
   


}
    

