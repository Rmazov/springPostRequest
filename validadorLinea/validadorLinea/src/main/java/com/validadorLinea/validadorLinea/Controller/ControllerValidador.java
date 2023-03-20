package com.validadorLinea.validadorLinea.Controller;

import com.validadorLinea.validadorLinea.ValidatorService.ServicioValidador;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControllerValidador {

    private ServicioValidador servicioValidador;

    public ControllerValidador(){
        this.servicioValidador = new ServicioValidador();
        //@services
    }
//    @Autowired
//    public void ControllerValidador(ServicioValidador servicioValidador){
//        this.servicioValidador = servicioValidador;
//    }
//

    @PostMapping("/archivo/validar")
    public boolean validar(@RequestBody String persona){
        return this.servicioValidador.validar(persona);

    }

}
