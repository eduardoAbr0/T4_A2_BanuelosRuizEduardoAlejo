package controlador;

import conexionBD.ConexionBD;
import modelo.Alumno;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {
    ConexionBD conexion = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //===================== METODOS ABCC ==============
    //Metodo de ALTAS ----------------
    public boolean agregarAlumno(Alumno alumno){
        boolean res = false;

        String sql = "INSERT INTO alumnos VALUES('01', '01','Luke', 'Skywalker', '-','1950/10/10', 50, 7, 'ISC')";
        String sql2 = "INSERT INTO alumnos VALUES('"+ alumno.getNumControl()+
                "', '"+alumno.getNumControl()+
                "','"+alumno.getNombre()+
                "', '"+alumno.getPrimerAp()+
                "', '"+alumno.getSegundoAp()+
                "','1950/10/10', "+alumno.getEdad()+
                ", "+alumno.getSemestre()+
                ", '"+alumno.getCarrera()+"')";
        res = conexion.ejecutarInstruccionDML(sql2);
        return res;
        //return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de BAJAS ----------------
    public boolean eliminarAlumno(String numControl){
        String sql = "DELETE FROM alumnos WHERE Num_Control='"+numControl+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de CAMBIOS ----------------
    public boolean actualizarAlumno(Alumno alumno){
        String sql = "UPDATE alumnos SET Nombre='"+alumno.getNombre()+"', Primer_Ap='X', " +
                "Segundo_Ap='X' ....... WHERE Num_Control='"+alumno.getNumControl()+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    public ArrayList mostrarAlumnos(String filtro){
        ArrayList listaAlumnos = new ArrayList();

        String sql = "SELECT * FROM alumnos";
        ResultSet rs = conexion.ejecutarConsultaSQL(sql);
        try{
            rs.next();
            do {
                String nc = rs.getString(1);
                String curp = rs.getString("CURP");
                String n = rs.getString("Nombre");
                String pa = rs.getString("Primer_Ap");
                String sa = rs.getString("Segundo_Ap");
                String f = rs.getString("Fecha_Nac");
                byte e = rs.getByte("Edad");
                byte s = rs.getByte("Semestre");
                String c = rs.getString("Carrera");

                Alumno a = new Alumno(nc, n, pa, sa, e, s, c);
                listaAlumnos.add(a);
            }while(rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaAlumnos;
    }

}//class
