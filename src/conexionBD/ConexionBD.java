package conexionBD;

import java.sql.*;

public class ConexionBD {


    static String x;
    private Connection conexion;
    private Statement statement;
    /* NOTA: es preferible utilizar PreparedStatement para evitar
                SQL INJECTION
     */

    private ResultSet resultSet;

    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/BD_Escuela";

            conexion = DriverManager.getConnection(URL, "root", "pizza");

        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en el DRIVER");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en la URL");
        }
    }

    //metodo para operaciones ABC (Altas, Bajas y Cambios)
                                    //(Data Manipulation Language)
    public boolean ejecutarInstruccionDML(String instruccionSQL){
        System.out.println(instruccionSQL);
        boolean res = false;
        try {
            statement = conexion.createStatement();
            if( statement.executeUpdate(instruccionSQL) >= 1 )
                res = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en instruccion SQL");
        }
        return res;
    }

    //metodo para consultas
    public ResultSet ejecutarConsultaSQL(String instruccionSQL){
        resultSet = null;
        try {
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(instruccionSQL);
        } catch (SQLException e) {
            System.out.println("Error en instrucion SQL");
        }
        return resultSet;
    }

    public static void main(String[] args) {
        new ConexionBD();
    }

}//class
