package vista.alumnos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alumnosInt extends JPanel{
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnMostrarAlumnos, btnMostrarEncuestas, btnRestablecer, btnBuscar, btnEncuesta, btnModificar;
    JTable tbAutos, tbEncuestas;
    JPanel panelTool;
    JDesktopPane ABCC = new JDesktopPane();
    //ArrayList<Empleado> listEmp;
    DefaultTableModel modelAlum = new DefaultTableModel();
    //DAOClienteImpl daoCliente = new DAOClienteImpl()            ;
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
                //ABCC.add(new cambiosAutos());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnBuscar = new JButton("Buscar"));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABCC.add(new consultasAutos());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnRestablecer = new JButton("Restablecer"));

        agregar(0,0,1,1,1,1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(panelTool, gbc);

        //CONSULTA DE TODOS LOS CLIENTES
        btnMostrarAlumnos = new JButton("Actualizar alumnos");
        btnMostrarAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                listEmp = daoEmpleado.buscarTodos();

                for(Empleado emp: listEmp){
                    modelClientes.addRow(new Object[]{emp.getId(),emp.getNombre(),emp.getPapellido(),emp.getSapellido(),emp.getNumeroCasa(),emp.getCalle(),emp.getColonia(),emp.getCp(),emp.getTelefono()});
                }
                tbClientes.setModel(modelClientes);

                 */
            }
        });
        //TABLA PARA MOSTRAR DATOS CLIENTES
        String autos[] = {"Num_Control","CURP","Nombre","Primer_Ap","Segundo_Ap","Fecha_Nac","Edad","Semestre","Carrera"};
        for (String col: autos){
            modelAlum.addColumn(col);
        }
        tbAutos = new JTable(modelAlum);
        JScrollPane jsCl = new JScrollPane(tbAutos);
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
