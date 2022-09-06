import java.util.Arrays;
import java.util.Scanner;

class Film{
    String name,country,janr; //   �����, �����, ����
    int year,price; // г� �������, �������
}

public class Films {
    public static void main (String[] args ) {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("������ ������� ������ =>");
        int n = sc.nextInt(); // ʳ������ ������
        Film move[] = new Film[n];
        System.out.println("������ ���������� ��� ���������: ");

        for (int i = 0; i < move.length; i++) {
            sc.nextLine();
            move[i] = new Film();

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
        }
        //��������� �������� ����������
        System.out.println("\n�������������� ����:");
        for (int i = 0; i < move.length; i++) {
            System.out.println("" + move[i].name + "\t" + move[i].year + "��" + "\t" + move[i].country + "\t" + move[i].janr + "\t" + move[i].price+"���");
        }

        //Գ��� � ����� ������ ��������
        double s=0;
        for(int i =0; i< move.length;i++)
            s+= move[i].price;
        double sr=s/move.length;
        System.out.println("\nԳ��� � ����� ������ ��������");

        for (int i=0;i< move.length;i++){
            if(move[i].price>sr)
                System.out.println("" + move[i].name + "\t" + move[i].year + "��" + "\t" + move[i].country + "\t" + move[i].janr + "\t" + move[i].price+"���");
        }
        System.out.println("������� ������� �������="+sr);

        //Գ��� ����������� ���� �������
        int nommax = 0;
        double max = move[nommax].year;
        for(int i=0; i<move.length;i++) if (move[i].year<max){
            max = move[i].year;
            nommax = i;
        }
        System.out.println("\nԳ��� ����������� ���� �������: ");
        System.out.println("" + move[nommax].name + "\t" + move[nommax].year + "��" + "\t" + move[nommax].country + "\t" + move[nommax].janr + "\t" + move[nommax].price+"���");

        //����������� ���� �� ������
        for (int i = 0; i < move.length - 1; i++)
            for (int j = 0; j < move.length - i - 1; j++)
                if (move[j].name.compareTo(move[i+1].name)>0){
                    Film rab=move[j];
                    move[j]=move[j+1];
                    move[j+1]=rab;
                }
        System.out.println("\n³���������� ������ �� ������:");
        for (int i=0;i< move.length;i++){
            System.out.println("" + move[i].name + "\t" + move[i].year + "��" + "\t" + move[i].country + "\t" + move[i].janr + "\t" + move[i].price+"���");
        }

        //����� �� ������
        sc.nextLine();
        System.out.println("������ ����� �������� ������ ");
        String name = sc.nextLine();
        int nom=-1;
        for(int i=0;i< move.length;i++)
            if(name.equalsIgnoreCase(move[i].name))nom=i;
        if(nom!=-1){
            System.out.println("���� ����� � � ������. �� " + move[nom].name + "\t" + move[nom].year + "��" + "\t" + move[nom].country + "\t" + move[nom].janr + "\t" + move[nom].price+"���");
        }
        else System.out.println("��� ����� ���� � ������");
    }
}
