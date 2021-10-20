package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import bus.Customer;
import bus.ValidatorGUI;
import data.CustomerDB;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddCustomerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNum;
	private JTextField txtName;
	private JTextField txtPin;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCustomerGUI dialog = new AddCustomerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(dialog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCustomerGUI() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("..\\BankFortisApplication\\icon\\business-and-finance-glyph-13-512.png"));
		setResizable(false);
		setTitle("Add New Customer");
		setBounds(100, 100, 441, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Customer Number :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 26, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("Customer Name:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 64, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("Customer Pin:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 99, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("Customer Email:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 138, 141, 13);
			contentPanel.add(lblNewLabel);
		}

		txtNum = new JTextField();
		txtNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNum.setBounds(164, 26, 206, 28);
		contentPanel.add(txtNum);
		txtNum.setColumns(10);
		{
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtName.setColumns(10);
			txtName.setBounds(164, 64, 206, 28);
			contentPanel.add(txtName);
		}
		{
			txtPin = new JTextField();
			txtPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPin.setColumns(10);
			txtPin.setBounds(164, 99, 206, 28);
			contentPanel.add(txtPin);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtEmail.setColumns(10);
			txtEmail.setBounds(164, 138, 206, 28);
			contentPanel.add(txtEmail);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String num, name, pin, email;

						num = txtNum.getText();
						name = txtName.getText().trim();
						pin = txtPin.getText().trim();
						email = txtEmail.getText().trim();

						if (num.isEmpty() || name.isEmpty() || pin.isEmpty() || email.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please Enter A Valid Input For Each Feild!",
									"Invalid Input", JOptionPane.ERROR_MESSAGE);
						} else {
							StringBuilder warnning = new StringBuilder();

							if (ValidatorGUI.ValiCustomerNumber(num) == false) {
								warnning.append("Please Enter A Valid Number With 5 Digits!\n");
							}

							if (ValidatorGUI.ValiCustomerName(name) == false) {
								warnning.append("Please Enter A Valid Name With 2 to 10 Characters!\n");
							}

							if (ValidatorGUI.ValiCustomerPin(pin) == false) {
								warnning.append("Please Enter A Valid Pin With 4 Digits!\n");
							}

							if (ValidatorGUI.ValiCustomerEmail(email) == false) {
								warnning.append("Please Enter A Valid Email Address!\n");
							}

							if (warnning.length() > 0) {
								JOptionPane.showMessageDialog(null, warnning.toString(), "Invalid Input",
										JOptionPane.ERROR_MESSAGE);

							} else {
								Customer aCustomer = new Customer(num, name, pin, email);

								try {

									if (!Customer.Search(num).next() == false)/// search for customer if exist)
									{
										JOptionPane.showMessageDialog(null,
												"This customer number exists! Please enter a new number.",
												"Incomplete Operation", JOptionPane.ERROR_MESSAGE);
									} else if (Customer.add(aCustomer) > 0) {

										JOptionPane.showMessageDialog(null, " The New Customer Added Successfully",
												"Success Operation", JOptionPane.INFORMATION_MESSAGE);
										setVisible(false);
										BankGUIAppDB.loadTable();
										BankGUIAppDB.setDateTime();
									} else {
										JOptionPane.showMessageDialog(null, " Something Went Wrong! Try Again.",
												"Incomplete operation", JOptionPane.ERROR_MESSAGE);

									}
								} catch (HeadlessException e1) {
									e1.printStackTrace();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
						}
					}
				});
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
				{
					JButton btnReset = new JButton("Reset");
					btnReset.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							txtNum.setText(null);
							txtName.setText(null);
							txtPin.setText(null);
							txtEmail.setText(null);

							txtNum.requestFocus();
						}
					});
					buttonPane.add(btnReset);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
