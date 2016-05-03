package edu.uagro.dao;

import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.Date;
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
public class Tbl_ExpedienteCasaDAO {

    
    public int insertar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        int indice = -1;
        if (expedienteCasa == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            if (expedienteCasa.getFechaFinalArrendamiento() != null) {
                ps.setDate(1, new Date (expedienteCasa.getFechaFinalArrendamiento().getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicialArrendamiento() != null) {
                ps.setDate(2, new Date (expedienteCasa.getFechaInicialArrendamiento().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicio() != null) {
                ps.setDate(3, new Date (expedienteCasa.getFechaInicio().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }
            ps.setDouble(4, expedienteCasa.getMontoRenta());
            ps.setString(5, expedienteCasa.getTipoRenta());
            ps.setInt(6, expedienteCasa.getTbl_arrendadorIdDTO());
            ps.setInt(7, expedienteCasa.getTbl_arrendatarioIdDTO());
            ps.setInt(8, expedienteCasa.getTbl_casaestudianteClaveDTO());
            ps.setString(9, expedienteCasa.getTbl_representanteMatriculaDTO());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating ExpedienteCasa failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                expedienteCasa.setId(indice);
            } else {
                throw new SQLException("Creating ExpedienteCasa failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        boolean band = false;
        if (expedienteCasa == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_expedientecasaId;
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasa.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating ExpedienteCasa failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        boolean band = false;
        if (expedienteCasa == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaEstado};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            if (expedienteCasa.getFechaFinalArrendamiento() != null) {
                ps.setDate(1, new Date (expedienteCasa.getFechaFinalArrendamiento().getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicialArrendamiento() != null) {
                ps.setDate(2, new Date (expedienteCasa.getFechaInicialArrendamiento().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicio() != null) {
                ps.setDate(3, new Date (expedienteCasa.getFechaInicio().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }
            ps.setDouble(4, expedienteCasa.getMontoRenta());
            ps.setString(5, expedienteCasa.getTipoRenta());
            ps.setInt(6, expedienteCasa.getTbl_arrendadorIdDTO());
            ps.setInt(7, expedienteCasa.getTbl_arrendatarioIdDTO());
            ps.setInt(8, expedienteCasa.getTbl_casaestudianteClaveDTO());
            ps.setString(9, expedienteCasa.getTbl_representanteMatriculaDTO());
            ps.setInt(10, expedienteCasa.getEstado());
            ps.setInt(11, expedienteCasa.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying ExpedienteCasa failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_ExpedienteCasaDTO buscar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        if (expedienteCasa == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaEstado};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasa.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                expedienteCasa.setFechaFinalArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaFinalArrendamiento)));
                expedienteCasa.setFechaInicialArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaInicialArrendamiento)));
                expedienteCasa.setFechaInicio(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaRegistro)));
                expedienteCasa.setMontoRenta(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoRenta)));
                expedienteCasa.setTipoRenta(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaTipoRenta)));
                expedienteCasa.setTbl_arrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)));
                expedienteCasa.setTbl_arrendatarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)));
                expedienteCasa.setTbl_casaestudianteClaveDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)));
                expedienteCasa.setTbl_representanteMatriculaDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_representanteMatricula)));
                expedienteCasa.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaEstado)));
            } else { 
                expedienteCasa = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            expedienteCasa = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expedienteCasa;
    }

}
