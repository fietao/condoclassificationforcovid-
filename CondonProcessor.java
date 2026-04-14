import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class CondonProcessor 
{
    
    // ============ PHASE 1A: LOAD CODON REFERENCE ============
    
    public static ArrayList<CodonEntry> loadReference(String csvPath) throws IOException 
    {
        ArrayList<CodonEntry> codons = new ArrayList<>();
        Scanner sc = new Scanner(new File(csvPath));

        while (sc.hasNextLine()) 
        {
            String line = sc.nextLine().trim();
            
            if (line.isEmpty() || line.startsWith("CODON")) 
            {
                continue;
            }

            String[] parts = line.split(",");
            
            if (parts.length >= 3) 
            {
                String sequence = parts[0].trim();
                String name = parts[1].trim();
                char symbol = parts[2].trim().charAt(0);
                
                codons.add(new CodonEntry(sequence, name, symbol));
            }
        }
        
        sc.close();
        return codons;
    }

    
    // ============ PHASE 1B: READ DNA SEQUENCE ============
    
    public static String readDNA(String fastaPath) throws IOException 
    {
        StringBuilder dna = new StringBuilder();
        Scanner sc = new Scanner(new File(fastaPath));

        while (sc.hasNextLine()) 
        {
            String line = sc.nextLine().trim();
            
            if (!line.startsWith(">")) 
            {
                dna.append(line.toUpperCase());
            }
        }
        
        sc.close();
        return dna.toString();
    }

    
    // ============ PHASE 1C: COUNT CODONS ============
    
    public static void countCodons(String dna, ArrayList<CodonEntry> codons, boolean isReplicase) 
    {
        for (int i = 0; i <= dna.length() - 3; i += 3) 
        {
            String triplet = dna.substring(i, i + 3);

            for (CodonEntry codon : codons) 
            {
                if (codon.codon_sequence.equals(triplet)) 
                {
                    if (isReplicase) 
                    {
                        codon.codon_count_replicase++;
                    } 
                    else 
                    {
                        codon.codon_count_spike++;
                    }
                    
                    break;
                }
            }
        }
    }
}
