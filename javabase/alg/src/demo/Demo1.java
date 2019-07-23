package demo;

import java.util.Stack;
public class Demo1 {
    public static void main(String[] args) {
        String s="(1+((2+3)*(4*5)))";
        Stack<String> ops=new Stack<>();
        Stack<Double> vals = new Stack<>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++ ){
            String temp=(""+chars[i]);
            if(temp.equals("("));                       //如果为运算符则入栈
            else if(temp.equals("+")) ops.push(temp);
            else if(temp.equals("-")) ops.push(temp);
            else if(temp.equals("*")) ops.push(temp);
            else if(temp.equals("/")) ops.push(temp);
            else if(temp.equals("sqrt")) ops.push(temp);
            else if(temp.equals(")")) {                  //  符号为 ")"时弹出运算符和操作数，计算结果并压入栈
                String s1=ops.pop();
                Double v=vals.pop();
                if(s1.equals("+")) v= vals.pop() +  v;
                else if(s1.equals("-")) v=vals.pop() -v;
                else if(s1.equals("*")) v=vals.pop() *v;
                else if(s1.equals("/")) v=vals.pop() /v;
                else if(s1.equals("sqrt")) v=Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(temp));    //不是运算符或者括号时，作为double值压入栈
        }
        System.out.println(vals.pop());                  //101.0
    }
}
