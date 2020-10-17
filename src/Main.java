import java.util.Scanner;

public class Main {
    static Account[] accounts = new Account[5];
    public static void main(String[] args) {

        int bankAccount = 0;
        System.out.println("Bank hisobida Transferlardan tushgan pul ="+bankAccount);
        boolean bool = true;
        accounts[0] = new Account(123456789, "Saylaubay", "Infin Bank", 1600, "2238061", true);
        accounts[1] = new Account(456, "Ramazan", "Xalq Bank", 700, "2237140", true);
        accounts[2] = new Account(789, "Dulat", "Milliy Bank", 1400, "123", true);
        accounts[3] = new Account(1234, "Jaras", "Agro Bank", 2500, "456", true);
        accounts[4] = new Account(12345, "Bayram", "Qurilish Bank", 900, "888", true);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Qaysi client ustida operatsiyalar bajarmoqchisiz!");
            showClient();
            System.out.println("Tanlang - ");
            int client = scanner.nextInt();
            if(client == 0){
                bool = false;
                break;
            }

            if (accounts[client-1].isStatus()){
                switch (client){
                    case 0:{
                        bool = false;
                        break;
                    }
                    case 1:{
                        System.out.print(accounts[client-1].getCardHolder() + " karta raqamini kiriting :");
                        int number = scanner.nextInt();

                        if (checkCardNumber(number, client-1)){
                            System.out.print(accounts[client - 1].getCardHolder() + " ning karta parolini kiriting Sizda 3 ta imkoniyat bor");
                            scanner = new Scanner(System.in);

                            System.out.println();

                            boolean b = true;
                            for (int i = 1; i <= 3; i++) {
                                System.out.println(i + " chi imkoniyatingiz :");
                                scanner = new Scanner(System.in);
                                String pass = scanner.nextLine();

                                if (accounts[client-1].checkPass(pass)){
                                    b = false;
                                    break;

                                }
                            }
                            if (b){

                                accounts[client-1].blockStatus();
                                System.out.println("Hurmatli " + accounts[client - 1].getCardHolder() + " sizning kartangiz bloklandi!");
                                break;
                            }else {
                                boolean isBool = true;
                                while (isBool){
                                    System.out.println("====================Operatsiyalar======================");
                                    System.out.println("0 - Orqaga qaytish");
                                    System.out.println("1 - Karta haqida malumot");
                                    System.out.println("2 - Deposit");
                                    System.out.println("3 - Withdraw");
                                    System.out.println("4 - Transfer");
                                    System.out.println("5 - Change Password");

                                    scanner = new Scanner(System.in);
                                    int operations = scanner.nextInt();

                                    switch (operations){
                                        case 0:{
                                            isBool = false;
                                            break;
                                        }
                                        case 1:{
//                                    System.out.println(accounts[client-1].getCardNumber());
                                            accounts[client-1].view();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Qancha pul qo'ymoqchisiz Summani kiriting : ");
                                            Scanner scanner1 = new Scanner(System.in);
                                            int deposit = scanner1.nextInt();

                                            accounts[client-1].deposit(deposit);
                                            System.out.println("Deposit muvafaqqiyatli qo'yildi!!!");
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Qancha pul qyechmoqchisiz Summani kiriting (Hisobingizda : " + accounts[client-1].getBalance() + " mavjud) : ");
                                            Scanner scanner2 = new Scanner(System.in);
                                            int debet = scanner2.nextInt();

                                            boolean d = accounts[client-1].withDraw(debet);

                                            if (d){
                                                System.out.println("Pul muvafaqqiyatli yechildi");
                                            }else {
                                                System.out.println("Balance dan ko'p pul yecha olmaysiz!");
                                            }

                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Qaysi clientga pul transfer qilmoqchisiz");

                                            Scanner scanner3 = new Scanner(System.in);

                                            for (int i = 0; i < accounts.length; i++) {
                                                if (client-1 != i){
                                                    System.out.println(i + 1 + " " + accounts[i].getCardHolder());
                                                }
                                            }
                                            int item = scanner3.nextInt();

                                            switch (item){
                                                case 2:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);

                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 4:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 5:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 5:{
                                            System.out.println("Eki parolni kiriting : ");
                                            Scanner scanner4 = new Scanner(System.in);
                                            String pass = scanner4.nextLine();

                                            if (accounts[client-1].checkPass(pass)){
                                                System.out.println("Ynagi parolni kiriting : ");
                                                Scanner scanner6 = new Scanner(System.in);
                                                String newPass = scanner6.nextLine();

                                                accounts[client-1].changePassword(newPass);
                                            }else {
                                                System.out.println("Parol to'g'ri kelmadi");
                                            }

                                            break;
                                        }
                                        default:{
                                            System.out.println("Bunday buyruq yo'q");
                                            break;
                                        }
                                    }
                                }

                            }
                        }else {
                            System.out.println(accounts[client-1].getCardHolder() + " ning karta raqami xato kiritildi");
                        }

                        break;
                    }
                    case 2:{

                        System.out.print(accounts[client-1].getCardHolder() + " karta raqamini kiriting :");
                        int number = scanner.nextInt();

                        if (checkCardNumber(number, client-1)){
                            System.out.print(accounts[client - 1].getCardHolder() + " ning karta parolini kiriting Sizda 3 ta imkoniyat bor");
                            scanner = new Scanner(System.in);

                            System.out.println();

                            boolean b = true;
                            for (int i = 1; i <= 3; i++) {
                                System.out.println(i + " chi imkoniyatingiz :");
                                scanner = new Scanner(System.in);
                                String pass = scanner.nextLine();

                                if (accounts[client-1].checkPass(pass)){

                                    b = false;
                                    break;

                                }
                            }
                            if (b){

//                            System.exit(1);
                                accounts[client-1].blockStatus();
                                System.out.println("Hurmatli " + accounts[client - 1].getCardHolder() + " sizning kartangiz bloklandi!");
                                break;
                            }else {
                                boolean isBool = true;
                                while (isBool){
                                    System.out.println("====================Operatsiyalar======================");
                                    System.out.println("0 - Orqaga qaytish");
                                    System.out.println("1 - Karta haqida malumot");
                                    System.out.println("2 - Deposit");
                                    System.out.println("3 - Withdraw");
                                    System.out.println("4 - Transfer");
                                    System.out.println("5 - Change Password");

                                    scanner = new Scanner(System.in);
                                    int operations = scanner.nextInt();

                                    switch (operations){
                                        case 0:{
                                            isBool = false;
                                            break;
                                        }
                                        case 1:{
//                                    System.out.println(accounts[client-1].getCardNumber());
                                            accounts[client-1].view();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Qancha pul qo'ymoqchisiz Summani kiriting : ");
                                            Scanner scanner1 = new Scanner(System.in);
                                            int deposit = scanner1.nextInt();

                                            accounts[client-1].deposit(deposit);
                                            System.out.println("Deposit muvafaqqiyatli qo'yildi!!!");
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Qancha pul qyechmoqchisiz Summani kiriting (Hisobingizda : " + accounts[client-1].getBalance() + " mavjud) : ");
                                            Scanner scanner2 = new Scanner(System.in);
                                            int debet = scanner2.nextInt();

                                            boolean d = accounts[client-1].withDraw(debet);

                                            if (d){
                                                System.out.println("Pul muvafaqqiyatli yechildi");
                                            }else {
                                                System.out.println("Balance dan ko'p pul yecha olmaysiz!");
                                            }

                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Qaysi clientga pul transfer qilmoqchisiz");

                                            Scanner scanner3 = new Scanner(System.in);

                                            for (int i = 0; i < accounts.length; i++) {
                                                if (client-1 != i){
                                                    System.out.println(i + 1 + " " + accounts[i].getCardHolder());
                                                }
                                            }
                                            int item = scanner3.nextInt();

                                            switch (item){
                                                case 1:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 4:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 5:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 5:{
                                            System.out.println("Eki parolni kiriting : ");
                                            Scanner scanner4 = new Scanner(System.in);
                                            String pass = scanner4.nextLine();

                                            if (accounts[client-1].checkPass(pass)){
                                                System.out.println("Ynagi parolni kiriting : ");
                                                Scanner scanner6 = new Scanner(System.in);
                                                String newPass = scanner6.nextLine();

                                                accounts[client-1].changePassword(newPass);
                                            }else {
                                                System.out.println("Parol to'g'ri kelmadi");
                                            }

                                            break;
                                        }
                                        default:{
                                            System.out.println("Bunday buyruq yo'q");
                                            break;
                                        }
                                    }
                                }

                            }
                        }else {
                            System.out.println(accounts[client-1].getCardHolder() + " ning karta raqami xato kiritildi");
                        }

                        break;
                    }
                    case 3:{

                        System.out.print(accounts[client-1].getCardHolder() + " karta raqamini kiriting :");
                        int number = scanner.nextInt();

                        if (checkCardNumber(number, client-1)){
                            System.out.print(accounts[client - 1].getCardHolder() + " ning karta parolini kiriting Sizda 3 ta imkoniyat bor");
                            scanner = new Scanner(System.in);

                            System.out.println();

                            boolean b = true;
                            for (int i = 1; i <= 3; i++) {
                                System.out.println(i + " chi imkoniyatingiz :");
                                scanner = new Scanner(System.in);
                                String pass = scanner.nextLine();

                                if (accounts[client-1].checkPass(pass)){

                                    b = false;
                                    break;

                                }
                            }
                            if (b){

//                            System.exit(1);
                                accounts[client-1].blockStatus();
                                System.out.println("Hurmatli " + accounts[client - 1].getCardHolder() + " sizning kartangiz bloklandi!");
                                break;
                            }else {
                                boolean isBool = true;
                                while (isBool){
                                    System.out.println("====================Operatsiyalar======================");
                                    System.out.println("0 - Orqaga qaytish");
                                    System.out.println("1 - Karta haqida malumot");
                                    System.out.println("2 - Deposit");
                                    System.out.println("3 - Withdraw");
                                    System.out.println("4 - Transfer");
                                    System.out.println("5 - Change Password");

                                    scanner = new Scanner(System.in);
                                    int operations = scanner.nextInt();

                                    switch (operations){
                                        case 0:{
                                            isBool = false;
                                            break;
                                        }
                                        case 1:{
//                                    System.out.println(accounts[client-1].getCardNumber());
                                            accounts[client-1].view();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Qancha pul qo'ymoqchisiz Summani kiriting : ");
                                            Scanner scanner1 = new Scanner(System.in);
                                            int deposit = scanner1.nextInt();

                                            accounts[client-1].deposit(deposit);
                                            System.out.println("Deposit muvafaqqiyatli qo'yildi!!!");
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Qancha pul qyechmoqchisiz Summani kiriting (Hisobingizda : " + accounts[client-1].getBalance() + " mavjud) : ");
                                            Scanner scanner2 = new Scanner(System.in);
                                            int debet = scanner2.nextInt();

                                            boolean d = accounts[client-1].withDraw(debet);

                                            if (d){
                                                System.out.println("Pul muvafaqqiyatli yechildi");
                                            }else {
                                                System.out.println("Balance dan ko'p pul yecha olmaysiz!");
                                            }

                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Qaysi clientga pul transfer qilmoqchisiz");

                                            Scanner scanner3 = new Scanner(System.in);

                                            for (int i = 0; i < accounts.length; i++) {
                                                if (client-1 != i){
                                                    System.out.println(i + 1 + " " + accounts[i].getCardHolder());
                                                }
                                            }
                                            int item = scanner3.nextInt();

                                            switch (item){
                                                case 1:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 4:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 5:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 5:{
                                            System.out.println("Eki parolni kiriting : ");
                                            Scanner scanner4 = new Scanner(System.in);
                                            String pass = scanner4.nextLine();

                                            if (accounts[client-1].checkPass(pass)){
                                                System.out.println("Ynagi parolni kiriting : ");
                                                Scanner scanner6 = new Scanner(System.in);
                                                String newPass = scanner6.nextLine();

                                                accounts[client-1].changePassword(newPass);
                                            }else {
                                                System.out.println("Parol to'g'ri kelmadi");
                                            }

                                            break;
                                        }
                                        default:{
                                            System.out.println("Bunday buyruq yo'q");
                                            break;
                                        }
                                    }
                                }

                            }
                        }else {
                            System.out.println(accounts[client-1].getCardHolder() + " ning karta raqami xato kiritildi");
                        }

                        break;
                    }
                    case 4:{

                        System.out.print(accounts[client-1].getCardHolder() + " karta raqamini kiriting :");
                        int number = scanner.nextInt();

                        if (checkCardNumber(number, client-1)){
                            System.out.print(accounts[client - 1].getCardHolder() + " ning karta parolini kiriting Sizda 3 ta imkoniyat bor");
                            scanner = new Scanner(System.in);

                            System.out.println();

                            boolean b = true;
                            for (int i = 1; i <= 3; i++) {
                                System.out.println(i + " chi imkoniyatingiz :");
                                scanner = new Scanner(System.in);
                                String pass = scanner.nextLine();

                                if (accounts[client-1].checkPass(pass)){

                                    b = false;
                                    break;

                                }
                            }
                            if (b){

//                            System.exit(1);
                                accounts[client-1].blockStatus();
                                System.out.println("Hurmatli " + accounts[client - 1].getCardHolder() + " sizning kartangiz bloklandi!");
                                break;
                            }else {
                                boolean isBool = true;
                                while (isBool){
                                    System.out.println("====================Operatsiyalar======================");
                                    System.out.println("0 - Orqaga qaytish");
                                    System.out.println("1 - Karta haqida malumot");
                                    System.out.println("2 - Deposit");
                                    System.out.println("3 - Withdraw");
                                    System.out.println("4 - Transfer");
                                    System.out.println("5 - Change Password");

                                    scanner = new Scanner(System.in);
                                    int operations = scanner.nextInt();

                                    switch (operations){
                                        case 0:{
                                            isBool = false;
                                            break;
                                        }
                                        case 1:{
//                                    System.out.println(accounts[client-1].getCardNumber());
                                            accounts[client-1].view();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Qancha pul qo'ymoqchisiz Summani kiriting : ");
                                            Scanner scanner1 = new Scanner(System.in);
                                            int deposit = scanner1.nextInt();

                                            accounts[client-1].deposit(deposit);
                                            System.out.println("Deposit muvafaqqiyatli qo'yildi!!!");
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Qancha pul qyechmoqchisiz Summani kiriting (Hisobingizda : " + accounts[client-1].getBalance() + " mavjud) : ");
                                            Scanner scanner2 = new Scanner(System.in);
                                            int debet = scanner2.nextInt();

                                            boolean d = accounts[client-1].withDraw(debet);

                                            if (d){
                                                System.out.println("Pul muvafaqqiyatli yechildi");
                                            }else {
                                                System.out.println("Balance dan ko'p pul yecha olmaysiz!");
                                            }

                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Qaysi clientga pul transfer qilmoqchisiz");

                                            Scanner scanner3 = new Scanner(System.in);

                                            for (int i = 0; i < accounts.length; i++) {
                                                if (client-1 != i){
                                                    System.out.println(i + 1 + " " + accounts[i].getCardHolder());
                                                }
                                            }
                                            int item = scanner3.nextInt();

                                            switch (item){
                                                case 1:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 5:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 5:{
                                            System.out.println("Eki parolni kiriting : ");
                                            Scanner scanner4 = new Scanner(System.in);
                                            String pass = scanner4.nextLine();

                                            if (accounts[client-1].checkPass(pass)){
                                                System.out.println("Ynagi parolni kiriting : ");
                                                Scanner scanner6 = new Scanner(System.in);
                                                String newPass = scanner6.nextLine();

                                                accounts[client-1].changePassword(newPass);
                                            }else {
                                                System.out.println("Parol to'g'ri kelmadi");
                                            }

                                            break;
                                        }
                                        default:{
                                            System.out.println("Bunday buyruq yo'q");
                                            break;
                                        }
                                    }
                                }

                            }
                        }else {
                            System.out.println(accounts[client-1].getCardHolder() + " ning karta raqami xato kiritildi");
                        }

                        break;
                    }
                    case 5:{

                        System.out.print(accounts[client-1].getCardHolder() + " karta raqamini kiriting :");
                        int number = scanner.nextInt();

                        if (checkCardNumber(number, client-1)){
                            System.out.print(accounts[client - 1].getCardHolder() + " ning karta parolini kiriting Sizda 3 ta imkoniyat bor");
                            scanner = new Scanner(System.in);

                            System.out.println();

                            boolean b = true;
                            for (int i = 1; i <= 3; i++) {
                                System.out.println(i + " chi imkoniyatingiz :");
                                scanner = new Scanner(System.in);
                                String pass = scanner.nextLine();

                                if (accounts[client-1].checkPass(pass)){

                                    b = false;
                                    break;

                                }
                            }
                            if (b){

//                            System.exit(1);
                                accounts[client-1].blockStatus();
                                System.out.println("Hurmatli " + accounts[client - 1].getCardHolder() + " sizning kartangiz bloklandi!");
                                break;
                            }else {
                                boolean isBool = true;
                                while (isBool){
                                    System.out.println("====================Operatsiyalar======================");
                                    System.out.println("0 - Orqaga qaytish");
                                    System.out.println("1 - Karta haqida malumot");
                                    System.out.println("2 - Deposit");
                                    System.out.println("3 - Withdraw");
                                    System.out.println("4 - Transfer");
                                    System.out.println("5 - Change Password");

                                    scanner = new Scanner(System.in);
                                    int operations = scanner.nextInt();

                                    switch (operations){
                                        case 0:{
                                            isBool = false;
                                            break;
                                        }
                                        case 1:{
//                                    System.out.println(accounts[client-1].getCardNumber());
                                            accounts[client-1].view();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Qancha pul qo'ymoqchisiz Summani kiriting : ");
                                            Scanner scanner1 = new Scanner(System.in);
                                            int deposit = scanner1.nextInt();

                                            accounts[client-1].deposit(deposit);
                                            System.out.println("Deposit muvafaqqiyatli qo'yildi!!!");
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Qancha pul qyechmoqchisiz Summani kiriting (Hisobingizda : " + accounts[client-1].getBalance() + " mavjud) : ");
                                            Scanner scanner2 = new Scanner(System.in);
                                            int debet = scanner2.nextInt();

                                            boolean d = accounts[client-1].withDraw(debet);

                                            if (d){
                                                System.out.println("Pul muvafaqqiyatli yechildi");
                                            }else {
                                                System.out.println("Balance dan ko'p pul yecha olmaysiz!");
                                            }

                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Qaysi clientga pul transfer qilmoqchisiz");

                                            Scanner scanner3 = new Scanner(System.in);

                                            for (int i = 0; i < accounts.length; i++) {
                                                if (client-1 != i){
                                                    System.out.println(i + 1 + " " + accounts[i].getCardHolder());
                                                }
                                            }
                                            int item = scanner3.nextInt();

                                            switch (item){
                                                case 1:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +
                                                    
                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                                case 4:{
                                                    System.out.println("Qancha pul transfer qilmoqchisiz ("+ accounts[client-1].getBalance()+" mavjud): ");
                                                    System.out.println("Transfer xizmat narxi 1%");
                                                    Scanner scanner9 = new Scanner(System.in);
                                                    double deb = scanner9.nextInt();// +

                                                    double debPercent = deb + deb / 100;//+
                                                    if (accounts[client-1].withDraw(debPercent)){
                                                        bankAccount += deb/100;
//                                                        bank.setBankAccount(deb/100);//+
                                                        System.out.println("Hisobingizdan 1% bilan " + debPercent + " summa yechib olindi");//+
                                                        accounts[item-1].deposit(deb);
                                                        System.out.println("Transfer Muvafaqiyatli amalga oshdi");
                                                        System.out.println("Bank hisobida transferlardan tushgan pullar = " + bankAccount);
                                                    }else {
                                                        System.out.println("Transferda xatolik");
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 5:{
                                            System.out.println("Eki parolni kiriting : ");
                                            Scanner scanner4 = new Scanner(System.in);
                                            String pass = scanner4.nextLine();

                                            if (accounts[client-1].checkPass(pass)){
                                                System.out.println("Ynagi parolni kiriting : ");
                                                Scanner scanner6 = new Scanner(System.in);
                                                String newPass = scanner6.nextLine();

                                                accounts[client-1].changePassword(newPass);
                                            }else {
                                                System.out.println("Parol to'g'ri kelmadi");
                                            }

                                            break;
                                        }
                                        default:{
                                            System.out.println("Bunday buyruq yo'q");
                                            break;
                                        }
                                    }
                                }

                            }
                        }else {
                            System.out.println(accounts[client-1].getCardHolder() + " ning karta raqami xato kiritildi");
                        }

                        break;
                    }
                }
            }else {
                System.out.println(accounts[client-1].getCardHolder() + " client bloklangan");
                break;
            }




        }while (bool);

//        showClient();

        System.out.println("Bank hisobida Transferlardan tushgan pullar ="+bankAccount);

    }

    static boolean checkCardNumber(int number, int id){
        if (accounts[id].getCardNumber() == number){
            return true;
        }
        return false;
    }

    static void showClient(){
        System.out.println("Bankdagi mijozlar soni : " + accounts.length);
        System.out.println("0 Exit");
        for (int i = 0; i < accounts.length; i++) {
                System.out.println(i + 1 + " " + accounts[i].getCardHolder());
        }
    }

    static void showTransferList(int id){
        for (int i = 0; i < accounts.length; i++) {
            if (i != id){
                System.out.println(i + 1 + " " + accounts[i].getCardHolder());
            }
        }
    }

}
