package controlador;

import conexionBD.ConexionBD;
import modelo.Alumno;

import java.sql.PreparedStatement;
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

        String sql2 = "INSERT INTO alumnos VALUES('"+ alumno.getNumControl()+
                "', '"+alumno.getNombre()+
                "', '"+alumno.getPrimerAp()+
                "', '"+alumno.getSegundoAp()+
                "', '"+alumno.getEdad()+
                "', '"+alumno.getSemestre()+
                "', '"+alumno.getCarrera()+"')";
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
        String sql = "UPDATE alumnos SET Nombre='"+alumno.getNombre()+"'," +
                "Primer_ap='"+alumno.getPrimerAp()+"', " +
                "Segundo_ap='"+alumno.getSegundoAp()+"', " +
                "edad='"+alumno.getEdad()+"', " +
                "semestre='"+alumno.getSemestre()+"', " +
                "carrera='"+alumno.getCarrera()+"' " +
                "WHERE Num_Control='"+alumno.getNumControl()+"'";

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
                String n = rs.getString("Nombre");
                String pa = rs.getString("Primer_Ap");
                String sa = rs.getString("Segundo_Ap");
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

    public Alumno buscarUno(String id)  {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE Num_control = '"+id+"'";
        ResultSet resultSet = null;

        ArrayList listaAlumnos = new ArrayList();
        ResultSet rs = conexion.ejecutarConsultaSQL(sql);
        try{
            rs.next();
            do {
                String nc = rs.getString(1);
                String n = rs.getString("Nombre");
                String pa = rs.getString("Primer_Ap");
                String sa = rs.getString("Segundo_Ap");
                byte e = rs.getByte("Edad");
                byte s = rs.getByte("Semestre");
                String c = rs.getString("Carrera");

                alumno = new Alumno(nc, n, pa, sa, e, s, c);
            }while(rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }

        return alumno;
    }

}//class
