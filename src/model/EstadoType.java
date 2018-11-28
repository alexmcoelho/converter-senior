package model;

public enum EstadoType {

    ORCAMENTO("Orçamento"),
    APROVADO("Aprovado/Em andamento"),
    FINALIZADO("Finalizado"),
    FALTA_PECA("Falta peça"),
    NAO_APROVADO("Não aprovado"),
    SEM_CONSERTO("Sem conserto");

    private String estado;

    EstadoType(String estado) {
        this.setEstado(estado);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



}
