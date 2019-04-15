package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DTextInicial extends JFrame {


	private JPanel contentPane;
	private JTextPane TextPane;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DTextInicial frame = new DTextInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DTextInicial() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TextFunctions txter = new TextFunctions();
				 
				JFileChooser filechooser = new JFileChooser();
				filechooser.setDialogTitle("save");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("texto","txt");
				filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				filechooser.setFileFilter(filter);
				int retorno = filechooser.showSaveDialog(btnSave);
				
			
				if(retorno == JFileChooser.APPROVE_OPTION) {
					
					
					try {
						
						txter.textCreator(TextPane.getText(),filechooser.getSelectedFile().getAbsolutePath());
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				
				
			}
		});
		btnSave.setBounds(10, 646, 89, 23);
		contentPane.add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 875, 635);
		contentPane.add(scrollPane);
		
		TextPane = new JTextPane();
		scrollPane.setViewportView(TextPane);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TextFunctions txter2 = new TextFunctions();

				JFileChooser filechooser2 = new JFileChooser();
				filechooser2.setDialogTitle("open");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("texto","txt");
				filechooser2.setCurrentDirectory(new File(System.getProperty("user.home")));
				filechooser2.setFileFilter(filter);
				int retorno2 = filechooser2.showOpenDialog(null);
				
				if(retorno2 == JFileChooser.APPROVE_OPTION)
				{
					txter2.ReadFile(TextPane,filechooser2.getSelectedFile().getAbsolutePath().toString());
					
					
				}
				
				
			}
		});
		btnOpen.setBounds(109, 646, 89, 23);
		contentPane.add(btnOpen);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextPane.setText("");
				
			}
		});
		btnNew.setBounds(208, 646, 89, 23);
		contentPane.add(btnNew);
	}
}
