import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;

public class selenium_test {
    public static void seleniumTest(){
        try {
            OpenShell getPwd = new OpenShell();
            String realPwd = getPwd.AdminPwd();
            String finalUrl = "http://admin:" + realPwd + "@192.168.76.20/basic_auth";

            System.setProperty("webdriver.gecko.driver", "/home/network-18/IdeaProjects/selenium_test/src/main/java/geckodriver");
            WebDriver driver = new FirefoxDriver();

            Thread.sleep(2000);

            driver.get("http://admin:admin@192.168.2.1");
            driver.get("http://admin:admin@192.168.2.1/boafrm/formWlanRedirect?redirect-url=wlbasic.htm&wlan_id=0");
            WebElement changeSsid = driver.findElement(By.xpath("/html/body/blockquote/form/table[5]/tbody/tr/td[2]/input"));
            changeSsid.clear();
            changeSsid.sendKeys("test");
            changeSsid.submit();

            Thread.sleep(2000);

            driver.get("http://admin:admin@192.168.2.1/boafrm/formWlanRedirect?redirect-url=wlsecurity.htm&wlan_id=0");
            driver.switchTo().frame("SSIDAuthMode");
            WebElement takePwd = driver.findElement(By.xpath("//*[@id=\"show_wpa_psk2_show\"]/td[2]/input"));
            takePwd.click();
            String APpwd = takePwd.getAttribute("value");
            System.out.println(APpwd);

            Thread.sleep(2000);

            driver.get("http://admin:admin@192.168.2.1/tcpiplan.htm");
            WebElement configIp = driver.findElement(By.xpath("//*[@id=\"route_mode_lanip\"]/td[2]/input"));
            configIp.clear();
            configIp.sendKeys("192.168.76.20");
            configIp.submit();

            Thread.sleep(20000);

            driver.close();

            System.setProperty("webdriver.gecko.driver", "/home/network-18/IdeaProjects/selenium_test/src/main/java/geckodriver");
            WebDriver Rdriver = new FirefoxDriver();

            OpenShell.dhcpNetwork();

            Rdriver.get("http://admin:admin@192.168.76.20");
            Rdriver.get("http://admin:admin@192.168.76.20/password.htm");
            WebElement adminID = Rdriver.findElement(By.xpath("/html/body/blockquote/form/table[1]/tbody/tr[2]/td[2]/input"));
            adminID.sendKeys("admin");
            WebElement adminPwd = Rdriver.findElement(By.xpath("/html/body/blockquote/form/table[1]/tbody/tr[3]/td[2]/input"));
            adminPwd.sendKeys(realPwd);
            WebElement adminCFpwd = Rdriver.findElement(By.xpath("/html/body/blockquote/form/table[1]/tbody/tr[4]/td[2]/input"));
            adminCFpwd.sendKeys(realPwd);
            WebElement confirm = Rdriver.findElement(By.xpath("/html/body/blockquote/form/table[2]/tbody/tr/td/p/input"));
            confirm.submit();

            Thread.sleep(15000);

            Rdriver.navigate().to(finalUrl);
            System.out.println(finalUrl);

            Rdriver.close();

        } catch(Exception e){

        }
    }
}