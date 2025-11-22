package dao;

import model.Alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO implements IBaseDAO<Alumnos> {

    private final Connection conn;

    public AlumnosDAO() {
        this.conn = ConexionMySQL.getInstancia().getConexion();
    }

    @Override
    public boolean create(Alumnos input) {
        String SQL = "INSERT INTO alumnos (dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id_aula) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setString(1, input.getDni());
            pst.setString(2, input.getPrimer_nombre());
            pst.setString(3, input.getSegundo_nombre());
            pst.setString(4, input.getPrimer_apellido());
            pst.setString(5, input.getSegundo_apellido());
            pst.setInt(6, input.getId_aula());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AlumnosDAO.Create: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Alumnos read(int id) {
        String SQL = "SELECT * FROM alumnos WHERE id_alumno=?";
        Alumnos alumno = null;

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                alumno = new Alumnos();
                alumno.setId_alumno(id);
                alumno.setDni(res.getString("dni"));
                alumno.setPrimer_nombre(res.getString("primer_nombre"));
                alumno.setSegundo_nombre(res.getString("segundo_nombre"));
                alumno.setPrimer_apellido(res.getString("primer_apellido"));
                alumno.setSegundo_apellido(res.getString("segundo_apellido"));
                alumno.setId_aula(res.getInt("id_aula"));
            }

        } catch (SQLException e) {
            System.out.println("Error en AlumnosDAO.Read: " + e.getMessage());
        }

        return alumno;
    }

    @Override
    public List<Alumnos> readall() {
        String SQL = "SELECT id_alumno, dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id_aula FROM alumnos";
        List<Alumnos> lista = new ArrayList<>();

        try (PreparedStatement pst = conn.prepareStatement(SQL);
             ResultSet res = pst.executeQuery()) {

            while (res.next()) {
                Alumnos alumno = new Alumnos();
                alumno.setId_alumno(res.getInt("id_alumno"));
                alumno.setDni(res.getString("dni"));
                alumno.setPrimer_nombre(res.getString("primer_nombre"));
                alumno.setSegundo_nombre(res.getString("segundo_nombre"));
                alumno.setPrimer_apellido(res.getString("primer_apellido"));
                alumno.setSegundo_apellido(res.getString("segundo_apellido"));
                alumno.setId_aula(res.getInt("id_aula"));

                lista.add(alumno);
            }

        } catch (SQLException e) {
            System.out.println("Error en AlumnosDAO.ReadAll: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean update(Alumnos input) {
        String SQL = "UPDATE alumnos SET dni=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, id_aula=? WHERE id_alumno=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setString(1, input.getDni());
            pst.setString(2, input.getPrimer_nombre());
            pst.setString(3, input.getSegundo_nombre());
            pst.setString(4, input.getPrimer_apellido());
            pst.setString(5, input.getSegundo_apellido());
            pst.setInt(6, input.getId_aula());
            pst.setInt(7, input.getId_alumno());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AlumnosDAO.Update: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String SQL = "DELETE FROM alumnos WHERE id_alumno=?";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en AlumnosDAO.Delete: " + e.getMessage());
            return false;
        }
    }
}