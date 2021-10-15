package co.usa.recursohumano.recursohumano.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Representa la tabla

@Entity
@Table(name="departamento")
public class Departamento implements Serializable{
    //campo llave primaria y autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombreDepartamento;
    private Date fechaCreacionDate;
    
    //Realizamos la relación
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "departamento") //mapea a atributo que está en la otra tabla
    @JsonIgnoreProperties("departamento")
    private List<Empleado> empleados;

    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public Date getFechaCreacionDate() {
        return fechaCreacionDate;
    }
    public void setFechaCreacionDate(Date fechaCreacionDate) {
        this.fechaCreacionDate = fechaCreacionDate;
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    
}
