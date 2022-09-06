import java.util.Scanner;
class Strana{
    String name; //   �����
    double square; // �����
}

public class RecordCountry2 {
    public static Strana[] setCountryArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        Strana country[] = new Strana[k];
        System.out.println("������ ���������� ��� �����: ");

        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana();
            System.out.print("����� " + (i + 1) + "-� ����� => ");
            country[i].name = sc.nextLine();
            System.out.print("����� " + (i + 1) + "-� ����� => ");
            country[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return country;
    }

    // ��������� ������
    public static void showArray(Strana[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + "\t" + cntr[i].square + "���.��.��");
        }
    }

    // ���������� ��� ���� �����
    public static void showCountry(Strana cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.square + "���. ��. ��");
    }

    // ����� ����� � ����. ������
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

    // ���������� ���� �� ������
    public static void sortSquare(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].square > cntr[j + 1].square) {
                    Strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // ���������� ���� �� ������
    public static void sortName(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // ������� �����
    public static double avgSquare(Strana[] cntr) {
        double s = 0; // ������� �����
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].square;
        double sr = s / cntr.length;
        return sr;
    }

    // ����� � ������ ����� ��������
    public static Strana[] Bigger(Strana cntr[]) {
        double sred = avgSquare(cntr);
        int kol = 0; //������� ����
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

    // ����� �� ������
    public static Strana findForName(Strana cntr[], String name) {
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
        System.out.print("������ ������� ���� => ");
        int n = sc.nextInt();
        Strana Country[] = setCountryArr(n);// �������� ���������� ��� �����
        System.out.println("\n�������������� ����:");
        showArray(Country);// ��������� �������� ����������

        // ����� � ������������ ������
        int nommax = NomMax(Country);
        System.out.println("\n����� � ������������ ������:");
        showCountry(Country[nommax]);

        // ���������� ���� �� ������
        sortSquare(Country);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(Country);

        // ���������� ���� �� ������
        sortName(Country);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(Country);

        // ������� �����
        System.out.println("������� ����� =" + avgSquare(Country));

        // ����� ����� �� �������
        System.out.println("\n�����, � ������ ����� ��������");
        Strana[] Larger = Bigger(Country);
        showArray(Larger);

        // ����� �����
        System.out.println("\n����� ����� \n ������ ����� ����� => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Strana sfind = findForName(Country,sname);
        if (sfind!=null){
            showCountry(sfind);
        }
        else {
            System.out.println("����� ����� ���� � ������!");
        }
    }
}




