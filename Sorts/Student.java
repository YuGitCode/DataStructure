public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }

    // Setters
    public void setId(int id) {
        this.id = id;

    }

    public void setname(String name) {
        this.name = name;

    }

    // Accessor
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.id + "," + this.name + "\n";
    }
}
