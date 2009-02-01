/* LanguageTool, a natural language style checker 
 * Copyright (C) 2007 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

/*
 * Created on 23.12.2005
 */
package de.danielnaber.languagetool.tagging.xx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.danielnaber.languagetool.AnalyzedToken;
import de.danielnaber.languagetool.AnalyzedTokenReadings;
import de.danielnaber.languagetool.tagging.Tagger;

/**
 * A trivial tagger that does nothing than assign null
 * tags to words.
 * 
 * @author Daniel Naber
 */
public class DemoTagger implements Tagger {

  @Override
  public List<AnalyzedTokenReadings> tag(List<String> sentenceTokens) {

    List<AnalyzedTokenReadings> tokenReadings = new ArrayList<AnalyzedTokenReadings>();
    int pos = 0;
    for (Iterator<String> iter = sentenceTokens.iterator(); iter.hasNext();) {
    	String word = iter.next();
        List<AnalyzedToken> l = new ArrayList<AnalyzedToken>();
      // a real tagger would need to assign a POS tag
      // in the next line instead of null:
      l.add(new AnalyzedToken(word, null, pos));
      pos += word.length();
      tokenReadings.add(new AnalyzedTokenReadings(l.toArray(new AnalyzedToken[0])));
    }
    return tokenReadings;
  }

  @Override
  public AnalyzedTokenReadings createNullToken(String token, int startPos) {
	  return new AnalyzedTokenReadings(new AnalyzedToken(token, null, startPos));
  }

  @Override
  public AnalyzedToken createToken(String token, String posTag, int startPos) {
    return new AnalyzedToken(token, posTag, startPos);
  }

}
