package DataAccessObject;

import DataTransferObject.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class DVDLibrary implements Library{

    public static final String DVD_LIBRARY_FILE = new File("").getAbsolutePath() + "/src/Model/DvdLibraryData.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public List<DVD> getAll() throws DVDLibraryException {
        readDvdLibraryData();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public DVD get(String dvdTitle) throws DVDLibraryException {
        readDvdLibraryData();
        return dvds.get(dvdTitle);
    }

    @Override
    public DVD add(String dvdTitle, DVD dvd) throws DVDLibraryException {
        DVD newDvd = dvds.put(dvdTitle, dvd);
        updateDvdLibraryData();
        return newDvd;
    }

    @Override
    public DVD remove(String dvdTitle) throws DVDLibraryException {
        DVD removedDvd = dvds.remove(dvdTitle);
        updateDvdLibraryData();
        return removedDvd;
    }

    private void readDvdLibraryData() throws DVDLibraryException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryException("Sorry, an error occurred while the DVD Library Data was loading", e);
        }

        String[] currentDvdData;

        while (scanner.hasNextLine()) {
            currentDvdData = scanner.nextLine().split(DELIMITER);

            DVD currentDvd = new DVD(currentDvdData[0]);
            currentDvd.setReleaseDate(Integer.parseInt(currentDvdData[1]));
            currentDvd.setMpaaRating(currentDvdData[2]);
            currentDvd.setStudio(currentDvdData[3]);
            currentDvd.setDirectorsName((currentDvdData[4]));
            currentDvd.setUserRating(currentDvdData[5]);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    private void updateDvdLibraryData() throws DVDLibraryException {

        PrintWriter writer;

        try {
            writer = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryException("Sorry, an error occurred while the DVD Library Data was loading", e);
        }

        List<DVD> dvdList = this.getAll();
        for (DVD currentDvd : dvdList) {

            writer.println(currentDvd.getTitle() + DELIMITER + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER + currentDvd.getUserRating());
            writer.flush();
        }
        writer.close();
    }


}
