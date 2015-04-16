import java.io.*;
import java.util.*;
import org.apache.thrift.TException;

public class SpellHandler implements SpellService.Iface{

@Override
 public boolean[] spellcheck(Arraylist<String>) throws TException
{
	    //Read the dictionary
	    String file ="words.txt";
            InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String line;
            
            //initialize arraylist to store
            ArrayList<String> dict = new ArrayList();
            
            //Adding dictionary words into the arraylist dict, by parsing the words one by one
            int i=0;
            while ((line=br.readLine())!=null){
		dict.add(i,line);
		i++;
	    }
	    
	    //Create chk array for storing the return values from server
	  boolean chk[]=new boolean[args.length];
	  
	   //Compare the user/client's words with the dictionary words
	   //Set boolean value if word exists .
	   for(int j=0; j<args.length;j++){
	   if(dict.contains(args[j])){
	   chk[j]=1;
	   }
	   else{
           chk[j]=0;
	   }
	   }
	  
            line="  ";
            br.close(); 
	    return chk;
}
}