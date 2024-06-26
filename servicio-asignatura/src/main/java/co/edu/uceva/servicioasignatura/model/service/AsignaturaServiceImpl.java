package co.edu.uceva.servicioasignatura.model.service;

import co.edu.uceva.servicioasignatura.model.dao.IAsignaturaDao;
import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{

    IAsignaturaDao asignaturaDao;
   @Autowired
   public AsignaturaServiceImpl(IAsignaturaDao asignaturaDao) {
       this.asignaturaDao = asignaturaDao;
   }



    @Override
    public Asignatura delete(Asignatura asignatura) {
         this.asignaturaDao.delete(asignatura);
        return asignatura;
    }

    @Override
    public List<Asignatura> findAll() {return (List<Asignatura>) asignaturaDao.findAll(); }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaDao.save(asignatura);
    }

    @Override
    public Asignatura findById(Long id) {
        return asignaturaDao.findById(id).orElse(null);
    }

    @Override
    public Asignatura findByOvaId(String ovaId) {
        return asignaturaDao.findByOvaId(ovaId);
    }

    @Override
    public Asignatura update(Asignatura asignatura) {
        return asignaturaDao.save(asignatura);
    }
}
