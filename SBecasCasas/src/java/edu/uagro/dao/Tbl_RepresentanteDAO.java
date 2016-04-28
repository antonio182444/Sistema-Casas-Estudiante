package edu.uagro.dao;

import edu.uagro.dto.Tbl_RepresentanteDTO;
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
public class Tbl_RepresentanteDAO {

    
    public int insertar(Tbl_RepresentanteDTO representante) {
        int indice = -1;
        if (representante == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteEmail,
                            Util.tbl_representanteMatricula,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteTelefono};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getApellidoMat());
            ps.setString(2, representante.getApellidoPat());
            ps.setString(3, representante.getEmail());
            ps.setString(4, representante.getMatricula());
            ps.setString(5, representante.getNombre());
            ps.setString(6, representante.getTelefono());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Representante failed, no rows affected.");
            }
            indice = filaMod;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_RepresentanteDTO representante) {
        boolean band = false;
        if (representante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_representanteMatricula;
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Representante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_RepresentanteDTO representante) {
        boolean band = false;
        if (representante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteEmail,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEstado};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getApellidoMat());
            ps.setString(2, representante.getApellidoPat());
            ps.setString(3, representante.getEmail());
            ps.setString(4, representante.getNombre());
            ps.setString(5, representante.getTelefono());
            ps.setInt(6, representante.getEstado());
            ps.setString(7, representante.getMatricula());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Representante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_RepresentanteDTO buscar(Tbl_RepresentanteDTO representante) {
        if (representante == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteEmail,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEstado};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            rs = ps.executeQuery();
            if(rs.first()){
                representante.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representante.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representante.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                representante.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representante.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representante.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteEstado)));
            } else { 
                representante = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            representante = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return representante;
    }

}
