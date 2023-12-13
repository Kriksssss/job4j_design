package ru.job4j.serialization.json;

import javax.xml.bind.*;
import java.io.File;

public class JAXBExample {
    public static void main(String[] args) {
        try {
            UserProfile userProfile = new UserProfile(
                    true, 25, "JohnDoe",
                    new Address("New York", "USA"),
                    new String[]{"Reading", "Traveling"}
            );

            File file = new File("userProfile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(UserProfile.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userProfile, file);

            System.out.println("XML-представление объекта успешно записано в файл userProfile.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("userProfile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            UserProfile userProfile = (UserProfile) unmarshaller.unmarshal(file);

            System.out.println("Десериализованный объект:\n" + userProfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

