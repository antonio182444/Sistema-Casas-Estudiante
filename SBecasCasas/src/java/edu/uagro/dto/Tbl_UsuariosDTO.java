package edu.uagro.dto;

public class Tbl_UsuariosDTO {
    private int id;
    private int cat_tipousuarioDTO;
    private String nombre;
    private String email;
    private String contrasenia;
    private String fechaCreacion;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_tipousuarioDTO() {
        return cat_tipousuarioDTO;
    }

    public void setCat_tipousuarioDTO(int cat_tipousuarioDTO) {
        this.cat_tipousuarioDTO = cat_tipousuarioDTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
