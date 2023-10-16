
package conexiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexionDB {

    
    public static void main(String[] args) {
        String url = "jdbc:mariadb://127.0.0.1:3306/mostrar+";
        String usuario = "root";
        String contraseña = "1234";

        Connection conexion = null;
        try {
            
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");

                
                String consultaSQL = "SELECT * FROM mostrar2";
                Statement statement = conexion.createStatement();
                ResultSet resultado = statement.executeQuery(consultaSQL);

                while (resultado.next()) {
                    String columna1 = resultado.getString("ID");
                    String columna2 = resultado.getString("Producto");
                    String columna3 = resultado.getString("Cantidad");
                    String columna4 = resultado.getString("Precio");
                    System.out.println("ID: " + columna1 +", Producto: " + columna2 + ", Cantidad: " + columna3 +", Precio: " + columna4);
                }

             
                resultado.close();
                statement.close();
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
}
