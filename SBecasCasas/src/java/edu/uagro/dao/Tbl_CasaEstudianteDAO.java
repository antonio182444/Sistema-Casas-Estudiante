package edu.uagro.dao;

import edu.uagro.dto.Tbl_CasaEstudianteDTO;
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
public class Tbl_CasaEstudianteDAO {

    
    public int insertar(Tbl_CasaEstudianteDTO casaEstudiante) {
        int indice = -1;
        if (casaEstudiante == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_casaestudianteClave,
                            Util.tbl_casaestudianteDireccion,
                            Util.tbl_casaestudianteLatitud,
                            Util.tbl_casaestudianteLongitud,
                            Util.tbl_casaestudianteNombre,
                            Util.tbl_casaestudianteObservacion,
                            Util.tbl_casaestudiante_cat_tipocasaId,
                            Util.tbl_casaestudiante_cat_zonasId};
        Util tabla = Util.tbl_casaestudiante;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, casaEstudiante.getClave());
            ps.setString(2, casaEstudiante.getDireccion());
            ps.setString(3, casaEstudiante.getLatitud());
            ps.setString(4, casaEstudiante.getLongitud());
            ps.setString(5, casaEstudiante.getNombre());
            ps.setString(6, casaEstudiante.getObservacion());
            ps.setInt(7, casaEstudiante.getCat_tipocasaIdDTO());
            ps.setInt(8, casaEstudiante.getCat_zonasIdDTO());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating CasaEstudiante failed, no rows affected.");
            }
            indice = filaMod;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_CasaEstudianteDTO casaEstudiante) {
        boolean band = false;
        if (casaEstudiante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_casaestudianteClave;
        Util tabla = Util.tbl_casaestudiante;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, casaEstudiante.getClave());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating CasaEstudiante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_CasaEstudianteDTO casaEstudiante) {
        boolean band = false;
        if (casaEstudiante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_casaestudianteDireccion,
                            Util.tbl_casaestudianteLatitud,
                            Util.tbl_casaestudianteLongitud,
                            Util.tbl_casaestudianteNombre,
                            Util.tbl_casaestudianteObservacion,
                            Util.tbl_casaestudiante_cat_tipocasaId,
                            Util.tbl_casaestudiante_cat_zonasId,
                            Util.tbl_casaestudianteEstado};
        Util tabla = Util.tbl_casaestudiante;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_casaestudianteClave;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, casaEstudiante.getDireccion());
            ps.setString(2, casaEstudiante.getLatitud());
            ps.setString(3, casaEstudiante.getLongitud());
            ps.setString(4, casaEstudiante.getNombre());
            ps.setString(5, casaEstudiante.getObservacion());
            ps.setInt(6, casaEstudiante.getCat_tipocasaIdDTO());
            ps.setInt(7, casaEstudiante.getCat_zonasIdDTO());
            ps.setInt(8, casaEstudiante.getEstado());
            ps.setString(9, casaEstudiante.getClave());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying CasaEstudiante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_CasaEstudianteDTO buscar(Tbl_CasaEstudianteDTO casaEstudiante) {
        if (casaEstudiante == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_casaestudianteDireccion,
                            Util.tbl_casaestudianteLatitud,
                            Util.tbl_casaestudianteLongitud,
                            Util.tbl_casaestudianteNombre,
                            Util.tbl_casaestudianteObservacion,
                            Util.tbl_casaestudiante_cat_tipocasaId,
                            Util.tbl_casaestudiante_cat_zonasId,
                            Util.tbl_casaestudianteEstado};
        Util tabla = Util.tbl_casaestudiante;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_casaestudianteClave;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, casaEstudiante.getClave());
            rs = ps.executeQuery();
            if(rs.first()){
                casaEstudiante.setDireccion(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteDireccion)));
                casaEstudiante.setLatitud(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteLatitud)));
                casaEstudiante.setLongitud(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteLongitud)));
                casaEstudiante.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteNombre)));
                casaEstudiante.setObservacion(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteObservacion)));
                casaEstudiante.setCat_tipocasaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_casaestudiante_cat_tipocasaId)));
                casaEstudiante.setCat_zonasIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_casaestudiante_cat_zonasId)));
                casaEstudiante.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_casaestudianteEstado)));
            } else { 
                casaEstudiante = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            casaEstudiante = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_CasaEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return casaEstudiante;
    }

}
