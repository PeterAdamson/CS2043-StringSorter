/*Author Peter Adamson*/

package pja.assn1;

import java.util.Scanner;

public class StringSorterCLI
{
  private Scanner sc = new Scanner(System.in);

  public StringSorterCLI()
  {

  }

  public void promptforInput()
  {
    System.out.println("please enter the name of the input file");
    String input = sc.nextLine();
    System.out.println("please enter the name of the output file");
    String output = sc.nextLine();
    StringSorter sorter = new StringSorter(input, output);
    sorter.read();
    sorter.write();
  }
}
