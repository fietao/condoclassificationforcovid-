# Project Roadmap: SARS-CoV-2 RSCU Analysis

## ✅ Phase 1: Reading Data
- [x] **Load Codons**: Read `codons.csv` into a list of `CodonEntry` objects.
- [x] **Load DNA**: Read both FASTA files and strip the header lines.

## ✅ Phase 2: Counting Codons
- [x] **countTriplets**: Loop through DNA 3 letters at a time and increment `codon_number` (replicase) or `condon_spike` (spike) on each matching entry.

## 🔜 Phase 3: RSCU Math (Your Turn)
Implement `calculateRSCU` in [CodonEntry.java](CodonEntry.java).

For each unique amino acid symbol in `allSymbols`:
1. Count how many codons share that symbol → **ni** (number of synonyms)
2. Sum all counts for that symbol → **sumRep**, **sumSpike**
3. For each codon with that symbol:
   - `RSU_replicase = (codon_number * ni) / sumRep`  ← only if sumRep > 0
   - `RSU_spike     = (condon_spike  * ni) / sumSpike` ← only if sumSpike > 0

## 🔜 Phase 4: Output (Your Turn)
Write `saveCSV` in [Main.java](Main.java) and call it at the end of `main`.

The output file `rscu_comparison.csv` should have this header:
```
Codon,Code,RepRSU,SpikeRSU,Diff
```
Then one row per `CodonEntry` with `codon_sequence`, `amino_acid_symbol`, `RSU_replicase`, `RSU_spike`, and the difference (`RSU_spike - RSU_replicase`).
