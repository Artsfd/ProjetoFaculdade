public class Assento {
    private Integer codigoAssento;
    private Integer codigoOnibus;
    private Integer numeroAssento;

    public Assento(Integer codigoAssento, Integer codigoOnibus, Integer numeroAssento) {
        this.codigoAssento = codigoAssento;
        this.codigoOnibus = codigoOnibus;
        this.numeroAssento = numeroAssento;
    }

    // Getters e Setters
    public Integer getCodigoAssento() {
        return codigoAssento;
    }

    public void setCodigoAssento(Integer codigoAssento) {
        this.codigoAssento = codigoAssento;
    }

    public Integer getCodigoOnibus() {
        return codigoOnibus;
    }

    public void setCodigoOnibus(Integer codigoOnibus) {
        this.codigoOnibus = codigoOnibus;
    }

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }
}
