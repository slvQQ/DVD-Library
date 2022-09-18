package View;

import java.util.List;
import DataAccessObject.UserIO;
import DataTransferObject.DVD;

public class DVDLibraryView {

    UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add a DVD");
        io.print("3. Remove a DVD");
        io.print("4. Edit a DVD's Information");
        io.print("5. Search and view Information by DVD Title");
        io.print("6. Exit");

        return io.readInt("Please select from the above options", 1, 6);
    }

    public DVD getNewDvdInfo() {
        String dvdName = io.readString("Please enter DVD Title:");
        int releaseDate = io.readInt("Please enter release date:", 0, 2022);
        String mpaaRating = io.readString("Please enter the DVD's MPAA Rating:");
        String studio = io.readString("Please enter the studio:");
        String directorsName = io.readString("Please enter the director's name:");
        String userRating = io.readString("Please enter user rating:");

        DVD currentDvd = new DVD(dvdName);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setStudio(studio);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    }

    public DVD getEditDvdInfo(DVD dvd) {

        if (dvd != null) {

            int releaseDate = io.readInt("Please enter release date:", 0, 2022);
            String mpaaRating = io.readString("Please enter the DVD's MPAA Rating:");
            String directorsName = io.readString("Please enter the director's name:");
            String studio = io.readString("Please enter the studio:");
            String userRating = io.readString("Please enter user rating:");

            dvd.setReleaseDate(releaseDate);
            dvd.setMpaaRating(mpaaRating);
            dvd.setStudio(studio);
            dvd.setDirectorsName(directorsName);
            dvd.setUserRating(userRating);
        } else {
            io.print("DVD not found.");
        }
        return dvd;
    }

    public void displayDvdList(List<DVD> dvdList) {

        for (DVD currentDvd : dvdList) {
            io.print(currentDvd.getTitle() + ": " + currentDvd.getReleaseDate() + " " + currentDvd.getMpaaRating() + " "
                    + currentDvd.getStudio() + " " + currentDvd.getDirectorsName() + " " + currentDvd.getUserRating());
        }
        io.readString("Please press enter to continue.");
    }

    public void displayDvd(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle() + ": " + dvd.getReleaseDate() + " " + dvd.getMpaaRating() + " " + dvd.getStudio()
                    + " " + dvd.getDirectorsName() + " " + dvd.getUserRating());
        } else {
            io.print("DVD not found.");
        }

        io.readString("Please press enter to continue.");
    }

    public void displayListAllDvdsBanner() {
        io.print("---- DVD Collection ----");
    }

    public void displayAddDvdBanner() {
        io.print("---- Add DVD ----");
    }

    public void displayAddDvdSuccessBanner() {
        io.readString("DVD has successfully been added.  Please press enter to continue");
    }

    public void displayRemoveDvdBanner() {
        io.print("---- Remove DVD ----");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayRemoveDvdSuccessBanner() {
        io.readString("DVD has successfully been removed.  Please press enter to continue");
    }

    public void displayEditDvdBanner() {
        io.readString("Please enter the DVD you wish to edit.  Please press enter to continue");
    }

    public void displayEditDvdSuccessBanner() {
        io.readString("DVD has successfully been edited.  Please press enter to continue");
    }

    public void displaySearchDvdByNameBanner() {
        io.print("---- Search DVD By Name ----");
    }

    public void displayPromptToContinueBanner() {
        io.print("Please press enter to continue.");
    }

    public void displayExitBanner() {
        io.print("See you later!");
    }

    public void displayUnknownCommandBanner() {
        io.print("INVALID COMMAND");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("---- ERROR ----");
        io.print(errorMsg);
    }
}
