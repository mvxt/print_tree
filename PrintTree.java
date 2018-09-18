public class PrintTree {

    /**
     * printTree method returns the same input string.
     * TODO: implement logic for tree
     *
     * @param input
     * @return
     */
    protected String printTree(String input) throws Exception {
        return input;
    }

    public static void main(String[] args) {
        
        // Just accept one string input at a time
        if (args.length != 1) {
            System.out.println("  usage: java PrintTree STRING");
            return;
        }

        final PrintTree pt = new PrintTree();

        // Catches exceptions and prints "Invalid!"
        try {
            System.out.println(pt.printTree(args[0]));
        } catch (Exception e) {
            System.out.println("Invalid!");
        }
    }
}
