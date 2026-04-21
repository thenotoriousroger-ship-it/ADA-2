package ada2_POOGit;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMuestra;
	DefaultListModel<String> modeloHistorial= new DefaultListModel<>();
	ArrayList<registro> ListaRegistros = new ArrayList<registro>();
	LocalDate hoy = LocalDate.now();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(56, 88, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Muestra");
		lblNewLabel_1.setBounds(56, 124, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha");
		lblNewLabel_2.setBounds(56, 160, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(135, 86, 195, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textMuestra = new JTextField();
		textMuestra.setBounds(135, 122, 96, 20);
		textMuestra.setColumns(10);
		contentPane.add(textMuestra);
		
		JLabel lblNewLabel_3 = new JLabel("mg/dL");
		lblNewLabel_3.setBounds(241, 125, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setBounds(135, 157, 39, 22);
		comboDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		contentPane.add(comboDia);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setBounds(188, 157, 109, 22);
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		contentPane.add(comboMes);
		
		JComboBox comboAño = new JComboBox();
		comboAño.setBounds(310, 157, 57, 22);
		comboAño.setModel(new DefaultComboBoxModel(new String[] {"2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034"}));
		contentPane.add(comboAño);
		
		comboDia.setSelectedIndex(hoy.getDayOfMonth()-1);
		comboMes.setSelectedIndex(hoy.getMonthValue()-1);
		comboAño.setSelectedIndex(hoy.getYear()-2026);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(201, 216, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dia=Integer.parseInt((String)comboDia.getSelectedItem());
				int mes=comboMes.getSelectedIndex()+1;
				int año=Integer.parseInt((String)comboAño.getSelectedItem());
				
				LocalDate fechaDeMuestra = LocalDate.of(año, mes, dia);
				registro persona = new registro(textNombre.getText(),Double.parseDouble(textMuestra.getText()),fechaDeMuestra);
				
				ListaRegistros.add(persona);
				
				textNombre.setText("");
				textMuestra.setText("");
				comboDia.setSelectedIndex(hoy.getDayOfMonth()-1);
				comboMes.setSelectedIndex(hoy.getMonthValue()-1);
				comboAño.setSelectedIndex(hoy.getYear()-2026);
				
				JOptionPane.showMessageDialog(null, "Registro guardado");
			}
		});
		contentPane.add(btnGuardar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(44, 264, 96, 28);
		contentPane.add(toolBar);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
							
				for (int i=0; i<ListaRegistros.size();i++) {
					registro Persona= ListaRegistros.get(i);	
							
							modeloHistorial.addElement(Persona.getNombre()+ " "+ Persona.getGlucosa()+ " "+ Persona.getFecha());			
				}				
			}
			
		});
		toolBar.add(btnHistorial);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 264, 224, 130);
		contentPane.add(scrollPane);
		
		JList listHistprial = new JList();
		scrollPane.setColumnHeaderView(listHistprial);
		listHistprial.setModel(modeloHistorial);
}
}
