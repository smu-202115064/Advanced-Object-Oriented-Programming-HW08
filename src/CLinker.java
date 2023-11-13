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
        System.out.print(INFO_MSG_LINKING);
        StringBuilder sb = new StringBuilder();
        for (ObjectCode objectCode : objFiles) {
            System.out.println(objectCode.getFileName());
            sb.append('\n').append(objectCode.getFileName());
        }
        return new Executable(exeFileName, sb.toString());
    }
}
