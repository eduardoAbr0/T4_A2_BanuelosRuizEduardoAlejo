package vista;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VetnanaInicio extends JFrame{
    BorderLayout bl = new BorderLayout();
    CardLayout cl = new CardLayout();
    JPanel barraArriba, general, opciones;
    JButton btnClientes, btnAlumnos, btnCursos, btnDocentes;

    public VetnanaInicio() {
        //CONFIGURACIONES INICIALES DEL JFRAME
        getContentPane().setLayout(bl);
        setTitle("Escuela");
        setMinimumSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREACION PANELES GENERALES PARA LA PARTE SUPERIOR, CENTRO E IZQUIERDA
        barraArriba = new JPanel();
        //USO DE CARD LAYOUT PARA ACCEDER LOS DIFERENTES SUBPANELES EN EL MISMO AREA(CENTER)
        general = new JPanel(cl);
        opciones = new JPanel();
        //CREACION DE SUBPANELES PARA LA PARTE CENTRAL DEL PANEL GENERAL
        //panelAlumnos pnlAlum = new panelAlumnos();

        //general.add(pnlAlum,"ALUMNOS");

        //PERSONALIZACION BASICA DE COLORES PARA IDENTIFICAR
        barraArriba.setBackground(Color.LIGHT_GRAY);
        general.setBackground(Color.GRAY);
        opciones.setBackground(Color.BLACK);

        //CONFIGURACION TAMANOS Y ESPECIFICACIONES PARA LAYOUT EN EL PANEL
        barraArriba.setPreferredSize(new Dimension(0, 200));
        opciones.setPreferredSize(new Dimension(200, 0));
        opciones.setLayout(new GridLayout(4, 0));

        //CREACION Y CONFIGURACION DE BOTONES DE LA PARTE IZQUIERDA, QUE SERAN
        //DE USO PARA ACCEDER A LOS DIFERENTES SUBPANELES
        btnAlumnos = new JButton("Alumnos");    
        btnAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "ALUMNOS");
            }
        });
        opciones.add(btnAlumnos);
        btnClientes = new JButton("Asignaturas");
        opciones.add(btnClientes);

        btnCursos = new JButton("Cursos");
        opciones.add(btnCursos);

        btnDocentes = new JButton("Docentes");
        opciones.add(btnDocentes);

        //SE AGREGAN LOS PANELES PARA LA PARTE SUPERIOR , CENTRAL E IZQUIERDA DEL BORDER LAYOUT
        add(barraArriba, BorderLayout.NORTH);
        add(general, BorderLayout.CENTER);
        add(opciones, BorderLayout.WEST);

        //DEMAS CONFIGURACIONES DEL JFRAME
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VetnanaInicio();
    }
}
