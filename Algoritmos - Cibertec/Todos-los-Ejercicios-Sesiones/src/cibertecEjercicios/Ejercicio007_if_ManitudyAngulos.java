package cibertecEjercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Ejercicio007_if_ManitudyAngulos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblGrados;
	private JLabel lblMinutos;
	private JLabel lblSegundos;
	private JTextField txtGrados;
	private JTextField txtMinutos;
	private JTextField txtSegundos;
	private JButton btnCalcular;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio007_if_ManitudyAngulos frame = new Ejercicio007_if_ManitudyAngulos();
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
	public Ejercicio007_if_ManitudyAngulos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblGrados = new JLabel("Grados");
			lblGrados.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblGrados.setBounds(52, 35, 70, 18);
			contentPane.add(lblGrados);
		}
		{
			lblMinutos = new JLabel("Minutos");
			lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblMinutos.setBounds(52, 69, 70, 18);
			contentPane.add(lblMinutos);
		}
		{
			lblSegundos = new JLabel("Segundos");
			lblSegundos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSegundos.setBounds(52, 108, 70, 18);
			contentPane.add(lblSegundos);
		}
		{
			txtGrados = new JTextField();
			txtGrados.setBounds(133, 24, 96, 31);
			contentPane.add(txtGrados);
			txtGrados.setColumns(10);
		}
		{
			txtMinutos = new JTextField();
			txtMinutos.setColumns(10);
			txtMinutos.setBounds(132, 64, 96, 31);
			contentPane.add(txtMinutos);
		}
		{
			txtSegundos = new JTextField();
			txtSegundos.setColumns(10);
			txtSegundos.setBounds(133, 103, 96, 31);
			contentPane.add(txtSegundos);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnCalcular.setBounds(303, 35, 85, 21);
			contentPane.add(btnCalcular);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(24, 141, 356, 112);
			contentPane.add(textArea);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		double grados, min, seg, angulo;
		String clasificacion;

		grados = Double.parseDouble(txtGrados.getText());
		min = Double.parseDouble(txtMinutos.getText());
		seg = Double.parseDouble(txtSegundos.getText());

		angulo = grados + (min / 60.0) + (seg / 3600.0);

		if (angulo == 0)
			clasificacion = "Nulo";
		else if (angulo < 90)
			clasificacion = "Agudo";
		else if (angulo == 90)
			clasificacion = "Recto";
		else if (angulo > 90 && angulo < 180)
			clasificacion = "Obtuso";
		else if (angulo == 180)
			clasificacion = "Llano";
		else if (angulo > 180 && angulo < 360)
			clasificacion = "Concavo";
		else
			clasificacion = "Completo";

		textArea.append("Angulo es: " + angulo);

	}
}
