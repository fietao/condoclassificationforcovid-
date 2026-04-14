import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CodonEntry {
    private String codon_sequence;
    private String amino_acid_name;

    private char amino_acid_symbol;
    private int codon_number;
    private int condon_spike;

    private double RSU_replicase;
    private double RSU_spike;
    
    public CodonEntry(String codon_sequence, String amino_acid_name, char amino_acid_symbol, int codon_number,
            int condon_spike, double RSU_replicase, double RSU_spike) {
        this.codon_sequence = codon_sequence;
        this.amino_acid_name = amino_acid_name;
        this.amino_acid_symbol = amino_acid_symbol;
        this.codon_number = codon_number;
        this.condon_spike = condon_spike;
        this.RSU_replicase = 0.00;
        this.RSU_spike = 0.00;
    }

    public String getCodonSequence() {
        return codon_sequence;
    }

    public void setCodonSequence(String codon_sequence) {
        this.codon_sequence = codon_sequence;
    }

    public String getAminoAcidName() {
        return amino_acid_name;
    }

    public void setAminoAcidName(String amino_acid_name) {
        this.amino_acid_name = amino_acid_name;
    }

    public char getAminoAcidSymbol() {
        return amino_acid_symbol;
    }

    public void setAminoAcidSymbol(char amino_acid_symbol) {
        this.amino_acid_symbol = amino_acid_symbol;
    }

    public int getCodonNumber() {
        return codon_number;
    }

    public void setCodonNumber(int codon_number) {
        this.codon_number = codon_number;
    }

    public int getCondonSpike() {
        return condon_spike;
    }

    public void setCondonSpike(int condon_spike) {
        this.condon_spike = condon_spike;
    }

    public double getRSUReplicase() {
        return RSU_replicase;
    }

    public void setRSUReplicase(double RSU_replicase) {
        this.RSU_replicase = RSU_replicase;
    }

    public double getRSUSpike() {
        return RSU_spike;
    }

    public void setRSUSpike(double RSU_spike) {
        this.RSU_spike = RSU_spike;
    }
}