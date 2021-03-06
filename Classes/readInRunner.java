import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class readInRunner {
	
	public static ElemList elementList = new ElemList();
	private EquatList equationList = new EquatList();
	
	public void readInFormulas() throws IOException{
		
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
		public void formulaTokenizer(String arrayList) throws IOException{ //will be called in readFile method and filled
	
			StringTokenizer st = new StringTokenizer(arrayList,",",false);
			
	
			MolecList reactants = new MolecList();
			MolecList products = new MolecList();
			String number = st.nextToken();
			number = null;
			for (int i = 0; i < 2; i++) {
				String s = st.nextToken();
				if (s != "-") {
					reactants.add(new Molecule(s));
				}
			}
			for (int i = 0; i < 3; i++) {
				String s = st.nextToken();
				if (s != "-") {
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
		
			//Element(int number, int neutrons, double atomicMass, String code, String name)
			//Symbol,Name,Atomic_Number,Atomic_Mass,Neutrons,Protons,Electrons
			StringTokenizer st = new StringTokenizer(arrayList,",");
			
			String code = st.nextToken();
			String name = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			double atomicMass = Double.parseDouble(st.nextToken());
			int neutrons = Integer.parseInt(st.nextToken());
			
			elementList.add(new Element(number, neutrons, atomicMass, code, name));	
		}
		
		public static void main(String[] args) throws IOException {
			readInElements();
			for (Element e: elementList) {
				System.out.println(e.getName());
			}
		}
}
