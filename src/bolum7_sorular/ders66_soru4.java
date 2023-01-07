//DESR66 - SORU4:
/*
SORU4: bir banka hesabı için sınıf tasarlayın. bu sınıfta hesabın kime ait oldugunu tutan
hesapNo, shesaptakiPara, paraYatirma ve cekme metotları olsun.
ayrıca bu hesaplarda olan tüm parayı, açılan hesap sayısını, yapılan
toplam para cekme ve yatırma sayısını gosteren bir metot ve iki hesabı para değişkenine
gore birbiriyle kıyaslayacak metot bulunmalı.
 */


package bolum7_sorular;

public class ders66_soru4 {
    public static void main(String[] args) {

        BankaHesap emre = new BankaHesap(123, 500);
        BankaHesap hasan = new BankaHesap(125, 900);
        BankaHesap ayse = new BankaHesap(186,456);
        BankaHesap.bankaOzetiGoster();

        ayse.paraYatir(1000);
        emre.paraCek(350);
        BankaHesap.bankaOzetiGoster();

        ayse.kiyasla(emre);

    }
}

class BankaHesap{
    /*
    static yapmali miyim? bilgiler her kişinin kendine oxgu yani nesneye bağlı,
    bu nedenle static kulllanmamıza gerek yok.
     */

    private int hesapNo;
    private int hesapBakiye;
    /* soruda bir de butun para istenmiş, yani butun banka nesnelerinin
     kullanabilecegi bir şeyden bahsediliyo, static değişken kullanacagız:*/
    private static int tumBankaBakiyesi=0;
    private static int tumHesapSayisi=0;
    private static int operasyonSayisi=0;

    /*peki bu tumBankaBakiyesine nasıl erişecegiz, nasıl kullanacagız?
    ne zaman ki buraya bir para yatırılacak; o zaman constructor olusturalım:*/

    public BankaHesap(int hesapNo, int hesapBakiye){ //constructor yazıyorum:
        this.hesapBakiye = hesapBakiye;
        this.hesapNo = hesapNo;
        tumBankaBakiyesi += hesapBakiye;
        tumHesapSayisi ++;
    }


   /*hesapNO ve hesapBkaiye için private yaptıktan sonra bilgileri okumak
   ve veri yazmak için generate diyip getter setterlarını oluşturuyorum:*/

    public int getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(int hesapNo) {
        this.hesapNo = hesapNo;
    }

    public int getHesapBakiye() {
        return hesapBakiye;
    }

    public void setHesapBakiye(int hesapBakiye) {
        this.hesapBakiye = hesapBakiye;
    }

    /*sonra para yatırma ve cekme metotlarımız olmalıymış,
    bunlar dışarıya ozgu olmalıdır, o nedenle public yapıyorum
     */

    public void paraYatir(int paraMiktari){
        this.hesapBakiye += paraMiktari;
        operasyonSayisi ++; // işlem bitince operasyonSayisi bir arttırılsın
    }

    public void paraCek(int paraMiktari){
        if(this.hesapBakiye>= paraMiktari){
            this.hesapBakiye -= paraMiktari;
            operasyonSayisi ++;
            tumBankaBakiyesi -= paraMiktari;
        } else{
            System.out.println("hesabinizda yeterli bakiye bulunmamaktadir.");
        }

    }

    public static void bankaOzetiGoster(){ //bu metot nesneye değil sınıfa bağlıdır.
        System.out.println("bankadaki hesap sayisi: " +tumHesapSayisi);
        System.out.println("bankadaki toplam para: "+tumBankaBakiyesi);
        System.out.println("bankada yapılan tum operasyonlarin sayisi: " +operasyonSayisi);

    }

    //son olarak iki hesabı para değişkenine gore birbiriyle kıyaslamamız istenmiş
    //nesneler soz konusu oldugu için buradaki metot static olmayacak:
    public void kiyasla(BankaHesap kiyaslanacakHesap){ // parantez içi int sayi1 gibi düsün
        if(this.getHesapBakiye() < kiyaslanacakHesap.getHesapBakiye()){
            System.out.println(this.getHesapNo()+ "nolu kisinin parası" +kiyaslanacakHesap.getHesapNo()+
                    "nolu kisinin parasindan azdir.");
        }else if(this.getHesapBakiye() > kiyaslanacakHesap.getHesapBakiye()){
            System.out.println(this.getHesapNo()+ "nolu kisinin parası" +kiyaslanacakHesap.getHesapNo()+
                    "nolu kisinin parasindan fazladir.");
        }else{
            System.out.println(this.getHesapNo()+ "nolu kisinin parası" +kiyaslanacakHesap.getHesapNo()+
                    "ve nolu kisinin parasi esittir.");

        }
    }
}