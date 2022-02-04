
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.MenuShortcut;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;

public class Interface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JTextArea textArea_Editor = new JTextArea();
	JTextArea textArea_Mensagens = new JTextArea();
	JTextArea textArea_Status = new JTextArea();
	JFileChooser arquivo = new JFileChooser();
	TextListener tln;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
					frame.setMinimumSize(new Dimension(900, 600));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		contentPane = new JPanel(); // new GridLayout(0, 5));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane DebugerScrollPane = new JScrollPane();
		DebugerScrollPane.setBounds(165, 435, 700, 90);
		DebugerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		DebugerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(DebugerScrollPane);

		JTextPane DebuguerTextPane = new JTextPane();
		DebuguerTextPane.setEditable(false);
		DebugerScrollPane.setViewportView(DebuguerTextPane);

		JScrollPane CodigoScrollPane = new JScrollPane();
		CodigoScrollPane.setBounds(165, 35, 700, 380);
		CodigoScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		CodigoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(CodigoScrollPane);

		JTextArea textAreaCodigo = new JTextArea();
		textAreaCodigo.setBorder(new NumberedBorder());
		CodigoScrollPane.setViewportView(textAreaCodigo);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				DebugerScrollPane.setPreferredSize(new Dimension(300, 300));
				CodigoScrollPane.setPreferredSize(new Dimension(300, 300));

				DebuguerTextPane.setSize(DebugerScrollPane.getPreferredSize());
				textAreaCodigo.setSize(CodigoScrollPane.getPreferredSize());
			}
		});

		JLabel lblNewLabel = new JLabel("pasta\\nome do arquivo");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 535, 900, 25);
		contentPane.add(lblNewLabel);

		// Criação de novo arquivo
		JButton btnNewBotton = new JButton("Novo \r\n(ctrl-n)");
		btnNewBotton.setMnemonic(KeyEvent.VK_N);
		btnNewBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCodigo.setText("");
				DebuguerTextPane.setText("");
				lblNewLabel.setText("pasta\\nome do arquivo");
			}
		});
		btnNewBotton.setVerticalTextPosition(SwingConstants.CENTER);
		btnNewBotton.setHorizontalTextPosition(SwingConstants.RIGHT);

		// Gera novo arquivo
		btnNewBotton.setIcon(new ImageIcon(Interface.class.getResource("/Novo1.png")));
		btnNewBotton.setForeground(new Color(0, 0, 205));
		btnNewBotton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewBotton.setBounds(5, 35, 155, 60);
		contentPane.add(btnNewBotton);

		// Abre novo arquivo
		JButton btnAbirctlo = new JButton("Abrir (ctrl-o)");
		btnAbirctlo.setMnemonic(KeyEvent.VK_O);
		btnAbirctlo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de texto", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						textAreaCodigo.setText("");
						File arquivo = chooser.getSelectedFile();
						BufferedReader in = new BufferedReader(new FileReader(arquivo));
						String linha = in.readLine();
						textAreaCodigo.setText(linha);
						linha = in.readLine();
						while (linha != null) {
							textAreaCodigo.setText(textAreaCodigo.getText() + "\n" + linha);
							linha = in.readLine();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					lblNewLabel.setText(chooser.getSelectedFile().getPath());
				}
			}
		});

		btnAbirctlo.setIcon(new ImageIcon(Interface.class.getResource("/new2.png")));
		btnAbirctlo.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAbirctlo.setForeground(new Color(0, 0, 205));
		btnAbirctlo.setBounds(5, 95, 155, 60);
		contentPane.add(btnAbirctlo);

		// Salva novo arquivo
		JButton btnSalvarctls = new JButton("Salvar (ctrl-s)");
		btnSalvarctls.setMnemonic(KeyEvent.VK_S);
		btnSalvarctls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblNewLabel.getText() == "pasta\\nome do arquivo") {
					try {
						JFileChooser chooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de texto", "txt");
						chooser.setFileFilter(filter);
						int returnVal = chooser.showOpenDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							FileWriter arq = new FileWriter(chooser.getSelectedFile());
							PrintWriter gravarArq = new PrintWriter(arq);
							gravarArq.print(textAreaCodigo.getText());
							arq.close();
							DebuguerTextPane.setText("Arquivo salvo com sucesso");
							lblNewLabel.setText(chooser.getSelectedFile().getPath());
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						FileWriter arq = new FileWriter(lblNewLabel.getText());
						PrintWriter gravarArq = new PrintWriter(arq);
						gravarArq.print(textAreaCodigo.getText());
						arq.close();
						DebuguerTextPane.setText("Arquivo salvo com sucesso");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnSalvarctls.setIcon(new ImageIcon(Interface.class.getResource("/Save1.png")));
		btnSalvarctls.setForeground(new Color(0, 0, 205));
		btnSalvarctls.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSalvarctls.setBounds(5, 155, 155, 60);
		contentPane.add(btnSalvarctls);

		JButton btnCopiarctlc = new JButton("Copiar (ctrl-c)");
		btnCopiarctlc.setMnemonic(KeyEvent.VK_COPY);
		btnCopiarctlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCodigo.copy();
			}
		});

		btnCopiarctlc.setIcon(new ImageIcon(Interface.class.getResource("/Copy1.png")));
		btnCopiarctlc.setForeground(new Color(0, 0, 205));
		btnCopiarctlc.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCopiarctlc.setBounds(5, 215, 155, 60);
		contentPane.add(btnCopiarctlc);

		// Cola texto
		JButton btnColarctlc = new JButton("Colar (ctrl-v)");
		btnColarctlc.setMnemonic(KeyEvent.VK_PASTE);
		btnColarctlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCodigo.paste();
			}
		});
		btnColarctlc.setIcon(new ImageIcon(Interface.class.getResource("/Paste1.png")));
		btnColarctlc.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnColarctlc.setForeground(new Color(0, 0, 205));
		btnColarctlc.setBounds(5, 275, 155, 60);
		contentPane.add(btnColarctlc);

		// Recorta texto
		JButton btnRecortarctlx = new JButton("Recortar \r\n(ctrl-x)");
		btnRecortarctlx.setMnemonic(KeyEvent.VK_CUT);
		btnRecortarctlx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCodigo.cut();
			}
		});
		btnRecortarctlx.setIcon(new ImageIcon(Interface.class.getResource("/Cortar1.png")));
		btnRecortarctlx.setForeground(new Color(0, 0, 205));
		btnRecortarctlx.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRecortarctlx.setBounds(5, 335, 155, 60);
		contentPane.add(btnRecortarctlx);

		JButton btnNewButton_5_1 = new JButton("Compilar (F7)");
		btnNewButton_5_1.setMnemonic(KeyEvent.VK_F7);
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ANTIGO, VAI QUE

