package at.refugeescode.mp16mypersonaltodolistui.model;

public class ToDo {

    private String id;

    private String name;

    private boolean done;

    public ToDo() {
    }

    public ToDo(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
