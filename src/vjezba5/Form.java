import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Form {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private static final Logger log = (Logger) LoggerFactory.getLogger(Form.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 5, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea, 5, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textArea);
		
		JScrollPane scrp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		springLayout.putConstraint(SpringLayout.NORTH, scrp, 5, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrp, 5, SpringLayout.WEST, frame.getContentPane());
		
		frame.getContentPane().add(scrp);
		
		connect();
		
		JButton btnNewButton = new JButton("Po\u0161alji");
		springLayout.putConstraint(SpringLayout.EAST, scrp, -5, SpringLayout.WEST, btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();  
				textArea.append(dtf.format(now) + ">  " + textField.getText() + "\n");
				textField.setText(null);*/
				send();
			}
		});
		
		springLayout.putConstraint(SpringLayout.EAST, textArea, -5, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -5, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -5, SpringLayout.EAST, frame.getContentPane());
		btnNewButton.setPreferredSize(new Dimension(100, 25));
		btnNewButton.setMaximumSize(new Dimension(150, 25));
		btnNewButton.setMinimumSize(new Dimension(100, 25));
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, scrp, -5, SpringLayout.NORTH, textField);
		textField.setBorder(null);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, textField, -30, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -5, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField, -5, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -5, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnKonfiguracija = new JButton("Konfiguracija");
		btnKonfiguracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Postavke dialog = new Postavke();
				dialog.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnKonfiguracija, 5, SpringLayout.EAST, textArea);
		btnKonfiguracija.setPreferredSize(new Dimension(100, 25));
		btnKonfiguracija.setMinimumSize(new Dimension(100, 25));
		springLayout.putConstraint(SpringLayout.SOUTH, btnKonfiguracija, 0, SpringLayout.SOUTH, textArea);
		frame.getContentPane().add(btnKonfiguracija);
	}
	private Socket soc;
	private BufferedReader br;
	private PrintWriter pw;
	
	private void connect()
	{
		try 
		{
			soc = new Socket(UserConfig.getHost(), UserConfig.getPort());
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			pw = new PrintWriter(soc.getOutputStream());
			String response;
			try 
			{
				response = br.readLine();
				if (textArea.getText().length()>0)
						textArea.append("\n");
				textArea.append(response);
				textArea.setText(null);
			} catch (IOException e) {
				log.error("Greška kod čitanja inicijalnog odgovora", e);
				JOptionPane.showMessageDialog(textField, "Greška kod čitanja inicijalnog odgovora", "Greška!", JOptionPane.ERROR_MESSAGE);
			}
		} catch (UnknownHostException e) {
			log.error("Nepoznati host", e);
			frame.dispose();
		} catch (IOException e) {
			log.error("IO iznimka", e);
			frame.dispose();
		}
	}
	
	private void send(){
		pw.println(textField.getText());
		if (pw.checkError())
		{
			JOptionPane.showMessageDialog(textField, "Greška kod slanja poruke",
					"Greška!", JOptionPane.ERROR_MESSAGE);
		}
		String response;
		try {
				response = br.readLine();
				if (textArea.getText().length()>0)
					textArea.append("\n");
				textArea.append(response);
				textArea.setText(null);
		} catch (IOException e) {
		log.error("Greška kod čitanja", e);
		JOptionPane.showMessageDialog(textField, "Greška kod čitanja odgovora",
		"Greška!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
