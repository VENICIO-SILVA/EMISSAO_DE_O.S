package br.com.project.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Timer;

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

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "idcli")
    private Clientes cliente;


}
