package _001_JavaBeans.XMLEncoderAndDecoder;


import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by mdolat on 13.06.2017 , 21:20.
 *
 */
public class DecodeTest {
    public static void main(String[] args){
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream("TestExploit.xml")
                    )
            );

            Example example = (Example) xmlDecoder.readObject();
            System.out.println(example);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
