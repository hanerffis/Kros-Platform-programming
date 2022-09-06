import java.util.Scanner;

class FilmMetod{
    String name,country,janr; //   Назва, країна, жанр
    int year,price; // Рік випуску, вартість
}

public class FilmsMetods {
    public static FilmMetod[] setFilmsArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        FilmMetod move[] = new FilmMetod[k];
        System.out.println("Введіть інформацію про країни: ");

        for (int i = 0; i < move.length; i++) {
            move[i] = new FilmMetod();
            System.out.print("Назва " + (i + 1) + "-го фільму => ");
            move[i].name = sc.nextLine();

            System.out.print("Рік випуску " + (i + 1) + "-го фільму => ");
            move[i].year = sc.nextInt();
            sc.nextLine();

            System.out.print("Країна " + (i + 1) + "-го фільму => ");
            move[i].country = sc.nextLine();

            System.out.print("Жанр " + (i + 1) + "-го фільму => ");
            move[i].janr = sc.nextLine();

            System.out.print("Вартість прокату " + (i + 1) + "-го фільму => ");
            move[i].price = sc.nextInt();
            System.out.print("--------------------------------\n");
            sc.nextLine();
        }
        return move;
    }


    // Виведення масиву
    public static void showArray(FilmMetod[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + "\t" + cntr[i].year + "рік" + "\t" + cntr[i].country + "\t" + cntr[i].janr + "\t" + cntr[i].price+"грн");
        }
    }

    // Інформація про одну країну
    public static void showFilm(FilmMetod cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.year + "рік" + "\t" + cntr.country + "\t" + cntr.janr + "\t" + cntr.price+"грн");
    }

    // Середня ціна
    public static double avgPrice(FilmMetod[] cntr) {
        double s = 0;
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].price;
        double sr = s / cntr.length;
        return sr;
    }


    // Фільм з ціною бульше середьної
    public static FilmMetod[] BiggerPrice(FilmMetod cntr[]) {
        double sred = avgPrice(cntr);
        int kol = 0; //кількість країн
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].price > sred)
                ++kol;
        }
        if (kol != 0) {
            FilmMetod[] bigerPrice = new FilmMetod[kol];
            int n = -1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].price > sred) {
                    bigerPrice[++n] = cntr[i];
                }
            return bigerPrice;
        } else return null;
    }

    // Фільм найдавнішого року випуску
    public static int MinYear(FilmMetod[] st) {
        int nommax2 = 0;
        double max = st[nommax2].year;
        for (int i = 0; i < st.length; i++)
            if (st[i].year < max) {
                max = st[i].year;
                nommax2 = i;
            }
        return nommax2;
    }

    // Сортування країн за назвою
    public static void sortName(FilmMetod[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    FilmMetod rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // Пошук за назвою
    public static FilmMetod findForName(FilmMetod cntr[], String name) {
        int n = -1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return cntr[n];
        } else return null;
    }

    // ГОЛОВНИЙ КЛАС З МЕТОДАМИ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введіть кількість фільмів => ");
        int n = sc.nextInt();
        FilmMetod move[] = setFilmsArr(n);// Введення інформації про країни
        System.out.println("\nХарактеристики фільмів:");
        showArray(move);// Виведення отриманої інформації

        // Найдавніший Фільм
        int nommax = MinYear(move);
        System.out.println("\nНайдавніший фільм:");
        showFilm(move[nommax]);

        // Сортування за назвою
        sortName(move);
        System.out.println("\nВідсортований список за назвою:");
        showArray(move);

        // Ціна більша за середню
        System.out.println("\nФільмі, з ціноб більше середньої");
        FilmMetod[] Larger = BiggerPrice(move);
        showArray(Larger);

        // Середня ціна
        System.out.println("Середня ціна =" + avgPrice(move));

        // Пошук країни
        System.out.println("\nПошук фільму \n Введіть назву => ");
        sc.nextLine();
        String sname = sc.nextLine();
        FilmMetod sfind = findForName(move,sname);
        if (sfind!=null){
            showFilm(sfind);
        }
        else {
            System.out.println("Такого фільму немає у списку!");
        }
    }
}
