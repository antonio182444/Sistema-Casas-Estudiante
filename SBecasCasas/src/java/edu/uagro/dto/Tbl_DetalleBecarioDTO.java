package edu.uagro.dto;

public class Tbl_DetalleBecarioDTO {
    private int id;
    private String fecha;
    private int tbl_becarioIdDTO;
    private String fechaInicioBeca;
    private String fechaFinBeca;
    private String area;
    private String solicitante;
    private String adscripcion;
    private int cat_zonasIdDTO;
    private int cat_nivelbecaIdDTO;
    private int cat_tipobecaIdDTO;
    private String observacion;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTbl_becarioIdDTO() {
        return tbl_becarioIdDTO;
    }

    public void setTbl_becarioIdDTO(int tbl_becarioIdDTO) {
        this.tbl_becarioIdDTO = tbl_becarioIdDTO;
    }

    public String getFechaInicioBeca() {
        return fechaInicioBeca;
    }

    public void setFechaInicioBeca(String fechaInicioBeca) {
        this.fechaInicioBeca = fechaInicioBeca;
    }

    public String getFechaFinBeca() {
        return fechaFinBeca;
    }

    public void setFechaFinBeca(String fechaFinBeca) {
        this.fechaFinBeca = fechaFinBeca;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getAdscripcion() {
        return adscripcion;
    }

    public void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }

    public int getCat_zonasIdDTO() {
        return cat_zonasIdDTO;
    }

    public void setCat_zonasIdDTO(int cat_zonasIdDTO) {
        this.cat_zonasIdDTO = cat_zonasIdDTO;
    }

    public int getCat_nivelbecaIdDTO() {
        return cat_nivelbecaIdDTO;
    }

    public void setCat_nivelbecaIdDTO(int cat_nivelbecaIdDTO) {
        this.cat_nivelbecaIdDTO = cat_nivelbecaIdDTO;
    }

    public int getCat_tipobecaIdDTO() {
        return cat_tipobecaIdDTO;
    }

    public void setCat_tipobecaIdDTO(int cat_tipobecaIdDTO) {
        this.cat_tipobecaIdDTO = cat_tipobecaIdDTO;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
        
}
