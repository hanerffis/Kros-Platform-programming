import java.util.Scanner;
class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}
public class Firma {
    public static void  main (String[] args) {
        Scanner sc = new Scanner(System.in,"cp1251");

        System.out.println("Введіть кількість робітників ==>");
        int kol = sc.nextInt();
        sc.nextLine();

        Sotrudnik[] sotr = new Sotrudnik[kol];

        System.out.println("Введіть інформацію про кожного співробітник: ");
        for (int i=0; i<sotr.length;i++){
            sotr[i] = new Sotrudnik();

            System.out.print("Введіть прізвище "+(i+1)+" співробітнка =>");
            sotr[i].fam = sc.nextLine();

            System.out.print("Введіть ім'я =>");
            sotr[i].im = sc.nextLine();

            System.out.print("Введіть його ім'я по батькові =>");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введіть його посаду =>");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("Введіть його оклад =>");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("\nСпівробітники фірми:\n фам\t ім'я\t отчество\t посада\t Оклад");
        for (Sotrudnik s: sotr){
            System.out.println(s.fam+"\t"+s.im+"\t"+s.otch+"\t"+s.doljnost+"\t\t"+s.oklad);
        }
    }
}
