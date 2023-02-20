package bolum13_collections_project.udemyKursPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ogrenci extends Kisi{   //kisi sınıfından kalıtım yaptım.

    private ArrayList<Kurs> katildigiKurslar;
    private LinkedList<Ders> izlenecekDersListesi;


    //kalıtım yaptıgım için üst sınıftaki const.ları burada tanımlamak zorundayım.
    public Ogrenci(String isim, String tanitimyazisi, String kullaniciAdi) {

        super(isim, tanitimyazisi, kullaniciAdi);
        katildigiKurslar = new ArrayList<>();
        izlenecekDersListesi = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "katildigiKurslar=" + katildigiKurslar +
                '}';
    }

    public void kursaKatil(Kurs javaKursu){
        //eger kurs yayındaysa java kursuna kurs ogrencilerini ekleyeceğim
        if(javaKursu.kursYayindaKontrol()){
            javaKursu.getKursOgrencileri().add(this);
            katildigiKurslar.add(javaKursu);
            System.out.println(this.getIsim()+ " kullanıcısı " +javaKursu.getKursAdi()+ " kursuna katıldı.");
        }else{
            System.out.println(javaKursu.getKursAdi()+ " isimli kurs yayında değil katılım sağlayamazsınız.");
        }
    }

    //ogrenci ne yapacak ders ekleyecek
    //o ders o kursta var mı ve de o ogrenci o kursa katılmış mı kontrolunu yapmam gerekiyor.
    public void izlenecekDersEkle(Ders izlenecekDers){

        boolean dersBulundu = false;

        if(katildigiKurslar.size()>0){ //ogrenci belki 20 tane kursa katıldı bu kursları for döngüsüyle gezeyim:
            for(Kurs gecici : katildigiKurslar){
               if (gecici.getKurstakiDersler().contains(izlenecekDers)){
                  izlenecekDersListesi.add(izlenecekDers);
                  System.out.println("izlenecekler listesine " +gecici.getKursAdi()+ " kursunda bulunan" +izlenecekDers.getDersBaslik()+ " dersi eklendi");
                  dersBulundu = true;
                  break; //donguden çıkayım. else kısmını yapmayacagım.
               }
            }//fordan çıktım.
            if(!dersBulundu){ //dersBulundu false ise
                System.out.println("girdiğiniz ders kurslarda bulunamadı veya yetkisiz erişim.");
            }
        }
    }
}
