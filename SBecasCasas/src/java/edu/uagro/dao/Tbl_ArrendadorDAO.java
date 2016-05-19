package edu.uagro.dao;

import edu.uagro.dto.Tbl_ArrendadorDTO;
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

public class Tbl_ArrendadorDAO {
    
    public int insertar (Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendadorNombre,
                           Util.tbl_arrendadorNumProveedor,
                           Util.tbl_arrendadorRFC,
                           Util.tbl_arrendadorApellidoPat,
                           Util.tbl_arrendadorApellidoMat,
                           Util.tbl_arrendadorDomicilio,
                           Util.tbl_arrendadorCurp,
                           Util.tbl_arrendadorTelefono,
                           Util.tbl_arrendadorEmail,
                           Util.tbl_arrendador_cat_tipoarrendadorId};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, arrendadorDTO.getNombre());
            ps.setString(2, arrendadorDTO.getNumProveedor());
            ps.setString(3, arrendadorDTO.getRFC());
            ps.setString(4, arrendadorDTO.getApellidoPat());
            ps.setString(5, arrendadorDTO.getApellidoMat());
            ps.setString(6, arrendadorDTO.getDomicilio());
            ps.setString(7, arrendadorDTO.getCurp());
            ps.setString(8, arrendadorDTO.getTelefono());
            ps.setString(9, arrendadorDTO.getEmail());
            ps.setInt(10, arrendadorDTO.getCat_tipoarrendadorIdDTO());
            int filMod = ps.executeUpdate();
            if(filMod == 0){
                throw new SQLException("Creating Tbl_Arrendador failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if(rs.first()){
                indice = rs.getInt(1);
                arrendadorDTO.setId(indice);
            }else{
                throw new SQLException("Creating Tbl_Arrendador failed, no ID obtained.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return indice;
    }
        
    public boolean eliminar(Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_arrendadorId;
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, arrendadorDTO.getId());
            int filaMod = ps.executeUpdate();
            if(filaMod == 0){
                throw new SQLException("Eliminating Tbl_Arrendador failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return band;
    }
    
    public boolean modificar(Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendadorNombre,
                           Util.tbl_arrendadorNumProveedor,
                           Util.tbl_arrendadorRFC,
                           Util.tbl_arrendadorApellidoPat,
                           Util.tbl_arrendadorApellidoMat,
                           Util.tbl_arrendadorDomicilio,
                           Util.tbl_arrendadorCurp,
                           Util.tbl_arrendadorTelefono,
                           Util.tbl_arrendadorEmail,
                           Util.tbl_arrendador_cat_tipoarrendadorId};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_arrendadorId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, arrendadorDTO.getNombre());
            ps.setString(2, arrendadorDTO.getNumProveedor());
            ps.setString(3, arrendadorDTO.getRFC());
            ps.setString(4, arrendadorDTO.getApellidoPat());
            ps.setString(5, arrendadorDTO.getApellidoMat());
            ps.setString(6, arrendadorDTO.getDomicilio());
            ps.setString(7, arrendadorDTO.getCurp());
            ps.setString(8, arrendadorDTO.getTelefono());
            ps.setString(9, arrendadorDTO.getEmail());
            ps.setInt(10, arrendadorDTO.getCat_tipoarrendadorIdDTO());
            ps.setInt(11, arrendadorDTO.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Tbl_Arrendador failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return band;
    }
    
    public Object buscar(Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
         Util[] columnas = {Util.tbl_arrendadorNombre,
                            Util.tbl_arrendadorNumProveedor,
                            Util.tbl_arrendadorRFC,
                            Util.tbl_arrendadorApellidoPat,
                            Util.tbl_arrendadorApellidoMat,
                            Util.tbl_arrendadorDomicilio,
                            Util.tbl_arrendadorCurp,
                            Util.tbl_arrendadorTelefono,
                            Util.tbl_arrendadorEmail,
                            Util.tbl_arrendador_cat_tipoarrendadorId};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_arrendadorId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, arrendadorDTO.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                arrendadorDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                arrendadorDTO.setNumProveedor(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)));
                arrendadorDTO.setRFC(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)));
                arrendadorDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoPat)));
                arrendadorDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoMat)));
                arrendadorDTO.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)));
                arrendadorDTO.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)));
                arrendadorDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)));
                arrendadorDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)));
                arrendadorDTO.setCat_tipoarrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)));
            }else{
                arrendadorDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return arrendadorDTO;
    }
    
//    public static void main(String [] arg){
//        Tbl_ArrendadorDAO arrendadorDAO = new Tbl_ArrendadorDAO();
//        Tbl_ArrendadorDTO arrendadorDTO = new Tbl_ArrendadorDTO();
//        arrendadorDTO.setNombre("Fernando Mod");
//        arrendadorDTO.setApellidoPat("Ramirez Mod");
//        arrendadorDTO.setApellidoMat("Cipriano");
//        arrendadorDTO.setDomicilio("Conocido");
//        arrendadorDTO.setCurp("RACF910228HGRMPR02");
//        arrendadorDTO.setTelefono("7471054389");
//        arrendadorDTO.setEmail("racf1991@gmail.com");
//        arrendadorDTO.setCat_tipoarrendadorIdDTO(1);
//        arrendadorDTO.setId(1);
        //INSERTAR
//        arrendadorDAO.insertar(arrendadorDTO);
        //modificar         
//        arrendadorDAO.modificar(arrendadorDTO);
        //Eliminar
//        arrendadorDAO.eliminar(arrendadorDTO);
        
//    }
}
