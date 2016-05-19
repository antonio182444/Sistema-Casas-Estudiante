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
        Util[] columnas = { Util.tbl_representanteMatricula,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteSexo,
                            Util.tbl_representanteUAcademica,
                            Util.tbl_representanteGrado,
                            Util.tbl_representanteTurno,
                            Util.tbl_representantePromedio,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEmail,
                            Util.tbl_representante_cat_tiporepresentanteId
                           
    };
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            ps.setString(2, representante.getNombre());
            ps.setString(3, representante.getApellidoMat());
            ps.setString(4, representante.getApellidoPat());
            ps.setString(5, representante.getSexo());
            ps.setString(6, representante.getUAcademica());
            ps.setInt(7, representante.getGrado());
            ps.setString(8, representante.getTurno());
            ps.setDouble(9, representante.getPromedio());
            ps.setString(10, representante.getTelefono());
            ps.setString(11, representante.getEmail());
            ps.setInt(12, representante.getCat_tiporepresentanteIdDTO());
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
        Util columna[] ={ Util.tbl_representanteEstado};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareUpdate(tabla);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            representante.setEstado(0);
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, representante.getEstado());
            ps.setString(2, representante.getMatricula());
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
        Util[] columnas = { Util.tbl_representanteMatricula,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteSexo,
                            Util.tbl_representanteUAcademica,
                            Util.tbl_representanteGrado,
                            Util.tbl_representanteTurno,
                            Util.tbl_representantePromedio,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEmail,
                            Util.tbl_representante_cat_tiporepresentanteId};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            ps.setString(2, representante.getNombre());
            ps.setString(3, representante.getApellidoMat());
            ps.setString(4, representante.getApellidoPat());
            ps.setString(5, representante.getSexo());
            ps.setString(6, representante.getUAcademica());
            ps.setInt(7, representante.getGrado());
            ps.setString(8, representante.getTurno());
            ps.setDouble(9, representante.getPromedio());
            ps.setString(10, representante.getTelefono());
            ps.setString(11, representante.getEmail());
            ps.setInt(12, representante.getCat_tiporepresentanteIdDTO());
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
        Util[] columnas = { Util.tbl_representanteMatricula,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteSexo,
                            Util.tbl_representanteUAcademica,
                            Util.tbl_representanteGrado,
                            Util.tbl_representanteTurno,
                            Util.tbl_representantePromedio,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEmail,
                            Util.tbl_representante_cat_tiporepresentanteId};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            rs = ps.executeQuery();
            if(rs.first()){
                representante.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMatricula)));
                representante.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representante.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representante.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representante.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteSexo)));
                representante.setUAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)));
                representante.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteGrado)));
                representante.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTurno)));
                representante.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_representantePromedio)));
                representante.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                representante.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representante.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteEstado)));
                representante.setCat_tiporepresentanteIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)));
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
