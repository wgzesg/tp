package storage.profile;

import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import org.junit.jupiter.api.Test;
import profile.Profile;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EXAMPLE_PROFILE_STRING;

class StorageTest {

    /**
     * Tests decodeProfile method of class Storage when data from file is valid.
     *
     * @throws SchwarzeneggerException If there are exceptions while decoding data.
     */
    @Test
    void testDecodeProfile_exampleProfileData_returnsExampleProfileString() throws SchwarzeneggerException,
            FileNotFoundException {
        Storage storage = new Storage();
        String inputFilePath = System.getProperty("user.dir") + "/src/test/java/storage/profile/exampleProfileData.txt";
        Profile testProfile = storage.decodeProfile(inputFilePath);
        assertEquals(EXAMPLE_PROFILE_STRING, testProfile.toString());
    }

    /**
     * Tests decodeProfile method of class Storage when data from file is invalid.
     */
    @Test
    void testDecodeProfile_invalidDataInput_throwsInvalidSaveFormatException() {
        Storage storage = new Storage();
        String inputFilePath = System.getProperty("user.dir") + "/src/test/java/storage/profile/invalidProfileData.txt";
        assertThrows(InvalidSaveFormatException.class, () -> {
            storage.decodeProfile(inputFilePath);
        });
    }
}
