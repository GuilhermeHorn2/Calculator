package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main_misc {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String exp =  "2*3+5/6*3+15*2+1-1";
	System.out.println("result: "+calculator(exp));
	

	}
	
	private static double calculator(String expression) {
		
		//1->get the numbers
		ArrayList<Double> numbers = new ArrayList<>();
		ArrayList<String> operators = new ArrayList<>();
		StringBuilder number = new StringBuilder();
		for(int i = 0;i < expression.length();i++) {
			String x = expression.substring(i,i+1);
			if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")){
				numbers.add(Double.parseDouble(number.toString()));
				number = new StringBuilder();
				operators.add(x);
				continue;
			}
			number.append(x);
		}
		numbers.add(Double.parseDouble(number.toString()));

		//System.out.println(numbers);
		
		//2->result
		double result = 0;
		int count_op = 0;
		int count_num = 0;
		double last_num = 0;
		String last_op = "";
		boolean set = false;
		double last_operation = 0;
		
		for(int i = 0;i < numbers.size();i++) {
			
			double num = numbers.get(i);
			double x = num;
			if(count_num == 1) {
				
				String op = operators.get(count_op);
				
				if(op.equals("*")) {
					x = num*last_num;
				}
				if(op.equals("/")) {
					x = last_num/num;
				}
				if(op.equals("+") || op.equals("-")) {
					
					if(!set) {
						last_op = op;
						last_operation = last_num;
					}
					if(set) {
						if(last_op.equals("+")){
							result = last_operation + last_num;
						}
						if(last_op.equals("-")) {
							result = last_operation - last_num;
						}
						last_operation = result;
					
					}
					set = true;
					last_op = op;
					
				}
				count_num = 0;
				count_op++;
			}
			
			last_num = x;
			count_num++;
			
		}
		
		if(last_op.equals("+")){
			result += last_num;
		}
		if(last_op.equals("-")) {
			result -= last_num;
		}
		
		
		return result;
	}
	
	

}
