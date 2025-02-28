package model.beans;

public class Client {
   
    private int id;
    private String nom;
    private String age;
    
    public Client() {
    }

    public Client(int id, String nom, String age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return nom;
    }

    public String getAge() {
        return age;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.nom = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}