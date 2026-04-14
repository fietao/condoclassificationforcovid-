import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 * PHASE 1: CodonProcessor handles file I/O and codon counting.
 */
public class CondonProcessor {

    /**
     * Load codon reference data from CSV file.
     * Format: CODON,AMINO_ACID_NAME,AMINO_ACID_SYMBOL
     */
    public static ArrayList<CodonEntry> loadReference(String csvPath) throws IOException {
        ArrayList<CodonEntry> codons = new ArrayList<>();
        Scanner sc = new Scanner(new File(csvPath));

        // Skip header line if present
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty() || line.startsWith("CODON")) continue;

            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String sequence = parts[0].trim();
                String name = parts[1].trim();
                char symbol = parts[2].trim().charAt(0);
                codons.add(new CodonEntry(sequence, name, symbol));
            }
        }
        sc.close();
        return codons;
    }

    /**
     * Read DNA sequence from a FASTA file (ignoring headers).
     */
    public static String readDNA(String fastaPath) throws IOException {
        StringBuilder dna = new StringBuilder();
        Scanner sc = new Scanner(new File(fastaPath));

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            // Skip FASTA headers (lines starting with '>')
            if (!line.startsWith(">")) {
                dna.append(line.toUpperCase());
            }
        }
        sc.close();
        return dna.toString();
    }

    /**
     * Count codon occurrences in a DNA sequence.
     * Reads 3 nucleotides at a time and matches against codon list.
     *
     * @param dna           the DNA sequence
     * @param codons        list of known codons
     * @param isReplicase   true for replicase region, false for spike region
     */
    public static void countCodons(String dna, ArrayList<CodonEntry> codons, boolean isReplicase) {
        // Process the DNA sequence 3 nucleotides at a time
        for (int i = 0; i <= dna.length() - 3; i += 3) {
            String triplet = dna.substring(i, i + 3);

            // Find matching codon and update count
            for (CodonEntry codon : codons) {
                if (codon.codon_sequence.equals(triplet)) {
                    if (isReplicase) {
                        codon.codon_count_replicase++;
                    } else {
                        codon.codon_count_spike++;
                    }
                    break;  // Found the codon, move to next triplet
                }
            }
        }
    }
}
