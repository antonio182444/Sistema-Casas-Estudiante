package edu.uagro.dao;

import edu.uagro.dto.Cat_NivelBecaDTO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_BecarioDTO;
import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_DetalleBecarioDAO {

    
    public int insertar(Tbl_DetalleBecarioDTO detalleBecario) {
        int indice = -1;
        if (detalleBecario == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_detallebecarioAdscripcion,
                            Util.tbl_detallebecarioArea,
                            Util.tbl_detallebecarioFecha,
                            Util.tbl_detallebecarioFechaFinBeca,
                            Util.tbl_detallebecarioFechaInicioBeca,
                            Util.tbl_detallebecarioObservacion,
                            Util.tbl_detallebecarioSolicitante,
                            Util.tbl_detallebecario_cat_nivelbecaId,
                            Util.tbl_detallebecario_cat_tipobecaId,
                            Util.tbl_detallebecario_cat_zonasId,
                            Util.tbl_detallebecario_tbl_becarioId};
        Util tabla = Util.tbl_detallebecario;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, detalleBecario.getAdscripcion());
            ps.setString(2, detalleBecario.getArea());
//            if (detalleBecario.getFecha() != null) {
//                ps.setDate(3, new Date (detalleBecario.getFecha().getTime()));
//            } else {
//                ps.setNull(3, java.sql.Types.DATE);
//            }
            Calendar c = Calendar.getInstance();
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH)+1);
            String annio = Integer.toString(c.get(Calendar.YEAR));
            String fecha = annio+"-"+mes+"-"+dia;
            detalleBecario.setFecha(fecha);
            ps.setString(3, detalleBecario.getFecha());
            if (detalleBecario.getFechaFinBeca()!= null) {
                ps.setDate(4, new Date (detalleBecario.getFechaFinBeca().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }
            if (detalleBecario.getFecha() != null) {
                ps.setDate(5, new Date (detalleBecario.getFechaInicioBeca().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.setString(6, detalleBecario.getObservacion());
            ps.setString(7, detalleBecario.getSolicitante());
            ps.setInt(8, detalleBecario.getCat_nivelbecaIdDTO());
            ps.setInt(9, detalleBecario.getCat_tipobecaIdDTO());
            ps.setInt(10, detalleBecario.getCat_zonasIdDTO());
            ps.setInt(11, detalleBecario.getTbl_becarioIdDTO());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating DetalleBecario failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                detalleBecario.setId(indice);
            } else {
                throw new SQLException("Creating DetalleBecario failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_DetalleBecarioDTO detalleBecario) {
        boolean band = false;
        if (detalleBecario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_detallebecarioId;
        Util tabla = Util.tbl_detallebecario;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, detalleBecario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating DetalleBecario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_DetalleBecarioDTO detalleBecario) {
        boolean band = false;
        if (detalleBecario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_detallebecarioAdscripcion,
                            Util.tbl_detallebecarioArea,
                            Util.tbl_detallebecarioFecha,
                            Util.tbl_detallebecarioFechaFinBeca,
                            Util.tbl_detallebecarioFechaInicioBeca,
                            Util.tbl_detallebecarioObservacion,
                            Util.tbl_detallebecarioSolicitante,
                            Util.tbl_detallebecario_cat_nivelbecaId,
                            Util.tbl_detallebecario_cat_tipobecaId,
                            Util.tbl_detallebecario_cat_zonasId,
                            Util.tbl_detallebecario_tbl_becarioId,
                            Util.tbl_detallebecarioEstado};
        Util tabla = Util.tbl_detallebecario;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_detallebecarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, detalleBecario.getAdscripcion());
            ps.setString(2, detalleBecario.getArea());
//            if (detalleBecario.getFecha() != null) {
//                ps.setDate(3, new Date (detalleBecario.getFecha().getTime()));
//            } else {
//                ps.setNull(3, java.sql.Types.DATE);
//            }
            Calendar c = Calendar.getInstance();
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH)+1);
            String annio = Integer.toString(c.get(Calendar.YEAR));
            String fecha = annio+"-"+mes+"-"+dia;
            detalleBecario.setFecha(fecha);
            ps.setString(3, detalleBecario.getFecha());
            if (detalleBecario.getFechaFinBeca()!= null) {
                ps.setDate(4, new Date (detalleBecario.getFechaFinBeca().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }
            if (detalleBecario.getFecha() != null) {
                ps.setDate(5, new Date (detalleBecario.getFechaInicioBeca().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.setString(6, detalleBecario.getObservacion());
            ps.setString(7, detalleBecario.getSolicitante());
            ps.setInt(8, detalleBecario.getCat_nivelbecaIdDTO());
            ps.setInt(9, detalleBecario.getCat_tipobecaIdDTO());
            ps.setInt(10, detalleBecario.getCat_zonasIdDTO());
            ps.setInt(11, detalleBecario.getTbl_becarioIdDTO());
            ps.setInt(12, detalleBecario.getEstado());
            ps.setInt(13, detalleBecario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying DetalleBecario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_DetalleBecarioDTO buscar(Tbl_DetalleBecarioDTO detalleBecario) {
        if (detalleBecario == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_detallebecarioAdscripcion,
                            Util.tbl_detallebecarioArea,
                            Util.tbl_detallebecarioFecha,
                            Util.tbl_detallebecarioFechaFinBeca,
                            Util.tbl_detallebecarioFechaInicioBeca,
                            Util.tbl_detallebecarioObservacion,
                            Util.tbl_detallebecarioSolicitante,
                            Util.tbl_detallebecario_cat_nivelbecaId,
                            Util.tbl_detallebecario_cat_tipobecaId,
                            Util.tbl_detallebecario_cat_zonasId,
                            Util.tbl_detallebecario_tbl_becarioId,
                            Util.tbl_detallebecarioEstado};
        Util tabla = Util.tbl_detallebecario;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_detallebecarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, detalleBecario.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                detalleBecario.setAdscripcion(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioAdscripcion)));
                detalleBecario.setArea(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioArea)));
                detalleBecario.setFecha(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioFecha)));
                detalleBecario.setFechaFinBeca(rs.getDate(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)));
                detalleBecario.setFechaInicioBeca(rs.getDate(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)));
                detalleBecario.setObservacion(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioObservacion)));
                detalleBecario.setSolicitante(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioSolicitante)));
                detalleBecario.setCat_nivelbecaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)));
                detalleBecario.setCat_tipobecaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)));
                detalleBecario.setCat_zonasIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)));
                detalleBecario.setTbl_becarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)));
                detalleBecario.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecarioEstado)));
            } else { 
                detalleBecario = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            detalleBecario = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return detalleBecario;
    }
    
    public ArrayList<Tbl_DetalleBecarioDTO> obtenerDatos(int clave) {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_DetalleBecarioDTO> lista = new ArrayList();       
        Cat_NivelBecaDTO nivelBecaDTO = new Cat_NivelBecaDTO();

        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            // 1. define la cadena sql
            sql = new StringBuilder(400);
            // sql = select * from cat_nivelbeca
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFecha)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioArea)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioSolicitante)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioAdscripcion)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioObservacion)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioCurp)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioFechaRegistro)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.tbl_becario)).append(" ON ").append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append("=").append(clave);                   
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
//            System.out.println(sql);
            while (rs.next()) {
                Tbl_DetalleBecarioDTO detalleBecarioDTO = new Tbl_DetalleBecarioDTO();
                detalleBecarioDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecarioId)));
                detalleBecarioDTO.setTbl_becarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)));
                detalleBecarioDTO.setFechaInicioBeca(rs.getDate(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)));
                detalleBecarioDTO.setFechaFinBeca(rs.getDate(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)));
                detalleBecarioDTO.setArea(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioArea)));
                detalleBecarioDTO.setSolicitante(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioSolicitante)));
                detalleBecarioDTO.setAdscripcion(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioAdscripcion)));
                nivelBecaDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)));
                detalleBecarioDTO.setNivelBecaDTO(nivelBecaDTO);
                lista.add(detalleBecarioDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
    public Object buscarDetalleBecario(Object t){
        Tbl_DetalleBecarioDTO detalleBecarioDTO;
        if(t instanceof Tbl_DetalleBecarioDTO){
            detalleBecarioDTO = (Tbl_DetalleBecarioDTO)t;            
        }else{
            return null;
        }
        Tbl_BecarioDTO becarioDTO = new Tbl_BecarioDTO();
        Cat_NivelBecaDTO nivelBecaDTO = new Cat_NivelBecaDTO();                
        Cat_TipoBecaDTO tipoBecaDTO = new Cat_TipoBecaDTO();
        Cat_ZonasDTO zonasDTO = new Cat_ZonasDTO();
        
        Connection con = BDConexion.getConexion();

        try {
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        sql = new StringBuilder(400);
       sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFecha)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioArea)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioSolicitante)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioAdscripcion)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioObservacion)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioCurp)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioFechaRegistro)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.tbl_becario)).append(" ON ").append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioId)).append("=").append(detalleBecarioDTO.getId());         
            System.err.println(sql);
            ps = con.prepareStatement(sql.toString());
