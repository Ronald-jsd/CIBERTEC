//1.Estamos declarando el paquete
package cibertecEjercicios;

//2.Importamos Libreria
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Ejercicio012prestamos_VarifElse extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblMoPrestamo;

	private JTextField txtMoPrestamo;

	private JButton btnProcesar;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	// DECLARO METODO MAIN
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio012prestamos_VarifElse frame = new Ejercicio012prestamos_VarifElse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CREA LA GUI - CONSTRUCTOR
	// Vamos a darle valores
	public Ejercicio012prestamos_VarifElse() {
		setTitle("Tienda promoción");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblMoPrestamo = new JLabel("Monto de prestamo");
		lblMoPrestamo.setBounds(10, 13, 120, 14);
		getContentPane().add(lblMoPrestamo);

		txtMoPrestamo = new JTextField();
		txtMoPrestamo.setBounds(120, 10, 90, 20);
		getContentPane().add(txtMoPrestamo);
		txtMoPrestamo.setColumns(10);

		// botones
		btnProcesar = new JButton("Procesar"); // creo
		btnProcesar.addActionListener(this); // accion
		btnProcesar.setBounds(335, 9, 89, 23); // ubico
		getContentPane().add(btnProcesar); // agrego

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);

		//
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 69, 414, 120);
		getContentPane().add(scpScroll);
		//
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
		txtS.setEditable(false);
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

//DECLARO VARIABLLES QUE ENTRARAN A MI ALORITMO
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		// DECLARO VARIABLES
		double MPrestamo, interes, MCMensual, MITotal;
		int NCuotas;

		// ENTRADA DE DATOS
		MPrestamo = Double.parseDouble(txtMoPrestamo.getText());

		// PROCESO DE DATOS

		// Calculo de Numero de Cuotas

		if (MPrestamo <= 5000)
			NCuotas = 2;
		else if (MPrestamo <= 10000)
			NCuotas = 4;
		else if (MPrestamo <= 15000)
			NCuotas = 6;
		else
			NCuotas = 10;

		/*
		 * if(MPrestamo >0 && MPrestamo <= 5000) NCuotas = 2; else if(MPrestamo > 5000
		 * && MPrestamo <= 10000) NCuotas = 4; else if(MPrestamo > 10000 && MPrestamo
		 * <=15000) NCuotas = 6; else if (MPrestamo > 15000) NCuotas = 10; else NCuotas
		 * = 0;
		 */

		// INTERES
		if (MPrestamo > 10000)
			interes = 0.03;
		else
			interes = 0.05;

		// MONTO DE CUOTA MENSUAL
		// MCMensual = MPrestamo/NCuotas+(MPrestamo*interes);

		// INTERES TOTAL
		// MITotal = interes*MPrestamo;
		MITotal = interes * MPrestamo * NCuotas;
		MCMensual = (MPrestamo + MITotal) / NCuotas;

		// SALIDA DE DATOS
		/*
		 * txtS.setText("El Numero de cuotas es: " + NCuotas + "\n"+ "El descuento es: "
		 * + MCMensual + "\n"+ "El Monto de Interes total es: " + MITotal + "\n");
		 */

		txtS.setText("El Numero de cuotas es: " + NCuotas + "\n");
		txtS.append("El Monto de cuota mensual es: " + MCMensual + "\n");
		txtS.append("El Monto de Interes total es: " + MITotal + "\n");
	}

	// METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtMoPrestamo.setText("");
		txtS.setText("");

		txtMoPrestamo.requestFocus();
	}
}
