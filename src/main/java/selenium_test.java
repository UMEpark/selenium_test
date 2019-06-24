import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_test {
    public static void seleniumTest(){
        try {
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
            WebElement takePwd = driver.findElement(By.xpath("//*[@id=\"show_wpa_psk2_show\"]/td[2]/input"));
            takePwd.click();
            takePwd.getText();
            System.out.println(takePwd);

            Thread.sleep(2000);

            driver.close();

        } catch(Exception e){

        }
    }
}

/*
        driver.get("http://admin:admin@192.168.2.1");
        Thread.sleep(5000);
        WebElement changeSsid = driver.findElement(By.name("ssid0"));
        changeSsid.clear();
        changeSsid.sendKeys(a[].ssid);
        WebElement getPw = driver.findElement(By.name("pskValue0_show"));
        getPw.click(); //비밀번호 획득
        WebElement adminId = driver.findElement(By.name("username"));
        adminId.clear();
        adminId.sendKeys("admin");
        WebElement adminPw = driver.findElement(By.name("newpass"));
        adminPw.clear();
        adminPw.sendKeys("pwd");
        WebElement adminCpw = driver.findElement(By.name("confpass"));
        adminCpw.clear();
        adminCpw.sendKeys("pwd");
        WebElement changeIp = driver.findElement(By.name("lan_ip"));
        changeIp.click();
        Thread.sleep(2000);
        WebElement passWord = driver.findElement(By.name("user_pw"));
        passWord.sendKeys("test");
 */