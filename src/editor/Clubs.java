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

import java.awt.Color;
import java.io.UnsupportedEncodingException;

public class Clubs {
	static final int total = 130; //offset

	//static final int startAdr = 739800;
	static final int startAdr = 730872; //offset

	static final int size = 88; //offset

	//static final int firstFlag = 349;
	static final int firstFlag = 348; //offset

	// static final int firstDefEmblem = 144;
	static final int firstDefEmblem = 143; //offset

	static final int startAdr13 = 739800;
	static final int firstFlag13 = 349;
	static final int firstDefEmblem13 = 144;

	static final int total12 = 135;
	static final int startAdr12 = 747248;
	static final int firstFlag12 = 354;
	static final int firstDefEmblem12 = 144;

	static final int total11 = 138;
	static final int startAdr11 = 758672;
	static final int firstFlag11 = 357;
	static final int firstDefEmblem11 = 142;

	static final int total10 = 138;
	static final int startAdr10 = 753488;
	static final int firstFlag10 = 316;
	static final int firstDefEmblem10 = 141;

	static final int total09 = 136;
	static final int startAdr09 = 748476;
	static final int firstFlag09 = 307;
	static final int firstDefEmblem09 = 134;

	static final int total08 = 148;
	static final int startAdr08 = 773820;
	static final int firstFlag08 = 307;
	static final int firstDefEmblem08 = 122;

	static final int total6 = 140;
	static final int startAdr6 = 751472;
	static final int firstFlag6 = 292;
	static final int firstDefEmblem6 = 115;

	static final int total5 = 138;
	static final int startAdr5 = 803608;
	static final int size5 = 140;
	static final int firstFlag5 = 284;
	static final int firstDefEmblem5 = 111;

	static int getEmblem(OptionFile of, int club) {
		int a = 0;
		if (of.newVersion)
			a = startAdr + 60 + (size * club);
		else if (of.version13)
			a = startAdr13 + 60 + (size * club);
		else if (of.version12)
			a = startAdr12 + 60 + (size * club);
		else if (of.version11)
			a = startAdr11 + 60 + (size * club);
		else if (of.version10)
			a = startAdr10 + 60 + (size * club);
		else if (of.version09)
			a = startAdr09 + 60 + (size * club);
		else if (of.version08)
			a = startAdr08 + 60 + (size * club);
		else if (of.version6)
			a = startAdr6 + 60 + (size * club);
		else if (of.version5)
			a = startAdr5 + 112 + (size5 * club);
		byte[] tb = new byte[2];
		if (of.newVersion)
			System.arraycopy(of.data, a, tb, 0, 2);
		else if (of.version13)
			System.arraycopy(of.data13, a, tb, 0, 2);
		else if (of.version12)
			System.arraycopy(of.data12, a, tb, 0, 2);
		else if (of.version11)
			System.arraycopy(of.data11, a, tb, 0, 2);
		else if (of.version10)
			System.arraycopy(of.data10, a, tb, 0, 2);
		else if (of.version09)
			System.arraycopy(of.data09, a, tb, 0, 2);
		else if (of.version08)
			System.arraycopy(of.data08, a, tb, 0, 2);
		else if (of.version6)
			System.arraycopy(of.data6, a, tb, 0, 2);
			else if (of.version5)
			System.arraycopy(of.data5, a, tb, 0, 2);
		return (of.toInt(tb[1]) << 8) | (of.toInt(tb[0]) & 0xFF);
	}

