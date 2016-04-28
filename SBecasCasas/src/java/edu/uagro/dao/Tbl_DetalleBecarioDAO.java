package edu.uagro.dao;

import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            ps.setString(3, detalleBecario.getFecha());
            ps.setString(4, detalleBecario.getFechaFinBeca());
            ps.setString(5, detalleBecario.getFechaInicioBeca());
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
            ps.setString(3, detalleBecario.getFecha());
            ps.setString(4, detalleBecario.getFechaFinBeca());
            ps.setString(5, detalleBecario.getFechaInicioBeca());
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
                detalleBecario.setFechaFinBeca(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaFinBeca)));
                detalleBecario.setFechaInicioBeca(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecarioFechaInicioBeca)));
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

}
