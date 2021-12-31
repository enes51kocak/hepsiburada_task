package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AramaTalebiSayfa {

    public AramaTalebiSayfa(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".bottom-sheet-title")
    public WebElement aramaTelebiSayfaBaşlık;

    @FindBy(xpath = "//button[contains(.,'Gönder')]")
    public WebElement gönderbutonu;


}
