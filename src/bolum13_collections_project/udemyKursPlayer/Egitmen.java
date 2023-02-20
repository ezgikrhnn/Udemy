package bolum13_collections_project.udemyKursPlayer;

public class Egitmen extends Ogrenci{   // eğitmenler de kurslara girip izleyebilceği için eğitmenler de öğrencidir şeklinde kalıtım yaptım.


    public Egitmen(String isim, String tanitimyazisi, String kullaniciAdi) {
        super(isim, tanitimyazisi, kullaniciAdi);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
