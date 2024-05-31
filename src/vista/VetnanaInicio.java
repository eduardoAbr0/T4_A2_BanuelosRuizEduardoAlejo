package vista;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.util.ArrayList;

public class VetnanaInicio {

    public static void main(String[] args) {

        //suponer la GUI de la vetnana de ALTAS

        //String nc = cajaNumControl.getText();

        Alumno a = new Alumno("3",
                                "3",
                                "1",
                                "1",
                                        (byte)1,
                                        (byte)1,
                                    "1");
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        if(alumnoDAO.agregarAlumno(a))
            JOptionPane.showMessageDialog(null,
                    "Registro AGREGADO con EXITO!!!!");
        else
            JOptionPane.showMessageDialog(null,
                    "ERROR en la insercion!!!!");

        //--------------------------------- PREUBA CONSULTAS ----------------------------

        ArrayList lista = alumnoDAO.mostrarAlumnos("");

        for(Object alumno : lista)
            System.out.println(alumno);

    }
}
