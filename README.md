# Hepsiburada task

* Bu proje hepsiburada.com sitesinin Çözüm Merkezi sayfasının bir kısım otomasyonunu ve API enegrasyon testi örneği içerir. <br>
* Java-Cucumber-JUnit-Maven kullanılarak oluşturulmuştur <br>
* Proje, Chrome, Firefox, Opera ve Headless-Chrome üzerinde çalıştırılabilir. Ancak specifik tarayıcının makinenizde kurulu olduğundan emin olunuz. <br>
* Tarayıcıyı değiştirmek istiyorsanız,'configuration.properties' dosyasına gidip browser adını şu şekilde değiştirebilirsiniz;  <br>
      -- chrome<br>
      -- firefox<br>
      -- opera<br>
      -- chrome-headless<br>
* Projeyı Runner class üzerinden çalıştırabilirsiniz. Tag isimlerini değiştirerek entegrasyon testini de koşturabilirsiniz <br>
* Test koşturma işlemi sona erdiğinde lokalinizde, test-output klasörü altında raporlar oluşacaktır. Bunun yanında test geçmemesi halinde de ekran görüntüsü alınıp hep rapora eklenecek hem de ayrıca bir klasörde tutulacaktır <br>
* Projede test etmek için sahte kullanıcı oluşturulmuştur. Koşturmadan önce 'configuration.properties' dosyasından email ve şifreyi güncelleyebilirsiniz.
