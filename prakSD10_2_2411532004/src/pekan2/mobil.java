package pekan2;


public class mobil {
    private String platNomor;

    public mobil(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    @Override
    public String toString() {
        return "Mobil dengan plat: " + platNomor;
    }
}



