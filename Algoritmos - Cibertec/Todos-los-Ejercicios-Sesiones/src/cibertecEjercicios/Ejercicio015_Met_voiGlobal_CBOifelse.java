package cibertecEjercicios;

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

public class Ejercicio015_Met_voiGlobal_CBOifelse extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblCategoria;
	private JLabel lblPromedio;

	private JComboBox<String> cboCategoria;
	private JTextField txtPromedio;

	private JButton btnProcesar;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	int Categ;
	double Promed, pensionA = 0, dscto, NewPension;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio015_Met_voiGlobal_CBOifelse frame = new Ejercicio015_Met_voiGlobal_CBOifelse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio015_Met_voiGlobal_CBOifelse() {
		setTitle("Transporte");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// texto a mostrar
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 13, 80, 14);
		getContentPane().add(lblCategoria);

		lblPromedio = new JLabel("Promedio");
		lblPromedio.setBounds(10, 38, 80, 14);
		getContentPane().add(lblPromedio);

		// nombre de los campos vacios

		// combobox
		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] { "A", "B", "C", "D" }));
		cboCategoria.setBounds(90, 10, 90, 20);
		getContentPane().add(cboCategoria);

		txtPromedio = new JTextField();
		txtPromedio.setBounds(90, 35, 90, 20);
		getContentPane().add(txtPromedio);
		txtPromedio.setColumns(4);

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

//PROCESA LA PULSACION DE PROOCESAR

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		ingresarDatos();
		calcularPensionActual();
		calcularDescuento();
		calcularNuevaPension();
		mostrarResultados();
	}

//METODO BORRAR		
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtPromedio.setText("");
		cboCategoria.setSelectedIndex(0);
		txtS.setText("");

		txtPromedio.requestFocus();
	}

	// PROCESO DE DATO
	// ENTRADA DE DATOS
	void ingresarDatos() {
		Categ = cboCategoria.getSelectedIndex();
		Promed = Double.parseDouble(txtPromedio.getText());
	}

	// PROCESO DE DATOS
	void calcularPensionActual() {
		// Dar valor por turno del combobox
		switch (Categ) {
		case 0:
			pensionA = 550;
			break;
		case 1:
			pensionA = 500;
			break;
		case 2:
			pensionA = 460;
			break;
		case 3:
			pensionA = 400;
			break;
		}
	}

	// CALCULO DESCUENTO
	void calcularDescuento() {

		if (Promed <= 13.99)
			dscto = 0;
		else if (Promed <= 15.99)
			dscto = 0.10 * pensionA;
		else if (Promed <= 17.99)
			dscto = 0.12 * pensionA;
		else
			dscto = 0.15 * pensionA;
	}

	// Calculo la nueva pension
	void calcularNuevaPension() {
		NewPension = pensionA - dscto;
	}

	// Muestra resultados
	void mostrarResultados() {
		txtS.setText("");
		imprimir("La pension actual es: " + pensionA);
		imprimir("El descuento es: " + dscto);
		imprimir("La Nueva pension es: " + NewPension);
	}

	// Imprime una linea de texto incluyendo un salto de liera
	// cad es un parametro de tipo String que recibiremos
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
