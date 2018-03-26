package ssm.utils;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/10/6
 */

public class Property {
    private String name;
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
