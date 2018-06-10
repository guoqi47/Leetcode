package TestCode;
/**
 * 两个栈完成算数表达式
 */
import java.util.Scanner;
import java.util.Stack;

public class TwoStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> ops = new Stack<Character>();
		Stack<Double> vals = new Stack<Double>();
		Scanner s = new Scanner(System.in);
//		System.out.println(s.nextLine());
		
		String string1 = s.nextLine();
		char[] c = string1.toCharArray();
		for(char c1:c) {
			if		(c1=='(')			;
			else if(c1=='+')	ops.push(c1);
			else if(c1=='-')	ops.push(c1);
			else if(c1=='*')	ops.push(c1);
			else if(c1=='/')	ops.push(c1);
			else if(c1==')') {
				double d1 = vals.pop();
				char op = ops.pop();
				if(op=='+')	vals.push(d1+vals.pop());
				if(op=='-')	vals.push(d1-vals.pop());
				if(op=='*')	vals.push(d1*vals.pop());
				if(op=='/')	vals.push(d1/vals.pop());
			}
			else vals.push((double)(c1-'0'));
//			System.out.println(vals.pop());
		}
		System.out.println(vals.pop());
		s.close();
//		System.out.println(Double.valueOf('1'));
	}

}
