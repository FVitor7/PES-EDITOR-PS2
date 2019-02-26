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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class KitImportDialog extends JDialog implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OptionFile of2;

	JLabel fileLabel;

	JList list;

	int index;

	public KitImportDialog(Frame owner, OptionFile opf2) {
		super(owner, "Import Kit", true);
		of2 = opf2;
		JPanel panel = new JPanel(new BorderLayout());
		fileLabel = new JLabel("From:");
		list = new JList();
		// list.addListSelectionListener(this);
		list.addMouseListener(this);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(20);
		JScrollPane scroll = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(list);
		CancelButton cancelButton = new CancelButton(this);
		panel.add(fileLabel, BorderLayout.NORTH);
		panel.add(scroll, BorderLayout.CENTER);
		panel.add(cancelButton, BorderLayout.SOUTH);
		getContentPane().add(panel);
		index = 0;

		// setResizable(false);
		// setPreferredSize(new Dimension(462, 677));
		// System.out.println(getWidth() + ", " + getHeight());
	}

	public int show(int i) {
		index = -1;
		refresh(i);
		setVisible(true);
		return index;
	}

	public void refresh(int i) {
		DefaultListModel model = new DefaultListModel();
		model.removeAllElements();

		if (of2.newVersion) {
			if (i < Clubs.total) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total > 59) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad[i
							- Clubs.total - 60], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total], i));
				}
				for (int n = Clubs.total; n < Clubs.total + 67; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total > 59) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad[n
									- Clubs.total - 60], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total], n));
						}
					}
				}
			}
		} else if (of2.version13) {
			if (i < Clubs.total) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total > 59) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad[i
							- Clubs.total - 60], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total], i));
				}
				for (int n = Clubs.total; n < Clubs.total + 67; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total > 59) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad[n
									- Clubs.total12 - 60], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total12], n));
						}
					}
				}
			}
		} else if (of2.version12) {
			if (i < Clubs.total12) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total12; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total12 > 59) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad[i
							- Clubs.total12 - 60], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total12], i));
				}
				for (int n = Clubs.total12; n < Clubs.total12 + 67; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total12 > 59) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad[n
									- Clubs.total12 - 60], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total12], n));
						}
					}
				}
			}
		} else if (of2.version11) {
			if (i < Clubs.total11) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total11; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total11 > 59) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad[i
							- Clubs.total11 - 60], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total11], i));
				}
				for (int n = Clubs.total11; n < Clubs.total11 + 67; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total11 > 59) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad[n
									- Clubs.total11 - 60], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total11], n));
						}
					}
				}
			}
		} else if (of2.version10) {
			if (i < Clubs.total10) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total10; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total10 > 59) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad10[i
							- Clubs.total10 - 60], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total10], i));
				}
				for (int n = Clubs.total10; n < Clubs.total10 + 67; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total10 > 59) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad10[n
									- Clubs.total10 - 60], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total10], n));
						}
					}
				}
			}
		} else if (of2.version09) {
			if (i < Clubs.total09) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total09; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total09 > 59) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad09[i
							- Clubs.total09 - 60], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total09], i));
				}
				for (int n = Clubs.total09; n < Clubs.total09 + 67; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total09 > 59) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad09[n
									- Clubs.total09 - 60], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total09], n));
						}
					}
				}
			}
		} else if (of2.version08) {
			if (i < Clubs.total08) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total08; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total08 > 56) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad08[i
							- Clubs.total08 - 57], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total08], i));
				}
				for (int n = Clubs.total08; n < Clubs.total08 + 64; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total08 > 56) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad08[n
									- Clubs.total08 - 57], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total08], n));
						}
					}
				}
			}
		} else if (of2.version6) {
			if (i < Clubs.total6) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total6; c++) {
					if (c != i && !Kits.isLic(of2, c)) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total6 > 56) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad6[i
							- Clubs.total6 - 57], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total6], i));
				}
				for (int n = Clubs.total6; n < Clubs.total6 + 64; n++) { //squadnumber
					if (n != i && !Kits.isLic(of2, n)) {
						if (n - Clubs.total6 > 56) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad6[n
									- Clubs.total6 - 57], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total6], n));
						}
					}
				}
			}
		} else if (of2.version5) {
			if (i < Clubs.total5) {
				model.addElement(new KitItem(Clubs.getName(of2, i), i));
				for (int c = 0; c < Clubs.total5; c++) {
					//if (c != i && !Kits.isLic(of2, c)) {
					if (c != i) {
						model.addElement(new KitItem(Clubs.getName(of2, c), c));
					}
				}
			} else {
				if (i - Clubs.total5 > 56) { //squadnumber
					model.addElement(new KitItem(PESUtils.extraSquad5[i
							- Clubs.total5 - 57], i)); //squadnumber
				} else {
					model.addElement(new KitItem(Stats.nation[i - Clubs.total5], i));
				}
				for (int n = Clubs.total5; n < Clubs.total5 + 64; n++) { //squadnumber
					//if (n != i && !Kits.isLic(of2, n)) {
					if (n != i) {
						if (n - Clubs.total5 > 56) { //squadnumber
							model.addElement(new KitItem(PESUtils.extraSquad5[n
									- Clubs.total5 - 57], n)); //squadnumber
						} else {
							model.addElement(new KitItem(Stats.nation[n
									- Clubs.total5], n));
						}
					}
				}
			}
		}
		model.trimToSize();
		list.setModel(model);
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
		pack();
	}

	/*
	 * public void valueChanged(ListSelectionEvent e) { if
	 * (e.getValueIsAdjusting() == false) { if (!list.isSelectionEmpty()) { } }
	 * }
	 */

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
		KitItem i = (KitItem) list.getSelectedValue();
		if (clicks == 2 && i != null) {
			index = i.num;
			setVisible(false);
		}
	}

	private class KitItem {
		String team;
		int num;

		public KitItem(String s, int n) {
			team = s;
			num = n;
		}

		public String toString() {
			return team;
		}
	}

}
