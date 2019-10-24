package puc.pos.schoolsupply.repository.util;

import java.io.InputStream;

public class ResourcesManipulator {

    public static InputStream getResourceStream(String fileName){
        return ResourcesManipulator.class.getClassLoader().getResourceAsStream(fileName);
    }

}
