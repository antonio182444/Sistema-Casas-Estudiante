/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import edu.uagro.bo.Cat_NivelBecaBO;
import edu.uagro.bo.Cat_TipoBecaBO;
import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.dto.Cat_NivelBecaDTO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_BecarioDTO;
import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean (name = "altaBecarioBeans")
@ViewScoped
public final class AltaBecarioBeans {
    private Tbl_BecarioDTO  becarioDTO = new Tbl_BecarioDTO(); 
    List<Tbl_BecarioDTO> lstBecarioDTO = new ArrayList();
    private Cat_NivelBecaDTO nivelBecaDTO;
    private Cat_TipoBecaDTO tipoBecaDTO;
    private Tbl_DetalleBecarioDTO detalleBecarioDTO;
    private Cat_ZonasDTO zonasDTO; 
    
    public AltaBecarioBeans() {
        
        nivelBecaDTO = new Cat_NivelBecaDTO();
        tipoBecaDTO = new Cat_TipoBecaDTO();
        detalleBecarioDTO = new Tbl_DetalleBecarioDTO();
        zonasDTO = new Cat_ZonasDTO();
    }

    public Cat_ZonasDTO getZonasDTO() {
        return zonasDTO;
    }

    public void setZonasDTO(Cat_ZonasDTO zonasDTO) {
        this.zonasDTO = zonasDTO;
    }
    
    public Tbl_DetalleBecarioDTO getDetalleBecarioDTO() {
        return detalleBecarioDTO;
    }

    public void setDetalleBecarioDTO(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
        this.detalleBecarioDTO = detalleBecarioDTO;
    }       

    public Cat_TipoBecaDTO getTipoBecaDTO() {
        return tipoBecaDTO;
    }

    public void setTipoBecaDTO(Cat_TipoBecaDTO tipoBecaDTO) {
        this.tipoBecaDTO = tipoBecaDTO;
    }
       
    public Cat_NivelBecaDTO getNivelBecaDTO() {
        return nivelBecaDTO;
    }

    public void setNivelBecaDTO(Cat_NivelBecaDTO nivelBecaDTO) {
        this.nivelBecaDTO = nivelBecaDTO;
    }
    

    public Tbl_BecarioDTO getBecarioDTO() {
        return becarioDTO;
    }

    public void setBecarioDTO(Tbl_BecarioDTO becarioDTO) {
        this.becarioDTO = becarioDTO;
    }

    public List<Tbl_BecarioDTO> getLstBecarioDTO() {
        return lstBecarioDTO;
    }

    public void setLstBecarioDTO(List<Tbl_BecarioDTO> lstBecarioDTO) {
        this.lstBecarioDTO = lstBecarioDTO;
    }
    
    public void altaBecario(){
        Tbl_BecarioBO becarioBO = new Tbl_BecarioBO();
        //becarioBO.altaBecario(becarioDTO);
    }
    
    public ArrayList<Cat_NivelBecaDTO> obtenerNivelesBeca(){
        Cat_NivelBecaBO nivelBO = new Cat_NivelBecaBO();
        return nivelBO.obtenerDatos();
    }
    
    public ArrayList<Cat_TipoBecaDTO> obtenerTiposBeca(){
       Cat_TipoBecaBO tipoBecaBO = new Cat_TipoBecaBO();
       return tipoBecaBO.obtenerDatos();
   }
    
     public ArrayList<Cat_ZonasDTO> obtenerZonas(){
         Cat_ZonasBO zonasBO  = new Cat_ZonasBO();
      return null; //  return zonasBO.obtenerZonas();
     }
     
    
}
