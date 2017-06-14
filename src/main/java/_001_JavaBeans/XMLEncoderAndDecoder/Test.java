package _001_JavaBeans.XMLEncoderAndDecoder;

import java.beans.*;
import java.io.*;

/**
 * Created by mdolat on 11.06.2017 , 22:09 , 19:36.
 *
 */
public class Test {

    public static void main(String[] args){

        Example temp = new Example(1,"Pies");
        Example content = new Example(1,"Al2a",temp);
        String transientProperty = "";
        try {

            final XMLEncoder xmlEncoder = getEncoder(XMLEncoderEnum.TO_FILE);
            final PersistenceDelegate persistenceDelegate = getPersistenceDelegate(PDEnum.DEFAULT);
            if (persistenceDelegate != null){
                xmlEncoder.setPersistenceDelegate(Example.class,persistenceDelegate);
            }
            setPropertiesTransient(Example.class, transientProperty);


            xmlEncoder.writeObject(content);
            xmlEncoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private static void setPropertiesTransient(Class clas,String property) throws IntrospectionException {
        if (clas == null || property == null){
            return;
        }
        BeanInfo info = Introspector.getBeanInfo(clas);
        PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
        for (PropertyDescriptor pd : propertyDescriptors)
            if (pd.getName().equals(property))
                pd.setValue("transient", Boolean.TRUE);
    }

    private static XMLEncoder getEncoder(XMLEncoderEnum mode) throws FileNotFoundException {
        if (mode == null){
            return null;
        }

        XMLEncoder encoder = null;
        switch (mode){
            case SYSTEM_OUT: encoder = new XMLEncoder(System.out); break;
            case TO_FILE: encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream("Test.xml"))); break;
        }
        return encoder;
    }

    private static PersistenceDelegate getPersistenceDelegate(PDEnum mode){

        if (mode == null){
            return null;
        }

        PersistenceDelegate persistenceDelegate = null;
        switch (mode){
            case DEFAULT: break;
            case DEFAULT_PD_DESCRIPTION:
                persistenceDelegate = new DefaultPersistenceDelegate(new String[]{"description"});
                break;
            case CUSTOM_PD:
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

    private enum PDEnum{
        DEFAULT, DEFAULT_PD_DESCRIPTION, CUSTOM_PD
    }

    private enum XMLEncoderEnum{
        SYSTEM_OUT, TO_FILE
    }
}
