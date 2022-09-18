package Controller;

import java.util.List;
import DataAccessObject.DVDLibrary;
import DataAccessObject.DVDLibraryException;
import View.DVDLibraryView;
import DataTransferObject.DVD;

public class DVD_Library_Controller {

    DVDLibrary dvdLibrary;
    DVDLibraryView dvdLibraryView;

    public DVD_Library_Controller(DVDLibrary dvdLibrary, DVDLibraryView dvdLibraryView) {
        this.dvdLibrary = dvdLibrary;
        this.dvdLibraryView = dvdLibraryView;
    }

    public void run() {

        boolean running = true;
        int menuSelection = 0;

        try {
            while (running) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        addDvd();
                        break;
                    case 3:
                        removeDvd();
                        break;
                    case 4:
                        editDvd();
                        break;
                    case 5:
                        searchAndViewDvd();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        unknownCommand();
                }

            }

        } catch (DVDLibraryException e) {
            dvdLibraryView.displayErrorMessage(e.getMessage());
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return dvdLibraryView.printMenuAndGetSelection();
    }

    private void listDvds() throws DVDLibraryException {
        dvdLibraryView.displayListAllDvdsBanner();
        List<DVD> dvdList = dvdLibrary.getAll();
        dvdLibraryView.displayDvdList(dvdList);
    }

    private void addDvd() throws DVDLibraryException {
        dvdLibraryView.displayAddDvdBanner();
        DVD newDvd = dvdLibraryView.getNewDvdInfo();
        dvdLibrary.add(newDvd.getTitle(), newDvd);
        dvdLibraryView.displayAddDvdSuccessBanner();
    }

    private void removeDvd() throws DVDLibraryException {
        dvdLibraryView.displayRemoveDvdBanner();
        String dvdTitle = dvdLibraryView.getDvdTitleChoice();
        dvdLibrary.remove(dvdTitle);
        dvdLibraryView.displayRemoveDvdSuccessBanner();
    }

    private void editDvd() throws DVDLibraryException {
        dvdLibraryView.displayEditDvdBanner();
        String dvdTitle = dvdLibraryView.getDvdTitleChoice();
        DVD dvd = dvdLibrary.get(dvdTitle);
        dvdLibraryView.getEditDvdInfo(dvd);
        dvdLibrary.add(dvdTitle, dvd);
        dvdLibraryView.displayEditDvdSuccessBanner();
    }

    private void searchAndViewDvd() throws DVDLibraryException {
        dvdLibraryView.displaySearchDvdByNameBanner();
        String dvdTitle = dvdLibraryView.getDvdTitleChoice();
        DVD dvd = dvdLibrary.get(dvdTitle);
        dvdLibraryView.displayDvd(dvd);
    }

    private void unknownCommand() {
        dvdLibraryView.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        dvdLibraryView.displayExitBanner();
    }
}
