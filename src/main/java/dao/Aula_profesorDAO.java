package dao;

import model.Aula_profesor;
import model.Aulas;
import model.Profesores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aula_profesorDAO implements IBaseDAO<Aula_profesor> {

    private final Connection conn;

    public Aula_profesorDAO() {
        this.conn = ConexionMySQL.getInstancia().getConexion();
    }

    @Override
    public boolean create(Aula_profesor input) {
        String SQL = "INSERT INTO aula_profesor (id_aula, id_profesor) VALUES (?,?)";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, input.getAula().getId_aula());
            pst.setInt(2, input.getProfesor().getId_profesor());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en Aula_profesorDAO.Create: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Aula_profesor read(int id) {
        String SQL = "SELECT * FROM aula_profesor WHERE id_asignacion=?";
        Aula_profesor ap = null;

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                ap = new Aula_profesor();
                ap.setId_asignacion(id);

                Aulas aula = new Aulas();
                aula.setId_aula(res.getInt("id_aula"));
                ap.setAula(aula);

                Profesores profesor = new Profesores();
                profesor.setId_profesor(res.getInt("id_profesor"));
                ap.setProfesor(profesor);
            }

        } catch (SQLException e) {
            System.out.println("Error en Aula_profesorDAO.Read: " + e.getMessage());
        }

        return ap;
    }

    @Override
    public List<Aula_profesor> readall() {
        List<Aula_profesor> lista = new ArrayList<>();
        String SQL = "SELECT id_asignacion, id_aula, id_profesor FROM aula_profesor";

        try (PreparedStatement pst = conn.prepareStatement(SQL);
             ResultSet res = pst.executeQuery()) {

            while (res.next()) {
                Aula_profesor ap = new Aula_profesor();
                ap.setId_asignacion(res.getInt("id_asignacion"));

                Aulas aula = new Aulas();
                aula.setId_aula(res.getInt("id_aula"));
                ap.setAula(aula);

                Profesores profesor = new Profesores();
                profesor.setId_profesor(res.getInt("id_profesor"));
                ap.setProfesor(profesor);

                lista.add(ap);
            }

        } catch (SQLException e) {
            System.out.println("Error en Aula_profesorDAO.ReadAll: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean update(Aula_profesor input) {
        String SQL = "UPDATE aula_profesor SET id_aula=?, id_profesor=? WHERE id_asignacion=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, input.getAula().getId_aula());
            pst.setInt(2, input.getProfesor().getId_profesor());
            pst.setInt(3, input.getId_asignacion());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en Aula_profesorDAO.Update: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String SQL = "DELETE FROM aula_profesor WHERE id_asignacion=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en Aula_profesorDAO.Delete: " + e.getMessage());
            return false;
        }
    }
}