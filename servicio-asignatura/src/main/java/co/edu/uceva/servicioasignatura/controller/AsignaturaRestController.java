package co.edu.uceva.servicioasignatura.controller;

import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import co.edu.uceva.servicioasignatura.model.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/asignatura-service")
public class AsignaturaRestController {
    private IAsignaturaService asignaturaService;

    @Autowired
    public AsignaturaRestController(IAsignaturaService asignaturaService){
        this.asignaturaService = asignaturaService;
    }


    //funcion listar que usa AsignaturaService
    @GetMapping("/asignaturas")
    public List<Asignatura> listar(){
        return this.asignaturaService.findAll();
    }

    //TODO funcion buscar,actualizar, eliminar

}
