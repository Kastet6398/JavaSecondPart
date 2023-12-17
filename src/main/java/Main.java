import auth.BankAccount;
import auth.PremiumUser;
import auth.RegularUser;
import auth.User;
import currency.BaseCurrency;
import currency.Euro;
import currency.Uah;
import currency.Usd;
import fields.Date;


public class Main {
    public static void main(String[] args) {
        RegularUser user1 = new RegularUser(new User("John", "Doe", "john.doe@email.com"));
        PremiumUser user2 = new PremiumUser(new User("Jane", "Doe", "jane.doe@email.com"));
        RegularUser user3 = new RegularUser(new User("Jack", "Doe", "jack.doe@email.com"));
        BankAccount account1 = new BankAccount(user1, Usd.getInstance(), 500.0, 0.02, 500.0, new Date(10, 10, 10, 10));
        BankAccount account2 = new BankAccount(user2, Euro.getInstance(), 500.0, 0.015, 300.0, new Date(40, 4, 11, 45));
        BankAccount account3 = new BankAccount(user3, Uah.getInstance(), 500.0, 0.015, 300.0, new Date(14, 13, 23, 1));

        account1.deposit(200.0);
        account2.withdraw(50.0);

        account1.setInterestRate(0.03);
        account2.setCreditLimit(400.0);

        account1.convertBalance(BaseCurrency.init("MNT", .00029));
        account2.convertBalance(Usd.getInstance());
        account2.deposit(400.0);
        account3.takeInCredit(300);

        account1.displayAccountInfo();
        System.out.println();
        account2.displayAccountInfo();
        System.out.println();
        account3.displayAccountInfo();
    }
}
