package vsite.placa.java;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Izracun extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtSati;
	private JTextField txtPrekovremeni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Izracun dialog = new Izracun();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Izracun() {
		setTitle("Obra\u010Dun pla\u0107e");
		setModal(true);
		setBounds(100, 100, 901, 310);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		
		JButton btnObracunaj = new JButton("Obra\u010Dunaj pla\u0107u");
		btnObracunaj.setMargin(new Insets(2, 5, 2, 5));
		springLayout.putConstraint(SpringLayout.NORTH, btnObracunaj, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnObracunaj, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnObracunaj, 153, SpringLayout.WEST, getContentPane());
		btnObracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double neoporezivo=0, sati = 0, prekovremeni=0;
				DoubleCheck dch = new DoubleCheck();
				String[] idZaposlenik = comboBox.getSelectedItem().toString().split(". ", 2);
				int id =Integer.parseInt(idZaposlenik[0]);
				if(dch.check(txtSati.getText()) & dch.check(txtPrekovremeni.getText()) )
				{
					sati= Double.parseDouble(txtSati.getText());
					prekovremeni = Double.parseDouble(txtPrekovremeni.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Greška kod unosa, provjerite sate");
					return;
				}
				DbConnection dc = new DbConnection();
				neoporezivo = dc.dohvatiNeoporezivoDjelatnika(id);
				Obracun o = new Obracun();
				o.Obracunaj(id, sati, prekovremeni, neoporezivo);
				dc.upisiObracun(o, id);
				UpdateTable();
			}
		});
		
		getContentPane().add(btnObracunaj);
		
		table = new JTable();
		table.setDoubleBuffered(true);
		springLayout.putConstraint(SpringLayout.NORTH, table, 66, SpringLayout.SOUTH, btnObracunaj);
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, getContentPane());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setDoubleBuffered(true);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 100, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(scrollPane);
		UpdateTable();
		
		//combobox ostatak
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 100, SpringLayout.EAST, btnObracunaj);
		getContentPane().add(comboBox);
		DbConnection dc = new DbConnection();
		ArrayList<String> imena = new ArrayList<String>();
		imena=dc.prikazImena();
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>(imena.toArray());
		comboBox.setModel(model);
		
		JLabel lblNewLabel = new JLabel("za djelatnika:");
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 200, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 4, SpringLayout.NORTH, btnObracunaj);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.EAST, btnObracunaj);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sati rada:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 30, SpringLayout.SOUTH, btnObracunaj);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -15, SpringLayout.NORTH, scrollPane);
		getContentPane().add(lblNewLabel_1);
		
		txtSati = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtSati, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtSati, 5, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSati, 0, SpringLayout.SOUTH, lblNewLabel_1);
		getContentPane().add(txtSati);
		txtSati.setText("160");
		txtSati.setColumns(10);
		
		JLabel lblOdTogaPrekovremeno = new JLabel("od toga prekovremeno");
		springLayout.putConstraint(SpringLayout.NORTH, lblOdTogaPrekovremeno, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblOdTogaPrekovremeno, 5, SpringLayout.EAST, txtSati);
		springLayout.putConstraint(SpringLayout.SOUTH, lblOdTogaPrekovremeno, 0, SpringLayout.SOUTH, lblNewLabel_1);
		getContentPane().add(lblOdTogaPrekovremeno);
		
		txtPrekovremeni = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPrekovremeni, 0, SpringLayout.NORTH, txtSati);
		springLayout.putConstraint(SpringLayout.WEST, txtPrekovremeni, 6, SpringLayout.EAST, lblOdTogaPrekovremeno);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPrekovremeni, 0, SpringLayout.SOUTH, txtSati);
		getContentPane().add(txtPrekovremeni);
		txtPrekovremeni.setText("0");
		txtPrekovremeni.setColumns(10);		
	}
	
	private void UpdateTable()
	{
		DbConnection dbc = new DbConnection();
		table.setModel(dbc.prikazObracuna());
	}
}
