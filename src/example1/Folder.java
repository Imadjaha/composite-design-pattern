package example1;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemElement {

    private String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemElement element) {
        children.add(element);
    }

    public void remove(FileSystemElement element) {
        children.remove(element);
    }

    @Override
    public void display(String prefix) {
        System.out.println(prefix + " Folder " + name);
        for (FileSystemElement child : children) {
            child.display(prefix + " "); // show recursively children
        }
    }
}
