package cibertecEjercicios;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Window.Type;

public class Ejemplo004_switch_STRING extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTipo;
	private JComboBox<String> cboTipo;
	private JButton btnProcesar;
	private JTextArea textArea;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo004_switch_STRING frame = new Ejemplo004_switch_STRING();
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
	public Ejemplo004_switch_STRING() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblTipo = new JLabel("Tipo de Chocolate");
			lblTipo.setFont(new Font("Source Sans Pro Light", Font.BOLD, 13));
			lblTipo.setBounds(10, 42, 114, 13);
			contentPane.add(lblTipo);
		}
		{
			cboTipo = new JComboBox<String>();
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Primor", "Dulzura", "Tentación", "Explosión"}));
			cboTipo.setName("");
			cboTipo.setToolTipText("");
			cboTipo.setBounds(136, 39, 129, 21);
			contentPane.add(cboTipo);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnProcesarActionPerformed(e);
				}
			});
			btnProcesar.setBounds(301, 38, 85, 21);
			contentPane.add(btnProcesar);
		}
		{
			textArea = new JTextArea();
			textArea.setRequestFocusEnabled(false);
			textArea.setBounds(34, 121, 372, 110);
			contentPane.add(textArea);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(136, 70, 129, 27);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setFont(new Font("Source Sans Pro Light", Font.BOLD, 13));
			lblCantidad.setBounds(10, 77, 114, 13);
			contentPane.add(lblCantidad);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBorrarActionPerformed(e);
				}
			});
			btnBorrar.setBounds(301, 69, 85, 21);
			contentPane.add(btnBorrar);
		}
		
		
		
	
	}
	
	
	
	
	
	protected void btnProcesarActionPerformed(ActionEvent e) {
		String tipoChocolate;
		int cantidadChocolate=0, obsequio=0;
		double importeCompra=0.0, importeDescuento=0.0, importePagar =0.0;
		
		tipoChocolate = cboTipo.getSelectedItem().toString();
		cantidadChocolate = Integer.parseInt(txtCantidad.getText());
		
		//IMPORTE DE COMPRA
		
		if(tipoChocolate=="Primor")
			importeCompra=8.5;
		else if (tipoChocolate == "Dulzura")
			importeCompra=10;
		else if (tipoChocolate == "Tentación")
			importeCompra=7;
		else if (tipoChocolate == "Explosión")
			importeCompra=12.5;
		
		importeCompra = cantidadChocolate* importeCompra;
		
		
		/*switch(tipoChocolate) {
		case "Primor":
			precioChocolate= 8.5;
		break;
		case "Dulzura":
			precioChocolate= 10;
		break;
		case "Tentación":
			precioChocolate= 7;
		break;
		case "Exploción":
			precioChocolate= 12.5;
		break;
		}*/
		
		/*switch(tipoChocolate) {
		case "Primor":
			importeCompra= 8.5*cantidadChocolate;
		break;
		case "Dulzura":
			importeCompra= 10*cantidadChocolate;
		break;
		case "Tentación":
			importeCompra= 7*cantidadChocolate;
		break;
		case "Exploción":
			importeCompra= 12.5*cantidadChocolate;
		break;
		}*/
		
		
		
		
		//IMPORTE DE DESCUENTO
		if (cantidadChocolate >0 && cantidadChocolate<5)
			importeDescuento = 0.04*importeCompra;
		else if (cantidadChocolate >=5 && cantidadChocolate<10)
			importeDescuento = 0.065*importeCompra;
		else if (cantidadChocolate >=10 && cantidadChocolate<15)
			importeDescuento = 0.09*importeCompra;
		else 
			importeDescuento = 0.115*importeCompra;
		
		//IMPORTE A PAGAR
		importePagar=importeCompra-importeDescuento;
		
		//OBSEQUIO DE CARAMELOS
		if (importePagar >=250)
				obsequio= 3*cantidadChocolate;
		else 
			obsequio = 2*cantidadChocolate;
		
		
		textArea.setText("Ell importe de compra es: S/" + importeCompra + "\n" );
		textArea.append("El importe del descuento es: S/" + importeDescuento + "\n");
		textArea.append("El importe a pagar es: S/" + importePagar + "\n");
		textArea.append("La cantidad de caramelos de obsequio es: " + obsequio + " unidades") ;
		
		
	}
	protected void btnBorrarActionPerformed(ActionEvent e) {
		txtCantidad.setText("");
		txtCantidad.requestFocus();
		}
}
