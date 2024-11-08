package AppTFG;

public class Producto {
	    private int id;
	    private int stock;
	    private int ventas;
	    private String nombre;
	    private String descripcion;
	    private double precio;
	   
	    public Producto() {}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public int getVentas() {
			return ventas;
		}

		public void setVentas(int ventas) {
			this.ventas = ventas;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

}
