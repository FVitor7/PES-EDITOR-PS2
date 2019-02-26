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

public class Kits {
	static final int totalN = 67; //offset

	//static final int startAdrN = 751254;
	static final int startAdrN = 742324; //offset

	static final int sizeN = 456; //offset

	//static final int startAdrC = 781806;
	static final int startAdrC = 772876; //offset

	static final int sizeC = 648; //offset

	static final int startAdrN13 = 751254;
	static final int startAdrC13 = 781806;

	static final int startAdrN12 = 759142;
	static final int startAdrC12 = 789694;

	static final int startAdrN11 = 770830;
	static final int startAdrC11 = 801382;

	static final int startAdrN10 = 765644;
	static final int sizeN10 = 440;
	static final int startAdrC10 = 795124;
	static final int sizeC10 = 632;
	
	static final int startAdrN09 = 760456;
	static final int sizeN09 = 352;
	static final int startAdrC09 = 784040;
	static final int sizeC09 = 544;

	static final int totalN08 = 64;
	static final int startAdrN08 = 786856;
	static final int sizeN08 = 352;
	static final int startAdrC08 = 809384;
	static final int sizeC08 = 544;

	static final int totalN6 = 64;
	static final int startAdrN6 = 763804;
	static final int sizeN6 = 352;
	static final int startAdrC6 = 786332;
	static final int sizeC6 = 544;

	static final int totalN5 = 64;
	static final int startAdrN5 = 822940;
	static final int sizeN5 = 352;
	static final int totalC5 = 138;
	static final int startAdrC5 = 845468;
	static final int sizeC5 = 544;

