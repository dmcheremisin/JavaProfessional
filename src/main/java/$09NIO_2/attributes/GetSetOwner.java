package $09NIO_2.attributes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * Created by Dmitrii on 20.03.2018.
 */
public class GetSetOwner {
    public static void main(String[] args) {
        try {
            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
            UserPrincipal dmitrii = lookupService.lookupPrincipalByName("dmitrii");
            System.out.println(dmitrii); // DMITRII\ (Domain)
            UserPrincipal system = lookupService.lookupPrincipalByName("system");
            System.out.println(system); // NT AUTHORITY\СИСТЕМА (Well-known group)

            Path file = Paths.get("C:\\files\\file.txt");
            // another approach to get UserPrincipal
            dmitrii = file.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("dmitrii");
            System.out.println(Files.getOwner(file).getName()); // DMITRII\Dmitrii

            Files.setOwner(file, system); // Can't get/set owner for: C:\files\file.txt
        } catch (IOException e) {
            System.out.println("Can't get/set owner for: " + e.getMessage());
        }
    }
}
