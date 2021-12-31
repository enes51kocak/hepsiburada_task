Feature: Hepsiburada

  Rule: Kullanıcı Hepsiburada hesabına giriş yapmamış olmalıdır

    @cozum_merkezi
    Scenario: Cozum Merkezı Arayüz Otomasyonu
      Given kullanıcı tarayıcıyı açar ve hepsiburada çözüm merkezi sayfasına gider
      And farklı bir konuda sorum var butonuna tıklar
      And ürün bilgisi sekmesini seçer
      And ürün orjinal midir sorusunu seçer ve beni arayın butonuna tıklar
      And giriş yap sayfası açılır ve kullanıcı başarılı giriş yapar
      Then arama talebi oluştur sayfasından gönder butonuna tıklar

    @api_entegrasyon
    Scenario: entegrasyon testi
      Given kullanıcı end-pointe GET sorgusu gönderir
      Then sorgu cevabı status kodu 200 olmalıdır