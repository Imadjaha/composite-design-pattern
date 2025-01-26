package example1;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder1 = new Folder("folder1");
        folder1.add(file1);
        folder1.add(file2);

        Folder rootFolder = new Folder("rootFolder");
        rootFolder.add(folder1);
        rootFolder.add(new File("file3.txt "));

        rootFolder.display("");

//
//        Code-Erklärung:
//        FileSystemElement (Komponente):
//
//        Die gemeinsame Schnittstelle, die die Methode display() definiert. Sowohl File als auch Folder
//        implementieren diese Methode.
//        File (Blatt):
//
//        Repräsentiert eine Datei. Die Methode display() zeigt nur den Dateinamen an.
//                Folder (Kompositum):
//
//        Repräsentiert einen Ordner. Er kann andere Dateien oder Ordner enthalten.
//                Die Methode display() ruft rekursiv display() für alle Kinder des Ordners auf.
//        Client:
//
//        Erstellt Dateien und Ordner und organisiert sie in einer Baumstruktur.
//        Verwendet die Methode display(), um die gesamte Struktur einheitlich anzuzeigen.

    }
}