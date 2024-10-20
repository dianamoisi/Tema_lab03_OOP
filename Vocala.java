import java.util.Scanner;

//4.3
public class Vocala {
    String cuvant;
    int nrVoc;
    int nrCons;

    public Vocala(String cuvant) {
        this.cuvant = cuvant;
        this.nrVoc = 0;
        this.nrCons = 0;
    }

    public int getNumarVocale() {
        this.nrVoc = 0;
        for(int i = 0; i < this.cuvant.length(); i++) {
            if(this.cuvant.charAt(i) == 'A' || this.cuvant.charAt(i) == 'E' || this.cuvant.charAt(i) == 'I' || this.cuvant.charAt(i) == 'O' || this.cuvant.charAt(i) == 'U') {
                this.nrVoc++;
            }
            if(this.cuvant.charAt(i) == 'a' || this.cuvant.charAt(i) == 'e' || this.cuvant.charAt(i) == 'i' || this.cuvant.charAt(i) == 'o' || this.cuvant.charAt(i) == 'u') {
                this.nrVoc++;
            }

        }
        return this.nrVoc;
    }
    public int getNumarConsoane() {
        this.nrCons = 0;
        for(int i = 0; i < this.cuvant.length(); i++) {
            if(this.cuvant.charAt(i) != 'A' && this.cuvant.charAt(i) != 'E' && this.cuvant.charAt(i) != 'I' && this.cuvant.charAt(i) != 'O' && this.cuvant.charAt(i) != 'U'
               && this.cuvant.charAt(i) != 'a' && this.cuvant.charAt(i) != 'e' && this.cuvant.charAt(i) != 'i' && this.cuvant.charAt(i) != 'o' && this.cuvant.charAt(i) != 'u' && this.cuvant.charAt(i) != ' ') {
                this.nrCons++;
            }
        }
        return this.nrCons;
    }

    public int[] getPosition(char s) {
        int[] table = new int[this.cuvant.length()];
        for(int i = 0; i < this.cuvant.length(); i++) {
            if(this.cuvant.charAt(i) == s) {
                table[i] = i;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        String contineVocala = " AbE edf io";
        Vocala vocala = new Vocala(contineVocala);

        System.out.println("numarul de vocale este: " + vocala.getNumarVocale());
        System.out.println("numarul de consoane este: " + vocala.getNumarConsoane());

        Scanner in = new Scanner(System.in);
        String insertString = in.nextLine();

        in.close();
        char vocChar = insertString.charAt(0);
        int[] table = vocala.getPosition(vocChar);
        for(int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }


    }
}
