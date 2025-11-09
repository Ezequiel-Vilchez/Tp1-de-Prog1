public class Profesor extends Persona implements MiembroUniversidad{
    private String especialidad;
    private String aniosDeExperencia;
    private Materia[] materias;
    private int contadorMaterias;

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, String aniosDeExperencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.aniosDeExperencia = aniosDeExperencia;
        this.materias = new Materia[12];
        this.contadorMaterias = 0;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAniosDeExperencia() {
        return aniosDeExperencia;
    }

    public void setAniosDeExperencia(String aniosDeExperencia) {
        this.aniosDeExperencia = aniosDeExperencia;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void asignarMateria(Materia materia) {
        if (contadorMaterias < materias.length) {
            materias[contadorMaterias] = materia;
            contadorMaterias++;
            System.out.println("El profesor " + this.getNombre() + " se ha inscrito a la materia: " + materia.getNombre());
        } else {
            System.out.println("No se pudo inscribir: El profesor ya tiene el cupo de materias lleno.");
        }
    }

    public int getContadorMaterias() {
        return contadorMaterias;
    }

    public void mostrarInformacion(){
        System.out.println("Nombre y apellido: "+this.nombre + " " +this.apellido);
        System.out.println("Edad: "+this.edad);
        System.out.println("Documento: "+this.documento);
        System.out.println("Especialidad: "+this.especialidad);
        System.out.println("Años de experencia: "+aniosDeExperencia);
    }

    @Override
    public String toString() {
        return this.nombre + " "+this.apellido+"Edad: "+this.edad+ "Dni: "+documento+" "+"Especialidad: "+especialidad+" "+"Años de experiencia: "+aniosDeExperencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        Profesor that = (Profesor) obj;
        return this.documento.equals(that.documento);
    }

    public String obtenerRol(){
        return "Profesor";
    }
    public String obtenerInformacionCompleta(){
        return this.toString();
    }

}

