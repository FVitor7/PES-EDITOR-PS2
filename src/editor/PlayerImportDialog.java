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
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PlayerImportDialog extends JDialog implements
		ListSelectionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OptionFile of;

	OptionFile of2;

	JLabel fileLabel;

	SelectByTeam plList;

	InfoPanel infoPanel;

	boolean of2Open;

	int index;

	int replacement;

	JRadioButton allButton;

	JRadioButton statsButton;

	JRadioButton exStatsButton;

	JRadioButton oldButton;

	JPanel topPanel = new JPanel(new GridLayout(4, 1));

	public PlayerImportDialog(Frame owner, OptionFile opf, OptionFile opf2) {
		super(owner, "Import Player", true);
		of = opf;
		of2 = opf2;
		fileLabel = new JLabel("From:");
		plList = new SelectByTeam(of2, false);
		infoPanel = new InfoPanel(of2);
		plList.squadList.addListSelectionListener(this);
		plList.squadList.addMouseListener(this);
		CancelButton cancelButton = new CancelButton(this);

		allButton = new JRadioButton(
				"Import everything (name, appearance, stats, etc.)");
		statsButton = new JRadioButton(
				"Import only the stats editable on the 'Edit Player' dialog");
		exStatsButton = new JRadioButton(
				"Import everything except stats (name, appearance, etc.)");
		oldButton = new JRadioButton(
				"Import name and stats");
		ButtonGroup group = new ButtonGroup();
		group.add(allButton);
		group.add(statsButton);
		group.add(exStatsButton);
		group.add(oldButton);
		allButton.setSelected(true);

		topPanel.add(fileLabel);
		topPanel.add(allButton);
		topPanel.add(statsButton);
		topPanel.add(exStatsButton);

		getContentPane().add(plList, BorderLayout.WEST);
		getContentPane().add(infoPanel, BorderLayout.CENTER);
		getContentPane().add(cancelButton, BorderLayout.SOUTH);
		getContentPane().add(topPanel, BorderLayout.NORTH);

		of2Open = false;
		index = 0;
		replacement = 0;
		pack();
		setResizable(false);
	}

	public void show(int i) {
		index = i;
		setVisible(true);
	}

	public void refresh() {
		plList.refresh();
		of2Open = true;
		if (of2.version10 || of2.version09 || of2.version08 || of2.version6 || of2.version5) {
			topPanel.remove(allButton);
			topPanel.remove(statsButton);
			topPanel.remove(exStatsButton);
			topPanel.add(oldButton);
			topPanel.add(statsButton);
			oldButton.setSelected(true);
		} else {
			topPanel.remove(oldButton);
			topPanel.remove(statsButton);
			topPanel.add(allButton);
			topPanel.add(statsButton);
			topPanel.add(exStatsButton);
			allButton.setSelected(true);
		}
		if (of2.newVersion)
			fileLabel.setText("From:  " + of2.fileName);
		else if (of2.version13)
			fileLabel.setText("From PES2013 OF:  " + of2.fileName); //version
		else if (of2.version12)
			fileLabel.setText("From PES2012 OF:  " + of2.fileName); //version
		else if (of2.version11)
			fileLabel.setText("From PES2011 OF:  " + of2.fileName); //version
		else if (of2.version10)
			fileLabel.setText("From PES2010 OF:  " + of2.fileName); //version
		else if (of2.version09)
			fileLabel.setText("From PES2009 OF:  " + of2.fileName); //version
		else if (of2.version08)
			fileLabel.setText("From PES2008 OF:  " + of2.fileName); //version
		else if (of2.version6)
			fileLabel.setText("From PES6 OF:  " + of2.fileName); //version
		else if (of2.version5)
			fileLabel.setText("From PES5 OF:  " + of2.fileName); //version
		index = 0;
		replacement = 0;
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			if (!plList.squadList.isSelectionEmpty()) {
				infoPanel
						.refresh(
								((Player) plList.squadList.getSelectedValue()).index,
								0);
			}
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int clicks = e.getClickCount();
		JList list = (JList) (e.getSource());
		int pi = ((Player) list.getSelectedValue()).index;
		if (clicks == 2 && pi != 0) {
			replacement = pi;
			importPlayer();
			setVisible(false);
		}
	}

	private void importPlayer() {
		int ia = 0;
		int ra = 0;
		if (of2.newVersion) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr + (replacement * 124);
			if (replacement >= Player.firstEdit) {
				ra = Player.startAdrE + ((replacement - Player.firstEdit) * 124);
			}
		} else if (of2.version13) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr13 + (replacement * 124);
			if (replacement >= Player.firstEdit13) {
				ra = Player.startAdrE13 + ((replacement - Player.firstEdit13) * 124);
			}
		} else if (of2.version12) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr12 + (replacement * 124);
			if (replacement >= Player.firstEdit12) {
				ra = Player.startAdrE12 + ((replacement - Player.firstEdit12) * 124);
			}
		} else if (of2.version11) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr11 + (replacement * 124);
			if (replacement >= Player.firstEdit11) {
				ra = Player.startAdrE11 + ((replacement - Player.firstEdit11) * 124);
			}
		} else if (of2.version10) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr10 + (replacement * 124);
			if (replacement >= Player.firstEdit10) {
				ra = Player.startAdrE10 + ((replacement - Player.firstEdit10) * 124);
			}
		} else if (of2.version09) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr09 + (replacement * 124);
			if (replacement >= Player.firstEdit09) {
				ra = Player.startAdrE09 + ((replacement - Player.firstEdit09) * 124);
			}
		} else if (of2.version08) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr08 + (replacement * 124);
			if (replacement >= Player.firstEdit08) {
				ra = Player.startAdrE08 + ((replacement - Player.firstEdit08) * 124);
			}
		} else if (of2.version6) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr6 + (replacement * 124);
			if (replacement >= Player.firstEdit6) {
				ra = Player.startAdrE6 + ((replacement - Player.firstEdit6) * 124);
			}
		} else if (of2.version5) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			ra = Player.startAdr5 + (replacement * 124);
			if (replacement >= Player.firstEdit5) {
				ra = Player.startAdrE5 + ((replacement - Player.firstEdit5) * 124);
			}
		}
		if (allButton.isSelected()) {
			if (of2.newVersion)
				System.arraycopy(of2.data, ra, of.data, ia, 124);
			else if (of2.version13) {
				System.arraycopy(of2.data13, ra, of.data, ia, 124);
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation13[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version12) {
				System.arraycopy(of2.data12, ra, of.data, ia, 124);
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation12[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version11) {
				System.arraycopy(of2.data11, ra, of.data, ia, 124);
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation11[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			}
		} else if (statsButton.isSelected()) {
			if (of2.newVersion)
				Stats.setValue(of, index, Stats.nationality, Stats.getValue(of2,
					replacement, Stats.nationality));
			else if (of2.version13) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation13[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version12) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation12[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version11) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation11[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version10) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation10[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version09) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation09[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version08) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation08[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version6) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation6[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version5) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation5[Stats.getValue(of2, replacement, Stats.nationality5)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
				Stats.setValue(of, index, Stats.favSide, Stats.getValue(of2, replacement, Stats.favSide5));
				Stats.setValue(of, index, Stats.wfa, Stats.getValue(of2, replacement, Stats.wfa5));
				Stats.setValue(of, index, Stats.wff, Stats.getValue(of2, replacement, Stats.wff5));
				Stats.setValue(of, index, Stats.injury, Stats.getValue(of2, replacement, Stats.injury5));
				Stats.setValue(of, index, Stats.age, Stats.getValue(of2, replacement, Stats.age5));
				Stats.setValue(of, index, Stats.weight, Stats.getValue(of2, replacement, Stats.weight5));
				Stats.setValue(of, index, Stats.consistency, Stats.getValue(of2, replacement, Stats.consistency5));
				Stats.setValue(of, index, Stats.condition, Stats.getValue(of2, replacement, Stats.condition5));
				for (int i = 0; i < Stats.roles.length; i++) {
					Stats.setValue(of, index, Stats.roles[i], Stats.getValue(of2, replacement, Stats.roles5[i]));
				}
				for (int i = 0; i < Stats.ability99.length; i++) {
					Stats.setValue(of, index, Stats.ability99[i], Stats.getValue(of2, replacement, Stats.ability995[i]));
				}
				for (int i = 0; i < Stats.abilitySpecial.length; i++) {
					Stats.setValue(of, index, Stats.abilitySpecial[i], Stats.getValue(of2, replacement, Stats.abilitySpecial5[i]));
				}
				Stats.setValue(of, index, Stats.abilityEdited, Stats.getValue(of2, replacement, Stats.age5));
			}
			
			Stats.setValue(of, index, Stats.height, Stats.getValue(of2,
					replacement, Stats.height));
			Stats.setValue(of, index, Stats.foot, Stats.getValue(of2,
							replacement, Stats.foot));
			Stats.setValue(of, index, Stats.dribSty, Stats.getValue(of2,
					replacement, Stats.dribSty));
			Stats.setValue(of, index, Stats.pkStyle, Stats.getValue(of2,
					replacement, Stats.pkStyle));
			Stats.setValue(of, index, Stats.freekick, Stats.getValue(of2,
					replacement, Stats.freekick));
			Stats.setValue(of, index, Stats.dkSty, Stats.getValue(of2,
					replacement, Stats.dkSty));
			Stats.setValue(of, index, Stats.regPos, Stats.getValue(of2,
					replacement, Stats.regPos));

			if (!of2.version5) {
				Stats.setValue(of, index, Stats.age, Stats.getValue(of2,
						replacement, Stats.age));
				Stats.setValue(of, index, Stats.weight, Stats.getValue(of2,
						replacement, Stats.weight));
				Stats.setValue(of, index, Stats.favSide, Stats.getValue(of2,
						replacement, Stats.favSide));
				Stats.setValue(of, index, Stats.wfa, Stats.getValue(of2,
						replacement, Stats.wfa));
				Stats.setValue(of, index, Stats.wff, Stats.getValue(of2,
						replacement, Stats.wff));
				Stats.setValue(of, index, Stats.condition, Stats.getValue(of2,
						replacement, Stats.condition));
				Stats.setValue(of, index, Stats.consistency, Stats.getValue(of2,
						replacement, Stats.consistency));
				Stats.setValue(of, index, Stats.injury, Stats.getValue(of2,
						replacement, Stats.injury));
				for (int i = 0; i < Stats.roles.length; i++) {
					Stats.setValue(of, index, Stats.roles[i], Stats.getValue(of2,
							replacement, Stats.roles[i]));
				}
				for (int i = 0; i < Stats.ability99.length; i++) {
					Stats.setValue(of, index, Stats.ability99[i], Stats.getValue(
							of2, replacement, Stats.ability99[i]));
				}
				for (int i = 0; i < Stats.abilitySpecial.length; i++) {
					Stats.setValue(of, index, Stats.abilitySpecial[i], Stats
							.getValue(of2, replacement, Stats.abilitySpecial[i]));
				}
				Stats.setValue(of, index, Stats.abilityEdited, 1);
			}
		} else if (oldButton.isSelected()) {
			ia = Player.startAdr + (index * 124);
			if (index >= Player.firstEdit) {
				ia = Player.startAdrE + ((index - Player.firstEdit) * 124);
			}
			if (of2.version10) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation10[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				ra = Player.startAdr10 + (replacement * 124);
				if (replacement >= Player.firstEdit10) {
					ra = Player.startAdrE10 + ((replacement - Player.firstEdit10) * 124);
				}
				System.arraycopy(of2.data10, ra, of.data, ia, 48);
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version09) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation09[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				ra = Player.startAdr09 + (replacement * 124);
				if (replacement >= Player.firstEdit09) {
					ra = Player.startAdrE09 + ((replacement - Player.firstEdit09) * 124);
				}
				System.arraycopy(of2.data09, ra, of.data, ia, 48);
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version08) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation08[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				ra = Player.startAdr08 + (replacement * 124);
				if (replacement >= Player.firstEdit08) {
					ra = Player.startAdrE08 + ((replacement - Player.firstEdit08) * 124);
				}
				System.arraycopy(of2.data08, ra, of.data, ia, 48);
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version6) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation6[Stats.getValue(of2, replacement, Stats.nationality)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				ra = Player.startAdr6 + (replacement * 124);
				if (replacement >= Player.firstEdit6) {
					ra = Player.startAdrE6 + ((replacement - Player.firstEdit6) * 124);
				}
				System.arraycopy(of2.data6, ra, of.data, ia, 48);
				Stats.setValue(of, index, Stats.nationality, nat);
			} else if (of2.version5) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation.length; i++) {
					if (!found && Stats.nation5[Stats.getValue(of2, replacement, Stats.nationality5)].equals(Stats.nation[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of, index, Stats.nationality, nat);
				Stats.setValue(of, index, Stats.favSide, Stats.getValue(of2, replacement, Stats.favSide5));
				Stats.setValue(of, index, Stats.wfa, Stats.getValue(of2, replacement, Stats.wfa5));
				Stats.setValue(of, index, Stats.wff, Stats.getValue(of2, replacement, Stats.wff5));
				Stats.setValue(of, index, Stats.injury, Stats.getValue(of2, replacement, Stats.injury5));
				Stats.setValue(of, index, Stats.age, Stats.getValue(of2, replacement, Stats.age5));
				Stats.setValue(of, index, Stats.weight, Stats.getValue(of2, replacement, Stats.weight5));
				Stats.setValue(of, index, Stats.consistency, Stats.getValue(of2, replacement, Stats.consistency5));
				Stats.setValue(of, index, Stats.condition, Stats.getValue(of2, replacement, Stats.condition5));
				for (int i = 0; i < Stats.roles.length; i++) {
					Stats.setValue(of, index, Stats.roles[i], Stats.getValue(of2, replacement, Stats.roles5[i]));
				}
				for (int i = 0; i < Stats.ability99.length; i++) {
					Stats.setValue(of, index, Stats.ability99[i], Stats.getValue(of2, replacement, Stats.ability995[i]));
				}
				for (int i = 0; i < Stats.abilitySpecial.length; i++) {
					Stats.setValue(of, index, Stats.abilitySpecial[i], Stats.getValue(of2, replacement, Stats.abilitySpecial5[i]));
				}
				ra = Player.startAdr5 + (replacement * 124);
				if (replacement >= Player.firstEdit5) {
					ra = Player.startAdrE5 + ((replacement - Player.firstEdit5) * 124);
				}
				System.arraycopy(of2.data5, ra, of.data, ia, 48);
				Stats.setValue(of, index, Stats.abilityEdited, Stats.getValue(of2, replacement, Stats.abilityEdited5));
			}
			Stats.setValue(of, index, Stats.height, Stats.getValue(of2,
					replacement, Stats.height));
			Stats.setValue(of, index, Stats.foot, Stats.getValue(of2,
							replacement, Stats.foot));
			Stats.setValue(of, index, Stats.dribSty, Stats.getValue(of2,
					replacement, Stats.dribSty));
			Stats.setValue(of, index, Stats.pkStyle, Stats.getValue(of2,
					replacement, Stats.pkStyle));
			Stats.setValue(of, index, Stats.freekick, Stats.getValue(of2,
					replacement, Stats.freekick));
			Stats.setValue(of, index, Stats.dkSty, Stats.getValue(of2,
					replacement, Stats.dkSty));
			Stats.setValue(of, index, Stats.regPos, Stats.getValue(of2,
					replacement, Stats.regPos));
			if (!of2.version5) {
				Stats.setValue(of, index, Stats.age, Stats.getValue(of2,
						replacement, Stats.age));
				Stats.setValue(of, index, Stats.weight, Stats.getValue(of2,
						replacement, Stats.weight));
				Stats.setValue(of, index, Stats.favSide, Stats.getValue(of2,
						replacement, Stats.favSide));
				Stats.setValue(of, index, Stats.wfa, Stats.getValue(of2,
						replacement, Stats.wfa));
				Stats.setValue(of, index, Stats.wff, Stats.getValue(of2,
						replacement, Stats.wff));
				Stats.setValue(of, index, Stats.condition, Stats.getValue(of2,
						replacement, Stats.condition));
				Stats.setValue(of, index, Stats.consistency, Stats.getValue(of2,
						replacement, Stats.consistency));
				Stats.setValue(of, index, Stats.injury, Stats.getValue(of2,
						replacement, Stats.injury));
				for (int i = 0; i < Stats.roles.length; i++) {
					Stats.setValue(of, index, Stats.roles[i], Stats.getValue(of2,
							replacement, Stats.roles[i]));
				}
				for (int i = 0; i < Stats.ability99.length; i++) {
					Stats.setValue(of, index, Stats.ability99[i], Stats.getValue(
							of2, replacement, Stats.ability99[i]));
				}
				for (int i = 0; i < Stats.abilitySpecial.length; i++) {
					Stats.setValue(of, index, Stats.abilitySpecial[i], Stats
							.getValue(of2, replacement, Stats.abilitySpecial[i]));
				}
				Stats.setValue(of, index, Stats.abilityEdited, 1);
				Stats.setValue(of, index, Stats.nameEdited, 1);
				Stats.setValue(of, index, Stats.shirtEdited, 1);
			}
		} else {
			byte[] temp = new byte[124];
			if (of2.newVersion)
				System.arraycopy(of2.data, ra, temp, 0, 124);
			else if (of2.version13)
				System.arraycopy(of2.data13, ra, temp, 0, 124);
			else if (of2.version12)
				System.arraycopy(of2.data12, ra, temp, 0, 124);
			else if (of2.version11)
				System.arraycopy(of2.data11, ra, temp, 0, 124);
			/*else if (of2.version10)
				System.arraycopy(of2.data10, ra, temp, 0, 124);
			else if (of2.version09)
				System.arraycopy(of2.data09, ra, temp, 0, 124);
			else if (of2.version08)
				System.arraycopy(of2.data08, ra, temp, 0, 124);
			else if (of2.version6)
				System.arraycopy(of2.data6, ra, temp, 0, 124);
			else if (of2.version5)
				System.arraycopy(of2.data5, ra, temp, 0, 124);*/

			if (of2.newVersion)
				Stats.setValue(of2, replacement, Stats.nationality, Stats.getValue(
					of, index, Stats.nationality));
			else if (of2.version13) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation13.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation13[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} else if (of2.version12) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation12.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation12[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} else if (of2.version11) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation11.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation11[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} /*else if (of2.version10) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation10.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation10[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} else if (of2.version09) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation09.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation09[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} else if (of2.version08) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation08.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation08[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} else if (of2.version6) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation6.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation6[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			} else if (of2.version5) {
				int nat = 0;
				boolean found = false;
				for (int i = 0; i < Stats.nation5.length; i++) {
					if (!found && Stats.nation[Stats.getValue(of, index, Stats.nationality)].equals(Stats.nation5[i])) {
						found = true;
						nat = i;
					}
				}
				Stats.setValue(of2, replacement, Stats.nationality, nat);
			}*/
			Stats.setValue(of2, replacement, Stats.age, Stats.getValue(of,
					index, Stats.age));
			Stats.setValue(of2, replacement, Stats.callName, Stats.getValue(of,
					index, Stats.callName));
			Stats.setValue(of2, replacement, Stats.cel1, Stats.getValue(of,
					index, Stats.cel1));
			Stats.setValue(of2, replacement, Stats.faceType, Stats.getValue(of,
					index, Stats.faceType));
			Stats.setValue(of2, replacement, Stats.cel2, Stats.getValue(of,
					index, Stats.cel2));
			Stats.setValue(of2, replacement, Stats.SKIN, Stats.getValue(of,
					index, Stats.SKIN));
			Stats.setValue(of2, replacement, Stats.hair, Stats.getValue(of,
					index, Stats.hair));
			Stats.setValue(of2, replacement, Stats.FACE_TYPE, Stats.getValue(of,
					index, Stats.FACE_TYPE));
			Stats.setValue(of2, replacement, Stats.height, Stats.getValue(of,
					index, Stats.height));
			Stats.setValue(of2, replacement, Stats.weight, Stats.getValue(of,
					index, Stats.weight));
			Stats.setValue(of2, replacement, Stats.foot, Stats.getValue(of,
					index, Stats.foot));
			Stats.setValue(of2, replacement, Stats.favSide, Stats.getValue(of,
					index, Stats.favSide));
			Stats.setValue(of2, replacement, Stats.wfa, Stats.getValue(of,
					index, Stats.wfa));
			Stats.setValue(of2, replacement, Stats.wff, Stats.getValue(of,
					index, Stats.wff));
			Stats.setValue(of2, replacement, Stats.condition, Stats.getValue(
					of, index, Stats.condition));
			Stats.setValue(of2, replacement, Stats.consistency, Stats.getValue(
					of, index, Stats.consistency));
			Stats.setValue(of2, replacement, Stats.injury, Stats.getValue(of,
					index, Stats.injury));
			Stats.setValue(of2, replacement, Stats.SH2, Stats.getValue(of,
					index, Stats.SH2));
			Stats.setValue(of2, replacement, Stats.dribSty, Stats.getValue(of,
					index, Stats.dribSty));
			Stats.setValue(of2, replacement, Stats.pkStyle, Stats.getValue(of,
					index, Stats.pkStyle));
			Stats.setValue(of2, replacement, Stats.freekick, Stats.getValue(of,
					index, Stats.freekick));
			Stats.setValue(of2, replacement, Stats.dkSty, Stats.getValue(of,
					index, Stats.dkSty));
			Stats.setValue(of2, replacement, Stats.regPos, Stats.getValue(of,
					index, Stats.regPos));

			for (int i = 0; i < Stats.roles.length; i++) {
				Stats.setValue(of2, replacement, Stats.roles[i], Stats
						.getValue(of, index, Stats.roles[i]));
			}
			for (int i = 0; i < Stats.ability99.length; i++) {
				Stats.setValue(of2, replacement, Stats.ability99[i], Stats
						.getValue(of, index, Stats.ability99[i]));
			}
			for (int i = 0; i < Stats.abilitySpecial.length; i++) {
				Stats.setValue(of2, replacement, Stats.abilitySpecial[i], Stats
						.getValue(of, index, Stats.abilitySpecial[i]));
			}

			if (of2.newVersion)
				System.arraycopy(of2.data, ra, of.data, ia, 124);
			else if (of2.version13)
				System.arraycopy(of2.data13, ra, of.data, ia, 124);
			else if (of2.version12)
				System.arraycopy(of2.data12, ra, of.data, ia, 124);
			else if (of2.version11)
				System.arraycopy(of2.data11, ra, of.data, ia, 124);
			/*else if (of2.version10)
				System.arraycopy(of2.data10, ra, of.data, ia, 124);
			else if (of2.version09)
				System.arraycopy(of2.data09, ra, of.data, ia, 124);
			else if (of2.version08)
				System.arraycopy(of2.data08, ra, of.data, ia, 124);
			else if (of2.version6)
				System.arraycopy(of2.data6, ra, of.data, ia, 124);
			else if (of2.version5)
				System.arraycopy(of2.data5, ra, of.data, ia, 124);*/
			Stats.setValue(of, index, Stats.nameEdited, 1);
			Stats.setValue(of, index, Stats.callEdited, 1);
			Stats.setValue(of, index, Stats.shirtEdited, 1);
			/*
			 * if (!of.isWE() && of2.isWE()) { Convert.player(of, index,
			 * Convert.WE2007_PES6); } if (of.isWE() && !of2.isWE()) {
			 * Convert.player(of, index, Convert.PES6_WE2007); }
			 */

			if (of2.newVersion)
				System.arraycopy(temp, 0, of2.data, ra, 124);
			else if (of2.version13)
				System.arraycopy(temp, 0, of2.data13, ra, 124);
			else if (of2.version12)
				System.arraycopy(temp, 0, of2.data12, ra, 124);
			else if (of2.version11)
				System.arraycopy(temp, 0, of2.data11, ra, 124);
			/*else if (of2.version10)
				System.arraycopy(temp, 0, of2.data10, ra, 124);
			else if (of2.version09)
				System.arraycopy(temp, 0, of2.data09, ra, 124);
			else if (of2.version08)
				System.arraycopy(temp, 0, of2.data08, ra, 124);
			else if (of2.version6)
				System.arraycopy(temp, 0, of2.data6, ra, 124);
			else if (of2.version5)
				System.arraycopy(temp, 0, of2.data5, ra, 124);*/
		}
	}
}
