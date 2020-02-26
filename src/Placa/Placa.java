package vsite.placa.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;

public class Placa {

	private JFrame frmObraunPlae;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Placa window = new Placa();
					window.frmObraunPlae.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Placa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmObraunPlae = new JFrame();
		frmObraunPlae.setTitle("Obra\u010Dun pla\u0107e");
		frmObraunPlae.setBounds(100, 100, 544, 433);
		frmObraunPlae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmObraunPlae.getContentPane().setLayout(null);
		
		JButton btnZaposlenici = new JButton("Zaposlenici");
		btnZaposlenici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Zaposlenici dialog = new Zaposlenici();
				dialog.setVisible(true);
			}
		});
		btnZaposlenici.setBounds(10, 36, 108, 23);
		frmObraunPlae.getContentPane().add(btnZaposlenici);
		
		JButton btnNewButton = new JButton("Radna mjesta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RadnaMj rm = new RadnaMj();
				rm.setVisible(true);
			}
		});
		btnNewButton.setBounds(391, 70, 127, 23);
		frmObraunPlae.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Postavke koef.");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostavkePlaca pp = new PostavkePlaca();
				pp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(391, 36, 127, 23);
		frmObraunPlae.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sistematizacija");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistematizacija s=new Sistematizacija();
				s.setVisible(true);
			}
		});
		btnNewButton_2.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_2.setBounds(10, 70, 108, 23);
		frmObraunPlae.getContentPane().add(btnNewButton_2);
		
		JButton btnIzracun = new JButton("Izra\u010Dun");
		btnIzracun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Izracun s=new Izracun();
				s.setVisible(true);
			}
		});
		btnIzracun.setBounds(10, 138, 108, 23);
		frmObraunPlae.getContentPane().add(btnIzracun);
		
		JButton btnNewButton_3 = new JButton("Neoporezivo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Neoporezivo n = new Neoporezivo();
				n.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 104, 108, 23);
		frmObraunPlae.getContentPane().add(btnNewButton_3);
		
		JLabel lblObradaZaposlenikaI = new JLabel("Obrada zaposlenika i pla\u0107e");
		lblObradaZaposlenikaI.setBounds(10, 11, 157, 14);
		frmObraunPlae.getContentPane().add(lblObradaZaposlenikaI);
		
		JLabel lblKonifiguracija = new JLabel("Konifiguracija");
		lblKonifiguracija.setBounds(391, 11, 127, 14);
		frmObraunPlae.getContentPane().add(lblKonifiguracija);
	}
}
