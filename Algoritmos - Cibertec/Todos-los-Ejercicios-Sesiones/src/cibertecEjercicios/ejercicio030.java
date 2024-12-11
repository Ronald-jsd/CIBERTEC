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

class ejercicio030 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblNota;

	private JTextField txtNota;

	private JButton btnProcesar;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	double sumaTotal = 0;
	int totalNotas = 0;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ejercicio030 frame = new ejercicio030();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ejercicio030() {
		// ContentPane
		setTitle("Tienda promoción");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// JLabel
		lblNota = new JLabel("Nota");
		lblNota.setBounds(10, 13, 120, 14);
		getContentPane().add(lblNota);

		// JTextField
		txtNota = new JTextField();
		txtNota.setBounds(120, 10, 90, 20);
		getContentPane().add(txtNota);
		txtNota.setColumns(10);

		// Button
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

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		// DECLARO VARIABLES

		double nota = 0, promedio = 0;

		// ENTRADA DE DATOS

		nota = Double.parseDouble(txtNota.getText());

		// PROCESO DE DATOS

		sumaTotal += nota; // ACUMULA LAS NOTA EN SUMATOTAL 15 + 14 = 29
		totalNotas++; // VA IR CONTANDO LA CANTIDAD DE VECES QUE SE ESTA LLENANDO 1 + 1 = 2

		promedio = sumaTotal / totalNotas;
		// LO ACUMULADO SOBRE LA CANTIDAD DE VECES

		// SALIDA DE DATOS
		txtS.setText("El promedio de sus notas es: " + promedio + "\n");

	}

	// METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtNota.setText("");
		sumaTotal = 0;
		totalNotas = 0;
		txtS.setText("");

		txtNota.requestFocus();
	}
}
