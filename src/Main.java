import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static int numSpaces = 0;
    public static DataOutputStream dataOutputStream;
    public static File root = new File("/Users/Student/Desktop/");
    public static int isBar[] = new int[500];
    public static void main(String[] args) throws Exception{

        isBar[0] = 1;
        File output = new File("/Users/Student/IdeaProjects/CISC3150Homework8/src/dir_tree.txt");
        output.createNewFile();
        dataOutputStream = new DataOutputStream(new FileOutputStream(output));
        dataOutputStream.writeBytes(root.toString()  + '\n');
        dataOutputStream.flush();
        isBar[++numSpaces] = 1;
        File[] tree = root.listFiles();
        writeTree(tree);
    }
    public static void writeTree(File[] tree)throws Exception{
        File[] subTree;
        for(int i = 0;i<tree.length;i++) {
            String spaces = new String();
            for(int k = 0;k < numSpaces -1;k++){
                if(isBar[k] == 1){
                    spaces += "|           ";
                }else{
                    spaces +=  "\t\t\t";
                }
            }
            if(i==tree.length - 1){
                spaces += "\\---------->";
                isBar[numSpaces - 1] = 0;
            }else {
                spaces += "|---------->";
                isBar[numSpaces - 1] = 1;
            }
            dataOutputStream.writeBytes(spaces + tree[i].toString() + " " + '\n');
            dataOutputStream.flush();
            if (tree[i].isDirectory()) {
                subTree = tree[i].listFiles();
                if(subTree != null) {
                    numSpaces++;
                    writeTree(subTree);
                }
            }
        }
        numSpaces--;


    }
}

