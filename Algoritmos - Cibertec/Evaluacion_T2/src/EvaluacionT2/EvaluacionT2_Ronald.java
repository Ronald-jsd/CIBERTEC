package EvaluacionT2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

class EvaluacionT2_Ronald extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblMarca;
	private JLabel lblCantidad;

	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;

	private JButton btnProcesar;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	int ctd = 0, Marca, obsequio1 = 0;
	double precio = 0, ICompra = 0, dscto = 0, IPagar = 0, IDscto = 0;

	double ITotal0 = 0, ITotal1 = 0, ITotal2 = 0, ITotal3 = 0, ITotal4 = 0;
	int VentaAc0 = 0, VentaAc1 = 0, VentaAc2 = 0, VentaAc3 = 0, VentaAc4 = 0;
	int ctdUndVendidas0, ctdUndVendidas1, ctdUndVendidas2, ctdUndVendidas3, ctdUndVendidas4;
	String material;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					EvaluacionT2_Ronald frame = new EvaluacionT2_Ronald();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	public EvaluacionT2_Ronald() {

		setTitle("Tienda de Zapatillas");
		setBounds(150, 100, 450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblMarca = new JLabel("MARCA");
		lblMarca.setBounds(10, 13, 120, 14);
		getContentPane().add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 38, 80, 14);
		getContentPane().add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(
				new DefaultComboBoxModel<String>(new String[] { "NIKE", "ADIDAS", "PUMA", "REBOOK", "UMBRO" }));
		cboMarca.setBounds(90, 10, 130, 20);
		getContentPane().add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(90, 35, 130, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(4);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 9, 89, 23);
		getContentPane().add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 69, 414, 450);
		getContentPane().add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
		txtS.setEditable(false);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);

		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		if (txtCantidad.getText().isEmpty() || txtCantidad.getText().equals("0")) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad");
		} else {
			EntradadeDatos();
			CalculoPrecio();
			CalculoICompra();
			Calculodescuento();
			CalculoIDescuento();
			CalculoIPagar();
			CalculoITotalyVentaTotal();
			CalculoObsequio();
			SalidadeResultados();
		}
	}

	void EntradadeDatos() {
		Marca = cboMarca.getSelectedIndex();
		ctd = Integer.parseInt(txtCantidad.getText());
	}

	void CalculoPrecio() {
		switch (Marca) {
		case 0:
			precio = 390;
			break;
		case 1:
			precio = 299;
			break;
		case 2:
			precio = 190;
			break;
		case 3:
			precio = 150;
			break;
		case 4:
			precio = 129;
			break;
		}
	}

	void CalculoICompra() {
		ICompra = precio * ctd;
	}

	void Calculodescuento() {
		if (ctd <= 3)
			dscto = 0.065;
		else if (ctd <= 6)
			dscto = 0.085;
		else if (ctd <= 10)
			dscto = 0.1;
		else
			dscto = 0.13;
	}

	void CalculoIDescuento() {
		IDscto = (dscto * ICompra);
	}

	void CalculoIPagar() {
		IPagar = ICompra - IDscto;
	}

	void CalculoObsequio() {
		if (IPagar < 3500) {
			obsequio1 = ctd / 2;
			material = "camisetas";
		} else if (IPagar >= 3500) {
			obsequio1 = 2 * (ctd / 3);
			material = "pelotas";
		}
	}

	void CalculoITotalyVentaTotal() {
		switch (Marca) {
		case 0:
			ITotal0 += IPagar;
			VentaAc0++;
			ctdUndVendidas0 += ctd;
			break;
		case 1:
			ITotal1 += IPagar;
			VentaAc1++;
			ctdUndVendidas1 += ctd;
			break;
		case 2:
			ITotal2 += IPagar;
			VentaAc2++;
			ctdUndVendidas2 += ctd;

			break;
		case 3:
			ITotal3 += IPagar;
			VentaAc3++;
			ctdUndVendidas3 += ctd;

		default:
			ITotal4 += IPagar;
			VentaAc4++;
			ctdUndVendidas4 += ctd;

		}
	}

	void SalidadeResultados() {
		txtS.setText("");
		imprimir("---------------------------------------------");
		imprimir("DATOS POR COMPRA UNICA");
		imprimir("El Importe de compra es: S/" + ICompra);
		imprimir("El Importe de descuento es: S/" + IDscto);
		imprimir("El Importe a pagar es: S/" + IPagar);
		imprimir("El obsequio es: " + obsequio1 + " " + material);

		imprimir("---------------------------------------------");

		imprimir("IMPORTE TOTAL POR MARCA DE ZAPATILLA");
		imprimir("*El Importe total de NIKE: " + ITotal0);
		imprimir("*El Importe total de ADIDAS: " + ITotal1);
		imprimir("*El Importe total de PUMA: " + ITotal2);
		imprimir("*El Importe total de REBOOK: " + ITotal3);
		imprimir("*El Importe total de UMBRO: " + ITotal4);

		imprimir("---------------------------------------------");

		imprimir("CANTIDAD DE VENTAS POR MARCA DE ZAPATILLA");
		imprimir("*La venta total de NIKE: " + VentaAc0);
		imprimir("*La venta total de ADIDAS: " + VentaAc1);
		imprimir("*La venta total de PUMA: " + VentaAc2);
		imprimir("*La venta total de REBOOK: " + VentaAc3);
		imprimir("*La venta total de UMBRO: " + VentaAc4);

		imprimir("---------------------------------------------");

		imprimir("CANTIDAD DE UNIDADES TOTALES VENDIDAS POR MARCA");
		imprimir("*La venta de unidades de NIKE: " + ctdUndVendidas0);
		imprimir("*La venta de unidades de ADIDAS: " + ctdUndVendidas1);
		imprimir("*La venta de unidades de PUMA: " + ctdUndVendidas2);
		imprimir("*La venta de unidades de REBOOK: " + ctdUndVendidas3);
		imprimir("*La venta de unidades de UMBRO: " + ctdUndVendidas4);
	}

	void imprimir(String cadena) {
		txtS.append(cadena + "\n");
	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
}
