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

public class Squads {
	//static final int num23 = 649560;
	static final int num23 = 640632; //offset
	//static final int num32 = 651285;
	static final int num32 = 642357; //offset
	//static final int slot23 = 655734;
	static final int slot23 = 646806; //offset
	//static final int slot32 = 659184;
	static final int slot32 = 650256; //offset
	static final int newSquadNumber = 60 + PESUtils.extraSquad.length + Clubs.total; //60 + 22 + 130 = 212

	static final int num2313 = 649560;
	static final int num3213 = 651285;
	static final int slot2313 = 655734;
	static final int slot3213 = 659184;
	static final int squadNumber13 = 60 + PESUtils.extraSquad.length + Clubs.total; //60 + 22 + 130 = 212

	static final int num2312 = 654708;
	static final int num3212 = 656433;
	static final int slot2312 = 661042;
	static final int slot3212 = 664492;
	static final int squadNumber12 = 60 + PESUtils.extraSquad.length + Clubs.total12; //60 + 22 + 135 = 217

	static final int num2311 = 664752;
	static final int num3211 = 666477;
	static final int slot2311 = 671182;
	static final int slot3211 = 674632;
	static final int squadNumber11 = 60 + PESUtils.extraSquad.length + Clubs.total11; //60 + 22 + 138 = 220

	static final int num2310 = 659664;
	static final int num3210 = 661389;
	static final int slot2310 = 666062;
	static final int slot3210 = 669512;
	static final int squadNumber10 = 60 + PESUtils.extraSquad10.length + Clubs.total10; //60 + 21 + 138 = 219

	static final int num2309 = 655572;
	static final int num3209 = 657297;
	static final int slot2309 = 661906;
	static final int slot3209 = 665356;
	static final int squadNumber09 = 60 + PESUtils.extraSquad09.length + Clubs.total09; //60 + 21 + 136 = 217

	static final int num2308 = 676624;
	static final int num3208 = 678303;
	static final int slot2308 = 683296;
	static final int slot3208 = 686654;
	static final int squadNumber08 = 57 + PESUtils.extraSquad08.length + Clubs.total08; //57 + 22 + 148 = 227

	static final int num236 = 657956;
	static final int num326 = 659635;
	static final int slot236 = 664372;
	static final int slot326 = 667730;
	static final int squadNumber6 = 57 + PESUtils.extraSquad6.length + Clubs.total6; //57 + 22 + 140 = 219

	static final int num235 = 657712;
	static final int num325 = 659414;
	static final int slot235 = 664054;
	static final int slot325 = 667458;
	static final int squadNumber5 = 57 + PESUtils.extraSquad5.length + Clubs.total5; //57 + 24 + 138 = 219

