package final_proje;

public class DoublyLinkedList {

    Node head = null;
    Node tail = null;
    Node current = null;

    //DoublyLinkedList sınıfı içerisinde inner class olarak yazdığım Node sınıfı
    class Node {

        CustomerInfo data;
        Node prev;
        Node next;

        public Node(CustomerInfo data) {
            this.data = data;
        }
    }

    //Listeye müşteri eklemek için kullanılacak "ekleme" metodu
    public void add(CustomerInfo data) {
        current = head; //Listenin içinde dolaşacak olan current değişkenini head'den başlatma
        boolean added = false;
        Node musteri = new Node(data); //Yeni müşteri node'u oluşturma

        //Listede hiç müşteri olmadığı takdirde listeye ilk müşteriyi ekleme
        if (head == null) {
            head = tail = musteri;
            head.prev = null;
            tail.next = null;
            current = head;
            added = true;
            System.out.println("Müşteri başarıyla listeye eklendi.");

        } else { //Listede müşteri olduğu takdirde listeye müşteri ekleme

            //Alfabetik sıralamaya göre yerleştirme yapabilmek için müşterinin soyismini belirleme
            String s = data.getAdSoyad();
            String[] isimSoyisim = s.split(" ");
            String soyisim = isimSoyisim[isimSoyisim.length - 1];

            while (current != null) {
                //Listeyi dolaşan current değişkeninin soyadı ile eklenecek müşterinin soyadlarını
                //alfabetik olarak kıyaslama
                String c = current.data.getAdSoyad();
                String[] cIsimSoyisim = c.split(" ");
                String cSoyisim = cIsimSoyisim[cIsimSoyisim.length - 1];
                int compare = soyisim.compareTo(cSoyisim);

                //Müşterinin soyadı current değişkeninden alfabetik olarak önce ise gerçekleşecekler
                if (compare < 0) {
                    //Eğer müşteri listenin başına eklenecek ise gerçekleşecekler 
                    if (current == head) {
                        musteri.next = head;
                        head.prev = musteri.prev;
                        head.prev = musteri;
                        head = musteri;
                        added = true;
                        System.out.println("Müşteri başarıyla listeye eklendi.");
                        break;
                    } else { //Eğer müşteri listede araya eklenecek ise gerçekleşecekler
                        musteri.next = current.prev.next;
                        current.prev.next = musteri;
                        musteri.prev = current.prev;
                        current.prev = musteri;
                        added = true;
                        System.out.println("Müşteri başarıyla listeye eklendi.");
                        break;

                    }

                }

                current = current.next;//Current değişkenini listede ilerletme
            }
            //Eğer müşteri listenin sonuna eklenecek ise gerçekleşecekler
            if (added == false) {
                musteri.prev = tail;
                tail.next = musteri.next;
                tail.next = musteri;
                tail = musteri;
                added = true;
                System.out.println("Müşteri başarıyla listeye eklendi.");

            }

        }
    }

    //Parametre olarak müşterinin adını ve soyadını alarak o müşterinin bilgilerini yazdırma
    public void findAndPrint(String adSoyad) {
        current = head;//Current değişkenini head'den başlatma
        boolean finded = false;
        while (current != null) {
            //Eğer current değişkeninin ismi ve soyismi aranan müşterininki ile aynıysa 
            //müşterinin bilgilerini yazdırma
            if (current.data.getAdSoyad().equals(adSoyad)) {
                System.out.println("Aradığınız müşterinin bilgileri: " + current.data.toString());
                finded = true;
                break;
            } else {
                current = current.next;//Current değişkenini listede ilerletme
            }
        }
        if (finded == false) {//Aranan müşteri listede yoksa kullanıcıyı uyarma
            System.out.println("Aradığınız müşteri bulunamadı!");
        }

    }

    //Parametre olarak müşterinin adını ve soyadını alarak o müşteriyi listeden silme
    public void delete(String adSoyad) {
        current = head;//Current değişkenini head'den başlatma
        boolean deleted = false;
        while (current != null) {
            //Eğer current değişkeninin ismi ve soyismi silmek istenen müşterininki
            //ile aynıysa o müşteriyi listeden çıkarma
            if (current.data.getAdSoyad().equals(adSoyad)) {
                //Çıkarılmak istenen müşteri listenin başındaysa gerçekleşecekler
                if (current == head) {
                    current.next.prev = null;
                    head = current.next;
                    deleted = true;
                    System.out.println("Müşteri başarıyla listeden silindi.");
                    break;
                    //Çıkarılmak istenen müşteri listenin sonundaysa gerçekleşecekler
                } else if (current == tail) {
                    current.prev.next = null;
                    tail = current.prev;
                    deleted = true;
                    System.out.println("Müşteri başarıyla listeden silindi.");
                    break;
                    //Çıkarılmak istenen müşteri listede aradaysa gerçekleşecekler
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    deleted = true;
                    System.out.println("Müşteri başarıyla listeden silindi.");
                    break;
                }

            } else {
                current = current.next;//Current değişkenini listede ilerletme
            }

        }
        //Silme işlemi gerçekleşemediyse müşterinin listede olmadığını kullanıcıya bildirme
        if (deleted == false) {
            System.out.println("Silmek istediğiniz müşteri bulunamadı!");
        }

    }

    //Listeyi müşterilerin soyadlarına göre A'dan Z'ye sıralı yazdırma
    public void printAToZ() {
        current = head;
        System.out.println("A'dan Z'ye tüm müşteriler:");
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    //Listeyi müşterilerin soyadlarına göre Z'den A'ya sıralı yazdırma
    public void printZToA() {
        current = tail;
        System.out.println("Z'den A'ya tüm müşteriler:");
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.prev;
        }

    }
}
