
//DERS81 ARRAY SINIFI:
package bolum8;

import java.util.ArrayList;

public class ders81_arraySinifi {

    public static void main(String[] args) {
        /*
        Telefon[] telefonlar = new Telefon[20]; //20 tane telefon tutacak bir dizi oluşturuyorum.

        Telefon tel1 = new Telefon("mi 8", 7000);
        Telefon tel2 = new Telefon("iphone 11", 17000);
        Telefon tel3 = new Telefon("samsung s32", 10000);
        Telefon tel4 = new Telefon("redmi", 9000);

        telefonlar[0] = tel1;
        telefonlar[1] = tel2;
        telefonlar[2] = tel3;

        //diyelim ki bu seşilde 20 elemanlı diziyi doldurdum ama 5 tane daha telefonu saklamak istiyorum,
        telefonlar = new Telefon[25];
        //bunu yaptıgımızdaki sıkıntı diziler sabittir gidip de yanına 5 tane daha kutucuk acmıyor
        //yeniden 25 elemanlı boş bir dizi oluşturuyor ve yazdıgımız degerler artık burada gorunmeyecek.

        System.out.println(telefonlar[1]); //artık iphone 11 değil null degerini, alırım.

        İŞTE BU GİBİ DURUMLARDA BİZ ARRAYLİSTLERİ KULLANIRIZ.
        */

        ArrayList<Telefon> telefonlar = new ArrayList<>();

        Telefon tel1 = new Telefon("mi 8", 7000);
        Telefon tel2 = new Telefon("iphone 11", 17000);
        Telefon tel3 = new Telefon("samsung s32", 10000);
        Telefon tel4 = new Telefon("redmi", 9000);

        telefonlar.add(tel1); //0 a tel1 i koymuştu
        telefonlar.add(0, tel2); //0. indexe tel2yi koydu yani kaydırdı.
        telefonlar.add(tel3);
        telefonlar.remove(0);  //0. indexi sil. yani tel2 silindi


        telefonlar.set(0,tel2); //set() uzerine yazdırma yapae
        listeyiYazdir(telefonlar);

        System.out.println(telefonlar.contains(tel2));   //true yazdırır.
    }

    //bir metod oluşturalım:
    public static void listeyiYazdir(ArrayList<Telefon> liste){
        for(int i=0; i<liste.size(); i++){ //size 5 donerken indexler 0dan başladı
            System.out.println(liste.get(i));  //get() listelerde index verir

        }

    }
}
class Telefon{
    String model;
    int fiyat;

    //ben bir telefon nesnesi oluşturdugumda const.dan faydalanmak istiyorum:


    public Telefon(String model, int fiyat) {
        this.model = model;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "telefon{" +
                "model='" + model + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
