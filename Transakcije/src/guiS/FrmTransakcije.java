package guiS;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import guiS.Transakcija;
import guiS.TransactionService;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;

public class FrmTransakcije extends JFrame {

	private JPanel contentPane;
	private JTextField txtSuma;
	private JTextField txtDan;
	private JTextField txtMesec;
	private JTextField txtGodina;
	private JTextField txtStanje;
	private ButtonGroup bg;
	private JPanel pnlUplataIsplata;
	private JRadioButton rdbtnUplata;
	private JLabel lblSuma;
	private JLabel lblDan;
	private JLabel lblMesec;
	private JLabel lblGodina;
	private JPanel pnlCenter;
	private JLabel lblStanjeNaRacunu;
	private JButton btnIzvrsiTransakciju;
	private JLabel lblPoruka;
	private JButton btnPrikaziTransakcije;
	private JRadioButton rdbtnIsplata;
	private JScrollPane scrlIsplate;
	private JScrollPane scrlUplate;

	private Transakcija t;
	private TransactionService ts;
	private ArrayList<Transakcija> listaUplata;
	private ArrayList<Transakcija> listaIsplata;
	public static double stanjeRacuna;
	private DefaultListModel<JCheckBox> dlmUplate;
	private DefaultListModel<JCheckBox> dlmIsplate;
	private JPanel pnlUplate;
	private JPanel pnlIsplate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTransakcije frame = new FrmTransakcije();
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
	public FrmTransakcije() {
		setTitle("Uplata/Isplata");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ts = new TransactionService();
		listaUplata = new ArrayList<Transakcija>();
		listaIsplata = new ArrayList<Transakcija>();

		pnlUplataIsplata = new JPanel();
		pnlUplataIsplata.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Uplata/Isplata",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		pnlUplataIsplata.setBounds(10, 11, 357, 153);
		contentPane.add(pnlUplataIsplata);
		pnlUplataIsplata.setLayout(null);

		rdbtnUplata = new JRadioButton("Uplata");
		rdbtnUplata.setSelected(true);
		rdbtnUplata.setBounds(65, 25, 109, 23);
		pnlUplataIsplata.add(rdbtnUplata);

		rdbtnIsplata = new JRadioButton("Isplata");
		rdbtnIsplata.setBounds(176, 25, 109, 23);
		pnlUplataIsplata.add(rdbtnIsplata);

		bg = new ButtonGroup();
		bg.add(rdbtnIsplata);
		bg.add(rdbtnUplata);

		lblSuma = new JLabel("Suma:");
		lblSuma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuma.setBounds(65, 71, 46, 14);
		pnlUplataIsplata.add(lblSuma);

		txtSuma = new JTextField();
		txtSuma.setBounds(121, 68, 141, 20);
		pnlUplataIsplata.add(txtSuma);
		txtSuma.setColumns(10);

		lblDan = new JLabel("Dan:");
		lblDan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDan.setBounds(10, 121, 46, 14);
		pnlUplataIsplata.add(lblDan);

		txtDan = new JTextField();
		txtDan.setBounds(65, 118, 50, 20);
		pnlUplataIsplata.add(txtDan);
		txtDan.setColumns(10);

		lblMesec = new JLabel("Mesec:");
		lblMesec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMesec.setBounds(121, 121, 49, 14);
		pnlUplataIsplata.add(lblMesec);

		txtMesec = new JTextField();
		txtMesec.setBounds(176, 118, 56, 20);
		pnlUplataIsplata.add(txtMesec);
		txtMesec.setColumns(10);

		lblGodina = new JLabel("Godina:");
		lblGodina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGodina.setBounds(242, 121, 43, 14);
		pnlUplataIsplata.add(lblGodina);

		txtGodina = new JTextField();
		txtGodina.setBounds(291, 118, 56, 20);
		pnlUplataIsplata.add(txtGodina);
		txtGodina.setColumns(10);

		pnlCenter = new JPanel();
		pnlCenter.setBounds(35, 175, 318, 138);
		contentPane.add(pnlCenter);
		pnlCenter.setLayout(null);

		lblStanjeNaRacunu = new JLabel("Stanje na racunu:");
		lblStanjeNaRacunu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanjeNaRacunu.setBounds(34, 11, 105, 14);
		pnlCenter.add(lblStanjeNaRacunu);

		txtStanje = new JTextField();
		txtStanje.setEditable(false);
		txtStanje.setBounds(149, 8, 105, 20);
		pnlCenter.add(txtStanje);
		txtStanje.setColumns(10);

		scrlUplate = new JScrollPane();
		scrlUplate.setViewportBorder(
				new TitledBorder(null, "Uplate", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		scrlUplate.setBounds(10, 322, 178, 163);
		contentPane.add(scrlUplate);

		pnlUplate = new JPanel();
		scrlUplate.setViewportView(pnlUplate);

		scrlIsplate = new JScrollPane();
		scrlIsplate.setViewportBorder(
				new TitledBorder(null, "Isplate", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		scrlIsplate.setBounds(198, 324, 178, 163);
		contentPane.add(scrlIsplate);

		pnlIsplate = new JPanel();
		scrlIsplate.setViewportView(pnlIsplate);

		btnIzvrsiTransakciju = new JButton("Izvrsi transakciju");
		btnIzvrsiTransakciju.setBounds(87, 36, 138, 23);
		pnlCenter.add(btnIzvrsiTransakciju);
		btnIzvrsiTransakciju.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double suma = Double.parseDouble(txtSuma.getText());
				int dan = Integer.parseInt(txtDan.getText());
				int mesec = Integer.parseInt(txtMesec.getText());
				int godina = Integer.parseInt(txtGodina.getText());
				if (rdbtnUplata.isSelected()) {
					t = new Transakcija(true, suma, dan, mesec, godina);
					listaUplata.add(t);

				} else if (rdbtnIsplata.isSelected()) {
					t = new Transakcija(false, suma, dan, mesec, godina);
					listaIsplata.add(t);
				}
			}
		});

		lblPoruka = new JLabel("Poruka");
		lblPoruka.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoruka.setBounds(87, 70, 138, 14);
		pnlCenter.add(lblPoruka);

		btnPrikaziTransakcije = new JButton("Prikazi transakcije");
		btnPrikaziTransakcije.setBounds(80, 104, 155, 23);
		pnlCenter.add(btnPrikaziTransakcije);
		btnPrikaziTransakcije.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<JCheckBox> list = new ArrayList<JCheckBox>();
				for (Transakcija a : listaUplata) {
					if (ts.isTekuciMesec(ts.getDatum(a))) {
						list.add(new JCheckBox(a.toString(), true));
					} else
						list.add(new JCheckBox(a.toString(), false));
				}
				pnlUplate.setLayout(new GridLayout(0, 1, 4, 4));

				pnlUplate.removeAll();
				for (JCheckBox a : list) {
					pnlUplate.add(a);
					pnlUplate.revalidate();
					pnlUplate.repaint();
				}
				list.clear();
				for (Transakcija a : listaIsplata) {
					if (ts.isTekuciMesec(ts.getDatum(a))) {
						list.add(new JCheckBox(a.toString(), true));
					} else
						list.add(new JCheckBox(a.toString(), false));
				}
				pnlIsplate.setLayout(new GridLayout(0, 1, 4, 4));

				pnlIsplate.removeAll();
				for (JCheckBox a : list) {
					pnlIsplate.add(a);
					pnlIsplate.revalidate();
					pnlIsplate.repaint();
				}
				list.clear();

			}
		});
	}
}