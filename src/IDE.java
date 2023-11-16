import java.util.Arrays;
import java.util.List;

public class IDE implements Builder {
    private String projectName = null;
    private final Preprocessor preprocessor = new CPreprocessor();
    private final Compiler compiler = new CCompiler();
    private final Linker linker = new CLinker();

    @Override
    public void createProject(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public Executable build(List<SourceCode> sourceCodes) {
        List<ObjectCode> objectCodes = sourceCodes.stream()
                .map(preprocessor::preprocess)
                .map(compiler::compile)
                .toList();
        return linker.link(projectName+".exe", objectCodes);
    }

    @Override
    public Executable build(SourceCode[] files) {
        ObjectCode[] objs = new ObjectCode[files.length];
        for (int i = 0; i < files.length; i++) {
            SourceCode c = preprocessor.preprocess(files[i]);
            objs[i] = compiler.compile(c);
        }
        return linker.link(projectName, objs);
    }
}
