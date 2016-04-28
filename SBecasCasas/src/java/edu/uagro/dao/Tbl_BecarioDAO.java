package edu.uagro.dao;

import edu.uagro.dto.Tbl_BecarioDTO;
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
public class Tbl_BecarioDAO {

    
    public int insertar(Tbl_BecarioDTO becario) {
        int indice = -1;
        if (becario == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioApellidoMat,
                            Util.tbl_becarioApellidoPat,
                            Util.tbl_becarioCurp,
                            Util.tbl_becarioFechaRegistro,
                            Util.tbl_becarioNombre,
                            Util.tbl_becarioTelefono};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, becario.getApellidoMat());
            ps.setString(2, becario.getApellidoPat());
            ps.setString(3, becario.getCurp());
            ps.setString(4, becario.getNombre());
            ps.setString(5, becario.getTelefono());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Becario failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                becario.setId(indice);
            } else {
                throw new SQLException("Creating Becario failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_BecarioDTO becario) {
        boolean band = false;
        if (becario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_becarioId;
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, becario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Becario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_BecarioDTO becario) {
        boolean band = false;
        if (becario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioApellidoMat,
                            Util.tbl_becarioApellidoPat,
                            Util.tbl_becarioCurp,
                            Util.tbl_becarioFechaRegistro,
                            Util.tbl_becarioNombre,
                            Util.tbl_becarioTelefono,
                            Util.tbl_becarioEstado};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, becario.getApellidoMat());
            ps.setString(2, becario.getApellidoPat());
            ps.setString(3, becario.getCurp());
            ps.setString(4, becario.getNombre());
            ps.setString(5, becario.getTelefono());
            ps.setInt(6, becario.getEstado());
            ps.setInt(7, becario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Becario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_BecarioDTO buscar(Tbl_BecarioDTO becario) {
        if (becario == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioApellidoMat,
                            Util.tbl_becarioApellidoPat,
                            Util.tbl_becarioCurp,
                            Util.tbl_becarioFechaRegistro,
                            Util.tbl_becarioNombre,
                            Util.tbl_becarioTelefono,
                            Util.tbl_becarioEstado};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, becario.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                becario.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)));
                becario.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)));
                becario.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioCurp)));
                becario.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioNombre)));
                becario.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioTelefono)));
                becario.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioEstado)));
            } else { 
                becario = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            becario = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return becario;
    }

}
