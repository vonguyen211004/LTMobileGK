package due.giuaky221121514224.model;

public class Contact {
    private String name;
    private String phone;
    private int avatarResId;  // Đảm bảo trường avatar là kiểu int

    public Contact(String name, String phone, int avatarResId) {
        this.name = name;
        this.phone = phone;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAvatar() {
        return avatarResId;
    }
}
