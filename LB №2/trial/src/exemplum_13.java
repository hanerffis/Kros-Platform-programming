public class exemplum_13 {
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("����� ������=" + l);
            int h = 10 / l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {
            System.out.println("ĳ����� �� ����");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("������ �� ����");
        }
    }
}
