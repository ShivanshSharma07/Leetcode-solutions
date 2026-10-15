import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int ans = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            else if (c == '+') {
                ans += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                st.push(ans);
                st.push(sign);
                ans = 0;
                sign = 1;
            }
            else if (c == ')') {
                ans += sign * num;
                num = 0;

                ans *= st.pop();
                ans += st.pop();
            }
        }

        ans += sign * num;
        return ans;
    }
}