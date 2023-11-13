public class CCompiler implements Compiler {
    final String INFO_MSG_COMPILING = "Compiling code: %s\n";
    final String INFO_MSG_GENERATING = "Generating object code: %s\n";

    @Override
    public ObjectCode compile(SourceCode sourceCode) {
        ObjectCode objectCode;
        System.out.printf(INFO_MSG_COMPILING, sourceCode.getFileName());
        objectCode = new ObjectCode(sourceCode.getFileName().replace(".c", ".obj"));
        System.out.printf(INFO_MSG_GENERATING, objectCode.getFileName());
        return objectCode;
    }
}
