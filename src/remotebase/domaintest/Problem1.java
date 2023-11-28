package remotebase.domaintest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.Array;
import java.util.stream.Collectors;

/* model ouput for cut and paste
Member with name ____ does not exist
File with id ____ does not exist
Message with id ____ does not exist
Total number of members in the conversation are ____
The names of these members are ____
Total number of files in the conversation are ____
The messages in the conversation are ____
*/
class Chat {
    private List<String> members;
    private List<Integer> files;
    private Map<Integer, String> message;

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<Integer> getFiles() {
        return files;
    }

    public void setFiles(List<Integer> files) {
        this.files = files;
    }

    public Map<Integer, String> getMessage() {
        return message;
    }

    public void setMessage(Map<Integer, String> message) {
        this.message = message;
    }

    public void add(String[] names) {

        this.setMembers(new LinkedList<>(Arrays.asList(names)));
    }

    public void add(int [] ids) {
        List<Integer> listOfIds  = Arrays.stream(ids).boxed().collect( Collectors.toList() );
        this.setFiles(listOfIds);
    }

    public void add(int id, String newMessage) {
        Map<Integer, String> messagesMap = this.getMessage();
        if(messagesMap != null) {
            messagesMap.put(id, newMessage);
        } else {
            messagesMap = new HashMap<>();
            messagesMap.put(id, newMessage);
        }

        this.setMessage(messagesMap);
    }

    public void remove(String[] names) {
        List<String> members = this.getMembers();
        //List<String> newMembers = new ArrayList<>();

        for(String name : names) {
            if(members.contains(name)) {
                members.remove(name);
            } else {
                System.out.println("Member with name " + name + " does not exist");
            }
        }

        this.setMembers(members);
    }

    public void remove(int [] ids) {
        List<Integer> files = this.getFiles();
        for(int id : ids) {
            if(files.contains(id)) {
                files.remove(Integer.valueOf(id));
            } else {
                System.out.println("File with id " + id + " does not exist");
            }
        }
        this.setFiles(files);
    }

    public void remove(int id) {
        if(this.getMessage().containsKey(id)) {
            this.getMessage().remove(id);
        } else {
            System.out.println("Message with id " + id + " does not exist");
        }
    }


    public void printConversation() {
        List<String> members = this.getMembers();
        System.out.println("Total number of members in the conversation are " + members.size());

        System.out.print("The names of these members are");
        for(String member : members)
            System.out.print(" " + member);

        System.out.println();
        System.out.println("Total number of files in the conversation are " + this.getFiles().size());

        System.out.print("The messages in the conversation are");
        Map<Integer, String> messages = this.getMessage();
        for(Map.Entry<Integer, String> m : messages.entrySet()) {
            System.out.print(" '" + m.getValue() + "'");
        }
    }
}

public class Problem1 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] lineArray = sc.nextLine().split(" ");

        Chat newChat = new Chat();
        newChat.add(lineArray);

        lineArray = sc.nextLine().split(" ");

        int[] files = new int[lineArray.length];
        for (int i=0; i < lineArray.length; i++) {
            files[i] = Integer.parseInt(lineArray[i]);
        }
        newChat.add(files);

        String line = sc.nextLine();
        int numberOfMessages = Integer.parseInt(line);

        for (int i=0; i < numberOfMessages; i++) {
            line = sc.nextLine();
            newChat.add(i, line);
        }

        lineArray = sc.nextLine().split(" ");
        newChat.remove(lineArray);

        lineArray = sc.nextLine().split(" ");
        int[] filesRemoved = new int[lineArray.length];
        for (int i=0; i < lineArray.length; i++) {
            filesRemoved[i] = Integer.parseInt(lineArray[i]);
        }
        newChat.remove(filesRemoved);

        lineArray = sc.nextLine().split(" ");
        for (int i=0; i < lineArray.length; i++) {
            newChat.remove(Integer.parseInt(lineArray[i]));
        }

        newChat.printConversation();
    }
}