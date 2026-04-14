import java.util.List;

/**
 * CodonEntry represents a single codon with its amino acid info and counts.
 */
public class CodonEntry {
    // Codon data
    public String codon_sequence;
    public String amino_acid_name;
    public char amino_acid_symbol;

    // Codon counts from each region
    public int codon_count_replicase;  // count in replicase region
    public int codon_count_spike;      // count in spike region

    // RSCU values (Phase 2)
    public double rscu_replicase;
    public double rscu_spike;

    /**
     * Constructor for a codon entry.
     */
    public CodonEntry(String sequence, String name, char symbol) {
        this.codon_sequence = sequence;
        this.amino_acid_name = name;
        this.amino_acid_symbol = symbol;
        this.codon_count_replicase = 0;
        this.codon_count_spike = 0;
        this.rscu_replicase = 0.0;
        this.rscu_spike = 0.0;
    }

    /**
     * PHASE 2: Calculate RSCU (Relative Synonymous Codon Usage) values.
     * For each amino acid group:
     *   1. Count codons with same symbol (ni = number of synonyms)
     *   2. Sum all counts for that amino acid (sum_replicase, sum_spike)
     *   3. Calculate RSCU = (individual_count * ni) / sum
     */
    public static void calculateRSCU(List<CodonEntry> entries) {
        String allSymbols = "ARNDCQEGHILKMFPSTWYV_";

        // For each unique amino acid symbol
        for (char symbol : allSymbols.toCharArray()) {
            // Count synonymous codons (ni)
            int ni = 0;
            int sum_replicase = 0;
            int sum_spike = 0;

            // Count synonyms and sum their occurrences
            for (CodonEntry entry : entries) {
                if (entry.amino_acid_symbol == symbol) {
                    ni++;
                    sum_replicase += entry.codon_count_replicase;
                    sum_spike += entry.codon_count_spike;
                }
            }

            // Calculate RSCU for each codon with this symbol
            if (ni > 0) {
                for (CodonEntry entry : entries) {
                    if (entry.amino_acid_symbol == symbol) {
                        if (sum_replicase > 0) {
                            entry.rscu_replicase = (entry.codon_count_replicase * ni) / (double) sum_replicase;
                        }
                        if (sum_spike > 0) {
                            entry.rscu_spike = (entry.codon_count_spike * ni) / (double) sum_spike;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%c): rep=%d spike=%d | rscu_rep=%.4f rscu_spike=%.4f",
                codon_sequence, amino_acid_symbol, codon_count_replicase, codon_count_spike,
                rscu_replicase, rscu_spike);
    }
}
