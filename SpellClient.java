import java.io.*;
import java.util.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

//
public class SpellClient {
public static void main(String [] args)throws IOException 
{
    try {
    TTransport transpot;
    
    //Pass the IP address and Port No. through socket connect
    transport = new TSocket(args[0], args[1]);
    transport.open();
    TProtocol protocol = new TBinaryProtocol(transport);
    SpellService.Client client = new SpellService.Client(protocol);
    perform(client);
    transport.close();
    } 
    catch (TException x) {
    x.printStackTrace();
    }
}

private static void perform(SpellService.Client client) throws TException
{

    ArrayList<String> inp = new ArrayList();
    //Copy the user array into a temporary array inp with only words, excluding the  ip address and port no. 
    for(int i=2;i<args.length;i++)
    inp[i-2]=args[i];
    
    //check the correctness of the words by calling spellcheck
    boolean answer[]=new boolean[args.length-2];
    answer[]=client.spellcheck(inp);
    
    String wrong_words=""
    //print the boolean array and gathers the wrong words
    for(int i=0;i<(args.length-2);i++)
    {
      System.out.println(answer[i]);
      if(answer[i]==0)
	wrong_words+=inp[i]+"\n";
   }
   
   //prints the wrong words
   System.out.println(wrong_words);
 }
}