	public static void fixForm(OptionFile of, int s, boolean fixJobs) {
		//System.out.println(s);
		byte[] temp = new byte[64];
		byte[] tempNum = new byte[32];
		int t;
		int size;
		int firstAdr;
		int firstAdrNum;

		if (of.newVersion) {
			// for (int t = 0; t < 202; t++) {
			if ((s >= 0 && s < 67) || (s >= 75 && s < Squads.newSquadNumber - 7 )) { //squadnumber
				t = s;
				if (s > 74) { //squadnumber
					t = t - 8;
				}
				// System.out.println(t);
				if (s < 67) { //squadnumber
					size = 23;
					firstAdr = slot23 + (s * size * 2);
					firstAdrNum = num23 + (s * size);
				} else {
					size = 32;
					firstAdr = slot32 + ((s - 75) * size * 2); //squadnumber
					firstAdrNum = num32 + ((s - 75) * size); //squadnumber
				}
				//System.out.println(firstAdr);
				System.arraycopy(of.data, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version13) {
			if ((s >= 0 && s < 67) || (s >= 75 && s < Squads.squadNumber13 - 7 )) { //squadnumber
				t = s;
				if (s > 74) { //squadnumber
					t = t - 8;
				}
				if (s < 67) { //squadnumber
					size = 23;
					firstAdr = slot2313 + (s * size * 2);
					firstAdrNum = num2313 + (s * size);
				} else {
					size = 32;
					firstAdr = slot3213 + ((s - 75) * size * 2); //squadnumber
					firstAdrNum = num3213 + ((s - 75) * size); //squadnumber
				}
				System.arraycopy(of.data13, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data13, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data13, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data13, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version12) {
			if ((s >= 0 && s < 67) || (s >= 75 && s < Squads.squadNumber12 - 7 )) { //squadnumber
				t = s;
				if (s > 74) { //squadnumber
					t = t - 8;
				}
				if (s < 67) { //squadnumber
					size = 23;
					firstAdr = slot2312 + (s * size * 2);
					firstAdrNum = num2312 + (s * size);
				} else {
					size = 32;
					firstAdr = slot3212 + ((s - 75) * size * 2); //squadnumber
					firstAdrNum = num3212 + ((s - 75) * size); //squadnumber
				}
				System.arraycopy(of.data12, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data12, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data12, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data12, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version11) {
			if ((s >= 0 && s < 67) || (s >= 75 && s < Squads.squadNumber11 - 7 )) { //squadnumber
				t = s;
				if (s > 74) { //squadnumber
					t = t - 8;
				}
				if (s < 67) { //squadnumber
					size = 23;
					firstAdr = slot2311 + (s * size * 2);
					firstAdrNum = num2311 + (s * size);
				} else {
					size = 32;
					firstAdr = slot3211 + ((s - 75) * size * 2); //squadnumber
					firstAdrNum = num3211 + ((s - 75) * size); //squadnumber
				}
				System.arraycopy(of.data11, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data11, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data11, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data11, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version10) {
			if ((s >= 0 && s < 67) || (s >= 75 && s < Squads.squadNumber10 - 7 )) { //squadnumber
				t = s;
				if (s > 74) { //squadnumber
					t = t - 8;
				}
				if (s < 67) { //squadnumber
					size = 23;
					firstAdr = slot2310 + (s * size * 2);
					firstAdrNum = num2310 + (s * size);
				} else {
					size = 32;
					firstAdr = slot3210 + ((s - 75) * size * 2); //squadnumber
					firstAdrNum = num3210 + ((s - 75) * size); //squadnumber
				}
				System.arraycopy(of.data10, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data10, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data10, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data10, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version09) {
			if ((s >= 0 && s < 67) || (s >= 75 && s < Squads.squadNumber09 - 7 )) { //squadnumber
				t = s;
				if (s > 74) { //squadnumber
					t = t - 8;
				}
				if (s < 67) { //squadnumber
					size = 23;
					firstAdr = slot2309 + (s * size * 2);
					firstAdrNum = num2309 + (s * size);
				} else {
					size = 32;
					firstAdr = slot3209 + ((s - 75) * size * 2); //squadnumber
					firstAdrNum = num3209 + ((s - 75) * size); //squadnumber
				}
				System.arraycopy(of.data09, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data09, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data09, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data09, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version08) {
			if ((s >= 0 && s < 64) || (s >= 73 && s < Squads.squadNumber08 - 7 )) { //squadnumber
				t = s;
				if (s > 72) { //squadnumber
					t = t - 9;
				}
				if (s < 64) { //squadnumber
					size = 23;
					firstAdr = slot2308 + (s * size * 2);
					firstAdrNum = num2308 + (s * size);
				} else {
					size = 32;
					firstAdr = slot3208 + ((s - 73) * size * 2); //squadnumber
					firstAdrNum = num3208 + ((s - 73) * size); //squadnumber
				}
				System.arraycopy(of.data08, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data08, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data08, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data08, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version6) {
			if ((s >= 0 && s < 64) || (s >= 73 && s < Squads.squadNumber6 - 7 )) { //squadnumber
				t = s;
				if (s > 72) { //squadnumber
					t = t - 9;
				}
				if (s < 64) { //squadnumber
					size = 23;
					firstAdr = slot236 + (s * size * 2);
					firstAdrNum = num236 + (s * size);
				} else {
					size = 32;
					firstAdr = slot326 + ((s - 73) * size * 2); //squadnumber
					firstAdrNum = num326 + ((s - 73) * size); //squadnumber
				}
				System.arraycopy(of.data6, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data6, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data6, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data6, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		} else if (of.version5) {
			if ((s >= 0 && s < 64) || (s >= 74 && s < Squads.squadNumber5 - 7 )) { //squadnumber
				t = s;
				if (s > 73) { //squadnumber
					t = t - 10;
				}
				if (s < 74) { //squadnumber
					size = 23;
					firstAdr = slot235 + (s * size * 2);
					firstAdrNum = num235 + (s * size);
				} else {
					size = 32;
					firstAdr = slot325 + ((s - 74) * size * 2); //squadnumber
					firstAdrNum = num325 + ((s - 74) * size); //squadnumber
				}
				System.arraycopy(of.data5, firstAdr, temp, 0, size * 2);
				System.arraycopy(of.data5, firstAdrNum, tempNum, 0, size);
				for (int p = 0; p < size; p++) {
					System.arraycopy(temp, Formations.getSlot(of, t, p) * 2,
							of.data5, firstAdr + (p * 2), 2);
					System.arraycopy(tempNum, Formations.getSlot(of, t, p),
							of.data5, firstAdrNum + p, 1);
				}
	
				if (fixJobs) {
					boolean fixed;
					for (int j = 0; j < 6; j++) {
						fixed = false;
						for (byte i = 0; !fixed && i < 32; i++) {
							if (Formations.getSlot(of, t, i) == Formations.getJob(
									of, t, j)) {
								Formations.setJob(of, t, j, i);
	
								fixed = true;
							}
						}
					}
				}
	
				for (byte i = 0; i < 32; i++) {
					Formations.setSlot(of, t, i, i);
				}
			}
		}
	}

	public static void fixAll(OptionFile of) {
		if (of.newVersion) {
			for (int i = 0; i < Squads.newSquadNumber - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version13) {
			for (int i = 0; i < Squads.squadNumber13 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version12) {
			for (int i = 0; i < Squads.squadNumber12 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version11) {
			for (int i = 0; i < Squads.squadNumber11 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version10) {
			for (int i = 0; i < Squads.squadNumber10 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version09) {
			for (int i = 0; i < Squads.squadNumber09 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version08) {
			for (int i = 0; i < Squads.squadNumber08 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version6) {
			for (int i = 0; i < Squads.squadNumber6 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		} else if (of.version5) {
			for (int i = 0; i < Squads.squadNumber5 - 1; i++) { //squadnumber
				fixForm(of, i, true);
			}
		}
	}

	public static void tidy(OptionFile of, int team) {
		if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.newSquadNumber - 7 )) { //squadnumber
			// FormFixer.fixForm(of, team);
			// System.out.println(team);
			int size;
			int firstAdr;
			int firstAdrNum;
			if (team < 67) { //squadnumber
				size = 23;
				firstAdr = slot23 + (team * size * 2);
				firstAdrNum = num23 + (team * size);
			} else {
				size = 32;
				firstAdr = slot32 + ((team - 75) * size * 2); //squadnumber
				firstAdrNum = num32 + ((team - 75) * size); //squadnumber
			}
			byte[] tempSlot = new byte[(size - 11) * 2];
			byte[] tempNum = new byte[size - 11];
			int numAdr;
			int slotAdr;
			int tempPos = 0;
			for (int i = 11; i < size; i++) {
				slotAdr = firstAdr + (i * 2);
				numAdr = firstAdrNum + i;
				if (!(of.data[slotAdr] == 0 && of.data[slotAdr + 1] == 0)) {
					tempSlot[tempPos * 2] = of.data[slotAdr];
					tempSlot[(tempPos * 2) + 1] = of.data[slotAdr + 1];
					tempNum[tempPos] = of.data[numAdr];
					tempPos++;
				}
			}
			for (int j = tempPos; j < size - 11; j++) {
				tempNum[j] = -1;
			}
			System.arraycopy(tempSlot, 0, of.data, firstAdr + 22,
					tempSlot.length);
			System.arraycopy(tempNum, 0, of.data, firstAdrNum + 11,
					tempNum.length);
		}
	}

	public static void tidy11(OptionFile of, int team, int freePos, int selPos) {
		if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.newSquadNumber - 7 )) { //squadnumber
		//	System.out.println(team);
			Stat stat = Stats.gk;
			int[] score = new int[21];
			int pos = 0;
			if ((selPos > 0 && selPos < 4) || (selPos > 5 && selPos < 8)) {
				stat = Stats.cbt;
				pos = 1;
			}
			if (selPos == 4 || selPos == 5) {
				stat = Stats.cwp;
				pos = 1;
			}
			if (selPos == 8) {
				stat = Stats.sb;
				pos = 2;
			}
			if (selPos == 9) {
				stat = Stats.sb;
				pos = 2;
			}
			if (selPos > 9 && selPos < 15) {
				stat = Stats.dm;
				pos = 3;
			}
			if (selPos == 15) {
				stat = Stats.wb;
				pos = 2;
			}
			if (selPos == 16) {
				stat = Stats.wb;
				pos = 2;
			}
			if (selPos > 16 && selPos < 22) {
				stat = Stats.cm;
				pos = 4;
			}
			if (selPos == 22) {
				stat = Stats.sm;
				pos = 5;
			}
			if (selPos == 23) {
				stat = Stats.sm;
				pos = 5;
			}
			if (selPos > 23 && selPos < 29) {
				stat = Stats.am;
				pos = 6;
			}
			if (selPos > 35 && selPos < 41) {
				stat = Stats.cf;
				pos = 7;
			}
			if (selPos > 30 && selPos < 36) {
				stat = Stats.ss;
				pos = 6;
			}
			if (selPos == 29) {
				stat = Stats.wg;
				pos = 8;
			}
			if (selPos == 30) {
				stat = Stats.wg;
				pos = 8;
			}

			int size;
			int firstAdr;
			int firstAdrNum;
			if (team < 67) { //squadnumber
				size = 23;
				firstAdr = slot23 + (team * size * 2);
				firstAdrNum = num23 + (team * size);
			} else {
				size = 32;
				firstAdr = slot32 + ((team - 75) * size * 2); //squadnumber
				firstAdrNum = num32 + ((team - 75) * size); //squadnumber
			}

			int a;
			int c = 0;
			int pi = -1;
			int[] playerIndex = new int[21];
			for (int i = 11; pi != 0 && i < size; i++) {
				c = i - 11;
				a = firstAdr + (i * 2);
				pi = of.toInt(of.data[a + 1]) << 8 | of.toInt(of.data[a]);
				if (pi != 0) {
					playerIndex[c] = pi;
					switch (pos) {
					case 0:
						score[c] = Stats.getValue(of, pi, Stats.defence)
								+ Stats.getValue(of, pi, Stats.balance)
								+ Stats.getValue(of, pi, Stats.response)
								+ Stats.getValue(of, pi, Stats.gkAbil)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 1:
						score[c] = Stats.getValue(of, pi, Stats.defence)
								+ Stats.getValue(of, pi, Stats.balance)
								+ Stats.getValue(of, pi, Stats.response)
								+ Stats.getValue(of, pi, Stats.speed)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 2:
						score[c] = Stats.getValue(of, pi, Stats.defence)
								+ Stats.getValue(of, pi, Stats.balance)
								+ Stats.getValue(of, pi, Stats.response)
								+ Stats.getValue(of, pi, Stats.stamina)
								+ Stats.getValue(of, pi, Stats.speed)
								+ Stats.getValue(of, pi, Stats.lPassAcc)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 3:
						score[c] = Stats.getValue(of, pi, Stats.defence)
								+ Stats.getValue(of, pi, Stats.balance)
								+ Stats.getValue(of, pi, Stats.response)
								+ Stats.getValue(of, pi, Stats.sPassAcc)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 4:
						score[c] = Stats.getValue(of, pi, Stats.defence)
								+ Stats.getValue(of, pi, Stats.attack)
								+ Stats.getValue(of, pi, Stats.dribAcc)
								+ Stats.getValue(of, pi, Stats.sPassAcc)
								+ Stats.getValue(of, pi, Stats.tech)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 5:
						score[c] = Stats.getValue(of, pi, Stats.attack)
								+ Stats.getValue(of, pi, Stats.speed)
								+ Stats.getValue(of, pi, Stats.stamina)
								+ Stats.getValue(of, pi, Stats.dribAcc)
								+ Stats.getValue(of, pi, Stats.lPassAcc)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 6:
						score[c] = Stats.getValue(of, pi, Stats.attack)
								+ Stats.getValue(of, pi, Stats.dribAcc)
								+ Stats.getValue(of, pi, Stats.sPassAcc)
								+ Stats.getValue(of, pi, Stats.tech)
								+ Stats.getValue(of, pi, Stats.agility)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 7:
						score[c] = Stats.getValue(of, pi, Stats.attack)
								+ Stats.getValue(of, pi, Stats.response)
								+ Stats.getValue(of, pi, Stats.shotAcc)
								+ Stats.getValue(of, pi, Stats.shotTec)
								+ Stats.getValue(of, pi, Stats.tech)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					case 8:
						score[c] = Stats.getValue(of, pi, Stats.attack)
								+ Stats.getValue(of, pi, Stats.speed)
								+ Stats.getValue(of, pi, Stats.dribAcc)
								+ Stats.getValue(of, pi, Stats.dribSpe)
								+ Stats.getValue(of, pi, Stats.sPassAcc)
								+ Stats.getValue(of, pi, Stats.lPassAcc)
								+ Stats.getValue(of, pi, Stats.agility)
								+ Stats.getValue(of, pi, Stats.tech)
								+ Stats.getValue(of, pi, Stats.team);
						break;
					}
				}
			}

			int bestPosPlayer = 0;
			int bestPosScore = 0;
			int bestPlayer = 0;
			int bestScore = 0;
			int isPos = 0;
			for (int i = 0; i < 21; i++) {
				if (playerIndex[i] != 0) {
					isPos = Stats.getValue(of, playerIndex[i], stat);
					if (isPos == 1 && score[i] > bestPosScore) {
						bestPosScore = score[i];
						bestPosPlayer = i;
					}
					if (isPos == 0 && score[i] > bestScore) {
						bestScore = score[i];
						bestPlayer = i;
					}
				}
			}
			// System.out.println(pos);
			// System.out.println(bestPlayer);
			// System.out.println(bestPosPlayer);
			if (bestPosScore != 0) {
				bestPlayer = bestPosPlayer;
			}
			bestPlayer = bestPlayer + 11;
			//System.out.println(bestPlayer);
			of.data[firstAdr + (2 * freePos)] = of
					.toByte(playerIndex[bestPlayer - 11] & 0x000000FF);
			of.data[firstAdr + (2 * freePos) + 1] = of
					.toByte((playerIndex[bestPlayer - 11] & 0x0000FF00) >>> 8);
			of.data[firstAdr + (2 * bestPlayer)] = 0;
			of.data[firstAdr + (2 * bestPlayer) + 1] = 0;
			of.data[firstAdrNum + freePos] = of.data[firstAdrNum + bestPlayer];
			of.data[firstAdrNum + bestPlayer] = -1;
			tidy(of, team);
		}
	}

}
