public class Onibus {
    private Integer codigoOnibus;
    private String placa;
    private Integer quantidadeAssentos;

    public Onibus(Integer codigoOnibus, String placa, Integer quantidadeAssentos) {
        this.codigoOnibus = codigoOnibus;
        this.placa = placa;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    // Getters e Setters
    public Integer getCodigoOnibus() {
        return codigoOnibus;
    }

    public void setCodigoOnibus(Integer codigoOnibus) {
        this.codigoOnibus = codigoOnibus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(Integer quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }
}
