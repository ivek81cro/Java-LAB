package vsite.placa.java;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RadnaMjUnos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtNaziv;
	private JTextField txtKoeficijent;
	private JLabel lblKoeficijent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RadnaMjUnos dialog = new RadnaMjUnos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RadnaMjUnos() {
		setModal(true);
		setTitle("Unos radnog mijesta");
		setResizable(false);
		setBounds(100, 100, 488, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			lblNewLabel = new JLabel("Naziv");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblNewLabel);
		}
		{
			lblKoeficijent = new JLabel("Koeficijent");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblKoeficijent, 17, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblKoeficijent, 0, SpringLayout.WEST, lblNewLabel);
			contentPanel.add(lblKoeficijent);
		}
		
		txtNaziv = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtNaziv, -3, SpringLayout.NORTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtNaziv, 241, SpringLayout.EAST, lblNewLabel);
		contentPanel.add(txtNaziv);
		txtNaziv.setColumns(10);
		
		txtKoeficijent = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtNaziv, 0, SpringLayout.WEST, txtKoeficijent);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtKoeficijent, 38, SpringLayout.EAST, lblKoeficijent);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, txtKoeficijent, 0, SpringLayout.SOUTH, lblKoeficijent);
		txtKoeficijent.setColumns(10);
		contentPanel.add(txtKoeficijent);
		
		JButton btnNewButton = new JButton("Spremi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String koef = txtKoeficijent.getText().replace(",", ".");
				DbConnection dbc = new DbConnection();
				DoubleCheck dc = new DoubleCheck();
				if(dc.check(koef))
				{
					double k = Double.parseDouble(koef);
					RadnoMjesto rm = new RadnoMjesto(txtNaziv.getText(),k);
					if(dbc.UnosRadnogmjesta(rm))
					{
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Greška kod unosa, radno mjesto nije unešeno");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unesite koeficijent u odgovarajuæem formatu");
				}
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPanel);
		contentPanel.add(btnNewButton);
	}
}
