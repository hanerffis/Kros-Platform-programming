import java.util.Scanner;
class Sotrudnik2{
    String fam, im, otch, doljnost;
    int kolDet;
    Rebenok []reb = null;
}
class Rebenok{
    String imaR;
    int vozrastR;
}

public class Firma2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in,"cp1251");
        System.out.println("������ ������� �������� ==> ");
        int kol = sc.nextInt();
        sc.nextLine();

        Sotrudnik2[] sotr = new Sotrudnik2[kol];
        System.out.println("������ ���������� ��� ������� ��������: ");
        for (int i=0;i< sotr.length;i++){
            sotr[i] = new Sotrudnik2();

            System.out.print("������ ������� "+(i+1)+" ���������� => ");
            sotr[i].fam = sc.nextLine();

            System.out.print("������ ��'� =>");
            sotr[i].im = sc.nextLine();

            System.out.print("������ ��'� �� ������� =>");
            sotr[i].otch = sc.nextLine();

            System.out.print("������ ���� ������ =>");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("������ ������� ���� =>");
            sotr[i].kolDet = sc.nextInt();
            sc.nextLine();

            if (sotr[i].kolDet!= 0) {
                sotr[i].reb=new Rebenok[sotr[i].kolDet];
                System.out.println("ĳ�� =>");
                for(int j = 0; j < sotr[i].reb.length;j++){
                    sotr[i].reb[j] = new Rebenok();

                    System.out.print("������ ��'� " + (j+1) +" ������");
                    sotr[i].reb[j].imaR =sc.nextLine();

                    System.out.print("������ ���� �� =>");
                    sotr[i].reb[j].vozrastR = sc.nextInt();
                    sc.nextLine();
                }
            }
        }
        System.out.println("\n����������� ����� \n ��� \t ��� \t ��� \t ������");
        for (Sotrudnik2 s: sotr){
            System.out.print(s.fam + "\t" +s.im+ "\t" +s.otch+ "\t" +s.doljnost);
            System.out.println("\nĳ��: ");
            for(Rebenok r: s.reb) {
                System.out.println("\t\t" + r.imaR + "\t\t" + r.vozrastR);
                System.out.println("");
            }
        }
    }
}


