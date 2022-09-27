package final_proje;//By Barış Bektaşoğlu 05190000019

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Final_Proje {

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();//Yeni bir çift bağlı liste oluşturma
        //Kullanıcının yapabileceği işlem seçeneklerinin ekrana yazdırılması
        System.out.println("1) Listeye eklenecek müşterilerin bilgilerini dosyadan oku");
        System.out.println("2) Listeye eklenecek müşterinin bilgilerini klavyeden gir");
        System.out.println("3) Bilgileri yazdırılacak müşterinin adını ve soyadını klavyeden gir");
        System.out.println("4) Listeden silinecek müşterinin adını ve soyadını klavyeden gir");
        System.out.println("5) Listeyi A'dan Z'ye yazdır");
        System.out.println("6) Listeyi Z'den A'ya yazdır");
        System.out.println("7) Programı bitir");

        Scanner input = new Scanner(System.in);
        //Kullanıcın işlem seçimini alıp değişkene atama
        System.out.println("Yapmak istediğiniz işlemin numarasını giriniz:");
        int islem = input.nextInt();
        input.nextLine();
        System.out.println(" ");

        //Kullanıcı konsola "7" girmediği sürece dönecek olan while döngüsü
        while (islem != 7) {
            switch (islem) {
                case 1://Kullanıcı 1. işlemi seçtiği takdirde gerçekleşecekler
                    try {
                    //Müşterilerin okunacağı dosyanın açılıp okunamsı
                    File dosya = new File("customer.txt");
                    Scanner rdr = new Scanner(dosya);

                    //Tüm satırların okunması
                    while (rdr.hasNextLine()) {
                        //Her satırın bir string olarak alınması sonradan bu string'in
                        //virgüller yardımıyla parçalanarak bilgilerin değişkenlere atanması
                        String all = rdr.nextLine();
                        String[] spData = all.split(",");
                        String name = spData[0];
                        String adr = spData[1];
                        //Müşterinin tüm telefon numaralarının array list'te tutulması
                        ArrayList tel = new ArrayList();
                        for (int i = 2; i < spData.length; i++) {
                            tel.add(spData[i]);
                        }
                        //Dosyadan alınan bilgilerle yeni bir CustomerInfo sınıfı tipinde
                        //müşteri oluşturma ve bu müşteriyi çift bağlı listeye ekleme
                        CustomerInfo cust = new CustomerInfo(name, adr, tel);
                        dList.add(cust);
                    }
                    System.out.println(" ");

                    //Dosya bulunamadığı takdirde kullanıcının uyarılması
                } catch (FileNotFoundException e) {
                    System.out.println("Dosya bulunamadı!");

                }

                break;
                //Kullanıcı 2. işlemi seçtiği takdirde gerçekleşecekler
                case 2:
                    //Kullanıcının listeye eklemek istediği müşterinin bilgilerini kullanıcıdan alma
                    System.out.println("Eklemek istediğiniz müşterinin bilgilerini virgülle ayırarak yazınız:");
                    String allData = input.nextLine();
                    //Alınan string'i virgüller yardımıyla parçalayarak bilgileri değişkenlere atama
                    String[] splitData = allData.split(",");
                    String adSoyad = splitData[0];
                    String adres = splitData[1];
                    //Müşterinin telefon numaralarının bir array list'te tutulması
                    ArrayList telNo = new ArrayList();
                    for (int i = 2; i < splitData.length; i++) {
                        telNo.add(splitData[i]);

                    }
                    //Kullanıcıdan alınan bilgiler ile CustomerInfo sınıfı tipinde yeni bir müşteri oluşturma
                    //ve bu müşteriyi çift bağlı listeye ekleme
                    CustomerInfo musteri = new CustomerInfo(adSoyad, adres, telNo);
                    dList.add(musteri);
                    System.out.println(" ");
                    break;
                //Kullanıcı 3. işlemi seçtiği takdirde gerçekleşecekler
                case 3:
                    //Adı ve soyadı kullanıcıdan alınan müşterinin "DoublyLinkedList" sınıfı
                    //içinde yazdığım metot yardımıyla liste içinde bulma ve bilgilerini yazdırma
                    System.out.println("Bilgilerini yazdırmak istediğiniz müşterinin adını ve soyadını yazınız:");
                    String printAdSoyad = input.nextLine();
                    dList.findAndPrint(printAdSoyad);
                    System.out.println(" ");
                    break;
                //Kullanıcı 4. işlemi seçtiği takdirde gerçekleşecekler
                case 4:
                    //Adı ve soyadı kullanıcıdan alınan müşterinin "DoublyLinkedList" sınıfı
                    //içinde yazdığım metot yardımıyla listeden silinmesi
                    System.out.println("Listeden silmek istediğiniz müşterinin adını ve soyadını yazınız:");
                    String popAdSoyad = input.nextLine();
                    dList.delete(popAdSoyad);
                    System.out.println(" ");
                    break;
                //Kullanıcı 5. işlemi seçtiği takdirde gerçekleşecekler
                case 5:
                    //"DoublyLinkedList" sınıfı içinde yazdığım metot yardımıyla
                    //listedeki tüm müşterilerin A'dan Z'ye sıralı yazdırılması
                    dList.printAToZ();
                    System.out.println(" ");
                    break;
                //Kullanıcı 6. işlemi seçtiği takdirde gerçekleşecekler
                case 6:
                    //"DoublyLinkedList" sınıfı içinde yazdığım metot yardımıyla
                    //listedeki tüm müşterilerin Z'den A'ya sıralı yazdırılması
                    dList.printZToA();
                    System.out.println(" ");
                    break;
                default:
                    break;
            }
            //İşlem yapıldıktan sonra yapılabilecek işlemlerin tekrar ekrana gelmesi ve 
            //kullanıcıdan yapmak istediği işlemin numarasının alınması
            System.out.println("1) Listeye eklenecek müşterilerin bilgilerini dosyadan oku");
            System.out.println("2) Listeye eklenecek müşterinin bilgilerini klavyeden gir");
            System.out.println("3) Bilgileri yazdırılacak müşterinin adını ve soyadını klavyeden gir");
            System.out.println("4) Listeden silinecek müşterinin adını ve soyadını klavyeden gir");
            System.out.println("5) Listeyi A'dan Z'ye yazdır");
            System.out.println("6) Listeyi Z'den A'ya yazdır");
            System.out.println("7) Programı bitir");

            System.out.println("Yapmak istediğiniz işlemin numarasını giriniz:");
            islem = input.nextInt();
            input.nextLine();
            System.out.println(" ");
        }

    }

}
