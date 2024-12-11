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

class Ejercicio005_Obsequio_If extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblNumBolos;

	private JTextField txtNumBolos;

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
					Ejercicio005_Obsequio_If frame = new Ejercicio005_Obsequio_If();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CREA LA GUI - CONSTRUCTOR
	public Ejercicio005_Obsequio_If() {
		setTitle("Obsequios de Tienda");
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// textofijo
		lblNumBolos = new JLabel("N° de Bolo");
		lblNumBolos.setBounds(10, 13, 80, 14);
		getContentPane().add(lblNumBolos);

		// nombre de los campos vacios
		txtNumBolos = new JTextField();
		txtNumBolos.setBounds(90, 10, 90, 20);
		getContentPane().add(txtNumBolos);
		txtNumBolos.setColumns(10);

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

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//// NUMERO DEL BOLO
		int numeroBolo = Integer.parseInt(txtNumBolos.getText());

		if (numeroBolo < 1) {
			imprimir("Ingrese un numero valido");
		} else
			determinarElPrecio(numeroBolo);

	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtNumBolos.setText("");
		txtS.setText("");
		txtNumBolos.requestFocus();
	}

	public void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	public void determinarElPrecio(int numeroBolo) {
		if (numeroBolo <= 20) {
			imprimir("Ganaste un lapicero");
		} else if (numeroBolo >= 21 && numeroBolo <= 40) {
			imprimir("Ganaste un cuaderno de 100 hojas");
		} else if (numeroBolo >= 41 && numeroBolo <= 60) {
			imprimir("Ganaste una caja de plumones");
		} else if (numeroBolo >= 61 && numeroBolo <= 80) {
			imprimir("Ganaste una cuaderno espiral");
		} else if (numeroBolo >= 81 && numeroBolo <= 99) {
			imprimir("Ganaste una agenda+");
		} else if (numeroBolo == 100)
			imprimir("Ganaste una mochila");
		else
			imprimir("Ninguno");
	}

}
