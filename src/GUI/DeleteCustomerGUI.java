package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.Customer;
import bus.ValidatorGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DeleteCustomerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCustomerNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteCustomerGUI dialog = new DeleteCustomerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteCustomerGUI() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("..\\BankFortisApplication\\icon\\business-and-finance-glyph-13-512.png"));
		setResizable(false);
		setTitle("Delete Customer");
		setBounds(100, 100, 362, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Please Enter The Customer Number:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 10, 292, 30);
			contentPanel.add(lblNewLabel);
		}

		txtCustomerNumber = new JTextField();
		txtCustomerNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerNumber.setBounds(10, 48, 329, 30);
		contentPanel.add(txtCustomerNumber);
		txtCustomerNumber.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String customerNum = null;
						customerNum = txtCustomerNumber.getText();

						if (customerNum.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please Enter A Valid Customer Number!", "Empty Input",
									JOptionPane.ERROR_MESSAGE);
						} else if (ValidatorGUI.ValiCustomerNumber(customerNum) == false) {
							JOptionPane.showMessageDialog(null,
									"Please Enter A Valid Customer Number With 5 Digits!\nEx. 55673", "Invalid Input",
									JOptionPane.ERROR_MESSAGE);
						} else {

							try {
								if (Customer.delete(customerNum) > 0) {

									JOptionPane.showMessageDialog(null, " The Customer Deleted Successfully",
											"Success Operation", JOptionPane.INFORMATION_MESSAGE);
									setVisible(false);
									BankGUIAppDB.loadTable();
									BankGUIAppDB.setDateTime();

								} else {
									JOptionPane.showMessageDialog(null, " This Customer Does Not Exist! Try Again.",
											"Invalid Input", JOptionPane.ERROR_MESSAGE);

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
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
