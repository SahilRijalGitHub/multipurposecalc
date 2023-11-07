package mainPackage;

import java.util.Stack;

public class Test {
    static Stack<Integer> stack = new Stack<Integer>();
    public static void Testing(){
        stack.push(2);
        try{
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }
        catch (Exception e){
            System.out.println(stack.pop());
            System.out.println("0");
        }
    }
}
