package stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AramaTalebiSayfa;
import pages.CozumMerkeziAnaSayfa;
import pages.GirişSayfası;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class HepsiburadaStepDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    GirişSayfası girişSayfası = new GirişSayfası();
    CozumMerkeziAnaSayfa anaSayfa = new CozumMerkeziAnaSayfa();
    AramaTalebiSayfa aramaTalebiSayfa = new AramaTalebiSayfa();

    String anaSayfaBaşlığı = "Size nasıl yardımcı olabiliriz?";
    String ürünÖzellikleriBaşlık = "Ürün özellikleri / Fiyat";
    String aramaTalebiSayfaBaşlık = "Arama talebi oluştur";

    @Given("kullanıcı tarayıcıyı açar ve hepsiburada çözüm merkezi sayfasına gider")
    public void kullanıcı_tarayıcıyı_açar_ve_hepsiburada_çözüm_merkezi_sayfasına_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("main_page_url"));
        Assert.assertEquals(anaSayfaBaşlığı, anaSayfa.sayfaBaşlığı.getText());
    }

    @Given("farklı bir konuda sorum var butonuna tıklar")
    public void farklı_bir_konuda_sorum_var_butonuna_tıklar() {
        anaSayfa.farklıKonuButon.click();
    }

    @Given("ürün bilgisi sekmesini seçer")
    public void ürün_bilgisi_sekmesini_seçer() {
        wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.ürünBilgisiButon));
        js.executeScript("arguments[0].click();", anaSayfa.ürünBilgisiButon);
        Assert.assertEquals(ürünÖzellikleriBaşlık, anaSayfa.ürünÖzellikleriBaşlık.getText());
    }

    @Given("ürün orjinal midir sorusunu seçer ve beni arayın butonuna tıklar")
    public void ürün_orjinal_midir_sorusunu_seçer_ve_beni_arayın_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.ürünOrjinalmiSoruBaşlığı));
        js.executeScript("arguments[0].click();", anaSayfa.ürünOrjinalmiSoruBaşlığı);
        wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.beniArayınButonu));
        anaSayfa.beniArayınButonu.click();
        Assert.assertTrue(girişSayfası.girişLogosu.isDisplayed());
    }

    @Given("giriş yap sayfası açılır ve kullanıcı başarılı giriş yapar")
    public void giriş_yap_sayfası_açılır_ve_kullanıcı_başarılı_giriş_yapar() {
        girişSayfası.kullanıcıEmail.sendKeys(ConfigReader.getProperty("email"));
        girişSayfası.girişYapEmail.click();
        wait.until(ExpectedConditions.visibilityOf(girişSayfası.emailÖnizleme));
        Assert.assertEquals(ConfigReader.getProperty("email"), girişSayfası.emailÖnizleme.getText());
        girişSayfası.kullanıcıŞifresi.sendKeys(ConfigReader.getProperty("sifre"));
        girişSayfası.girişYapFinal.click();
        wait.until(ExpectedConditions.visibilityOf(aramaTalebiSayfa.aramaTelebiSayfaBaşlık));
    }

    @Then("arama talebi oluştur sayfasından gönder butonuna tıklar")
    public void arama_talebi_oluştur_sayfasından_gönder_butonuna_tıklar() {
        Assert.assertEquals(aramaTalebiSayfaBaşlık, aramaTalebiSayfa.aramaTelebiSayfaBaşlık.getText());
//        aramaTalebiSayfa.gönderbutonu.click();   //--> comment this line if you don't want to receive a call
    }

}