	static void importClub(OptionFile of1, int c1, OptionFile of2, int c2) {
		int a1 = startAdr + (size * c1);
		int a2 = 0;
		if (of2.newVersion)
			a2 = startAdr + (size * c2);
		else if (of2.version13)
			a2 = startAdr13 + (size * c2);
		else if (of2.version12)
			a2 = startAdr12 + (size * c2);
		else if (of2.version11)
			a2 = startAdr11 + (size * c2);
		else if (of2.version10)
			a2 = startAdr10 + (size * c2);
		else if (of2.version09)
			a2 = startAdr09 + (size * c2);
		else if (of2.version08)
			a2 = startAdr08 + (size * c2);
		else if (of2.version6)
			a2 = startAdr6 + (size * c2);
		else if (of2.version5)
			a2 = startAdr5 + (size5 * c2);
		byte t = of1.data[a1 + 54];
		if (of2.newVersion)
			System.arraycopy(of2.data, a2, of1.data, a1, size);
		else if (of2.version13)
			System.arraycopy(of2.data13, a2, of1.data, a1, size);
		else if (of2.version12)
			System.arraycopy(of2.data12, a2, of1.data, a1, size);
		else if (of2.version11)
			System.arraycopy(of2.data11, a2, of1.data, a1, size);
		else if (of2.version10)
			System.arraycopy(of2.data10, a2, of1.data, a1, size);
		else if (of2.version09)
			System.arraycopy(of2.data09, a2, of1.data, a1, size);
		else if (of2.version08)
			System.arraycopy(of2.data08, a2, of1.data, a1, size);
		else if (of2.version6)
			System.arraycopy(of2.data6, a2, of1.data, a1, size);
		else if (of2.version5)
			System.arraycopy(of2.data5, a2, of1.data, a1, size);
		of1.data[a1 + 54] = t;
		setNameEdited(of1, c1);
		setEmblemEdited(of1, c1, true);

		if (of2.version13) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version12) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version11) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version10) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version09) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version08) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version6) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else if (of2.version5) {
			int stad = 0;
			boolean found = false;
			for (int i = 0; i < Stadia.total; i++) {
				if (!found && Stadia.get(of2, getStadium(of2, c2)).equals(Stadia.get(of1, i))) {
					found = true;
					stad = i;
				}
			}
			setStadium(of1, c1, stad);
			setStadiumEdited(of1, c1);
		} else

		setStadiumEdited(of1, c1);
	}

	static void setEmblem(OptionFile of, int club, byte[] index) {
		boolean edited = true;
		if (index == null) {
			if (of.newVersion)
				index = of.getBytes(club + firstDefEmblem);
			else if (of.version13)
				index = of.getBytes(club + firstDefEmblem13);
			else if (of.version12)
				index = of.getBytes(club + firstDefEmblem12);
			else if (of.version11)
				index = of.getBytes(club + firstDefEmblem11);
			else if (of.version10)
				index = of.getBytes(club + firstDefEmblem10);
			else if (of.version09)
				index = of.getBytes(club + firstDefEmblem09);
			else if (of.version08)
				index = of.getBytes(club + firstDefEmblem08);
			else if (of.version6)
				index = of.getBytes(club + firstDefEmblem6);
			else if (of.version5)
				index = of.getBytes(club + firstDefEmblem5);
			edited = false;
		}
		int a = startAdr + 60 + (size * club);
		System.arraycopy(index, 0, of.data, a, 2);
		System.arraycopy(index, 0, of.data, a + 4, 2);
		setEmblemEdited(of, club, edited);
	}

	static void unAssEmblem(OptionFile of, int emblem) {
		if (of.version12) {
			for (int i = 0; i < total12; i++) {
				if (emblem == getEmblem(of, i) - firstFlag12) {
					setEmblem(of, i, null);
				}
			}
		} else if (of.version11) {
			for (int i = 0; i < total11; i++) {
				if (emblem == getEmblem(of, i) - firstFlag11) {
					setEmblem(of, i, null);
				}
			}
		} else if (of.version10) {
			for (int i = 0; i < total10; i++) {
				if (emblem == getEmblem(of, i) - firstFlag10) {
					setEmblem(of, i, null);
				}
			}
		} else if (of.version09) {
			for (int i = 0; i < total09; i++) {
				if (emblem == getEmblem(of, i) - firstFlag09) {
					setEmblem(of, i, null);
				}
			}
		} else if (of.version08) {
			for (int i = 0; i < total08; i++) {
				if (emblem == getEmblem(of, i) - firstFlag08) {
					setEmblem(of, i, null);
				}
			}
		} else if (of.version6) {
			for (int i = 0; i < total6; i++) {
				if (emblem == getEmblem(of, i) - firstFlag6) {
					setEmblem(of, i, null);
				}
			}
		} else if (of.version5) {
			for (int i = 0; i < total5; i++) {
				if (emblem == getEmblem(of, i) - firstFlag5) {
					setEmblem(of, i, null);
				}
			}
		} else {
			for (int i = 0; i < total; i++) {
				if (of.newVersion) {
					if (emblem == getEmblem(of, i) - firstFlag) {
						setEmblem(of, i, null);
					}
				} else if (of.version13) {
					if (emblem == getEmblem(of, i) - firstFlag13) {
						setEmblem(of, i, null);
					}
				}
			}
		}
	}

	static String[] getNames(OptionFile of) {
		if (of.version12) {
			String[] clubs = new String[total12];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else if (of.version11) {
			String[] clubs = new String[total11];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else if (of.version10) {
			String[] clubs = new String[total10];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else if (of.version09) {
			String[] clubs = new String[total09];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else if (of.version08) {
			String[] clubs = new String[total08];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else if (of.version6) {
			String[] clubs = new String[total6];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else if (of.version5) {
			String[] clubs = new String[total5];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		} else {
			String[] clubs = new String[total];
			for (int c = 0; c < clubs.length; c++) {
				clubs[c] = getName(of, c);
			}
			return clubs;
		}
	}

	static String getName(OptionFile of, int c) {
		String club = "";
		int len = 0;
		if (of.newVersion) {
			int a = startAdr + (c * size);
			if (of.data[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version13) {
			int a = startAdr13 + (c * size);
			if (of.data13[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data13[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data13, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version12) {
			int a = startAdr12 + (c * size);
			if (of.data12[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data12[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data12, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version11) {
			int a = startAdr11 + (c * size);
			if (of.data11[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data11[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data11, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version10) {
			int a = startAdr10 + (c * size);
			if (of.data10[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data10[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data10, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version09) {
			int a = startAdr09 + (c * size);
			if (of.data09[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data09[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data09, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version08) {
			int a = startAdr08 + (c * size);
			if (of.data08[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data08[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data08, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version6) {
			int a = startAdr6 + (c * size);
			if (of.data6[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data6[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data6, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		} else if (of.version5) {
			int a = startAdr5 + (c * size5);
			if (of.data5[a] != 0) {
				for (int i = 0; i < 49; i++) {
					if (len == 0 && of.data5[a + i] == 0) {
						len = i;
					}
				}
				try {
					club = new String(of.data5, a, len, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					club = "<" + String.valueOf(c) + ">";
				}
			} else {
				club = "<" + String.valueOf(c) + ">";
			}
		}
		return club;
	}

	static String getAbv(OptionFile of, int c) {
		String abv = "";
		int a = startAdr + 49 + (c * size);
		abv = new String(of.data, a, 3);
		return abv;
	}

	static void setAbv(OptionFile of, int c, String text) {
		int a = startAdr + 49 + (c * size);
		byte[] tb = new byte[3];
		byte[] sb = text.getBytes();
		System.arraycopy(sb, 0, tb, 0, 3);
		System.arraycopy(tb, 0, of.data, a, 3);
		setNameEdited(of, c);
	}

	static void setName(OptionFile of, int c, String text) {
		int a = 0;
		if (of.newVersion)
			a = startAdr + (c * size);
		else if (of.version13)
			a = startAdr13 + (c * size);
		else if (of.version12)
			a = startAdr12 + (c * size);
		else if (of.version11)
			a = startAdr11 + (c * size);
		else if (of.version10)
			a = startAdr10 + (c * size);
		else if (of.version09)
			a = startAdr09 + (c * size);
		else if (of.version08)
			a = startAdr08 + (c * size);
		else if (of.version6)
			a = startAdr6 + (c * size);
		else if (of.version5)
			a = startAdr5 + (c * size5);
		byte[] tb = new byte[49];
		byte[] sb;
		try {
			sb = text.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			sb = new byte[48];
		}
		if (sb.length <= 48) {
			System.arraycopy(sb, 0, tb, 0, sb.length);
		} else {
			System.arraycopy(sb, 0, tb, 0, 48);
		}
		if (of.newVersion)
			System.arraycopy(tb, 0, of.data, a, 49);
		else if (of.version13)
			System.arraycopy(tb, 0, of.data13, a, 49);
		else if (of.version12)
			System.arraycopy(tb, 0, of.data12, a, 49);
		else if (of.version11)
			System.arraycopy(tb, 0, of.data11, a, 49);
		else if (of.version10)
			System.arraycopy(tb, 0, of.data10, a, 49);
		else if (of.version09)
			System.arraycopy(tb, 0, of.data09, a, 49);
		else if (of.version08)
			System.arraycopy(tb, 0, of.data08, a, 49);
		else if (of.version6)
			System.arraycopy(tb, 0, of.data6, a, 49);
		else if (of.version5)
			System.arraycopy(tb, 0, of.data5, a, 49);
		setNameEdited(of, c);
	}

	static int getStadium(OptionFile of, int c) {
		int a;
		if (of.newVersion) {
			a = startAdr + 81 + (c * size);
			return of.data[a];			
		} else if (of.version13) {
			a = startAdr13 + 81 + (c * size);
			return of.data13[a];
		} else if (of.version12) {
			a = startAdr12 + 81 + (c * size);
			return of.data12[a];
		} else if (of.version11) {
			a = startAdr11 + 81 + (c * size);
			return of.data11[a];
		} else if (of.version10) {
			a = startAdr10 + 81 + (c * size);
			return of.data10[a];
		} else if (of.version09) {
			a = startAdr09 + 81 + (c * size);
			return of.data09[a];
		} else if (of.version08) {
			a = startAdr08 + 81 + (c * size);
			return of.data08[a];
		} else if (of.version6) {
			a = startAdr6 + 81 + (c * size);
			return of.data6[a];
		} else if (of.version5) {
			a = startAdr5 + 81 + (c * size5);
			return of.data5[a];
		} else
			return (Integer) null;
	}

	static void setStadium(OptionFile of, int c, int s) {
		int a = startAdr + 81 + (c * size);
		of.data[a] = of.toByte(s);
		setStadiumEdited(of, c);
	}

	static byte getBack(OptionFile of, int c) {
		int a = startAdr + 70 + (c * size);
		return of.data[a];
	}

	static void setBack(OptionFile of, int c, int b) {
		int a = startAdr + 70 + (c * size);
		of.data[a] = of.toByte(b);
		// int sa = 797507 + 6236 + (t * 140);
		// of.data[sa] = 1;
	}

	static byte[] getRed(OptionFile of, int c) {
		int a = Clubs.startAdr + 72 + (c * Clubs.size);
		byte[] red = new byte[2];
		red[0] = of.data[a];
		red[1] = of.data[a + 4];
		return red;
	}

	static byte[] getGreen(OptionFile of, int c) {
		int a = Clubs.startAdr + 73 + (c * Clubs.size);
		byte[] red = new byte[2];
		red[0] = of.data[a];
		red[1] = of.data[a + 4];
		return red;
	}

	static byte[] getBlue(OptionFile of, int c) {
		int a = Clubs.startAdr + 74 + (c * Clubs.size);
		byte[] red = new byte[2];
		red[0] = of.data[a];
		red[1] = of.data[a + 4];
		return red;
	}

	static Color getColor(OptionFile of, int c, boolean two) {
		int a = startAdr + 72 + (c * size);
		if (two) {
			a = a + 4;
		}
		int red = of.toInt(of.data[a]);
		int green = of.toInt(of.data[a + 1]);
		int blue = of.toInt(of.data[a + 2]);
		return new Color(red, green, blue);
	}

	static void setColor(OptionFile of, int c, boolean two, Color color) {
		int a = startAdr + 72 + (c * size);
		if (two) {
			a = a + 4;
		}
		byte r = (byte) color.getRed();
		byte g = (byte) color.getGreen();
		byte b = (byte) color.getBlue();
		of.data[a] = r;
		of.data[a + 1] = g;
		of.data[a + 2] = b;
	}

	static void importNames(OptionFile of1, OptionFile of2) {
		if (of2.version12) {
			for (int i = 0; i < total12; i++) {
				System.arraycopy(of2.data12, startAdr12 + (i * size), of1.data,
						startAdr + (i * size), 57);
			}
		} else if (of2.version11) {
			for (int i = 0; i < total11; i++) {
				System.arraycopy(of2.data11, startAdr11 + (i * size), of1.data,
						startAdr + (i * size), 57);
			}
		} else if (of2.version10) {
			for (int i = 0; i < total10; i++) {
				System.arraycopy(of2.data10, startAdr10 + (i * size), of1.data,
						startAdr + (i * size), 57);
			}
		} else if (of2.version09) {
			for (int i = 0; i < total09; i++) {
				System.arraycopy(of2.data09, startAdr09 + (i * size), of1.data,
						startAdr + (i * size), 57);
			}
		} else if (of2.version08) {
			for (int i = 0; i < total08; i++) {
				System.arraycopy(of2.data08, startAdr08 + (i * size), of1.data,
						startAdr + (i * size), 57);
			}
		} else if (of2.version6) {
			for (int i = 0; i < total6; i++) {
				System.arraycopy(of2.data6, startAdr6 + (i * size), of1.data,
						startAdr + (i * size), 57);
			}
		} else if (of2.version5) {
			for (int i = 0; i < total5; i++) {
				System.arraycopy(of2.data5, startAdr5 + (i * size5), of1.data,
						startAdr + (i * size), 57);
			}
		} else {
			for (int i = 0; i < total; i++) {
				if (of2.newVersion)
					System.arraycopy(of2.data, startAdr + (i * size), of1.data,
						startAdr + (i * size), 57);
				else if (of2.version13)
					System.arraycopy(of2.data13, startAdr13 + (i * size), of1.data,
							startAdr + (i * size), 57);
			}
		}
	}

	static void importData(OptionFile of1, OptionFile of2) {
		if (of2.version12) {
			for (int i = 0; i < total12; i++) {
				System.arraycopy(of2.data12, startAdr12 + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else if (of2.version11) {
			for (int i = 0; i < total11; i++) {
				System.arraycopy(of2.data11, startAdr11 + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else if (of2.version10) {
			for (int i = 0; i < total10; i++) {
				System.arraycopy(of2.data10, startAdr10 + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else if (of2.version09) {
			for (int i = 0; i < total09; i++) {
				System.arraycopy(of2.data09, startAdr09 + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else if (of2.version08) {
			for (int i = 0; i < total08; i++) {
				System.arraycopy(of2.data08, startAdr08 + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else if (of2.version6) {
			for (int i = 0; i < total6; i++) {
				System.arraycopy(of2.data6, startAdr6 + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else if (of2.version5) {
			for (int i = 0; i < total5; i++) {
				System.arraycopy(of2.data5, startAdr5 + (i * size5) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
			}
		} else {
			for (int i = 0; i < total; i++) {
				if (of2.newVersion)
					System.arraycopy(of2.data, startAdr + (i * size) + 57, of1.data,
						startAdr + (i * size) + 57, 31);
				else if (of2.version13)
					System.arraycopy(of2.data13, startAdr13 + (i * size) + 57, of1.data,
							startAdr + (i * size) + 57, 31);
			}
		}
	}

	static void setNameEdited(OptionFile of, int c) {
		int a = startAdr + (c * size) + 56;
		of.data[a] = 1;
	}

	static void setEmblemEdited(OptionFile of, int c, boolean e) {
		byte sw = 0;
		if (e) {
			sw = 1;
		}
		int sa;
		sa = startAdr + 68 + (size * c);
		of.data[sa] = sw;
		of.data[sa + 1] = sw;
	}

	static void setStadiumEdited(OptionFile of, int c) {
		int a = startAdr + 83 + (c * size);
		of.data[a] = 1;
	}

}