//           ps.setInt(1, detalleBecarioDTO.getId());
            rs = ps.executeQuery();
            System.err.println(rs);
            if(rs.first()){
                System.err.println("Si entro");
                detalleBecarioDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecarioId)));
                detalleBecarioDTO.setFecha(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioFecha)));
                detalleBecarioDTO.setFechaInicioBeca(rs.getDate(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)));
                detalleBecarioDTO.setFechaFinBeca(rs.getDate(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)));
                detalleBecarioDTO.setArea(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioArea)));
                detalleBecarioDTO.setSolicitante(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioSolicitante)));
                detalleBecarioDTO.setAdscripcion(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioAdscripcion)));
                detalleBecarioDTO.setObservacion(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioObservacion)));
                //DATOS DEL BECARIO
                becarioDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioId)));
                becarioDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioNombre)));
                becarioDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)));
                becarioDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)));
                becarioDTO.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioCurp)));
                becarioDTO.setFechaRegistro(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioFechaRegistro)));
                becarioDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioTelefono)));
                detalleBecarioDTO.setBecarioDTO(becarioDTO);
                //DATOS DEL NIVEL DE BECA 
                nivelBecaDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)));
                detalleBecarioDTO.setNivelBecaDTO(nivelBecaDTO);
                //DATOS DEL TIPO DE BECA
                tipoBecaDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tipobecaNombre)));
                detalleBecarioDTO.setTipoBecaDTO(tipoBecaDTO);
                //DATOS DE LA ZONA 
                zonasDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_zonasNombre)));
                detalleBecarioDTO.setZonasDTO(zonasDTO);                
            }else{
                System.err.println("No entro");
                detalleBecarioDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_DetalleBecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return detalleBecarioDTO;
    }
