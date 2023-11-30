//import java.sq;.{Connection, DriverManager, ResultSet}
import java.io.FileInputStream
import opennlp.tools.namefind.{NameFinderME, TokenNameFinderModel}
import opennlp.tools.tokenize.*
import opennlp.tools.util.Span

object Main25 {
    def main(args:Array[String]): Unit = {
        val tokenizerModelIn = new FileInputStream("en-token.bin")
        val tokenizerModel = new opennlp.tools.tokenize.TokenizerModel(tokenizerModelIn)
        val tokenizer = new opennlp.tools.tokenize.TokenizerME(tokenizerModel)
        // Load NER model
        val nerModelIn = new FileInputStream("en-ner-person.bin")
        val nerModel = new TokenNameFinderModel(nerModelIn)
        val ner = new NameFinderME(nerModel)

  		// Define some sample text
        val text = "John Smith is a software engineer at Google."

        // Tokenize the text
        val tokens = tokenizer.tokenize(text)

  		// Find the named entities in the text
        val spans = ner.find(tokens)

        // Print the named entities and their types
        for(span <- spans) 
        {
            val entityType = span.getType
            val entity = tokens.slice(span.getStart, span.getEnd).mkString("")
            println(s"$entityType: $entity")
        }
    }
}