import java.util.Stack;
public class InfixtoPostfix {
    static int priority(char ch) {
        if (ch == '^') {
            return 3;
        }
        else if (ch == '*' || ch == '/') {
            return 2;
        }
        else if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }
    static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        int i = 0;
        int n = s.length();
        while (i < n) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ans = ans + ch;
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans = ans + st.pop();
                }
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else {
                while (!st.isEmpty()
                        && st.peek() != '('
                        && priority(ch) <= priority(st.peek())) {
                    ans = ans + st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while (!st.isEmpty()) {
            ans = ans + st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";
        System.out.println("Infix:   " + s);
        System.out.println("Postfix: " + infixToPostfix(s));
    }
}