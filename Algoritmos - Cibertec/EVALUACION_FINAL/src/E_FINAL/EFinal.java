package E_FINAL;

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

public class EFinal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblCategoria;
	private JLabel lblCantidad;
	private JComboBox<String> cboCategoria;
	private JTextField txtcantidad;
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
					EFinal frame = new EFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EFinal() {
		setTitle("TIENDA DE CELULARES");
		setBounds(100, 100, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblCategoria = new JLabel("Marca");
		lblCategoria.setBounds(10, 13, 80, 14);
		getContentPane().add(lblCategoria);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 38, 80, 14);
		getContentPane().add(lblCantidad);

		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Motorola Buds 3 Pro Glacier Gray", "Nokia 8 Neptune Blue", "Alcatel 10 Pebble White",
						"Xiaomi 11 Lite 5G Black 128GB", "Samsung 10T 5G Lunar Silver" }));
		cboCategoria.setBounds(90, 10, 180, 20);
		getContentPane().add(cboCategoria);
		txtcantidad = new JTextField();
		txtcantidad.setBounds(90, 35, 180, 20);
		getContentPane().add(txtcantidad);
		txtcantidad.setColumns(10);
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
		int Marca;
		double ImportePagar;
		int Micas, Cases, cantidad;

		Marca = leerMarca();
		cantidad = leercantidad();

		ImportePagar = calcularImportePagar(Marca, cantidad);

		Micas = calcularMicas(cantidad);
		Cases = calcularCases(Marca, cantidad);
		mostrarResultados(ImportePagar, Micas, Cases);

	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtcantidad.setText("");
		txtS.setText("");
		txtcantidad.requestFocus();
	}

	int leerMarca() {
		return cboCategoria.getSelectedIndex();
	}

	int leercantidad() {
		return Integer.parseInt(txtcantidad.getText());
	}

	double calcularImportePagar(int marc, int canti) {
		switch (marc) {
		case 0:
			return 329.90 * canti;
		case 1:
			return 699.9 * canti;
		case 2:
			return 899.9 * canti;
		case 3:
			return 1699.9 * canti;
		default:
			return 1999.9 * canti;
		}
	}

	int calcularMicas(int canti) {

		if (canti <= 5)
			return 2;
		else if (canti > 5 && canti <= 10)
			return 3;
		else if (canti > 10 && canti <= 15)
			return 1 * canti;
		else
			return canti * 2;
	}

	int calcularCases(int marc, int canti) {

		switch (marc) {
		case 0:
			return 3;
		case 1:
			return 4;
		case 2:
			return 2 * canti;
		case 3:
			return 3 * canti;
		default:
			return 5 * canti;
		}

	}

	void mostrarResultados(double IP, int Mic, int cas) {
		txtS.setText("");
		imprimir("Importe a pagar es : S/. " + IP);
		imprimir("Recibes: " + Mic + " unidades de obsequio de Micas");
		imprimir("Recibes:  " + cas + " unidades de obsequio de Case Protectores");
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
