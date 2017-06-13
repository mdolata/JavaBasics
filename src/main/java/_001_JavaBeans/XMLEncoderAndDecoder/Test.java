package _001_JavaBeans.XMLEncoderAndDecoder;

import java.beans.*;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by mdolat on 11.06.2017 , 22:09 , 19:36.
 *
 */
public class Test {

    public static void main(String[] args){

        Example temp = new Example(1,"Pies");
        Example content = new Example(1,"Al2a",temp);
        XMLEncoder xmlEncoder;

        try {
            xmlEncoder = getEncoder("file");


            final PersistenceDelegate persistenceDelegate = getPersistenceDelegate("default");
            if (persistenceDelegate != null){
                xmlEncoder.setPersistenceDelegate(Example.class,persistenceDelegate);
            }
            xmlEncoder.writeObject(content);
            System.out.println(content);
            xmlEncoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private static XMLEncoder getEncoder(String mode) throws FileNotFoundException {
        if (mode == null){
            return null;
        }

        XMLEncoder encoder = null;
        switch (mode){
            case "sout": encoder = new XMLEncoder(System.out); break;
            case "file": encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream("Test.xml")));
        }
        return encoder;
    }

    private static PersistenceDelegate getPersistenceDelegate(String mode){

        if (mode == null){
            return null;
        }

        PersistenceDelegate persistenceDelegate = null;
        switch (mode){
            case "default" :  break;
            case "defaultPDwithDescription":
                persistenceDelegate = new DefaultPersistenceDelegate(new String[]{"description"});
                break;
            case "customPD":
                persistenceDelegate = new PersistenceDelegate() {
                    @Override
                    protected Expression instantiate(Object oldInstance, Encoder out) {
                        return new Expression(oldInstance,
                                oldInstance.getClass(),
                                "new",
                                new Object[]{oldInstance.toString()});
                    }
                };
                 break;
        }
        return persistenceDelegate;
    }
}
