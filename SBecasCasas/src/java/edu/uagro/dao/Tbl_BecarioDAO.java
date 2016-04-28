package edu.uagro.dao;

import edu.uagro.dto.Tbl_BecarioDTO;
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
    
//    public static void main(String [] arg){
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
