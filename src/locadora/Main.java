package locadora;

import locadora.view.MainWindow;

public class Main {
    private static MainWindow window;
    
    public static void main(String[] args) {
        window = new MainWindow();
        window.init();
    }
    
}
