package AppTFG;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Daoproducto {
Conexion cx;
public  Daoproducto() {
	cx = new Conexion();

}
public boolean insertarProducto(Producto prod) {
    PreparedStatement ps = null;
    try {

        ps = cx.conectar().prepareStatement(
            "INSERT INTO Productos (nombre, stock, ventas, precio, descripcion) VALUES (?, ?, ?, ?, ?)"
        );
        ps.setString(1, prod.getNombre()); 
        ps.setInt(2, prod.getStock());      
        ps.setInt(3, prod.getVentas());     
        ps.setDouble(4, prod.getPrecio());  
        ps.setString(5, prod.getDescripcion());  

        ps.executeUpdate();  
        cx.desconectar();    
        return true;         
    } catch (SQLException e) {
        e.printStackTrace();  
        return false;       
    }
}
public ArrayList<Producto> consultaProducto(){
	ArrayList<Producto> lista= new ArrayList<Producto>();
	PreparedStatement ps = null;
	ResultSet rs= null;
	try {
		ps= cx.conectar().prepareStatement("SELECT * FROM Productos");
		rs= ps.executeQuery();
		while(rs.next()) {
			Producto prod= new Producto();
			prod.setId(rs.getInt("id"));
			 prod.setNombre(rs.getString("nombre"));  
	            prod.setStock(rs.getInt("stock"));     
	            prod.setVentas(rs.getInt("ventas"));     
	            prod.setPrecio(rs.getDouble("precio")); 
	            prod.setDescripcion(rs.getString("descripcion")); 
	            lista.add(prod); 
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lista;
}
public boolean eliminarProducto(int id) {
    PreparedStatement ps = null;
    try {

        ps = cx.conectar().prepareStatement(
            "DELETE FROM productos WHERE id=?"
        );
        ps.setInt(1, id); 

        ps.executeUpdate();  
        cx.desconectar();    
        return true;         
    } catch (SQLException e) {
        e.printStackTrace();  
        return false;       
    }
}
public boolean editarProducto(Producto prod) {
    PreparedStatement ps = null;
    try {

        ps = cx.conectar().prepareStatement(
            "UPDATE Productos SET nombre=?, stock=?, ventas=?, precio=?, descripcion=? WHERE id=? "
        );
        ps.setString(1, prod.getNombre()); 
        ps.setInt(2, prod.getStock());      
        ps.setInt(3, prod.getVentas());     
        ps.setDouble(4, prod.getPrecio());  
        ps.setString(5, prod.getDescripcion());  
        ps.setInt(6, prod.getId());
        ps.executeUpdate();  
        cx.desconectar();    
        return true;         
    } catch (SQLException e) {
        e.printStackTrace();  
        return false;       
    }
}
}
