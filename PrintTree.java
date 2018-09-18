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
        for (char c : input.toCharArray()) {
            switch (c) {
                case '[':
                    indent++;
                    break;
                case ']':
                    indent--;
                    break;
                case ',':
                    continue;
                case ' ':
                    sb.appent("\n"); // insert newline
                    afterIndent = true; // need indents after new line
                    break;
                default:
                    // Only insert indents after new lines
                    if (afterIndent) {
                        for (int i = 0; i < indent; i++) {
                            sb.append("  "); // 2-space indents
                        }
                        afterIndent = false;
                    }
                    sb.append(c); // Append actual char
                    break;
           }
        }

        // If indent is not back to -1 then something was invalid.
        if (indent != -1) {
            throw new Exception("error: mismatched brackets!");
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
