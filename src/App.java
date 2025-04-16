import mvc.*;
import plague.*;

public class App {
    public static void main(String[] args) throws Exception {
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
