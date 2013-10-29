
/**
 * 
 */
package ac.uk.susx.tag.wikipedia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.wikipedia.miner.comparison.ArticleComparer;
import org.wikipedia.miner.model.Wikipedia;
import org.wikipedia.miner.util.WikipediaConfiguration;
import org.xml.sax.SAXException;

/**
 * Handles all Wikipedia interaction.
 * Initialise Wikipedia Miner.
 * Create a Wikiepedia object
 * Create an Article Comparer
 * Close Wikipedia
 * 
 * @author nikos
 *
 */
public class WikipediaCommunicator {
	
	
	//instance variables
	private Wikipedia wikipedia;
	private ArticleComparer comparer;

	/**
	 * Initialise Wikipedia and ArticleComparer objects
	 * 
	 * @param wikiPath: path to a wikipedia configuration xml file (see wikipedia miner documentation)
	 */
	public WikipediaCommunicator(String wikiPath)
	{
		WikipediaConfiguration conf;
		try {
			
			conf = new WikipediaConfiguration(new File("/home/aletras/wikipedia-miner/configs/wikipediaConfig.xml"));
			
			wikipedia = new Wikipedia(conf,false);
			
			comparer = new ArticleComparer(wikipedia);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	//methods
	
	/**
	 * Return a Wikipedia object
	 * 
	 * @return wikipedia:Wikipedia
	 */
	public Wikipedia getWikipedia()
	{
		return wikipedia;
	}
	
	
	/**
	 * Return an ArticleComparer object
	 * 
	 * @return comparer:ArticleComparer
	 */
	public ArticleComparer getArticleComparer()
	{
		return comparer;
	}
	
	
	/**
	 * Close Wikipedia to release memory
	 */
	public void closeWiki()
	{
		wikipedia.close();
	}


}
