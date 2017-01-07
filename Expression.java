public class Expression{
    int type; //NUMBER = 1, VARIABLE = 2, BINOP = 3
    int value; // for type=NUMBER
    char varName; //for type=VARIABLE
    char binopName; //for type=BINOP
    Expression leftOp;
    Expression rightOp;
}
