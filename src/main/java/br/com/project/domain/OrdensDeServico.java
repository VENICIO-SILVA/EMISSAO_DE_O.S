package br.com.project.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "os")
public class OrdensDeServico {

    @Id
    private int os;

    private Timestamp data_os;

    private String equipamento;

    private String defeito;

    private String servico;

    private String tecnico;

    @Column(name = "preco_servico")
    private Double valor;

    private String status;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idcli")
    private Clientes cliente;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getOs() {
        return os;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public Timestamp getData_os() {
        return data_os;
    }

    public void setData_os(Timestamp data_os) {
        this.data_os = data_os;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
