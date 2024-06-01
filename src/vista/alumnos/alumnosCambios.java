package vista.alumnos;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alumnosCambios extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerap, txtSegundoap, txtEdad, txtSemestre, txtCarrera;
    JButton btnCambiar, btnLimpiar;
    Alumno alumno;
    AlumnoDAO daoAlumno = new AlumnoDAO();

    public alumnosCambios(){
        super("Cambios alumnos", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        JLabel txID = new JLabel("Num_Control: ");
        agregarComp(txID,0,1,1,1,1,1);
        add(txID, gbc);
        txtID = new JTextField(10);
        agregarComp(txtID,1,1,1,1,1,1);
        add(txtID, gbc);


        JLabel txPrecio = new JLabel("Nombre: ");
        agregarComp(txPrecio,0,2,1,1,1,1);
        add(txPrecio, gbc);
        txtNombre = new JTextField(10);
        agregarComp(txtNombre,1,2,1,1,1,1);
        add(txtNombre, gbc);

        JLabel txFechaf = new JLabel("Primer ap: ");
        agregarComp(txFechaf,0,3,1,1,1,1);
        add(txFechaf, gbc);
        txtPrimerap = new JTextField(10);
        agregarComp(txtPrimerap,1,3,1,1,1,1);
        add(txtPrimerap, gbc);

        JLabel txPeso = new JLabel("Segundo ap: ");
        agregarComp(txPeso,0,4,1,1,1,1);
        add(txPeso, gbc);
        txtSegundoap = new JTextField(10);
        agregarComp(txtSegundoap,1,4,1,1,1,1);
        add(txtSegundoap, gbc);

        JLabel txColor = new JLabel("Edad: ");
        agregarComp(txColor,0,5,1,1,1,1);
        add(txColor, gbc);
        txtEdad = new JTextField(10);
        agregarComp(txtEdad,1,5,1,1,1,1);
        add(txtEdad, gbc);

        JLabel txCapL = new JLabel("Semestre: ");
        agregarComp(txCapL,0,6,1,1,1,1);
        add(txCapL, gbc);
        txtSemestre = new JTextField(10);
        agregarComp(txtSemestre,1,6,1,1,1,1);
        add(txtSemestre, gbc);

        JLabel txEstado = new JLabel("Carrera: ");
        agregarComp(txEstado,0,7,1,1,1,1);
        add(txEstado, gbc);
        txtCarrera = new JTextField(10);
        agregarComp(txtCarrera,1,7,1,1,1,1);
        add(txtCarrera, gbc);


        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                alumno = new Alumno(txtID.getText(), txtNombre.getText() , txtPrimerap.getText(), txtSegundoap.getText(), (byte)Integer.parseInt(txtEdad.getText()) ,  (byte)Integer.parseInt(txtSemestre.getText()), txtCarrera.getText() );

                if (daoAlumno.actualizarAlumno(alumno)) {
                    JOptionPane.showMessageDialog(null, "Alumno Actualizado Correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al actualizar alumno");
                }

            }
        });
        agregarComp(btnCambiar,0,8,1,1,1,1);
        add(btnCambiar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,8,1,1,1,1);
        add(btnLimpiar, gbc);

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
