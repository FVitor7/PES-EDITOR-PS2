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

public class Formations {
	//static final int startAdr = 668080;
	static final int startAdr = 659152; //offset

	static final int size = 364; //offset

	static final int abcSize = 82; //offset

	static final int configPlayersTeamAdr = 111;
	static final int configPlayersTeamSize = 6;

	static final int startAdr13 = 668080;

	static final int startAdr12 = 673708;

	static final int startAdr11 = 684040;

	static final int startAdr10 = 678856;

	static final int startAdr09 = 674572;

	static final int startAdr08 = 696638;

	static final int startAdr6 = 677202;

	static final int startAdr5 = 676738;
	static final int size5 = 628;

	static byte getPos(OptionFile of, int squad, int abc, int i) {
		if (of.newVersion)
			return of.data[startAdr + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version13)
			return of.data13[startAdr13 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version12)
			return of.data12[startAdr12 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version11)
			return of.data11[startAdr11 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version10)
			return of.data10[startAdr10 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version09)
			return of.data09[startAdr09 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version08)
			return of.data08[startAdr08 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version6)
			return of.data6[startAdr6 + 138 + (size * squad) + (abc * abcSize) + i];
		else if (of.version5)
			return of.data5[startAdr5 + 138 + (size5 * squad) + (abc * abcSize) + i];
		return (Byte) null;
	}

	static void setPos(OptionFile of, int squad, int abc, int i, int p) {
		if (of.newVersion)
			of.data[startAdr + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version13)
			of.data13[startAdr13 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version12)
			of.data12[startAdr12 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version11)
			of.data11[startAdr11 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version10)
			of.data10[startAdr10 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version09)
			of.data09[startAdr09 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version08)
			of.data08[startAdr08 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version6)
			of.data6[startAdr6 + 138 + (size * squad) + (abc * abcSize) + i] = (byte) p;
		else if (of.version5)
			of.data5[startAdr5 + 138 + (size5 * squad) + (abc * abcSize) + i] = (byte) p;
	}

	static byte getSlot(OptionFile of, int squad, int i) {
		if (of.newVersion)
			return of.data[startAdr + 6 + (size * squad) + i];
		else if (of.version13)
			return of.data13[startAdr13 + 6 + (size * squad) + i];
		else if (of.version12)
			return of.data12[startAdr12 + 6 + (size * squad) + i];
		else if (of.version11)
			return of.data11[startAdr11 + 6 + (size * squad) + i];
		else if (of.version10)
			return of.data10[startAdr10 + 6 + (size * squad) + i];
		else if (of.version09)
			return of.data09[startAdr09 + 6 + (size * squad) + i];
		else if (of.version08)
			return of.data08[startAdr08 + 6 + (size * squad) + i];
		else if (of.version6)
			return of.data6[startAdr6 + 6 + (size * squad) + i];
		else if (of.version5)
			return of.data5[startAdr5 + 6 + (size5 * squad) + i];
		return (Byte) null;
	}

	static void setSlot(OptionFile of, int squad, int i, byte p) {
		if (of.newVersion)
			of.data[startAdr + 6 + (size * squad) + i] = p;
		else if (of.version13)
			of.data13[startAdr13 + 6 + (size * squad) + i] = p;
		else if (of.version12)
			of.data12[startAdr12 + 6 + (size * squad) + i] = p;
		else if (of.version11)
			of.data11[startAdr11 + 6 + (size * squad) + i] = p;
		else if (of.version10)
			of.data10[startAdr10 + 6 + (size * squad) + i] = p;
		else if (of.version09)
			of.data09[startAdr09 + 6 + (size * squad) + i] = p;
		else if (of.version08)
			of.data08[startAdr08 + 6 + (size * squad) + i] = p;
		else if (of.version6)
			of.data6[startAdr6 + 6 + (size * squad) + i] = p;
		else if (of.version5)
			of.data5[startAdr5 + 6 + (size5 * squad) + i] = p;
	}

	static byte getJob(OptionFile of, int squad, int j) {
		if (of.newVersion)
			return of.data[startAdr + 111 + (size * squad) + j];
		else if (of.version13)
			return of.data13[startAdr13 + 111 + (size * squad) + j];
		else if (of.version12)
			return of.data12[startAdr12 + 111 + (size * squad) + j];
		else if (of.version11)
			return of.data11[startAdr11 + 111 + (size * squad) + j];
		else if (of.version10)
			return of.data10[startAdr10 + 111 + (size * squad) + j];
		else if (of.version09)
			return of.data09[startAdr09 + 111 + (size * squad) + j];
		else if (of.version08)
			return of.data08[startAdr08 + 111 + (size * squad) + j];
		else if (of.version6)
			return of.data6[startAdr6 + 111 + (size * squad) + j];
		else if (of.version5)
			return of.data5[startAdr5 + 108 + (size5 * squad) + j];
		return (Byte) null;
	}

