/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.PostgreSQL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author PC
 */
public class RegistrosPostgres {
    private static String  ENCRYPT_KEY="password";
    PostgreSQL postgres;
    BufferedReader reader;
    String nombreEmpleado, apellidoEmpleado, usuario, pass;
    String nombreActor, fechaNActor;
    String tituloPelicula, AñoPelicula;
    String nomCategoria;

    public RegistrosPostgres() {
        postgres = new PostgreSQL();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void RegistrarEmpleados() {
        System.out.println("Empleados");
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("Digite el nombre");
                nombreEmpleado = reader.readLine();
                System.out.println("Digite el Apellido");
                apellidoEmpleado = reader.readLine();
                usuario = nombreEmpleado.substring(0,2) + apellidoEmpleado.substring(apellidoEmpleado.length()-3,apellidoEmpleado.length()).toUpperCase()+i;
                pass = encriptar(usuario);
                postgres.registrarEmpleados(i+"", nombreEmpleado, apellidoEmpleado, usuario, pass);
            } catch (IOException ex) {
                Logger.getLogger(RegistrosPostgres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String encriptar(String mensaje){
        char array[] = mensaje.toCharArray();
        
        for(int i = 0 ; i < array.length ; i++ ){
            array[i] = (char)(array[i]+(char)5);
        }
        String encriptado = String.valueOf(array);
        return encriptado;
    }   
}
