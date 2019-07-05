import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String bldgname; //ビルの名前

        System.out.println("Please input information.");
        Scanner scan = new Scanner(System.in);

        bldgname = scan.nextLine(); //ビルの名前 入力

        System.out.println(bldgname);
        System.out.println();

        OpenCsv openCsv = new OpenCsv();
        ArrayList<ArrayList<String>> list = openCsv.openCsv(bldgname); //CSVデータ(ファイル名：建物名)生成

//        for(int i = 0; i < list.get(0).size(); i++){
//
//        }

        OpenShell.staticNetwork();

        selenium_test.seleniumTest();

        //System.exit(0);
    }
}