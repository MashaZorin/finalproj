import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Calculus{
    /*private static void convertPoly(String poly){
	//find how many parts of the poly there are
	int numPowers = 0;
	for (int i = 0; i < poly.length(); i ++){
	    if (poly.charAt(i) == '^'){
		numPowers ++;
	    }
	}
	double[] powers = new double[numPowers + 2]; // add 2 in case of constant or x - they don't get a carrot char
	double[] coef = new double[numPowers + 2];
	//split up polynomial
	PolyTokens str = new PolyTokens(poly);
	while(str.hasMoreTokens()){
	    int index = 0;
	    String next1 = str.nextToken();
	    if (next1.equals("+")){
		String next2 = str.nextToken();
		if (next2.equals("^")){
		    coef[index] = 1;
		    powers[index] = Integer.parseInt(str.nextToken());
		    index ++;
		}
		else if(Character.isDigit(next2.charAt(0))){
		    coef[index] = Integer.parseInt(next2);
		}
		else{
		    //error
		}
	    }
	    if (next1.equals("-")){
		String next2 = str.nextToken();
		if (next2.equals("^")){
		    coef[index] = -1;
		    powers[index] = Integer.parseInt(str.nextToken());
		    index ++;
		}
		else if (Character.isDigit(next2.charAt(0))){
		}
	    }
	    //System.out.println(str.nextToken());
	}
    }
    
    private static String derOfPoly(String poly){
    return "";
    }*/

    private static int getType(String str){
	if (Character.isDigit(str.charAt(0))){
	    return 1; // is a number
	}
	else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^")){
	    return 2; // is a binary operation
	}
	else if (str.equals("(") || str.equals(")")){
	    return 3; // is a parenthasis
	}
	else{
	    return 4; // is a variable
	}
    }
    
    /* public static String derivative(PolyTokens expr){
	//PolyTokens expr = new PolyTokens(f);
	String next1 = expr.nextToken();
	if (expr.hasMoreTokens() && (getType(next1) == 1 || getType(next1) == 4)){
	    String next2 = expr.nextToken();
	    if (!expr.hasMoreTokens()){
		if (getType(next1) == 1){
		    System.out.println(0);
		}
		else{
		    System.out.println(1);
		}
	    }
	    else if (getType(next2) == 2){
		String next3 = expr.nextToken();
		String leftOp = next1;
		String rightOp;
		if (getType(next3) == 1 || getType(next3) == 4){
		    rightOp = next3;
		}
		else{
		    rightOp = derivative(expr);
		}
		PolyTokens left = new PolyTokens(leftOp);
		PolyTokens right = new PolyTokens(rightOp);
		if (next2.equals("+") || next2.equals("-")){
		    derivative(left);
		    System.out.println(" " + next2 + " ");
		    derivative(right);
		}
		else if (next2.equals("*")){
		    derivative(left);
		    System.out.println("*" + rightOp + "+" + leftOp + "*");
		    derivative(right);
		}
		else if (next2.equals("/")){
		    System.out.println("(");
		    derivative(left);
		    System.out.println("*" + rightOp + "-" + leftOp + "*");
		    derivative(right);
		    System.out.println("/" + rightOp + "^2");
		}
		else if (next2.equals("^")){
		    System.out.println(leftOp + "^" + rightOp + "(");
		    derivative(right);
		    System.out.println("*ln(" + leftOp + ") + " + rightOp + "/" + leftOp + "*");
		    derivative(left);
		    System.out.println(")");
		}
		return leftOp + next2 + rightOp;
	    }
	    else if (next2.equals(")")){
		//derivative(next1);
		return next1;
	    }
	}
	else if (next1.equals("(")){
	    derivative(expr);
	}
	else{
	    throw new IllegalArgumentException();
	}
	return "what?";    
	    
	}*/

    public static String[] parseExpr(PolyTokens expr){
    }

    private static String[] parseTerm(PolyTokens term){
    }

    private static String[] parsePower(PolyTokens power){
	String[] both = new String[2];
	String next = power.nextToken();
    }

    private static String[] parsePart(PolyTokens part){
	String[] both = new String[2];
	String next = part.nextToken();
	if (getType(next) == 1){
	    both[0] = next;
	    both[1] = "0";
	}
	else if (getType(next) == 4){
	    both[0] = next;
	    both[1] = "1";
	}
	else if (next.equals("(")){
	    both = parseExpr(part);
	}
	return both;
    }

    private static void printAry(int[] ary){
	System.out.println(Arrays.toString(ary));
    }

    public static void main(String[]args){
	//printAry(convertPoly("x^2 + x^1"));
	//printAry(convertPoly("x^2 + 3x^4 - 4x^0"));
	PolyTokens expr = new PolyTokens("(x^2) + (34x^4) + 3");
	derivative(expr);
    }
}
