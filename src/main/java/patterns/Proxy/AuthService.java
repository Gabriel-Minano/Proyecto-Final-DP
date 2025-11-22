package patterns.Proxy;

import dao.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService extends ConexionMySQL {

    public boolean login(String usuario, String contrasenha) {
        String sql = "SELECT COUNT(*) FROM administradores WHERE usuario=? AND contrasenha=?";

        try (Connection conn = getConexion(); 
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, contrasenha);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error en AuthService.Login: " + e.getMessage());
        }

        return false;
    }
}
