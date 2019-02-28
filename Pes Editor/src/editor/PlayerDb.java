/*
 * Copyright 2008-9 Compulsion
 * <pes_compulsion@yahoo.co.uk>
 * <http://www.purplehaze.eclipse.co.uk/>
 * <http://uk.geocities.com/pes_compulsion/>
 *
 * This file is part of PES Editor.
 *
 * PES Editor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PES Editor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PES Editor.  If not, see <http://www.gnu.org/licenses/>.
 */

package editor;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class PlayerDb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;

	public int index;

	public int adr;

	public byte[] dbBytes = new byte[124];

	static final int total = 1088; //offset
	static final int total2 = 830; //offset

	static byte[] extPlayers = new byte[134912];
	static byte[] ext2Players = new byte[102920];
	
	public PlayerDb(byte[] dbIn, int i, boolean lower) throws IOException {
		if (dbIn == null)
			throw new NullPointerException();
		boolean end;
		int a = 0;
		int offSet = i * 124;
		byte[] nameDbBytes = new byte[32];
		System.arraycopy(dbIn, a + offSet, nameDbBytes, 0, 32);
		end = false;
		int len = 0;
		for (int j = 0; !end && j < nameDbBytes.length - 1; j = j + 2) {
			if (nameDbBytes[j] == 0 && nameDbBytes[j + 1] == 0) {
				end = true;
				len = j;
			}
		}
		byte[] t;
		if (lower) {
			try {
				name = new String(nameDbBytes, 0, len, "UTF-16LE");
				name = GlobalPanel.capitalizeFully(name);
				t = name.getBytes("UTF-16LE");
			} catch (UnsupportedEncodingException e) {
				name = "<Error " + String.valueOf(index) + ">";
				t = new byte[30];
			}
		} else {
			try {
				name = new String(nameDbBytes, 0, len, "UTF-16LE");
				name = name.toUpperCase();
				t = name.getBytes("UTF-16LE");
			} catch (UnsupportedEncodingException e) {
				name = "<Error " + String.valueOf(index) + ">";
				t = new byte[30];
			}
		}
		if (t.length <= 30) {
			System.arraycopy(t, 0, nameDbBytes, 0, t.length);
		} else {
			System.arraycopy(t, 0, nameDbBytes, 0, 30);
		}
		if (dbIn.length == extPlayers.length) {
			System.arraycopy(dbIn, a + offSet, extPlayers, a + offSet, 124);
			System.arraycopy(nameDbBytes, 0, extPlayers, a + offSet, 32);
		} else {
			System.arraycopy(dbIn, a + offSet, ext2Players, a + offSet, 124);
			System.arraycopy(nameDbBytes, 0, ext2Players, a + offSet, 32);
		}
	}
}
