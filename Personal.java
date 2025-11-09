public class Personal extends Persona implements MiembroUniversidad{
    private String departamento;
    private String puesto;
    private String fechaIngreso;

    public Personal(String departamento,String puesto,String fechaIngreso,String nombre,String apellido,int edad,String documento){
        super(nombre, apellido, edad, documento);
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
    }

    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getPuesto(){
        return puesto;
    }
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }

    public String getfechaIngreso(){
        return fechaIngreso;
    }
    public void setFechaingreso(String fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nombre: "+nombre +" "+apellido+ " ,edad: "+ edad +" ,Documento: "+documento  +" ,Departamento: "+departamento+" ,Puesto: "+puesto+ " ,FechaIngreso: "+fechaIngreso ;
    }

    public String obtenerRol(){
        return "Personal";
    }

    public String obtenerInformacionCompleta(){
        return this.toString();
    }
}
