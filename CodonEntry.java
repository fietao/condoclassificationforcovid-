import java.util.List;

public class CodonEntry 
{
    // ============ DATA FIELDS ============
    
    public String codon_sequence;
    public String amino_acid_name;
    public char amino_acid_symbol;
    
    public int codon_count_replicase;
    public int codon_count_spike;
    
    public double rscu_replicase;
    public double rscu_spike;

    
    // ============ CONSTRUCTOR ============
    
    public CodonEntry(String sequence, String name, char symbol) 
    {
        this.codon_sequence = sequence;
        this.amino_acid_name = name;
        this.amino_acid_symbol = symbol;
        this.codon_count_replicase = 0;
        this.codon_count_spike = 0;
        this.rscu_replicase = 0.0;
        this.rscu_spike = 0.0;
    }

    
    // ============ PHASE 2: RSCU CALCULATION ============
    
    public static void calculateRSCU(List<CodonEntry> entries) 
    {
        String allSymbols = "ARNDCQEGHILKMFPSTWYV_";

        for (char symbol : allSymbols.toCharArray()) 
        {
            int ni = 0;
            int sum_replicase = 0;
            int sum_spike = 0;

            // Count synonymous codons and sum their occurrences
            for (CodonEntry entry : entries) 
            {
                if (entry.amino_acid_symbol == symbol) 
                {
                    ni++;
                    sum_replicase += entry.codon_count_replicase;
                    sum_spike += entry.codon_count_spike;
                }
            }

            // Calculate RSCU for each codon with this symbol
            if (ni > 0) 
            {
                for (CodonEntry entry : entries) 
                {
                    if (entry.amino_acid_symbol == symbol) 
                    {
                        if (sum_replicase > 0) 
                        {
                            entry.rscu_replicase = (entry.codon_count_replicase * ni) / (double) sum_replicase;
                        }
                        if (sum_spike > 0) 
                        {
                            entry.rscu_spike = (entry.codon_count_spike * ni) / (double) sum_spike;
                        }
                    }
                }
            }
        }
    }

    
    // ============ OUTPUT ============
    
    @Override
    public String toString() 
    {
        return String.format(
            "%s (%c): rep=%d spike=%d | rscu_rep=%.4f rscu_spike=%.4f",
            codon_sequence, amino_acid_symbol, codon_count_replicase, codon_count_spike,
            rscu_replicase, rscu_spike
        );
    }
}
