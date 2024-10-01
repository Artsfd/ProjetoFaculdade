import java.util.Date;

public class Viagem {
    private Integer codigoViagem;
    private Integer codigoOnibus;
    private String cidadeOrigem;
    private Date dataSaida;
    private String horarioSaida;
    private String cidadeDestino;
    private Date dataChegada;
    private String horarioChegada;
    private Double valorPassagem;

    public Viagem(Integer codigoViagem, Integer codigoOnibus, String cidadeOrigem, Date dataSaida,
                  String horarioSaida, String cidadeDestino, Date dataChegada, String horarioChegada,
                  Double valorPassagem) {
        this.codigoViagem = codigoViagem;
        this.codigoOnibus = codigoOnibus;
        this.cidadeOrigem = cidadeOrigem;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.cidadeDestino = cidadeDestino;
        this.dataChegada = dataChegada;
        this.horarioChegada = horarioChegada;
        this.valorPassagem = valorPassagem;
    }

    // Getters e Setters
    public Integer getCodigoViagem() {
        return codigoViagem;
    }

    public void setCodigoViagem(Integer codigoViagem) {
        this.codigoViagem = codigoViagem;
    }

    public Integer getCodigoOnibus() {
        return codigoOnibus;
    }

    public void setCodigoOnibus(Integer codigoOnibus) {
        this.codigoOnibus = codigoOnibus;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(String horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public Double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(Double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }
}
