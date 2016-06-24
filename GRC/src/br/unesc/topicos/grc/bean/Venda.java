package br.unesc.topicos.grc.bean;

public class Venda {

    private int id_venda;
    private String referencia;
    private String cpf;
    private String data;
   
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDate() {
        return data;
    }

    public void setDate(String date) {
        this.data = date;
    }    
    
    public int getIdVenda() {
        return id_venda;
    }

    public void setIdVenda(int venda) {
        this.id_venda = venda;
    }

    @Override
    public String toString() {
        return referencia + " - " + convertData(data.split("-"));
    }
    
    public String convertData(String[] data){
        return data[2] + "/" + data[1] + "/" + data[0];
    }
}
