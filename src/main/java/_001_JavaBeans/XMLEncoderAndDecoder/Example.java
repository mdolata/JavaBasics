package _001_JavaBeans.XMLEncoderAndDecoder;


import java.io.Serializable;

/**
 * Created by mdolat on 11.06.2017 , 22:19.
 *
 */
public class Example implements Serializable{
    private Integer value;
    private String description;
    private Example example;

    public Example() {
    }

    public Example(String description) {
        this.description = description;
    }

    public Example(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Example(Integer value, String description, Example example) {
        this.value = value;
        this.description = description;
        this.example = example;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Example{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", example=" + example +
                '}';
    }
}
