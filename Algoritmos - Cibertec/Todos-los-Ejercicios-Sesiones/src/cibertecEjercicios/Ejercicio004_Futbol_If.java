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

class Ejercicio004_Futbol_If extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblGolesA;
	private JLabel lblGolesB;

	private JTextField txtGolesA;
	private JTextField txtGolesB;

	private JButton btnProcesar;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			// Dentro del metodo main hay un metodo run
			// se usa para definir la loica de la ejecucionde un hio en JAVA
			public void run() {
				try {
					Ejercicio004_Futbol_If frame = new Ejercicio004_Futbol_If();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CREA LA GUI - CONSTRUCTOR
	public Ejercicio004_Futbol_If() {
		// ContentPane
		setTitle("Futbol");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// texto a mostrar
		lblGolesA = new JLabel("Equipo A");
		lblGolesA.setBounds(10, 13, 80, 14);
		getContentPane().add(lblGolesA);

		lblGolesB = new JLabel("Equipo B");
		lblGolesB.setBounds(10, 38, 80, 14);
		getContentPane().add(lblGolesB);

		// nombre de los campos vacios
		txtGolesA = new JTextField();
		txtGolesA.setBounds(90, 10, 90, 20);
		getContentPane().add(txtGolesA);
		txtGolesA.setColumns(4);

		txtGolesB = new JTextField();
		txtGolesB.setBounds(90, 35, 90, 20);
		getContentPane().add(txtGolesB);
		txtGolesB.setColumns(4);

		// botones
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
		//
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

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		// DECLARO VARIABLES
		int golA, golB;
		String resul = " ";

		// ENTRADA DE DATOS
		golA = Integer.parseInt(txtGolesA.getText());
		golB = Integer.parseInt(txtGolesB.getText());

		// PROCESO DE DATOS
		if (golA > golB)
			resul = "Gano A";

		if (golA < golB)
			resul = "Gano B";

		if (golA == golB)
			resul = "Empate";

		// SALIDA DE DATOS
		txtS.setText("El resultado es: " + resul + "\n");
	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtGolesA.setText("");
		txtGolesB.setText("");
		txtS.setText("");

		txtGolesA.requestFocus();
	}
}
