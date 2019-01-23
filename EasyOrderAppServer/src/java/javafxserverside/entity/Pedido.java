/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad clase JPA para datos de pedido. Las propiedades de esta clase son ,
 * Nombre, fecha tramitado, fecha preparado, fecha entregado y estado.
 *
 * @author Leticia Garcia
 */
@Entity
@Table(name = "pedido", schema = "easyorderappdb")
@NamedQueries({
    @NamedQuery(name = "buscarTodosLosPedidos", query = "SELECT p FROM Pedido p ORDER BY p.nombre DESC"
    ),
     @NamedQuery(name = "buscarPedidoDeCliente", query = "SELECT p FROM Pedido p WHERE p.cliente =:cliente"
    )       
})
@XmlRootElement
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Date fechaTramitado;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Date fechaPreparado;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Date fechaEntregado;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    private EstadoPedido estadoPedido;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "PEDIDO_EMPLEADO", schema = "easyorderappdb")
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "pedido", fetch=FetchType.EAGER)
    private List<ProductoPedido> productos;
    
    
    //Cambios de ultimo momento
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Date fechaPedido;
    
    private String horaPedido;
   
    //Getters and setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaTramitado(java.util.Date fechaTramitado) {
        this.fechaTramitado = fechaTramitado;
    }

    public void setFechaPreparado(java.util.Date fechaPreparado) {
        this.fechaPreparado = fechaPreparado;
    }

    public void setFechaEntregado(java.util.Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public java.util.Date getFechaTramitado() {
        return fechaTramitado;
    }

    public java.util.Date getFechaPreparado() {
        return fechaPreparado;
    }

    public java.util.Date getFechaEntregado() {
        return fechaEntregado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
       @XmlTransient
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<ProductoPedido> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoPedido> productos) {
        this.productos = productos;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public String getHora() {
        return horaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setHora(String horaPedido) {
        this.horaPedido = horaPedido;
    }
    
    
    
    
    

    //Metodoak
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxserverside.entity.Pedido[ id=" + id + " ]";
    }

}
