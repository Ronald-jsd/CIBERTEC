package CIB;

//Importamos Libreria
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

class EVALUACIONT1 extends JFrame implements ActionListener {

	// Declaracion de variables -
	private static final long serialVersionUID = 1L;

	private JLabel lblpresupuesto;

	private JTextField txtpresupuesto;

	private JButton btnCalcular;
	private JButton btnBorrar;

	private JScrollPane scpScroll;
	private JTextArea txtS;

	// DECLARO METODO MAIN -
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EVALUACIONT1 frame = new EVALUACIONT1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CREA LA GUI - CONSTRUCTOR
	public EVALUACIONT1() {
		setTitle("PRESUPUESTO");
		setBounds(550, 300, 550, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblpresupuesto = new JLabel("Presupuesto");
		lblpresupuesto.setBounds(10, 13, 80, 14);
		getContentPane().add(lblpresupuesto);

		txtpresupuesto = new JTextField();
		txtpresupuesto.setBounds(90, 10, 90, 20);
		getContentPane().add(txtpresupuesto);
		txtpresupuesto.setColumns(10);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(335, 9, 89, 23);
		getContentPane().add(btnCalcular);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(50, 80, 414, 120);
		getContentPane().add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnCalcular) {
			actionPerformedBtnProcesar(arg0);

		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}

	// DECLARO VARIABLES
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		double DinPrespsto, Ucay, Req, May, RCasti, Pmayo;

		// ENTRADA DE DATOS
		DinPrespsto = Double.parseDouble(txtpresupuesto.getText());

		// PROCESO DE DATOS
		Ucay = 0.135 * DinPrespsto;
		May = 0.15 * DinPrespsto;

		RCasti = 0.125 * (May + Ucay);
		Req = 0.35 * RCasti;
		Pmayo = DinPrespsto - (Ucay + May + RCasti + Req);

		// SALIDA DE DATOS
		txtS.setText("Ucayali recibira: " + Ucay + "\n");
		txtS.append("Maynas recibira : " + May + "\n");
		txtS.append("Ramon Castilla recibira : " + RCasti + "\n");
		txtS.append("Requena recibira : " + Req + "\n");
		txtS.append("Putumayo recibira : " + Pmayo);
	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtpresupuesto.setText("");
		txtS.setText("");
		txtpresupuesto.requestFocus();
	}

}
