package code;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

 

	/**
	 * Create the frame.
	 */
	public Interface() {
		super("Ecommerce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400,900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea Results = new JTextArea();
		JScrollPane scrollV = new JScrollPane(Results);
		scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollV, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8,2));
		contentPane.add(panel, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Operazione 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 250);
				tmp.setLayout(new GridLayout(1,3));
				
				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(5,1));
				panel1.add(new JLabel("idCliente"));
				panel1.add(new JLabel("nome"));
				panel1.add(new JLabel("cognome"));
				panel1.add(new JLabel("username"));
				panel1.add(new JLabel("password"));
				tmp.add(panel1);
				JTextField t1= new JTextField();
				JTextField t2= new JTextField();
				JTextField t3= new JTextField();
				JTextField t4= new JTextField();
				JTextField t5= new JTextField();
				
				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(5,1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Connections.query1(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),t4.getText(),t5.getText());
						Results.setText("Clinete Aggiunto!!");
						tmp.dispose();
					}
				});
				tmp.add(btn);
				
				}
		});
		
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Operazione 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 300);
				tmp.setLayout(new GridLayout(1,3));
				
				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(6,1));
				panel1.add(new JLabel("idProdotto"));
				panel1.add(new JLabel("nome"));
				panel1.add(new JLabel("descrizione"));
				panel1.add(new JLabel("prezzo"));
				panel1.add(new JLabel("peso"));
				panel1.add(new JLabel("categoria"));
				
				tmp.add(panel1);
				
				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();
				
				
				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(6,1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				panel.add(t6);
				
				tmp.add(panel);
				
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
						Connections.query2(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),Integer.parseInt(t4.getText()),Float.parseFloat(t5.getText()),Integer.parseInt(t6.getText()));
						Results.setText("prodotto aggiunto");
						tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
						       JPanel pane= new JPanel();
						       JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				 
				tmp.add(btn);
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Operazione 3");
		btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
				
				Results.setText("Visualizzare tutti i prodotti\n\n "+Connections.query3());
			
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Operazione 4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Trovare i prodotti più venduti\n\n"+Connections.query4());
			
			}
		});
		
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Operazione 5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Trovare i prodotti meno venduti\n\n"+Connections.query5());
			
			}
		});
		
		panel.add(btnNewButton_4);
		
		
		JButton btn4a= new JButton("Operazione 6");
		btn4a.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Trovare il prodotto più costoso\n\n"+Connections.query6());
			
			}
		});
		
		panel.add(btn4a);
		
		JButton btn4b= new JButton("Operazione 7");
		btn4b.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Trovare i clienti che hanno effettuato più di 1 ordine\n\n  "+Connections.query7());
			
			}
		});
		
		panel.add(btn4b);
		
		JButton btn4c= new JButton("Operazione 8");
		btn4c.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Elencare i prodotti in ordine di prezzo dal più basso al più alto\n\n  "+Connections.query8());
			
			}
		});
		
		panel.add(btn4c);
		
		JButton btn4d= new JButton("Operazione 9");
		btn4d.addActionListener(new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {
					JFrame tmp= new JFrame();
					tmp.setVisible(true);
					tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					tmp.setSize(500, 100);
					tmp.setLayout(new GridLayout(1, 3));
					
					JPanel panel1 = new JPanel();
					panel1.setVisible(true);
					panel1.setLayout(new BorderLayout());
					panel1.add(new JLabel("Inserisci idCliente"));
					tmp.add(panel1,BorderLayout.WEST);
					
					JTextField t1= new JTextField();
					
					JPanel panel = new JPanel();
					panel.setVisible(true);
					panel.setLayout(new GridLayout(3,1));
					panel.add(new JPanel());
					panel.add(t1,BorderLayout.CENTER);
					tmp.add(panel);
					JButton btn= new JButton("Invia Dati");
					btn.setVisible(true);
					btn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							try {
							Results.setText("Selezionare gli importi effettuati da un dato cliente\n\n"
									+Connections.query9(Integer.parseInt(t1.getText())));
							tmp.dispose();
							}
							catch(NumberFormatException e) {
								System.out.println(e);
							       JPanel pane= new JPanel();
							       JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);	
							}
						}
					});
					tmp.add(btn);
				}
			});		
		panel.add(btn4d);
		
		
		
		JButton btnNewButton_5 = new JButton("Operazione 10");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Trovare i prodotti con prezzo maggiore di 50 euro \n\n"+Connections.query10());
			
			}
		});
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Operazione 11");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText("Trovare i prodotti che non sono mai stati venduti\n\n"+Connections.query11());
			}
		});
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Operazione 12");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText("Trovare la data dell'ultimo ordine effettuato da ciascun cliente\n\n"+Connections.query12());
			}
		});
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Operazione 13");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText("Trovare le categorie con la maggior varietà di prodotti distinti\n\n"+Connections.query13());
			}
		});
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Operazione 14");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Selezionare tutti gli ordini pagati con Carta di credito\n\n"+Connections.query14());
				
			}
		});
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Operazione 15");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 100);
				tmp.setLayout(new GridLayout(1, 3));
				
				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new BorderLayout());
				panel1.add(new JLabel("Inserisci l'anno di interesse"));
				tmp.add(panel1,BorderLayout.WEST);
				
				JTextField t1= new JTextField();
				
				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3,1));
				panel.add(new JPanel());
				panel.add(t1,BorderLayout.CENTER);
				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
						Results.setText("Visualizzare tutti gli ordini eseguiti in un anno.\n\n"
								+Connections.query15(Integer.parseInt(t1.getText())));
						tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
						       JPanel pane= new JPanel();
						       JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);	
						}
					}
				});
				tmp.add(btn);
			}
		});	
		panel.add(btnNewButton_10);
		
		
		JButton btnNewButton_11 = new JButton("Operazione 16");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Results.setText("Seleziona i ritiri nei negozi e il cliente associato con il maggior numero totale di ritiri\n\n"+Connections.query16());
				
			}
		});
		panel.add(btnNewButton_11);
		
		
		
		
		
		
		JButton btnNewButton_14 = new JButton("CONNESSIONE");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Connections.connessione());
			}
		});
		
		JButton btnNewButton_15 = new JButton("ESCI");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Connections.uscita());
				
			}
		});
		JPanel bt= new JPanel();
		bt.setVisible(true);
		bt.setLayout(new GridLayout(1,4));
		
		bt.add(new JPanel());
		bt.add(btnNewButton_14);
		bt.add(btnNewButton_15);
	
		bt.add(new JPanel());
		
		contentPane.add(bt, BorderLayout.NORTH);
		setVisible(true);
	}

}
