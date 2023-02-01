package TaskTwo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserTaskTwoTest {

    public static void main(String[] args) {
        List<UserTaskTwo> listOfUsers = new ArrayList<>();
        // reading from files
        try (BufferedReader br = new BufferedReader(new FileReader("src/assets/newFile.txt"), 24)) {
            br.readLine(); //skipping the first title line
            while (br.ready()) {
                String [] line = br.readLine().split(" "); //converting the read line to array
                UserTaskTwo user = new UserTaskTwo(line[0],Integer.parseInt(line[1]));//making a user
                listOfUsers.add(user);//adding the user to the list of users
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // writing into the json file
        File newFileWriter = new File("src/TaskTwo/user.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(newFileWriter)) {
            String json = gson.toJson(listOfUsers);
            writer.write(json);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

