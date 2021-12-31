package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CozumMerkeziAnaSayfa {

    public CozumMerkeziAnaSayfa(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='entrance-title']//following-sibling::div[@class='text']")
    public WebElement sayfaBaşlığı;

    @FindBy(xpath = "(//div[@class= 'btn button-primary-default'])[2]/button")
    public WebElement farklıKonuButon;

    @FindBy(xpath = "(//div[@class='parent-line'])[2]")
    public WebElement ürünBilgisiButon;

    @FindBy(id = "sub67")
    public WebElement ürünÖzellikleriBaşlık;

    @FindBy(css = "#faq-188>span")
    public WebElement ürünOrjinalmiSoruBaşlığı;

    @FindBy(xpath = "//div[@class='rule-messages']/div[2]")
    public WebElement beniArayınButonu;

}
