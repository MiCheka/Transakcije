package gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class frmTransakcije extends JFrame {

	private JPanel contentPane;
	private JPanel pnlUplataIsplata;
	private JPanel pnlStanje;
	private JPanel pnlRezultat;
	private JRadioButton rdbtnUplata;
	private JRadioButton rdbtnIsplata;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblSuma;
	private JTextField txtSuma;
	private JLabel lblDan;
	private JTextField txtDan;
	private JLabel lblMesec;
	private JTextField txtMesec;
	private JLabel lblGodina;
	private JTextField txtGodina;
	private JLabel lblStanjeNaRacunu;
	private JTextField txtStanjeNaRacunu;
	private JButton btnIzvrsiTransakciju;
	private JLabel lblPoruka;
	private JButton btnPrikaziTransakcije;
	private JPanel pnlUplate;
	private JPanel pnlIsplate;

	private ArrayList<Datum> datum = new ArrayList<Datum>();
	private ArrayList<Transakcija> transakcijaUplata = new ArrayList<Transakcija>();
	private ArrayList<Transakcija> transakcijaIsplata = new ArrayList<Transakcija>();
	private DefaultListModel<JCheckBox> dlmUplate;
	private DefaultListModel<JCheckBox> dlmIsplate;

	private boolean datumValidation;
	protected Transakcija transakcijaU;
	protected Transakcija transakcijaI;
	private JScrollPane scrlUplate;
	private JScrollPane scrlIsplate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTransakcije frame = new frmTransakcije();
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
	public frmTransakcije() {
		setTitle("Uplate/Isplate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		pnlUplataIsplata = new JPanel();
		pnlUplataIsplata
				.setBorder(new TitledBorder(null, "Uplata/Isplata", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(pnlUplataIsplata);

		rdbtnUplata = new JRadioButton("Uplata");
		rdbtnUplata.setSelected(true);
		buttonGroup.add(rdbtnUplata);

		rdbtnIsplata = new JRadioButton("Isplata");
		buttonGroup.add(rdbtnIsplata);

		lblSuma = new JLabel("Suma:");

		txtSuma = new JTextField();
		txtSuma.setColumns(10);

		lblDan = new JLabel("Dan:");

		txtDan = new JTextField();
		txtDan.setColumns(10);

		lblMesec = new JLabel("Mesec:");

		txtMesec = new JTextField();
		txtMesec.setColumns(10);

		lblGodina = new JLabel("Godina:");

		txtGodina = new JTextField();
		txtGodina.setColumns(10);
		GroupLayout gl_pnlUplataIsplata = new GroupLayout(pnlUplataIsplata);
		gl_pnlUplataIsplata.setHorizontalGroup(gl_pnlUplataIsplata.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUplataIsplata.createSequentialGroup()
						.addGroup(gl_pnlUplataIsplata.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlUplataIsplata.createSequentialGroup().addGap(101)
										.addComponent(rdbtnUplata).addGap(18).addComponent(rdbtnIsplata))
								.addGroup(gl_pnlUplataIsplata.createSequentialGroup().addGap(95).addComponent(lblSuma)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtSuma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlUplataIsplata.createSequentialGroup().addGap(37).addComponent(lblDan)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtDan, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblMesec).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtMesec, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblGodina).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtGodina, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(131, Short.MAX_VALUE)));
		gl_pnlUplataIsplata
				.setVerticalGroup(gl_pnlUplataIsplata.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlUplataIsplata.createSequentialGroup().addGap(21)
								.addGroup(gl_pnlUplataIsplata.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnIsplata).addComponent(rdbtnUplata))
								.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
								.addGroup(gl_pnlUplataIsplata.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtSuma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSuma))
								.addGap(29)
								.addGroup(
										gl_pnlUplataIsplata.createParallelGroup(Alignment.BASELINE).addComponent(lblDan)
												.addComponent(txtDan, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMesec)
												.addComponent(txtMesec, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblGodina).addComponent(txtGodina,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(47, Short.MAX_VALUE)));
		pnlUplataIsplata.setLayout(gl_pnlUplataIsplata);

		pnlStanje = new JPanel();
		contentPane.add(pnlStanje);

		lblStanjeNaRacunu = new JLabel("Stanje na racunu:");

		txtStanjeNaRacunu = new JTextField();
		txtStanjeNaRacunu.setEditable(false);
		txtStanjeNaRacunu.setColumns(10);
		txtStanjeNaRacunu.setText(Double.valueOf(Transakcija.tekuceStanje()).toString());

		btnIzvrsiTransakciju = new JButton("Izvrsi transakciju");
		btnIzvrsiTransakciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int dan = Integer.parseInt(txtDan.getText());
					int mesec = Integer.parseInt(txtMesec.getText());
					int godina = Integer.parseInt(txtGodina.getText());

					if (godina < 2015
							|| ((Integer.toString(godina).length() < 4 || Integer.toString(godina).length() > 4))) {
						txtGodina.setText(null);
						JOptionPane.showMessageDialog(null, "godina > 2015", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					if (mesec < 1 || mesec > 12) {
						txtMesec.setText(null);
					}
					if (dan < 1 || dan > 31) {
						txtDan.setText(null);
						lblPoruka.setText("");
					}
					if (mesec == 2) {
						if (godina % 4 == 0) {
							if (dan > 29) {
								txtDan.setText(null);
								lblPoruka.setText("mesec ima 29 dana");
							}
						} else if (godina % 4 != 0) {
							if (dan > 28) {
								txtDan.setText(null);
								lblPoruka.setText("mesec ima 28 dana");
							}
						}
					}

					if ((mesec == 4 || mesec == 6 || mesec == 9 || mesec == 11) && dan >= 31) {
						txtDan.setText(null);
						lblPoruka.setText("mesec ima 30 dana");
					}
//				} catch (NumberFormatException e) {
//					lblPoruka.setText("greska prilikom popunjavanja");
//				}

//				if (!datumValidation) {
//					JOptionPane.showMessageDialog(null, "pogresan datum", "Greska", JOptionPane.ERROR_MESSAGE);
//				}

//				try {
					double iznos = Integer.parseInt(txtSuma.getText());

					if (rdbtnUplata.isSelected()) {
						transakcijaU = new Transakcija(iznos, dan, mesec, godina, Transakcija.vrstaTranskacije(true));
					} else {
						transakcijaI = new Transakcija(iznos, dan, mesec, godina, Transakcija.vrstaTranskacije(false));
					}
					if (!transakcijaU.izvrsiTransakciju()) {
						lblPoruka.setText("nema dovoljno sredstava na racunu");
					} else {
						transakcijaUplata.add(transakcijaU);
						transakcijaIsplata.add(transakcijaI);
						lblPoruka.setText("uspesno");
					}
					txtStanjeNaRacunu.setText(String.valueOf(Transakcija.tekuceStanje()));

				} catch (NumberFormatException e) {
					lblPoruka.setText("greska prilikom popunjavanja");
				}
			}
		});

		lblPoruka = new JLabel("");
		lblPoruka.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoruka.setForeground(Color.red);

		btnPrikaziTransakcije = new JButton("Prikazi transakcije");
		btnPrikaziTransakcije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Transakcija tr : transakcijaUplata) {
					JCheckBox cxBox = new JCheckBox(tr.toString());
					pnlUplate.add(cxBox);
					pnlUplate.validate();
				}
				/*for (Transakcija tr1 : transakcijaIsplata) {
					JCheckBox cxBox1 = new JCheckBox(tr1.toString());
					pnlIsplate.add(cxBox1);
					pnlIsplate.validate();
				}*/
			}
		});

		GroupLayout gl_pnlStanje = new GroupLayout(pnlStanje);
		gl_pnlStanje.setHorizontalGroup(gl_pnlStanje.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlStanje
				.createSequentialGroup()
				.addGroup(gl_pnlStanje.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlStanje.createSequentialGroup().addGap(87).addComponent(lblStanjeNaRacunu)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtStanjeNaRacunu,
										GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlStanje.createSequentialGroup().addGap(114)
								.addGroup(gl_pnlStanje.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnPrikaziTransakcije).addComponent(btnIzvrsiTransakciju)))
						.addGroup(gl_pnlStanje.createSequentialGroup().addContainerGap().addComponent(lblPoruka,
								GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_pnlStanje.setVerticalGroup(gl_pnlStanje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlStanje.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlStanje.createParallelGroup(Alignment.BASELINE).addComponent(lblStanjeNaRacunu)
								.addComponent(txtStanjeNaRacunu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnIzvrsiTransakciju).addGap(18).addComponent(lblPoruka).addGap(18)
						.addComponent(btnPrikaziTransakcije).addContainerGap(38, Short.MAX_VALUE)));
		pnlStanje.setLayout(gl_pnlStanje);

		pnlRezultat = new JPanel();
		contentPane.add(pnlRezultat);
		pnlRezultat.setLayout(new GridLayout(0, 2, 0, 0));

		scrlUplate = new JScrollPane();
		pnlRezultat.add(scrlUplate);

		pnlUplate = new JPanel();
		scrlUplate.setViewportView(pnlUplate);
		pnlUplate.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Uplate", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlUplate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		scrlIsplate = new JScrollPane();
		pnlRezultat.add(scrlIsplate);

		pnlIsplate = new JPanel();
		scrlIsplate.setViewportView(pnlIsplate);
		pnlIsplate.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Isplate", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlIsplate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
