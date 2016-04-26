package edu.uagro.dto;

public class Tbl_ExpedienteCasaDTO {
    private int id;
    private int tbl_casaestudianteClaveDTO;
    private int tbl_arrendatarioIdDTO;
    private String tbl_representanteMatriculaDTO;
    private int tbl_arrendadorIdDTO;
    private double montoRenta;
    private String tipoRenta;
    private String fechaInicio;
    private String fechaInicialArrendamiento;
    private String fechaFinalArrendamiento;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTbl_casaestudianteClaveDTO() {
        return tbl_casaestudianteClaveDTO;
    }

    public void setTbl_casaestudianteClaveDTO(int tbl_casaestudianteClaveDTO) {
        this.tbl_casaestudianteClaveDTO = tbl_casaestudianteClaveDTO;
    }

    public int getTbl_arrendatarioIdDTO() {
        return tbl_arrendatarioIdDTO;
    }

    public void setTbl_arrendatarioIdDTO(int tbl_arrendatarioIdDTO) {
        this.tbl_arrendatarioIdDTO = tbl_arrendatarioIdDTO;
    }

    public String getTbl_representanteMatriculaDTO() {
        return tbl_representanteMatriculaDTO;
    }

    public void setTbl_representanteMatriculaDTO(String tbl_representanteMatriculaDTO) {
        this.tbl_representanteMatriculaDTO = tbl_representanteMatriculaDTO;
    }

    public int getTbl_arrendadorIdDTO() {
        return tbl_arrendadorIdDTO;
    }

    public void setTbl_arrendadorIdDTO(int tbl_arrendadorIdDTO) {
        this.tbl_arrendadorIdDTO = tbl_arrendadorIdDTO;
    }

    public double getMontoRenta() {
        return montoRenta;
    }

    public void setMontoRenta(double montoRenta) {
        this.montoRenta = montoRenta;
    }

    public String getTipoRenta() {
        return tipoRenta;
    }

    public void setTipoRenta(String tipoRenta) {
        this.tipoRenta = tipoRenta;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaInicialArrendamiento() {
        return fechaInicialArrendamiento;
    }

    public void setFechaInicialArrendamiento(String fechaInicialArrendamiento) {
        this.fechaInicialArrendamiento = fechaInicialArrendamiento;
    }

    public String getFechaFinalArrendamiento() {
        return fechaFinalArrendamiento;
    }

    public void setFechaFinalArrendamiento(String fechaFinalArrendamiento) {
        this.fechaFinalArrendamiento = fechaFinalArrendamiento;
    }
    
}
