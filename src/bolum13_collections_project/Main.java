package bolum13_collections_project;

import bolum13_collections_project.udemyKursPlayer.Ders;
import bolum13_collections_project.udemyKursPlayer.Egitmen;
import bolum13_collections_project.udemyKursPlayer.Kurs;
import bolum13_collections_project.udemyKursPlayer.Ogrenci;

public class Main {
    public static void main(String[] args) {

        Ogrenci ogr1 = new Ogrenci("ali", "alinin tanıtım yazısı", "ali_udemy");
        Egitmen emre = new Egitmen("emre","emre java", "emre_Altunbilek");  //indexi 0 olan bas eğitmen olsun.
        Egitmen omer = new Egitmen("omer", "omer java", "omer_rıfkısu");  //indexi 1 olan eğitmen
        Egitmen esin = new Egitmen("esin", "esin java", "esin_serrosu");
        System.out.println(emre);

        Ders d1 = new Ders(1, "giriş", 3.5 );
        Ders d2 = new Ders(2, "java nedir", 10.2);
        Ders d3 = new Ders(3, "primitive veri tipleri", 30.5);
        Ders d4 = new Ders(4, "diziler", 15.9);
        Ders d5 = new Ders(5, "metotlar", 20);
        Ders d6 = new Ders(6, "nesneler", 30);

        Kurs javaKursu = new Kurs("ileri seviye Java kursu", emre);
        javaKursu.kursaDersEkle(d1);
        javaKursu.kursaDersEkle(d2);
        javaKursu.kursaDersEkle(d3);
        javaKursu.kursaDersEkle(d4);
        javaKursu.kursaDersEkle(d5);


        javaKursu.kurstanEgitmenSil(emre); //eğitmenin 0. indexsinde emre yer aldığı için silinemez uyarısı verecek
        javaKursu.kursaEgitmenEkle(esin);   //farklı uyarılar görebilmek için bu öalışmayı yaptım.
        javaKursu.kurstanEgitmenSil(omer);

        Kurs androidKursu = new Kurs("android Kursu", emre);
        androidKursu.kursaDersEkle(d6);

        ogr1.kursaKatil(javaKursu); //su an kursumun içine aliyi ekledim.

        ogr1.izlenecekDersEkle(d6);  //girdiğiniz ders kursta bulunamadı uyarısı verir çünkü d6yı kursa henüz eklemedim



    }

}
