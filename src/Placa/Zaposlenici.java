package vsite.placa.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zaposlenici extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnUnos;
	private DbConnection dbc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Zaposlenici dialog = new Zaposlenici();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Zaposlenici() {
		setTitle("Popis zaposlenika");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setBounds(100, 100, 604, 525);
		getContentPane().setLayout(new BorderLayout());
		{
			table = new JTable();
			getContentPane().add(new JScrollPane(table));
			UpdateTable();
		}
		{
			JPanel panel = new JPanel();
			panel.setAlignmentY(Component.TOP_ALIGNMENT);
			panel.setAlignmentX(Component.LEFT_ALIGNMENT);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				btnUnos = new JButton("Unos");
				btnUnos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						ZaposleniciUnos dialog = new ZaposleniciUnos();
						dialog.setVisible(true);
						UpdateTable();
					}
				});
			}
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panel.add(btnUnos);
			{
				JButton btnBrisi = new JButton("Bri\u0161i");
				btnBrisi.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						DbConnection dc = new DbConnection();
						int indexRow = table.getSelectedRow();						
						if(indexRow!=-1) 
						{
							int id=Integer.parseInt(table.getValueAt(indexRow, 0).toString());
							dc.BrisiZaposlenika(id);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Nije odabran zaposlenik");
						}
						UpdateTable();
					}
				});
				panel.add(btnBrisi);
			}
		}
	}
	
	private void UpdateTable()
	{
		dbc = new DbConnection();
		table.setModel(dbc.prikazSve());
	}
}
