package model;

public class Aula_profesor {

    //CORRECCIÓN A FUTURO
    /*
    No es necesario guardar un objeto entero, solo bastaba con
    hacer un int id_aula, puesto que así ahorra memoria y es más eficiente.
    Por otro lado, como no se usará después el nombre u otro atributo
    no era necesario poner un objeto.
     */
    private int id_asignacion;
    private Aulas aula;
    private Profesores profesor;

    public Aula_profesor() {
    }

    public Aula_profesor(int id_asignacion, Aulas aula, Profesores profesor) {
        this.id_asignacion = id_asignacion;
        this.aula = aula;
        this.profesor = profesor;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public Aulas getAula() {
        return aula;
    }

    public void setAula(Aulas aula) {
        this.aula = aula;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

}
