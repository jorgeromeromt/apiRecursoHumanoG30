package co.usa.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumano.recursohumano.model.Departamento;
import co.usa.recursohumano.recursohumano.repository.DepartamentoRepositorio;

@Service
public class DepartamentoServicio {
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento>getAll(){
        return departamentoRepositorio.getAll();
    }

    public Optional<Departamento>getDepartamento(int id){
        return  departamentoRepositorio.getDepartamento(id);
    }

    public Departamento save (Departamento dpto){
        //Verificamos si el Departamento es nuevo y de se asi se guarda
        if (dpto.getNumId()==null){
            return departamentoRepositorio.save(dpto);
        }else { //Si el objeto viene con un numId verificamos si existe o no
            Optional<Departamento> consulta= departamentoRepositorio.getDepartamento(dpto.getNumId());
            if(consulta.isEmpty()){
                return departamentoRepositorio.save(dpto);

            }else {
                return dpto; //si no viene en blanco, retorna el id.
            }
        }
    }
}
