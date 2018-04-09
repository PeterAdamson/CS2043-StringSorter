/*Author Peter Adamson*/

package pja.assn1;

//drives the StringSorterCLI class, which makes use of the StringSorter class
public class StringSorterDriver
{
  public static void main(String[] args)
  {
    String fileName = "test.txt";
    StringSorterCLI command = new StringSorterCLI();
    command.promptforInput();
  }
}
