package model;

public class Profesores {

    private int id_profesor;
    private String dni;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String especialidad;
    private String segunda_especialidad;

    public Profesores() {
    }

    public Profesores(Builder builder) {
        this.id_profesor = builder.id_profesor;
        this.dni = builder.dni;
        this.primer_nombre = builder.primer_nombre;
        this.segundo_nombre = builder.segundo_nombre;
        this.primer_apellido = builder.primer_apellido;
        this.segundo_apellido = builder.segundo_apellido;
        this.especialidad = builder.especialidad;
        this.segunda_especialidad = builder.segunda_especialidad;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getSegunda_especialidad() {
        return segunda_especialidad;
    }

    public void setSegunda_especialidad(String segunda_especialidad) {
        this.segunda_especialidad = segunda_especialidad;
    }

    // Builder
    public static class Builder {

        private int id_profesor;
        private String dni;
        private String primer_nombre;
        private String segundo_nombre;
        private String primer_apellido;
        private String segundo_apellido;
        private String especialidad;
        private String segunda_especialidad;

        public Builder idProfesor(int id_profesor) {
            this.id_profesor = id_profesor;
            return this;
        }

        public Builder dni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder primerNombre(String primer_nombre) {
            this.primer_nombre = primer_nombre;
            return this;
        }

        public Builder segundoNombre(String segundo_nombre) {
            this.segundo_nombre = segundo_nombre;
            return this;
        }

        public Builder primerApellido(String primer_apellido) {
            this.primer_apellido = primer_apellido;
            return this;
        }

        public Builder segundoApellido(String segundo_apellido) {
            this.segundo_apellido = segundo_apellido;
            return this;
        }

        public Builder especialidad(String especialidad) {
            this.especialidad = especialidad;
            return this;
        }

        public Builder segundaEspecialidad(String segunda_especialidad) {
            this.segunda_especialidad = segunda_especialidad;
            return this;
        }

        public Profesores build() {
            return new Profesores(this);
        }
    }
}
