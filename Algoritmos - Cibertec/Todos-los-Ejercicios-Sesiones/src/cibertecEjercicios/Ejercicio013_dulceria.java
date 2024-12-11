package cibertecEjercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio013_dulceria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JLabel lblTipo;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio013_dulceria frame = new Ejercicio013_dulceria();
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
	public Ejercicio013_dulceria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(53, 61, 40, 13);
			contentPane.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(117, 58, 76, 19);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(41, 97, 277, 139);
			contentPane.add(txtS);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblProcesarActionPerformed(e);
				}
			});
			btnProcesar.setBounds(225, 57, 81, 21);
			contentPane.add(btnProcesar);
		}
		{
			lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(53, 21, 40, 13);
			contentPane.add(lblTipo);
		}
		{
			cboTipo = new JComboBox();
			cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Primor", "Dulzura", "Tentacion", "Explosion" }));
			cboTipo.setBounds(117, 27, 76, 21);
			contentPane.add(cboTipo);
		}
	}

	protected void lblProcesarActionPerformed(ActionEvent e) {
		txtS.setText("");
		int cantidad = Integer.parseInt(txtCantidad.getText());
		int tipo = cboTipo.getSelectedIndex();
		double importeCompra = 0;
		double importeDescuento = 0;
		double importePagar = 0;
		double preciounitarioProducto = 0;

		// determinar precio
		switch (tipo) {
		case 0:
			preciounitarioProducto = 8.5;
			break;
		case 1:
			preciounitarioProducto = 10;
			break;
		case 2:
			preciounitarioProducto = 7;
			break;
		case 3:
			preciounitarioProducto = 12.5;
			break;
		default:
			imprimir("No valido");
		}

		// importe compra
		importeCompra = cantidad * preciounitarioProducto;

		// importe descuento
		if (cantidad < 1) {
			imprimir("No valido");
		} else if (cantidad < 5) {
			importeDescuento = importeCompra * 0.04;
		} else if (cantidad >= 10 && cantidad < 15) {
			importeDescuento = importeCompra * 0.065;
		} else if (cantidad >= 10 && cantidad < 15) {
			importeDescuento = importeCompra * 0.09;
		} else
			importeDescuento = importeCompra * 0.115;

		// importe total pagar
		importePagar = importeCompra - importeDescuento;

		imprimir("Precio del producto unitario: " + preciounitarioProducto);
		imprimir("Importe compra: " + importeCompra);
		imprimir("Importe descuento:" + importeDescuento);
		imprimir("Importe pagar: " + importePagar);

	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");

	}
}
