import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.initial();
    }

    private void initial() {
        String bil, error_bil;
        do {
            System.out.print("Masukkan jumlah bilangan : ");
            bil = scanner.nextLine();
            error_bil = Validation.validation(bil);
            if (!error_bil.isEmpty()) {
                Validation.printError(error_bil);
            }
        } while (!error_bil.isEmpty());

        acakAngka(Integer.parseInt(bil));

        mainMenu(Integer.parseInt(bil));
    }

    private void mainMenu(int bil) {
        while (true) {
            String [] menu = {"Lihat angka", "Acak angka", "Sorting angka ascending",
                              "Sorting angka descending", "Keluar"};
            StringBuilder range = new StringBuilder();
            String error,choose;

            System.out.println("==================== Menu Utama =====================");
            for (int i = 0; i < menu.length; i++) {
                int no = i + 1;
                System.out.println(no + ". " + menu[i]);
                range.append(no).append("/");
            }

            do {
                System.out.print("Masukkan pilihan [" + range + "] : ");
                choose = scanner.next();
                error = Validation.validation(choose);
                if (!error.isEmpty()) {
                    Validation.printError(error);
                }
            } while (!error.isEmpty());

            switch (Integer.parseInt(choose)) {
                case 1 -> lihatAngka();
                case 2 -> acakAngka(bil);
                case 3 -> sortAsc();
                case 4 -> sortDesc();
                case 5 -> System.exit(0);
                default -> Validation.printError("Masukkan angka antara 1-" + menu.length);
            }
        }
    }

    private void lihatAngka() {
        System.out.println("==================== Angka Acak =====================");
        list.forEach((number) -> System.out.print(number + " "));
        System.out.println();
    }

    private void acakAngka(int bil) {
        list.clear();
        Random rand = new Random();
        for (int i = 0; i < bil; i++) {
            int random = rand.nextInt(20) + 1;
            list.add(random);
        }
        lihatAngka();
    }

    private void sortAsc() {
        System.out.println("==================== Angka Ascending =====================");
        list.stream().sorted().forEach((number) -> System.out.print(number + " "));
        System.out.println();
    }

    private void sortDesc() {
        System.out.println("==================== Angka Descending =====================");
        list.stream().sorted(Comparator.reverseOrder()).forEach((number) -> System.out.print(number + " "));
        System.out.println();
    }
}
