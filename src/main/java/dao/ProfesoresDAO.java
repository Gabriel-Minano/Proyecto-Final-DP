package dao;

import model.Profesores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesoresDAO implements IBaseDAO<Profesores> {

    private final Connection conn;

    public ProfesoresDAO() {
        this.conn = ConexionMySQL.getInstancia().getConexion();
    }

    @Override
    public boolean create(Profesores input) {
        String SQL = "INSERT INTO profesores (dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, especialidad, segunda_especialidad) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setString(1, input.getDni());
            pst.setString(2, input.getPrimer_nombre());
            pst.setString(3, input.getSegundo_nombre());
            pst.setString(4, input.getPrimer_apellido());
            pst.setString(5, input.getSegundo_apellido());
            pst.setString(6, input.getEspecialidad());
            pst.setString(7, input.getSegunda_especialidad());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en ProfesoresDAO.Create: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Profesores read(int id) {
        String SQL = "SELECT * FROM profesores WHERE id_profesor=?";
        Profesores profesor = null;

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                profesor = new Profesores();
                profesor.setId_profesor(id);
                profesor.setDni(res.getString("dni"));
                profesor.setPrimer_nombre(res.getString("primer_nombre"));
                profesor.setSegundo_nombre(res.getString("segundo_nombre"));
                profesor.setPrimer_apellido(res.getString("primer_apellido"));
                profesor.setSegundo_apellido(res.getString("segundo_apellido"));
                profesor.setEspecialidad(res.getString("especialidad"));
                profesor.setSegunda_especialidad(res.getString("segunda_especialidad"));
            }

        } catch (SQLException e) {
            System.out.println("Error en ProfesoresDAO.Read: " + e.getMessage());
        }

        return profesor;
    }

    @Override
    public List<Profesores> readall() {
        String SQL = "SELECT id_profesor, dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, especialidad, segunda_especialidad FROM profesores";
        List<Profesores> lista = new ArrayList<>();

        try (PreparedStatement pst = conn.prepareStatement(SQL);
             ResultSet res = pst.executeQuery()) {

            while (res.next()) {
                Profesores profesor = new Profesores();

                profesor.setId_profesor(res.getInt("id_profesor"));
                profesor.setDni(res.getString("dni"));
                profesor.setPrimer_nombre(res.getString("primer_nombre"));
                profesor.setSegundo_nombre(res.getString("segundo_nombre"));
                profesor.setPrimer_apellido(res.getString("primer_apellido"));
                profesor.setSegundo_apellido(res.getString("segundo_apellido"));
                profesor.setEspecialidad(res.getString("especialidad"));
                profesor.setSegunda_especialidad(res.getString("segunda_especialidad"));

                lista.add(profesor);
            }

        } catch (SQLException e) {
            System.out.println("Error en ProfesoresDAO.ReadAll: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean update(Profesores input) {
        String SQL = "UPDATE profesores SET dni=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, especialidad=?, segunda_especialidad=? WHERE id_profesor=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setString(1, input.getDni());
            pst.setString(2, input.getPrimer_nombre());
            pst.setString(3, input.getSegundo_nombre());
            pst.setString(4, input.getPrimer_apellido());
            pst.setString(5, input.getSegundo_apellido());
            pst.setString(6, input.getEspecialidad());
            pst.setString(7, input.getSegunda_especialidad());
            pst.setInt(8, input.getId_profesor());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en ProfesoresDAO.Update: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String SQL = "DELETE FROM profesores WHERE id_profesor=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en ProfesoresDAO.Delete: " + e.getMessage());
            return false;
        }
    }
}