//				Lexico lexico = new Lexico();
//				lexico.setInput(textAreaCodigo.getText());
//				try {
//					Token t = null;
//					DebuguerTextPane.setText("Linha\tClasse\t\tLexema");
//					while ((t = lexico.nextToken()) != null) { 	// micro-metodo pra converter linha
//						int linha = 1;
//						int i = t.getPosition();
//						for (int j = 0; j != i; j++)
//							try {
//								if (textAreaCodigo.getText(j, 1).contains("\n")) {
//									linha++;
//								}
//							} catch (BadLocationException e1) {
//								e1.printStackTrace();
//							}									//fim do micro-metodo
//						if (t.porExtenso(t.getId())== null) {
//							throw new LexicalError("palavra reservada inválida", t.getPosition());
//						}
//						DebuguerTextPane.setText(DebuguerTextPane.getText()
//								+ ("\n" + linha + " \t" + t.porExtenso(t.getId()) + "\t" + t.getLexeme()));
//					}
//				} catch (LexicalError le) {
//					int linha = 1;
//					int i = 0;			//"metodo" pra puxar a palavra toda ao invés de só o char
//					String str="";
//					try {
//						str = textAreaCodigo.getText(le.getPosition(), (textAreaCodigo.getText().length()-le.getPosition()));
//					} catch (BadLocationException e2) {
//						e2.printStackTrace();
//					}
//					String[] palavras = str.split(" |\n");
//					i= le.getPosition();
//					for (int j = 0; j != i; j++)
//						try {
//							if (textAreaCodigo.getText(j, 1).contains("\n")) {
//								linha++;
//							}
//						} catch (BadLocationException e1) {
//							e1.printStackTrace();
//						}
//					DebuguerTextPane.setText("Erro na linha " + linha + " - " + palavras[0] + " " + le.getMessage());
//					return;
//				}
//				DebuguerTextPane.setText(DebuguerTextPane.getText() + ("\n\n Programa compilado com sucesso"));

				Lexico lexico = new Lexico();
				Sintatico sintatico = new Sintatico();
				Semantico semantico = new Semantico();

				lexico.setInput(textAreaCodigo.getText());

				try {
					sintatico.parse(lexico, semantico); // tradução dirigida pela sintaxe
					DebuguerTextPane.setText("Programa compilado com sucesso");
					//salvar na compilação
					try {
						FileWriter arq = new FileWriter("C:\\temp\\teste.il");
						PrintWriter gravarArq = new PrintWriter(arq);
						gravarArq.print(semantico.getCodigo());
						arq.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				// mensagem: programa compilado com sucesso
				catch (LexicalError le) {
					int linha = 1;
					int i = 0; 
					// "metodo" pra puxar a palavra toda ao invés de só o char
					String str = "";
					try {
						str = textAreaCodigo.getText(le.getPosition(),
								(textAreaCodigo.getText().length() - le.getPosition()));
					} catch (BadLocationException e2) {
						e2.printStackTrace();
					}
					String[] palavras = str.split(" |\n");
					i = le.getPosition();
					for (int j = 0; j != i; j++)
						try {
							if (textAreaCodigo.getText(j, 1).contains("\n")) {
								linha++;
							}
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					if (le.getMessage() == "Constante string inválida ou não finalizada") {
						DebuguerTextPane.setText("Erro na linha " + linha + " - " + le.getMessage());
					} else {
						DebuguerTextPane
								.setText("Erro na linha " + linha + " - " + palavras[0] + " " + le.getMessage());
					}
					// if pra corrigir o errinho do constante string invalida
					return;
				} catch (SyntaticError sye) {
					int linha = 1;
					int i = sye.getPosition();
					for (int j = 0; j != i; j++)
						try {
							if (textAreaCodigo.getText(j, 1).contains("\n")) {
								linha++;
							}
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					if(sintatico.getCurrentToken().getId()==1) {
						DebuguerTextPane.setText("Erro na linha " + linha + " - encontrado EOF " + sye.getMessage());
						}else {
					DebuguerTextPane.setText("Erro na linha " + linha + " - encontrado " + 
							sintatico.getCurrentToken().getLexeme() + " " + sye.getMessage());
						}
				} catch (SemanticError se) {
					int linha = 1;
					int i = se.getPosition();
					for (int j = 0; j != i; j++)
						try {
							if (textAreaCodigo.getText(j, 1).contains("\n")) {
								linha++;
							}
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					DebuguerTextPane.setText("Erro na linha " + linha + " - " + se.getMessage());
				}
			}
		});

		btnNewButton_5_1.setIcon(new ImageIcon(Interface.class.getResource("/Compiler (1).png")));
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5_1.setForeground(new Color(0, 0, 205));
		btnNewButton_5_1.setBounds(5, 395, 155, 60);
		contentPane.add(btnNewButton_5_1);

		// Apresenta a equipe
		JButton btnNewButton_5_1_1 = new JButton("Equipe (F1)");
		btnNewButton_5_1_1.setMnemonic(KeyEvent.VK_F1);
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DebuguerTextPane.setText("Matheus Petters Bevilaqua, \nMarcos Mattedi");
			}
		});

		// Compilador
		btnNewButton_5_1_1.setIcon(new ImageIcon(Interface.class.getResource("/Equipe2.png")));
		btnNewButton_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_5_1_1.setBounds(5, 455, 155, 60);
		contentPane.add(btnNewButton_5_1_1);

		JLabel lblNewLabel_1 = new JLabel("COMPILADOR 21");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setBounds(385, 0, 195, 34);
		contentPane.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(165, 435, 700, -20);
		contentPane.add(separator);

		// Métodos espeíficos do ctrl
		textAreaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if ((evt.getKeyCode() == KeyEvent.VK_N) && (evt.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK)) {
					// novo
					textAreaCodigo.setText("");
					DebuguerTextPane.setText("");
					lblNewLabel.setText("pasta\\nome do arquivo");
				}
				if ((evt.getKeyCode() == KeyEvent.VK_S) && (evt.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK)) {
					// salvar
					if (lblNewLabel.getText() == "pasta\\nome do arquivo") {
						try {
							JFileChooser chooser = new JFileChooser();
							FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de texto", "txt");
							chooser.setFileFilter(filter);
							int returnVal = chooser.showOpenDialog(null);
							if (returnVal == JFileChooser.APPROVE_OPTION) {
								FileWriter arq = new FileWriter(chooser.getSelectedFile());
								PrintWriter gravarArq = new PrintWriter(arq);
								gravarArq.print(textAreaCodigo.getText());
								arq.close();
								DebuguerTextPane.setText("Arquivo salvo com sucesso");
								lblNewLabel.setText(chooser.getSelectedFile().getPath());
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							FileWriter arq = new FileWriter(lblNewLabel.getText());
							PrintWriter gravarArq = new PrintWriter(arq);
							gravarArq.print(textAreaCodigo.getText());
							arq.close();
							DebuguerTextPane.setText("Arquivo salvo com sucesso");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				}
				if ((evt.getKeyCode() == KeyEvent.VK_F1)) {
					// equipe
					DebuguerTextPane.setText("Matheus Petters Bevilaqua, \nMarcos Mattedi");
				}
				if ((evt.getKeyCode() == KeyEvent.VK_F7)) {

					Lexico lexico = new Lexico();
					Sintatico sintatico = new Sintatico();
					Semantico semantico = new Semantico();

					lexico.setInput(textAreaCodigo.getText());

					try {
						sintatico.parse(lexico, semantico); // tradução dirigida pela sintaxe
						DebuguerTextPane.setText("Programa compilado com sucesso");
						//salvar na compilação
							try {
								FileWriter arq = new FileWriter("C:\\temp\\teste.il");
								PrintWriter gravarArq = new PrintWriter(arq);
								gravarArq.print(semantico.getCodigo());
								arq.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
					}
					// mensagem: programa compilado com sucesso
					catch (LexicalError le) {
						int linha = 1;
						int i = 0; 
						// "metodo" pra puxar a palavra toda ao invés de só o char
						String str = "";
						try {
							str = textAreaCodigo.getText(le.getPosition(),
									(textAreaCodigo.getText().length() - le.getPosition()));
						} catch (BadLocationException e2) {
							e2.printStackTrace();
						}
						String[] palavras = str.split(" |\n");
						i = le.getPosition();
						for (int j = 0; j != i; j++)
							try {
								if (textAreaCodigo.getText(j, 1).contains("\n")) {
									linha++;
								}
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						if (le.getMessage() == "Constante string inválida ou não finalizada") {
							DebuguerTextPane.setText("Erro na linha " + linha + " - " + le.getMessage());
						} else {
							DebuguerTextPane
									.setText("Erro na linha " + linha + " - " + palavras[0] + " " + le.getMessage());
						}
						// if pra corrigir o errinho do constante string invalida
						return;
					} catch (SyntaticError sye) {
						int linha = 1;
						int i = sye.getPosition();
						for (int j = 0; j != i; j++)
							try {
								if (textAreaCodigo.getText(j, 1).contains("\n")) {
									linha++;
								}
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						if(sintatico.getCurrentToken().getId()==1) {
							DebuguerTextPane.setText("Erro na linha " + linha + " - encontrado EOF " + sye.getMessage());
							}else {
						DebuguerTextPane.setText("Erro na linha " + linha + " - encontrado " + 
								sintatico.getCurrentToken().getLexeme() + " " + sye.getMessage());
							}
					} catch (SemanticError se) {
						// Trata erros semânticos
					}
				}
				if ((evt.getKeyCode() == KeyEvent.VK_O) && (evt.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK)) {
					// abrir
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de texto", "txt");
					chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(null);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						try {
							textAreaCodigo.setText("");
							File arquivo = chooser.getSelectedFile();
							BufferedReader in = new BufferedReader(new FileReader(arquivo));
							String linha = in.readLine();
							textAreaCodigo.setText(linha);
							linha = in.readLine();
							while (linha != null) {
								textAreaCodigo.setText(textAreaCodigo.getText() + "\n" + linha);
								linha = in.readLine();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						lblNewLabel.setText(chooser.getSelectedFile().getPath());
					}
				}
			}
		});

		// aqui

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
