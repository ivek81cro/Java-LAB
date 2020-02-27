package vsite.placa.java;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZaposleniciUnos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOib;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;
	private JTextField txtGrad;
	private JTextField txtPrirez;
	private JTextField txtOlaksica;
	private static String m_oib;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ZaposleniciUnos dialog = new ZaposleniciUnos(m_oib);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ZaposleniciUnos(String oib) {
		m_oib=oib;
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setTitle("Unos zaposlenika");
		setBounds(100, 100, 555, 421);
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lbOib = new JLabel("OIB");
		springLayout.putConstraint(SpringLayout.NORTH, lbOib, 50, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbOib, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbOib, 60, SpringLayout.WEST, getContentPane());
		getContentPane().add(lbOib);
		
		JLabel lbIme = new JLabel("Ime");
		springLayout.putConstraint(SpringLayout.NORTH, lbIme, 118, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbOib, -52, SpringLayout.NORTH, lbIme);
		springLayout.putConstraint(SpringLayout.WEST, lbIme, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbIme, -479, SpringLayout.EAST, getContentPane());
		getContentPane().add(lbIme);
		
		JLabel lbPrezime = new JLabel("Prezime");
		springLayout.putConstraint(SpringLayout.NORTH, lbPrezime, 184, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbIme, -52, SpringLayout.NORTH, lbPrezime);
		springLayout.putConstraint(SpringLayout.WEST, lbPrezime, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbPrezime, -184, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbPrezime, -479, SpringLayout.EAST, getContentPane());
		getContentPane().add(lbPrezime);
		
		JLabel lbAdresa = new JLabel("Adresa");
		springLayout.putConstraint(SpringLayout.NORTH, lbAdresa, 52, SpringLayout.SOUTH, lbPrezime);
		springLayout.putConstraint(SpringLayout.WEST, lbAdresa, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbAdresa, -118, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbAdresa, -479, SpringLayout.EAST, getContentPane());
		getContentPane().add(lbAdresa);
		
		JLabel lbGrad = new JLabel("Grad");
		springLayout.putConstraint(SpringLayout.NORTH, lbGrad, 52, SpringLayout.SOUTH, lbAdresa);
		springLayout.putConstraint(SpringLayout.WEST, lbGrad, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbGrad, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbGrad, -479, SpringLayout.EAST, getContentPane());
		getContentPane().add(lbGrad);
		
		txtOib = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtOib, -3, SpringLayout.NORTH, lbOib);
		getContentPane().add(txtOib);
		txtOib.setColumns(10);
		
		txtIme = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtOib, 0, SpringLayout.WEST, txtIme);
		springLayout.putConstraint(SpringLayout.WEST, txtIme, 20, SpringLayout.EAST, lbIme);
		springLayout.putConstraint(SpringLayout.EAST, txtIme, -321, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtOib, 0, SpringLayout.EAST, txtIme);
		springLayout.putConstraint(SpringLayout.NORTH, txtIme, -3, SpringLayout.NORTH, lbIme);
		txtIme.setColumns(10);
		getContentPane().add(txtIme);
		
		txtPrezime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPrezime, -3, SpringLayout.NORTH, lbPrezime);
		springLayout.putConstraint(SpringLayout.WEST, txtPrezime, 20, SpringLayout.EAST, lbPrezime);
		springLayout.putConstraint(SpringLayout.EAST, txtPrezime, -321, SpringLayout.EAST, getContentPane());
		txtPrezime.setColumns(10);
		getContentPane().add(txtPrezime);
		
		txtAdresa = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtAdresa, -3, SpringLayout.NORTH, lbAdresa);
		springLayout.putConstraint(SpringLayout.WEST, txtAdresa, 20, SpringLayout.EAST, lbAdresa);
		springLayout.putConstraint(SpringLayout.EAST, txtAdresa, -321, SpringLayout.EAST, getContentPane());
		txtAdresa.setColumns(10);
		getContentPane().add(txtAdresa);
		
		txtGrad = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtGrad, -3, SpringLayout.NORTH, lbGrad);
		springLayout.putConstraint(SpringLayout.WEST, txtGrad, 20, SpringLayout.EAST, lbGrad);
		springLayout.putConstraint(SpringLayout.EAST, txtGrad, -321, SpringLayout.EAST, getContentPane());
		txtGrad.setColumns(10);
		getContentPane().add(txtGrad);		
		
		JButton btnNewButton = new JButton("Spremi");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -92, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoubleCheck dch = new DoubleCheck();
				double olaksica=0, prirez=0;
				if(dch.check(txtPrirez.getText()) & dch.check(txtOlaksica.getText()))
				{
					olaksica = Double.parseDouble(txtOlaksica.getText());
					prirez = Double.parseDouble(txtPrirez.getText());
					
					if(prirez>1)
						prirez=prirez/100.0;
				}
				
				Zaposlenik z = new Zaposlenik(txtOib.getText(), txtIme.getText(), txtPrezime.getText(), txtAdresa.getText(), 
						txtGrad.getText(), olaksica, prirez);
				if(z.Kontrola())
				{
					DbConnection dc = new DbConnection();
					if(dc.UnesiZaposlenika(z))
					{
						dispose();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Greška kod unosa, zaposlenik nije unešen");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Greška kod unosa, zaposlenik nije unešen");
				}
					
			}
		});
		getContentPane().add(btnNewButton);
		
		JLabel lblPrirez = new JLabel("Prirez");
		springLayout.putConstraint(SpringLayout.WEST, lblPrirez, 24, SpringLayout.EAST, txtOib);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPrirez, 0, SpringLayout.SOUTH, lbOib);
		getContentPane().add(lblPrirez);
		
		JLabel lblOlakica = new JLabel("Olak\u0161ica");
		springLayout.putConstraint(SpringLayout.NORTH, lblOlakica, 0, SpringLayout.NORTH, lbIme);
		springLayout.putConstraint(SpringLayout.WEST, lblOlakica, 0, SpringLayout.WEST, lblPrirez);
		getContentPane().add(lblOlakica);
		
		txtPrirez = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPrirez, -2, SpringLayout.NORTH, lbOib);
		txtPrirez.setColumns(10);
		getContentPane().add(txtPrirez);
		
		txtOlaksica = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtPrirez, 0, SpringLayout.EAST, txtOlaksica);
		springLayout.putConstraint(SpringLayout.WEST, txtOlaksica, 6, SpringLayout.EAST, lblOlakica);
		springLayout.putConstraint(SpringLayout.SOUTH, txtOlaksica, 0, SpringLayout.SOUTH, lbIme);
		txtOlaksica.setColumns(10);
		getContentPane().add(txtOlaksica);
		
		JButton btnNewButton_1 = new JButton("Izmjeni");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, -92, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, getContentPane());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				DoubleCheck dch = new DoubleCheck();
				double olaksica=0, prirez=0;
				if(dch.check(txtPrirez.getText()) & dch.check(txtOlaksica.getText()))
				{
					olaksica = Double.parseDouble(txtOlaksica.getText());
					prirez = Double.parseDouble(txtPrirez.getText());
					
					if(prirez>1)
						prirez=prirez/100.0;
				}
				Zaposlenik z = new Zaposlenik();
				z.setOlaksica(olaksica);
				z.setPrirez(prirez);
				z.setOib(txtOib.getText());
				z.setIme(txtIme.getText());
				z.setAdresa(txtAdresa.getText());
				z.setGrad(txtGrad.getText());
				z.setPrezme(txtPrezime.getText());
				if(z.Kontrola())
				{
					DbConnection dc = new DbConnection();
					if(dc.IzmjeniZaposlenika(z))
					{
						dispose();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Greška kod izmjene, zaposlenik nije izmjenjen");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Greška kod izmjene, zaposlenik nije izmjenjen");
				}
			}
		});
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		if(m_oib != "0")
		{
			dohvati();
			btnNewButton_1.setVisible(true);
			btnNewButton.setVisible(false);
		}
		
	}
	
	private void dohvati()
	{
		DbConnection dc = new DbConnection();
		Zaposlenik z = new Zaposlenik();
		z =dc.DohvatiZaposlenika(m_oib);
		txtIme.setText(z.getIme());
		txtPrezime.setText(z.getPrezime());
		txtAdresa.setText(z.getAdresa());
		txtGrad.setText(z.getGrad());
		txtPrirez.setText(Double.toString(z.getPrirez()));
		txtOlaksica.setText(Double.toString(z.getOlaksica()));
		txtOib.setText(z.getOib());
	}
}
