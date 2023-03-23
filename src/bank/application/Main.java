package bank.application;

public class Main {
    public static void main(String[] args) {
        SBI account1 = new SBI(100_000,"123","Dev");
        HDFCBank account2 = new HDFCBank(25000,"456","Aruna");
        int bal = account2.checkBalance("456");
        System.out.println(bal);
        String statement = account2.withdrawMoney(5000,"456");
        System.out.println(statement);
        statement = account2.addMoney(200);
        System.out.print(statement);
    }
}