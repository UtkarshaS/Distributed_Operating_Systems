import java.io.*;
import java.util.*;

class Code1{

public static void main (String args[])throws IOException{

	    String string=new String();
	    String file ="words.txt";
            InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String line;
            ArrayList<String> dict = new ArrayList();
            
            int i=0;
            System.out.println("*"); 
	    while ((line=br.readLine())!=null){
		dict.add(i,line);
		i++;
	    }
	    
	  boolean chk[]=new boolean[args.length];
	  for(int j=0; j<args.length;j++){
	  if(dict.contains(args[j])){
	  System.out.println("HO AAHE "+args[j]);
	  chk[j]=di;
	  }
	  else{
	  chk[j]=false;
	  }
	  }
	  for(i=0;i<args.length;i++)
	  System.out.print(chk[i]);
 
 
 
	  //for(i=0;i<dict.size();i++){
	    //System.out.println(i+" "+dict.get(i));
		//  }
            
	    System.out.println("Size is "+i);
            line="abcd";
            System.out.println(string.length());
            br.close(); 

}

}