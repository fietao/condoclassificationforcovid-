import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class CodonEntry {
    public String codon_sequence;
    public String amino_acid_name;
    public char amino_acid_symbol;

    public int codon_number;
    public int condon_spike;

    public double rscu_replicase;
    public double rscu_spike;


       public CodonEntry(String sequence, String name, char symbol) {
        this.codon_sequence = sequence;
        this.amino_acid_name = name;
        this.amino_acid_symbol = symbol;
        this.codon_number = 0;
        this.condon_spike = 0;
        this.rscu_replicase = 0.0;
        this.rscu_spike = 0.0;
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


    public double getCodonNumber() {
        return codon_number;
    }


    public void setCodonNumber(double codon_number) {
        this.codon_number = (int) codon_number;
    }


    public double getCondonSpike() {
        return condon_spike;
    }


    public void setCondonSpike(double condon_spike) {
        this.condon_spike = (int) condon_spike;
    }


    public double getRSUReplicase() {
        return rscu_replicase;
    }


    public void setRSUReplicase(double RSU_replicase) {
        this.rscu_replicase = RSU_replicase;
    }


    public double getRSUSpike() {
        return rscu_spike;
    }


    public void setRSUSpike(double RSU_spike) {
        this.rscu_spike = RSU_spike;
    }
}

