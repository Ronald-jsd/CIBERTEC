package cibertecEjercicios;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class Ejercicio008_ifelseCBOdoblecategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRuta;
	private JLabel lblCalidad;
	private JComboBox cboRuta;
	private JComboBox cboCalidad;
	private JButton lblCalcular;
	private JTextArea txtS;
	private JLabel lblCantidad;
	private JTextField txtCantidad;

	int ruta, calidad;
	double precio = 0, cantidad, ICompra, IDescuento = 0, IPagar = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio008_ifelseCBOdoblecategoria frame = new Ejercicio008_ifelseCBOdoblecategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio008_ifelseCBOdoblecategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblRuta = new JLabel("Ruta");
			lblRuta.setBounds(27, 39, 45, 13);
			contentPane.add(lblRuta);
		}
		{
			lblCalidad = new JLabel("Calidad");
			lblCalidad.setBounds(27, 74, 45, 13);
			contentPane.add(lblCalidad);
		}
		{
			cboRuta = new JComboBox();
			cboRuta.setModel(new DefaultComboBoxModel(new String[] { "Lima-Huánuco", "Lima-Huancayo" }));
			cboRuta.setName("");
			cboRuta.setBounds(83, 35, 168, 17);
			contentPane.add(cboRuta);
		}
		{
			cboCalidad = new JComboBox();
			cboCalidad.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C" }));
			cboCalidad.setBounds(83, 70, 168, 17);
			contentPane.add(cboCalidad);
		}
		{
			lblCalcular = new JButton("CALCULAR");
			lblCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblCalcularActionPerformed(e);
				}
			});
			lblCalcular.setBounds(308, 35, 85, 21);
			contentPane.add(lblCalcular);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(10, 140, 416, 113);
			contentPane.add(txtS);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(27, 98, 45, 13);
			contentPane.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(83, 95, 168, 16);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
	}

	protected void lblCalcularActionPerformed(ActionEvent e) {
		entradadedatos();
		calculoImporteCompra();
		calculoImporteDescuento();
		calculoImportePago();
		mostrarResultado();
	}

	void entradadedatos() {
		ruta = cboRuta.getSelectedIndex();
		calidad = cboCalidad.getSelectedIndex();
		cantidad = Double.parseDouble(txtCantidad.getText());
	}

	// Dada la ruta elegida, la calidad del servicio y la cantidad de boletos
	// adquiridos, diseñe un programa
	// que determine el importe de la compra, el importe del descuento y el importe
	// a pagar
	/*
	 * if (ruta==0) { if (calidad==0) { precio=45.0;} else if (calidad==1) { precio
	 * = 35.0;} else { precio = 30.0;} } else if (ruta == 1) { if (calidad == 0) {
	 * precio = 38.00; } else if(calidad == 1) { precio = 33; } else { precio = 28;
	 * } }
	 */

	void calculoImporteCompra() {
		switch (ruta) {
		case 0:
			if (calidad == 0)
				ICompra = 45.0 * cantidad;

			else if (calidad == 1)
				ICompra = 35.00 * cantidad;

			else
				ICompra = 30.00 * cantidad;
			break;

		case 1:
			if (calidad == 0)
				ICompra = 38.0 * cantidad;

			else if (calidad == 1)
				ICompra = 33.00 * cantidad;

			else
				ICompra = 28.00 * cantidad;
			break;
		}

	}

	void calculoImporteDescuento() {
		/*
		 * if (calidad == 0) { if (cantidad >4) { IDescuento=0.05 * ICompra; } }
		 */

		if (calidad == 0 && cantidad > 4)
			IDescuento = 0.05 * ICompra;
		else
			IDescuento = 0;
	}

	void calculoImportePago() {
		IPagar = ICompra - IDescuento;
	}

	void mostrarResultado() {
		txtS.setText("");
		imprimir("Precio: " + precio);
		imprimir("IC: " + ICompra);
		imprimir("ID: " + IDescuento);
		imprimir("IP: " + IPagar);
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

}
