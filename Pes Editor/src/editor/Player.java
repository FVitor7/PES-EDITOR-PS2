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


import java.io.Serializable;
import java.io.UnsupportedEncodingException;


public class Player implements Serializable, Comparable<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;

	public int index;

	public int adr;

	public byte[] bytes = new byte[124];

	private OptionFile of;

	//static final int startAdr = 34920;
	static final int startAdr = 34672; //offset
	//static final int startAdrE = 12092;
	static final int startAdrE = 11844; //offset
	// static int firstJapan = 4485;
	//static final int firstML = 4603;
	static final int firstML = 4534; //offset
	//static final int firstShop = 4631;
	static final int firstShop = 4562; //offset
	//static final int firstYoung = 4791;
	static final int firstYoung = 4722; //offset
	//static final int firstOld = 4931;
	static final int firstOld = 4862; //offset
	//static final int firstUnused = 4941;
	static final int firstUnused = 4872; //offset
	static final int firstEdit = 32768; //offset
	//static final int total = 4871;
	static final int total = 4872; //offset
	static final int totalEdit = 184; //ok //offset
	static final int firstClassic = 1381; //ok //offset
	static final int firstClub = 1542; //ok //offset
	//static final int firstPESUnited = 4584;
	static final int firstPESUnited = 4449; //offset

	static final int startAdr13 = 34920;
	static final int startAdrE13 = 12092;
	static final int firstML13 = 4603;
	static final int firstShop13 = 4631;
	static final int firstYoung13 = 4791;
	static final int firstOld13 = 4931;
	static final int firstUnused13 = 4941;
	static final int firstEdit13 = 32768;
	static final int total13 = 4872;
	static final int totalEdit13 = 184;
	static final int firstClassic13 = 1381;
	static final int firstClub13 = 1542;
	static final int firstPESUnited13 = 4584;

	static final int startAdr12 = 35108;
	static final int startAdrE12 = 12280;
	static final int firstML12 = 4643;
	static final int firstShop12 = 4671;
	static final int firstYoung12 = 4831;
	static final int firstOld12 = 4971;
	static final int firstUnused12 = 4980;
	static final int firstEdit12 = 32768;
	static final int total12 = 4980;
	static final int totalEdit12 = 184;
	static final int firstClassic12 = 1381;
	static final int firstClub12 = 1542;
	static final int firstPESUnited12 = 4624;

	static final int startAdr11 = 35232;
	static final int startAdrE11 = 12404;
	static final int firstML11 = 4725;
	static final int firstShop11 = 4753;
	static final int firstYoung11 = 4913;
	static final int firstOld11 = 5053;
	static final int firstUnused11 = 5063;
	static final int firstEdit11 = 32768;
	static final int total11 = 5063;
	static final int totalEdit11 = 184;
	static final int firstClassic11 = 1381;
	static final int firstClub11 = 1542;
	static final int firstPESUnited11 = 4624;

	static final int startAdr10 = 35104;
	static final int startAdrE10 = 12276;
	static final int firstML10 = 4683;
	static final int firstShop10 = 4711;
	static final int firstYoung10 = 4871;
	static final int firstOld10 = 5011;
	static final int firstUnused10 = 5021;
	static final int firstEdit10 = 32768;
	static final int total10 = 5021;
	static final int totalEdit10 = 184;
	static final int firstClassic10 = 1381;
	static final int firstClub10 = 1542;
	static final int firstPESUnited10 = 4605;

	static final int startAdr09 = 34732;
	static final int startAdrE09 = 11904;
	static final int firstML09 = 4586;
	static final int firstShop09 = 4614;
	static final int firstYoung09 = 4774;
	static final int firstOld09 = 4914;
	static final int firstUnused09 = 4924;
	static final int firstEdit09 = 32768;
	static final int total09 = 4924;
	static final int totalEdit09 = 184;
	static final int firstClassic09 = 1381;
	static final int firstClub09 = 1542;
	static final int firstPESUnited09 = 4508;

	static final int startAdr08 = 34704;
	static final int startAdrE08 = 11876;
	static final int firstML08 = 4790;
	static final int firstShop08 = 4818;
	static final int firstYoung08 = 4978;
	static final int firstOld08 = 5155;
	static final int firstUnused08 = 5165;
	static final int firstEdit08 = 32768;
	static final int total08 = 5165;
	static final int totalEdit08 = 184;
	static final int firstClassic08 = 1312;
	static final int firstClub08 = 1473;
	static final int firstPESUnited08 = 4330;

	static final int startAdr6 = 37116;
	static final int startAdrE6 = 14288;
	static final int firstML6 = 4414;
	static final int firstShop6 = 4437;
	static final int firstYoung6 = 4597;
	static final int firstOld6 = 4774;
	static final int firstUnused6 = 4784;
	static final int firstEdit6 = 32768;
	static final int total6 = 4784;
	static final int totalEdit6 = 184;
	static final int firstClassic6 = 1312;
	static final int firstClub6 = 1473;
	static final int firstPESUnited6 = 3954;

	static final int startAdr5 = 36872;
	static final int startAdrE5 = 14044;
	static final int firstML5 = 4535;
	static final int firstShop5 = 4558;
	static final int firstYoung5 = 4775;
	static final int firstOld5 = 4886;
	static final int firstUnused5 = 4896;
	static final int firstEdit5 = 32768;
	static final int total5 = 4896;
	static final int totalEdit5 = 184;
	static final int firstClassic5 = 4685;
	static final int firstClub5 = 1473;
	static final int firstPESUnited5 = 4489;

	public Player(OptionFile opf, int i, int sa) {
		of = opf;
		if (of == null)
			throw new NullPointerException();
		boolean end;
		index = i;
		adr = sa;
		if (of.newVersion) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total && i < firstEdit) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				// adr = 31568 + (i * 124);
				int a = startAdr;
				int offSet = i * 124;
				if (i >= firstEdit) {
					// adr = 8744 + (i * 124);
					a = startAdrE;
					offSet = (i - firstEdit) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}
	
				System.arraycopy(of.data, a + offSet, bytes, 0, 124);

				if (name.equals("") && index >= firstEdit) {
					// name = "<???>";
					name = "<Edited " + String.valueOf(index - firstEdit) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version13) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total13 && i < firstEdit13) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr13;
				int offSet = i * 124;
				if (i >= firstEdit13) {
					a = startAdrE13;
					offSet = (i - firstEdit13) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data13, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit13) {
					name = "<Edited " + String.valueOf(index - firstEdit13) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused13) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version12) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total12 && i < firstEdit12) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr12;
				int offSet = i * 124;
				if (i >= firstEdit12) {
					a = startAdrE12;
					offSet = (i - firstEdit12) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data12, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit12) {
					name = "<Edited " + String.valueOf(index - firstEdit12) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused12) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version11) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total11 && i < firstEdit11) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr11;
				int offSet = i * 124;
				if (i >= firstEdit11) {
					a = startAdrE11;
					offSet = (i - firstEdit11) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data11, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit11) {
					name = "<Edited " + String.valueOf(index - firstEdit11) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused11) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version10) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total10 && i < firstEdit10) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr10;
				int offSet = i * 124;
				if (i >= firstEdit10) {
					a = startAdrE10;
					offSet = (i - firstEdit10) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data10, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit10) {
					name = "<Edited " + String.valueOf(index - firstEdit10) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused10) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version09) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total09 && i < firstEdit09) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr09;
				int offSet = i * 124;
				if (i >= firstEdit09) {
					a = startAdrE09;
					offSet = (i - firstEdit09) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data09, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit09) {
					name = "<Edited " + String.valueOf(index - firstEdit09) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused09) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version08) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total08 && i < firstEdit08) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr08;
				int offSet = i * 124;
				if (i >= firstEdit08) {
					a = startAdrE08;
					offSet = (i - firstEdit08) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data08, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit08) {
					name = "<Edited " + String.valueOf(index - firstEdit08) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused08) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version6) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total6 && i < firstEdit6) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr6;
				int offSet = i * 124;
				if (i >= firstEdit6) {
					a = startAdrE6;
					offSet = (i - firstEdit6) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data6, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit6) {
					name = "<Edited " + String.valueOf(index - firstEdit6) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused6) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		} else if (of.version5) {
			if (i == 0) {
				name = "<empty>";
			} else if (i < 0 || (i >= total5 && i < firstEdit5) || i > 32951) { //offset
				name = "<ERROR>";
				index = 0;
			} else {
				int a = startAdr5;
				int offSet = i * 124;
				if (i >= firstEdit5) {
					a = startAdrE5;
					offSet = (i - firstEdit5) * 124;
				}
				byte[] nameBytes = new byte[32];
				System.arraycopy(of.data5, a + offSet, nameBytes, 0, 32);
				end = false;
				int len = 0;
				for (int j = 0; !end && j < nameBytes.length - 1; j = j + 2) {
					if (nameBytes[j] == 0 && nameBytes[j + 1] == 0) {
						end = true;
						len = j;
					}
				}
				try {
					name = new String(nameBytes, 0, len, "UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					name = "<Error " + String.valueOf(index) + ">";
				}

				if (name.equals("") && index >= firstEdit5) {
					name = "<Edited " + String.valueOf(index - firstEdit5) + ">";
				} else if (name.equals("")) {
					if (index >= firstUnused5) {
						name = "<Unused " + String.valueOf(index) + ">";
					} else {
						name = "<L " + String.valueOf(index) + ">";
					}
				}
			}
		}
	}

	public String toString() {
		return name;
	}

	public int compareTo(Object o) {
		Player n = (Player) o;
		int cmp = name.compareTo(n.name);
		if (cmp == 0) {
			cmp = new Integer(Stats.getValue(of, index, Stats.age))
					.compareTo(new Integer(Stats.getValue(of, n.index,
							Stats.age)));
		}
		return cmp;

	}

	public void setName(String newName) {
		int len = newName.length();
		if (index != 0 && len <= 15) {
			byte[] newNameBytes = new byte[32];
			byte[] t;
			try {
				t = newName.getBytes("UTF-16LE");
			} catch (UnsupportedEncodingException e) {
				t = new byte[30];
			}
			if (t.length <= 30) {
				System.arraycopy(t, 0, newNameBytes, 0, t.length);
			} else {
				System.arraycopy(t, 0, newNameBytes, 0, 30);
			}
			int a = startAdr;
			int offSet = index * 124;
			if (index >= firstEdit) {
				// adr = 8744 + (i * 124);
				a = startAdrE;
				offSet = (index - firstEdit) * 124;
			}
			System.arraycopy(newNameBytes, 0, of.data, a + offSet, 32);
			// of.data[a + offSet + 48] = -51;
			// of.data[a + offSet + 49] = -51;
			//Stats.setValue(of, index, Stats.callName, 0xcdcd);

			//Stats.setValue(of, index, Stats.nameEdited, 1);
			//Stats.setValue(of, index, Stats.callEdited, 1);
			// of.data[a + offSet + 50] = 1;
			name = newName;
		}
	}

	public String getShirtName() {
		String sn = "";
		int a = startAdr + 32 + (index * 124);
		if (index >= firstEdit) {
			a = startAdrE + 32 + ((index - firstEdit) * 124);
		}
		if (of.data[a] != 0) {
			byte[] sb = new byte[16];
			System.arraycopy(of.data, a, sb, 0, 16);
			for (int i = 0; i < 16; i++) {
				if (sb[i] == 0) {
					sb[i] = 33;
				}
			}
			sn = new String(sb);
			sn = sn.replaceAll("!", "");
		}
		return sn;
	}

	public void setShirtName(String n) {
		if (n.length() < 16 && index != 0) {
			int a = startAdr + 32 + (index * 124);
			if (index >= firstEdit) {
				a = startAdrE + 32 + ((index - firstEdit) * 124);
			}
			byte[] t = new byte[16];
			n = n.toUpperCase();
			byte[] nb = n.getBytes();
			for (int i = 0; i < nb.length; i++) {
				if ((nb[i] < 65 || nb[i] > 90) && nb[i] != 46 && nb[i] != 32
						&& nb[i] != 95) {
					nb[i] = 32;
				}
			}
			System.arraycopy(nb, 0, t, 0, nb.length);
			System.arraycopy(t, 0, of.data, a, 16);
			Stats.setValue(of, index, Stats.shirtEdited, 1);
		}
	}

	public void makeShirt(String n) {
		// System.out.println(n);
		String result = "";
		String spaces = "";
		int len = n.length();
		if (len < 9 && len > 5) {
			spaces = " ";
		} else if (len < 6 && len > 3) {
			spaces = "  ";
		} else if (len == 3) {
			spaces = "    ";
		} else if (len == 2) {
			spaces = "        ";
		}
		n = n.toUpperCase();
		byte[] nb = n.getBytes();
		for (int i = 0; i < nb.length; i++) {
			if ((nb[i] < 65 || nb[i] > 90) && nb[i] != 46 && nb[i] != 32
					&& nb[i] != 95) {
				nb[i] = 32;
			}
		}
		n = new String(nb);
		// System.out.println(n);
		for (int i = 0; i < n.length() - 1; i++) {
			result = result + n.substring(i, i + 1) + spaces;
		}
		result = result + n.substring(n.length() - 1, n.length());
		setShirtName(result);
	}


	/*
	 * private int getNumAdr(int a) { return 651576 + ((a - 657886) / 2); }
	 */
	

}
