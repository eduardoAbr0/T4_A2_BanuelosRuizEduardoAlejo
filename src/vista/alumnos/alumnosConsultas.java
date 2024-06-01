package vista.alumnos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alumnosConsultas extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnConsultar, btnLimpiar;
    JTable tbAuto;
    DefaultTableModel tableModel = new DefaultTableModel();
    //DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();

    public alumnosConsultas(){
        super("Consultas alumnos", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        setResizable(false);

        JLabel txID = new JLabel("Numero de control: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        txtID = new JTextField(15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        agregarComp(txtID,1,0,1,2,1,1);
        add(txtID, gbc);

        btnConsultar = new JButton("Consultar alumno");
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                Empleado emp = daoEmpleado.buscar(Integer.valueOf(txtID.getText()));

                if (emp == null){
                    JOptionPane.showMessageDialog(null, "Error al consultar empleado");
                }else {
                    Object[] empleadoE = {emp.getId(), emp.getNombre(), emp.getPapellido(), emp.getSapellido(), emp.getNumeroCasa(), emp.getCalle(), emp.getColonia(), emp.getCp(), emp.getTelefono(), emp.getTipoEmpleado()};
                    tableModel.addRow(empleadoE);
                    tbEmpleado = new JTable(tableModel);
                }
                */
            }
        });
        agregarComp(btnConsultar,0,1,1,1,1,1);
        gbc.fill = GridBagConstraints.NONE;
        getContentPane().add(btnConsultar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,1,1,1,1,1);
        getContentPane().add(btnLimpiar, gbc);

        tableModel.addColumn("Numero_Control");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Primer_ap");
        tableModel.addColumn("Segundo_ap");
        tableModel.addColumn("Fecha_nac");
        tableModel.addColumn("Edad");
        tableModel.addColumn("Semestre");
        tableModel.addColumn("Carrera");

        tbAuto = new JTable(tableModel);
        JScrollPane jsCl = new JScrollPane(tbAuto);
        agregarComp(jsCl,0,2,2,2,1,4);
        gbc.fill = GridBagConstraints.BOTH;
        add(jsCl, gbc);

        setVisible(true);
    }

    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;

        gbl.setConstraints(c,gbc);
    }
}
