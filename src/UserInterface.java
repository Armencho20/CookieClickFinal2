import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private ArrayList<String> w;

    public UserInterface(Scanner i) {
        this.sc = i;
        this.w = new ArrayList<String>();
    }

    public void start() {
        while (true) {
            System.out.println("Enter a word, kid: ");
            String wd = sc.nextLine();
            if (duplicateWord(wd)) {
                System.out.println("you cant enter that twice bud");
                for (String x : w) {
                    System.out.println(x);
                }
                break;
            }
            this.w.add(wd);
        }
    }

    private boolean duplicateWord(String wd) {
        return this.w.contains(wd);
    }
}
