package co.usa.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumano.recursohumano.model.Empleado;
import co.usa.recursohumano.recursohumano.repository.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado>getAll(){
        return empleadoRepositorio.getAll();

    }

    public Optional<Empleado>getEmpleado(int id){
        return empleadoRepositorio.getEmpleado(id);
    }

    public Empleado save(Empleado empleado){
        if (empleado.getNumId()==null) {
            return empleadoRepositorio.save(empleado);
        } else {
            Optional<Empleado> consulta = empleadoRepositorio.getEmpleado(empleado.getNumId());
            if (consulta.isEmpty()) {
                return empleadoRepositorio.save(empleado);
            } else {
                return empleado;
            }
        }
    }
}