	static boolean logoUsed(OptionFile of, int team, int logo) {
		int a = 0;
		if (of.newVersion)
			a = startAdrC + 360 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version13)
			a = startAdrC13 + 358 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version12)
			a = startAdrC12 + 358 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version11)
			a = startAdrC11 + 358 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version10)
			a = startAdrC10 + 344 + (sizeC10 * team) + (logo * 24) + 2;
		else if (of.version09)
			a = startAdrC09 + 256 + (sizeC09 * team) + (logo * 24) + 2;
		else if (of.version08)
			a = startAdrC08 + 352 + (sizeC08 * team) + (logo * 24) + 2;
		else if (of.version6)
			a = startAdrC6 + 256 + (sizeC6 * team) + (logo * 24) + 2;
		else if (of.version5)
			a = startAdrC5 + 256 + (sizeC5 * team) + (logo * 24) + 2;
		if (of.newVersion) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN + 360 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version13) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN13 + 358 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version12) {
			if (team >= Clubs.total12) {
				team = team - Clubs.total12;
				a = startAdrN12 + 358 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version11) {
			if (team >= Clubs.total11) {
				team = team - Clubs.total11;
				a = startAdrN11 + 358 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version10) {
			if (team >= Clubs.total10) {
				team = team - Clubs.total10;
				a = startAdrN10 + 344 + (sizeN10 * team) + (logo * 24) + 2;
			}
		} else if (of.version09) {
			if (team >= Clubs.total09) {
				team = team - Clubs.total09;
				a = startAdrN09 + 256 + (sizeN09 * team) + (logo * 24) + 2;
			}
		} else if (of.version08) {
			if (team >= Clubs.total08) {
				team = team - Clubs.total08;
				a = startAdrN08 + 352 + (sizeN08 * team) + (logo * 24) + 2;
			}
		} else if (of.version6) {
			if (team >= Clubs.total6) {
				team = team - Clubs.total6;
				a = startAdrN6 + 256 + (sizeN6 * team) + (logo * 24) + 2;
			}
		} else if (of.version5) {
			if (team >= Clubs.total5) {
				team = team - Clubs.total5;
				a = startAdrN5 + 256 + (sizeN5 * team) + (logo * 24) + 2;
			}
		}
		if (of.newVersion) {
			if (of.data[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version13) {
			if (of.data13[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version12) {
			if (of.data12[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version11) {
			if (of.data11[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version10) {
			if (of.data10[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version09) {
			if (of.data09[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version08) {
			if (of.data08[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version6) {
			if (of.data6[a] == 1) {
				return true;
			} else {
				return false;
			}
		} else if (of.version5) {
			if (of.data5[a] == 1) {
				return true;
			} else {
				return false;
			}
		}
		return (Boolean) null;
	}

	static byte getLogo(OptionFile of, int team, int logo) {
		int a = 0;
		if (of.newVersion)
			a = startAdrC + 360 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version13)
			a = startAdrC13 + 358 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version12)
			a = startAdrC12 + 358 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version11)
			a = startAdrC11 + 358 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version10)
			a = startAdrC10 + 344 + (sizeC10 * team) + (logo * 24) + 3;
		else if (of.version09)
			a = startAdrC09 + 256 + (sizeC09 * team) + (logo * 24) + 3;
		else if (of.version08)
			a = startAdrC08 + 352 + (sizeC08 * team) + (logo * 24) + 3;
		else if (of.version6)
			a = startAdrC6 + 256 + (sizeC6 * team) + (logo * 24) + 3;
		else if (of.version5)
			a = startAdrC5 + 256 + (sizeC5 * team) + (logo * 24) + 3;
		if (of.newVersion) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN + 360 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version13) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN13 + 358 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version12) {
			if (team >= Clubs.total12) {
				team = team - Clubs.total12;
				a = startAdrN12 + 358 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version11) {
			if (team >= Clubs.total11) {
				team = team - Clubs.total11;
				a = startAdrN11 + 358 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version10) {
			if (team >= Clubs.total10) {
				team = team - Clubs.total10;
				a = startAdrN10 + 344 + (sizeN10 * team) + (logo * 24) + 3;
			}
		} else if (of.version09) {
			if (team >= Clubs.total09) {
				team = team - Clubs.total09;
				a = startAdrN09 + 256 + (sizeN09 * team) + (logo * 24) + 3;
			}
		} else if (of.version08) {
			if (team >= Clubs.total08) {
				team = team - Clubs.total08;
				a = startAdrN08 + 352 + (sizeN08 * team) + (logo * 24) + 3;
			}
		} else if (of.version6) {
			if (team >= Clubs.total6) {
				team = team - Clubs.total6;
				a = startAdrN6 + 256 + (sizeN6 * team) + (logo * 24) + 3;
			}
		} else if (of.version5) {
			if (team >= Clubs.total5) {
				team = team - Clubs.total5;
				a = startAdrN5 + 256 + (sizeN5 * team) + (logo * 24) + 3;
			}
		}
		if (of.newVersion)
			return of.data[a];
		else if (of.version13)
			return of.data13[a];
		else if (of.version12)
			return of.data12[a];
		else if (of.version11)
			return of.data11[a];
		else if (of.version10)
			return of.data10[a];
		else if (of.version09)
			return of.data09[a];
		else if (of.version08)
			return of.data08[a];
		else if (of.version6)
			return of.data6[a];
		else if (of.version5)
			return of.data5[a];
		return (Byte) null;
	}

	static void setLogo(OptionFile of, int team, int logo, byte slot) {
		int a = 0;
		if (of.newVersion)
			a = startAdrC + 360 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version13)
			a = startAdrC13 + 358 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version12)
			a = startAdrC12 + 358 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version11)
			a = startAdrC11 + 358 + (sizeC * team) + (logo * 24) + 3;
		else if (of.version10)
			a = startAdrC10 + 344 + (sizeC10 * team) + (logo * 24) + 3;
		else if (of.version09)
			a = startAdrC09 + 256 + (sizeC09 * team) + (logo * 24) + 3;
		else if (of.version08)
			a = startAdrC08 + 352 + (sizeC08 * team) + (logo * 24) + 3;
		else if (of.version6)
			a = startAdrC6 + 256 + (sizeC6 * team) + (logo * 24) + 3;
		else if (of.version5)
			a = startAdrC5 + 256 + (sizeC5 * team) + (logo * 24) + 3;
		if (of.newVersion) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN + 360 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version13) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN13 + 358 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version12) {
			if (team >= Clubs.total12) {
				team = team - Clubs.total12;
				a = startAdrN12 + 358 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version11) {
			if (team >= Clubs.total11) {
				team = team - Clubs.total11;
				a = startAdrN11 + 358 + (sizeN * team) + (logo * 24) + 3;
			}
		} else if (of.version10) {
			if (team >= Clubs.total10) {
				team = team - Clubs.total10;
				a = startAdrN10 + 344 + (sizeN10 * team) + (logo * 24) + 3;
			}
		} else if (of.version09) {
			if (team >= Clubs.total09) {
				team = team - Clubs.total09;
				a = startAdrN09 + 256 + (sizeN09 * team) + (logo * 24) + 3;
			}
		} else if (of.version08) {
			if (team >= Clubs.total08) {
				team = team - Clubs.total08;
				a = startAdrN08 + 352 + (sizeN08 * team) + (logo * 24) + 3;
			}
		} else if (of.version6) {
			if (team >= Clubs.total6) {
				team = team - Clubs.total6;
				a = startAdrN6 + 256 + (sizeN6 * team) + (logo * 24) + 3;
			}
		} else if (of.version5) {
			if (team >= Clubs.total5) {
				team = team - Clubs.total5;
				a = startAdrN5 + 256 + (sizeN5 * team) + (logo * 24) + 3;
			}
		}
		of.data[a] = slot;
	}

	static void setLogoUnused(OptionFile of, int team, int logo) {
		int a = 0;
		if (of.newVersion)
			a = startAdrC + 360 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version13)
			a = startAdrC13 + 358 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version12)
			a = startAdrC12 + 358 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version11)
			a = startAdrC11 + 358 + (sizeC * team) + (logo * 24) + 2;
		else if (of.version10)
			a = startAdrC10 + 344 + (sizeC10 * team) + (logo * 24) + 2;
		else if (of.version09)
			a = startAdrC09 + 256 + (sizeC09 * team) + (logo * 24) + 2;
		else if (of.version08)
			a = startAdrC08 + 352 + (sizeC08 * team) + (logo * 24) + 2;
		else if (of.version6)
			a = startAdrC6 + 256 + (sizeC6 * team) + (logo * 24) + 2;
		else if (of.version5)
			a = startAdrC5 + 256 + (sizeC5 * team) + (logo * 24) + 2;
		if (of.newVersion) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN + 360 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version13) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN13 + 358 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version12) {
			if (team >= Clubs.total12) {
				team = team - Clubs.total12;
				a = startAdrN12 + 358 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version11) {
			if (team >= Clubs.total11) {
				team = team - Clubs.total11;
				a = startAdrN11 + 358 + (sizeN * team) + (logo * 24) + 2;
			}
		} else if (of.version10) {
			if (team >= Clubs.total10) {
				team = team - Clubs.total10;
				a = startAdrN10 + 344 + (sizeN10 * team) + (logo * 24) + 2;
			}
		} else if (of.version09) {
			if (team >= Clubs.total09) {
				team = team - Clubs.total09;
				a = startAdrN09 + 256 + (sizeN09 * team) + (logo * 24) + 2;
			}
		} else if (of.version08) {
			if (team >= Clubs.total08) {
				team = team - Clubs.total08;
				a = startAdrN08 + 352 + (sizeN08 * team) + (logo * 24) + 2;
			}
		} else if (of.version6) {
			if (team >= Clubs.total6) {
				team = team - Clubs.total6;
				a = startAdrN6 + 256 + (sizeN6 * team) + (logo * 24) + 2;
			}
		} else if (of.version5) {
			if (team >= Clubs.total5) {
				team = team - Clubs.total5;
				a = startAdrN5 + 256 + (sizeN5 * team) + (logo * 24) + 2;
			}
		}
		of.data[a] = 0;
		of.data[a + 1] = 88;
	}

	static void importKit(OptionFile of1, int team1, OptionFile of2, int team2) {
		// int t = team1;
		int a1 = startAdrC + (sizeC * team1);
		int a2 = 0;
		int size = 0;
		if (of2.newVersion) {
			a2 = startAdrC + (sizeC * team2);
			size = sizeC;
		}
		else if (of2.version13) {
			a2 = startAdrC13 + (sizeC * team2);
			size = sizeC;
		}
		else if (of2.version12) {
			a2 = startAdrC12 + (sizeC * team2);
			size = sizeC;
		}
		else if (of2.version11) {
			a2 = startAdrC11 + (sizeC * team2);
			size = sizeC;
		}
		else if (of2.version10) {
			a2 = startAdrC10 + (sizeC10 * team2);
			size = sizeC10;
		}
		else if (of2.version09) {
			a2 = startAdrC09 + (sizeC09 * team2);
			size = sizeC09;
		}
		else if (of2.version08) {
			a2 = startAdrC08 + (sizeC08 * team2);
			size = sizeC08;
		}
		else if (of2.version6) {
			a2 = startAdrC6 + (sizeC6 * team2);
			size = sizeC6;
		}
		else if (of2.version5) {
			a2 = startAdrC5 + (sizeC5 * team2);
			size = sizeC5;
		}
		if (of2.newVersion) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total;
				a2 = startAdrN + (sizeN * team2);
				size = sizeN;
			}
		} else if (of2.version13) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total;
				a2 = startAdrN13 + (sizeN * team2);
				size = sizeN;
			}
		} else if (of2.version12) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total12;
				a2 = startAdrN12 + (sizeN * team2);
				size = sizeN;
			}
		} else if (of2.version11) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total11;
				a2 = startAdrN11 + (sizeN * team2);
				size = sizeN;
			}
		} else if (of2.version10) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total10;
				a2 = startAdrN10 + (sizeN10 * team2);
				size = sizeN;
			}
		} else if (of2.version09) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total09;
				a2 = startAdrN09 + (sizeN09 * team2);
				size = sizeN;
			}
		} else if (of2.version08) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total08;
				a2 = startAdrN08 + (sizeN08 * team2);
				size = sizeN;
			}
		} else if (of2.version6) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total6;
				a2 = startAdrN6 + (sizeN6 * team2);
				size = sizeN;
			}
		} else if (of2.version5) {
			if (team1 >= Clubs.total) {
				team1 = team1 - Clubs.total;
				a1 = startAdrN + (sizeN * team1);
				team2 = team2 - Clubs.total5;
				a2 = startAdrN5 + (sizeN5 * team2);
				size = sizeN;
			}
		}
		if (of2.newVersion)
			System.arraycopy(of2.data, a2, of1.data, a1, size);
		else if (of2.version13)
			System.arraycopy(of2.data13, a2, of1.data, a1, size);
		else if (of2.version12)
			System.arraycopy(of2.data12, a2, of1.data, a1, size);
		else if (of2.version11)
			System.arraycopy(of2.data11, a2, of1.data, a1, size);
		/*else if (of2.version10)
			System.arraycopy(of2.data10, a2, of1.data, a1, size);*/
		/*else if (of2.version09)
			System.arraycopy(of2.data09, a2, of1.data, a1, size);*/
		/*else if (of2.version08)
			System.arraycopy(of2.data08, a2, of1.data, a1, size);*/
		/*else if (of2.version6)
		System.arraycopy(of2.data6, a2, of1.data, a1, size);*/
		/*else if (of2.version5)
		System.arraycopy(of2.data5, a2, of1.data, a1, size);*/

		/*
		 * if (!of1.isWE() && of2.isWE()) { Convert.kitModel(of1, t); }
		 */
	}

	static boolean isLic(OptionFile of,int team){
		int a = 0;
		int b = 0;
		if (of.newVersion) {
			a = startAdrC + 80 + (sizeC * team);
			b = startAdrC + 81 + (sizeC * team);
		} else if (of.version13) {
			a = startAdrC13 + 78 + (sizeC * team);
			b = startAdrC13 + 79 + (sizeC * team);
		} else if (of.version12) {
			a = startAdrC12 + 78 + (sizeC * team);
			b = startAdrC12 + 79 + (sizeC * team);
		} else if (of.version11) {
			a = startAdrC11 + 78 + (sizeC * team);
			b = startAdrC11 + 79 + (sizeC * team);
		} else if (of.version10) {
			a = startAdrC10 + 78 + (sizeC10 * team);
			b = startAdrC10 + 79 + (sizeC10 * team);
		} else if (of.version09) {
			a = startAdrC09 + 58 + (sizeC09 * team);
		} else if (of.version08) {
			a = startAdrC08 + 58 + (sizeC08 * team);
		} else if (of.version6) {
			a = startAdrC6 + 58 + (sizeC6 * team);
		} else if (of.version5) {
			a = startAdrC5 + 58 + (sizeC5 * team);
		}
		//System.out.println(Clubs.getName(of, team) + " : " +of.data[a] +" " +of.data[b]);
		if (of.newVersion) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN + 80 + (sizeN * team);
				b = startAdrN + 81 + (sizeN * team);
			//	System.out.println(Stats.nation[team] + " : " +of.data[a] +" " +of.data[b]);
			}
		} else if (of.version13) {
			if (team >= Clubs.total) {
				team = team - Clubs.total;
				a = startAdrN13 + 78 + (sizeN * team);
				b = startAdrN13 + 79 + (sizeN * team);
			}
		} else if (of.version12) {
			if (team >= Clubs.total12) {
				team = team - Clubs.total12;
				a = startAdrN12 + 78 + (sizeN * team);
				b = startAdrN12 + 79 + (sizeN * team);
			}
		} else if (of.version11) {
			if (team >= Clubs.total11) {
				team = team - Clubs.total11;
				a = startAdrN11 + 78 + (sizeN * team);
				b = startAdrN11 + 79 + (sizeN * team);
			}
		} else if (of.version10) {
			if (team >= Clubs.total10) {
				team = team - Clubs.total10;
				a = startAdrN10 + 78 + (sizeN10 * team);
				b = startAdrN10 + 79 + (sizeN10 * team);
			}
		} else if (of.version09) {
			if (team >= Clubs.total09) {
				team = team - Clubs.total09;
				a = startAdrN09 + 58 + (sizeN09 * team);
			}
		} else if (of.version08) {
			if (team >= Clubs.total08) {
				team = team - Clubs.total08;
				a = startAdrN08 + 58 + (sizeN08 * team);
			}
		} else if (of.version6) {
			if (team >= Clubs.total6) {
				team = team - Clubs.total6;
				a = startAdrN6 + 58 + (sizeN6 * team);
			}
		} else if (of.version5) {
			if (team >= Clubs.total5) {
				team = team - Clubs.total5;
				a = startAdrN5 + 58 + (sizeN5 * team);
			}
		}
		if (of.newVersion) {
			if (of.data[a] != -1 && of.data[b]!= -1) {
				return true;
			}
		} else if (of.version13) {
			if (of.data13[a] != -1 && of.data13[b]!= -1) {
				return true;
			}
		} else if (of.version12) {
			if (of.data12[a] != -1 && of.data12[b]!= -1) {
				return true;
			}
		} else if (of.version11) {
			if (of.data11[a] != -1 && of.data11[b]!= -1) {
				return true;
			}
		} else if (of.version10) {
			if (of.data10[a] != -1 && of.data10[b]!= -1) {
				return true;
			}
		} else if (of.version09) {
			if (of.data09[a] == 1) {
				return true;
			}
		} else if (of.version08) {
			if (of.data08[a] == 1) {
				return true;
			}
		} else if (of.version6) {
			if (of.data6[a] == 1) {
				return true;
			}
		} else if (of.version5) {
			if (of.data5[a] == 1) {
				return true;
			}
		}
		return false;
	}
}
