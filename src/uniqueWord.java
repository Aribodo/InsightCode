/**
 * @author arinzeumemyiora
 *the uniqueWord class creates an object which holds a string and an integer corresponding to its frequency
 */
public class uniqueWord {
private int count = 0;
private String word;

/*
 * constructor with string argument 
 * sets string argument to uniqueWords word
 */
public uniqueWord(String word1){
	word = word1;
	updateCount();
}
/*
 * returns uniqueWords word 
 */
public String getWord()
{
	return word;
}
/*
 * returs uniqueWords frequency
 */
public int getCount()
{
	return count;
}
/*
 * increments the count by 1
 */
public void updateCount(){
	count = count + 1;
	
}
}
