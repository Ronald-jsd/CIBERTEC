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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//3. Para hacer la GUI tenemos que extender a la clase JFrame
class Ejercicio007_transporte_if_CBO extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L; // Declaracion de variables - Se guarda serializado

	// Declaración de variables, que se introduciran

	private JLabel lblturno;
	private JLabel lblcntdBoleto;

	private JComboBox<String> cboTipo;

	//
	private JTextField txtcntBoleto;

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
			public void run() {
				try {
					Ejercicio007_transporte_if_CBO frame = new Ejercicio007_transporte_if_CBO();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio007_transporte_if_CBO() {
		// ContentPane
		setTitle("Transporte");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// texto a mostrar
		lblturno = new JLabel("Turno");
		lblturno.setBounds(10, 13, 80, 14);
		getContentPane().add(lblturno);

		lblcntdBoleto = new JLabel("Cantidad de boletos");
		lblcntdBoleto.setBounds(10, 38, 80, 14);
		getContentPane().add(lblcntdBoleto);

		// combobox
		cboTipo = new JComboBox<String>(); // Nueva instancia de la clase JCOMBOBOX
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] { // setModel, de Model se relaciona a las base
																			// de datos y estoy definiendo por deafault
																			// un arreglo de String
				"Mañana", "Noche" }));
		cboTipo.setBounds(90, 10, 90, 20);
		getContentPane().add(cboTipo);

		txtcntBoleto = new JTextField();
		txtcntBoleto.setBounds(90, 35, 90, 20);
		getContentPane().add(txtcntBoleto);
		txtcntBoleto.setColumns(4);

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

//DECLARO VARIABLLES 
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		// DECLARO VARIABLES
		int tipoPasaje = 0, obs = 0, ctdBoletos;
		double precPasaje = 0, dscto = 0, Imcompra, ImPagar;

		// ENTRADA DE DATOS
		ctdBoletos = Integer.parseInt(txtcntBoleto.getText());
		tipoPasaje = cboTipo.getSelectedIndex();

		// PROCESO DE DATOS
		// Dar valor por turno del combobox
		if (tipoPasaje == 0)
			precPasaje = 37.5;

		if (tipoPasaje == 1)
			precPasaje = 45.0;

		// Calcular el Importe de Compra
		Imcompra = precPasaje * ctdBoletos;

		// Condiciones y calculo sobre el Descuento
		if (ctdBoletos > 14)
			dscto = 0.08 * Imcompra;
		if (ctdBoletos < 15)
			dscto = 0.05 * Imcompra;

		// Importe a pagar
		ImPagar = Imcompra - dscto;

		// Condicion y Calculo de obsequio de caramelos
		if (ImPagar > 200)
			obs = 2 * ctdBoletos;
		if (ImPagar <= 200)
			obs = 0;

		// SALIDA DE RESULTADOS
		txtS.setText("El Importe de compra es: " + Imcompra + "\n");
		txtS.append("El descuento es: " + dscto + "\n");
		txtS.append("El Importe a pagar es: " + ImPagar + "\n");
		txtS.append("La cantidad de caramelos de obsequio es: " + obs + "\n");

	}

	// METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtcntBoleto.setText("");
		cboTipo.setSelectedIndex(0);
		txtS.setText("");

		txtcntBoleto.requestFocus();
		// requestFocus - volver a comenzar el txtRadio en la gui
	}
}
