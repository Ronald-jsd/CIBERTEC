package cibertecEjercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio006_ifelseString extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblGenero;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JComboBox cboGenero;
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio006_ifelseString frame = new Ejercicio006_ifelseString();
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
	public Ejercicio006_ifelseString() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblGenero = new JLabel("GENERO");
			lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGenero.setBounds(33, 42, 122, 24);
			contentPane.add(lblGenero);
		}
		{
			lblEdad = new JLabel("EDAD");
			lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEdad.setBounds(33, 87, 122, 24);
			contentPane.add(lblEdad);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setBounds(182, 92, 96, 19);
			contentPane.add(txtEdad);
			txtEdad.setColumns(10);
		}
		{
			cboGenero = new JComboBox();
			cboGenero.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
			cboGenero.setName("");
			cboGenero.setBounds(178, 46, 100, 21);
			contentPane.add(cboGenero);
		}
		{
			btnNewButton = new JButton("CALCULAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnNewButton.setBounds(300, 46, 126, 21);
			contentPane.add(btnNewButton);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(44, 142, 345, 111);
			contentPane.add(textArea);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		String genero, categoria = null;
		int edad;

		genero = cboGenero.getSelectedItem().toString();
		edad = Integer.parseInt(txtEdad.getText());

		if (genero == "Femenino" && edad < 23) {
			categoria = "FA";
		} else if (genero == "Femenino" && edad >= 23) {
			categoria = "FB";
		}

		if (genero == "Masculino" && edad < 25) {
			categoria = "MA";
		} else if (genero == "Masculino" && edad >= 25) {
			categoria = "MB";
		}

		textArea.setText("Su categoria es: " + categoria);
		/*
		 * if(genero == "Femenino") { if (edad<23) categoria = "FA"; else categoria =
		 * "FB"; }
		 * 
		 * else { if (edad<25) categoria = "MA"; else categoria = "MB"; }
		 * 
		 * textArea.setText(categoria);
		 */
	}
}
