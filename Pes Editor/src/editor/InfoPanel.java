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

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class InfoPanel extends JScrollPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OptionFile of;

	JEditorPane ta;

	SelectByTeam selector;

	boolean listSquads;

	SimpleAttributeSet attr;

	Document doc;

	public InfoPanel(SelectByTeam sbt, OptionFile opf) {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
		selector = sbt;
		of = opf;
		listSquads = true;
		init();
	}

	public InfoPanel(OptionFile opf) {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
		of = opf;
		listSquads = false;
		init();
	}

	private void init() {
		// setBorder(BorderFactory.createTitledBorder("Player info"));
		ta = new JEditorPane();
		ta.setEditable(false);
		setViewportView(ta);
		// add(scroll);
		// ta.setFont(new Font("SansSerif", Font.PLAIN, 10));
		StyledEditorKit sek = new StyledEditorKit();
		ta.setEditorKit(sek);
		ta.setBackground(Color.black);
		attr = new SimpleAttributeSet(sek.getInputAttributes());
		doc = ta.getDocument();
		if (listSquads) {
			setPreferredSize(new Dimension(290, 493));
		} else {
			setPreferredSize(new Dimension(145, 493));
		}
		// ta.setVisible(false);
		// StyleConstants.setFontSize(attr, 10);
		StyleConstants.setFontFamily(attr, "SansSerif");
	}

	public void refresh(int index1, int index2) {
		// System.out.println(index1 + ", " + index2);
		ta.setText("");
		if (index1 > 0 || index2 > 0) {
			try {
				if (index2 > 0) {
					StyleConstants.setFontSize(attr, 10);
					insertName(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertFace(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertHair(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertRole(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertPhys(index1, index2);
					insertStats(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertAbilities(index1, index2);
				} else {
					StyleConstants.setFontSize(attr, 12);
					insertName(index1, index2);
					doc.insertString(doc.getLength(), "\n\n", attr);
					insertFace(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertHair(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertAgeNat(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertPhys(index1, index2);
					doc.insertString(doc.getLength(), "\n", attr);
					insertRole(index1, index2);
					// doc.insertString(doc.getLength(),
					// stats.favSide.getString(index1), attr);
					doc.insertString(doc.getLength(), "\n\n", attr);
					insertSquads(index1);
					//doc.insertString(doc.getLength(), "\n\nBytes:\n", attr);
					//insertBytes(index1);
				}

			} catch (BadLocationException e) {
			}
			ta.setCaretPosition(0);
		}
		// ta.setVisible(true);
	}

	private void insertStats(int index1, int index2)
			throws BadLocationException {
		StyleConstants.setForeground(attr, Color.white);
		if (!of.version5)
			insertStat(Stats.wfa, index1, index2);
		else
			insertStat(Stats.wfa5, index1, index2);
		if (!of.version5)
			insertStat(Stats.wff, index1, index2);
		else
			insertStat(Stats.wff5, index1, index2);
		// insertStat(stats.statX, index1, index2);
		if (!of.version5) {
			for (int i = 0; i < Stats.ability99.length; i++) {
				insertStat(Stats.ability99[i], index1, index2);
			}
		} else {
			for (int i = 0; i < Stats.ability995.length; i++) {
				insertStat(Stats.ability995[i], index1, index2);
			}
		}
		if (!of.version5)
			insertStat(Stats.consistency, index1, index2);
		else
			insertStat(Stats.consistency5, index1, index2);
		if (!of.version5)
			insertStat(Stats.condition, index1, index2);
		else
			insertStat(Stats.condition5, index1, index2);

	}

	private void insertRole(int index1, int index2) throws BadLocationException {
		String text = "";
		if (!of.version5) {
			if (index1 > 0 && Stats.getValue(of, index1, Stats.gk) == 1) {
				text = "GK";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.gk) == 1) {
				text = text + "\t\tGK";
			}
			text = text + "\n";
	
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cwp) == 1) {
				text = text + "SW  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cbt) == 1) {
				text = text + "CB  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cwp) == 1) {
				text = text + "SW  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cbt) == 1) {
				text = text + "CB  ";
			}
			text = text + "\n";
	
			if (index1 > 0 && Stats.getValue(of, index1, Stats.sb) == 1) {
				text = text + "SB  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.wb) == 1) {
				text = text + "WB  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.dm) == 1) {
				text = text + "DMF  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
	
			if (index2 > 0 && Stats.getValue(of, index2, Stats.sb) == 1) {
				text = text + "SB  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.wb) == 1) {
				text = text + "WB  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.dm) == 1) {
				text = text + "DMF  ";
			}
			text = text + "\n";
	
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cm) == 1) {
				text = text + "CMF  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.sm) == 1) {
				text = text + "SMF  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.am) == 1) {
				text = text + "AMF  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
	
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cm) == 1) {
				text = text + "CMF  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.sm) == 1) {
				text = text + "SMF  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.am) == 1) {
				text = text + "AMF  ";
			}
	
			text = text + "\n";
			if (index1 > 0 && Stats.getValue(of, index1, Stats.ss) == 1) {
				text = text + "SS  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cf) == 1) {
				text = text + "CF  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.wg) == 1) {
				text = text + "WG  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.ss) == 1) {
				text = text + "SS  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cf) == 1) {
				text = text + "CF  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.wg) == 1) {
				text = text + "WG  ";
			}
		} else {
			if (index1 > 0 && Stats.getValue(of, index1, Stats.gk5) == 1) {
				text = "GK";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.gk5) == 1) {
				text = text + "\t\tGK";
			}
			text = text + "\n";
	
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cwp5) == 1) {
				text = text + "SW  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cbt5) == 1) {
				text = text + "CB  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cwp5) == 1) {
				text = text + "SW  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cbt5) == 1) {
				text = text + "CB  ";
			}
			text = text + "\n";
	
			if (index1 > 0 && Stats.getValue(of, index1, Stats.sb5) == 1) {
				text = text + "SB  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.wb5) == 1) {
				text = text + "WB  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.dm5) == 1) {
				text = text + "DMF  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
	
			if (index2 > 0 && Stats.getValue(of, index2, Stats.sb5) == 1) {
				text = text + "SB  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.wb5) == 1) {
				text = text + "WB  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.dm5) == 1) {
				text = text + "DMF  ";
			}
			text = text + "\n";
	
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cm5) == 1) {
				text = text + "CMF  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.sm5) == 1) {
				text = text + "SMF  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.am5) == 1) {
				text = text + "AMF  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
	
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cm5) == 1) {
				text = text + "CMF  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.sm5) == 1) {
				text = text + "SMF  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.am5) == 1) {
				text = text + "AMF  ";
			}
	
			text = text + "\n";
			if (index1 > 0 && Stats.getValue(of, index1, Stats.ss5) == 1) {
				text = text + "SS  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.cf5) == 1) {
				text = text + "CF  ";
			}
			if (index1 > 0 && Stats.getValue(of, index1, Stats.wg5) == 1) {
				text = text + "WG  ";
			}
			if (index2 > 0) {
				text = text + "\t\t";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.ss5) == 1) {
				text = text + "SS  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.cf5) == 1) {
				text = text + "CF  ";
			}
			if (index2 > 0 && Stats.getValue(of, index2, Stats.wg5) == 1) {
				text = text + "WG  ";
			}
		}
		if (index2 > 0) {
			StyleConstants.setFontSize(attr, 9);
		}
		doc.insertString(doc.getLength(), text, attr);
		if (index2 > 0) {
			StyleConstants.setFontSize(attr, 10);
		}
	}

	private void insertAbilities(int index1, int index2)
			throws BadLocationException {
		if (!of.version5) {
			for (int i = 0; i < Stats.abilitySpecial.length; i++) {
				if ((i & 1) == 1) {
					insertAbility(Stats.abilitySpecial[i], index1, index2,
							Color.red);
				} else {
					insertAbility(Stats.abilitySpecial[i], index1, index2,
							Color.green);
				}
			}
		} else {
			for (int i = 0; i < Stats.abilitySpecial5.length; i++) {
				if ((i & 1) == 1) {
					insertAbility(Stats.abilitySpecial5[i], index1, index2,
							Color.red);
				} else {
					insertAbility(Stats.abilitySpecial5[i], index1, index2,
							Color.green);
				}
			}
		}
		// StyleConstants.setForeground(attr, Color.yellow);
		StyleConstants.setForeground(attr, Color.white);
	}

	private void insertSquads(int index1) throws BadLocationException {
		if (listSquads) {
			StyleConstants.setForeground(attr, Color.white);
			int i;
			int t;
			int a;
			doc.insertString(doc.getLength(), "Squads:", attr);
			a = Squads.slot23 - 2;
			do {
				a = a + 2;
				i = (of.toInt(of.data[a + 1]) << 8) | of.toInt(of.data[a]);
				if (i == index1) {
					// System.out.println(a);

					t = 0;
					if (of.version08) {
						if (a < Squads.slot32) {
							if (a >= Squads.slot32 - 64) {
								t = 72; //squadnumber
							} else {
								t = (a - Squads.slot23) / 46;
							}
						} else {
							t = ((a - Squads.slot32) / 64) + 73; //squadnumber
						}
					} else if (of.version6) {
						if (a < Squads.slot32) {
							if (a >= Squads.slot32 - 64) {
								t = 72; //squadnumber
							} else {
								t = (a - Squads.slot23) / 46;
							}
						} else {
							t = ((a - Squads.slot32) / 64) + 73; //squadnumber
						}
					} else if (of.version5) {
						if (a < Squads.slot32) {
							if (a >= Squads.slot32 - 64) {
								t = 72; //squadnumber
							} else {
								t = (a - Squads.slot23) / 46;
							}
						} else {
							t = ((a - Squads.slot32) / 64) + 73; //squadnumber
						}
					} else {
						if (a < Squads.slot32) {
							if (a >= Squads.slot32 - 64) {
								t = 74; //squadnumber
							} else {
								t = (a - Squads.slot23) / 46;
							}
						} else {
							t = ((a - Squads.slot32) / 64) + 75; //squadnumber
						}
					}
					// System.out.println(t);
					doc
							.insertString(doc.getLength(), "\n"
									+ selector.teamBox.getModel().getElementAt(
											t), attr);
				}
			} while (a < Formations.startAdr -128 -2); // && i != p);
		}
	}

	/*private void insertBytes(int index1) throws BadLocationException {
		StyleConstants.setForeground(attr, Color.white);
		if (index1 > 0) {
			StringBuilder sb = new StringBuilder(); for (byte b : new Player(of, index1, 0).bytes) { sb.append(String.format("%02X", b)); }
			String str = sb.toString().replaceAll("....", "$0 ");
			doc.insertString(doc.getLength(), str,
						attr);
		}
	}*/

	private void insertName(int index1, int index2) throws BadLocationException {
		StyleConstants.setForeground(attr, Color.white);
		if (index1 > 0) {
			doc.insertString(doc.getLength(), new Player(of, index1, 0).name + " [ID: " + new Player(of, index1, 0).index + "]",
					attr);
		}
		if (index2 > 0) {
			doc.insertString(doc.getLength(), "\t"
					+ new Player(of, index2, 0).name + " [ID: " + new Player(of, index2, 0).index + "]", attr);
		}
	}

	 private void insertFace(int paramInt1, int paramInt2)
			    throws BadLocationException
			  {
			    StyleConstants.setForeground(this.attr, Color.GREEN);
			    if (paramInt1 > 0) {
			      doc.insertString(doc.getLength(), "Face: " + Stats.getString(of, paramInt1, Stats.FACE_TYPE), attr);
			    }
			    if (paramInt2 > 0) {
			      doc.insertString(doc.getLength(), "\tFace: " + Stats.getString(of, paramInt2, Stats.FACE_TYPE), attr);
			    }
			  }
	
	 private void insertHair(int paramInt1, int paramInt2)
			    throws BadLocationException
			  {
			    StyleConstants.setForeground(this.attr, Color.GREEN);
			    if (paramInt1 > 0) {
			      doc.insertString(doc.getLength(), "Hair: " + Stats.getString(of, paramInt1, Stats.hair), attr);
			    }
			    if (paramInt2 > 0) {
			      doc.insertString(doc.getLength(), "\tHair: " + Stats.getString(of, paramInt2, Stats.hair), this.attr);
			    }
			  }
	 
	private void insertAgeNat(int index1, int index2)
			throws BadLocationException {
		StyleConstants.setForeground(attr, Color.white);
		if (!of.version5) {
			if (index1 > 0) {
				doc.insertString(doc.getLength(), Stats.getString(of, index1,
						Stats.nationality), attr);
			}
		} else {
			if (index1 > 0) {
				doc.insertString(doc.getLength(), Stats.getString(of, index1,
						Stats.nationality5), attr);
			}
		}
		if (!of.version5) {
			if (index2 > 0) {
				doc.insertString(doc.getLength(), "\t"
						+ Stats.getString(of, index2, Stats.nationality), attr);
			}
		} else {
			if (index2 > 0) {
				doc.insertString(doc.getLength(), "\t"
						+ Stats.getString(of, index2, Stats.nationality5), attr);
			}
		}
		if (!of.version5) {
			if (index1 > 0) {
				doc.insertString(doc.getLength(), "\nAge: "
						+ Stats.getString(of, index1, Stats.age)/* + ", growth: " + Stats.getString(of, index1, Stats.growth)*/, attr);
			}
		} else {
			if (index1 > 0) {
				doc.insertString(doc.getLength(), "\nAge: "
						+ Stats.getString(of, index1, Stats.age5), attr);
			}
		}
		if (!of.version5) {
			if (index2 > 0) {
				doc.insertString(doc.getLength(), "\tAge: "
						+ Stats.getString(of, index2, Stats.age)/* + ", growth: " + Stats.getString(of, index2, Stats.growth)*/, attr);
			}
		} else {
			if (index2 > 0) {
				doc.insertString(doc.getLength(), "\tAge: "
						+ Stats.getString(of, index2, Stats.age5), attr);
			}
		}
	}

	private void insertPhys(int index1, int index2) throws BadLocationException {
		StyleConstants.setForeground(attr, Color.white);
		if (index1 > 0) {
			String footSide = "LF/";
			if (Stats.getValue(of, index1, Stats.foot) == 1) {
				switch (Stats.getValue(of, index1, Stats.favSide)) {
				case 0:
					footSide = footSide + "LS";
					break;
				case 1:
					footSide = footSide + "RS";
					break;
				case 2:
					footSide = footSide + "BS";
					break;
				}
			} else {
				footSide = "RF/";
				switch (Stats.getValue(of, index1, Stats.favSide)) {
				case 0:
					footSide = footSide + "RS";
					break;
				case 1:
					footSide = footSide + "LS";
					break;
				case 2:
					footSide = footSide + "BS";
					break;
				}
			}
			footSide = footSide + ", ";
			doc.insertString(doc.getLength(), footSide
					+ Stats.getString(of, index1, Stats.height) + "cm, "
					+ Stats.getString(of, index1, Stats.weight) + "Kg", attr);
		}
		if (index2 > 0) {
			if (index1 > 0) {
				doc.insertString(doc.getLength(), "\t", attr);
			} else {
				doc.insertString(doc.getLength(), "\t\t", attr);
			}
			String footSide = "LF/";
			if (Stats.getValue(of, index2, Stats.foot) == 1) {
				switch (Stats.getValue(of, index2, Stats.favSide)) {
				case 0:
					footSide = footSide + "LS";
					break;
				case 1:
					footSide = footSide + "RS";
					break;
				case 2:
					footSide = footSide + "BS";
					break;
				}
			} else {
				footSide = "RF/";
				switch (Stats.getValue(of, index2, Stats.favSide)) {
				case 0:
					footSide = footSide + "RS";
					break;
				case 1:
					footSide = footSide + "LS";
					break;
				case 2:
					footSide = footSide + "BS";
					break;
				}
			}
			footSide = footSide + ", ";
			doc.insertString(doc.getLength(), footSide
					+ Stats.getString(of, index2, Stats.height) + "cm, "
					+ Stats.getString(of, index2, Stats.weight) + "Kg", attr);
		}
	}

	private void insertStat(Stat stat, int index1, int index2)
			throws BadLocationException {
		int v1 = Stats.getValue(of, index1, stat);
		int v2 = Stats.getValue(of, index2, stat);
		String s1 = Stats.getString(of, index1, stat);
		String s2 = Stats.getString(of, index2, stat);
		doc.insertString(doc.getLength(), "\n" + stat.name + "\t", attr);
		if (index1 > 0) {
			setStatColour(stat, v1);
			doc.insertString(doc.getLength(), s1, attr);
		}
		if (index2 > 0) {
			if (index1 > 0) {
				int dif = v1 - v2;
				String comp = " ";
				int div = 3;
				int add = 1;
				if (!of.version5) {
					if (stat == Stats.wfa || stat == Stats.wff
							|| stat == Stats.consistency || stat == Stats.condition) {
						div = 1;
						add = 0;
					}
				} else {
					if (stat == Stats.wfa || stat == Stats.wff
							|| stat == Stats.consistency5 || stat == Stats.condition5) {
						div = 1;
						add = 0;
					}
				}
				if (dif > 0) {
					dif = (dif / div) + add;
					for (int i = 0; i < dif && i < 10; i++) {
						comp = comp + "*";
					}
					StyleConstants.setForeground(attr, Color.green);
					doc.insertString(doc.getLength(), comp, attr);
				}
				if (dif < 0) {
					dif = (dif / -div) + add;
					for (int i = 0; i < dif && i < 10; i++) {
						comp = comp + "*";
					}
					StyleConstants.setForeground(attr, Color.red);
					doc.insertString(doc.getLength(), comp, attr);
				}
			}
			StyleConstants.setForeground(attr, Color.white);
			setStatColour(stat, v2);
			doc.insertString(doc.getLength(), "\t" + s2, attr);
		}
		StyleConstants.setForeground(attr, Color.white);
	}

	private void insertAbility(Stat stat, int index1, int index2, Color colour)
			throws BadLocationException {
		StyleConstants.setForeground(attr, colour);
		doc.insertString(doc.getLength(), "\n" + stat.name + "\t", attr);
		if (index1 > 0 && Stats.getValue(of, index1, stat) == 1) {
			doc.insertString(doc.getLength(), "O", attr);
		}
		if (index2 > 0 && Stats.getValue(of, index2, stat) == 1) {
			doc.insertString(doc.getLength(), "\tO", attr);
		}
	}

	private void setStatColour(Stat stat, int v) {
		if (!of.version5) {
			if (stat == Stats.wfa || stat == Stats.wff || stat == Stats.consistency
					|| stat == Stats.condition) {
				if (v == 7) {
					StyleConstants.setForeground(attr, Color.red);
				} else if (v == 6) {
					StyleConstants.setForeground(attr, Color.orange);
				}
			} else {
				if (v > 94) {
					StyleConstants.setForeground(attr, Color.red);
				} else if (v > 89) {
					StyleConstants.setForeground(attr, Color.orange);
				} else if (v > 79) {
					StyleConstants.setForeground(attr, Color.yellow);
				} else if (v > 74) {
					StyleConstants.setForeground(attr, new Color(183, 255, 0));
				}
			}
		} else {
			if (stat == Stats.wfa5 || stat == Stats.wff5 || stat == Stats.consistency5
					|| stat == Stats.condition5) {
				if (v == 7) {
					StyleConstants.setForeground(attr, Color.red);
				} else if (v == 6) {
					StyleConstants.setForeground(attr, Color.orange);
				}
			} else {
				if (v > 94) {
					StyleConstants.setForeground(attr, Color.red);
				} else if (v > 89) {
					StyleConstants.setForeground(attr, Color.orange);
				} else if (v > 79) {
					StyleConstants.setForeground(attr, Color.yellow);
				} else if (v > 74) {
					StyleConstants.setForeground(attr, new Color(183, 255, 0));
				}
			}
		}
	}

}
