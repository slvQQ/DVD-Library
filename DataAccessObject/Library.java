package DataAccessObject;

import DataTransferObject.DVD;
import java.util.List;

public interface Library {

    List<DVD> getAll() throws DVDLibraryException;

    DVD get(String dvdTitle) throws DVDLibraryException;

    DVD add(String dvdTitle, DVD dvd) throws DVDLibraryException;

    DVD remove(String dvdTitle) throws DVDLibraryException;
}
