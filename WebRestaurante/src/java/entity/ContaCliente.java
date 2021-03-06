/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import repository.ContaClienteRepository;

/**
 *
 * @author Lurian V. Serafim
 */
@Entity
public class ContaCliente extends ContaClienteRepository implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ContaCliente;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAbertura;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFechamento;
    private double valorTotal;
    private double valorRecebido;
    private Cliente Cliente;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Mesa mesa;
    
        @OneToMany(fetch = FetchType.LAZY, 
            mappedBy = "contacli", 
            orphanRemoval = true, 
            cascade = CascadeType.ALL)
    private List<ItemContaCli> itens = new ArrayList<>();
        
        
    public void add(ItemContaCli i){
        i.setContacli(this);
        this.getItens().add(i);
    }    

    public ContaCliente() {

    }

    public Integer getContaCliente() {
        return ContaCliente;
    }

    public void setContaCliente(Integer ContaCliente) {
        this.ContaCliente = ContaCliente;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public List<ItemContaCli> getItens() {
        return itens;
    }

    public void setItens(List<ItemContaCli> itens) {
        this.itens = itens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    
}
