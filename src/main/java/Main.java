import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String bldgname; //ビルの名前

        System.out.println("Please input information.");
        Scanner sc = new Scanner(System.in);
        bldgname = sc.nextLine(); //ビルの名前 入力

        System.out.println(bldgname);
        System.out.println();

        OpenCsv opCsv = new OpenCsv();
        ArrayList<ArrayList<String>> list = opCsv.openCsv(bldgname); //CSVデータ(ファイル名：建物名)生成

        System.out.println(list);

        for(int i = 1; i < ; i++){

        }

        //OpenShell.staticNetwork();

        //selenium_test.seleniumTest();

        //System.exit(0);
    }
}