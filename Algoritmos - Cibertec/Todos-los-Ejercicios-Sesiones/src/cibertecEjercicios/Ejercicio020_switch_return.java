package cibertecEjercicios;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ejercicio020_switch_return extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTurno;
	private JLabel lblCantidad;
	private JComboBox cboTurno;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio020_switch_return frame = new Ejercicio020_switch_return();
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
	public Ejercicio020_switch_return() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblTurno = new JLabel("Turno");
			lblTurno.setBounds(19, 27, 40, 13);
			contentPane.add(lblTurno);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(19, 60, 56, 13);
			contentPane.add(lblCantidad);
		}
		{
			cboTurno = new JComboBox();
			cboTurno.setModel(new DefaultComboBoxModel(new String[] { "Mañana", "Noche" }));
			cboTurno.setBounds(83, 23, 142, 17);
			contentPane.add(cboTurno);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(83, 57, 142, 17);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnProcesarActionPerformed(e);
				}
			});
			btnProcesar.setBounds(307, 23, 106, 21);
			contentPane.add(btnProcesar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBorrarActionPerformed(e);
				}
			});
			btnBorrar.setBounds(307, 60, 81, 21);
			contentPane.add(btnBorrar);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(19, 111, 393, 140);
			contentPane.add(txtS);
		}
	}

	protected void btnProcesarActionPerformed(ActionEvent e) {
		int turno, cantidad, obsequio = 0;
		double IC, ID, IP, precio = 0;

		// ENTRADA DE DATOOS

		turno = cboTurno.getSelectedIndex();
		cantidad = Integer.parseInt(txtCantidad.getText());

		// Casillas de verificación (JCheckBox):

		// PROCESO

		// DADO VALORES A LOS TURNOS
		switch (turno) {
		case 0:
			precio = 37.5;
			break;
		case 1:
			precio = 45.0;
			break;
		}

		// IC
		IC = precio * cantidad;

		// ID
		if (cantidad >= 15)
			ID = 0.08 * IC;
		else
			ID = 0.05 * IC;

		// IP
		IP = IC - ID;

		// OBSEQUIO
		if (IP > 200)
			obsequio = 2 * cantidad;
		else if (IP <= 200)
			obsequio = 0;

		// MUESTREN LOS RESULTADOS EN TEXT AREA
		txtS.setText("");
		imprimir("El importe de la compra es: " + IC);
		imprimir("El importe del descuento es: " + ID);
		imprimir("El importe a pagar es: " + IP);
		imprimir("La cantidad de osbsequio es: " + obsequio);
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	protected void btnBorrarActionPerformed(ActionEvent e) {

		txtCantidad.setText("");
		txtS.setText("");
		cboTurno.requestFocus();
		cboTurno.setSelectedIndex(0);
	}
}
