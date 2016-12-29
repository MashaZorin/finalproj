import java.lang.Math.*;

public class Numbers{
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

    public static int convertBase(int startBase, int endBase, int num){
	int baseTen = convertToBase10(startBase, num);
	return convertFromBase10(endBase, baseTen);
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
    /*
    public static String primeFactorize(int num){
	int largest = largestFactor(num);
	int smallest = num / largest;
	while (largest != 1){
	    
    }
    */
    
    //tests:
    public static void main(String[]args){
	//tests for converting base
	System.out.println(highestPower(10, 16));
	System.out.println(convertFromBase10(10, 16));
	System.out.println(convertBase(2, 10, 10000));
	System.out.println(convertBase(10, 4, 16));
	System.out.println(convertBase(2, 4, 10000));

	//tests for prime factorizing
	System.out.println(largestFactor(10));
    }
	
}
