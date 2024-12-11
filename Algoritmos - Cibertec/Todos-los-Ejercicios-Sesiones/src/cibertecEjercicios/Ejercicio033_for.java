package cibertecEjercicios; 

	import java.awt.EventQueue;
	import java.awt.Font;
	import javax.swing.JFrame;
	import javax.swing.JButton;
	import javax.swing.UIManager;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import java.awt.event.ActionListener;
	import java.util.Iterator;
	import java.awt.event.ActionEvent;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;

	
	class Ejercicio033_for extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L; 


	private JLabel lblInicial; 
	private JLabel lblFinal;
	
	private JTextField txtInicial;
	private JTextField txtFinal;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;


	public static void main(String[] args) { 
		
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() { try { Ejercicio033_for frame = new Ejercicio033_for();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	public Ejercicio033_for() {
		setTitle("CONTADOR"); 
		setBounds(150, 300, 450, 239); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().setLayout(null); 
		
		//JLabel
		lblInicial = new JLabel("Valor inicial");
		lblInicial.setBounds(10, 13, 120, 14); 
		getContentPane().add(lblInicial);  
		
		lblFinal = new JLabel("Valor Final");
		lblFinal.setBounds(10, 38, 100, 14); 
		getContentPane().add(lblFinal);
		
		
		txtInicial = new JTextField(); 
		txtInicial.setBounds(120, 10, 90, 20);
		getContentPane().add(txtInicial); 
		txtInicial.setColumns(10);  
		
		txtFinal = new JTextField();
		txtFinal.setBounds(120, 35, 90, 20);
		getContentPane().add(txtFinal);
		txtFinal.setColumns(10);
		
		
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

	} if (arg0.getSource() == btnBorrar) { 
		actionPerformedBtnBorrar(arg0);
		}
	}


	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		int  VI, VF;
		
		VI = Integer.parseInt(txtInicial.getText());
		VF =  Integer.parseInt(txtFinal.getText());
		
		txtS.setText("");
		
		/* while(VI<=VF) {
			if (VI % 2 == 0) 
				txtS.append(VI + "\n");
				VI++;*/
		
		//Declaramos una variable local i en el bucle for 
		//Este metdo es mas recomendable con las buenas practicas
		for ( int i = VI; i <= VF; i++) {
			if (i % 2 == 0) 
				txtS.append(i + "\n");
		}
			
		}
		
	
	
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtInicial.setText("");
	txtFinal.setText("");
	txtS.setText("");
	txtInicial.requestFocus();
	}
}
