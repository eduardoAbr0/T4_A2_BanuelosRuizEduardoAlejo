package vista.alumnos;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class alumnosInt extends JPanel{
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnMostrarAlumnos, btnRestablecer, btnBuscar, btnModificar;
    JTable tbAlumnos;
    JPanel panelTool;
    JDesktopPane ABCC = new JDesktopPane();
    ArrayList<Alumno> listEmp;
    DefaultTableModel modelAlum = new DefaultTableModel();
    AlumnoDAO daoAlumno = new AlumnoDAO();
    public alumnosInt() {
        setLayout(gbl);

        //OPCIONES DE ABCC EN PARTE SUPERIOR
        panelTool = new JPanel();
        panelTool.setLayout(new FlowLayout());
        panelTool.add(btnAgregar = new JButton("Agregar"));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new alumnoAlta());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnEliminar = new JButton("Eliminar"));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new alumnosBajas());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnModificar = new JButton("Modificar"));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new alumnosCambios());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnBuscar = new JButton("Buscar"));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new alumnosConsultas());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnRestablecer = new JButton("Restablecer"));

        agregar(0,0,1,1,1,1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(panelTool, gbc);

        //CONSULTA DE TODOS LOS ALUMNOS
        btnMostrarAlumnos = new JButton("Actualizar/Mostrar alumnos");
        btnMostrarAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelAlum.setRowCount(0);

                listEmp = daoAlumno.mostrarAlumnos();

                for(Alumno alumno : listEmp){
                    modelAlum.addRow(new Object[]{alumno.getNumControl(), alumno.getNombre(), alumno.getPrimerAp(), alumno.getSegundoAp(), alumno.getEdad(), alumno.getSemestre(), alumno.getCarrera()});
                }
                tbAlumnos.setModel(modelAlum);


            }
        });
        //TABLA PARA MOSTRAR DATOS ALUMNOS
        String alumnos[] = {"Num_Control","Nombre","Primer_Ap","Segundo_Ap","Fecha_Nac","Edad","Semestre","Carrera"};
        for (String col: alumnos){
            modelAlum.addColumn(col);
        }
        tbAlumnos = new JTable(modelAlum);
        JScrollPane jsCl = new JScrollPane(tbAlumnos);
        agregar(0,3,1,1,1,1);
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMostrarAlumnos, gbc);
        JLabel txtTablaAutos = new JLabel("Tabla alumnos");
        agregar(0,4,1,1,1,1);
        gbc.anchor = GridBagConstraints.SOUTH;
        add(txtTablaAutos, gbc);


        gbc.fill = GridBagConstraints.BOTH;
        agregar(jsCl,0,5,1,2,3,1);

        agregar(0,1,2,2,4,4);
        gbc.fill = GridBagConstraints.BOTH;
        add(ABCC,gbc);

    }
    public void agregar(JComponent c, int x, int y, int altura, int anchura, int wx, int wy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anchura;
        gbc.gridheight = altura;
        gbc.weightx = wx;
        gbc.weighty = wy;

        add(c, gbc);
    }

    public void agregar( int x, int y, int altura, int anchura, int wx, int wy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anchura;
        gbc.gridheight = altura;
        gbc.weightx = wx;
        gbc.weighty = wy;

    }

}
