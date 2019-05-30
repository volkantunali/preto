/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package document;

import org.lemurproject.kstem.KrovetzStemmer;

/**
 *
 * @author volkan
 */
public class KStemmer implements Stemmer {
    private KrovetzStemmer kstemmer = new KrovetzStemmer();
    
    public String stem(String str) {
        return kstemmer.stem(str);
    }
    
}
