package co.edu.uceva.servicioasignatura.controller;

import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import co.edu.uceva.servicioasignatura.model.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsignaturaRestController {
    private IAsignaturaService asignaturaService;

    @Autowired
    public AsignaturaRestController(IAsignaturaService asignaturaService){
        this.asignaturaService = asignaturaService;
    }

}
