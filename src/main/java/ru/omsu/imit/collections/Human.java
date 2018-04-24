package ru.omsu.imit.collections;

public class Human {
    protected String name, surname, patronym;
    protected int age;

    public Human(String name, String surname, int age) {
        this.patronym = "";
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Human(String name, String surname, String patronym, int age) {
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (age != human.age) return false;
        if (!name.equals(human.name)) return false;
        if (!surname.equals(human.surname)) return false;
        return patronym != null ? patronym.equals(human.patronym) : human.patronym == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (patronym != null ? patronym.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
