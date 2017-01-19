import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Numbers {
    //converting the base stuff:
    private static int convertToBase10(int startbase, int num){
	int baseTen = 0;
	int i = 0;
	while(num > 0){
	    baseTen += (num % 10) * (Math.pow(startbase, i));
	    num = num / 10;
	    i ++;
	}
	return baseTen;
    }

    private static int highestPower(int endbase, int num){
	int i = 0;
	while(Math.pow(endbase, i) <= num){
	    i ++;
	}
	return i - 1;
    }

    private static int convertFromBase10(int endbase, int num){
	int finalNum = 0;
	for (int i = highestPower(endbase, num); i >= 0; i --){
	    int digit = 0;
	    while (highestPower(endbase, num) == i){
		if (num - Math.pow(endbase, i) >= 0){
		    num -= Math.pow(endbase, i);
		    digit ++;
		}
	    }
	    finalNum += digit * (Math.pow(10, i));
	}
	return finalNum;
    }

    public static String convertBase(String startbase, String endbase, String n){
	int startBase = Integer.parseInt(startbase);
	int endBase = Integer.parseInt(endbase);
	int num = Integer.parseInt(n);
	int baseTen = convertToBase10(startBase, num);
	return "" + convertFromBase10(endBase, baseTen);
    }

    //prime factorization stuff:
    private static int largestFactor(int num){
	for (int i = num - 1; i >= Math.sqrt(num); i --){
	    if (num % i == 0){
		return i;
	    }
	}
	return 1;
    }
    
    public static String primeFactorize(String n){
	int num = Integer.parseInt(n);
	String factor = "";
	int largest = largestFactor(num);
	int smallest = num / largest;
	ArrayList<String> primes = new ArrayList<String>();
	if (largest == 1){
	    primes.add("" + num);
	}
	while (largest != 1){
	    primes.add("" + smallest);
	    smallest = largest / largestFactor(largest);
	    if (largestFactor(largest) ==  1){
		primes.add("" + largest);
	    }
	    largest = largestFactor(largest);
	}
	for (int i = 0; i < primes.size(); i ++){
	    String prime = primes.get(i);
	    int pow = 0;
	    while (i < primes.size() && (primes.get(i)).equals(prime)){
		pow ++;
		i ++;
	    }
	    factor = factor + prime + "^" + pow + " * ";
	    i --;
	}
	factor = factor.substring(0, factor.length() - 3);
	return factor;
    }

    public static String add(double[] nums) {
	double sum = 0;
	for(int i = 0; i < nums.length; i++) {
	    sum += nums[i];
	}
	return "" + sum;
	
    }
    //TODO change this to use add so you can use an array
    public static String subtract(String x, String y) {
	double num1 = Double.parseDouble(x);
	double num2 = Double.parseDouble(y);
	double sum = num1 - num2;
	return "" + sum;
	
    }

    public static String multiply(double[] nums) {
	double product = 1;
	for(int i = 0; i < nums.length; i++) {
	    product *= nums[i];
	}
	return "" + product;
	
    }

    //TODO change this to use multiply
    public static String divide(String x, String y) {
	double num1 = Double.parseDouble(x);
	double num2 = Double.parseDouble(y);
	double product = num1 / num2;
	return "" + product;
	
    }
  
    public static String arithmetic(String expression) {
        String[] split = expression.split("\\s+");
	ArrayList<String> terms = new ArrayList<String>();
	for(int i = 0; i < split.length; i++) {
	    terms.add(split[i]);
	}
	terms.add(0, "a");
	terms.add("b");
	double soFar = Double.parseDouble(terms.get(1));
        for(int i = 0; i < terms.size(); i++) {
	    if(terms.get(i).equals("*")) {
		double[] nums = {Double.parseDouble(terms.get(i-1)), Double.parseDouble(terms.get(i+1))};
		soFar = Double.parseDouble(multiply(nums));
		terms.remove(i+1);
		terms.remove(i);
		terms.remove(i-1);
		terms.add((i-1),"" + soFar);
	    }
	    else if(terms.get(i).equals("/")) {
	    	soFar = Double.parseDouble(divide(terms.get(i-1), terms.get(i+1)));
		terms.remove(i+1);
		terms.remove(i);
		terms.remove(i-1);
		terms.add((i-1),"" + soFar);
	    }
	}
	for(int i = 0; i < terms.size(); i++) {
	    if(terms.get(i).equals("+")) {
		double[] nums = {Double.parseDouble(terms.get(i-1)),Double.parseDouble(terms.get(i+1))};
		soFar =  Double.parseDouble(add(nums));
		terms.remove(i+1);
		terms.remove(i);
		terms.remove(i-1);
		terms.add((i-1),"" + soFar);
	    }
	    else if(terms.get(i).equals("-")) {
		soFar = Double.parseDouble(subtract(terms.get(i-1), terms.get(i+1)));
		terms.remove(i+1);
		terms.remove(i);
		terms.remove(i-1);
		terms.add((i-1),"" + soFar);
	    }
	}
	return "" + soFar;
    }
    //need a program to get int[] coeffs
    //remember to add 0s

    //degree of polynomial 
    public static String degree(int[] coeffs) {
	//3x^2 + 3x + 4 -> [3,3,4] length of 3
	int d = coeffs.length - 1;
	return "" + d;
    }

    public static String poly(String eqns, int a) {
	String[] split = eqns.split("\\s+");
	String eqn1 = "a" + split[0] + "b";
	String eqn2 = "a" + split[1] + "b";
	ArrayList<String> powers = new ArrayList<String>();
	for (int i = 0; i < eqns.length(); i++){
	    if (eqns.charAt(i) == '^'){
		powers.add("" + eqns.charAt(i + 1));
	    }
	}
	int highestPower = 0;
	for (int i = 0; i < powers.size(); i ++){
	    if (Integer.parseInt(powers.get(i)) > highestPower){
		highestPower = Integer.parseInt(powers.get(i));
	    }
	}
	int[] f = new int[highestPower + 1];
	int[] g = new int[highestPower + 1];
	int findex = 0;
	for (int i = 0; i < eqn1.length(); i++) {
	    if(eqn1.charAt(i) == 'x' || eqn2.charAt(i) == 'b') {
		int iHateBigNums = 1;
		while(Character.isDigit(eqn1.charAt(i-iHateBigNums)) == true) {
		    iHateBigNums++;
		}
	        int index =  i - iHateBigNums + 1;
		f[findex] = Integer.parseInt(eqn1.substring(index,i));
		findex++;
	    }
	}

	int gindex = 0;
	for (int i = 0; i < eqn2.length(); i++) {
	    if(eqn2.charAt(i) == 'x' || eqn2.charAt(i) == 'b') {
		int iHateBigNums = 1;
		while(Character.isDigit(eqn2.charAt(i-iHateBigNums)) == true) {
		    iHateBigNums++;
		}
	        int index = i - iHateBigNums + 1;
		g[gindex] = Integer.parseInt(eqn2.substring(index,i));
		gindex++;
	    }

	}
	/*
	int[] f = new int[4];
	int[] g = new int[4];
	f[0] = Integer.parseInt("" + eqns.charAt(0));
	f[1] = Integer.parseInt("" + eqns.charAt(5));
	f[2] = Integer.parseInt("" + eqns.charAt(10));
	f[3] = Integer.parseInt("" + eqns.charAt(15));
	g[0] = Integer.parseInt("" + eqns.charAt(17));
	g[1] = Integer.parseInt("" + eqns.charAt(22));
	g[2] = Integer.parseInt("" + eqns.charAt(27));
	g[3] = Integer.parseInt("" + eqns.charAt(32));
	*/
	/*
	int i = 0;
	int j = 0;
	Scanner s = new Scanner(eqns);
	while(s.hasNextInt()){
	    if(i < 8 && (i%2 == 0 || i == 7)) {
		f[j] = s.nextInt();
		j++;
	    }else if(i > 8 && (i%2 == 0 || i == 7)) {
		g[j] = s.nextInt();
		j++;
	    }
	    i++;
	}
	s.close();
	*/

	if(a == 0) {
	    return addPoly(f, g);
	}else{
	    return subPoly(f, g);
	}

    }
    //so far only works if theyre even in length
    //todo make the - thing better like instead of + -1 itll just be -1

    public static String addPoly(int[] f, int[] g) {
	int[] h = new int[f.length];
	String ans = "";
	for(int i = 0; i < f.length; i++) {
	    h[i] = f[i] + g[i];
	}
	for(int j = 0; j < h.length; j++) {
	    int power = Integer.parseInt(degree(h)) - j;
	    if(power != 0) {
		 ans += h[j] + "x^" + power;
	    }else {
		ans += h[j];
	    }
	    if(j+1 < h.length) {
		ans += " + ";
	    }
	   
	}
	return ans;
    }

    public static String subPoly(int[] f, int[] g) {
	int[] h = new int[f.length];
	String ans = "";
	for(int i = 0; i < f.length; i++) {
	    h[i] = f[i] - g[i];
	}
	for(int j = 0; j < h.length; j++) {
	    int power = Integer.parseInt(degree(h)) - j;
	    if(power == 0) {
		ans += h[j];
	    }else {
		ans += h[j] + "x^" + power;
	    }
	    if(j+1 < h.length) {
		ans += " + ";
	    }
	}
	
	return ans;
	
    }	


    public static void main(String[] args) {
	/*
	System.out.println(arithmetic("3 + 4 * 2"));
	System.out.println(arithmetic("3 * 2 + 4"));
	System.out.println(arithmetic("3 - 4 * 2"));
	System.out.println(arithmetic("3 / 4 * 2"));
	System.out.println(arithmetic("3 + 4 / 2"));
	System.out.println(arithmetic("3 / 4 - 2"));
	*/
	System.out.println(poly("2x^3+3x^2+3x+1 8x^3+2x^2+7x+6", 0));
    }

} 
