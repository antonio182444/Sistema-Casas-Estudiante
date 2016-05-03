package edu.uagro.dao;

import edu.uagro.dto.Tbl_ResponsableDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_ResponsableDAO {

    
    public int insertar(Tbl_ResponsableDTO responsable) {
        int indice = -1;
        if (responsable == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_responsableApellidoMat,
                            Util.tbl_responsableApellidoPat,
                            Util.tbl_responsableEmail,
                            Util.tbl_responsableNombre,
                            Util.tbl_responsable_cat_zonasId};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, responsable.getApellidoMat());
            ps.setString(2, responsable.getApellidoPat());
            ps.setString(3, responsable.getEmail());
            ps.setString(4, responsable.getNombre());
            ps.setInt(5, responsable.getCat_zonasIdDTO());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Responsable failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                responsable.setId(indice);
            } else {
                throw new SQLException("Creating Responsable failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_ResponsableDTO responsable) {
        boolean band = false;
        if (responsable == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_responsableId;
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, responsable.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Responsable failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_ResponsableDTO responsable) {
        boolean band = false;
        if (responsable == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_responsableApellidoMat,
                            Util.tbl_responsableApellidoPat,
                            Util.tbl_responsableEmail,
                            Util.tbl_responsableNombre,
                            Util.tbl_responsable_cat_zonasId,
                            Util.tbl_responsableEstado};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_responsableId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, responsable.getApellidoMat());
            ps.setString(2, responsable.getApellidoPat());
            ps.setString(3, responsable.getEmail());
            ps.setString(4, responsable.getNombre());
            ps.setInt(5, responsable.getCat_zonasIdDTO());
            ps.setInt(6, responsable.getEstado());
            ps.setInt(7, responsable.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Responsable failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_ResponsableDTO buscar(Tbl_ResponsableDTO responsable) {
        if (responsable == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_responsableApellidoMat,
                            Util.tbl_responsableApellidoPat,
                            Util.tbl_responsableEmail,
                            Util.tbl_responsableNombre,
                            Util.tbl_responsable_cat_zonasId,
                            Util.tbl_responsableEstado};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_responsableId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, responsable.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                responsable.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)));
                responsable.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)));
                responsable.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableEmail)));
                responsable.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableNombre)));
                responsable.setCat_zonasIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)));
                responsable.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsableEstado)));
            } else { 
                responsable = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            responsable = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return responsable;
    }

}
