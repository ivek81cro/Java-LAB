package vsite.placa.java;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class PostavkePlaca extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtZdravstvo;
	private JTextField txtPorez2;
	private JTextField txtPorez1;
	private JTextField txtUzdrzavaniClan;
	private JTextField txtDijete3;
	private JTextField txtDijete2;
	private JTextField txtDijete1;
	private JTextField txtOsnovicaUzdrzavanje;
	private JTextField txtOdbitak;
	private JTextField txtBod;
	private JTextField txtMio1;
	private JTextField txtMio2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PostavkePlaca dialog = new PostavkePlaca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PostavkePlaca() {
		PlacaObj pl=new PlacaObj();
		
		pl.DohvatiPostavke();
		setTitle("Postavke koeficjenata");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 555, 471);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblbod = new JLabel("Iznos boda");
		springLayout.putConstraint(SpringLayout.WEST, lblbod, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblbod, -388, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblbod);
		
		JLabel lblOdbitak = new JLabel("Osnovni odbitak");
		springLayout.putConstraint(SpringLayout.NORTH, lblOdbitak, 25, SpringLayout.SOUTH, lblbod);
		springLayout.putConstraint(SpringLayout.WEST, lblOdbitak, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblOdbitak, -349, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblOdbitak);
		
		JLabel lblOsnovicaZaDijecu = new JLabel("Osnovica za dijecu");
		springLayout.putConstraint(SpringLayout.NORTH, lblOsnovicaZaDijecu, 25, SpringLayout.SOUTH, lblOdbitak);
		springLayout.putConstraint(SpringLayout.WEST, lblOsnovicaZaDijecu, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblOsnovicaZaDijecu, -310, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblOsnovicaZaDijecu);
		
		JLabel lblKoefPrvoDijete = new JLabel("Koef. prvo dijete");
		springLayout.putConstraint(SpringLayout.NORTH, lblKoefPrvoDijete, 25, SpringLayout.SOUTH, lblOsnovicaZaDijecu);
		springLayout.putConstraint(SpringLayout.WEST, lblKoefPrvoDijete, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblKoefPrvoDijete, -271, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblKoefPrvoDijete);
		
		JLabel lblKoefDrugoDijete = new JLabel("Koef. drugo dijete");
		springLayout.putConstraint(SpringLayout.NORTH, lblKoefDrugoDijete, 25, SpringLayout.SOUTH, lblKoefPrvoDijete);
		springLayout.putConstraint(SpringLayout.WEST, lblKoefDrugoDijete, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblKoefDrugoDijete, -232, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblKoefDrugoDijete);
		
		JLabel lblKoefTreceDijete = new JLabel("Koef. tre\u0107e dijete");
		springLayout.putConstraint(SpringLayout.NORTH, lblKoefTreceDijete, 25, SpringLayout.SOUTH, lblKoefDrugoDijete);
		springLayout.putConstraint(SpringLayout.WEST, lblKoefTreceDijete, 9, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblKoefTreceDijete, -193, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblKoefTreceDijete);
		
		JLabel lblUzdravanilan = new JLabel("Uzdr\u017Eavani \u010Dlan");
		springLayout.putConstraint(SpringLayout.NORTH, lblUzdravanilan, 25, SpringLayout.SOUTH, lblKoefTreceDijete);
		springLayout.putConstraint(SpringLayout.WEST, lblUzdravanilan, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUzdravanilan, -154, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblUzdravanilan);
		
		JLabel lblPorez = new JLabel("Porez 1");
		springLayout.putConstraint(SpringLayout.NORTH, lblPorez, 25, SpringLayout.SOUTH, lblUzdravanilan);
		springLayout.putConstraint(SpringLayout.WEST, lblPorez, 11, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPorez, -115, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblPorez);
		
		JLabel lblPorez_1 = new JLabel("Porez 2");
		springLayout.putConstraint(SpringLayout.NORTH, lblPorez_1, 25, SpringLayout.SOUTH, lblPorez);
		springLayout.putConstraint(SpringLayout.WEST, lblPorez_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPorez_1, -76, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblPorez_1);
		
		JLabel lblDoprinosiZdravstvo = new JLabel("Doprinosi zdravstvo");
		springLayout.putConstraint(SpringLayout.NORTH, lblDoprinosiZdravstvo, 25, SpringLayout.SOUTH, lblPorez_1);
		springLayout.putConstraint(SpringLayout.WEST, lblDoprinosiZdravstvo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDoprinosiZdravstvo, -37, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblDoprinosiZdravstvo);
		
		DoubleCheck dc = new DoubleCheck();
		txtZdravstvo = new JTextField();
		txtZdravstvo.setText(String.valueOf(pl.getZdravstveno()));
		springLayout.putConstraint(SpringLayout.EAST, lblDoprinosiZdravstvo, -6, SpringLayout.WEST, txtZdravstvo);
		springLayout.putConstraint(SpringLayout.WEST, txtZdravstvo, 151, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtZdravstvo, -324, SpringLayout.EAST, getContentPane());
		getContentPane().add(txtZdravstvo);
		txtZdravstvo.setColumns(10);
		txtZdravstvo.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtZdravstvo.getText().equals(txt))
					if(dc.check(txtZdravstvo.getText()))
						pl.setZdravstveno(Double.parseDouble(txtZdravstvo.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtZdravstvo.getText();
			}
		});
		
		txtPorez2 = new JTextField();
		txtPorez2.setText(String.valueOf(pl.getPorez2()));
		springLayout.putConstraint(SpringLayout.NORTH, txtZdravstvo, 19, SpringLayout.SOUTH, txtPorez2);
		springLayout.putConstraint(SpringLayout.EAST, lblPorez_1, -6, SpringLayout.WEST, txtPorez2);
		springLayout.putConstraint(SpringLayout.EAST, txtPorez2, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtPorez2, 0, SpringLayout.WEST, txtZdravstvo);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPorez2, -73, SpringLayout.SOUTH, getContentPane());
		txtPorez2.setColumns(10);
		getContentPane().add(txtPorez2);
		txtPorez2.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtPorez2.getText().equals(txt))
					if(dc.check(txtPorez2.getText()))
						pl.setPorez2(Double.parseDouble(txtPorez2.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtPorez2.getText();
			}
		  });
		
		txtPorez1 = new JTextField();
		txtPorez1.setText(String.valueOf(pl.getPorez1()));
		springLayout.putConstraint(SpringLayout.EAST, lblPorez, -6, SpringLayout.WEST, txtPorez1);
		springLayout.putConstraint(SpringLayout.EAST, txtPorez1, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtPorez1, 0, SpringLayout.WEST, txtZdravstvo);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPorez1, -112, SpringLayout.SOUTH, getContentPane());
		txtPorez1.setColumns(10);
		getContentPane().add(txtPorez1);
		txtPorez1.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtPorez1.getText().equals(txt))
					if(dc.check(txtPorez1.getText()))
						pl.setPorez1(Double.parseDouble(txtPorez1.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtPorez1.getText();
			}
		  });
		
		txtUzdrzavaniClan = new JTextField();
		txtUzdrzavaniClan.setText(String.valueOf(pl.getuzdrzavaniClan()));
		springLayout.putConstraint(SpringLayout.EAST, lblUzdravanilan, -6, SpringLayout.WEST, txtUzdrzavaniClan);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUzdrzavaniClan, -16, SpringLayout.NORTH, txtPorez1);
		springLayout.putConstraint(SpringLayout.EAST, txtUzdrzavaniClan, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtUzdrzavaniClan, 0, SpringLayout.WEST, txtZdravstvo);
		txtUzdrzavaniClan.setColumns(10);
		getContentPane().add(txtUzdrzavaniClan);
		txtUzdrzavaniClan.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtUzdrzavaniClan.getText().equals(txt))
					if(dc.check(txtUzdrzavaniClan.getText()))
						pl.setuzdrzavaniClan(Double.parseDouble(txtUzdrzavaniClan.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtUzdrzavaniClan.getText();
			}
		  });
		
		txtDijete3 = new JTextField();
		txtDijete3.setText(String.valueOf(pl.getDijete3()));
		springLayout.putConstraint(SpringLayout.EAST, lblKoefTreceDijete, -6, SpringLayout.WEST, txtDijete3);
		springLayout.putConstraint(SpringLayout.EAST, txtDijete3, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtDijete3, 0, SpringLayout.WEST, txtZdravstvo);
		springLayout.putConstraint(SpringLayout.SOUTH, txtDijete3, -190, SpringLayout.SOUTH, getContentPane());
		txtDijete3.setColumns(10);
		getContentPane().add(txtDijete3);
		txtDijete3.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtDijete3.getText().equals(txt))
					if(dc.check(txtDijete3.getText()))
						pl.setDijete3(Double.parseDouble(txtDijete3.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtDijete3.getText();
			}
		  });
		
		txtDijete2 = new JTextField();
		txtDijete2.setText(String.valueOf(pl.getDijete2()));
		springLayout.putConstraint(SpringLayout.EAST, lblKoefDrugoDijete, -6, SpringLayout.WEST, txtDijete2);
		springLayout.putConstraint(SpringLayout.SOUTH, txtDijete2, -16, SpringLayout.NORTH, txtDijete3);
		springLayout.putConstraint(SpringLayout.EAST, txtDijete2, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtDijete2, 0, SpringLayout.WEST, txtZdravstvo);
		txtDijete2.setColumns(10);
		getContentPane().add(txtDijete2);
		txtDijete2.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtDijete2.getText().equals(txt))
					if(dc.check(txtDijete2.getText()))
						pl.setDijete2(Double.parseDouble(txtDijete2.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtDijete2.getText();
			}
		  });
		
		txtDijete1 = new JTextField();
		txtDijete1.setText(String.valueOf(pl.getDijete1()));
		springLayout.putConstraint(SpringLayout.EAST, lblKoefPrvoDijete, -6, SpringLayout.WEST, txtDijete1);
		springLayout.putConstraint(SpringLayout.SOUTH, txtDijete1, -19, SpringLayout.NORTH, txtDijete2);
		springLayout.putConstraint(SpringLayout.EAST, txtDijete1, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtDijete1, 0, SpringLayout.WEST, txtZdravstvo);
		txtDijete1.setColumns(10);
		getContentPane().add(txtDijete1);
		txtDijete1.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtDijete1.getText().equals(txt))
					if(dc.check(txtDijete1.getText()))
						pl.setDijete1(Double.parseDouble(txtDijete1.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtDijete1.getText();
			}
		  });
		
		txtOsnovicaUzdrzavanje = new JTextField();
		txtOsnovicaUzdrzavanje.setText(String.valueOf(pl.getOsnovicaUzdrzavanje()));
		springLayout.putConstraint(SpringLayout.EAST, lblOsnovicaZaDijecu, -6, SpringLayout.WEST, txtOsnovicaUzdrzavanje);
		springLayout.putConstraint(SpringLayout.SOUTH, txtOsnovicaUzdrzavanje, -19, SpringLayout.NORTH, txtDijete1);
		springLayout.putConstraint(SpringLayout.EAST, txtOsnovicaUzdrzavanje, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtOsnovicaUzdrzavanje, 0, SpringLayout.WEST, txtZdravstvo);
		txtOsnovicaUzdrzavanje.setColumns(10);
		getContentPane().add(txtOsnovicaUzdrzavanje);
		txtOsnovicaUzdrzavanje.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtOsnovicaUzdrzavanje.getText().equals(txt))
					if(dc.check(txtOsnovicaUzdrzavanje.getText()))
						pl.setOsnovicaUzdrzavanje(Double.parseDouble(txtOsnovicaUzdrzavanje.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtOsnovicaUzdrzavanje.getText();
			}
		  });
		
		txtOdbitak = new JTextField();
		txtOdbitak.setText(String.valueOf(pl.getOdbitak()));
		springLayout.putConstraint(SpringLayout.EAST, lblOdbitak, -6, SpringLayout.WEST, txtOdbitak);
		springLayout.putConstraint(SpringLayout.SOUTH, txtOdbitak, -19, SpringLayout.NORTH, txtOsnovicaUzdrzavanje);
		springLayout.putConstraint(SpringLayout.EAST, txtOdbitak, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtOdbitak, 0, SpringLayout.WEST, txtZdravstvo);
		txtOdbitak.setColumns(10);
		getContentPane().add(txtOdbitak);
		txtOdbitak.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtOdbitak.getText().equals(txt))
					if(dc.check(txtOdbitak.getText()))
						pl.setOdbitak(Double.parseDouble(txtOdbitak.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtOdbitak.getText();
			}
		  });
		
		txtBod = new JTextField();
		txtBod.setText(String.valueOf(pl.getBod()));
		springLayout.putConstraint(SpringLayout.EAST, lblbod, -6, SpringLayout.WEST, txtBod);
		springLayout.putConstraint(SpringLayout.SOUTH, txtBod, -19, SpringLayout.NORTH, txtOdbitak);
		springLayout.putConstraint(SpringLayout.EAST, txtBod, -324, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtBod, 0, SpringLayout.WEST, txtZdravstvo);
		txtBod.setColumns(10);
		getContentPane().add(txtBod);
		txtBod.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtBod.getText().equals(txt))
					if(dc.check(txtBod.getText()))
						pl.setBod(Double.parseDouble(txtBod.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtBod.getText();
			}
		  });
		
		JLabel lblMio1 = new JLabel("Mio 1");
		springLayout.putConstraint(SpringLayout.NORTH, lblMio1, 0, SpringLayout.NORTH, lblbod);
		springLayout.putConstraint(SpringLayout.WEST, lblMio1, 50, SpringLayout.EAST, txtBod);
		getContentPane().add(lblMio1);
		
		txtMio1 = new JTextField();
		txtMio1.setText(String.valueOf(pl.getMio1()));
		springLayout.putConstraint(SpringLayout.EAST, txtMio1, -100, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblMio1, -50, SpringLayout.WEST, txtMio1);
		springLayout.putConstraint(SpringLayout.NORTH, txtMio1, 0, SpringLayout.NORTH, txtBod);
		springLayout.putConstraint(SpringLayout.WEST, txtMio1, 150, SpringLayout.EAST, txtBod);
		txtMio1.setColumns(10);
		getContentPane().add(txtMio1);
		txtMio1.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtMio1.getText().equals(txt))
					if(dc.check(txtMio1.getText()))
						pl.setMio1(Double.parseDouble(txtMio1.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtMio1.getText();
			}
		  });
		
		JLabel lblMio2 = new JLabel("Mio 2");
		springLayout.putConstraint(SpringLayout.NORTH, lblMio2, 0, SpringLayout.NORTH, txtOdbitak);
		springLayout.putConstraint(SpringLayout.WEST, lblMio2, 50, SpringLayout.EAST, txtOdbitak);
		getContentPane().add(lblMio2);
		
		txtMio2 = new JTextField();
		txtMio2.setText(String.valueOf(pl.getMio2()));
		springLayout.putConstraint(SpringLayout.NORTH, txtMio2, 0, SpringLayout.NORTH, txtOdbitak);
		springLayout.putConstraint(SpringLayout.WEST, txtMio2, 150, SpringLayout.EAST, txtOdbitak);
		springLayout.putConstraint(SpringLayout.EAST, txtMio2, -100, SpringLayout.EAST, getContentPane());
		txtMio2.setColumns(10);
		getContentPane().add(txtMio2);
		txtMio2.addFocusListener(new FocusListener() {
			String txt;
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtMio2.getText().equals(txt))
					if(dc.check(txtMio2.getText()))
						pl.setMio2(Double.parseDouble(txtMio2.getText()));			    
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt = txtMio2.getText();
			}
		  });
		
		JButton btnNewButton = new JButton("Spremi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pl.SpremiPostavke())
				{
					dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Greška kod unosa, provjerite koeficjente");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -98, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton);
	}
}
