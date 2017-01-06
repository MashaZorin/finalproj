public class PolyTokens{
    private String str;
    private String[] tokens;
    private int currentIndex;
    
    public PolyTokens(String str){
	this.str = str;
	currentIndex = 0;
	int index = 0;
	for (int i = 0; i < str.length(); i ++){
	    String token = "";
	    if (Character.IsDigit(str.charAt(i))){
		while (Character.IsDigit(str.charAt(i))){
		    token += str.charAt(i);
		    i ++
		}
		tokens[index] = token;
	    }
	    else if (str.charAt(i) != ' '){
		tokens[index] = "" + str.charAt(i);
	    }
	}
    }

    public boolean hasMoreTokens(){
	if (currentIndex < tokens.length){
	    return true;
	}
	else{
	    return false;
	}
    }

    public String nextToken(){
	String out = tokens[currentIndex};
	currentIndex ++;
	return out;
    }
}
