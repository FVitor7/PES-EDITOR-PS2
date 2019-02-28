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
import java.util.Collections;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SquadList extends JList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OptionFile of;

	public int team;

	public SquadList(OptionFile opf, boolean setSize) {
		super();
		// System.out.println("team-" + team);
		of = opf;
		// refresh(team);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayoutOrientation(JList.VERTICAL);
		setVisibleRowCount(32);
		// setFont(new Font("Dialog", Font.BOLD, 12));
		// System.out.println(getFont());
		if (setSize) {
			setPreferredSize(new Dimension(118, 576));
		}
	}

	public void refresh(int t, boolean normal) {
		team = t;
		if (of.version08) {
			if (!normal) {
				if (team > 63) { //squadnumber
					team = team + 9;
				}
			}
		} else if (of.version6) {
			if (!normal) {
				if (team > 63) { //squadnumber
					team = team + 9;
				}
			}
		} else if (of.version5) {
			if (!normal) {
				if (team > 63) { //squadnumber
					team = team + 10;
				}
			}
		} else {
			if (!normal) {
				if (team > 66) { //squadnumber
					team = team + 8;
				}
			}
		}
		if (of.newVersion) {
			if (team == Squads.newSquadNumber) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot23 + (team * size * 2);
					ft = team;
				} else if (team == 73) { //squadnumber
					size = 14;
					firstAdr = Squads.slot23 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot32 + ((team - 75) * size * 2); //squadnumber
					ft = team - 8;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.newSquadNumber - 7)) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data[a + 1]) << 8)
						| of.toInt(of.data[a]), a);
				}
				setListData(players);
			}
		} else if (of.version13) {
			if (team == Squads.squadNumber13) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total13; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit13; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot2313 + (team * size * 2);
					ft = team;
				} else if (team == 73) { //squadnumber
					size = 14;
					firstAdr = Squads.slot2313 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot3213 + ((team - 75) * size * 2); //squadnumber
					ft = team - 8;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber13 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data13[a + 1]) << 8)
						| of.toInt(of.data13[a]), a);
				}
				setListData(players);
			}
		} else if (of.version12) {
			if (team == Squads.squadNumber12) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total12; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit12; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot2312 + (team * size * 2);
					ft = team;
				} else if (team == 73) { //squadnumber
					size = 14;
					firstAdr = Squads.slot2312 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot3212 + ((team - 75) * size * 2); //squadnumber
					ft = team - 8;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber12 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data12[a + 1]) << 8)
						| of.toInt(of.data12[a]), a);
				}
				setListData(players);
			}
		} else if (of.version11) {
			if (team == Squads.squadNumber11) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total11; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit11; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot2311 + (team * size * 2);
					ft = team;
				} else if (team == 73) { //squadnumber
					size = 14;
					firstAdr = Squads.slot2311 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot3211 + ((team - 75) * size * 2); //squadnumber
					ft = team - 8;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber11 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data11[a + 1]) << 8)
						| of.toInt(of.data11[a]), a);
				}
				setListData(players);
			}
		} else if (of.version10) {
			if (team == Squads.squadNumber10) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total10; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit10; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot2310 + (team * size * 2);
					ft = team;
				} else if (team == 73) { //squadnumber
					size = 14;
					firstAdr = Squads.slot2310 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot3210 + ((team - 75) * size * 2); //squadnumber
					ft = team - 8;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber10 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data10[a + 1]) << 8)
						| of.toInt(of.data10[a]), a);
				}
				setListData(players);
			}
		} else if (of.version09) {
			if (team == Squads.squadNumber09) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total09; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit09; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot2309 + (team * size * 2);
					ft = team;
				} else if (team == 73) { //squadnumber
					size = 14;
					firstAdr = Squads.slot2309 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot3209 + ((team - 75) * size * 2); //squadnumber
					ft = team - 8;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 67) || (team >= 75 && team < Squads.squadNumber09 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data09[a + 1]) << 8)
						| of.toInt(of.data09[a]), a);
				}
				setListData(players);
			}
		} else if (of.version08) {
			if (team == Squads.squadNumber08) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total08; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit08; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 71) { //squadnumber
					size = 23;
					firstAdr = Squads.slot2308 + (team * size * 2);
					ft = team;
				} else if (team == 71) { //squadnumber
					size = 14;
					firstAdr = Squads.slot2308 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot3208 + ((team - 73) * size * 2); //squadnumber
					ft = team - 9;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 64) || (team >= 73 && team < Squads.squadNumber08 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data08[a + 1]) << 8)
						| of.toInt(of.data08[a]), a);
				}
				setListData(players);
			}
		} else if (of.version6) {
			if (team == Squads.squadNumber6) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total6; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit6; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 71) { //squadnumber
					size = 23;
					firstAdr = Squads.slot236 + (team * size * 2);
					ft = team;
				} else if (team == 71) { //squadnumber
					size = 14;
					firstAdr = Squads.slot236 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot326 + ((team - 73) * size * 2); //squadnumber
					ft = team - 9;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 64) || (team >= 73 && team < Squads.squadNumber6 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data6[a + 1]) << 8)
						| of.toInt(of.data6[a]), a);
				}
				setListData(players);
			}
		} else if (of.version5) {
			if (team == Squads.squadNumber5) { //squadnumber
				Vector<Player> model = new Vector<Player>();
				for (int p = 1; p < Player.total5; p++) {
					model.addElement(new Player(of, p, 0));
				}
				for (int p = Player.firstEdit5; p < 32952; p++) { //offset
					model.addElement(new Player(of, p, 0));
				}
				Collections.sort(model);
				model.trimToSize();
				setListData(model);
			} else {
				Player[] players;
				int size;
				int firstAdr = 0;
				int ft;
				int a;
				if (team < 72) { //squadnumber
					size = 23;
					firstAdr = Squads.slot235 + (team * size * 2);
					ft = team;
				} else if (team == 72) { //squadnumber
					size = 14;
					firstAdr = Squads.slot235 + (team * 23 * 2);
					ft = team;
				} else {
					size = 32;
					firstAdr = Squads.slot325 + ((team - 74) * size * 2); //squadnumber
					ft = team - 10;
				}
				players = new Player[size];
				for (int p = 0; p < size; p++) {
					a = firstAdr + (p * 2);
					if ((team >= 0 && team < 64) || (team >= 74 && team < Squads.squadNumber5 - 7 )) { //squadnumber
						// a = 670512 + (628 * ft) + 6232 + p;
						a = firstAdr + (Formations.getSlot(of, ft, p) * 2);
					}
					players[p] = new Player(of, (of.toInt(of.data5[a + 1]) << 8)
						| of.toInt(of.data5[a]), a);
				}
				setListData(players);
			}
		}
	}

}
