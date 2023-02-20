package bolum13_collections_project.udemyKursPlayer;

public abstract class Kisi { //kisi sınıfımdan nesne üretilmesini istemediğim için abstract yaptım.

    private String isim;
    private String tanitimyazisi;
    private String kullaniciAdi;

    //3 ogeyi de içeren const. içeriyorum.
    public Kisi(String isim, String tanitimyazisi, String kullaniciAdi) {
        this.isim = isim;
        this.tanitimyazisi = tanitimyazisi;
        this.kullaniciAdi = kullaniciAdi;
    }

    //herhangi bir kontrol yapmayacagım ilgili kişinin kullanıcı adı vs lazım oldugu için sadece getter oluşturuyorum.
    public String getIsim() {
        return isim;
    }

    public String getTanitimyazisi() {
        return tanitimyazisi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    //ve ben bu kişiyi mutlaka ekrana yazdırmak isteyeceğim, toString metodu lazım:
    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", tanitimyazisi='" + tanitimyazisi + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                '}';
    }

}
