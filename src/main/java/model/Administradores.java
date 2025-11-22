package model;

public class Administradores {

    private int id_admin;
    private String usuario;
    private String contrasenha;

    public Administradores() {
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        if (contrasenha == null || contrasenha.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (contrasenha.length() < 4) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 4 caracteres");
        }
        this.contrasenha = contrasenha.trim();
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        if (id_admin < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo");
        }
        this.id_admin = id_admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario no puede estar vacío");
        }
        if (usuario.length() < 3) {
            throw new IllegalArgumentException("El usuario debe tener mínimo 3 caracteres");
        }
        this.usuario = usuario.trim();
    }

}
