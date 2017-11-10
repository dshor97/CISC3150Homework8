import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static long numSpaces = 0;
    public static DataOutputStream dataOutputStream;
    public static int count = 0;
    public static void main(String[] args) throws Exception{
        File root = new File("/");
        File output = new File("/Users/Student/IdeaProjects/CISC3150Homework8/src/dir_tree.txt");
        output.createNewFile();
        dataOutputStream = new DataOutputStream(new FileOutputStream(output));
        File[] tree = root.listFiles();
        writeTree(tree);
        System.out.println(count);
    }
    public static void writeTree(File[] tree)throws Exception{
        File[] subTree;
        for(int i = 0;i<tree.length;i++) {
            String spaces = new String();
            for(int k = 0;k<numSpaces;k++){
                spaces += "\t";
            }
            dataOutputStream.writeBytes(spaces + tree[i].toString() + '\n');
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
