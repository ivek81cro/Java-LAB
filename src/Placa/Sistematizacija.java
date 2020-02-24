package vsite.placa.java;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sistematizacija extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sistematizacija dialog = new Sistematizacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sistematizacija() {
		setModal(true);
		setTitle("Sistematizacija");
		setResizable(false);
		setBounds(100, 100, 548, 481);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 176, SpringLayout.WEST, getContentPane());
		getContentPane().add(comboBox);
		
		DbConnection dc = new DbConnection();
		ArrayList<String> imena = new ArrayList<String>();
		imena=dc.prikazImena();
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>(imena.toArray());
		comboBox.setModel(model);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -180, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox_1);
		
		imena=dc.prikazRadnamj();
		DefaultComboBoxModel<Object> model2 = new DefaultComboBoxModel<Object>(imena.toArray());
		comboBox_1.setModel(model2);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 15, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, getContentPane());
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Spremi");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -1, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -50, SpringLayout.EAST, getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbConnection dc = new DbConnection();
				String[] idZaposlenik = comboBox.getSelectedItem().toString().split(". ", 2);
				String[] idRadnomj = comboBox_1.getSelectedItem().toString().split(". ", 2);
				dc.OdrediRadnoMjesto(Integer.parseInt(idZaposlenik[0]),Integer.parseInt(idRadnomj[0]));
				UpdateTable();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, comboBox_1);
		getContentPane().add(btnNewButton);
		UpdateTable();
	}
	
	private void UpdateTable()
	{
		DbConnection dbc = new DbConnection();
		table.setModel(dbc.prikazSistematizacije());
	}
}
