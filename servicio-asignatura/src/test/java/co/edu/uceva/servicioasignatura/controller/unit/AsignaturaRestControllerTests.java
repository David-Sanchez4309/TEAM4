package co.edu.uceva.servicioasignatura.controller.unit;

import co.edu.uceva.servicioasignatura.controller.AsignaturaRestController;
import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import co.edu.uceva.servicioasignatura.model.service.IAsignaturaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AsignaturaRestControllerTests {
    private MockMvc mockMvc;


    @Mock
    private IAsignaturaService asignaturaService;

    @InjectMocks
    private AsignaturaRestController asignaturaRestController;

    @Before
    public void setup(){mockMvc= MockMvcBuilders.standaloneSetup(asignaturaRestController).build();
    }
    @Test
    public void listar_returnsListaAsignatura()throws Exception{
        Asignatura asignatura1 = new Asignatura();
        Asignatura asignatura2 = new Asignatura();
        asignatura1.setNombre("matematicas 1");
        asignatura1.setDescripcion("calculo 1 e introducciones");
        asignatura2.setNombre("historia");
        asignatura2.setDescripcion("'Estudio de los eventos pasados y su influencia en el presente");
        List<Asignatura> todasLasAsignaturas = Arrays.asList(asignatura1, asignatura2);
        when(asignaturaService.findAll()).thenReturn(todasLasAsignaturas);

        mockMvc.perform(get("/api/asignatura-service/asignatura"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("matematicas 1")))
                .andExpect(jsonPath("$[1].nombre", is("historia")));

        verify(asignaturaService).findAll();
    }
}
