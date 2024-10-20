import java.math.BigDecimal;
import java.util.Random;

////4.6
//Implementați o aplicație pentru orice loterie în care să:
//a) calculați şansele de câştig la loterie (ex. 6 din 49)
//b) simulați extragerea numerelor la loterie (pentru generarea numerelor aleatoare folosiţi
//        Math.random)
//c) afişaţi în ordine crescătoare/descrescătoare numerele extrase la loterie fără a face sortări
//sau a folosi tablouri. (Sugestie: folosiţi împachetarea/despachetarea/extragerea de biţi stocaţi
//într-un long)


public class Loterie{
    int n;
    int k;

    public Loterie(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public BigDecimal factorial(int n) {
        BigDecimal a = new BigDecimal(1);
        for(int i = 1; i <= n; i++) {
            a = a.multiply(BigDecimal.valueOf(i));
        }
        return a;
    }

    public BigDecimal probabilitateCastig(int n, int k) {
        return  factorial(n).divide(factorial(k).multiply(factorial(n-k)));
    }

    public long extragereRandom(int n, int k) {
        Random r = new Random();
        long a = 0;
        for(int i = 0; i < k; i++) {
            int aux = r.nextInt(n) + 1;
            if(((1L<<aux) & a) == 0) {
                a = a |(1L<<aux);
            } else {
                i--;//ca sa realegem un numar, daca acesta s-a repetat
            }
        }
        return a;
    }

    public static void afisCrescator(long c) {
        for(int i = 1; i <= 49; i++) {
            if(((1L<<i) & c) != 0) {
                System.out.println(i);
            }
        }
    }

    public static void afisDescrescator(long c){
        for(int i = 49; i > 0; i--) {
            if(((1L<<i) & c) != 0) {
                System.out.println(i);
            }
        }
    }

    public static void main (String[] args){
        Loterie loterie = new Loterie(49, 6);
        //a)
        BigDecimal odds = loterie.probabilitateCastig(49, 6);
        System.out.println("sansa de castig la 6 din 49 este de 1 la " + odds);

        //b)
        long c = loterie.extragereRandom(49, 6);

        //c)
        afisCrescator(c);
        afisDescrescator(c);
    }
}