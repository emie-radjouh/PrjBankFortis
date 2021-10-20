package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.Customer;
import bus.ValidatorGUI;
import data.CustomerDB;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchCustomerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCustomerNum;
	private static JTable table;
	static JScrollPane scPanel = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchCustomerGUI dialog = new SearchCustomerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchCustomerGUI() {
		setTitle("Search Customer");
		setBounds(100, 100, 476, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Please Enter The Customer Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 22, 292, 30);
		contentPanel.add(lblNewLabel);

		txtCustomerNum = new JTextField();
		txtCustomerNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerNum.setColumns(10);
		txtCustomerNum.setBounds(20, 60, 254, 30);
		contentPanel.add(txtCustomerNum);
		scPanel.setViewportBorder(null);

		scPanel.setBounds(20, 100, 432, 59);
		contentPanel.add(scPanel);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Pin", "Email" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setEnabled(false);
		scPanel.setColumnHeaderView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String customerNum = null;
						customerNum = txtCustomerNum.getText().trim();

						if (customerNum.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please Enter A Valid Customer Number!", "Empty Input",
									JOptionPane.ERROR_MESSAGE);
						} else if (ValidatorGUI.ValiCustomerNumber(customerNum) == false) {
							JOptionPane.showMessageDialog(null,
									"Please Enter A Valid Customer Number With 5 Digits!\nEx. 55673", "Invalid Input",
									JOptionPane.ERROR_MESSAGE);
						} else {

							try {
								if (!Customer.Search(customerNum).next() == false) {

									JOptionPane.showMessageDialog(null, " The Customer Successfully Found.",
											"successful Operation", JOptionPane.INFORMATION_MESSAGE);

									try {

										table.setModel(DbUtils.resultSetToTableModel(CustomerDB.search(customerNum)));

									} catch (Exception e1) {
										e1.printStackTrace();

									}

								} else {
									JOptionPane.showMessageDialog(null, " This Customer Does Not Exist! Try Again.",
											"Invalid Input", JOptionPane.ERROR_MESSAGE);
									txtCustomerNum.setText("");
									txtCustomerNum.requestFocus();
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
