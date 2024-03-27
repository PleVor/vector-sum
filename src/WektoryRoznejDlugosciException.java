public class WektoryRoznejDlugosciException extends Exception {
    private int dlugoscPierwszego;
    private int dlugoscDrugiego;

    public WektoryRoznejDlugosciException(int dlugoscPierwszego, int dlugoscDrugiego) {
        this.dlugoscPierwszego = dlugoscPierwszego;
        this.dlugoscDrugiego = dlugoscDrugiego;
    }

    public int getDlugoscPierwszego() {
        return dlugoscPierwszego;
    }

    public int getDlugoscDrugiego() {
        return dlugoscDrugiego;
    }
}
