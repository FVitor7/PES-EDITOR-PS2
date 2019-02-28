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

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SquadNumList extends JList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OptionFile of;

	public SquadNumList(OptionFile opf) {
		super();
		// System.out.println("team-" + team);
		of = opf;
		// refresh(team);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayoutOrientation(JList.VERTICAL);
		setVisibleRowCount(1);
		// setFont(new Font("Dialog", Font.BOLD, 12));
		// System.out.println(getFont());
		setPreferredSize(new Dimension(16, 576));
	}

	public void refresh(int team) {
		String[] num;
		int size = 0;
		int firstAdr = 0;
		int a;
		int n = 0;
		int ft = 0;
		if (of.newVersion) {
			if (team < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num23 + (team * size);
				ft = team;
			} else if (team == 73) { //squadnumber
				size = 14;
				firstAdr = Squads.num23 + (team * 23);
				ft = team;
			} else {
				size = 32;
				firstAdr = Squads.num32 + ((team - 75) * size); //squadnumber
				ft = team - 8;
			}
		} else if (of.version13) {
			if (team < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num2313 + (team * size);
				ft = team;
			} else if (team == 73) { //squadnumber
				size = 14;
				firstAdr = Squads.num2313 + (team * 23);
				ft = team;
			} else {
				size = 32;
				firstAdr = Squads.num3213 + ((team - 75) * size); //squadnumber
				ft = team - 8;
			}
		} else if (of.version12) {
			if (team < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num2312 + (team * size);
				ft = team;
			} else if (team == 73) { //squadnumber
				size = 14;
				firstAdr = Squads.num2312 + (team * 23);
				ft = team;
			} else {
				size = 32;
				firstAdr = Squads.num3212 + ((team - 75) * size); //squadnumber
				ft = team - 8;
			}
		} else if (of.version11) {
			if (team < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num2311 + (team * size);
				ft = team;
			} else if (team == 73) { //squadnumber
				size = 14;
				firstAdr = Squads.num2311 + (team * 23);
				ft = team;
			} else {
				size = 32;
				firstAdr = Squads.num3211 + ((team - 75) * size); //squadnumber
				ft = team - 8;
			}
		} else if (of.version10) {
			if (team < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num2310 + (team * size);
				ft = team;
			} else if (team == 73) { //squadnumber
				size = 14;
				firstAdr = Squads.num2310 + (team * 23);
				ft = team;
			} else {
				size = 32;
				firstAdr = Squads.num3210 + ((team - 75) * size); //squadnumber
				ft = team - 8;
			}
		} else if (of.version09) {
			if (team < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num2309 + (team * size);
				ft = team;
			} else if (team == 73) { //squadnumber
				size = 14;
				firstAdr = Squads.num2309 + (team * 23);
				ft = team;
			} else {
				size = 32;
				firstAdr = Squads.num3209 + ((team - 75) * size); //squadnumber
				ft = team - 8;
			}
		} else if (of.version08) {
			if (team < 71) { //squadnumber
				size = 23;
				firstAdr = Squads.num2308 + (team * size);
				ft = team;
			} else if (team == 71) { //squadnumber
				size = 14;
				firstAdr = Squads.num2308 + (team * 23);
				ft = team;
			} else {
					size = 32;
					firstAdr = Squads.num3208 + ((team - 73) * size); //squadnumber
					ft = team - 8;
			}
		} else if (of.version6) {
			if (team < 71) { //squadnumber
				size = 23;
				firstAdr = Squads.num236 + (team * size);
				ft = team;
			} else if (team == 71) { //squadnumber
				size = 14;
				firstAdr = Squads.num236 + (team * 23);
				ft = team;
			} else {
					size = 32;
					firstAdr = Squads.num326 + ((team - 73) * size); //squadnumber
					ft = team - 8;
			}
		} else if (of.version5) {
			if (team < 72) { //squadnumber
				size = 23;
				firstAdr = Squads.num236 + (team * size);
				ft = team;
			} else if (team == 72) { //squadnumber
				size = 14;
				firstAdr = Squads.num236 + (team * 23);
				ft = team;
			} else {
					size = 32;
					firstAdr = Squads.num326 + ((team - 74) * size); //squadnumber
					ft = team - 8;
			}
		}

		num = new String[size];
		for (int p = 0; p < size; p++) {
			a = firstAdr + p;

			if (of.newVersion) {
				if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.newSquadNumber - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version13) {
				if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber13 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version12) {
				if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber12 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version11) {
				if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber11 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version10) {
				if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber10 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version09) {
				if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber09 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version08) {
				if ((team >= 0 && team < 64) || (team >= 73 && team < Squads.squadNumber08 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version6) {
				if ((team >= 0 && team < 64) || (team >= 73 && team < Squads.squadNumber6 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			} else if (of.version5) {
				if ((team >= 0 && team < 64) || (team >= 74 && team < Squads.squadNumber5 - 7 )) { //squadnumber
					// a = 670512 + (628 * ft) + 6232 + p;
					a = firstAdr + Formations.getSlot(of, ft, p);
				}
			}

			if (of.newVersion)
				n = of.toInt(of.data[a]) + 1;
			else if (of.version13)
				n = of.toInt(of.data13[a]) + 1;
			else if (of.version12)
				n = of.toInt(of.data12[a]) + 1;
			else if (of.version11)
				n = of.toInt(of.data11[a]) + 1;
			else if (of.version10)
				n = of.toInt(of.data10[a]) + 1;
			else if (of.version09)
				n = of.toInt(of.data09[a]) + 1;
			else if (of.version08)
				n = of.toInt(of.data08[a]) + 1;
			else if (of.version6)
				n = of.toInt(of.data6[a]) + 1;
			else if (of.version5)
				n = of.toInt(of.data5[a]) + 1;
			if (n == 256) {
				num[p] = "...";
			} else {
				num[p] = String.valueOf(n);
			}
		}
		setListData(num);
		// System.out.println(getWidth() + ", " + getHeight());
	}

}
