import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Calculus{
    private static void convertPoly(String poly){
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
    }
    
    public static String derivative(String f){
	return "";
    }

    private static void printAry(int[] ary){
	System.out.println(Arrays.toString(ary));
    }

    public static void main(String[]args){
	//printAry(convertPoly("x^2 + x^1"));
	//printAry(convertPoly("x^2 + 3x^4 - 4x^0"));
	convertPoly("x^2 + 34x^4 + 3");
    }
}
