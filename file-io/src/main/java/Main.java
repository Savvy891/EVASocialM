import java.io.*;

public class Main {

    static void main(String[] args) throws IOException {
        //FileWriter and BufferedWriter
        // FileWriter old way where you include the finally fileWriter.close()
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter("example.csv");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            fileWriter.close();
//        }
        try(
                FileWriter fileWriter = new FileWriter("example.csv");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
                ){
            bufferedWriter.write("Jab,CharacterName,WhenToSay");
            bufferedWriter.newLine();
            bufferedWriter.write("\" This Trap is so basic a slime can see it \", Kaelen,\" trap placement\",");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        // FileReader and BufferedReader

        try(
                FileReader fileReader = new FileReader("scr/main/resources/example.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader)
                ){
            for(String line : bufferedReader.lines().toList()){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

