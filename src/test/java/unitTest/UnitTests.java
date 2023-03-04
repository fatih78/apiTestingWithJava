package unitTest;

import org.junit.Assert;
import org.junit.Test;
import utils.Key;
import utils.TestDataGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class UnitTests {

    @Test
    public void testCurrentDate() {
        var firstDate = TestDataGenerator.currentDate();
        var secondDate = firstDate.minusDays(1);
        Assert.assertEquals(secondDate, firstDate.minusDays(1));
    }

    @Test
    public void testFutureDate() {
        var futureDateOne = TestDataGenerator.futureDate(1, "yyyy-MM-dd");
        var futureDateTwo = TestDataGenerator.futureDate(3, "yyyy-MM-dd");
        var futureDateNow = TestDataGenerator.futureDate(0, "yyyy-MM-dd");

        Assert.assertNotEquals(futureDateOne, futureDateTwo);
        Assert.assertEquals(futureDateNow, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Test
    public void testRandomEmail() {
        var email = TestDataGenerator.generateRandomEmail();
        System.out.println(email);
        Assert.assertTrue(email.contains("@gmail.com"));
    }

    @Test
    public void testEncodedEmail() {
        var encodedMail = TestDataGenerator.generateEncodedEmail();
        Assert.assertTrue(encodedMail.contains("%2B"));
    }

    @Test
    public void testRandomName() {
        var name = TestDataGenerator.generateDrink();
        System.out.println(name);
        Assert.assertTrue(name.contains("A") || name.contains("B") || name.contains("C") || name.contains("D") || name.contains("E") || name.contains("F") || name.contains("G") ||
                name.contains("H") || name.contains("I") || name.contains("J") || name.contains("K") || name.contains("L") || name.contains("M") || name.contains("N") ||
                name.contains("O") || name.contains("P") || name.contains("Q") || name.contains("R") || name.contains("S") || name.contains("T") || name.contains("U") ||
                name.contains("V") || name.contains("W") || name.contains("X") || name.contains("Y") || name.contains("Z"));
    }

    @Test
    public void testUUIDGenerator() {
        var uuId = TestDataGenerator.generateUUID();
        Assert.assertTrue(uuId.contains("-"));
    }

    @Test
    public void testTimeStampGenerator() {
        var ts = TestDataGenerator.generateTimeStamp();
        Assert.assertTrue(ts.contains(":"));
    }

    @Test
    public void testRandomInt() {
        var number = TestDataGenerator.generateRandomInt();
        Assert.assertTrue(number <= 10000);
    }

    @Test
    public void test_X_API_KEY() {
        var number = Key.getKey();
        Assert.assertTrue(number == "1234");
    }


}
