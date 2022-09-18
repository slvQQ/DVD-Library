import Controller.DVD_Library_Controller;
import DataAccessObject.UserConsoleIO;
import DataAccessObject.DVDLibrary;
import DataAccessObject.UserIO;
import View.DVDLibraryView;

public class DVDLibraryApp {

    public static void main(String[] args) {

        UserIO userIO = new UserConsoleIO();
        DVDLibrary dvdLibrary = new DVDLibrary();
        DVDLibraryView dvdLibraryView = new DVDLibraryView(userIO);
        DVD_Library_Controller controller = new DVD_Library_Controller(dvdLibrary, dvdLibraryView);
        controller.run();

    }





}
