public class Estudiante extends Persona implements MiembroUniversidad {
    
    private String carrera; 
    private double promedio;
    private Materia[] materias;

    
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, Materia[] materias) {
        super(nombre, apellido, edad, documento); 
        this.carrera = carrera;
        this.materias = materias;
        this.promedio = calcularPromedioIterativo();
    }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public Materia[] getMaterias() { return materias; }
    public void setMaterias(Materia[] materias) { this.materias = materias; }

    public double getPromedio() { return promedio; }

    public double calcularPromedioIterativo() {
        if (materias == null || materias.length == 0) {
            return 0.0;
        }
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion(); 
        }
        
        this.promedio = suma / materias.length;
        return this.promedio;
    }

    
    public static double sumarNotasRecursivo(Materia[] materias, int indice) {
        
        if (indice == materias.length - 1) {
            return materias[indice].getCalificacion();
        }
        
        if (indice >= materias.length) {
            return 0;
        }
        
        return materias[indice].getCalificacion() + sumarNotasRecursivo(materias, indice + 1);
    }
    
    
    public double calcularPromedioRecursivo() {
        if (materias == null || materias.length == 0) {
            return 0.0;
        }
        double suma = sumarNotasRecursivo(this.materias, 0);
        this.promedio = suma / this.materias.length;
        return this.promedio;
    }


    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return obtenerRol() + ": " + getNombre() + " " + getApellido() + " - Carrera: " + carrera + " - Promedio: " + promedio;
    }

    @Override
    public String toString() {
        return obtenerInformacionCompleta();
    }
}