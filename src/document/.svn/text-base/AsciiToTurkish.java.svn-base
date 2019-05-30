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

public class AsciiToTurkish {
    private static Zemberek zemberek = new Zemberek(DilBilgisiUretici.dilAyarUret(DilBilgisiUretici.TR_SINIF));

    public static String AsciiToTurkish(String str)
    {
        String[] ascii_to_tr_list = zemberek.asciidenTurkceye(str);
        if (ascii_to_tr_list.length > 0) {
            str = ascii_to_tr_list[0];
        }

        return str;
    }
}
