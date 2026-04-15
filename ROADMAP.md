PHASE 1 — Understand the inputs (before writing a single line)

Read lab09-definitions.pdf so you know what RSCU, codon bias, synonymous codons, etc. actually mean
Read RSCU_formula.pdf so you know the exact math + the category labels (Favored / Neutral / etc.)
Open codons.csv and understand its structure — 3 columns: codon sequence, amino acid full name, single-letter code
Open both .fasta files and understand the format — there's a header line starting with >, then raw nucleotide sequence


PHASE 2 — Design your classes (on paper first)

Design CodonEntry — it holds: codon sequence, AA name, AA letter, replicase count, spike count, replicase RSCU, spike RSCU
Decide what methods your Main class needs — rough list:

parseFasta(filename) → returns cleaned nucleotide string
splitIntoCodons(sequence) → returns list of 3-letter codon strings
loadCodons(csvFile) → builds your list of CodonEntry objects
countCodons(codonList, entries) → fills in the counts
calculateRSCU(entries, region) → runs the RSCU formula
writeCSV(entries, filename, region) → outputs the csv files
writeComparison(entries) → outputs the comparison csv
writeFavoredReport(entries) → outputs spike_favored.txt




PHASE 3 — Build incrementally

Write CodonEntry first — just the fields and a constructor
Write loadCodons() — read the CSV, create one CodonEntry per row, store in an ArrayList
Write parseFasta() — strip the > header line, concatenate remaining lines, uppercase everything
Write splitIntoCodons() — loop through the string 3 chars at a time
Write countCodons() — for each codon string you split out, find the matching CodonEntry and increment its count
Write calculateRSCU() — group entries by amino acid, apply the formula from the PDF
Test against H1N1 first (pb1 = replicase, ha = spike) — match the provided sample output before touching COVID data


PHASE 4 — Output generation

Write replicase_rscu.csv — 7 columns per the spec
Write spike_rscu.csv — same 7 columns
Write rscu_comparison.csv — 9 columns, including UP/DOWN column
Write spike_favored.txt — UP codons first, then DOWN codons, with the 4 required fields each