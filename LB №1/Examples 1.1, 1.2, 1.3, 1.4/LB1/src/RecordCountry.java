import java.util.Scanner;
import java.lang.Math;

class Strana{
    String name; //   Назва
    double square; // Площя
}

public class RecordCountry {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in,"cp1251");

        //Введення інформації
        System.out.println("Введіть калькість країн ");
        int n=sc.nextInt(); // Кількість країн
        Strana country[]=new Strana[n];
        System.out.println("Введіть інформацію про крахні: ");

        for (int i=0; i < country.length;i++){
            sc.nextLine();
            country[i] = new Strana();
            System.out.print("Назва "+(i+1)+"-ї країни=> ");
            country[i].name=sc.nextLine();
            System.out.print("Площя "+(i+1)+"-ї країни=> ");
            country[i].square=sc.nextDouble();
        }

        //Виведення отриманої інформації
        System.out.println("\nХарактеристика країн:");
        for(int i=0;i< country.length;i++){
            System.out.println(""+country[i].name+"\t"+country[i].square+"млн.кв.км");
        }

        //Країна з максимальною площею
        int nommax = 0;
        double max = country[nommax].square;
        for(int i=0; i<country.length;i++) if (country[i].square>max){
            max = country[i].square;
            nommax = i;
        }
        System.out.println("\nКраїна з максимальною площею: ");
        System.out.println(""+country[nommax].name+"\t"+country[nommax].square+"млн.кв.км");

        //Сортування за площею
        for (int i=0; i < country.length - 1; i++)
            for (int j =0; j < country.length-1-i;j++)
                if(country[j].square>country[j+1].square){
                    Strana rab =country[j];
                    country[j] = country[j+1];
                    country[j+1] = rab;
                }
        System.out.println("\nВідсортований список за площею: ");
        for (int i = 0;i< country.length;i++){
            System.out.println(""+country[i].name+"\t"+country[i].square+"млн.кв.км");
        }

        //Сортуванная країн за назвою
        for (int i = 0; i < country.length - 1; i++)
            for (int j = 0; j < country.length - i - 1; j++)
                if (country[j].name.compareTo(country[i+1].name)>0){
                    Strana rab=country[j];
                    country[j]=country[j+1];
                    country[j+1]=rab;
                }
        System.out.println("\nВідсортованій список за назвою:");
        for (int i=0;i< country.length;i++){
            System.out.println(""+country[i].name+"\t"+country[i].square+"млн.кв.км");
        }

        //Площя більше середьної
        double s=0;
        for(int i =0; i< country.length;i++)
            s+= country[i].square;
        double sr=s/country.length;
        System.out.println("Середня площя="+sr);
        System.out.println("\nКраїни з площеб бульше середьної");
        for (int i=0;i< country.length;i++){
            if(country[i].square>sr)
                System.out.println(country[i].name+"\t"+country[i].square+"млн.кв.км");
        }

        //Пошук за назвою
        sc.nextLine();
        System.out.println("Введіть назву шуканої країни ");
        String name = sc.nextLine();
        int nom=-1;
        for(int i=0;i< country.length;i++)
            if(name.equalsIgnoreCase(country[i].name))nom=i;
        if(nom!=-1){
            System.out.println("Така країна є у списку. Це "+country[nom].name +""
                    +country[nom].square+"млн.кв.км");
        }
        else System.out.println("Такї країни немає у списку");
    }
}
