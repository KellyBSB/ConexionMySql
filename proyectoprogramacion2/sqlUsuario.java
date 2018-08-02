/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class sqlUsuario extends Conectar{
    Conectar conectar= new Conectar();
Connection cn= conectar.conexion();
    public boolean registrar(Usuarios usr){
       PreparedStatement pst= null;
       Conectar conectar= new Conectar();
       Connection  cn= conectar.conexion();
       String sql ="Insert into usuarios(cedula,contraseña) values(?,?)";
      try{
           pst = cn.prepareStatement(sql);
           pst.setString(1, usr.getCedula());
           pst.setString(1, usr.getContasenia());
           pst.execute();
           return true;
           
           
           
           
      }catch(Exception ex){
         return false;
    }
      
    }
    
     public boolean login(Usuarios usr){
        PreparedStatement pst=null;
        ResultSet rs= null;
        String sql="Select cedula,contaseña FROM usuarios WHERE cedula=? ";
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, usr.getCedula());
            rs=pst.executeQuery();
            if(rs.next()){
                if(usr.getContasenia().equals(rs.getString(2))){
                    usr.setCedula(rs.getString(1));
                    return true;
                   
                }else{
                    return false;
                }
                
                
            }
            return false;
        }catch(Exception e){
                return false;
        }
    }
    
}
