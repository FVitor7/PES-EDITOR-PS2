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

public class Leagues {
	static final byte total = 33; //offset

	//static final int nameAdr = 9057;
	static final int nameAdr = 8724; //offset

	static final byte maxLen = 61; //offset

	static final byte fieldLen = 84; //offset

	static final int nameAdr13 = 8972;

	static final int nameAdr12 = 9179;

	static final int nameAdr11 = 9303;

	static final int nameAdr10 = 9261;

	static final int nameAdr09 = 9057;

	static final byte total08 = 28;
	static final int nameAdr08 = 9449;

	static final byte total6 = 29;
	static final int nameAdr6 = 11859;

	static final byte total5 = 28;
	static final int nameAdr5 = 11678;

	static final String[] def = { "International League", "English League",
			"NOT USED", "NOT USED", "Italian League", "NOT USED",
			"Spanish League", "League A", "League B", "League C", "League D",
			"NOT USED", "NOT USED", "NOT USED", "French League",
			"Dutch League", "ISS Cup", "England Cup", "French Cup", "NOT USED",
			"Italian Cup", "Netherlands Cup", "Spanish Cup",
			"International Cup", "European Cup", "African Cup", "American Cup",
			"Asia-Oceanian Cup", "Konami Cup", "D2 Cup", "D1 Cup",
			"European Masters Cup", "European Championship" }; //text

	static final String[] def08 = { "ISS", "England", "French", "German",
		"Italian", "Netherlands", "Spanish", "International", "European",
		"African", "American", "Asia-Oceanian", "Konami", "D2", "D1",
		"European Masters", "European Championship" };

	static final String[] def6 = { "ISS", "England", "French", "German",
		"Italian", "Netherlands", "Spanish", "International", "European",
		"African", "American", "Asia-Oceanian", "Konami", "D2", "D1",
		"European Masters", "European Championship", "Product Placement Cup" };

	static String[] def5 = { "ISS", "England", "French", "German", "Italian",
		"Netherlands", "Spanish", "International", "European", "African",
		"American", "Asia-Oceanian", "Konami", "D2", "D1", "WEFA Masters",
		"WEFA Championships", "International League" };

	static String get(OptionFile of, int l) {
		byte len;
		int a = 0;
		String name = "";
		if (of.newVersion)
			a = nameAdr + (l * fieldLen);
		else if (of.version13)
			a = nameAdr13 + (l * fieldLen);
		else if (of.version12)
			a = nameAdr12 + (l * fieldLen);
		else if (of.version11)
			a = nameAdr11 + (l * fieldLen);
		else if (of.version10)
			a = nameAdr10 + (l * fieldLen);
		else if (of.version09)
			a = nameAdr09 + (l * fieldLen);
		else if (of.version08)
			a = nameAdr08 + (l * fieldLen);
		else if (of.version6)
			a = nameAdr6 + (l * fieldLen);
		else if (of.version5)
			a = nameAdr5 + (l * fieldLen);
		len = 0;
		if (of.newVersion) {
			if (of.data[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data, a, len, "UTF-8");
					// System.out.println(len);
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def[l];
			}
		} else if (of.version13) {
			if (of.data13[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data13[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data13, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def[l];
			}
		} else if (of.version12) {
			if (of.data12[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data12[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data12, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def[l];
			}
		} else if (of.version11) {
			if (of.data11[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data11[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data11, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def[l];
			}
		} else if (of.version10) {
			if (of.data10[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data10[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data10, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def[l];
			}
		} else if (of.version09) {
			if (of.data09[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data09[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data09, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def[l];
			}
		} else if (of.version08) {
			if (of.data08[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data08[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data08, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def08[l];
			}
		} else if (of.version6) {
			if (of.data6[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data6[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data6, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def6[l];
			}
		} else if (of.version5) {
			if (of.data5[a + maxLen + 1] != 0) {
				for (byte i = 0; len == 0 && i < maxLen + 1; i++) {
					if (len == 0 && of.data5[a + i] == 0) {
						len = i;
					}
				}
				try {
					name = new String(of.data5, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					name = "<" + String.valueOf(l) + ">";
				}
			} else {
				name = def5[l];
			}
		}
		return name;
	}

	static String[] get(OptionFile of) {
		String[] leagues = new String[0];
		if (of.version08) {
			leagues = new String[total08];
			for (byte l = 0; l < total08; l++) {
				leagues[l] = get(of, l);
			}
		} if (of.version6) {
			leagues = new String[total6];
			for (byte l = 0; l < total6; l++) {
				leagues[l] = get(of, l);
			}
		} if (of.version5) {
			leagues = new String[total5];
			for (byte l = 0; l < total5; l++) {
				leagues[l] = get(of, l);
			}
		} else {
			leagues = new String[total];
			for (byte l = 0; l < total; l++) {
				leagues[l] = get(of, l);
			}
		}
		return leagues;
	}

	static void set(OptionFile of, int ln, String name) {
		if (name.length() <= maxLen && name.length() > 0) {
			int a = 0;
			if (of.newVersion)
				a = nameAdr + (ln * fieldLen);
			else if (of.version13)
				a = nameAdr13 + (ln * fieldLen);
			else if (of.version12)
				a = nameAdr12 + (ln * fieldLen);
			else if (of.version11)
				a = nameAdr11 + (ln * fieldLen);
			else if (of.version10)
				a = nameAdr10 + (ln * fieldLen);
			else if (of.version09)
				a = nameAdr09 + (ln * fieldLen);
			else if (of.version08)
				a = nameAdr08 + (ln * fieldLen);
			else if (of.version6)
				a = nameAdr6 + (ln * fieldLen);
			else if (of.version5)
				a = nameAdr5 + (ln * fieldLen);
			byte[] tb = new byte[maxLen + 2];
			byte[] sb;
			try {
				sb = name.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				sb = new byte[maxLen];
			}
			if (sb.length <= maxLen) {
				System.arraycopy(sb, 0, tb, 0, sb.length);
			} else {
				System.arraycopy(sb, 0, tb, 0, maxLen);
			}
			tb[maxLen + 1] = 1;
			// System.out.println(a);
			System.arraycopy(tb, 0, of.data, a, maxLen + 2);
		}
	}

	static void importData(OptionFile ofs, OptionFile ofd) {
		if (ofs.newVersion)
			System.arraycopy(ofs.data, nameAdr, ofd.data, nameAdr, fieldLen
						* total);
		else if (ofs.version13)
			System.arraycopy(ofs.data13, nameAdr13, ofd.data, nameAdr, fieldLen
					* total);
		else if (ofs.version12)
			System.arraycopy(ofs.data12, nameAdr12, ofd.data, nameAdr, fieldLen
					* total);
		else if (ofs.version11)
			System.arraycopy(ofs.data11, nameAdr11, ofd.data, nameAdr, fieldLen
					* total);
		else if (ofs.version10)
			System.arraycopy(ofs.data10, nameAdr10, ofd.data, nameAdr, fieldLen
					* total);
		else if (ofs.version09)
			System.arraycopy(ofs.data09, nameAdr09, ofd.data, nameAdr, fieldLen
					* total);
		else if (ofs.version08)
			System.arraycopy(ofs.data08, nameAdr08, ofd.data, nameAdr, fieldLen
					* total08);
		else if (ofs.version6)
			System.arraycopy(ofs.data6, nameAdr6, ofd.data, nameAdr, fieldLen
					* total6);
		else if (ofs.version5)
			System.arraycopy(ofs.data5, nameAdr5, ofd.data, nameAdr, fieldLen
					* total5);
	}

}
