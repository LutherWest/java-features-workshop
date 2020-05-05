package com.epam.features._5_text_blocks_preview;

/**
 * @since 13 preview
 * @since 14 second preview
 */
public class TextBlocks {
    public static void main(String[] args) {
        final var json = """
                         {
                             "name": "name",
                             "email": "email@example.com"
                         }
                          """;
        System.out.println(json);

        final var jsonWithExtraLine = """
                         {
                             "name": "name",
                             
                             "email": "email@example.com"
                         }
                          """;
        System.out.println(jsonWithExtraLine);

        final var jsonWithExtraTabs = """
                         {
                         \t"name": "name",
                         \n\t"email": "email@example.com"
                         }
                          """;
        System.out.println(jsonWithExtraTabs);

        final var jsonWithoutNewLine = """
                         {
                            "name": "name", \
                            "email": "email@example.com"
                         }
                          """;
        System.out.println(jsonWithoutNewLine);

        final var jsonWithMoreSpaces = """
                         {
                            "name": "name",                \s
                            "email": "email@example.com"
                         }
                          """;
        System.out.println(jsonWithMoreSpaces);

        final var formattedJson = """
                         {
                            "name": "%s",
                            "email": "%s"
                         }
                          """.formatted("name", "email");
        System.out.println(formattedJson);
    }
}
