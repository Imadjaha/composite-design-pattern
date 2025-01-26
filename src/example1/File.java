package example1;

public class File implements FileSystemElement {

    private String name;

    public File(String name){
        this.name = name;
    }

    @Override
    public  void display(String prefix){
        System.out.println(prefix + " File " + name);
    }
}
