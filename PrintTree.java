public class PrintTree {

    /**
     * printTree method iterates through the given string by character
     * and processes the output format based on what char it receives
     *
     * @param input
     * @return
     */
    protected String printTree(String input) throws Exception {
        // Build output string w/ StringBuilder, more efficient
        // than string concat
        final StringBuilder sb = new StringBuilder();

        // Iterate through chars in string. Keep track of indent
        // level outside of the loop. Every instance of delimiter
        // means a new line and re-evaluating tab spacing
        int indent = -1;
        boolean afterIndent = true;

        // Corner case 1: empty list []
        boolean afterOpen = false;
        // Corner case 2: no comma after ]. Anything except comma
        // after close bracket is invalid
        boolean afterClose = false;
        // Corner case 3: no chars before first [
        if (input.charAt(0) != '[') {
            throw new Exception();
        }
        for (char c : input.toCharArray()) {
            switch (c) {
                case '[':
                    if (afterClose) {
                        throw new Exception();
                    }
                    indent++;
                    afterOpen = true;
                    break;
                case ']':
                    indent--;
                    afterClose = true;
                    // corner case 1: empty list
                    if (afteropen) {
                        sb.append(gettabs(indent));
                        afteropen = false;
                    }
                    break;
                case ',':
                    afterOpen = false;
                    afterClose = false;
                    continue;
                case ' ':
                    // Corner case 2
                    if (afterClose) {
                        throw new Exception();
                    }
                    sb.append("\n");
                    afterIndent = true; // need indents after new line
                    afterOpen = false;
                    break;
                default:
                    // Corner case 2
                    if (afterClose) {
                        throw new Exception();
                    }
                    // Only insert indents after new lines
                    if (afterIndent) {
                        sb.append(getTabs(indent));
                        afterIndent = false;
                    }
                    sb.append(c); // Append char + newline
                    afterOpen = false;
                    break;
            }
        }

        // If indent is not back to -1 then something was invalid.
        if (indent != -1) {
            throw new Exception("error: mismatched brackets!");
        }

        return sb.toString();
    }

    /**
     * Helper function to return spaces based on indent level given.
     *
     * @param indent
     */
    private String getTabs(int indent) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  "); // 2-space indents
        }
        return sb.toString();
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
