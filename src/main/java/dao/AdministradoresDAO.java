package dao;

import java.sql.Connection;
import model.Administradores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradoresDAO implements IBaseDAO<Administradores> {

    private final Connection conn;

    public AdministradoresDAO() {
        this.conn = ConexionMySQL.getInstancia().getConexion();
    }

    @Override
    public boolean create(Administradores input) {
        String SQL = "INSERT INTO administradores (usuario, contrasenha) VALUES (?,?)";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setString(1, input.getUsuario());
            pst.setString(2, input.getContrasenha());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AdministradoresDAO.Create: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Administradores read(int id) {
        String SQL = "SELECT * FROM administradores WHERE id_admin=?";
        Administradores admin = null;

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                admin = new Administradores();
                admin.setId_admin(id);
                admin.setUsuario(res.getString("usuario"));
                admin.setContrasenha(res.getString("contrasenha"));
            }

        } catch (SQLException e) {
            System.out.println("Error en AdministradoresDAO.Read: " + e.getMessage());
        }

        return admin;
    }

    @Override
    public List<Administradores> readall() {
        List<Administradores> lista = new ArrayList<>();
        String SQL = "SELECT id_admin, usuario, contrasenha FROM administradores";

        try (PreparedStatement pst = conn.prepareStatement(SQL); ResultSet res = pst.executeQuery()) {

            while (res.next()) {
                Administradores admin = new Administradores();
                admin.setId_admin(res.getInt("id_admin"));
                admin.setUsuario(res.getString("usuario"));
                admin.setContrasenha(res.getString("contrasenha"));
                lista.add(admin);
            }

        } catch (SQLException e) {
            System.out.println("Error en AdministradoresDAO.ReadAll: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean update(Administradores input) {
        String SQL = "UPDATE administradores SET usuario=?, contrasenha=? WHERE id_admin=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setString(1, input.getUsuario());
            pst.setString(2, input.getContrasenha());
            pst.setInt(3, input.getId_admin());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AdministradoresDAO.Update: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String SQL = "DELETE FROM administradores WHERE id_admin=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AdministradoresDAO.Delete: " + e.getMessage());
            return false;
        }
    }
}
