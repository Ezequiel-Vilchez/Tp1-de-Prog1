public class Universidad {

    private String nombre;
    private String direccion;

    private MiembroUniversidad[] miembros;
    private int contadorMiembros;
    private int capacidadTotalMiembros;

    public Universidad(String nombre, String direccion, int capacidadTotalMiembros) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.miembros = new MiembroUniversidad[capacidadTotalMiembros];
        this.contadorMiembros = 0;
        this.capacidadTotalMiembros = capacidadTotalMiembros;
    }

    public void agregarMiembros(MiembroUniversidad miembro) {

        for (int i = 0; i < this.contadorMiembros; i++) {
            if (this.miembros[i].equals(miembro)) {
                System.out.println("Error: El miembro con documento " +
                        ((Persona) miembro).getDocumento() + " ya existe.");
                return;
            }
        }

        if (this.contadorMiembros < this.capacidadTotalMiembros) {
            this.miembros[this.contadorMiembros] = miembro;
            this.contadorMiembros++;
            System.out.println("Miembro agregado: " + miembro.obtenerRol());
        } else {
            System.out.println("No se pudo cargar a la universidad. Límite alcanzado.");
        }
    }

    public void buscarPorRol(String rol) {
        System.out.println("Buscando miembros con el rol: '" + rol + "'");
        int contadorEncontrados = 0;

        for (int i = 0; i < this.contadorMiembros; i++) {
            MiembroUniversidad miembro = this.miembros[i];

            if (miembro.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println("   -> " + miembro.obtenerInformacionCompleta());
                contadorEncontrados++;
            }
        }
        if (contadorEncontrados == 0) {
            System.out.println("No se encontraron miembros con ese rol.");
        }
    }

    public int contarEstudiantesIterativo(String carrera) {
        int contador = 0;
        for (int i = 0; i < this.contadorMiembros; i++) {
            if (this.miembros[i] instanceof Estudiante) {
                Estudiante e = (Estudiante) this.miembros[i];
                if (e.getCarrera().equalsIgnoreCase(carrera)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int contarEstudiantesRecursivo(String carrera) {
        return contarEstudiantesRecursivo(carrera, 0);
    }

    private int contarEstudiantesRecursivo(String carrera, int indice) {
        if (indice == this.contadorMiembros) {
            return 0;
        }

        int contadorActual = 0;
        if (this.miembros[indice] instanceof Estudiante) {
            Estudiante e = (Estudiante) this.miembros[indice];
            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                contadorActual = 1;
            }
        }
        return contadorActual + contarEstudiantesRecursivo(carrera, indice + 1);
    }

    public Estudiante buscarEstudianteIterativo(String documento) {
        for (int i = 0; i < this.contadorMiembros; i++) {
            if (this.miembros[i] instanceof Estudiante) {
                Estudiante e = (Estudiante) this.miembros[i];
                if (e.getDocumento().equals(documento)) {
                    return e;
                }
            }
        }
        return null;
    }

    public Estudiante buscarEstudianteRecursivo(String documento) {
        return buscarEstudianteRecursivo(documento, 0);
    }

    private Estudiante buscarEstudianteRecursivo(String documento, int indice) {
        if (indice == this.contadorMiembros) {
            return null;
        } 

        if (this.miembros[indice] instanceof Estudiante) {
            Estudiante e = (Estudiante) this.miembros[indice];
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        
        return buscarEstudianteRecursivo(documento, indice + 1); 
    }

    public void ordenarEstudiantesPorApellido() {

        int totalEstudiantes = 0;
        for (int i = 0; i < this.contadorMiembros; i++) {
            if (this.miembros[i] instanceof Estudiante) {
                totalEstudiantes++;
            }
        }

        Estudiante[] estudiantesArray = new Estudiante[totalEstudiantes];
        int k = 0;
        for (int i = 0; i < this.contadorMiembros; i++) {
            if (this.miembros[i] instanceof Estudiante) {
                estudiantesArray[k] = (Estudiante) this.miembros[i];
                k++;
            }
        }

        int n = estudiantesArray.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (estudiantesArray[j].getApellido().compareTo(estudiantesArray[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }

            if (indiceMinimo != i) {
                Estudiante temp = estudiantesArray[i];
                estudiantesArray[i] = estudiantesArray[indiceMinimo];
                estudiantesArray[indiceMinimo] = temp;
            }
        }

        System.out.println("--- Estudiantes Ordenados por Apellido ---");
        for (Estudiante e : estudiantesArray) {
            System.out.println(e.getApellido() + ", " + e.getNombre());
        }
    }

    public void mostrarInformacion() {
        System.out.println("Universidad: " + this.nombre);
        System.out.println("Direccion: " + this.direccion);
    }

    @Override
    public String toString() {
        return "Universidad: " + this.nombre + ", Direccion: " + this.direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public MiembroUniversidad[] getMiembros() {
        return miembros;
    }

    public int getContadorMiembros() {
        return contadorMiembros;
    }
}