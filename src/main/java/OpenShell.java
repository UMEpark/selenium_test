import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OpenShell {
    public static void staticNetwork(){
        Process p;
        try{
            List<String> cmdList = new ArrayList<>();
            cmdList.add("sh");
            cmdList.add("/home/network-18/static_network.sh");
            ProcessBuilder staticNetConfig = new ProcessBuilder(cmdList);
            p = staticNetConfig.start();
            p.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch(IOException e){
            e.printStackTrace();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void dhcpNetwork(){

    }
}
