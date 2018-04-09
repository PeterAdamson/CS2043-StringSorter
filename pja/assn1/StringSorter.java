/*Author Peter Adamson*/

package pja.assn1;

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

//Sorts a list of strings in ascending alphabetical order
public class StringSorter
{

  //variable declarations
  private String fileName;
  private String outputName;
  private int count;
  ArrayList<String> lines = new ArrayList<String>();

  //constructor sets the input and outpute file names given by the user
  public StringSorter(String fileName, String outputName)
  {
    this.fileName = fileName;
    this.outputName = outputName;
  }

  /*reads from the given hard coded file line by line and adds each line to an array list
  Once the end of the file has been reached, the read function calls swap, which sortst the array list*/
  public void read()
  {
    try
    {
      Scanner sc = new Scanner(new File(fileName));
      while(sc.hasNextLine())
      {
        lines.add(sc.nextLine());
        count += 1;
      }
      swap();
    }
    catch(FileNotFoundException notFound)
    {
      notFound.printStackTrace();
    }
  }

  //writes the sorted array list out to a file
  public void write()
  {
    File outputFile = new File(outputName);
    try
    {
      PrintWriter out = new PrintWriter(outputFile);
      for(int i = 0; i < lines.size(); i++)
      {
        out.println(lines.get(i));
      }
      out.flush();
      out.close();
    }
    catch (FileNotFoundException notFound)
    {
      notFound.printStackTrace();
    }
  }

  //uses findBiggestIndex method to find the next largest string to swap and then swaps the string in the current last position with that string
  private void swap()
  {
    for(int i = lines.size() - 1; i >= 0; i--)
    {
      int toSwap = findBiggestIndex();
      String swap = lines.get(toSwap);
      String last = lines.get(i);
      lines.set(i, swap);
      lines.set(toSwap, last);
    }
  }

  //finds the index of the largest (alphabetically) string in the current search field of the array list
  private int findBiggestIndex()
  {
    String largest = lines.get(0);
    int biggestIndex = 0;
    for(int i = 0; i < count; i++)
    {
      if(largest.compareTo(lines.get(i)) < 0)
      {
        largest = lines.get(i);
        biggestIndex = i;
      }
    }
    count = count - 1;
    return biggestIndex;
  }
}
