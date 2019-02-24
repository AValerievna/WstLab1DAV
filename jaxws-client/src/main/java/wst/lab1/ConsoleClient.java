package wst.lab1;

import wst.lab1.ws.Menagerie;
import wst.lab1.ws.MenagerieService;
import wst.lab1.ws.MenagerieServiceService;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConsoleClient {
    public static void main(String... args) throws IOException {
        URL url = new URL("http://localhost:9090/menagerie?wsdl");
        MenagerieServiceService menagerieService = new MenagerieServiceService(url);
        MenagerieService menageriePort = menagerieService.getMenagerieServicePort();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int currentState = 0;

        while (true) {
            switch (currentState) {
                case 0:
                    System.out.println("\nChoose option:");
                    System.out.println("1.Get all");
                    System.out.println("2.Filter option");
                    System.out.println("3.Create option");
                    System.out.println("4.Edit option");
                    System.out.println("5.Delete option");
                    System.out.println("6.Exit");
                    currentState = readState(currentState, reader);
                    break;
                case 1:
                    System.out.println("All animals:");
                    menageriePort.findAll().stream().map(ConsoleClient::menagerieToString).forEach(System.out::println);
                    currentState = 0;
                    break;
                case 2:
                    System.out.println("\nFill in the value of filter, if you'd like to");
                    System.out.println("id:");
                    Long id = readLong(reader);
                    System.out.println("animal:");
                    String animal = readString(reader);
                    System.out.println("name:");
                    String name = readString(reader);
                    System.out.println("breed:");
                    String breed = readString(reader);
                    System.out.println("health:");
                    String health = readString(reader);
                    System.out.println("arrival(yyyy-mm-dd):");
                    XMLGregorianCalendar arrival = readDate(reader);
                    System.out.println("Found:");
                    menageriePort.filter(id, animal, name, breed, health, arrival).stream().map(ConsoleClient::menagerieToString).forEach(System.out::println);
                    currentState = 0;
                    break;
                case 3:
                    System.out.println("\nFill in all fields");
                    String createAnimal;
                    do {
                        System.out.println("animal:");
                        createAnimal = readString(reader);
                    } while (createAnimal == null);
                    String createName;
                    do {
                        System.out.println("breed:");
                        createName = readString(reader);
                    } while (createName == null);
                    String createBreed;
                    do {
                        System.out.println("name:");
                        createBreed = readString(reader);
                    } while (createBreed == null);
                    String createHealth;
                    do {
                        System.out.println("health:");
                        createHealth = readString(reader);
                    } while (createHealth == null);
                    XMLGregorianCalendar createArrival;
                    do {
                        System.out.println("arrival(yyyy-mm-dd):");
                        createArrival = readDate(reader);
                    } while (createArrival == null);
                    Long createdId = 0L;
                    System.out.println("new ID: " + createdId);
                    currentState = 0;
                    break;
                case 4:
                    Long updateId;
                    do {
                        System.out.println("Edit note ID");
                        updateId = readLong(reader);
                    } while (updateId == null);

                    if (updateId == 0L) {
                        currentState = 0;
                        break;
                    }
                    System.out.println("animal:");
                    String updateAnimal = readString(reader);
                    System.out.println("breed:");
                    String updateName = readString(reader);
                    System.out.println("name:");
                    String updateBreed = readString(reader);
                    System.out.println("health:");
                    String updateHealth = readString(reader);
                    System.out.println("arrival(yyyy-mm-dd):");
                    XMLGregorianCalendar updateArrival = readDate(reader);
                    System.out.println("Value was changed");
                    currentState = 0;
                    break;
                case 5:
                    Long deleteId;
                    do {
                        System.out.println("Delete note ID:");
                        deleteId = readLong(reader);
                    } while (deleteId == null);
                    if (deleteId == 0L) {
                        currentState = 0;
                        break;
                    }
                    System.out.println("Value was deleteds");
                    currentState = 0;
                    break;
                case 6:
                    return;
                default:
                    currentState = 0;
                    break;
            }
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        String trim = reader.readLine().trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim;
    }

    private static XMLGregorianCalendar readDate(BufferedReader reader) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date rd = sdf.parse(reader.readLine());
            XMLGregorianCalendar arrival;

            GregorianCalendar c = new GregorianCalendar();

            if (rd != null) {
                c.setTime(rd);
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            } else {
                return null;
            }
        } catch (java.lang.Exception e) {
            return null;
        }
    }

    private static Long readLong(BufferedReader reader) {
        try {
            return Long.parseLong(reader.readLine());
        } catch (java.lang.Exception e) {
            return null;
        }
    }

    private static int readState(int current, BufferedReader reader) {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (java.lang.Exception e) {
            return current;
        }
    }

    private static String menagerieToString(Menagerie menagerie) {
        return "Menagerie(" +
                "id=" + menagerie.getId() +
                ", animal=" + menagerie.getAnimal() +
                ", name=" + menagerie.getName() +
                ", breed=" + menagerie.getBreed() +
                ", health=" + menagerie.getHealth() +
                ", arrival=" + menagerie.getArrival() +
                ")";
    }

}