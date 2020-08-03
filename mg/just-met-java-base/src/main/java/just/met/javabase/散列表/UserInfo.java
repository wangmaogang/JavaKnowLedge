package just.met.javabase.散列表;

/**
 * 测试实例对象
 */
public class UserInfo {

    public UserInfo(int id,String name){
        this.id = id;
        this.name = name;
    }

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
