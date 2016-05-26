/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Cat_ZonasDAO;
import edu.uagro.dto.Cat_ZonasDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Cat_ZonasBO {
         public ArrayList<Cat_ZonasDTO> obtenerZonas(){
         Cat_ZonasDAO zonasDAO  = new Cat_ZonasDAO();
         return zonasDAO.obtenerZonas();
     }
}
