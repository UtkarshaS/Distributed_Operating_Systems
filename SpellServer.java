import org.apache.thrift.server.TServer;
import java.io.*;
import java.util.*;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class SpellServer {
public static SpellHandler handler;
public static SpellService.Processor processor;
public static void main(String [] args) {
try {
handler = new SpellHandler();
processor = new SpellService.Processor(handler);
Runnable simple = new Runnable() {
public void run() {
simple(processor);
}
};
new Thread(simple).start();
} catch (Exception x) {
x.printStackTrace();
}
}
public static void simple(SpellService.Processor processor) {
try {
TServerTransport serverTransport = new TServerSocket(9393);
TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
System.out.println("Starting the Spelling server...");
server.serve();
} catch (Exception e) {
e.printStackTrace();
}
}
}