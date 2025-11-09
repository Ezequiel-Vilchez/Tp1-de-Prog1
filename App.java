public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Profesor profe1 = new Profesor("Carlos", "Gomez", 45, "99887766", "Matematicas", "20 años");
        
        Materia materia1 = new Materia("Base de datos", "Bs101", 4, 9.8, profe1);
        Materia materia2 = new Materia("Ingles", "ing1301", 0, 2.7, profe1);
        Materia materia3 = new Materia("Matematicas", "MT201", 2, 7.0, profe1);

        Materia[] materiasEzequiel = { materia1, materia2, materia3 };
        Materia[] materiasNicolas = { materia1, materia2 };
        Materia[] materiasJuan = { materia3 };
        Materia[] materiasAna = {}; 

        String c1 = "Programador";
        String c2 = "Ingenieria en Sistemas";

        Estudiante e1 = new Estudiante("Ezequiel", "Vilchez", 21, "12345678", c2, materiasEzequiel);
        Estudiante e2 = new Estudiante("Nicolas", "Sanchez", 22, "87654321", c1, materiasNicolas);
        Estudiante e3 = new Estudiante("Juan", "Guzman", 23, "11223344", c1, materiasJuan);
        Estudiante e4 = new Estudiante("Ana", "Lopez", 20, "44332211", c2, materiasAna);
        

        Personal per1 = new Personal("Social", "Administracion", "2025-19-10", "Jose", "Torres", 23, "46072241");
        
        System.out.println("----------------------------------------------------------------");
        
        
        Universidad u1 = new Universidad("Unvime", "Los poetas", 10);
        
        u1.agregarMiembros(e1);
        u1.agregarMiembros(e2);
        u1.agregarMiembros(e3);
        u1.agregarMiembros(e4);
        u1.agregarMiembros(profe1);
        u1.agregarMiembros(per1);

        System.out.println("Intentando agregar duplicado ");
        
        Estudiante e1_duplicado = new Estudiante("Ezequiel", "Repetido", 25, "12345678", c2, materiasAna);
        u1.agregarMiembros(e1_duplicado); 

        System.out.println("----------------------------------------------------------------");
        System.out.println("Promedios (Calculados en el constructor con Iterativo)");
        
        System.out.println("El promedio de " + e1.getNombre() + " es " + e1.getPromedio());
        System.out.println("El promedio de " + e2.getNombre() + " es " + e2.getPromedio());
        System.out.println("El promedio de " + e3.getNombre() + " es " + e3.getPromedio());
        System.out.println("El promedio de " + e4.getNombre() + " es " + e4.getPromedio()); 

        System.out.println("----------------------------------------------------------------");
        System.out.println("Prueba de Recursión");

        
        System.out.println("Promedio recursivo de Ezequiel: " + e1.calcularPromedioRecursivo());

        
        System.out.println("Estudiantes en Programador (Iterativo): " + u1.contarEstudiantesIterativo(c1));
        System.out.println("Estudiantes en Programador (Recursivo): " + u1.contarEstudiantesRecursivo(c1));
        System.out.println("Estudiantes en Ingenieria (Recursivo): " + u1.contarEstudiantesRecursivo(c2));

        Estudiante buscado = u1.buscarEstudianteRecursivo("11223344"); // Juan
        if (buscado != null) {
            System.out.println("Estudiante encontrado (Recursivo): " + buscado.getNombre());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
        
        Estudiante noEncontrado = u1.buscarEstudianteRecursivo("999");
        if (noEncontrado == null) {
            System.out.println("Estudiante '999' no encontrado .");
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Prueba de Ordenamiento ");
        
        u1.ordenarEstudiantesPorApellido();
    }
}

