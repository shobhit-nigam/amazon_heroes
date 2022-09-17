public class DocumentationSRP {
  String version;
  String author;
  String text;

  String replaceWord(String word, String newWord) {
    return text.replace(word, newWord);
  }

  boolean hasWord(String word) {
    return text.contains(word);
  }
}

class DocumentDisplay {
  void display() {
    // display the text
  }
}
