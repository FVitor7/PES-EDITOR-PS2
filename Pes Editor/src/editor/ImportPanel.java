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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImportPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel importFile;

	JPanel panel;

	private OptionFile of;

	private OptionFile of2;

	private JButton optionsButton;

	private JButton stadiumButton;

	private JButton leagueButton;

	private JButton bootsButton;

	private JButton clubNameButton;

	private JButton playerButton;

	private JButton allKitButton;

	private WENShopPanel wenShop;

	private StadiumPanel stadPan;

	private LeaguePanel leaguePan;

	private TeamPanel teamPan;

	EmblemPanel flagPan;

	LogoPanel imagePan;

	private TransferPanel tranPan;

	public ImportPanel(OptionFile opf, OptionFile opf2, WENShopPanel w,
			StadiumPanel s, LeaguePanel l, TeamPanel t, EmblemPanel fp,
			LogoPanel ip, TransferPanel tp) {// , Stats s1, Stats s2) {
		super(new BorderLayout());
		of = opf;
		of2 = opf2;
		wenShop = w;
		stadPan = s;
		leaguePan = l;
		teamPan = t;
		flagPan = fp;
		imagePan = ip;
		tranPan = tp;

		JPanel butPan = new JPanel(new GridLayout(0, 1));
		importFile = new JLabel(
				"To use the import options you must first use File > Open OF2 or 5/6/08/09/10/11/12/13 OF...");
		panel = new JPanel();
		optionsButton = new JButton(
				"Options / PES Points / Shop Items / Cup Gallery / Track Record / Playlist");
		optionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (of2.newVersion) {
					System.arraycopy(of2.data, OptionFile.block[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data, OptionFile.block[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data, OptionFile.block[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data, OptionFile.block[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version13) {
					System.arraycopy(of2.data13, OptionFile.block13[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data13, OptionFile.block13[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data13, OptionFile.block13[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data13, OptionFile.block13[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version12) {
					System.arraycopy(of2.data12, OptionFile.block12[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data12, OptionFile.block12[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data12, OptionFile.block12[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data12, OptionFile.block12[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version11) {
					System.arraycopy(of2.data11, OptionFile.block11[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data11, OptionFile.block11[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data11, OptionFile.block11[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data11, OptionFile.block11[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version10) {
					System.arraycopy(of2.data10, OptionFile.block10[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data10, OptionFile.block10[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data10, OptionFile.block10[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data10, OptionFile.block10[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version09) {
					System.arraycopy(of2.data09, OptionFile.block09[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data09, OptionFile.block09[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data09, OptionFile.block09[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data09, OptionFile.block09[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version08) {
					System.arraycopy(of2.data08, OptionFile.block08[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data08, OptionFile.block08[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data08, OptionFile.block08[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data08, OptionFile.block08[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version6) {
					System.arraycopy(of2.data6, OptionFile.block6[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data6, OptionFile.block6[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data6, OptionFile.block6[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data6, OptionFile.block6[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				} else if (of2.version5) {
					System.arraycopy(of2.data5, OptionFile.block5[0], of.data,
							OptionFile.block[0], OptionFile.blockSize[0]);
					System.arraycopy(of2.data5, OptionFile.block5[1], of.data,
							OptionFile.block[1], OptionFile.blockSize[1]);
					System.arraycopy(of2.data5, OptionFile.block5[9], of.data,
							OptionFile.block[9], OptionFile.blockSize[9]);
					System.arraycopy(of2.data5, OptionFile.block5[10], of.data,
							OptionFile.block[10], OptionFile.blockSize[10]);
				}
				wenShop.wenPanel.refresh();
				wenShop.shopPanel.status.setText("");
				optionsButton.setEnabled(false);
			}
		});
		stadiumButton = new JButton("Stadium names");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Stadia.importData(of2, of);
				stadPan.refresh();
				teamPan.refresh();
				stadiumButton.setEnabled(false);
			}
		});
		leagueButton = new JButton("League names");
		leagueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Leagues.importData(of2, of);
				leaguePan.refresh();
				leagueButton.setEnabled(false);
			}
		});
		bootsButton = new JButton("Boots");
		bootsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//System.arraycopy(of2.data, 654732, of.data, 654732, 828);
				if (of2.newVersion)
					System.arraycopy(of2.data, 639792, of.data, 639792, 828); //offset
				else if (of2.version13)
					System.arraycopy(of2.data13, 648720, of.data, 639792, 828);
				else if (of2.version12)
					System.arraycopy(of2.data12, 653868, of.data, 639792, 828);
				else if (of2.version11)
					System.arraycopy(of2.data11, 663912, of.data, 639792, 828);
				else if (of2.version10)
					System.arraycopy(of2.data10, 658824, of.data, 639792, 828);
				else if (of2.version09)
					System.arraycopy(of2.data09, 654732, of.data, 639792, 828);
				else if (of2.version08)
					System.arraycopy(of2.data08, 664624, of.data, 639792, 828);
				else if (of2.version6)
					System.arraycopy(of2.data6, 657116, of.data, 639792, 828);
				else if (of2.version5)
					System.arraycopy(of2.data5, 656872, of.data, 639792, 828);
				bootsButton.setEnabled(false);
			}
		});

		playerButton = new JButton("Players / Squads / Formations");
		playerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (of2.newVersion) {
					System.arraycopy(of2.data, OptionFile.block[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data, OptionFile.block[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data, OptionFile.block[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version13) {
					System.arraycopy(of2.data13, OptionFile.block13[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data13, OptionFile.block13[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data13, OptionFile.block13[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version12) {
					System.arraycopy(of2.data12, OptionFile.block12[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data12, OptionFile.block12[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data12, OptionFile.block12[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version11) {
					System.arraycopy(of2.data11, OptionFile.block11[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data11, OptionFile.block11[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data11, OptionFile.block11[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version10) {
					System.arraycopy(of2.data10, OptionFile.block10[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data10, OptionFile.block10[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data10, OptionFile.block10[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version09) {
					System.arraycopy(of2.data09, OptionFile.block09[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data09, OptionFile.block09[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data09, OptionFile.block09[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version08) {
					System.arraycopy(of2.data08, OptionFile.block08[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data08, OptionFile.block08[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data08, OptionFile.block08[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version6) {
					System.arraycopy(of2.data6, OptionFile.block6[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data6, OptionFile.block6[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data6, OptionFile.block6[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				} else if (of2.version5) {
					System.arraycopy(of2.data5, OptionFile.block5[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data5, OptionFile.block5[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data5, OptionFile.block5[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
				}

				/*
				 * if (!of.isWE() && of2.isWE()) { Convert.allPlayers(of,
				 * Convert.WE2007_PES6); } if (of.isWE() && !of2.isWE()) {
				 * Convert.allPlayers(of, Convert.PES6_WE2007); }
				 */

				tranPan.refresh();
				playerButton.setEnabled(false);
			}
		});

		clubNameButton = new JButton("Club names");
		clubNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Clubs.importNames(of, of2);
				teamPan.refresh();
				tranPan.refresh();
				clubNameButton.setEnabled(false);
			}
		});

		allKitButton = new JButton(
				"Kits / Emblems / Logos / Club stadiums, flags, colours");
		allKitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Clubs.importData(of, of2);
				if (of2.newVersion) {
					System.arraycopy(of2.data, OptionFile.block[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data, OptionFile.block[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version13) {
					System.arraycopy(of2.data13, OptionFile.block13[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data13, OptionFile.block13[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version12) {
					System.arraycopy(of2.data12, OptionFile.block12[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data12, OptionFile.block12[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version11) {
					System.arraycopy(of2.data11, OptionFile.block11[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data11, OptionFile.block11[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version10) {
					System.arraycopy(of2.data10, OptionFile.block10[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data10, OptionFile.block10[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version09) {
					System.arraycopy(of2.data09, OptionFile.block09[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data09, OptionFile.block09[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version08) {
					System.arraycopy(of2.data08, OptionFile.block08[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data08, OptionFile.block08[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version6) {
					System.arraycopy(of2.data6, OptionFile.block6[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data6, OptionFile.block6[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				} else if (of2.version5) {
					System.arraycopy(of2.data5, OptionFile.block5[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data5, OptionFile.block5[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
				}

				/*
				 * if (!of.isWE() && of2.isWE()) { Convert.allKitModel(of); }
				 */

				flagPan.refresh();
				imagePan.refresh();
				teamPan.refresh();
				tranPan.refresh();
				allKitButton.setEnabled(false);
			}
		});

		butPan.add(optionsButton);
		butPan.add(stadiumButton);
		butPan.add(leagueButton);
		butPan.add(bootsButton);
		butPan.add(playerButton);
		butPan.add(clubNameButton);

		butPan.add(allKitButton);
		panel.add(butPan);
		add(importFile, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		panel.setEnabled(false);
	}

	public void refresh() {
		if (of2.fileName == null) {
			panel.setVisible(false);
			importFile
					.setText("To use the import options you must first use File > Open OF2 or 5/6/08/09/10/11/12/13 OF...");
		} else {
			if (of2.newVersion)
				importFile.setText("From:  " + of2.fileName);
			else if (of2.version13)
				importFile.setText("From PES2013 OF:  " + of2.fileName); //version
			else if (of2.version12)
				importFile.setText("From PES2012 OF:  " + of2.fileName); //version
			else if (of2.version11)
				importFile.setText("From PES2011 OF:  " + of2.fileName); //version
			else if (of2.version10)
				importFile.setText("From PES2010 OF:  " + of2.fileName); //version
			else if (of2.version09)
				importFile.setText("From PES2009 OF:  " + of2.fileName); //version
			else if (of2.version08)
				importFile.setText("From PES2008 OF:  " + of2.fileName); //version
			else if (of2.version6)
				importFile.setText("From PES6 OF:  " + of2.fileName); //version
			else if (of2.version5)
				importFile.setText("From PES5 OF:  " + of2.fileName); //version
			panel.setVisible(true);
			if (of.gameID.equals(of2.gameID)) {
				optionsButton.setEnabled(true);
			} else {
				optionsButton.setEnabled(false);
			}
			stadiumButton.setEnabled(true);
			leagueButton.setEnabled(true);
			bootsButton.setEnabled(true);
			clubNameButton.setEnabled(true);
			if (of2.version12 || of2.version11 || of2.version10 || of2.version09 || of2.version08 || of2.version6 || of2.version5)
				playerButton.setEnabled(false);
			else
				playerButton.setEnabled(true);
			if (of2.version12 || of2.version11 || of2.version10 || of2.version09 || of2.version08 || of2.version6 || of2.version5)
				allKitButton.setEnabled(false);
			else
				allKitButton.setEnabled(true);
		}
	}

	public void disableAll() {
		optionsButton.setEnabled(false);
		stadiumButton.setEnabled(false);
		leagueButton.setEnabled(false);
		bootsButton.setEnabled(false);
		clubNameButton.setEnabled(false);
		playerButton.setEnabled(false);
		allKitButton.setEnabled(false);
	}

}
