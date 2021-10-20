package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import data.CustomerDB;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class BankGUIAppDB {

	private static JFrame frmBankApplication;
	public static JTable tableCustomers;
	public static JPanel panel = new JPanel();
	public static JLabel lblTime_1 = new JLabel();
	public static JLabel lblDateTime = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankGUIAppDB window = new BankGUIAppDB();
					window.frmBankApplication.setVisible(true);
					window.frmBankApplication.setLocationRelativeTo(null);
					loadTable();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankGUIAppDB() {
		initialize();

	}

	public static void loadTable() {
		try {
			tableCustomers.setModel(DbUtils.resultSetToTableModel(CustomerDB.display()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setDateTime() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		lblDateTime.setText("Last Update: " + date.format(now).toString());
		lblTime_1.setText("Time: " + time.format(now).toString());

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankApplication = new JFrame();
		frmBankApplication.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("..\\BankFortisApplication\\icon\\business-and-finance-glyph-13-512.png"));
		frmBankApplication.setResizable(false);
		frmBankApplication.setTitle("Bank Application");
		frmBankApplication.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmBankApplication.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 671, 455);
		frmBankApplication.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnAdd = new JButton("Add Customer");
		btnAdd.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerGUI addmenu = new AddCustomerGUI();
				addmenu.setVisible(true);
			}
		});
		btnAdd.setBounds(20, 372, 147, 28);
		panel.add(btnAdd);

		JButton btnRemove = new JButton("Remove Customer");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCustomerGUI dialog = new DeleteCustomerGUI();
				dialog.setVisible(true);
			}
		});
		btnRemove.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		btnRemove.setBounds(165, 372, 147, 28);
		panel.add(btnRemove);

		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UptadeCustomerGUI dialog = new UptadeCustomerGUI();
				dialog.setVisible(true);
			}
		});
		btnUpdateCustomer.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		btnUpdateCustomer.setBounds(358, 372, 147, 28);
		panel.add(btnUpdateCustomer);

		JButton btnRefreshTable = new JButton("Refresh Table");
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
				setDateTime();

			}
		});
		btnRefreshTable.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		btnRefreshTable.setBounds(505, 372, 147, 28);
		panel.add(btnRefreshTable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(23, 83, 629, 257);
		panel.add(scrollPane);

		tableCustomers = new JTable();
		tableCustomers.setRowSelectionAllowed(false);
		tableCustomers.setEnabled(false);
		tableCustomers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tableCustomers);
		tableCustomers
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NUM", "NAME", "PIN", "EMAIL" }));
		tableCustomers.getColumnModel().getColumn(0).setPreferredWidth(76);
		tableCustomers.getColumnModel().getColumn(2).setPreferredWidth(42);
		tableCustomers.getColumnModel().getColumn(3).setPreferredWidth(143);

		JLabel lblChangeable = new JLabel("All Customers");
		lblChangeable.setForeground(Color.WHITE);
		lblChangeable.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblChangeable.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeable.setBounds(244, 10, 161, 36);
		panel.add(lblChangeable);

		setDateTime();

		lblDateTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDateTime.setBounds(24, 56, 288, 36);
		panel.add(lblDateTime);

		lblTime_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime_1.setForeground(Color.WHITE);
		lblTime_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTime_1.setBounds(309, 56, 343, 36);
		panel.add(lblTime_1);

		JButton btnSearch = new JButton("Search Customer");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomerGUI dialog = new SearchCustomerGUI();
				dialog.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		btnSearch.setBounds(261, 410, 147, 28);
		panel.add(btnSearch);
		frmBankApplication.setBackground(Color.GRAY);
		frmBankApplication.setBounds(100, 100, 708, 534);
		frmBankApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmBankApplication.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Help");
		mnNewMenu.setForeground(Color.GRAY);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankApplication.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnNewMenu.add(btnExit);
	}
}
