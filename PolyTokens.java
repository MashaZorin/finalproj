public class PolyTokens{
    private String str;
    private String[] tokens;
    
    public PolyTokens(String str){
	this.str = str;
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
    }

    public String nextToken(){
    }
}
