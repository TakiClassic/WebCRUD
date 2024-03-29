package DAO;

import con.Conexion;
import java.sql.PreparedStatement;
import java.util.List;


public class DAOProductoImpl extends Conexion implements DAOProducto {

  public void listar(Producto pro) throws Exception {
    try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("{call USP_READ_PRODUCTOS (?)}");
            st.setInt(1, pro.getId());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    public void modificar(Producto pro) throws Exception {
    try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("{call UPS_ACTUALIZAR_PRODUCTOS (?,?,?,?,?)}");
            st.setInt(1, pro.getId());
            st.setString(2, pro.getName());
            st.setString(3, pro.getState());
            st.setInt(4, pro.getPrice());
            st.setInt(5, pro.getMarca());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    public void eliminar(Producto pro) throws Exception {
    try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("{call USP_PRODUCTOS_BORRAR_POR_ID (?)}");
            st.setInt(1, pro.getId());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void registrar(Producto pro) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("{call UPS_CREAR_PRODUCTOS (?,?,?,?)}");
            st.setString(1, pro.getName());
            st.setString(2, pro.getState());
            st.setInt(3, pro.getPrice());
            st.setInt(4, pro.getMarca());
            st.execute();
        }catch(Exception e){
            System.out.println("Error: " + " " + e);
            throw e;
        }finally{
            this.cerrar();
        }
    }

    public List<Producto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
