public class CPreprocessor implements Preprocessor {
    final String INFO_MSG_PREPROCESSING = "Preprocessing code: %s\n";
    final String INFO_MSG_GENERATING = "Generating a new code: %s\n";
    final String PREPROCESSED_FILENAME = "preprocessed_%s";

    @Override
    public SourceCode preprocess(SourceCode sourceCode) {
        SourceCode preprocessed;
        System.out.printf(INFO_MSG_PREPROCESSING, sourceCode.getFileName());
        preprocessed = new SourceCode(PREPROCESSED_FILENAME.formatted(sourceCode.getFileName()));
        System.out.printf(INFO_MSG_GENERATING, preprocessed.getFileName());
        return preprocessed;
    }
}
