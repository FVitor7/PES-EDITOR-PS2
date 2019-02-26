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

import java.util.Collections;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class NationalityList extends JList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OptionFile of;

	public NationalityList(OptionFile opf) {
		super();
		of = opf;
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayoutOrientation(JList.VERTICAL);
		setVisibleRowCount(32);
	}

	public void refresh(int nation, boolean alpha) {
		int a;
		int index;
		Vector<Player> model = new Vector<Player>();
		if (nation == Stats.nation.length + 4) {
			for (int p = 1; p < Player.total; p++) {
				model.addElement(new Player(of, p, 0));
			}
			for (int p = Player.firstEdit; p < 32768; p++) { //offset
				model.addElement(new Player(of, p, 0));
			}
		} else if (nation == Stats.nation.length + 3) {
			boolean free;

			for (int p = 1; p < Player.firstClassic; p++) {
				free = true;
				a = Squads.slot32 - 2;
				do {
					a = a + 2;
					index = (of.toInt(of.data[a + 1]) << 8)
							| of.toInt(of.data[a]);
					if (index == p) {
						free = false;
					}
				} while (a < Squads.slot32 + (Clubs.total * 64) - 2 + 1
						&& index != p);
				if (free) {
					model.addElement(new Player(of, p, 0));
				}
			}

			for (int p = Player.firstClub; p < Player.firstML; p++) {
				free = true;
				a = Squads.slot32 - 2;
				do {
					a = a + 2;
					index = (of.toInt(of.data[a + 1]) << 8)
							| of.toInt(of.data[a]);
					if (index == p) {
						free = false;
					}
				} while (a < Squads.slot32 + (Clubs.total * 64) - 2
						&& index != p);
				if (free) {
					model.addElement(new Player(of, p, 0));
				}
			}
		} else if (nation == Stats.nation.length + 2) {
			for (int p = 0; p < Player.firstPESUnited; p++) {
				int dupe = getDupe(p);
				if (dupe != -1) {
					//model.addElement(new Player(of, p, 0));
					model.addElement(new Player(of, dupe, 0));
				}
			}
		} else if (nation == Stats.nation.length + 1) {
			for (int p = Player.firstYoung; p < Player.firstOld; p++) {
				model.addElement(new Player(of, p, 0));
			}
		} else if (nation == Stats.nation.length) {
			for (int p = Player.firstOld; p < Player.firstUnused; p++) {
				model.addElement(new Player(of, p, 0));
			}
		} else {
			for (int p = 1; p < Player.total; p++) {
				if (Stats.getValue(of, p, Stats.nationality) == nation) {
					model.addElement(new Player(of, p, 0));
				}
			}
			for (int p = Player.firstEdit; p < 32952; p++) { //offset
				if (Stats.getValue(of, p, Stats.nationality) == nation) {
					model.addElement(new Player(of, p, 0));
				}
			}
		}
		if (alpha) {
			Collections.sort(model);
		}
		model.trimToSize();
		setListData(model);
	}

	private int getDupe(int p) {
		for (int i = 1; i < Player.firstPESUnited; i++) {
			boolean isDupe = true;
			if (i == p || (Stats.getValue(of, p, Stats.height) != Stats.getValue(of,
					i, Stats.height) && Stats.getValue(of, p, Stats.weight) != Stats.getValue(of,
							i, Stats.weight))) {
				isDupe = false;
			} else {
				int score = 0;
				if (Stats.getValue(of, p, Stats.foot) == Stats.getValue(of, i,
						Stats.foot)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.favSide) == Stats.getValue(of,
						i, Stats.favSide)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.wfa) == Stats.getValue(of,
						i, Stats.wfa)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.wff) == Stats.getValue(of,
						i, Stats.wff)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.injury) == Stats.getValue(of,
						i, Stats.injury)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.dribSty) == Stats.getValue(of,
						i, Stats.dribSty)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.freekick) == Stats.getValue(of,
						i, Stats.freekick)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.pkStyle) == Stats.getValue(of,
						i, Stats.pkStyle)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.dkSty) == Stats.getValue(of,
						i, Stats.dkSty)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.age) == Stats.getValue(of, i,
						Stats.age)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.consistency) == Stats.getValue(of,
						i, Stats.consistency)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.condition) == Stats.getValue(of, i,
						Stats.condition)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.attack) == Stats.getValue(of,
						i, Stats.attack)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.defence) == Stats.getValue(of,
						i, Stats.defence)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.balance) == Stats.getValue(of,
						i, Stats.balance)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.stamina) == Stats.getValue(of,
						i, Stats.stamina)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.speed) == Stats.getValue(of,
						i, Stats.speed)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.accel) == Stats.getValue(of, i,
						Stats.accel)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.response) == Stats.getValue(of, i,
						Stats.response)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.agility) == Stats.getValue(of, i,
						Stats.agility)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.dribAcc) == Stats.getValue(of,
						i, Stats.dribAcc)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.dribSpe) == Stats.getValue(of,
						i, Stats.dribSpe)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.sPassAcc) == Stats.getValue(of,
						i, Stats.sPassAcc)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.sPassSpe) == Stats.getValue(of,
						i, Stats.sPassSpe)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.lPassAcc) == Stats.getValue(of,
						i, Stats.lPassAcc)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.lPassSpe) == Stats.getValue(of,
						i, Stats.lPassSpe)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.shotAcc) == Stats.getValue(of, i,
						Stats.shotAcc)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.shotPow) == Stats.getValue(of,
						i, Stats.shotPow)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.shotTec) == Stats.getValue(of, i,
						Stats.shotTec)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.fk) == Stats.getValue(of,
						i, Stats.fk)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.curling) == Stats.getValue(of,
						i, Stats.curling)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.heading) == Stats.getValue(of,
						i, Stats.heading)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.jump) == Stats.getValue(of,
						i, Stats.jump)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.tech) == Stats.getValue(of,
						i, Stats.tech)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.aggress) == Stats.getValue(of,
						i, Stats.aggress)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.mental) == Stats.getValue(of, i,
						Stats.mental)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.gkAbil) == Stats.getValue(of, i,
						Stats.gkAbil)) {
					score++;
				}
				if (Stats.getValue(of, p, Stats.team) == Stats.getValue(of, i,
						Stats.team)) {
					score++;
				}
				if (score < 38) {
					isDupe = false;
				}
			}
			if (isDupe) {
				return i;
			}
		}
		return -1;
	}

}
