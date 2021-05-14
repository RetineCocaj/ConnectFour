public class TestConnect4 {
    public TestConnect4() {
        Connect4Model model = new Connect4Model();
        Connect4Drawing drawing = new Connect4Drawing(model);
        Connect4Frame view = new Connect4Frame(model,drawing);
    }

    public static void main(String[] args) {
        new TestConnect4();
    }
}
