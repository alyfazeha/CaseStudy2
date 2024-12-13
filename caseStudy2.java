import java.util.Scanner;
public class caseStudy2 {

    static Scanner sc = new Scanner(System.in);
    static final String[] MENU_NAMES = {"Black Coffe", "Latte", "Tensile Tea", "Fried Noodle"};
    static final int[] MENU_PRICES = {15000, 22000, 12000, 18000};
    static String[][] orders = new String[100][5];
    static int orderCount = 0;

    public static void tambahPesanan(){
        System.out.print("\nEnter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Table's Number: ");
        String tableNumber = sc.nextLine();

        int totalOrderPrice = 0;
        while (true) {
            System.out.println("\n========== CAFE MENU ==========");
            for (int i = 0; i < MENU_NAMES.length; i++) {
                System.out.printf("%d. %s - Rp %d\n", (i + 1), MENU_NAMES[i], MENU_PRICES[i]);
            }
            System.out.print("\nChoose the menu (Enter menu's number, or 0 to finish): ");
            int menuChoice = sc.nextInt();

            if (menuChoice == 0) break;

            if (menuChoice < 1 || menuChoice > MENU_NAMES.length) {
                System.out.println("Menu is invalid.");
                continue;
            }

            System.out.printf("Enter the number of items for %s: ", MENU_NAMES[menuChoice - 1]);
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("The number of item must more than 0.");
                continue;
            }

            int itemPrice = MENU_PRICES[menuChoice - 1];
            totalOrderPrice += itemPrice * quantity;

            orders[orderCount][0] = customerName;
            orders[orderCount][1] = tableNumber;
            orders[orderCount][2] = MENU_NAMES[menuChoice - 1];
            orders[orderCount][3] = String.valueOf(quantity);
            orders[orderCount][4] = String.valueOf(itemPrice * quantity);
            orderCount++;
        }

        System.out.println("\nOrder is Succesfully added.");
        System.out.printf("Total order price: Rp %d\n", totalOrderPrice);
    }

    public static void tampilkanDaftarPesanan() {
        String previousCustomerName = null;
        System.out.println("\n====== LIST OF ALL ORDER ======");
        
        if (orderCount != 0) {
            int totalPrice = 0;
    
            for (int a = 0; a < orderCount; a++) {
                String currentCustomerName = orders[a][0];

                if (!currentCustomerName.equalsIgnoreCase(previousCustomerName)) {

                    if (previousCustomerName != null) {
                        System.out.println("Total order price : Rp. " + totalPrice);
                        System.out.println("-------------------------------");
                    }
    
                    previousCustomerName = currentCustomerName;
                    totalPrice = 0;  
    
                    System.out.println("\nCustomer name: " + currentCustomerName);
                    System.out.println("Table Number: " + orders[a][1]);
                    System.out.println("Order Details:");
                }
    
                for (int b = 2; b < orders[a].length; b++) {
                    switch (b) {
                        case 2: 
                            System.out.print("- " + orders[a][b]);
                            break;
                        case 3: 
                            System.out.print(" x " + orders[a][b]);
                            break;
                        case 4: 
                            int price = Integer.parseInt(orders[a][b]);
                            System.out.println(" = Rp. " + price);
                            totalPrice += price;  
                            break;
                        default:
                            break;
                    }
                }
            }
    
            System.out.println("Total order price : Rp. " + totalPrice);
            System.out.println("-------------------------------");
        } else {
            System.out.println("No customer order data");
        }
    }
    
    public static void tampilkanMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Orders");
        System.out.println("2. Show list of Orders");
        System.out.println("3. Exit");
        System.out.print("Choose Menu: ");
        int pilihan = sc.nextInt();
        sc.nextLine();

        switch (pilihan) {
            case 1:
            tambahPesanan();
                break;
            case 2:
            tampilkanDaftarPesanan();
                break;
            case 3:
                System.out.println("Exitting program, Thank You!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Try again.");
        }
    }
    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
        }
    }
}






       
