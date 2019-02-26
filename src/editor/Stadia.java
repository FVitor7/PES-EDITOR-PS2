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

import java.io.UnsupportedEncodingException;

public class Stadia {
	//static final byte total = 21;
	static final byte total = 17; //offset

	static final int nameAdr = 7608; //offset

	static final byte maxLen = 61; //offset

	static final int switchAdr = nameAdr + (maxLen * total);

	static final int nameAdr10 = 7504; //offset

	static final int nameAdr09 = 7300; //offset

	static final int nameAdr08 = 7196; //offset

	static final int nameAdr6 = 9544; //offset

	static final int nameAdr5 = 9508; //offset

	static String get(OptionFile of, int s) {
		byte len;
		int a;
		String name = "";
		if (of.version10)
			a = nameAdr10 + (s * maxLen);
		else if (of.version09)
			a = nameAdr09 + (s * maxLen);
		else if (of.version08)
			a = nameAdr08 + (s * maxLen);
		else if (of.version6)
			a = nameAdr6 + (s * maxLen);
		else if (of.version5)
			a = nameAdr5 + (s * maxLen);
		else
			a = nameAdr + (s * maxLen);
		len = 0;
		if (of.newVersion) {
			if (of.data[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version13) {
			if (of.data13[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data13[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data13, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version12) {
			if (of.data12[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data12[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data12, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version11) {
			if (of.data11[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data11[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data11, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version10) {
			if (of.data10[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data10[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data10, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version09) {
			if (of.data09[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data09[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data09, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version08) {
			if (of.data08[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data08[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data08, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version6) {
			if (of.data6[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data6[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data6, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		} else if (of.version5) {
			if (of.data5[a] != 0) {
				for (byte i = 0; len == 0 && i < maxLen; i++) {
					if (len == 0 && of.data5[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data5, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(s) + ">";
				}
			} else {
				name = "<" + String.valueOf(s) + ">";
			}
		}
		return name;
	}

	static String[] get(OptionFile of) {
		String[] stadia = new String[total];
		for (byte s = 0; s < total; s++) {
			stadia[s] = get(of, s);
		}
		return stadia;
	}

	static void set(OptionFile of, int sn, String name) {
		if (name.length() < maxLen && name.length() > 0) {
			int a = nameAdr + (sn * maxLen);
			int sa = switchAdr + sn;
			byte[] tb = new byte[maxLen];
			byte[] sb;
			try {
				sb = name.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				sb = new byte[maxLen - 1];
			}
			if (sb.length <= maxLen - 1) {
				System.arraycopy(sb, 0, tb, 0, sb.length);
			} else {
				System.arraycopy(sb, 0, tb, 0, maxLen - 1);
			}
			System.arraycopy(tb, 0, of.data, a, maxLen);
			of.data[sa] = 1;
		}
	}

	static void importData(OptionFile ofs, OptionFile ofd) {
		if (ofs.newVersion)
			System.arraycopy(ofs.data, nameAdr, ofd.data, nameAdr, Leagues.nameAdr
				- nameAdr);
		else if (ofs.version13)
			System.arraycopy(ofs.data13, nameAdr, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version12)
			System.arraycopy(ofs.data12, nameAdr, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version11)
			System.arraycopy(ofs.data11, nameAdr, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version10)
			System.arraycopy(ofs.data10, nameAdr10, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version09)
			System.arraycopy(ofs.data09, nameAdr09, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version08)
			System.arraycopy(ofs.data08, nameAdr08, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version6)
			System.arraycopy(ofs.data6, nameAdr6, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
		else if (ofs.version5)
			System.arraycopy(ofs.data5, nameAdr5, ofd.data, nameAdr, Leagues.nameAdr
					- nameAdr);
	}

}