	static void setJob(OptionFile of, int squad, int j, byte i) {
		if (of.newVersion)
			of.data[startAdr + 111 + (size * squad) + j] = i;
		else if (of.version13)
			of.data13[startAdr13 + 111 + (size * squad) + j] = i;
		else if (of.version12)
			of.data12[startAdr12 + 111 + (size * squad) + j] = i;
		else if (of.version11)
			of.data11[startAdr11 + 111 + (size * squad) + j] = i;
		else if (of.version10)
			of.data10[startAdr10 + 111 + (size * squad) + j] = i;
		else if (of.version09)
			of.data09[startAdr09 + 111 + (size * squad) + j] = i;
		else if (of.version08)
			of.data08[startAdr08 + 111 + (size * squad) + j] = i;
		else if (of.version6)
			of.data6[startAdr6 + 111 + (size * squad) + j] = i;
		else if (of.version5)
			of.data5[startAdr5 + 108 + (size5 * squad) + j] = i;
	}

	static byte getX(OptionFile of, int squad, int abc, int i) {
		if (of.newVersion)
			return of.data[startAdr + 118 + (size * squad) + (abc * abcSize)
				+ (2 * (i - 1))];
		else if (of.version13)
			return of.data13[startAdr13 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version12)
			return of.data12[startAdr12 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version11)
			return of.data11[startAdr11 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version10)
			return of.data10[startAdr10 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version09)
			return of.data09[startAdr09 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version08)
			return of.data08[startAdr08 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version6)
			return of.data6[startAdr6 + 118 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version5)
			return of.data5[startAdr5 + 118 + (size5 * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		return (Byte) null;
	}

	static byte getY(OptionFile of, int squad, int abc, int i) {
		if (of.newVersion)
			return of.data[startAdr + 119 + (size * squad) + (abc * abcSize)
				+ (2 * (i - 1))];
		else if (of.version13)
			return of.data13[startAdr13 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version12)
			return of.data12[startAdr12 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version11)
			return of.data11[startAdr11 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version10)
			return of.data10[startAdr10 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version09)
			return of.data09[startAdr09 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version08)
			return of.data08[startAdr08 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version6)
			return of.data6[startAdr6 + 119 + (size * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		else if (of.version5)
			return of.data5[startAdr5 + 119 + (size5 * squad) + (abc * abcSize)
							+ (2 * (i - 1))];
		return (Byte) null;
	}

	static void setX(OptionFile of, int squad, int abc, int i, int x) {
		if (of.newVersion)
			of.data[startAdr + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version13)
			of.data13[startAdr13 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version12)
			of.data12[startAdr12 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version11)
			of.data11[startAdr11 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version10)
			of.data10[startAdr10 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version09)
			of.data09[startAdr09 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version08)
			of.data08[startAdr08 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version6)
			of.data6[startAdr6 + 118 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
		else if (of.version5)
			of.data5[startAdr5 + 118 + (size5 * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) x;
	}

	static void setY(OptionFile of, int squad, int abc, int i, int y) {
		if (of.newVersion)
			of.data[startAdr + 119 + (size * squad) + (abc * abcSize)
				+ (2 * (i - 1))] = (byte) y;
		else if (of.version13)
			of.data13[startAdr13 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version12)
			of.data12[startAdr12 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version11)
			of.data11[startAdr11 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version10)
			of.data10[startAdr10 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version09)
			of.data09[startAdr09 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version08)
			of.data08[startAdr08 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version6)
			of.data6[startAdr6 + 119 + (size * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
		else if (of.version5)
			of.data5[startAdr5 + 119 + (size5 * squad) + (abc * abcSize)
					+ (2 * (i - 1))] = (byte) y;
	}

	static boolean getAtk(OptionFile of, int squad, int abc, int i,
			int direction) {
		boolean result = false;
		if (of.newVersion) {
			byte t = of.data[startAdr + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version13) {
			byte t = of.data13[startAdr13 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version12) {
			byte t = of.data12[startAdr12 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version11) {
			byte t = of.data11[startAdr11 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version10) {
			byte t = of.data10[startAdr10 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version09) {
			byte t = of.data09[startAdr09 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version08) {
			byte t = of.data08[startAdr08 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version6) {
			byte t = of.data6[startAdr6 + 149 + (size * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		} else if (of.version5) {
			byte t = of.data5[startAdr5 + 149 + (size5 * squad) + (abc * abcSize) + i];
			if (((t >>> direction) & 1) == 1) {
				result = true;
			}
		}
		return result;
	}

	static void setAtk(OptionFile of, int squad, int abc, int i, int direction) {
		if (of.newVersion) {
			if (direction < 0) {
				of.data[startAdr + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data[startAdr + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data[startAdr + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version13) {
			if (direction < 0) {
				of.data13[startAdr13 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data13[startAdr13 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data13[startAdr13 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version12) {
			if (direction < 0) {
				of.data12[startAdr12 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data12[startAdr12 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data12[startAdr12 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version11) {
			if (direction < 0) {
				of.data11[startAdr11 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data11[startAdr11 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data11[startAdr11 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version10) {
			if (direction < 0) {
				of.data10[startAdr10 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data10[startAdr10 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data10[startAdr10 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version09) {
			if (direction < 0) {
				of.data09[startAdr09 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data09[startAdr09 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data09[startAdr09 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version08) {
			if (direction < 0) {
				of.data08[startAdr08 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data08[startAdr08 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data08[startAdr08 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version6) {
			if (direction < 0) {
				of.data6[startAdr6 + 149 + (size * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data6[startAdr6 + 149 + (size * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data6[startAdr6 + 149 + (size * squad) + (abc * abcSize) + i] = (byte) t;
			}
		} else if (of.version5) {
			if (direction < 0) {
				of.data5[startAdr5 + 149 + (size5 * squad) + (abc * abcSize) + i] = 0;
			} else {
				int t = of.data5[startAdr5 + 149 + (size5 * squad) + (abc * abcSize)
						+ i];
				t = t ^ (1 << direction);
				of.data5[startAdr5 + 149 + (size5 * squad) + (abc * abcSize) + i] = (byte) t;
			}
		}
	}

	static byte getDef(OptionFile of, int squad, int abc, int i) {
		if (of.newVersion)
			return of.data[startAdr + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version13)
			return of.data13[startAdr13 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version12)
			return of.data12[startAdr12 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version11)
			return of.data11[startAdr11 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version10)
			return of.data10[startAdr10 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version09)
			return of.data09[startAdr09 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version08)
			return of.data08[startAdr08 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version6)
			return of.data6[startAdr6 + 160 + (size * squad) + (abc * abcSize) + i];
		else if (of.version5)
			return of.data5[startAdr5 + 160 + (size5 * squad) + (abc * abcSize) + i];
		return (Byte) null;
	}

	static void setDef(OptionFile of, int squad, int abc, int i, int d) {
		if (of.newVersion)
			of.data[startAdr + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version13)
			of.data13[startAdr13 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version12)
			of.data12[startAdr12 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version11)
			of.data11[startAdr11 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version10)
			of.data10[startAdr10 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version09)
			of.data09[startAdr09 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version08)
			of.data08[startAdr08 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version6)
			of.data6[startAdr6 + 160 + (size * squad) + (abc * abcSize) + i] = (byte) d;
		else if (of.version5)
			of.data5[startAdr5 + 160 + (size5 * squad) + (abc * abcSize) + i] = (byte) d;
	}

	static byte getStrat(OptionFile of, int squad, int button) {
		if (of.newVersion)
			return of.data[startAdr + 102 + (size * squad) + button];
		else if (of.version13)
			return of.data13[startAdr13 + 102 + (size * squad) + button];
		else if (of.version12)
			return of.data12[startAdr12 + 102 + (size * squad) + button];
		else if (of.version11)
			return of.data11[startAdr11 + 102 + (size * squad) + button];
		else if (of.version10)
			return of.data10[startAdr10 + 102 + (size * squad) + button];
		else if (of.version09)
			return of.data09[startAdr09 + 102 + (size * squad) + button];
		else if (of.version08)
			return of.data08[startAdr08 + 102 + (size * squad) + button];
		else if (of.version6)
			return of.data6[startAdr6 + 102 + (size * squad) + button];
		else if (of.version5)
			return of.data5[startAdr5 + 102 + (size5 * squad) + button];
		return (Byte) null;
	}

	static void setStrat(OptionFile of, int squad, int button, int strat) {
		if (of.newVersion)
			of.data[startAdr + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version13)
			of.data13[startAdr13 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version12)
			of.data12[startAdr12 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version11)
			of.data11[startAdr11 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version10)
			of.data10[startAdr10 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version09)
			of.data09[startAdr09 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version08)
			of.data08[startAdr08 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version6)
			of.data6[startAdr6 + 102 + (size * squad) + button] = (byte) strat;
		else if (of.version5)
			of.data5[startAdr5 + 102 + (size5 * squad) + button] = (byte) strat;
	}

	static byte getStratOlCB(OptionFile of, int squad) {
		if (of.newVersion)
			return of.data[startAdr + 106 + (size * squad)];
		else if (of.version13)
			return of.data13[startAdr13 + 106 + (size * squad)];
		else if (of.version12)
			return of.data12[startAdr12 + 106 + (size * squad)];
		else if (of.version11)
			return of.data11[startAdr11 + 106 + (size * squad)];
		else if (of.version10)
			return of.data10[startAdr10 + 106 + (size * squad)];
		else if (of.version09)
			return of.data09[startAdr09 + 106 + (size * squad)];
		else if (of.version08)
			return of.data08[startAdr08 + 106 + (size * squad)];
		else if (of.version6)
			return of.data6[startAdr6 + 106 + (size * squad)];
		else if (of.version5)
			return of.data5[startAdr5 + 106 + (size5 * squad)];
		return (Byte) null;
	}

	static void setStratOlCB(OptionFile of, int squad, int cb) {
		if (of.newVersion)
			of.data[startAdr + 106 + (size * squad)] = (byte) cb;
		else if (of.version13)
			of.data13[startAdr13 + 106 + (size * squad)] = (byte) cb;
		else if (of.version12)
			of.data12[startAdr12 + 106 + (size * squad)] = (byte) cb;
		else if (of.version11)
			of.data11[startAdr11 + 106 + (size * squad)] = (byte) cb;
		else if (of.version10)
			of.data10[startAdr10 + 106 + (size * squad)] = (byte) cb;
		else if (of.version09)
			of.data09[startAdr09 + 106 + (size * squad)] = (byte) cb;
		else if (of.version08)
			of.data08[startAdr08 + 106 + (size * squad)] = (byte) cb;
		else if (of.version6)
			of.data6[startAdr6 + 106 + (size * squad)] = (byte) cb;
		else if (of.version5)
			of.data5[startAdr5 + 106 + (size5 * squad)] = (byte) cb;
	}

	static boolean getStratAuto(OptionFile of, int squad) {
		boolean auto = false;
		if (of.newVersion) {
			if (of.data[startAdr + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version13) {
			if (of.data13[startAdr13 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version12) {
			if (of.data12[startAdr12 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version11) {
			if (of.data11[startAdr11 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version10) {
			if (of.data10[startAdr10 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version09) {
			if (of.data09[startAdr09 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version08) {
			if (of.data08[startAdr08 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version6) {
			if (of.data6[startAdr6 + 107 + (size * squad)] == 1) {
				auto = true;
			}
		} else if (of.version5) {
			if (of.data5[startAdr5 + 107 + (size5 * squad)] == 1) {
				auto = true;
			}
		}
		return auto;
	}

	static void setStratAuto(OptionFile of, int squad, boolean auto) {
		byte b = 0;
		if (auto) {
			b = 1;
		}
		if (of.newVersion)
			of.data[startAdr + 107 + (size * squad)] = b;
		else if (of.version13)
			of.data13[startAdr13 + 107 + (size * squad)] = b;
		else if (of.version12)
			of.data12[startAdr12 + 107 + (size * squad)] = b;
		else if (of.version11)
			of.data11[startAdr11 + 107 + (size * squad)] = b;
		else if (of.version10)
			of.data10[startAdr10 + 107 + (size * squad)] = b;
		else if (of.version09)
			of.data09[startAdr09 + 107 + (size * squad)] = b;
		else if (of.version08)
			of.data08[startAdr08 + 107 + (size * squad)] = b;
		else if (of.version6)
			of.data6[startAdr6 + 107 + (size * squad)] = b;
		else if (of.version5)
			of.data5[startAdr5 + 107 + (size5 * squad)] = b;
	}

	static byte getTeam(OptionFile of, int squad, int abc, int set) {
		if (of.newVersion)
			return of.data[startAdr + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version13)
			return of.data13[startAdr13 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version12)
			return of.data12[startAdr12 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version11)
			return of.data11[startAdr11 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version10)
			return of.data10[startAdr10 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version09)
			return of.data09[startAdr09 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version08)
			return of.data08[startAdr08 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version6)
			return of.data6[startAdr6 + 194 + (size * squad) + (abc * abcSize) + set];
		else if (of.version5)
			return of.data5[startAdr5 + 194 + (size5 * squad) + (abc * abcSize) + set];
		return (Byte) null;
	}

	static void setTeam(OptionFile of, int squad, int abc, int set, int v) {
		if (of.newVersion)
			of.data[startAdr + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version13)
			of.data13[startAdr13 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version12)
			of.data12[startAdr12 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version11)
			of.data11[startAdr11 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version10)
			of.data10[startAdr10 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version09)
			of.data09[startAdr09 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version08)
			of.data08[startAdr08 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version6)
			of.data6[startAdr6 + 194 + (size * squad) + (abc * abcSize) + set] = (byte) v;
		else if (of.version5)
			of.data5[startAdr5 + 194 + (size5 * squad) + (abc * abcSize) + set] = (byte) v;
	}

}
