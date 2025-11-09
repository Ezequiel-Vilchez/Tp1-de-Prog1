import java.util.Objects;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String documento;
    
    public Persona(String nombre,String apellido,int edad, String documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getApellido(){ return apellido; }
    public void setApellido(String apellido){ this.apellido = apellido; }
    public int getEdad(){ return edad; }
    public void setEdad(int edad){ this.edad = edad; }
    public String getDocumento(){ return documento; }
    public void setDocumento(String documento){ this.documento = documento; }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona that = (Persona) obj;
        return Objects.equals(this.documento, that.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.documento);
    }
}