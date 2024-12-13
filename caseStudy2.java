import java.util.Scanner;;
public class caseStudy2 {
    static Scanner sc = new Scanner(System.in);
    static final String[] MENU_NAMES = {"Black Coffe", "Latte", "Tensile Tea", "Fried Noodle"};
    static final int[] MENU_PRICES = {15000, 22000, 12000, 18000};
    static String[][] orders = new String[100][5];
    static int orderCount = 0;
    public static void tambahPesanan(){
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Table's Number: ");
        String tableNumber = sc.nextLine();

        int totalOrderPrice = 0;
        while (true) {
            System.out.println("===== CAFE MENU =====");
            for (int i = 0; i < MENU_NAMES.length; i++) {
                System.out.printf("%d. %s - Rp %d\n", (i + 1), MENU_NAMES[i], MENU_PRICES[i]);
            }
            System.out.print("Choose the menu (Enter menu's number, or 0 to finish): ");
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

        System.out.println("Order is Succesfully added.");
        System.out.printf("Total order price: Rp %d\n", totalOrderPrice);
    }

    public static void tampilkanDaftarPesanan() {
        if (orderCount == 0) {
            System.out.println("Tidak ada pesanan.");
            return;
        }

        System.out.println("===== DAFTAR PESANAN =====");
        String currentCustomer = "";
        for (int i = 0; i < orderCount; i++) {
            if (!orders[i][0].equals(currentCustomer)) {
                currentCustomer = orders[i][0];
                System.out.printf("Nama Pelanggan: %s, Nomor Meja: %s\n", orders[i][0], orders[i][1]);
            }
            System.out.printf("    Menu: %s, Jumlah: %s, Total Harga: Rp %s\n",
                    orders[i][2], orders[i][3], orders[i][4]);
        }
    }
  
    public static void tampilkanMenu() {
        System.out.println("\n=== MAIN MENU ===");
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






       
