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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import java.io.UnsupportedEncodingException;

public class SelectByTeam extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SquadList squadList;

	JComboBox teamBox;

	OptionFile of;

	SquadNumList numList;

	PositionList posList;

	boolean normal;

	// NameEditor nameEditor;

	public SelectByTeam(OptionFile opf, boolean n) {
		super(new BorderLayout());
		of = opf;
		normal = n;
		// getTeams();
		teamBox = new JComboBox();
		teamBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent t) {
				// System.out.println(teamBox.getSelectedIndex());
				if (teamBox.getSelectedIndex() != -1) {
					squadList.refresh(teamBox.getSelectedIndex(), true);
					if (normal) {
						posList.refresh(teamBox.getSelectedIndex());
						numList.refresh(teamBox.getSelectedIndex());
					}
				}
			}
		});
		teamBox.setMaximumRowCount(32);
		squadList = new SquadList(of, n);
		add(teamBox, BorderLayout.NORTH);
		if (normal) {
			numList = new SquadNumList(of);
			posList = new PositionList(of, true);
			add(posList, BorderLayout.WEST);
			add(squadList, BorderLayout.CENTER);
			add(numList, BorderLayout.EAST);
		} else {
			JScrollPane scroll = new JScrollPane(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			setPreferredSize(null);
			scroll.setViewportView(squadList);
			add(scroll, BorderLayout.CENTER);
		}
		if (normal) {
			setPreferredSize(new Dimension(164, 601));
		}
	}

	public void refresh() {
		String[] squads;
		if (of.version12) {
			if (normal) {
				squads = new String[60 + PESUtils.extraSquad.length + Clubs.total12]; //squadnumber
			} else {
				squads = new String[60 + PESUtils.extraSquad.length + Clubs.total12
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation12, 0, squads, 0, 60); //squadnumber
			System.arraycopy(PESUtils.extraSquad, 0, squads, 60, 15); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 60 + 15, Clubs.total12); //squadnumber
			System.arraycopy(PESUtils.extraSquad, 15, squads,
					60 + 15 + Clubs.total12, 7); //squadnumber
			if (!normal) {
				squads[60 + PESUtils.extraSquad.length + Clubs.total12] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(60 + 15); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(60 + PESUtils.extraSquad.length //squadnumber
						+ Clubs.total12);
			}
		} else if (of.version11) {
			if (normal) {
				squads = new String[60 + PESUtils.extraSquad.length + Clubs.total11]; //squadnumber
			} else {
				squads = new String[60 + PESUtils.extraSquad.length + Clubs.total11
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation11, 0, squads, 0, 60); //squadnumber
			System.arraycopy(PESUtils.extraSquad, 0, squads, 60, 15); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 60 + 15, Clubs.total11); //squadnumber
			System.arraycopy(PESUtils.extraSquad, 15, squads,
					60 + 15 + Clubs.total11, 7); //squadnumber
			if (!normal) {
				squads[60 + PESUtils.extraSquad.length + Clubs.total11] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(60 + 15); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(60 + PESUtils.extraSquad.length //squadnumber
						+ Clubs.total11);
			}
		} else if (of.version10) {
			if (normal) {
				squads = new String[60 + PESUtils.extraSquad10.length + Clubs.total10]; //squadnumber
			} else {
				squads = new String[60 + PESUtils.extraSquad10.length + Clubs.total10
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation10, 0, squads, 0, 60); //squadnumber
			System.arraycopy(PESUtils.extraSquad10, 0, squads, 60, 15); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 60 + 15, Clubs.total10); //squadnumber
			System.arraycopy(PESUtils.extraSquad10, 15, squads,
					60 + 15 + Clubs.total10, 6); //squadnumber
			if (!normal) {
				squads[60 + PESUtils.extraSquad10.length + Clubs.total10] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(60 + 15); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(60 + PESUtils.extraSquad10.length //squadnumber
						+ Clubs.total10);
			}
		} else if (of.version09) {
			if (normal) {
				squads = new String[60 + PESUtils.extraSquad09.length + Clubs.total09]; //squadnumber
			} else {
				squads = new String[60 + PESUtils.extraSquad09.length + Clubs.total09
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation09, 0, squads, 0, 60); //squadnumber
			System.arraycopy(PESUtils.extraSquad09, 0, squads, 60, 15); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 60 + 15, Clubs.total09); //squadnumber
			System.arraycopy(PESUtils.extraSquad09, 15, squads,
					60 + 15 + Clubs.total09, 6); //squadnumber
			if (!normal) {
				squads[60 + PESUtils.extraSquad09.length + Clubs.total09] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(60 + 15); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(60 + PESUtils.extraSquad09.length //squadnumber
						+ Clubs.total09);
			}
		} else if (of.version08) {
			if (normal) {
				squads = new String[57 + PESUtils.extraSquad08.length + Clubs.total08]; //squadnumber
			} else {
				squads = new String[57 + PESUtils.extraSquad08.length + Clubs.total08
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation08, 0, squads, 0, 57); //squadnumber
			System.arraycopy(PESUtils.extraSquad08, 0, squads, 57, 16); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 57 + 16, Clubs.total08); //squadnumber
			System.arraycopy(PESUtils.extraSquad08, 16, squads,
					57 + 16 + Clubs.total08, 6); //squadnumber
			if (!normal) {
				squads[57 + PESUtils.extraSquad08.length + Clubs.total08] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(57 + 16); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(57 + PESUtils.extraSquad08.length //squadnumber
						+ Clubs.total08);
			}
		} else if (of.version6) {
			if (normal) {
				squads = new String[57 + PESUtils.extraSquad6.length + Clubs.total6]; //squadnumber
			} else {
				squads = new String[57 + PESUtils.extraSquad6.length + Clubs.total6
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation6, 0, squads, 0, 57); //squadnumber
			System.arraycopy(PESUtils.extraSquad6, 0, squads, 57, 16); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 57 + 16, Clubs.total6); //squadnumber
			System.arraycopy(PESUtils.extraSquad6, 16, squads,
					57 + 16 + Clubs.total6, 6); //squadnumber
			if (!normal) {
				squads[57 + PESUtils.extraSquad6.length + Clubs.total6] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(57 + 16); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(57 + PESUtils.extraSquad6.length //squadnumber
						+ Clubs.total6);
			}
		} else if (of.version5) {
			if (normal) {
				squads = new String[57 + PESUtils.extraSquad5.length + Clubs.total5]; //squadnumber
			} else {
				squads = new String[57 + PESUtils.extraSquad5.length + Clubs.total5
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation5, 0, squads, 0, 57); //squadnumber
			System.arraycopy(PESUtils.extraSquad5, 0, squads, 57, 17); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 57 + 17, Clubs.total5); //squadnumber
			System.arraycopy(PESUtils.extraSquad5, 17, squads,
					57 + 17 + Clubs.total5, 7); //squadnumber
			if (!normal) {
				squads[57 + PESUtils.extraSquad5.length + Clubs.total5] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(57 + 17); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(57 + PESUtils.extraSquad5.length //squadnumber
						+ Clubs.total5);
			}
		} else {
			if (normal) {
				squads = new String[60 + PESUtils.extraSquad.length + Clubs.total]; //squadnumber
			} else {
				squads = new String[60 + PESUtils.extraSquad.length + Clubs.total
						+ 1]; //squadnumber
			}
			System.arraycopy(Stats.nation, 0, squads, 0, 60); //squadnumber
			System.arraycopy(PESUtils.extraSquad, 0, squads, 60, 15); //squadnumber
			System.arraycopy(Clubs.getNames(of), 0, squads, 60 + 15, Clubs.total); //squadnumber
			System.arraycopy(PESUtils.extraSquad, 15, squads,
					60 + 15 + Clubs.total, 7); //squadnumber
			if (!normal) {
				squads[60 + PESUtils.extraSquad.length + Clubs.total] = "All Players"; //squadnumber
			}
			teamBox.setModel(new DefaultComboBoxModel(squads));
			if (normal) {
				teamBox.setSelectedIndex(60 + 15); //squadnumber
				numList.refresh(teamBox.getSelectedIndex());
				posList.refresh(teamBox.getSelectedIndex());
			} else {
				teamBox.setSelectedIndex(60 + PESUtils.extraSquad.length //squadnumber
						+ Clubs.total);
			}
		}

		squadList.refresh(teamBox.getSelectedIndex(), true);
	}

}
