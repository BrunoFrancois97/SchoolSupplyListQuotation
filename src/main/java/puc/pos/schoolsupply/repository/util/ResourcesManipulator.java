package puc.pos.schoolsupply.repository.util;

public class ResourcesManipulator {

    public static String getResourcePath(String fileName){
        String s = ResourcesManipulator.class.getClassLoader().getResource("").toString() + fileName;
        s = s.replace("file:/", "");
        return s;
    }

}
