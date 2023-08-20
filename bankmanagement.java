import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters and setters

    public String toString() {
        return accountNumber + " - " + accountHolder + " - $" + balance;
    }
}

class BankManagementSystem extends JFrame implements ActionListener {
    private List<BankAccount> accounts;
    private JTextArea accountListTextArea;

    public BankManagementSystem() {
        accounts = new ArrayList<>();

        setTitle("Bank Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JButton addButton = new JButton("Add Account");
        addButton.addActionListener(this);

        accountListTextArea = new JTextArea(10, 30);
        accountListTextArea.setEditable(false);

        mainPanel.add(addButton, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(accountListTextArea), BorderLayout.CENTER);

        add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Account")) {
            String accountNumber = JOptionPane.showInputDialog("Enter account number:");
            String accountHolder = JOptionPane.showInputDialog("Enter account holder:");
            double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter initial balance:"));

            BankAccount account = new BankAccount(accountNumber, accountHolder, balance);
            accounts.add(account);

            updateAccountList();
        }
    }

    private void updateAccountList() {
        accountListTextArea.setText("");
        for (BankAccount account : accounts) {
            accountListTextArea.append(account.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankManagementSystem().setVisible(true);
            }
        });
    }
}
