package ada2_POOGit;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
	ArrayList<String> ListaNombres = new ArrayList<String>();
	ArrayList<registro> ListaRegistros = new ArrayList<registro>();
	LocalDate hoy = LocalDate.now();
	DefaultListModel<String> modeloGlucosa = new DefaultListModel<>();
	
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
		setBounds(100, 100, 696, 459);
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
		toolBar.setBounds(10, 246, 96, 28);
		contentPane.add(toolBar);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
	
				for (int i = 0; i < ListaRegistros.size(); i++) {
					ListaNombres.add(ListaRegistros.get(i).getNombre());
				}
			String nombreAct= "";
			
				Collections.sort(ListaNombres);
				for (String nombres : ListaNombres) {
									
				if (!nombreAct.equals(nombres)) {
					nombreAct= nombres;
				
					       for (int j=0; j<ListaRegistros.size();j++) {
								registro PBuscar= ListaRegistros.get(j);
								
								if (PBuscar.getNombre().equals(nombreAct)){	
								modeloHistorial.addElement("Nombre:"+PBuscar.getNombre() + " "+"Glusocosa:"+ PBuscar.getGlucosa() + " "+"Fecha:" + PBuscar.getFecha());													
					}
					   
					}
				}
				}	
		}	
		});
		toolBar.add(btnHistorial);
		
		JList listHistprial = new JList();
		listHistprial.setBounds(38, 280, 372, 131);
		contentPane.add(listHistprial);
		listHistprial.setModel(modeloHistorial);
		
		JButton btnBuscar = new JButton("Buscar Persona");
		btnBuscar.setBounds(38, 34, 150, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar Persona");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int elim = listHistprial.getSelectedIndex();
			
			if(elim != -1) {
				
				String ReSelecc =modeloHistorial.getElementAt(elim);
				
					for (int t = 0; t < ListaRegistros.size(); t++) {
						registro r = ListaRegistros.get(t);
						String TxtRegis = "Nombre:"+r.getNombre() + " "+"Glusocosa:"+ r.getGlucosa() + " "+"Fecha:" + r.getFecha();
						
						if (TxtRegis.equals(ReSelecc)) {
							ListaRegistros.remove(t);
						}
						
					}
				modeloHistorial.remove(elim);
				JOptionPane.showMessageDialog(null,  "Reistro eliminado");
				
			}else {
				JOptionPane.showMessageDialog(null, "Seleciona un regisro");
	}
			}	
		
			
		});
		btnEliminar.setBounds(258, 34, 152, 23);
		contentPane.add(btnEliminar);
		
		

		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre:");
		        
		        modeloHistorial.clear(); 

		        boolean encontrado = false;

		        for (registro r : ListaRegistros) {

		            if (r.getNombre().equalsIgnoreCase(nombreBuscar)) {

		                modeloHistorial.addElement(
		                    "Nombre: " + r.getNombre() +
		                    " Glucosa: " + r.getGlucosa() +
		                    " Fecha: " + r.getFecha()
		                );

		                encontrado = true;
		            }
		        }


		       

		        if (!encontrado) {
		            JOptionPane.showMessageDialog(null, "No existe");
		        }
		    }
		});
	}
}
