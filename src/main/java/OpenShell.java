import java.io.*;
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
        Process p;
        try{
            List<String> cmdList = new ArrayList<>();
            cmdList.add("sh");
            cmdList.add("/home/network-18/DHCP_network.sh");
            ProcessBuilder dhcpNetConfig = new ProcessBuilder(cmdList);
            p = dhcpNetConfig.start();
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

    public String AdminPwd(){
        String adminPwd = null;
        try{
            FileReader fr = new FileReader("/home/network-18/password.txt");
            BufferedReader br = new BufferedReader(fr);

            adminPwd = br.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        return adminPwd;

    }
}