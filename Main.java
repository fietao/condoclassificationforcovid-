import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class Main {

    /**
     * Main method that processes codon and DNA sequence data.
     * Loads codons from CSV, processes replicase and spike FASTA files.
     *
     * @param args Command line arguments (not used)
     * @throws IOException if any file reading operation fails
     */
    public static void main(String[] args) throws IOException {
        // Load codons from CSV file
        File condonsPath = new File("codons.csv");
        Scanner condonsFile = new Scanner(condonsPath);
        ArrayList<CodonEntry> codonList = new ArrayList<>();

        /** Skip header line from CSV */
        condonsFile.nextLine();

        /** Read codon data and populate list */
        while (condonsFile.hasNext()) {
            String nextLine = condonsFile.nextLine();
            String[] tokens = nextLine.split(",");
            String sequence = tokens[0];
            String name = tokens[1];
            char code = tokens[2].charAt(0);
            CodonEntry entry = new CodonEntry(sequence, name, code);
            codonList.add(entry);
        }
        condonsFile.close();
        System.out.println("Total codons: " + codonList.size());

        // Process replicase FASTA file
        StringBuilder dnaSequence = new StringBuilder();
        File replicasePath = new File("replicase.fasta");
        Scanner replicaseFile = new Scanner(replicasePath);

        /** Skip FASTA header line */
        replicaseFile.nextLine();

        /** Read and append sequence lines */
        while (replicaseFile.hasNext()) {
            String nextLine = replicaseFile.nextLine();
            dnaSequence.append(nextLine.trim());
        }
        replicaseFile.close();

        /** Convert to uppercase for matching */
        String finalSequence = dnaSequence.toString().toUpperCase();

        /** Extract codons and count occurrences in replicase */
        for (int i = 0; i <= finalSequence.length() - 3; i += 3) {
            String codon = finalSequence.substring(i, i + 3);
            for (CodonEntry entry : codonList) {
                if (entry.getCodonSequence().equals(codon)) {
                    entry.setCodonNumber(entry.getCodonNumber() + 1);
                    break;
                }
            }
        }
        System.out.println("Total codons in replicase: " + (finalSequence.length() / 3));

        // Process spike FASTA file
        dnaSequence = new StringBuilder();
        File spikePath = new File("spike.fasta");
        Scanner spikeFile = new Scanner(spikePath);

        /** Skip FASTA header line */
        spikeFile.nextLine();

        /** Read and append sequence lines */
        while (spikeFile.hasNext()) {
            String nextLine = spikeFile.nextLine();
            dnaSequence.append(nextLine.trim());
        }
        spikeFile.close();

        /** Convert to uppercase for matching */
        finalSequence = dnaSequence.toString().toUpperCase();

        /** Extract codons and count occurrences in spike */
        for (int i = 0; i <= finalSequence.length() - 3; i += 3) {
            String codon = finalSequence.substring(i, i + 3);
            for (CodonEntry entry : codonList) {
                if (entry.getCodonSequence().equals(codon)) {
                    entry.setCondonSpike(entry.getCondonSpike() + 1);
                    break;
                }
            }
        }
        System.out.println("Total codons in spike: " + (finalSequence.length() / 3));
    }
}
