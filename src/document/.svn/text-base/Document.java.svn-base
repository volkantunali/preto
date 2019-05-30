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

import java.util.TreeMap;

public class Document {
    public String documentName;
    // 05.11.2010 VT begin
    // public HashMap<Term, Integer> terms; // term by intra-doc-freq.
    public TreeMap<Term, Float> terms; // term by intra-doc-freq.
    // 05.11.2010 VT end

    public Document(String docName) {
        documentName = docName;
        // 05.11.2010 VT begin
        // terms = new HashMap<Term, Integer>();
        terms = new TreeMap<Term, Float>();
        // 05.11.2010 VT end
    }
}
