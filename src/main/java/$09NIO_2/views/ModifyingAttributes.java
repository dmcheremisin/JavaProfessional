package $09NIO_2.views;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by Dmitrii on 21.03.2018.
 */
public class ModifyingAttributes {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("src\\main\\resources\\sample.txt");
            DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
            DosFileAttributes data = view.readAttributes();
            FileTime time = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000);
            view.setTimes(time, null, null);
        } catch (IOException e){}
    }
}
