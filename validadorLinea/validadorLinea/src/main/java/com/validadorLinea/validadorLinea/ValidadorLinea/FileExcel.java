package com.validadorLinea.validadorLinea.ValidadorLinea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExcel implements ValidadorLinea{

    @Override
    public boolean validar(String linea)
    {
        String[] partes = linea.split(",");
        String injuryLocation = partes[1];
        String reportType = partes[2];
        //System.out.println(injuryLocation);

        if(
                validateJuryLocation(injuryLocation) && validateReportType(reportType)


        ){

            return true;
        }


        return false;
    }

    public static boolean validateJuryLocation(String location){

        if(location.equals("N/A")){
            return false;
        }
        return true;
    }
    public static boolean validateReportType(String report){

        List<String> types = new ArrayList<>(Arrays.asList("Near Miss","Lost Time","First Aid"));
        if(types.contains(report)){
            return true;
        }
        return false;
    }


    }

