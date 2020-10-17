public class Account {

    private int cardNumber;
    private String cardHolder;
    private String cardCompany;
    private int balance;
    private String password;
    private boolean status;

    public Account(int cardNumber, String cardHolder, String cardCompany, int balance, String password, boolean status) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cardCompany = cardCompany;
        this.balance = balance;
        this.password = password;
        this.status = status;
    }

    public boolean checkPass(String pass){
        if (this.password.equals(pass)){
            return true;
        }
        return false;
    }

//    public boolean checkStatus(){
//
//    }

    public void view(){
        System.out.println("cardNumber=" + cardNumber +
                ", \ncardHolder='" + cardHolder + '\'' +
                ", \ncardCompany='" + cardCompany + '\'' +
                ", \nbalance=" + balance +
                ", \nstatus=" + status);
    }
    public void blockStatus(){
        this.status = false;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public int getBalance() {
        return balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void deposit(double summa){
        this.balance += summa;

    }

    public boolean withDraw(double debet){
        if (this.balance >= debet) {
            this.balance -= debet;
            return true;
        }else {
            return false;
        }

    }

    public void transfer(){

    }

    public void changePassword(String pass){
        this.password = pass;
    }

    @Override
    public String toString() {
        return "TEST";
//        return "Account{" +
//                "cardNumber=" + cardNumber +
//                ", cardHolder='" + cardHolder + '\'' +
//                ", cardCompany='" + cardCompany + '\'' +
//                ", balance=" + balance +
//                ", status=" + status +
//                '}';
    }
}
