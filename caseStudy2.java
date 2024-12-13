import java.util.Scanner;
public class caseStudy2 {
    static Scanner sc = new Scanner(System.in);
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
            // tambahPesanan();
                break;
            case 2:
            // tampilkanDaftarPesanan();
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






       
