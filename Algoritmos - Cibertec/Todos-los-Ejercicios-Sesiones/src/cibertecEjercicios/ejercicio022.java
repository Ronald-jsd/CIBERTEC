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

class ejercicio022 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblTipo;
	private JLabel lblctdPasajero;

	private JComboBox<String> cboTipo;
	private JTextField txtctdPasajero;

	private JButton btnProcesar;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	int totalauto, totalcamion, totalcamioneta, totalomnibus, totalotros;
	int pasajerosautomoviles, pasajeroscamion, pasajeroscamioneta, pasajerosomnibus, pasajerosotross;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio022 frame = new ejercicio022();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ejercicio022() {
		// ContentPane
		setTitle("Transporte");
		setBounds(150, 300, 450, 459);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// texto a mostrar
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 13, 80, 14);
		getContentPane().add(lblTipo);

		lblctdPasajero = new JLabel("Cantidad de pasajero");
		lblctdPasajero.setBounds(10, 38, 80, 14);
		getContentPane().add(lblctdPasajero);

		// combobox
		cboTipo = new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] { // setModel, de Model se relaciona a las base
																			// de datos y estoy definiendo por deafault
																			// un arreglo de String
				"Automovil", "Camion", "Camioneta", "Omnibus", "Otros" }));
		cboTipo.setBounds(90, 10, 90, 20);
		getContentPane().add(cboTipo);

		txtctdPasajero = new JTextField();
		txtctdPasajero.setBounds(90, 35, 90, 20);
		getContentPane().add(txtctdPasajero);
		txtctdPasajero.setColumns(4);

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
		scpScroll.setBounds(10, 69, 414, 310);
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
		int tipoveh = 0, ctdPasajero = 0;

		tipoveh = getTipo();
		ctdPasajero = getPasajeros();

		efectuarIncrementos(tipoveh, ctdPasajero);

		mostrarResultados();

	}

	// METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtctdPasajero.setText("");
		cboTipo.setSelectedIndex(0);
		txtS.setText("");

		txtctdPasajero.requestFocus();
	}

	// ENTRADA DE DATOS

	int getTipo() {
		return cboTipo.getSelectedIndex();
	}

	int getPasajeros() {
		return Integer.parseInt(txtctdPasajero.getText());
	}

	// PROCESO DE DATOS
	void efectuarIncrementos(int tipveh, int ctdpasajer) {

		switch (tipveh) {
		case 0:
			totalauto++;
			pasajerosautomoviles += ctdpasajer;
			break;

		case 1:
			totalcamion++;
			pasajeroscamion += ctdpasajer;
			break;

		case 2:
			totalcamioneta++;
			pasajeroscamioneta += ctdpasajer;
			break;
		case 3:
			totalomnibus++;
			pasajerosomnibus += ctdpasajer;
			break;

		default:
			totalotros++;
			pasajerosotross += ctdpasajer;
			break;

		}

	}

	// MOSTRAR RESULTADO
	void mostrarResultados() {
		txtS.setText("");
		imprimir("CANTIDAD TOTAL DE VEHICULOS POR TIPO: ");
		imprimir("Automóviles: " + totalauto);
		imprimir("Camiones: " + totalcamion);
		imprimir("Camionetas: " + totalcamioneta);
		imprimir("Omnibuses: " + totalomnibus);
		imprimir("Otros: " + totalotros);

		imprimir(" ");

		imprimir("CANTIDAD TOTAL DE PASAJEROS: ");
		imprimir("Automóviles: " + pasajerosautomoviles);
		imprimir("Camiones: " + pasajeroscamion);
		imprimir("Camionetas: " + pasajeroscamioneta);

		imprimir("Omnibuses: " + pasajerosomnibus);
		imprimir("Otros: " + pasajerosotross);
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

}
