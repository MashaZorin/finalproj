import java.util.ArrayList;

public class PolyTokens{
    private String str;
    private ArrayList<String> tokens;
    private int currentIndex;
    
    public PolyTokens(String str){
	this.str = str;
	currentIndex = 0;
	tokens = new ArrayList<String>(1);
	for (int i = 0; i < str.length(); i ++){
	    String token = "";
	    char c = str.charAt(i);
	    if (Character.isDigit(str.charAt(i))){
		while (i < str.length() && Character.isDigit(str.charAt(i))){
		    token += str.charAt(i);
		    i ++;
		}
		tokens.add(token);
	    }
	    else if (c == '(' || c == ')' || c == '*' || c == '/' || c == '+' || c == '-' || c == '^' || c == '[' || c == ']'){
		tokens.add("" + c);
	    }
	}
    }

    public boolean hasMoreTokens(){
	if (currentIndex < tokens.size()){
	    return true;
	}
	else{
	    return false;
	}
    }

    public String nextToken(){
	String out = tokens.get(currentIndex);
	currentIndex ++;
	return out;
    }
}
