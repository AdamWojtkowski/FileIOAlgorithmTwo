package us.mattgreen;

public class MovieRating {
    private String acct;
    private int rating;
    private int count;

    public MovieRating(String acct, int rating, int count) {
        super();
        this.acct = acct;
        this.rating = rating;
        this.count = count;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MovieRating{" +
                "acct='" + acct + '\'' +
                ", rating=" + rating +
                ", count=" + count +
                '}';
    }
}
