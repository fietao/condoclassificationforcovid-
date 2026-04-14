import java.util.ArrayList;
import java.io.IOException;

/**
 * Main entry point for Codon Analysis project.
 * 
 * PHASE 1: Load data and count codons
 * PHASE 2: Calculate RSCU values and generate reports
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Files
        String codonPath = "lab_materials/codons.csv";
        String repPath = "lab_materials/replicase.fasta";
        String spikePath = "lab_materials/spike.fasta";

        // 2. Loading the basic list
        ArrayList<CodonEntry> codonList = CodonProcessor.loadReference(codonPath);

        // 3. Loading the DNA sequences
        String repSeq = CodonProcessor.readDNA(repPath);
        String spikeSeq = CodonProcessor.readDNA(spikePath);

        // 4. Counting how many codons are in each region
        CodonProcessor.countCodons(repSeq, codonList, true);
        CodonProcessor.countCodons(spikeSeq, codonList, false);

        // TODO: Call the math logic here
        // TODO: Call the report generator here

        System.out.println("Part A Complete (Loading & Counting). Now you can implement Part B!");
    }
}
