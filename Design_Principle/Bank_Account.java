 class Customer {
    String name;
    double balance;

    Customer(String name) {
        this.name = name;
    }

    void viewBalance() {
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    String name;

    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer c, double initialAmount) {
        c.balance = initialAmount;
    }
}

public class Bank_Account {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer c = new Customer("Aditi");
        bank.openAccount(c, 1000);
        c.viewBalance();
    }
}
