package edu.uagro.dto;

import java.util.Date;

public class Tbl_ExpedienteCasaDTO {
    private int id;
    private int tbl_casaestudianteClaveDTO;
    private int tbl_arrendatarioIdDTO;
    private String tbl_representanteMatriculaDTO;
    private int tbl_arrendadorIdDTO;
    private double montoRenta;
    private double aumento;
    private double montoTotal;
    private String montoLetra;
    private String tipoRenta;
    private Date fechaInicio;
    private Date fechaInicialArrendamiento;
    private Date fechaFinalArrendamiento;
    private int estado;

    public double getAumento() {
        return aumento;
    }

    public void setAumento(double aumento) {
        this.aumento = aumento;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMontoLetra() {
        return montoLetra;
    }

    public void setMontoLetra(String montoLetra) {
        this.montoLetra = montoLetra;
    }
    

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicialArrendamiento() {
        return fechaInicialArrendamiento;
    }

    public void setFechaInicialArrendamiento(Date fechaInicialArrendamiento) {
        this.fechaInicialArrendamiento = fechaInicialArrendamiento;
    }

    public Date getFechaFinalArrendamiento() {
        return fechaFinalArrendamiento;
    }

    public void setFechaFinalArrendamiento(Date fechaFinalArrendamiento) {
        this.fechaFinalArrendamiento = fechaFinalArrendamiento;
    }
    
}
