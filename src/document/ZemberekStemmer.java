/*
    Copyright 2011, 2012 Volkan TUNALI
    This file is part of PRETO.

    PRETO is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PRETO is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with PRETO.  If not, see <http://www.gnu.org/licenses/>.
 */

package document;

import net.zemberek.erisim.DilBilgisiUretici;
import net.zemberek.erisim.Zemberek;
import net.zemberek.yapi.Kok;

public class ZemberekStemmer implements Stemmer {

    private Zemberek zemberek = new Zemberek(DilBilgisiUretici.dilAyarUret(DilBilgisiUretici.TR_SINIF));
    /*
    private boolean use_ascii_to_TR = false;
     */
    private boolean use_longest_stem = false;

    public ZemberekStemmer(boolean pUse_longest_stem) {
        super();
        use_longest_stem = pUse_longest_stem;
        /*
        use_ascii_to_TR = pUse_ascii_to_TR;
         */
    }

    private String findStem(String str) {
        Kok[] kokler = zemberek.kokBulucu().kokBul(str);
        if (kokler.length > 0)
        {
            if (use_longest_stem)
            {
                int maxIndex = 0;
                int maxLen = 0;
                int i = 0;
                for(Kok k:kokler)
                {
                    int len = k.icerik().length();
                    if (len > maxLen)
                    {
                        maxLen = len;
                        maxIndex = i;
                    }
                    i++;
                }
                return kokler[maxIndex].icerik();
            }
            else
                return kokler[0].icerik();
        }
        return null;
    }

     public String stem(String str) {
        String kok = findStem(str);
        if (kok != null)
            return kok;
         else
            return str;
    }
}
