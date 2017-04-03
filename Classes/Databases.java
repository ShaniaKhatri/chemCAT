import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * The abstract <code>Databases</code> class stores the databases of element, molecule, and equation
 * information. Databases are stored in <code>ElemList</code>, <code>MolecList</code>, and 
 * <code>EquatList</code> objects (all extensions of the <code>ArrayList</code> class).
 * @author Justin
 *
 */
public class Databases {
	public static ElemList elementList = new ElemList();
	public static EquatList equationList = new EquatList();
	
	public static void readInFormulas() throws IOException{
		
		FileReader readFile = new FileReader("PrototypeDatabase-Formulas.csv");
		BufferedReader inFile = new BufferedReader(readFile);
			
		
		String header = inFile.readLine(); // try to read one line and store it in a string
		String inputString = inFile.readLine();
		header = null;
		
		//checks for null string
		while (inputString != null){
				
			formulaTokenizer(inputString);
			inputString = inFile.readLine(); // try to read one line and store it in a string
		}

		inFile.close(); //ALWAYS CLOSE FILE
	}	
	
	//string tokenizer. takes input from file and breaks it into tokens.
	//tells Java that each grouping of 4 variables(String, String, String, String) is an inputted equation
	public static void formulaTokenizer(String arrayList) throws IOException{ //will be called in readFile method and filled
	
		StringTokenizer st = new StringTokenizer(arrayList,",",false);
			
	
		MolecList reactants = new MolecList();
		MolecList products = new MolecList();
		String number = st.nextToken();
		number = null;
		for (int i = 0; i < 2; i++) {
			String s = st.nextToken();
			if (!s.equals("-")) {
				reactants.add(new Molecule(s));
			}
		}
		for (int i = 0; i < 3; i++) {
			String s = st.nextToken();
			if (!s.equals("-")) {
				products.add(new Molecule(s));
			}
		}
		equationList.add(new Equation(reactants, products));
	
	}
	
	public static void readInElements() throws IOException{
		
		FileReader readFile = new FileReader("PrototypeDatabase-Elements.csv");
		BufferedReader inFile = new BufferedReader(readFile);
				
			
		String header = inFile.readLine(); // try to read one line and store it in a string
		String inputString = inFile.readLine();
		header = null;
		
		//checks for null string
		while (inputString != null){
			elementTokenizer(inputString);
			inputString = inFile.readLine(); // try to read one line and store it in a string
		}

		inFile.close(); //ALWAYS CLOSE FILE
	}	
		
		//string tokenizer. takes input from file and breaks it into tokens.
		//tells Java that each grouping of 4 variables(String, String, String, String) is an inputted equation
	public static void elementTokenizer(String arrayList) throws IOException{ //will be called in readFile method and filled
		
		StringTokenizer st = new StringTokenizer(arrayList,",");
		
		String code = st.nextToken();
		String name = st.nextToken();
		int number = Integer.parseInt(st.nextToken());
		double atomicMass = Double.parseDouble(st.nextToken());
		int neutrons = 0;
		
		String s = st.nextToken();
		if (!s.equals("-")) {
			neutrons = Integer.parseInt(s);
		}
		else{
			neutrons = 999;
		}
		String properties = ("\nDensity: " + st.nextToken() + "\nMelting Point: " + st.nextToken() + "\nBoiling Point: "
				 + st.nextToken() + "\nAtomic Radius: "+ st.nextToken()+ "\nCovalent Radius: " + st.nextToken() + "\nHeat Fusion: " + st.nextToken() + "\nHeat Evaporation: " + st.nextToken() + "\nFirst Ionization Energy: " + st.nextToken());
		elementList.add(new Element(number, neutrons, atomicMass, code, name, properties));	
	}
	
}
