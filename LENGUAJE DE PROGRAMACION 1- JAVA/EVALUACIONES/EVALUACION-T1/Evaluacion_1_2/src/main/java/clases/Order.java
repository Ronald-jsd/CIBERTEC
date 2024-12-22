package clases;

public class Order {

	private String nameProduct ;
	private int cantidad;
	private double precioProducto;
	private double total;
	
	public Order(String nameProduct, int cantidad, double precioProducto, double total) {
		super();
		this.nameProduct = nameProduct;
		this.cantidad = cantidad;
		this.precioProducto = precioProducto;
		this.total = total;
	}

	public String getNameProduct() {
		return nameProduct;
	}


	public int getCantidad() {
		return cantidad;
	}


	public double getPrecioProducto() {
		return precioProducto;
	}


	public double getTotal() {
		return total;
	}

	
	
}
