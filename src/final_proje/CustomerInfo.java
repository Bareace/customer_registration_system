package final_proje;

import java.util.ArrayList;

public class CustomerInfo {

    private String adSoyad;
    private String adres;
    private ArrayList telNo;

    //Alınan parametreleri değişkeneler atama
    public CustomerInfo(String adSoyad, String adres, ArrayList telNo) {
        this.adSoyad = adSoyad;
        this.adres = adres;
        this.telNo = telNo;

    }

    //Müşterinin adını ve soyadını çağıracak metot
    public String getAdSoyad() {
        return adSoyad;
    }

    //Müşterinin adını ve soyadını düzenlemek için kullanılacak metot
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    //Müşterinin adresini çağıracak metot
    public String getAdres() {
        return adres;
    }

    //Müşterinin adresini düsenlemek için kullanılacak metot
    public void setAdres(String adres) {
        this.adres = adres;
    }

    //Müşterinin telefon numaralarını çağıracak metot
    public ArrayList getTelNo() {
        return telNo;
    }

    //Müşterinin telefon numaralarını düzenlemek için kullanılacak metot
    public void setTelNo(ArrayList telNo) {
        this.telNo = telNo;
    }

    //Müşterinin bilgilerini yazdıracak olan metot
    @Override
    public String toString() {
        return (getAdSoyad() + ", " + getAdres() + ", " + getTelNo());
    }

}
