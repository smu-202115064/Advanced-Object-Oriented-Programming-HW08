import java.util.Arrays;
import java.util.List;

public class CLinker implements Linker {
    final String INFO_MSG_LINKING = "Linking\n";

    @Override
    public Executable link(String exeFileName, ObjectCode[] objFiles) {
        return link(exeFileName, Arrays.asList(objFiles));
    }

    @Override
    public Executable link(String exeFileName, List<ObjectCode> objFiles) {
        String names = "";
        for (ObjectCode objectCode : objFiles) {
            names += "\n" + objectCode.getFileName();
        }
        System.out.print(INFO_MSG_LINKING);
        System.out.println(names);
        return new Executable(exeFileName, names);
    }
}
