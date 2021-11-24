import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int menuNum = 0;
        List<Branch> branches = new ArrayList<>(Main.branchManager.loadAll());
        if (branches == null || branches.size() == 0) {
            System.out.print("""
                    There are no branches!
                    Create a one at least!
                    """);
            createBranch();
        }
        while (true) {
            System.out.print("""
                    1-Employee
                    2-Customer
                    3-Branch                   
                    Enter the selected option: 
                    """);
            menuNum = input.nextInt();
            input.nextLine();
            switch (menuNum) {
                case 1: {
                    E:
                    while (true) {
                        System.out.println("""
                                1-SingUp
                                2-SignIn
                                0-Back
                                """);
                        menuNum = input.nextInt();
                        input.nextLine();
                        switch (menuNum) {
                            case 1: {
                                createEmployee();
                                break;
                            }
                            case 2: {
                                while (true) {
                                    Set<Employee> employees = Main.employeeManager.loadAll();

                                    if (employees == null) {
                                        System.out.print("""
                                                There are no employees!
                                                Create a one at least!
                                                """);
                                        createEmployee();
                                    } else
                                        break;
                                }
                                Employee loggedInEmployee = loginEmployee();

                                if (loggedInEmployee == null)
                                    System.out.println("Wrong username or password!");
                                else
                                    System.out.println("Logged In!");
                                System.out.print("""
                                        1-Show locked account
                                        0-Logout
                                                                        
                                        Enter the selected option: 
                                        """);
                                menuNum = input.nextInt();
                                input.nextLine();
                                switch (menuNum) {
                                    case 0: {
                                        loggedInEmployee = null;
                                        break E;
                                    }
                                    case 1: {
                                        unlockAccount(loggedInEmployee);
                                        break;
                                    }
                                }
                                break;
                            }
                            case 0: {
                                break E;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("""
                            1-Open an account
                            2-Login
                                                        
                            Enter the selected option: 
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 1: {
                            Customer customer;
                            System.out.print("Enter your national id: ");
                            String nationalId = input.nextLine();
                            if (Main.customerManager.exists(nationalId))
                                customer = Main.customerManager.loadByNationalId(nationalId);
                            else {
                                customer = createCustomer(nationalId);
                            }
                            Account account = createAccount(customer);
                            CreditCard card;
                            card = createCreditCard(account);
                            System.out.println(card);
                            System.out.println("Done!");
                            break;
                        }
                        case 2: {
                            CreditCard card = login();
                            if (card == null)
                                break;
                            A:
                            while (true) {
                                System.out.println("""
                                        1-Balance inquiry
                                        2-Transfer
                                        3-Change password
                                        4-Show Transactions
                                        0-Back
                                        """);
                                menuNum = input.nextInt();
                                input.nextLine();
                                switch (menuNum) {
                                    case 0: {
                                        break A;
                                    }
                                    case 1: {
                                        System.out.println("Balance: " + card.getAccount().getBalance());
                                        break;
                                    }
                                    case 2: {
                                        transfer(card);
                                        break;
                                    }
                                    case 3: {
                                        changePin(card);
                                        break;
                                    }
                                    case 4: {
                                        showTransactions(card);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    createBranch();
                    break;
                }
            }
        }
    }

    private static void showTransactions(CreditCard card) {
        System.out.println("--------Transactions:");
        List<Transaction> transactions = Main.transactionManager.getTransactions(card.getAccount());
        if (transactions.size() == 0) {
            System.out.println("No Transactions found!");
            return;
        }
        for (int i = 0; i < transactions.size(); i++) {
            String state = "";
            if (transactions.get(i).getOrigin() == card.getAccount())
                state = "Out";
            else
                state = "In";
            System.out.println((i + 1) + "-" + transactions.get(i).getAmount() + " " + state);
        }
        System.out.print("Choose a one to see detail or 0 to back: ");
        int answer = input.nextInt();
        if (answer == 0)
            return;
        Transaction transaction = transactions.get(answer - 1);
        System.out.println("\n--Transaction");
        System.out.println("ID: " + transaction.getId());
        System.out.println("Date & Time: " + transaction.getTimestamp().toLocalDateTime());
        System.out.println("From: " + transaction.getOrigin().getCreditCards().getNumber()
                + " | " + transaction.getOrigin().getCustomer().getName());
        System.out.println("To: " + transaction.getDestination().getCreditCards().getNumber()
                + " | " + transaction.getDestination().getCustomer().getName());
        System.out.println("Amount: "+transaction.getAmount());
    }

    private static Branch createBranch() {
        String name = "";
        while (true) {
            System.out.print("Enter a name: ");
            name = input.nextLine();
            if (Main.branchManager.exists(name))
                System.out.println("The name exists! Try again.");
            else
                break;
        }
        Branch branch = Branch.builder()
                .name(name)
                .build();
        Main.branchManager.save(branch);
        System.out.println("Branch added!");
        return branch;
    }

    private static Employee createEmployee() {
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        String username = "";
        while (true) {
            System.out.print("Enter a username: ");
            username = input.nextLine();
            if (Main.employeeManager.userExists(username))
                System.out.println("The username exists! Try again.");
            else
                break;
        }
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        Branch branch = selectBranch();
        Employee employee = Employee.builder()
                .name(name)
                .username(username)
                .password(password)
                .branch(branch)
                .build();
        Main.employeeManager.save(employee);
        return employee;
    }

    private static Employee loginEmployee() {
        System.out.print("\nUsername: ");
        String username = input.nextLine();
        System.out.print("\nPassword: ");
        String password = input.nextLine();
        Employee employee = Main.employeeManager.login(username, password);
        return employee;
    }

    private static void unlockAccount(Employee employee) {
        List<Account> accounts = employee.getBranch().getLockedAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + "-" + accounts.get(i).getCustomer().getName());
        }
        System.out.print("\nSelect an account to unlock: ");
        Account account = accounts.get(input.nextInt() - 1);
        input.nextLine();
        account.setLocked(false);
        Main.accountManager.update(account);
        System.out.println("Unlocked!");
    }

    private static Customer createCustomer(String nationalId) {
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        Customer customer = Customer.builder()
                .nationalId(nationalId)
                .name(name)
                .build();
        Main.customerManager.save(customer);
        return customer;
    }

    private static Account createAccount(Customer customer) {
        Branch branch = selectBranch();
        System.out.print("Enter the initial balance: ");
        Integer balance = Integer.parseInt(input.nextLine());

        Account account = Account.builder()
                .branch(branch)
                .customer(customer)
                .balance(balance)
                .build();
        Main.accountManager.save(account);
        return account;
    }

    private static CreditCard createCreditCard(Account account) {
        System.out.print("Enter a pin: ");
        String pin = input.nextLine();
        CreditCard card = CreditCard.builder()
                .account(account)
                .pin(pin)
                .expDate("2611")
                .build();
        Main.creditCardManager.save(card);
        return card;
    }

    private static Branch selectBranch() {
        System.out.println("Branches:");
        List<Branch> branches = new ArrayList<>(Main.branchManager.loadAll());
        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i + 1) + "-" + branches.get(i).getName());
        }
        System.out.print("Choose a branch: ");
        int branchNum = input.nextInt();
        input.nextLine();
        return branches.get(branchNum - 1);
    }

    private static CreditCard login() {
        System.out.print("Enter your card number: ");
        String number = input.nextLine();
        System.out.print("Enter your pin: ");
        String pin = input.nextLine();
        CreditCard card;
        try {
            card = Main.creditCardManager.login(number, pin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return card;
    }

    private static void transfer(CreditCard card) {
        System.out.print("Enter the amount: ");
        Integer amount = input.nextInt();
        input.nextLine();
        System.out.print("Enter the destination card number: ");
        String number = input.nextLine();
        CreditCard destination = Main.creditCardManager.loadByNumber(number);
        if (destination == null) {
            System.out.println("Destination Card number is not valid!");
            return;
        }
        System.out.println("------Confirmation------");
        System.out.println("Amount: " + amount);
        System.out.println("From: " + card.getNumber() + " | " + card.getAccount().getCustomer().getName());
        System.out.println("To: " + destination.getNumber() + " | " + destination.getAccount().getCustomer().getName());
        System.out.print("Continue (y/n)? ");
        String answer = input.nextLine();
        if (!answer.equals("y")) {
            System.out.println("Canceled!");
            return;
        }
        try {
            Main.creditCardManager.transfer(card, number, amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Done!");
    }

    private static void changePin(CreditCard card) {
        System.out.print("Enter the new pin: ");
        String pin = input.nextLine();
        System.out.print("Re-enter the new pin: ");
        String pinReEntered = input.nextLine();
        if (!pin.equals(pinReEntered)) {
            System.out.println("Pin mismatch!");
            return;
        }
        try {
            Main.creditCardManager.changePassword(card, pinReEntered);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
