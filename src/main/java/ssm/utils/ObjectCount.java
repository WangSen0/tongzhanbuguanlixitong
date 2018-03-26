package ssm.utils;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/20
 */
public class ObjectCount implements Comparable<ObjectCount>{
    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    @Override
    public int compareTo(ObjectCount objectCount){
        return this.getName().compareTo(objectCount.getName());
    }
}
