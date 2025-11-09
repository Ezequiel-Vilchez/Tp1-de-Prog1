public class Carrera {
    private String nombre;
    private int cantidadEstudiantes;
    private int contadorEstudiantes;
    private Estudiante[] estudiantes;


    public Carrera(String nombre) {
        this.nombre = nombre;
        this.cantidadEstudiantes = 120;
        this.contadorEstudiantes = 0;
        this.estudiantes = new Estudiante[this.cantidadEstudiantes];
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {


        if (this.contadorEstudiantes < this.cantidadEstudiantes) {
            this.estudiantes[this.contadorEstudiantes] = estudiante;
            this.contadorEstudiantes++;
        } else {
            System.out.println("Error. No se pueden cargar mas de " + this.cantidadEstudiantes + " estudiantes.");
        }


    }

    public Estudiante[] listarEstudiantes() {
        return this.estudiantes;
    }

    public boolean buscarEstudiante(String nombreEstudiante) {
        for (int i = 0; i < this.contadorEstudiantes; i++) {
            if (this.estudiantes[i].getNombre().equalsIgnoreCase(nombreEstudiante)) {
                return true;
            }
        }
        return false;
    }

    public int getContadorEstudiantes() {
        return this.contadorEstudiantes;
    }

    public void mostrarInformacion(){
        System.out.println(this.nombre);
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Carrera: "+ nombre ;
    }

    

}
