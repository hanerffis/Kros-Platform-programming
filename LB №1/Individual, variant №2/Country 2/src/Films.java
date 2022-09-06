import java.util.Arrays;
import java.util.Scanner;

class Film{
    String name,country,janr; //   Назва, країна, жанр
    int year,price; // Рік випуску, вартість
}

public class Films {
    public static void main (String[] args ) {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("Введіть кількість фільмів =>");
        int n = sc.nextInt(); // Кількість фільмів
        Film move[] = new Film[n];
        System.out.println("Введіть інформацію про кінофільми: ");

        for (int i = 0; i < move.length; i++) {
            sc.nextLine();
            move[i] = new Film();

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
        }
        //Виведення отриманої інформації
        System.out.println("\nХарактеристика країн:");
        for (int i = 0; i < move.length; i++) {
            System.out.println("" + move[i].name + "\t" + move[i].year + "рік" + "\t" + move[i].country + "\t" + move[i].janr + "\t" + move[i].price+"грн");
        }

        //Фільм з ціною бульше середьної
        double s=0;
        for(int i =0; i< move.length;i++)
            s+= move[i].price;
        double sr=s/move.length;
        System.out.println("\nФільм з ціною бульше середьної");

        for (int i=0;i< move.length;i++){
            if(move[i].price>sr)
                System.out.println("" + move[i].name + "\t" + move[i].year + "рік" + "\t" + move[i].country + "\t" + move[i].janr + "\t" + move[i].price+"грн");
        }
        System.out.println("Середня вартість прокату="+sr);

        //Фільм найдавнішого року випуску
        int nommax = 0;
        double max = move[nommax].year;
        for(int i=0; i<move.length;i++) if (move[i].year<max){
            max = move[i].year;
            nommax = i;
        }
        System.out.println("\nФільм найдавнішого року випуску: ");
        System.out.println("" + move[nommax].name + "\t" + move[nommax].year + "рік" + "\t" + move[nommax].country + "\t" + move[nommax].janr + "\t" + move[nommax].price+"грн");

        //Сортуванная країн за назвою
        for (int i = 0; i < move.length - 1; i++)
            for (int j = 0; j < move.length - i - 1; j++)
                if (move[j].name.compareTo(move[i+1].name)>0){
                    Film rab=move[j];
                    move[j]=move[j+1];
                    move[j+1]=rab;
                }
        System.out.println("\nВідсортованій список за назвою:");
        for (int i=0;i< move.length;i++){
            System.out.println("" + move[i].name + "\t" + move[i].year + "рік" + "\t" + move[i].country + "\t" + move[i].janr + "\t" + move[i].price+"грн");
        }

        //Пошук за назвою
        sc.nextLine();
        System.out.println("Введіть назву шуканого фільму ");
        String name = sc.nextLine();
        int nom=-1;
        for(int i=0;i< move.length;i++)
            if(name.equalsIgnoreCase(move[i].name))nom=i;
        if(nom!=-1){
            System.out.println("Така країна є у списку. Це " + move[nom].name + "\t" + move[nom].year + "рік" + "\t" + move[nom].country + "\t" + move[nom].janr + "\t" + move[nom].price+"грн");
        }
        else System.out.println("Такї країни немає у списку");
    }
}
