import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Code {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("in.txt"))
        {
        	Scanner scanner = new Scanner(fr);
        	String line = scanner.nextLine();
        	String[] nums= line.split("[ ]");
            System.out.print(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }  
    }      
}
