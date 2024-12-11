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

class ejercicio024 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblMonto;

	private JTextField txtMonto;

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
					ejercicio024 frame = new ejercicio024();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ejercicio024() {
		// ContentPane
		setTitle("PRESTAMO");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// texto a mostrar
		lblMonto = new JLabel("Monto de prestamo");
		lblMonto.setBounds(10, 13, 120, 14);
		getContentPane().add(lblMonto);

		txtMonto.setBounds(120, 10, 90, 20);
		getContentPane().add(txtMonto);
		txtMonto.setColumns(4);

		// botones
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 9, 89, 23);
		getContentPane().add(btnProcesar);

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
	}

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
		double MonPresta, interes, MontIntTotal, MPrestMens;
		int NCuotas;
		// ENTRADA DE DATOS
		// ctddocenas = Integer.parseInt(txtctdDocna.getText());
		MonPresta = Double.parseDouble(txtMonto.getText());

		// PROCESO DE DATOS

		// OBTENER NUMERO DE CUOTAS
		if (MonPresta <= 5000)
			NCuotas = 2;
		else if (MonPresta <= 10000)
			NCuotas = 4;
		else if (MonPresta <= 15000)
			NCuotas = 6;
		else
			NCuotas = 10;

		// OBTIENE LA TAS DE INTERES
		if (MonPresta > 10000)
			interes = 0.03;
		else
			interes = 0.05;

		// MONTO DE INTERES TOTAL
		MontIntTotal = interes * MonPresta * NCuotas;

		// MONTO DE LA CUOTA MENSUAL
		MPrestMens = (MonPresta + MontIntTotal) / NCuotas;

		// SALIDA DE DATOS
		txtS.setText("El monto mensual es: " + MPrestMens + "\n");
		txtS.append("El interes total es: " + MontIntTotal + "\n");
		txtS.append("El numero de cuotas es: " + NCuotas + "\n");

	}

	// Procesa accion de borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtMonto.setText("");
		txtS.setText("");
		txtMonto.requestFocus();
	}
}
