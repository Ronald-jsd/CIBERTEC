package cibertecEjercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio005_UIManager extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// Declaración de variables
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio005_UIManager frame = new Ejercicio005_UIManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Ejercicio005_UIManager() {
		setTitle("TIENDA");
		setBounds(100, 100, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 13, 80, 14);
		getContentPane().add(lblCantidad);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 38, 80, 14);
		getContentPane().add(lblPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(90, 10, 90, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(90, 35, 90, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 9, 89, 23);
		getContentPane().add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 69, 414, 120);
		getContentPane().add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaración de variables
		double precio, IC, ID = 0, IP;
		int cantidad, Lapiceros;

		// Entrada de datos
		precio = Double.parseDouble(txtPrecio.getText());
		cantidad = Integer.parseInt(txtCantidad.getText());
		// Proceso

		// Calculo Importe de compra
		IC = precio * cantidad;

		// Calculo importe de descuento
		if (cantidad >= 10)
			ID = 0.15 * IC;
		else if (cantidad < 10)
			ID = 0.11 * IC;

		// Importe a pagar
		IP = IC - ID;

		// OBSEQUIO DE LAPICEROS
		if (IP >= 200)
			Lapiceros = 2 * cantidad;
		else
			Lapiceros = 0;

		// Salida de resultados

		txtS.setText("Importe de compra: " + IC + "\n");
		txtS.append("Importe del descuento: " + ID + "\n");
		txtS.append("Importe a pagar: " + IP + "\n");
		txtS.append("Obsequio: " + Lapiceros + "\n");

	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
}
