package edu.uagro.dto;

public class Tbl_RepresentanteDTO {
    private String matricula;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String sexo;
    private String UAcademica;
    private int grado;
    private String turno;
    private double promedio; 
    private String telefono;
    private String email;
    private int estado;
    private int tiporepresentanteId;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUAcademica() {
        return UAcademica;
    }

    public void setUAcademica(String UAcademica) {
        this.UAcademica = UAcademica;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getCat_tiporepresentanteIdDTO() {
        return tiporepresentanteId;
    }

    public void setCat_tiporepresentanteIdDTO(int cat_tiporepresentanteIdDTO) {
        this.tiporepresentanteId = cat_tiporepresentanteIdDTO;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
