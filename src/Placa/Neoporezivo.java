package vsite.placa.java;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class Neoporezivo extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Neoporezivo dialog = new Neoporezivo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Neoporezivo() {
		setTitle("Neoporezive stavke");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 596, 561);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -300, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox);
		DbConnection dc = new DbConnection();
		ArrayList<String> imena = new ArrayList<String>();
		imena=dc.prikazImena();
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>(imena.toArray());
		comboBox.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Djelatnik:");
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -500, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 100, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, table, 100, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(scrollPane);
		UpdateTable();
		
		JLabel lblNewLabel_1 = new JLabel("Stavka");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 30, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -28, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -500, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNewLabel_1);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"putni", "nagrada", "obrok", "vrtic"}));
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 22, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 0, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -300, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Iznos");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 23, SpringLayout.EAST, comboBox_1);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Spremi");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -50, SpringLayout.EAST, getContentPane());
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbConnection dc = new DbConnection();
				String[] idZaposlenik = comboBox.getSelectedItem().toString().split(". ", 2);
				String neop = comboBox_1.getSelectedItem().toString();
				double iznos=0;
				DoubleCheck dch= new DoubleCheck();
				
				if(dch.check(textField.getText()))
				{
					iznos=Double.parseDouble(textField.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Greška kod unosa, provjerite iznos");
				}
				dc.spremiNeoporezivoZaposlenik(Integer.parseInt(idZaposlenik[0]),neop,iznos);
				UpdateTable();
			}
		});
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -2, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 2, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, comboBox_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, comboBox_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel_2);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	private void UpdateTable()
	{
		DbConnection dbc = new DbConnection();
		table.setModel(dbc.prikazNeoporezivo());
	}
}
