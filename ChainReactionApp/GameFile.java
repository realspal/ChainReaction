//GameFile Class
import javax.swing.*;
import java.io.*;
import java.util.*;
public class GameFile
{
    public static void save(String file_name,BoardData bd)
    {
        String full_name=file_name.trim()+".crxn";
        int mat2[][]=bd.mat;
        int whoseMoveNow2=bd.whoseMoveNow;
        try
        {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(full_name));
            oos.writeObject(mat2);
            oos.writeInt(whoseMoveNow2);
            oos.close();
        }
        catch(Exception e)
        {
        }
    }
}