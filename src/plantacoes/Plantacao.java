package plantacoes;

public class Plantacao {
    private String variedadeAzeitona;
    private String distanciaAteLagar;
    
    public Plantacao(String variedadeAzeitona, String distanciaAteLagar) {
        this.variedadeAzeitona = variedadeAzeitona;
        this.distanciaAteLagar = distanciaAteLagar;
    }

    public String getDistanciaAteLagar() {
        return distanciaAteLagar;
    }
    public String getVariedadeAzeitona() {
        return variedadeAzeitona;
    }
    
}
