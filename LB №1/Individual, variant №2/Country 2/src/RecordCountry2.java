import java.util.Scanner;
class Strana{
    String name; //   Назва
    double square; // Площя
}

public class RecordCountry2 {
    public static Strana[] setCountryArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        Strana country[] = new Strana[k];
        System.out.println("Введіть інформацію про країни: ");

        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana();
            System.out.print("Назва " + (i + 1) + "-ї країни => ");
            country[i].name = sc.nextLine();
            System.out.print("Площа " + (i + 1) + "-ї країни => ");
            country[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return country;
    }

    // Виведення масиву
    public static void showArray(Strana[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + "\t" + cntr[i].square + "млн.кв.км");
        }
    }

    // Інформація про одну країну
    public static void showCountry(Strana cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.square + "млн. кв. км");
    }

    // Номер країни з макс. площею
    public static int NomMax(Strana[] st) {
        int nommax2 = 0;
        double max = st[nommax2].square;
        for (int i = 0; i < st.length; i++)
            if (st[i].square > max) {
                max = st[i].square;
                nommax2 = i;
            }
        return nommax2;
    }

    // Сортування країн за площею
    public static void sortSquare(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].square > cntr[j + 1].square) {
                    Strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // Сортування країн за назвою
    public static void sortName(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // Середня площа
    public static double avgSquare(Strana[] cntr) {
        double s = 0; // сумарна площа
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].square;
        double sr = s / cntr.length;
        return sr;
    }

    // Країни з площою більше середньої
    public static Strana[] Bigger(Strana cntr[]) {
        double sred = avgSquare(cntr);
        int kol = 0; //кількість країн
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square > sred)
                ++kol;
        }
        if (kol != 0) {
            Strana[] bigCountry = new Strana[kol];
            int n = -1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].square > sred) {
                    bigCountry[++n] = cntr[i];
                }
            return bigCountry;
        } else return null;
    }

    // Пошук за назвою
    public static Strana findForName(Strana cntr[], String name) {
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
        System.out.print("Введіть кількість країн => ");
        int n = sc.nextInt();
        Strana Country[] = setCountryArr(n);// Введення інформації про країни
        System.out.println("\nХарактеристики країн:");
        showArray(Country);// Виведення отриманої інформації

        // Країна з максимальною площею
        int nommax = NomMax(Country);
        System.out.println("\nКраїна з максимальною площею:");
        showCountry(Country[nommax]);

        // Сортування країн за площею
        sortSquare(Country);
        System.out.println("\nВідсортований список за площею:");
        showArray(Country);

        // Сортування країн за назвою
        sortName(Country);
        System.out.println("\nВідсортований список за назвою:");
        showArray(Country);

        // Середня площа
        System.out.println("Середня площа =" + avgSquare(Country));

        // Площа більша за середню
        System.out.println("\nКраїни, з площею більше середньої");
        Strana[] Larger = Bigger(Country);
        showArray(Larger);

        // Пошук країни
        System.out.println("\nПошук країни \n Введіть назву країни => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Strana sfind = findForName(Country,sname);
        if (sfind!=null){
            showCountry(sfind);
        }
        else {
            System.out.println("Такой країни немає у списку!");
        }
    }
}