//    public static void main(String [] arg){
////        Calendar c = Calendar.getInstance();
////        String dia = Integer.toString(c.get(Calendar.DATE));
////        String mes = Integer.toString(c.get(Calendar.MONTH)+1);
////        String annio = Integer.toString(c.get(Calendar.YEAR));
////        
////        String fecha = annio+"-"+mes+"-"+dia;
////        System.out.println("fecha :"+fecha);
////    Tbl_DetalleBecarioDAO detalleBecarioDAO = new Tbl_DetalleBecarioDAO();
////    detalleBecarioDAO.obtenerDatos();
//
//        Connection con = BDConexion.getConexion();
//        try {
//            PreparedStatement ps;
//            ResultSet rs;
//            StringBuilder sql;
//            // 1. define la cadena sql
//            sql = new StringBuilder(400);
//            // sql = select * from cat_nivelbeca
////            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
////                    .append(Utilerias.getPropiedad(Util.ASTERISCO)).append(Utilerias.getPropiedad(Util.ESPACIO))
////                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
////                    .append(Utilerias.getPropiedad(Util.tbl_becario))
////                    .append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(Utilerias.getPropiedad(Util.tbl_becarioEstado)).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(1);
//            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFecha)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioArea)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioSolicitante)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioAdscripcion)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioObservacion)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioNombre)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioCurp)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioFechaRegistro)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioTelefono)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaNombre)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append(", ")
//                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasNombre)).append(" ")
//                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
//                    .append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(" ")
//                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.tbl_becario)).append(" ON ").append(Utilerias.getPropiedad(Util.tbl_becario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_becarioId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_tbl_becarioId)).append(" ")
//                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_nivelbeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_nivelbecaId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_nivelbecaId)).append(" ")
//                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tipobeca)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipobecaId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_tipobecaId)).append(" ")
//                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append("=").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecario_cat_zonasId)).append(" ")
//                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_detallebecario)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_detallebecarioId)).append("=").append(1);
//            ps = con.prepareStatement(sql.toString());
//            rs = ps.executeQuery();
//            System.out.println(sql);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(con != null){
//                     con.close();
//                }               
//            } catch (SQLException ex) {
//                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

}
