import java.util.Stack;
class basic_operations {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println("Top: " + st.peek());
        System.out.println("Removed: " + st.pop());
        System.out.println("Is empty: " + st.isEmpty());
        System.out.println("Size: " + st.size());
    }
}