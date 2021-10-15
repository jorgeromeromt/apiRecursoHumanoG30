package co.usa.recursohumano.recursohumano.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.recursohumano.recursohumano.model.Empleado;
import co.usa.recursohumano.recursohumano.repository.crud.EmpleadoCrudRepositorio;

@Repository
public class EmpleadoRepositorio {
    @Autowired
    private EmpleadoCrudRepositorio empleadoCrudRepositorio;

    public List<Empleado> getAll(){ //lista todo
        return (List<Empleado>)empleadoCrudRepositorio.findAll();
    }

    public Optional<Empleado>getEmpleado(int id){ //Lista mediante un ID
        return empleadoCrudRepositorio.findById(id);
    }

    public Empleado save(Empleado empleado){ //Guarda
        return empleadoCrudRepositorio.save(empleado);
    }
}
