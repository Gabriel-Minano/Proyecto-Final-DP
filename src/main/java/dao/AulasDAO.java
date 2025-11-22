package dao;

import java.sql.Connection;
import model.Aulas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulasDAO implements IBaseDAO<Aulas> {

    private final Connection conn;

    public AulasDAO() {
        this.conn = ConexionMySQL.getInstancia().getConexion();
    }

    @Override
    public boolean create(Aulas input) {
        String SQL = "INSERT INTO aulas (grado, seccion) VALUES (?,?)";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setString(1, input.getGrado());
            pst.setString(2, input.getSeccion());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AulasDAO.Create: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Aulas read(int id) {
        String SQL = "SELECT * FROM aulas WHERE id_aula=?";
        Aulas aulas = null;

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                aulas = new Aulas();
                aulas.setId_aula(id);
                aulas.setGrado(res.getString("grado"));
                aulas.setSeccion(res.getString("seccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error en AulasDAO.Read: " + e.getMessage());
        }
        return aulas;
    }

    @Override
    public List<Aulas> readall() {
        List<Aulas> lista = new ArrayList<>();
        String SQL = "SELECT id_aula, grado, seccion FROM aulas";

        try (PreparedStatement pst = conn.prepareStatement(SQL);
             ResultSet res = pst.executeQuery()) {

            while (res.next()) {
                Aulas aula = new Aulas();
                aula.setId_aula(res.getInt("id_aula"));
                aula.setGrado(res.getString("grado"));
                aula.setSeccion(res.getString("seccion"));
                lista.add(aula);
            }

        } catch (SQLException e) {
            System.out.println("Error en AulasDAO.ReadAll: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean update(Aulas input) {
        String SQL = "UPDATE aulas SET grado=?, seccion=? WHERE id_aula=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setString(1, input.getGrado());
            pst.setString(2, input.getSeccion());
            pst.setInt(3, input.getId_aula());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AulasDAO.Update: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String SQL = "DELETE FROM aulas WHERE id_aula=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AulasDAO.Delete: " + e.getMessage());
            return false;
        }
    }
}