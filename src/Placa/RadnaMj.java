package vsite.placa.java;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RadnaMj extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RadnaMj dialog = new RadnaMj();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RadnaMj() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, contentPanel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, contentPanel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, contentPanel, 51, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contentPanel, 434, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			{
				btnNewButton = new JButton("Unos");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RadnaMjUnos ru = new RadnaMjUnos();
						ru.setVisible(true);
						UpdateTable();
					}
				});
				sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, contentPanel);
				sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, contentPanel);
				contentPanel.add(btnNewButton);
			}
			{
				btnNewButton_1 = new JButton("Bri\u0161i");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DbConnection dc = new DbConnection();
						int indexRow = table.getSelectedRow();						
						if(indexRow!=-1) 
						{
							int id=Integer.parseInt(table.getValueAt(indexRow, 0).toString());
							dc.BrisiRadnoMjesto(id);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Nije odabran zaposlenik");
						}
						UpdateTable();
					}
				});
				sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
				sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, 13, SpringLayout.EAST, btnNewButton);
				contentPanel.add(btnNewButton_1);
			}
			
			table = new JTable();
			springLayout.putConstraint(SpringLayout.WEST, table, 111, SpringLayout.WEST, getContentPane());
			springLayout.putConstraint(SpringLayout.SOUTH, table, -102, SpringLayout.SOUTH, getContentPane());
			JScrollPane scrollPane = new JScrollPane(table);
			springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.SOUTH, contentPanel);
			springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, getContentPane());
			springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, getContentPane());
			springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, getContentPane());
			getContentPane().add(scrollPane);
			UpdateTable();
		}
	}
	private void UpdateTable()
	{
		DbConnection dbc = new DbConnection();
		table.setModel(dbc.SvaRadnaMjesta());
	}
}
