import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        File f = new File ("C:\Users\georg\OneDrive\Desktop\condoclassificationforcovid--main\CodonEntry.java");
        Scanner infile=new Scanner(f);

        ArrayList<CodonEntry> CodonEntry = new ArrayList<CodonEntry>(65);
        String Codon,AA_Name,AA_Code;

        infile.nextline();


         while (infile.hasNext())
        {
            nextLine = infile.nextLine();
            String[] tokens = nextLine.split(",");

            String codon_sequence, String amino_acid_name; 
            char amino_acid_symbol;
            double codon_number, double condon_spike, double RSU_replicase, double RSU_spike;

            Codon = tokens[0];
            //we don't need [1] - that's land area
            AA_Name = Double.parseDouble(tokens[2]);
            AA_Code = Double.parseDouble(tokens[3]);
            //we don't need [4] - that's rural percentage
            lifeExpPass = Double.parseDouble(tokens[5]);
            countries.add(new CountryRecord(Codon, AA_Name, AA_Code));
        }
        infile.close();
    }

}