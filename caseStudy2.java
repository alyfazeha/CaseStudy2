import java.util.Scanner;;
public class caseStudy2 {
    static Scanner sc = new Scanner(System.in);
    static final String[] MENU_NAMES = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
    static final int[] MENU_PRICES = {15000, 22000, 12000, 18000};
    static String[][] orders = new String[100][5];
    static int orderCount = 0;
    public static void tambahPesanan(){
        System.out.print("Masukkan nama pelanggan: ");
        String customerName = sc.nextLine();

        System.out.print("Masukkan nomor meja: ");
        String tableNumber = sc.nextLine();

        int totalOrderPrice = 0;
        while (true) {
            System.out.println("===== MENU KAFE =====");
            for (int i = 0; i < MENU_NAMES.length; i++) {
                System.out.printf("%d. %s - Rp %d\n", (i + 1), MENU_NAMES[i], MENU_PRICES[i]);
            }
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            int menuChoice = sc.nextInt();

            if (menuChoice == 0) break;

            if (menuChoice < 1 || menuChoice > MENU_NAMES.length) {
                System.out.println("Pilihan menu tidak valid.");
                continue;
            }

            System.out.printf("Masukkan jumlah item untuk %s: ", MENU_NAMES[menuChoice - 1]);
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Jumlah item harus lebih dari 0.");
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

        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.printf("Total harga pesanan: Rp %d\n", totalOrderPrice);
    }
}
