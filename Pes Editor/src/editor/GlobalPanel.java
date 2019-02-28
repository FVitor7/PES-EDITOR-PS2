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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class GlobalPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField numField;

	private JComboBox statBox;

	private JComboBox opBox;

	private JButton doButton;

	private JButton lowercase;

	private JButton uppercase;

	private JButton lowercaseDb;

	private JButton uppercaseDb;

	private JButton lowercaseDb2;

	private JButton uppercaseDb2;

	private JComboBox scopeBox;

	private String[] statNames = { "1-99 Stats", "ATTACK", "DEFENSE",
			"BALANCE", "STAMINA", "TOP SPEED", "ACCELERATION", "RESPONSE",
			"AGILITY", "DRIBBLE ACCURACY", "DRIBBLE SPEED",
			"SHORT PASS ACCURACY", "SHORT PASS SPEED", "LONG PASS ACCURACY",
			"LONG PASS SPEED", "SHOT ACCURACY", "SHOT POWER", "SHOT TECHNIQUE",
			"FREE KICK ACCURACY", "CURLING", "HEADING", "JUMP", "TECHNIQUE",
			"AGGRESSION", "MENTALITY", "GOAL KEEPING", "TEAM WORK",
			"1-8 Stats", "WEAK FOOT ACCURACY", "WEAK FOOT FREQUENCY",
			"CONSISTENCY", "CONDITION / FITNESS", "AGE" };

	private String[] ops = { "+", "-", "=", "+ %", "- %" };

	private String[] scopes = { "All Players", "GK", "SW", "CB", "SB", "DMF",
			"WB", "CMF", "SMF", "AMF", "WG", "SS", "CF" };

	private JComboBox teamBox;

	private OptionFile of;

	private JCheckBox checkBox;

	private TransferPanel tranPanel;

	byte[] dbIn;

	public GlobalPanel(OptionFile of1, TransferPanel tp) {
		super();
		of = of1;
		tranPanel = tp;
		statBox = new JComboBox(statNames);
		numField = new JTextField(2);
		opBox = new JComboBox(ops);
		JPanel panel99 = new JPanel();
		JPanel scopePanel = new JPanel(new GridLayout(2, 3));
		JPanel names = new JPanel();
		JPanel namesDb = new JPanel();
		JPanel namesDb2 = new JPanel();
		JPanel main = new JPanel(new GridLayout(0, 1));
		scopePanel.setBorder(BorderFactory.createTitledBorder("Scope"));
		panel99.setBorder(BorderFactory.createTitledBorder("Adjustment"));
		names.setBorder(BorderFactory.createTitledBorder("Names"));
		namesDb.setBorder(BorderFactory.createTitledBorder("unknow_00053.bin_000 Names"));
		namesDb2.setBorder(BorderFactory.createTitledBorder("unknow_00055.bin_000 Names"));
		scopeBox = new JComboBox(scopes);
		teamBox = new JComboBox();
		checkBox = new JCheckBox();

		doButton = new JButton("Adjust");
		doButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				int num = getNum();
				int si = statBox.getSelectedIndex();
				int v = num;
				int oi = opBox.getSelectedIndex();
				int max = 99;
				int min = 1;
				if (si == 32) {
					max = 46;
					min = 15;
				} else if (si > 26) {
					max = 8;
				}

				if (num == 0) {
					int dm = 1;
					int dx = 99;
					if (oi == 2) {
						dm = min;
						dx = max;
					}
					JOptionPane.showMessageDialog(null, "Enter a number: " + dm
							+ "-" + dx, "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (si == 0) {
						for (int p = 1; p < Player.total; p++) {
							if (adj(p) && adjTeam(p)) {
								for (int i = 1; i < 27; i++) {
									switch (oi) {
									case 0:
										v = getStat(i, p) + num;
										break;
									case 1:
										v = getStat(i, p) - num;
										break;
									case 2:
										v = num;
										break;
									case 3:
										v = getStat(i, p)
												+ (getStat(i, p) * num / 100);
										break;
									case 4:
										v = getStat(i, p)
												- (getStat(i, p) * num / 100);
										break;
									}
									if (v > 99) {
										v = 99;
									}
									if (v < 1) {
										v = 1;
									}
									setStat(i, p, v);
								}
							}
						}
						if (checkBox.isSelected()) {
							for (int p = Player.firstEdit; p < 32952; p++) { //offset
								if (adj(p) && adjTeam(p)) {
									for (int i = 1; i < 27; i++) {
										switch (oi) {
										case 0:
											v = getStat(i, p) + num;
											break;
										case 1:
											v = getStat(i, p) - num;
											break;
										case 2:
											v = num;
											break;
										case 3:
											v = getStat(i, p)
													+ (getStat(i, p) * num / 100);
											break;
										case 4:
											v = getStat(i, p)
													- (getStat(i, p) * num / 100);
											break;
										}
										if (v > 99) {
											v = 99;
										}
										if (v < 1) {
											v = 1;
										}
										setStat(i, p, v);
									}
								}
							}
						}
					}

					if (si == 27) {
						for (int p = 1; p < Player.total; p++) {
							if (adj(p) && adjTeam(p)) {
								for (int i = 28; i < 32; i++) {
									switch (oi) {
									case 0:
										v = getStat(i, p) + num;
										break;
									case 1:
										v = getStat(i, p) - num;
										break;
									case 2:
										v = num;
										break;
									case 3:
										v = getStat(i, p)
												+ (getStat(i, p) * num / 100);
										break;
									case 4:
										v = getStat(i, p)
												- (getStat(i, p) * num / 100);
										break;
									}
									if (v > 8) {
										v = 8;
									}
									if (v < 1) {
										v = 1;
									}
									setStat(i, p, v);
								}
							}
						}
						if (checkBox.isSelected()) {
							for (int p = Player.firstEdit; p < 32952; p++) { //offset
								if (adj(p) && adjTeam(p)) {
									for (int i = 28; i < 32; i++) {
										switch (oi) {
										case 0:
											v = getStat(i, p) + num;
											break;
										case 1:
											v = getStat(i, p) - num;
											break;
										case 2:
											v = num;
											break;
										case 3:
											v = getStat(i, p)
													+ (getStat(i, p) * num / 100);
											break;
										case 4:
											v = getStat(i, p)
													- (getStat(i, p) * num / 100);
											break;
										}
										if (v > 8) {
											v = 8;
										}
										if (v < 1) {
											v = 1;
										}
										setStat(i, p, v);
									}
								}
							}
						}
					}

					if (si != 0 && si != 27) {
						for (int p = 1; p < Player.total; p++) {
							if (adj(p) && adjTeam(p)) {
								switch (oi) {
								case 0:
									v = getStat(si, p) + num;
									break;
								case 1:
									v = getStat(si, p) - num;
									break;
								case 2:
									v = num;
									break;
								case 3:
									v = getStat(si, p)
											+ (getStat(si, p) * num / 100);
									break;
								case 4:
									v = getStat(si, p)
											- (getStat(si, p) * num / 100);
									break;
								}
								if (v > max) {
									v = max;
								}
								if (v < min) {
									v = min;
								}
								setStat(si, p, v);
							}
						}
						if (checkBox.isSelected()) {
							for (int p = Player.firstEdit; p < 32952; p++) { //offset
								if (adj(p) && adjTeam(p)) {
									switch (oi) {
									case 0:
										v = getStat(si, p) + num;
										break;
									case 1:
										v = getStat(si, p) - num;
										break;
									case 2:
										v = num;
										break;
									case 3:
										v = getStat(si, p)
												+ (getStat(si, p) * num / 100);
										break;
									case 4:
										v = getStat(si, p)
												- (getStat(si, p) * num / 100);
										break;
									}
									if (v > max) {
										v = max;
									}
									if (v < 1) {
										v = 1;
									}
									setStat(si, p, v);
								}
							}
						}
					}
					JOptionPane.showMessageDialog(null,
							"Stats have been adjusted", "Stats Adjusted",
							JOptionPane.INFORMATION_MESSAGE);
					/*
					 * String messageText1 = " set to: "; switch (oi) { case 0:
					 * messageText1 = " increased by: "; break; case 1:
					 * messageText1 = " decreased by: "; break; } String
					 * messageText2 = "every player"; if
					 * (scopeBox.getSelectedIndex() != 0) { messageText2 = "all
					 * players registered in the " +
					 * scopes[scopeBox.getSelectedIndex()] + " position"; }
					 * JOptionPane.showMessageDialog(null, statNames[si] +
					 * " of "+ messageText2 + messageText1 + num,
					 * "Stats Adjusted", JOptionPane.INFORMATION_MESSAGE);
					 */
					tranPanel.refresh();
				}
			}
		});
		lowercase = new JButton("Lowercase");
		lowercase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				for (int p = 1; p < Player.total; p++) {
					Player pl = new Player(of, p, 0);
					pl.setName(capitalizeFully(pl.toString()));
				}
				for (int p = Player.firstEdit; p < 32952; p++) {
					Player pl = new Player(of, p, 0);
					pl.setName(capitalizeFully(pl.toString()));
				}
				tranPanel.refresh();
			}
		});
		

		
		uppercase = new JButton("Uppercase");
		uppercase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				for (int p = 1; p < Player.total; p++) {
					Player pl = new Player(of, p, 0);
					pl.setName(pl.toString().toUpperCase());
				}
				for (int p = Player.firstEdit; p < 32952; p++) {
					Player pl = new Player(of, p, 0);
					pl.setName(pl.toString().toUpperCase());
				}
				tranPanel.refresh();
			}
		});
		lowercaseDb = new JButton("Lowercase");
		lowercaseDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Open unknow_00053.bin_000");
				chooser.setCurrentDirectory(new File(of.filePath));
				chooser.setFileFilter(new FileFilter() {
			        @Override
			        public boolean accept(File f) {
			            if (f.isDirectory()) {
			                return true;
			            }
			            final String name = f.getName();
			            return name.equals("unknow_00053.bin_000");
			        }
			        @Override
			        public String getDescription() {
			            return "*.bin_000";
			        }
			    });
				int returnVal = chooser.showOpenDialog(getRootPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dest = chooser.getSelectedFile();
					if (chooser.getSelectedFile().isFile()) {
						dbIn = null;
						dbIn = new byte[PlayerDb.total * 124];
						byte[] dbPlayers = new byte[134912];
						try {
							RandomAccessFile in = new RandomAccessFile(dest, "r");
							in.read(dbIn);
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (int p = 0; p < PlayerDb.total; p++) {
							try {
								new PlayerDb(dbIn, p, true);
								System.arraycopy(PlayerDb.extPlayers, p * 124, dbPlayers, p * 124, 124);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						try {
							RandomAccessFile dbPlayersBin = new RandomAccessFile(dest, "rw");
							dbPlayersBin.write(dbPlayers);
							dbPlayersBin.close();
							saveOkMsg(dest);
							chooser.setSelectedFile(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						openFailMsg();
					}
				}
			}
		});
		uppercaseDb = new JButton("Uppercase");
		uppercaseDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Open unknow_00053.bin_000");
				chooser.setCurrentDirectory(new File(of.filePath));
				chooser.setFileFilter(new FileFilter() {
			        @Override
			        public boolean accept(File f) {
			            if (f.isDirectory()) {
			                return true;
			            }
			            final String name = f.getName();
			            return name.equals("unknow_00053.bin_000");
			        }
			        @Override
			        public String getDescription() {
			            return "*.bin_000";
			        }
			    });
				int returnVal = chooser.showOpenDialog(getRootPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dest = chooser.getSelectedFile();
					if (chooser.getSelectedFile().isFile()) {
						dbIn = null;
						dbIn = new byte[PlayerDb.total * 124];
						byte[] dbPlayers = new byte[134912];
						try {
							RandomAccessFile in = new RandomAccessFile(dest, "r");
							in.read(dbIn);
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (int p = 0; p < PlayerDb.total; p++) {
							try {
								new PlayerDb(dbIn, p, false);
								System.arraycopy(PlayerDb.extPlayers, p * 124, dbPlayers, p * 124, 124);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						try {
							RandomAccessFile dbPlayersBin = new RandomAccessFile(dest, "rw");
							dbPlayersBin.write(dbPlayers);
							dbPlayersBin.close();
							saveOkMsg(dest);
							chooser.setSelectedFile(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						openFailMsg();
					}
				}
			}
		});
		lowercaseDb2 = new JButton("Lowercase");
		lowercaseDb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Open unknow_00055.bin_000");
				chooser.setCurrentDirectory(new File(of.filePath));
				chooser.setFileFilter(new FileFilter() {
			        @Override
			        public boolean accept(File f) {
			            if (f.isDirectory()) {
			                return true;
			            }
			            final String name = f.getName();
			            return name.equals("unknow_00055.bin_000");
			        }
			        @Override
			        public String getDescription() {
			            return "*.bin_000";
			        }
			    });
				int returnVal = chooser.showOpenDialog(getRootPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dest = chooser.getSelectedFile();
					if (chooser.getSelectedFile().isFile()) {
						dbIn = null;
						dbIn = new byte[PlayerDb.total2 * 124];
						byte[] dbPlayers = new byte[102920];
						try {
							RandomAccessFile in = new RandomAccessFile(dest, "r");
							in.read(dbIn);
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (int p = 0; p < PlayerDb.total2; p++) {
							try {
								new PlayerDb(dbIn, p, true);
								System.arraycopy(PlayerDb.ext2Players, p * 124, dbPlayers, p * 124, 124);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						try {
							RandomAccessFile dbPlayersBin = new RandomAccessFile(dest, "rw");
							dbPlayersBin.write(dbPlayers);
							dbPlayersBin.close();
							saveOkMsg(dest);
							chooser.setSelectedFile(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						openFailMsg();
					}
				}
			}
		});
		uppercaseDb2 = new JButton("Uppercase");
		uppercaseDb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Open unknow_00055.bin_000");
				chooser.setCurrentDirectory(new File(of.filePath));
				chooser.setFileFilter(new FileFilter() {
			        @Override
			        public boolean accept(File f) {
			            if (f.isDirectory()) {
			                return true;
			            }
			            final String name = f.getName();
			            return name.equals("unknow_00055.bin_000");
			        }
			        @Override
			        public String getDescription() {
			            return "*.bin_000";
			        }
			    });
				int returnVal = chooser.showOpenDialog(getRootPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dest = chooser.getSelectedFile();
					if (chooser.getSelectedFile().isFile()) {
						dbIn = null;
						dbIn = new byte[PlayerDb.total2 * 124];
						byte[] dbPlayers = new byte[102920];
						try {
							RandomAccessFile in = new RandomAccessFile(dest, "r");
							in.read(dbIn);
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (int p = 0; p < PlayerDb.total2; p++) {
							try {
								new PlayerDb(dbIn, p, false);
								System.arraycopy(PlayerDb.ext2Players, p * 124, dbPlayers, p * 124, 124);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						try {
							RandomAccessFile dbPlayersBin = new RandomAccessFile(dest, "rw");
							dbPlayersBin.write(dbPlayers);
							dbPlayersBin.close();
							saveOkMsg(dest);
							chooser.setSelectedFile(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						openFailMsg();
					}
				}
			}
		});
		scopePanel.add(new JLabel("Registered Position:"));
		scopePanel.add(new JLabel("Exclude Team:"));
		scopePanel.add(new JLabel("Created Players:"));
		scopePanel.add(scopeBox);
		scopePanel.add(teamBox);
		scopePanel.add(checkBox);
		panel99.add(statBox);
		panel99.add(opBox);
		panel99.add(numField);
		panel99.add(doButton);
		names.add(lowercase);
		names.add(uppercase);
		namesDb.add(lowercaseDb);
		namesDb.add(uppercaseDb);
		namesDb2.add(lowercaseDb2);
		namesDb2.add(uppercaseDb2);
		main.add(scopePanel);
		main.add(panel99);
		main.add(names);
		main.add(namesDb);
		main.add(namesDb2);
		add(main);
	}

	private int getNum() {
		int v;
		int max = 99;
		int min = 1;
		int si = statBox.getSelectedIndex();
		if (opBox.getSelectedIndex() == 2) {
			if (si == 32) {
				max = 46;
				min = 15;
			} else if (si > 26) {
				max = 8;
			}
		}
		try {
			v = new Integer(numField.getText()).intValue();
			if (v < min || v > max) {
				v = 0;
			}
		} catch (NumberFormatException nfe) {
			v = 0;
		}
		return v;
	}

	private void setStat(int si, int p, int num) {
		if (si == 32) {
			num = num - 15;
		} else if (si > 26) {
			num = num - 1;
		}
		if (si > 0 && si <= 26) {
			Stats.setValue(of, p, Stats.ability99[si - 1], num);
		}
		switch (si) {
		case 28:
			Stats.setValue(of, p, Stats.wfa, num);
			break;
		case 29:
			Stats.setValue(of, p, Stats.wff, num);
			break;
		case 30:
			Stats.setValue(of, p, Stats.consistency, num);
			break;
		case 31:
			Stats.setValue(of, p, Stats.condition, num);
			break;
		case 32:
			Stats.setValue(of, p, Stats.age, num);
			break;
		}
		Stats.setValue(of, p, Stats.abilityEdited, 1);
	}

	private int getStat(int si, int p) {
		int v = 0;
		if (si > 0 && si <= 26) {
			v = Stats.getValue(of, p, Stats.ability99[si - 1]);
		}
		switch (si) {
		case 28:
			v = Stats.getValue(of, p, Stats.wfa);
			break;
		case 29:
			v = Stats.getValue(of, p, Stats.wff);
			break;
		case 30:
			v = Stats.getValue(of, p, Stats.consistency);
			break;
		case 31:
			v = Stats.getValue(of, p, Stats.condition);
			break;
		case 32:
			v = Stats.getValue(of, p, Stats.age);
			break;
		}
		if (si == 32) {
			v = v + 15;
		} else if (si > 26) {
			v = v + 1;
		}
		return v;
	}

	private boolean adj(int p) {
		boolean result = false;
		int si = scopeBox.getSelectedIndex();
		if (si == 0) {
			result = true;
		} else {
			int v = Stats.getValue(of, p, Stats.regPos);
			if (si == 1) {
				si = si - 1;
			}
			if (v == si) {
				result = true;
			}
		}
		return result;
	}

	public void updateTeamBox(String[] teams) {
		String[] clubs = new String[Clubs.total + 1];
		clubs[0] = "None";
		System.arraycopy(teams, 0, clubs, 1, Clubs.total);
		DefaultComboBoxModel model = new DefaultComboBoxModel(clubs);
		teamBox.setModel(model);
	}

	private boolean adjTeam(int p) {
		boolean result = true;
		int ti = teamBox.getSelectedIndex();
		if (ti != 0) {
			int firstAdr = Squads.slot32 + ((ti - 1) * 64);
			int a;
			int i;
			for (int sp = 0; result && sp < 32; sp++) {
				a = firstAdr + (sp * 2);
				i = (of.toInt(of.data[a + 1]) << 8) | of.toInt(of.data[a]);
				if (i == p) {
					result = false;
				}
			}
		}
		return result;
	}

	public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

	private static boolean isDelimiter(final char ch, final char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        }
        for (final char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }

	public static String capitalize(final String str) {
        return capitalize(str, null);
    }

	public static String capitalize(final String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if (isEmpty(str) || delimLen == 0) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            if (isDelimiter(ch, delimiters)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer[i] = Character.toTitleCase(ch);
                capitalizeNext = false;
            }
        }
        return new String(buffer);
    }

	public static String capitalizeFully(final String str) {
        return capitalizeFully(str, null);
    }

	public static String capitalizeFully(String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if (isEmpty(str) || delimLen == 0) {
            return str;
        }
        str = str.toLowerCase();
        return capitalize(str, delimiters);
    }

	public static String uncapitalize(final String str) {
        return uncapitalize(str, null);
    }

	public static String uncapitalize(final String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if (isEmpty(str) || delimLen == 0) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean uncapitalizeNext = true;
        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            if (isDelimiter(ch, delimiters)) {
                uncapitalizeNext = true;
            } else if (uncapitalizeNext) {
                buffer[i] = Character.toLowerCase(ch);
                uncapitalizeNext = false;
            }
        }
        return new String(buffer);
    }

	private void openFailMsg() {
		JOptionPane.showMessageDialog(getRootPane(), "Could not open file",
				"Error", JOptionPane.ERROR_MESSAGE);
	}

	private void saveOkMsg(File dest) {
		JOptionPane.showMessageDialog(getRootPane(), dest.getName()
				+ "\nSaved in:\n" + dest.getParent(),
				"Database Successfully Modified", JOptionPane.INFORMATION_MESSAGE);
	}
}
