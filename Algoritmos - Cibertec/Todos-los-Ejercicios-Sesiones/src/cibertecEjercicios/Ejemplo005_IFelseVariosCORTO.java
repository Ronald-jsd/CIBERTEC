package cibertecEjercicios;
	import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo005_IFelseVariosCORTO extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JButton btnCalcular;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo005_IFelseVariosCORTO frame = new Ejemplo005_IFelseVariosCORTO();
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
	public Ejemplo005_IFelseVariosCORTO() {
		setTitle("TIENDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblPrecio = new JLabel("Precio");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPrecio.setBounds(20, 44, 75, 13);
			contentPane.add(lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(122, 33, 96, 28);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(122, 76, 96, 28);
			contentPane.add(txtCantidad);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCantidad.setBounds(20, 83, 75, 13);
			contentPane.add(lblCantidad);
		}
		{
			btnCalcular = new JButton("CALCULAR");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCalcularActionPerformed(e);
				}
			});
			btnCalcular.setBounds(272, 41, 114, 21);
			contentPane.add(btnCalcular);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(20, 143, 366, 99);
			contentPane.add(textArea);
		}
	}

	protected void btnCalcularActionPerformed(ActionEvent e) {
		//IMPORTE DE COMPRA , IMPORTE DE DESCUENTO, IMPORTE A PAGAR, OBSEQUIO
		int cantidad;
		double precio, ICompra, IDescuento, IPagar;
		String obsequio;
		
		cantidad = Integer.parseInt(txtCantidad.getText());
		precio = Double.parseDouble(txtPrecio.getText());
		
		
		ICompra=precio*cantidad;
		
		//IMPORTE DE descuento
		//Si pongo entre llaves puedo hacer mas reglas 
		if(cantidad > 10) {
			IDescuento = 0.15*ICompra;
			textArea.setText("El porcentaje de descuento es 15%" + "\n");
		}
		else
			{
			IDescuento = 0.05*ICompra;
			textArea.append("El porcentaje de descuento es 5%" + "\n");
			}
		
		
		//IMPORTE A PAGAR
		IPagar = ICompra-IDescuento;
		 
		
		//OBSEQUIO
		if (IPagar>200)
			obsequio= "Una agenda";
		else 
			obsequio = "Un cuaderno";
		
		
		textArea.append("El importe de compra es: S/" + ICompra + "\n");
		textArea.append("El importe de descuento es: S/" + IDescuento + "\n");
		textArea.append("El importe a pagar es: S/" + IPagar + "\n");
		textArea.append("El obsequio es: " + obsequio + "\n");

		
		
		
	}
}
