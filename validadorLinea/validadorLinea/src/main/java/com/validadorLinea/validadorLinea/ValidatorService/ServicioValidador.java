package com.validadorLinea.validadorLinea.ValidatorService;

import com.validadorLinea.validadorLinea.ValidadorLinea.FileCsv;
import com.validadorLinea.validadorLinea.ValidadorLinea.FileExcel;
import com.validadorLinea.validadorLinea.ValidadorLinea.ValidadorLinea;

import java.util.List;

public class ServicioValidador {


    private String contadorLineaInvalida = "0";

    public ServicioValidador() {

    }

    public String getContadorLineaInvalida() {
        return contadorLineaInvalida;
    }


    public boolean validar(String linea) {

        ValidadorLinea validadorLinea;
        String[] partes = linea.split(",");
        String primerCampo = partes[0];
        if(primerCampo.equalsIgnoreCase("csv")){

            validadorLinea = new FileCsv();
            return validadorLinea.validar(linea);

        }else if(primerCampo.equalsIgnoreCase("xlsx")){
           validadorLinea=new FileExcel();
            return validadorLinea.validar(linea);
        }



        return false;
    }
}
