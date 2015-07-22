import java.io.*;
import java.util.*;
/**
 * The texReader class implements the reading of the file and also writing of a new file 
 * it also contains the methods needed to determine the uniqueness of the words in the file 
*/
public class textReader 
{
	/*
	 * ListOfWords is an array list that holds uniqueWords
	 * uniqueWords holds the amount of unique words per line with inteers 
	 * medianOfUniqueWords holds the median of unique words in each line 
	 * scanner and lineScan will remove and hold the text from the file
	 * textscan holds each word from a text
	 * linewrite writes text into files 
	 * linewrite2 writes text into files 
	 */
	private List<uniqueWord> listOfWords = new ArrayList<uniqueWord>();
	private List<Integer> uniqueWords = new ArrayList<Integer>();
	private List<Float> medianOfUniqueWords = new ArrayList<Float>();
	private Scanner textScan;
	private Scanner lineScan;
	private Formatter lineWrite;
	private Formatter lineWrite2;
	
	/*
	 * openFile opens the required file and stores it in a scanner type
	 */
	public void openFile(String fileName)	
	{
		try
		{
			
			textScan = new Scanner(new File(fileName));
			
		}
		catch (Exception error)
		{
			System.out.println("could not find file");
			
		}
	}
	
	 /*
	  * takes a string as argument and returns the amount of spacing in string form 
	  */
     public String spacing (String word)
     {  int maxSpacing = 45;
        int requiredSpacing = maxSpacing - word.length();
        String spacing =" "; 
        
        for (int index = 0; index < requiredSpacing; index++ )
        {
        	
        	spacing = spacing.concat(" ");
        }
    	 return spacing; 
     }
	 /*
	  * writes file into filename specified in argument 
	  */
	 public void writeFile(String fileName){
		 
		 try {
			 lineWrite = new Formatter(fileName);
					
		 }
		 catch (Exception Error)
		 {
			 System.out.println("There is an error");
			 
		 }
		 for(int index = listOfWords.size()-1; index >= 0; index--)
		 {
			 String statLine = (listOfWords.get(index).getWord() + spacing(listOfWords.get(index).getWord())+ listOfWords.get(index).getCount() );
			 
			 lineWrite.format("%s%n%n",  statLine );
			 
		 }
		 
 
	 }
	 /*
	  * writes file into filename specified in argument 
	  */
	 public void writeFile2(String fileName)
	 {
		 try {
			 lineWrite2 = new Formatter(fileName);
					
		 }
		 catch (Exception Error)
		 {
			 System.out.println("There is an error");
			 
		 }
		 for(int index = 0; index < medianOfUniqueWords.size(); index++)
		 {
			 lineWrite2.format("%s%n", " "+medianOfUniqueWords.get(index));
		 }
	 }
	 
	 /*
	  * finds the median of numbers added in the uniqueWords list and places them in the medianOfuniqueWords list
	  */
	 public void findMedian()
	 {
     	 float sumOfUniqueWords = 0;
		 float median;
			for(int index = 0; index < uniqueWords.size() ; index++)
			{
				
				 for(int index2 = index; index2 >= 0; index2--)
				 {				
					 sumOfUniqueWords = sumOfUniqueWords + uniqueWords.get(index2);					 
				 }
				 median = sumOfUniqueWords/(index+1);
				 medianOfUniqueWords.add(median);
				 sumOfUniqueWords = 0;
			}					
	 }
	
	
	 
	
	/*
	 * uniqueChecker takes a string as input compares it to previous entries in listOfWords and returs true or false if its unique or not 
	 * true if the string is unique 
	 * false if it is not 
	 */
	public boolean uniqueChecker (String b)
	{
		boolean isUnique = true;
		if (listOfWords.isEmpty())
		{
			
			isUnique = true;
		}
	    int listSize = listOfWords.size();
	    for(int index = listSize-1 ; index >= 0 ; index--)
		{
			if (listOfWords.get(index).getWord().equals(b))
			{   
		
				
				listOfWords.get(index).updateCount();
				isUnique = false;
				break;	
			}
			else
			{
				
			}
			
		}
		return isUnique;
	}
	

	/*
	 * sorts the entry of uniqueWords by ascii value
	 */
    private void  uniqueWordsSort(uniqueWord word)
    {
    	
    	if (listOfWords.isEmpty())
    	{
    		listOfWords.add(word);
    	}
    	else{
    		
    			for(int index = listOfWords.size() -1 ; index >= 0 ; index--)
    			{
    				int comparison = listOfWords.get(index).getWord().compareTo(word.getWord());
    				if(comparison >= 0 && index == listOfWords.size() -1 ){
    					listOfWords.add(word);
    					
    					break;
    					
    				}
    				else if(comparison >= 0){
    					
    				   listOfWords.add(index + 1, word);
    				   
    				   break;
    				}
    				else if (index == 0 && !listOfWords.isEmpty() ) {
    					listOfWords.add(index, word);
    					
    					
    					
    				}
    				else{
    					
    				}
    				
    				
    			}
    		
    	}
    }
    
    
    
    /*
     * turns strings read from a file into uniqueWords
     */
	public void formatFile() 
	{
		listOfWords.clear();
		
		while(textScan.hasNext())
		{
			String a = textScan.next();
			uniqueWord word = new uniqueWord(a);
			
			if(uniqueChecker(word.getWord()))
			{
					
			uniqueWordsSort(word);
			}
			else
			{
				
			}
		}
	

	}
	
    
	
	
	/*
	 * readFile2 instead iterates through the lines rather than words held in the scanner and writes the number of unique words into a file
	 */
	public void readFile() 
	{   
		listOfWords.clear();
		while(textScan.hasNext())
		{
			 lineScan = new Scanner(textScan.nextLine());
			
              listOfWords.clear();
			while (lineScan.hasNext())
			{
				
				String b = lineScan.next();
				
				uniqueWord word1 = new uniqueWord(b);
				
				if(uniqueChecker(word1.getWord()))
				{
				
				listOfWords.add(word1);
				
				
				}
				else
				{
					
				}
				
			}
			
			uniqueWords.add(listOfWords.size());
			
			
			
			
		}
		
		findMedian();
		
	}
	
	/*
	 * closes file scanner files 
	 */
	public void closeFile()
	{
		textScan.close();
		lineScan.close();
		lineWrite.close();
		lineWrite2.close();
	}
	
	
	
}
