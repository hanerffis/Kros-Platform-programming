import java.util.Scanner;

class FilmMetod{
    String name,country,janr; //   �����, �����, ����
    int year,price; // г� �������, �������
}

public class FilmsMetods {
    public static FilmMetod[] setFilmsArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        FilmMetod move[] = new FilmMetod[k];
        System.out.println("������ ���������� ��� �����: ");

        for (int i = 0; i < move.length; i++) {
            move[i] = new FilmMetod();
            System.out.print("����� " + (i + 1) + "-�� ������ => ");
            move[i].name = sc.nextLine();

            System.out.print("г� ������� " + (i + 1) + "-�� ������ => ");
            move[i].year = sc.nextInt();
            sc.nextLine();

            System.out.print("����� " + (i + 1) + "-�� ������ => ");
            move[i].country = sc.nextLine();

            System.out.print("���� " + (i + 1) + "-�� ������ => ");
            move[i].janr = sc.nextLine();

            System.out.print("������� ������� " + (i + 1) + "-�� ������ => ");
            move[i].price = sc.nextInt();
            System.out.print("--------------------------------\n");
            sc.nextLine();
        }
        return move;
    }


    // ��������� ������
    public static void showArray(FilmMetod[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + "\t" + cntr[i].year + "��" + "\t" + cntr[i].country + "\t" + cntr[i].janr + "\t" + cntr[i].price+"���");
        }
    }

    // ���������� ��� ���� �����
    public static void showFilm(FilmMetod cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.year + "��" + "\t" + cntr.country + "\t" + cntr.janr + "\t" + cntr.price+"���");
    }

    // ������� ����
    public static double avgPrice(FilmMetod[] cntr) {
        double s = 0;
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].price;
        double sr = s / cntr.length;
        return sr;
    }


    // Գ��� � ����� ������ ��������
    public static FilmMetod[] BiggerPrice(FilmMetod cntr[]) {
        double sred = avgPrice(cntr);
        int kol = 0; //������� ����
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

    // Գ��� ����������� ���� �������
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

    // ���������� ���� �� ������
    public static void sortName(FilmMetod[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    FilmMetod rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // ����� �� ������
    public static FilmMetod findForName(FilmMetod cntr[], String name) {
        int n = -1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return cntr[n];
        } else return null;
    }

    // �������� ���� � ��������
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("������ ������� ������ => ");
        int n = sc.nextInt();
        FilmMetod move[] = setFilmsArr(n);// �������� ���������� ��� �����
        System.out.println("\n�������������� ������:");
        showArray(move);// ��������� �������� ����������

        // ���������� Գ���
        int nommax = MinYear(move);
        System.out.println("\n���������� �����:");
        showFilm(move[nommax]);

        // ���������� �� ������
        sortName(move);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(move);

        // ֳ�� ����� �� �������
        System.out.println("\nԳ���, � ����� ����� ��������");
        FilmMetod[] Larger = BiggerPrice(move);
        showArray(Larger);

        // ������� ����
        System.out.println("������� ���� =" + avgPrice(move));

        // ����� �����
        System.out.println("\n����� ������ \n ������ ����� => ");
        sc.nextLine();
        String sname = sc.nextLine();
        FilmMetod sfind = findForName(move,sname);
        if (sfind!=null){
            showFilm(sfind);
        }
        else {
            System.out.println("������ ������ ���� � ������!");
        }
    }
}
