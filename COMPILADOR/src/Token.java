public class Token
{
    private int id;
    private String lexeme;
    private int position;

    public Token(int id, String lexeme, int position)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        return lexeme;
    }

    public final int getPosition()
    {
        return position;
    }

    public String toString()
    {
        return id+" ( "+lexeme+" ) @ "+position;
    };
    
    public String porExtenso(int id) {
    	switch (id) {
    	case 1:
    		return "EOF\t\t";
    	case 3: case 4: case 5: case 6:
    		return "identificador\t";
    	case 7:
    		return "constante int\t";
    	case 8:
    		return "constante float";
    	case 9:
    		return "constante string";
    	case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18:
    	case 19: case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27:
    		return "palavra reservada";
    	case 28: case 29: case 30: case 31: case 32: case 33: case 34: case 35: case 36:
    	case 37: case 38: case 39: case 40: case 41: case 42: case 43:
    		return "simbolo especial";
    	default:
    		return null; //vai dar erro no programa -> palavra reservada invalida
    		}
    	}
    }
