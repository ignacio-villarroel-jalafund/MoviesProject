package entity;

/**
 * Class to define the variables and constants needed for the Movie entity.
 */
public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;
    private String title;
    private int priceCode;

    /**
     * 
     * @param title Title of the movie.
     * @param priceCode Price code asigned to the movie eg: REGULAR, NEW_RELEASE, CHILDREN.
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }
}
