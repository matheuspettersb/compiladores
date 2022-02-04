import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Semantico implements Constants {
	String operador = "";
	String codigo = "";
	Stack<String> pilhaTipos = new Stack();
	List<String> listaId = new ArrayList<String>();
	Stack<Integer> pilhaRotulos = new Stack();
	int rotulo =1;

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
		switch (action) {
		
		case 1:
			String tipo1, tipo2;
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			
			if (!tipo1.equals("int64") && !tipo1.equals("float64")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}
			if (!tipo2.equals("int64") && !tipo2.equals("float64")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}
			
			if (tipo1.equals("float64") || tipo2.equals("float64")) {
				pilhaTipos.push("float64");
			} else {
				pilhaTipos.push("int64");
			}
			
			codigo += "\nadd";
			break;
		
		case 2:
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			if (!tipo1.equals("int64") && !tipo1.equals("float64")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}
			if (!tipo2.equals("int64") && !tipo2.equals("float64")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}

			if (tipo1.equals("float64") || tipo2.equals("float64")) {
				pilhaTipos.push("float64");
			} else {
				pilhaTipos.push("int64");
			}
			
			codigo += "\nsub";
			break;
			
		case 3:
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			if (!tipo1.equals("int64") && !tipo1.equals("float64")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}
			if (!tipo2.equals("int64") && !tipo2.equals("float64")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}

			if (tipo1.equals("float64") || tipo2.equals("float64")) {
				pilhaTipos.push("float64");
			} else {
				pilhaTipos.push("int64");
			}
			
			codigo += "\nmul";
			break;
			
		case 4:
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			// perguntar se n tem que virar float64
			if (tipo1 == tipo2) {
				pilhaTipos.push(tipo1);
			} else {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}
			
			codigo += "\ndiv";
			break;
		
		case 5:
			pilhaTipos.push("int64");
			codigo += "\nldc.i8 " + token.getLexeme();
			codigo += "\nconv.r8";
			break;
			
		case 6:
			pilhaTipos.push("float64");
			codigo += "\nldc.r8 " + token.getLexeme();
			break;
			
		case 7:
			String tipo = pilhaTipos.pop();
			if (tipo.equals("float64") || tipo.equals("float64")) {
				pilhaTipos.push(tipo);
				} else {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}

			break;
			
		case 8:
			tipo = pilhaTipos.pop();
			if(tipo.equals("float64") || tipo.equals("int64")) {
				pilhaTipos.push("float64");
			} else {
				throw new SemanticError("tipo(s) incompatível(is) em expressão aritimética");
			}

			codigo += "\nldc.i8 -1";
			codigo += "\nconv.r8";
			codigo += "\nmul";

			break;
		
		case 9:
			operador = token.getLexeme();
			break;
			
		case 10:
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			
			if (tipo1.equals("string") && !tipo2.equals("string"))
				throw new SemanticError("tipos incompatíveis em expressão relacional");
			if (!tipo1.equals("string") && tipo2.equals("string"))
				throw new SemanticError("tipos incompatíveis em expressão relacional");
			if (tipo1.equals("bool") || tipo2.equals("bool"))
				throw new SemanticError("tipos incompatíveis em expressão relacional");
			if (tipo1.equals("int64|float64") && !tipo2.equals("int64|float64"))
				throw new SemanticError("tipos incompatíveis em expressão relacional");
			if (!tipo1.equals("int64|float64") && tipo2.equals("int64|float64"))
				throw new SemanticError("tipos incompatíveis em expressão relacional");
			
			pilhaTipos.push("bool");
			
			if (operador.equals(">")) {
				codigo += "\ncgt";
			}
			if (operador.equals("<")) {
					codigo += "\nclt";
				}
			if (operador.equals("==")) {
				codigo += "\nceq";
			}
			if (operador.equals("<>")) {
				codigo += 	"\nceq"
							+"\nldc.i4 0"
							+"\nceq";
			}
		
			
			break;
		
		case 11:
			pilhaTipos.push("bool");
			codigo += "\nldc.i4.1";
			break;
			
		case 12:
			pilhaTipos.push("bool");
			codigo += "\nldc.i4.0";
			break;
		
		case 13:
			tipo = pilhaTipos.pop();
			if (tipo.equals("bool")) {
				pilhaTipos.push("bool");
			} else {
				throw new SemanticError("tipo(s) incompatível(is) em expressão lógica");
			}
			codigo += "\nldc.i4.1";
			codigo += "\nxor";
			break;
			
		case 14:
			tipo = pilhaTipos.pop();
			if (tipo == "int64") {
				codigo += "\nconv.i8";
			}
			codigo += ("\ncall void [mscorlib]System.Console::Write(" + tipo + ")");
			break;
			
		case 15:
			codigo += (	"\n.assembly extern mscorlib {}"
						+ "\n.assembly _codigo_objeto{}"
						+ "\n.module   _codigo_objeto.exe");
			
			codigo += ("\n.class public _UNICA{"
						+"\n.method static public void _principal() {" 
						+"\n.entrypoint"); 
			break;
			
		case 16:
			codigo += 	"\nret"
						+"}"
						+"}";
			break;
		
		case 17:
			pilhaTipos.push("string");
			codigo += "\nldstr "+ token.getLexeme();
			break;
		
		case 18:
			pilhaTipos.push("string");
			codigo += "\nldstr \"\\n\"";
			break;
		
		case 19:
			pilhaTipos.push("string");
			codigo += "\nldstr \" \"";
			break;
		
		case 20:
			pilhaTipos.push("string");
			codigo += "\nldstr \"\\t\"";
			break;
			
		case 21:
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			if (!tipo1.equals("bool") || !tipo2.equals("bool")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão lógica");
			}
			pilhaTipos.push("bool");
			codigo += "\nand";
			break;
			
		case 22:
			tipo1 = pilhaTipos.pop();
			tipo2 = pilhaTipos.pop();
			if (!tipo1.equals("bool") || !tipo2.equals("bool")) {
				throw new SemanticError("tipo(s) incompatível(is) em expressão lógica");
			}
			pilhaTipos.push("bool");
			codigo += "\nor";
			break;
			
		case 23:
			for (String s : listaId) {
				if (s.startsWith("I")) {
					codigo += "\n.locals(int64  "+s+")";
				}
				if (s.startsWith("F")) {
					codigo += "\n.locals(float64  "+s+")";
				}
				if (s.startsWith("S")) {
					codigo += "\n.locals(string  "+s+")";
				}
				if (s.startsWith("B")) {
					codigo += "\n.locals(bool  "+s+")";
				}
			}
			listaId.clear();	
			break;
			
		case 24:
			listaId.add(token.getLexeme());
			break;
		
		case 25:		
			if (listaId.get(0).startsWith("I")) {
				codigo+="\nconv.i8";
			}
			codigo += "\nstloc "+listaId.get(0);
			listaId.clear();
			break;
		
		case 27:
			for (String s : listaId) {
				codigo += "\ncall string [mscorlib]System.Console::ReadLine()";
				if (s.startsWith("I")){
					codigo += "\ncall int64 [mscorlib]System.Int64::Parse(string)";
				}
				if (s.startsWith("F")){
					codigo += "\ncall float64 [mscorlib]System.Double::Parse(string)";
				}
				if (s.startsWith("B")){
					codigo += "\ncall bool [mscorlib]System.Boolean::Parse(string)";
				}
			    codigo += "\nstloc "+s;    
			}
			listaId.clear();
			break;

		case 28:
			codigo += "\nbrfalse rotulo"+rotulo;
			pilhaRotulos.push(rotulo);
			rotulo++;
			break;
			
		case 29:
			codigo += "\nrotulo"+pilhaRotulos.pop()+": ";
			break;
			
		case 30:
			codigo += "\nbr rotulo"+rotulo;
			codigo += "\nrotulo"+pilhaRotulos.pop()+": ";
			pilhaRotulos.push(rotulo);
			rotulo++;
			break;
			

			
		case 31:
			codigo += "\nrotulo"+rotulo+": ";
			pilhaRotulos.push(rotulo);
			rotulo++;
			break;
			
		case 32:
			if (token.getLexeme().equals("isFalseDo")) {
				codigo += "\nbrtrue rotulo"+rotulo;
				pilhaRotulos.push(rotulo);
				rotulo++;
			}
			if (token.getLexeme().equals("isTrueDo")) {
				codigo += "\nbrfalse rotulo"+rotulo;
				pilhaRotulos.push(rotulo);
				rotulo++;
			}
			break;
		
		case 33:
			int r = pilhaRotulos.pop();
			codigo += "\nbr rotulo"+pilhaRotulos.pop();
			codigo += "\nrotulo"+r+": ";
			break;
			
		case 34:
			codigo += "\nldloc " + token.getLexeme();
			if (token.getLexeme().startsWith("I")) {
				pilhaTipos.push("int64");
				codigo += "\nconv.r8";
			}
			if (token.getLexeme().startsWith("F")) {
				pilhaTipos.push("float64");
			}
			if (token.getLexeme().startsWith("S")) {
				pilhaTipos.push("string");
			}
			if (token.getLexeme().startsWith("B")) {
				pilhaTipos.push("bool");
			}
			break;
		
		
		default:
			throw new SemanticError("Ação semântica não implementada: " + action);
		}

	}

	public String getCodigo() {
		return codigo;
	}
}
