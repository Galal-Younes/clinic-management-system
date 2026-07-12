public class Person {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String location;

    //No-Arg Constructor
    Person() {
        name = null;
        id = null;
        phone = null;
        location = null;
        age = 0;
    }

    //parametrized Constructor
    Person(String name, String id, int age, String phone, String location) {
        setName(name);
        setId(id);
        setAge(age);
        setPhone(phone);
        setLocation(location);

    }

    //copy constructor
    Person(Person p) {
        this(p.name, p.id, p.age, p.phone, p.location);
    }

    public void setId(String id) {
        //id should be 5 numbers
        if (id.length() != 5) {
            System.out.println("Please Enter An Id From 5 Numbers");
            return;
        }
            this.id = id;

    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Please Enter A Valid Name");
            return;
        }
        this.name = name;

    }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            System.out.println("Please Enter A Valid Age");
        }
    }

    public void setPhone(String phone) {
        if (phone.length() != 11) {
            System.out.println("Please Enter A Valid Phone");
            return;
        }
        this.phone = phone;
    }

    public void setLocation(String location) {
        if (location.isEmpty()) {
            System.out.println("Please Enter A Valid Location");
            return;
        }
        this.location = location;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age +
                        ", phone='" + phone + '\'' +
                        ", location='" + location + '\'';
    }
}

