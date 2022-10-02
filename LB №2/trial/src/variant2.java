import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serial;

public class variant2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Мартица:");
        int[][] matrice = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 8 ,1 ,2},
                {3, 4, 5, 6, 7, 1},
                {1, 5, 3, 9, 6, 6},
                {9, 8, 7, 8 ,3 ,2},
                {8, 4, 3, 4, 7, 3}
            };


        for (int t=0; t<matrice.length;t++){
            for (int y=0; y<matrice[t].length;y++){
                System.out.print(matrice[t][y]+" ");
            }
            System.out.println();
        }

        //int a = sc.nextInt();
        try{
            System.out.print ("Введите номер желаемого столбца:");
            int a = sc.nextInt();
            int size = matrice.length;
            int[] My0 = new int[size]; //My0 = {1, 2, 3}
            System.out.println("Желаемый столбец");
            for (int i=0;i<size;i++){
                My0[i] = matrice[a-1][i];
                System.out.print(My0[i]+" ");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("За границами матрицы. Выбери число от 1 до "+ matrice.length);
            System.out.print("\033[H\033[J");
            main(args);
        }catch (InputMismatchException e) {
            System.out.println("Ты ввёл не число!Выбери число от 1 до "+ matrice.length);
            System.out.print("\033[H\033[J");
            main(args);
        }finally {
            System.exit(2);
        }
    }
}
