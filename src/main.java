
public class main {
	
	public static void main(String[] args) 
	{
		textReader text = new textReader();
		text.openFile("words.txt");
		text.formatFile();
		text.writeFile("ft1.txt");
		
		
		
		
		
		text.openFile("words.txt");
		text.readFile();
		text.writeFile2("ft2.txt");
		text.closeFile();
		
        
		
	}

}
