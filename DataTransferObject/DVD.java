package DataTransferObject;

public class DVD {
    String title;
    int releaseDate;
    String mpaa_Rating;
    String directorsName;
    String studio;
    String userRating;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaa_Rating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaa_Rating = mpaaRating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
