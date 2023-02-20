package bolum13_collections_project.udemyKursPlayer;

import java.util.ArrayList;

public class Kurs {

    private String kursAdi;
    private ArrayList<Ders> kurstakiDersler;   //Ders sınıfı veri tipinden arraylist oluşturuyorum.
    private ArrayList<Egitmen> kursEgitmenleri;

    //ders sayisi en az 5 ve toplam içerik en az 60 dk olmalı  bunun için boolean deger tanımlıyorum.
    private boolean yayinda;
    private  ArrayList<Ogrenci> kursOgrencileri;


    public Kurs(String kursAdi, Egitmen basEgitmen) {
        this.kursAdi = kursAdi;
        this.kurstakiDersler = new ArrayList<>();
        this.kursEgitmenleri = new ArrayList<>();
        kursEgitmenleri.add(0, basEgitmen);
        this.yayinda = false;
        this.kursOgrencileri = new ArrayList<>();
    }


    //kurs>Ogrencilerinin getterını alıyorum cunku bu listeyi ogrenci sınıfı içnde kullanmak istiyorum.
    public ArrayList<Ogrenci> getKursOgrencileri() {
        return kursOgrencileri;
    }

    //kursAdi getter oluşturuyorum cunku başka sınıfta kullanacağım.
    public String getKursAdi() {
        return kursAdi;
    }

    //kurstaki derslerin de getter metotlarını oluşturuyorum:
    public ArrayList<Ders> getKurstakiDersler() {
        return kurstakiDersler;
    }

    //yukarıdaki nesneleri private yaptım, haliyle main sınıfından erişemeyeceğim,okuyup ekleme silme yapabilmek için
    //public metodlarını oluşturmalıyım:
    public void kursaEgitmenEkle(Egitmen yeniEgitmen){
        if(kursEgitmenleri.contains(yeniEgitmen)){
            kursEgitmenleri.add(yeniEgitmen);
        }else{
            System.out.println(yeniEgitmen.getIsim() + " zaten kursta tanımlı bir egitmeni eklemeye çalışıyorsunuz.");
        }

    }


    public void kurstanEgitmenSil(Egitmen silinecekEgitmen){
        if(silinecekEgitmen.getIsim().equals(kursEgitmenleri.get(0).getIsim())){
            System.out.println(silinecekEgitmen.getIsim()+ " kursun baş eğitmenidir o yüzden silinemez.");
        }else {
            kursEgitmenleri.remove(silinecekEgitmen);
            System.out.println(silinecekEgitmen.getIsim()+ " kurs eğitmenliğinden kaldırılmıştır.");
        }

    }


    //kursa dersk ekleyebilmem lazım:
    public void kursaDersEkle(Ders eklenecekDers){
        kurstakiDersler.add(eklenecekDers);
    }
    public int kurstakidersSayisi(){
        return kurstakiDersler.size();
    }


    private int kurstakiToplamDerslerinDakikaSuresi(){
        double toplamSure=0;
        for(Ders ders : kurstakiDersler){

            toplamSure = toplamSure + ders.getDakika();
        }
        return (int)toplamSure;
    }


    public boolean kursYayindaKontrol(){
        if(kurstakiDersler.size() >= 5 && kurstakiToplamDerslerinDakikaSuresi()>60){
            yayinda = true;
            return true;
        }else{
            return false;
        }
    }



}
