package lesson1;
public class ChangePlace {
    public static void main(String[] args) {
        String[] massive = {"a", "b", "c", "d", "f"};
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + "\t");
        }
        System.out.println();
        int n = massive.length;
        String reversMassivi;

        for (int i = 0; i < n / 2; i++) {
            reversMassivi = massive[n - i - 1];
            massive[n - i - 1] = massive[i];
            massive[i] = reversMassivi;
        }

        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + "\t");
        }
    }
}

