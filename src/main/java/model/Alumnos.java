package model;

public class Alumnos {

    private int id_alumno;
    private String dni;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private int id_aula;

    public Alumnos() {
    }

    public Alumnos(Builder builder) {
        this.id_alumno = builder.id_alumno;
        this.dni = builder.dni;
        this.primer_nombre = builder.primer_nombre;
        this.segundo_nombre = builder.segundo_nombre;
        this.primer_apellido = builder.primer_apellido;
        this.segundo_apellido = builder.segundo_apellido;
        this.id_aula = builder.id_aula;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    //Builder 
    public static class Builder {

        private int id_alumno;
        private String dni;
        private String primer_nombre;
        private String segundo_nombre;
        private String primer_apellido;
        private String segundo_apellido;
        private int id_aula;

        public Builder idAlumno(int id) {
            this.id_alumno = id;
            return this;
        }

        public Builder dni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder primerNombre(String nombre) {
            this.primer_nombre = nombre;
            return this;
        }

        public Builder segundoNombre(String nombre) {
            this.segundo_nombre = nombre;
            return this;
        }

        public Builder primerApellido(String ape) {
            this.primer_apellido = ape;
            return this;
        }

        public Builder segundoApellido(String ape) {
            this.segundo_apellido = ape;
            return this;
        }

        public Builder idAula(int aula) {
            this.id_aula = aula;
            return this;
        }

        public Alumnos build() {
            return new Alumnos(this);
        }
    }

}
