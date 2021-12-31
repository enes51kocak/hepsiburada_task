package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class GirişSayfası {

    public GirişSayfası(){
        PageFactory.initElements(Driver.getDriver(),  this);
    }

    @FindBy(tagName = "a")
    public WebElement girişLogosu;

    @FindBy(className = "_3kuUxLzkHa5tBZFWbKwAfZ")
    public WebElement emailÖnizleme;

    @FindBy(id = "txtUserName")
    public WebElement kullanıcıEmail;

    @FindBy(id = "txtPassword")
    public WebElement kullanıcıŞifresi;

    @FindBy(id = "btnLogin")
    public WebElement girişYapEmail;

    @FindBy(id = "btnEmailSelect")
    public WebElement girişYapFinal;
}
