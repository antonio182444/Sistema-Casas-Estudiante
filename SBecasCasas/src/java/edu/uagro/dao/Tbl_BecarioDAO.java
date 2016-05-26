package edu.uagro.dao;

import edu.uagro.dto.Tbl_BecarioDTO;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tbl_BecarioDAO {
    
    public void insertar (Tbl_BecarioDTO becarioDTO){
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioId,
                           Util.tbl_becarioNombre,
                           Util.tbl_becarioApellidoPat,
                           Util.tbl_becarioApellidoMat,
                           Util.tbl_becarioCurp,
                           Util.tbl_becarioFechaRegistro,
                           Util.tbl_becarioEstado,
                           Util.tbl_becarioTelefono};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, becarioDTO.getId());
            ps.setString(2, becarioDTO.getNombre());
            ps.setString(3, becarioDTO.getApellidoPat());
            ps.setString(4, becarioDTO.getApellidoMat());
            ps.setString(5, becarioDTO.getCurp());
//            java.util.Date utilDate = becarioDTO.getFechaRegistro();
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setString(6, becarioDTO.getFechaRegistro());
            becarioDTO.setEstado(1);
            ps.setInt(7, becarioDTO.getEstado());
            ps.setString(8, becarioDTO.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public boolean validarBecarioExiste(Tbl_BecarioDTO becarioDTO){
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        ResultSet rs;
        Util[] columnas = {Util.tbl_becarioId};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql.append(" WHERE ").append(columnaCondicion).append("=").append(becarioDTO.getId());
        try {
             ps = con.prepareStatement(sql.toString());
             rs = ps.executeQuery();
             if(rs.first()){
                 return true;
             }
        } catch (Exception e) {
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    public boolean eliminar(Object t){
        Tbl_BecarioDTO becarioDTO;
        if(t instanceof Tbl_BecarioDTO){
            becarioDTO = (Tbl_BecarioDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_becarioEstado;
        Util tabla = Util.tbl_becario;
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.prepareUpdate(tabla, columna);
        sql.append(" WHERE ").append(columnaCondicion).append("=").append(becarioDTO.getId());
        try {
            System.out.println(sql);
            ps = con.prepareStatement(sql.toString());
            becarioDTO.setEstado(0);
            ps.setInt(1, becarioDTO.getEstado());            
            
            int filaMod = ps.executeUpdate();
            if(filaMod == 0){
                throw new SQLException("Eliminating Tbl_Becario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return band;
    }
    
    public boolean bajaBecario(Tbl_BecarioDTO becario) {
        boolean band = false;
        if (becario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioEstado};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            becario.setEstado(0);
            ps.setInt(1, becario.getEstado());
            ps.setInt(2, becario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Becario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                    con.close();
                }                
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }
    
    public boolean reactivarBecario(Tbl_BecarioDTO becario) {
        boolean band = false;
        if (becario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioEstado};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            becario.setEstado(1);
            ps.setInt(1, becario.getEstado());
            ps.setInt(2, becario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Becario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                    con.close();
                }                
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }
    
    public boolean modificarBecario(Tbl_BecarioDTO becario) {
        boolean band = false;
        if (becario == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioTelefono};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            becario.setEstado(0);
            ps.setString(1, becario.getTelefono());
            ps.setInt(2, becario.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Becario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                    con.close();
                }                
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }    
    
    
    public Object buscar(Object t){
        Tbl_BecarioDTO becarioDTO;
        if(t instanceof Tbl_BecarioDTO){
            becarioDTO = (Tbl_BecarioDTO)t;            
        }else{
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
         Util[] columnas = {Util.tbl_becarioId,
                           Util.tbl_becarioNombre,
                           Util.tbl_becarioApellidoPat,
                           Util.tbl_becarioApellidoMat,
                           Util.tbl_becarioCurp,
                           Util.tbl_becarioFechaRegistro,
                           Util.tbl_becarioEstado,
                           Util.tbl_becarioTelefono};
        Util tabla = Util.tbl_becario;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, becarioDTO.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                becarioDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioId)));
                becarioDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioNombre)));
                becarioDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)));
                becarioDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)));
                becarioDTO.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioCurp)));
                becarioDTO.setFechaRegistro(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioFechaRegistro)));
                becarioDTO.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioEstado)));
                becarioDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioTelefono)));
            }else{
                becarioDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return becarioDTO;
    }
    
    public ArrayList<Tbl_BecarioDTO> obtenerDatos() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_BecarioDTO> lista = new ArrayList();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            // 1. define la cadena sql
            sql = new StringBuilder(400);
            // sql = select * from cat_nivelbeca
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.ASTERISCO)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_becario))
                    .append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(Utilerias.getPropiedad(Util.tbl_becarioEstado)).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(1);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_BecarioDTO dto = new Tbl_BecarioDTO();
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioId)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioNombre)));
                dto.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)));
                dto.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)));
                dto.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioCurp)));
                lista.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
    public ArrayList<Tbl_BecarioDTO> obtenerDatosBecarioBaja() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_BecarioDTO> lista = new ArrayList();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            // 1. define la cadena sql
            sql = new StringBuilder(400);
            // sql = select * from cat_nivelbeca
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.ASTERISCO)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_becario))
                    .append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(Utilerias.getPropiedad(Util.tbl_becarioEstado)).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(0);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_BecarioDTO dto = new Tbl_BecarioDTO();
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioId)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioNombre)));
                dto.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoPat)));
                dto.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioApellidoMat)));
                dto.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioCurp)));
                lista.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }   
    
    
    
//    public static void main(String [] arg){
//    java.util.Date utilDate = new java.util.Date();
//    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//    System.out.println("utilDate:" + utilDate);
//    System.out.println("sqlDate:" + sqlDate);
//        Tbl_BecarioDTO becarioDTO = new Tbl_BecarioDTO();
//        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
//
//        becarioDTO.setId(303031);
//        becarioDTO.setNombre("Fernando");
//        becarioDTO.setApellidoPat("Prueba");
//        becarioDTO.setApellidoMat("Cipriano");
//        becarioDTO.setCurp("RACF910228HGRMPR02");
//        becarioDTO.setFechaRegistro("2016/02/27");
//        becarioDTO.setTelefono("7471054389");
//        //INSERTAR BECARIO 
////        becarioDAO.insertar(becarioDTO);
//
//        //validar si el becario ya se encuentra en el sistema
////        System.out.println(becarioDAO.validarBecarioExiste(becarioDTO));
////      Eliminar Becario
//        becarioDAO.eliminar(becarioDTO);
//    
//
//    }
}
