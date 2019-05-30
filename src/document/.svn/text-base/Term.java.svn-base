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

public class Term implements Comparable {
    public int termId;
    public String value;
    public float termFreq; // totally how many times this term was encountered.
    public int docCount; // in how many doc. this term appears.
    public Document lastDocument; // last document in which we have seen this term, needed for document count calculation

    public int compareTo(Object o) {
        if (o == null)
            return 1;
        
        if (o instanceof Term) {
            Term t = (Term)o;
            if (this.termId < t.termId)
                return -1;

            if (this.termId == t.termId)
                return 0;

            return 1;
        }
        else
            return -1;
    }
}
