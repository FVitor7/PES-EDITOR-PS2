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
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TransferPanel extends JPanel implements MouseListener,
		DropTargetListener, DragSourceListener, DragGestureListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SelectByTeam selectorL;

	private SelectByTeam selectorR;

	private SelectByNation freeList;

	private OptionFile of;

	private NameEditor nameEditor;

	private NumEditor numEditor;

	private InfoPanel infoPanel;

	private ShirtNameEditor shirtEditor;

	private PlayerDialog playerDia;

	private FormationDialog teamDia;

	private JCheckBox autoRel = new JCheckBox("Auto Release");

	private JCheckBox autoRep = new JCheckBox("Auto Sub");

	private JCheckBox safeMode = new JCheckBox("Safe Mode");

	private JButton compare;

	private int releasedIndex = 0;

	private DragSource sourceF = null;

	private DragSource sourceL = null;

	private DragSource sourceR = null;

	private Component sourceComp = null;

	private int sourceIndex = -1;

	private DataFlavor localPlayerFlavor;

	private int compIndex = 0;

	private int lastIndex = 0;

	private JButton exportTeam;
	private JButton importTeam;
	@SuppressWarnings("unused")
	private File currentFile = null;

	public TransferPanel(PlayerDialog pd, OptionFile opf, FormationDialog td) {
		super();
		of = opf;
		teamDia = td;
		playerDia = pd;
		autoRel
				.setToolTipText("When a player is transfered to a club squad he will be automatically released from his old squad");
		autoRel.setSelected(true);
		autoRep
				.setToolTipText("Gaps made in a team's first 11 will be automatically filled with the most appropriate sub");
		autoRep.setSelected(true);
		safeMode
				.setToolTipText("Only transfers that are possible in-game will be allowed");
		safeMode.setSelected(true);

		compare = new JButton("Compare Stats");
		compare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent rl) {
				if (compIndex == 0) {
					compIndex = lastIndex;
					if (nameEditor.source == 2) {
						int squadS = selectorL.teamBox.getSelectedIndex();
						if (of.newVersion) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.newSquadNumber)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version13) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber13)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version12) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber12)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version11) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber11)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version10) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber10)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version09) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber09)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version08) {
							if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber08)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version6) {
							if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber6)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						} else if (of.version5) {
							if (squadS < 64 || (squadS > 73 && squadS < Squads.squadNumber5)) { //squadnumber
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							}
						}
					} else if (nameEditor.source == 3) {
						int squadS = selectorR.teamBox.getSelectedIndex();
						if (of.newVersion) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.newSquadNumber)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version13) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber13)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version12) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber12)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version11) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber11)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version10) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber10)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version09) {
							if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber09)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version08) {
							if (squadS < 64 || (squadS > 72 && squadS < Squads.newSquadNumber)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version6) {
							if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber6)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						} else if (of.version5) {
							if (squadS < 64 || (squadS > 73 && squadS < Squads.squadNumber5)) { //squadnumber
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					}
				} else {
					compIndex = 0;
					selectorL.posList.clearSelection();
					selectorR.posList.clearSelection();
				}
				infoPanel.refresh(lastIndex, compIndex);
			}
		});

		exportTeam = new JButton("Export Team");
		exportTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent rl) {
				int size;
				int index;
				if (selectorL.squadList.team < 73) { //squadnumber
					size = 23;
				} else if (selectorL.squadList.team == 73) { //squadnumber
					size = 14;
				} else {
					size = 32;
				}
				Player pl = (Player) selectorL.squadList.getModel().getElementAt(0);
				int playerNumber = 0;
				if (!pl.name.startsWith("<Edited")) {
					for (int p = 0; p < size; p++) {
						Player player = (Player) selectorL.squadList.getModel().getElementAt(p);
						if (player.name != "<empty>")
							playerNumber++;
					}
				}
				byte[] players = new byte[playerNumber * 124];
				if (!pl.name.startsWith("<Edited")) {
					for (int p = 0; p < playerNumber; p++) {
						index = ((Player) selectorL.squadList.getModel().getElementAt(p)).index;
						Player player = (Player) selectorL.squadList.getModel().getElementAt(p);
						if (player.name != "<empty>")
							System.arraycopy(of.data, Player.startAdr + index * 124, players, p * 124, 124);
					}
					RandomAccessFile playersBin;
					JFileChooser chooser = new JFileChooser();
					chooser.setDialogTitle("Export Team");
					chooser.setCurrentDirectory(new File(of.filePath));
					chooser.setFileFilter(new FileNameExtensionFilter("TMRV files (*.tmrv)", "tmrv"));
					if ((String) selectorL.teamBox.getItemAt(selectorL.squadList.team) != null)
						chooser.setSelectedFile(new File((String) selectorL.teamBox.getItemAt(selectorL.squadList.team) + ".tmrv"));
					int returnVal = chooser.showSaveDialog(getRootPane());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser.getSelectedFile();
						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getRootPane(),
												dest.getName()
														+ "\nAlready exists in:\n"
														+ dest.getParent()
														+ "\nAre you sure you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete()) {
										currentFile = dest;
										try {
											playersBin = new RandomAccessFile(chooser.getSelectedFile(), "rw");
											playersBin.write(players);
											playersBin.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
										saveOkMsg(dest);
										chooser.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {
								currentFile = dest;
								try {
									playersBin = new RandomAccessFile(chooser.getSelectedFile(), "rw");
									playersBin.write(players);
									playersBin.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
								saveOkMsg(dest);
								chooser.setSelectedFile(null);
							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		importTeam = new JButton("Import Team");
		importTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent rl) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Import Team");
				chooser.setCurrentDirectory(new File(of.filePath));
				chooser.setFileFilter(new FileNameExtensionFilter("TMRV files (*.tmrv)", "tmrv"));
				int returnVal = chooser.showOpenDialog(getRootPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dest = chooser.getSelectedFile();
					if (chooser.getSelectedFile().isFile()) {
						int index;
						int sizeDest;
						if (selectorL.squadList.team < 73) { //squadnumber
							sizeDest = 23;
						} else if (selectorL.squadList.team == 73) { //squadnumber
							sizeDest = 14;
						} else {
							sizeDest = 32;
						}
						Player plDest = (Player) selectorL.squadList.getModel().getElementAt(0);
						int playerNumberDest = 0;
						if (!plDest.name.startsWith("<Edited")) {
							for (int p = 0; p < sizeDest; p++) {
								Player player = (Player) selectorL.squadList.getModel().getElementAt(p);
								if (player.name != "<empty>")
									playerNumberDest++;
							}
						}
						int playerNumberSrc = (int) chooser.getSelectedFile().length() / 124;
						try {
							RandomAccessFile playersBin = new RandomAccessFile(chooser.getSelectedFile(), "r");
							byte[] players;
							players = new byte[playerNumberSrc * 124];
							playersBin.read(players);
							playersBin.close();
							if (playerNumberSrc <= playerNumberDest) {
								for (int p = 0; p < playerNumberSrc; p++) {
									index = ((Player) selectorL.squadList.getModel().getElementAt(p)).index;
									if (index >= Player.firstEdit)
										System.arraycopy(players, p * 124, of.data, Player.startAdrE + ((index - Player.firstEdit) * 124), 124);
									else
										System.arraycopy(players, p * 124, of.data, Player.startAdr + index * 124, 124);
								}
								importOkMsg(dest, (String) selectorL.teamBox.getItemAt(selectorL.squadList.team), playerNumberSrc, playerNumberDest);
							} else {
								for (int p = 0; p < playerNumberDest; p++) {
									index = ((Player) selectorL.squadList.getModel().getElementAt(p)).index;
									if (index >= Player.firstEdit)
										System.arraycopy(players, p * 124, of.data, Player.startAdrE + ((index - Player.firstEdit) * 124), 124);
									else
										System.arraycopy(players, p * 124, of.data, Player.startAdr + index * 124, 124);
								}
								importLessOkMsg(dest, (String) selectorL.teamBox.getItemAt(selectorL.squadList.team), playerNumberSrc, playerNumberDest);
							}
							refreshLists();
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

		freeList = new SelectByNation(of);
		selectorL = new SelectByTeam(of, true);
		nameEditor = new NameEditor();
		numEditor = new NumEditor();
		shirtEditor = new ShirtNameEditor();
		JPanel editPanel = new JPanel(new GridLayout(0, 1));
		JPanel optPanel = new JPanel(new GridLayout(0, 1));
		JPanel lPanel = new JPanel(new BorderLayout());
		JPanel rPanel = new JPanel(new BorderLayout());
		selectorR = new SelectByTeam(of, true);
		addListen();
		freeList.freeList.addMouseListener(this);
		selectorL.squadList.addMouseListener(this);
		selectorR.squadList.addMouseListener(this);

		String localPlayerType = DataFlavor.javaJVMLocalObjectMimeType
				+ ";class=editor.Player";
		try {
			localPlayerFlavor = new DataFlavor(localPlayerType);
		} catch (ClassNotFoundException e) {
			System.out
					.println("FormTransferHandler: unable to create data flavor");
		}
		new DropTarget(freeList.freeList, this);
		new DropTarget(selectorL.squadList, this);
		new DropTarget(selectorR.squadList, this);
		sourceF = new DragSource();
		sourceF.createDefaultDragGestureRecognizer(freeList.freeList,
				DnDConstants.ACTION_MOVE, this);
		sourceL = new DragSource();
		sourceL.createDefaultDragGestureRecognizer(selectorL.squadList,
				DnDConstants.ACTION_MOVE, this);
		sourceR = new DragSource();
		sourceR.createDefaultDragGestureRecognizer(selectorR.squadList,
				DnDConstants.ACTION_MOVE, this);

		infoPanel = new InfoPanel(selectorL, of);

		selectorL.squadList
				.setToolTipText("Double click to edit player, right click to edit formation");
		selectorR.squadList
				.setToolTipText("Double click to edit player, right click to edit formation");
		freeList.freeList.setToolTipText("Double click to edit player");

		editPanel.add(nameEditor);
		editPanel.add(shirtEditor);
		optPanel.add(autoRel);
		optPanel.add(autoRep);
		optPanel.add(safeMode);

		JPanel editOptPan = new JPanel();
		JPanel editOptInfoPan = new JPanel(new BorderLayout());
		editOptPan.add(numEditor);
		editOptPan.add(editPanel);
		editOptPan.add(optPanel);
		editOptInfoPan.add(editOptPan, BorderLayout.NORTH);
		editOptInfoPan.add(infoPanel, BorderLayout.CENTER);
		editOptInfoPan.add(compare, BorderLayout.SOUTH);

		lPanel.add(selectorL, BorderLayout.CENTER);
		lPanel.add(exportTeam, BorderLayout.SOUTH);
		rPanel.add(selectorR, BorderLayout.CENTER);
		rPanel.add(importTeam, BorderLayout.SOUTH);
		JPanel listPan = new JPanel(new GridLayout(0, 3));
		listPan.add(freeList);
		listPan.add(lPanel);
		listPan.add(rPanel);

		add(listPan);
		add(editOptInfoPan);
	}

	private int getNumAdr(int a) {
		return Squads.num23 + ((a - Squads.slot23) / 2);
	}

	public void refresh() {
		freeList.refresh();
		selectorL.refresh();
		selectorR.refresh();
		nameEditor.setText("");
		numEditor.setText("");
		shirtEditor.setText("");
		compIndex = 0;
		lastIndex = 0;
		infoPanel.refresh(lastIndex, compIndex);
	}

	public void refreshLists() {
		freeList.freeList.refresh(freeList.nationBox.getSelectedIndex(),
				freeList.alpha);
		selectorL.squadList.refresh(selectorL.teamBox.getSelectedIndex(), true);
		selectorR.squadList.refresh(selectorR.teamBox.getSelectedIndex(), true);
		selectorL.numList.refresh(selectorL.teamBox.getSelectedIndex());
		selectorR.numList.refresh(selectorR.teamBox.getSelectedIndex());
		selectorL.posList.refresh(selectorL.teamBox.getSelectedIndex());
		selectorR.posList.refresh(selectorR.teamBox.getSelectedIndex());
		nameEditor.setText("");
		numEditor.setText("");
		shirtEditor.setText("");
		compIndex = 0;
		lastIndex = 0;
		infoPanel.refresh(lastIndex, compIndex);
	}

	private class NameEditor extends JTextField implements
			ListSelectionListener, ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int source = 0;

		public NameEditor() {
			super(13);
			addActionListener(this);
			setToolTipText("Enter new name and press return");
		}

		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting() == false) {
				if (e.getSource() == freeList.freeList) {
					if (freeList.freeList.isSelectionEmpty()) {
						setText("");
						lastIndex = 0;
					} else {
						setText(((Player) freeList.freeList.getSelectedValue()).name);
						source = 1;
						selectAll();
						lastIndex = ((Player) freeList.freeList
								.getSelectedValue()).index;
					}
				}
				if (e.getSource() == selectorL.squadList) {
					if (selectorL.squadList.isSelectionEmpty()) {
						setText("");
						lastIndex = 0;
					} else {
						if (((Player) selectorL.squadList.getSelectedValue()).index != 0) {
							setText(((Player) selectorL.squadList
									.getSelectedValue()).name);
						} else {
							setText("");
						}
						source = 2;
						selectAll();
						lastIndex = ((Player) selectorL.squadList
								.getSelectedValue()).index;
					}
				}
				if (e.getSource() == selectorR.squadList) {
					if (selectorR.squadList.isSelectionEmpty()) {
						setText("");
						lastIndex = 0;
					} else {
						if (((Player) selectorR.squadList.getSelectedValue()).index != 0) {
							setText(((Player) selectorR.squadList
									.getSelectedValue()).name);
						} else {
							setText("");
						}
						source = 3;
						selectAll();
						lastIndex = ((Player) selectorR.squadList
								.getSelectedValue()).index;
					}
				}
				infoPanel.refresh(lastIndex, compIndex);
			}
		}

		public void actionPerformed(ActionEvent evt) {
			if (source == 1 && !freeList.freeList.isSelectionEmpty()
					&& getText().length() < 16 && getText().length() != 0) {
				int i = freeList.freeList.getSelectedIndex();
				if (!(((Player) freeList.freeList.getSelectedValue()).name
						.equals(getText()))) {
					((Player) freeList.freeList.getSelectedValue())
							.setName(getText());
					((Player) freeList.freeList.getSelectedValue())
							.makeShirt(getText());
					refreshLists();
				}
				if (!freeList.alpha
						&& i < freeList.freeList.getModel().getSize() - 1) {
					freeList.freeList.setSelectedIndex(i + 1);
					freeList.freeList.ensureIndexIsVisible(i + 1);
				}
			}
			if (source == 2 && !selectorL.squadList.isSelectionEmpty()
					&& getText().length() < 16 && getText().length() != 0) {
				int i = selectorL.squadList.getSelectedIndex();
				if (!(((Player) selectorL.squadList.getSelectedValue()).name
						.equals(getText()))) {
					((Player) selectorL.squadList.getSelectedValue())
							.setName(getText());
					((Player) selectorL.squadList.getSelectedValue())
							.makeShirt(getText());
					refreshLists();
				}
				if (i < selectorL.squadList.getModel().getSize() - 1) {
					selectorL.squadList.setSelectedIndex(i + 1);
				}
			}
			if (source == 3 && !selectorR.squadList.isSelectionEmpty()
					&& getText().length() < 16 && getText().length() != 0) {
				int i = selectorR.squadList.getSelectedIndex();
				if (!(((Player) selectorR.squadList.getSelectedValue()).name
						.equals(getText()))) {
					((Player) selectorR.squadList.getSelectedValue())
							.setName(getText());
					((Player) selectorR.squadList.getSelectedValue())
							.makeShirt(getText());
					refreshLists();
				}
				if (i < selectorR.squadList.getModel().getSize() - 1) {
					selectorR.squadList.setSelectedIndex(i + 1);
				}
			}
		}
	}

	private class NumEditor extends JTextField implements
			ListSelectionListener, ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int source = 0;

		public NumEditor() {
			super(2);
			addActionListener(this);
			setToolTipText("Enter new squad number and press return");
		}

		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == selectorL.numList) {
				if (selectorL.numList.isSelectionEmpty()) {
					setText("");
				} else {
					source = 2;
					setText(String.valueOf(getShirt(source, selectorL.numList
							.getSelectedIndex())));
					selectorR.numList.clearSelection();
					selectAll();
				}
			}
			if (e.getSource() == selectorR.numList) {
				if (selectorR.numList.isSelectionEmpty()) {
					setText("");
				} else {
					source = 3;
					setText(String.valueOf(getShirt(source, selectorR.numList
							.getSelectedIndex())));
					selectorL.numList.clearSelection();
					selectAll();
				}
			}
		}

		public void actionPerformed(ActionEvent evt) {
			if (source == 2 && !selectorL.numList.isSelectionEmpty()) {
				int i = selectorL.numList.getSelectedIndex();
				try {
					int v = new Integer(getText()).intValue();
					if (v != 0 && v <= 99) {
						setShirt(source, i, v);
					}
					selectorR.numList.refresh(selectorR.teamBox
							.getSelectedIndex());
					selectorL.numList.refresh(selectorL.teamBox
							.getSelectedIndex());
					if (i < selectorL.squadList.getModel().getSize() - 1) {
						selectorL.numList.setSelectedIndex(i + 1);
					}
				} catch (NumberFormatException nfe) {
				}
			}
			if (source == 3 && !selectorR.numList.isSelectionEmpty()) {
				int i = selectorR.numList.getSelectedIndex();
				try {
					int v = new Integer(getText()).intValue();
					if (v != 0 && v <= 99) {
						setShirt(source, i, v);
					}
					selectorR.numList.refresh(selectorR.teamBox
							.getSelectedIndex());
					selectorL.numList.refresh(selectorL.teamBox
							.getSelectedIndex());
					if (i < selectorR.squadList.getModel().getSize() - 1) {
						selectorR.numList.setSelectedIndex(i + 1);
					}
				} catch (NumberFormatException nfe) {
				}
			}
		}
	}

	public int getShirt(int s, int i) {
		int a;
		if (s == 2) {
			a = ((Player) (selectorL.squadList.getModel().getElementAt(i))).adr;
		} else {
			a = ((Player) (selectorR.squadList.getModel().getElementAt(i))).adr;
		}
		a = getNumAdr(a);
		int shirt = of.toInt(of.data[a]) + 1;
		if (shirt == 256) {
			shirt = 0;
		}
		return shirt;
	}

	public void setShirt(int s, int i, int newShirt) {
		int a;
		if (s == 2) {
			a = ((Player) (selectorL.squadList.getModel().getElementAt(i))).adr;
		} else {
			a = ((Player) (selectorR.squadList.getModel().getElementAt(i))).adr;
		}
		a = getNumAdr(a);
		int shirt = of.toInt(of.data[a]) + 1;
		if (shirt != 256) {
			of.data[a] = of.toByte(newShirt - 1);
		}
	}

	private class ShirtNameEditor extends JTextField implements
			ListSelectionListener, ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int source = 0;

		public ShirtNameEditor() {
			super(13);
			addActionListener(this);
			setToolTipText("Enter new shirt name and press return");
		}

		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting() == false) {
				if (e.getSource() == freeList.freeList) {
					if (freeList.freeList.isSelectionEmpty()) {
						setText("");
					} else {
						setText(((Player) freeList.freeList.getSelectedValue())
								.getShirtName());
						source = 1;
						selectAll();
					}
				}
				if (e.getSource() == selectorL.squadList) {
					if (selectorL.squadList.isSelectionEmpty()) {
						setText("");
					} else {
						setText(((Player) selectorL.squadList
								.getSelectedValue()).getShirtName());
						source = 2;
						selectAll();
					}
				}
				if (e.getSource() == selectorR.squadList) {
					if (selectorR.squadList.isSelectionEmpty()) {
						setText("");
					} else {
						setText(((Player) selectorR.squadList
								.getSelectedValue()).getShirtName());
						source = 3;
						selectAll();
					}
				}
			}
		}

		public void actionPerformed(ActionEvent evt) {
			if (source == 1 && !freeList.freeList.isSelectionEmpty()
					&& getText().length() < 16) {
				((Player) freeList.freeList.getSelectedValue())
						.setShirtName(getText());
				refreshLists();
			}
			if (source == 2 && !selectorL.squadList.isSelectionEmpty()
					&& getText().length() < 16) {
				int i = selectorL.squadList.getSelectedIndex();
				((Player) selectorL.squadList.getSelectedValue())
						.setShirtName(getText());
				refreshLists();
				if (i < selectorL.squadList.getModel().getSize() - 1) {
					selectorL.squadList.setSelectedIndex(i + 1);
				}
			}
			if (source == 3 && !selectorR.squadList.isSelectionEmpty()
					&& getText().length() < 16) {
				int i = selectorR.squadList.getSelectedIndex();
				((Player) selectorR.squadList.getSelectedValue())
						.setShirtName(getText());
				refreshLists();
				if (i < selectorR.squadList.getModel().getSize() - 1) {
					selectorR.squadList.setSelectedIndex(i + 1);
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1 && e.isControlDown()) {
			if (e.getSource() != freeList.freeList) {
				e.consume();
				SquadList list = (SquadList) (e.getSource());
				int t = list.team;
				if (of.newVersion) {
					if (t >= 0 && t < 66) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.newSquadNumber - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version13) {
					if (t >= 0 && t < 66) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber13 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version12) {
					if (t >= 0 && t < 66) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber12 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version11) {
					if (t >= 0 && t < 66) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber11 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version10) {
					if (t >= 0 && t < 66) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber10 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version09) {
					if (t >= 0 && t < 66) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber09 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version08) {
					if (t >= 0 && t < 64) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 73 && t < Squads.squadNumber08 - 7 ) { //squadnumber
						teamDia
								.show(t - 9, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version6) {
					if (t >= 0 && t < 64) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 73 && t < Squads.squadNumber6 - 6 ) { //squadnumber
						teamDia
								.show(t - 9, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version5) {
					if (t >= 0 && t < 64) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 74 && t < Squads.squadNumber5 - 7 ) { //squadnumber
						teamDia
								.show(t - 10, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int clicks = e.getClickCount();
		if (e.getButton() == MouseEvent.BUTTON1 && clicks == 2) {
			JList list = (JList) (e.getSource());
			Player p = ((Player) list.getSelectedValue());
			int pi = p.index;
			if (pi != 0) {
				if (safeMode.isSelected()) {
					if (inNatSquad(pi)) {
						playerDia.genPanel.nationBox.setEnabled(false);
					} else {
						playerDia.genPanel.nationBox.setEnabled(true);
					}
				} else {
					playerDia.genPanel.nationBox.setEnabled(true);
				}
				playerDia.show(p);
				refreshLists();
			}
		} else if (clicks == 1 && e.getButton() == MouseEvent.BUTTON3) {
			if (e.getSource() != freeList.freeList) {
				SquadList list = (SquadList) (e.getSource());
				int t = list.team;
				if (of.newVersion) {
					if (t >= 0 && t < 67) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.newSquadNumber - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version13) {
					if (t >= 0 && t < 67) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber13 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version12) {
					if (t >= 0 && t < 67) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber12 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version11) {
					if (t >= 0 && t < 67) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber11 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version10) {
					if (t >= 0 && t < 67) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber10 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version09) {
					if (t >= 0 && t < 67) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 75 && t < Squads.squadNumber09 - 7 ) { //squadnumber
						teamDia
								.show(t - 8, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version08) {
					if (t >= 0 && t < 64) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 73 && t < Squads.squadNumber08 - 6 ) { //squadnumber
						teamDia
								.show(t - 9, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version6) {
					if (t >= 0 && t < 64) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 73 && t < Squads.squadNumber6 - 6 ) { //squadnumber
						teamDia
								.show(t - 9, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				} else if (of.version5) {
					if (t >= 0 && t < 64) { //squadnumber
						teamDia.show(t, (String) selectorL.teamBox.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
					if (t >= 74 && t < Squads.squadNumber5 - 7 ) { //squadnumber
						teamDia
								.show(t - 10, (String) selectorL.teamBox
										.getItemAt(t));
						Squads.fixForm(of, t, false);
						refreshLists();
					}
				}
			}
		}
	}

	private int clubRelease(int p, boolean rel) {
		int a = Squads.slot32 - 2;
		int index;
		int result = -1;
		int sqi;
		int sp;
		do {
			a = a + 2;
			index = (of.toInt(of.data[a + 1]) << 8) | of.toInt(of.data[a]);
			if (index == p) {
				if (of.version08)
					sqi = ((a - Squads.slot32) / 64) + 73; //squadnumber
				else if (of.version6)
					sqi = ((a - Squads.slot32) / 64) + 73; //squadnumber
				else if (of.version5)
					sqi = ((a - Squads.slot32) / 64) + 74; //squadnumber
				else
					sqi = ((a - Squads.slot32) / 64) + 75; //squadnumber
				sp = (a - Squads.slot32) % 64;
				if (result == -1) {
					if (!rel || sp < 22) {
						result = sqi;
						if (rel) {
							releasedIndex = sp / 2;
						}

					}
				}
				if (rel) {
					of.data[a] = 0;
					of.data[a + 1] = 0;
					of.data[getNumAdr(a)] = -1;
					if (sp >= 22) {
						Squads.tidy(of, sqi);
					} else {
						if (autoRep.isSelected()) {
							int t = sqi;
							if (of.version08) {
								if (t > 72) { //squadnumber
									t = t - 9;
								}
							} else if (of.version6) {
								if (t > 72) { //squadnumber
									t = t - 9;
								}
							} else if (of.version5) {
								if (t > 73) { //squadnumber
									t = t - 10;
								}
							} else {
								if (t > 74) { //squadnumber
									t = t - 8;
								}
							}
							Squads.tidy11(of, sqi, sp / 2, Formations.getPos(
									of, t, 0, sp / 2));
						}
					}
				}
			}
		} while (a < Squads.slot32 + (Clubs.total * 64) - 2);// && index != p);
		return result;
	}

	private byte getNextNum(int s) {
		int size;
		int firstAdr;
		byte num = -1;
		int a;
		byte n;
		boolean spare;
		if (of.version08) {
			if (s < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num23 + (s * size);
			} else {
				size = 32;
				firstAdr = Squads.num32 + ((s - 73) * size); //squadnumber
			}
		} else if (of.version6) {
			if (s < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.num23 + (s * size);
			} else {
				size = 32;
				firstAdr = Squads.num32 + ((s - 73) * size); //squadnumber
			}
		} else if (of.version5) {
			if (s < 74) { //squadnumber
				size = 23;
				firstAdr = Squads.num23 + (s * size);
			} else {
				size = 32;
				firstAdr = Squads.num32 + ((s - 74) * size); //squadnumber
			}
		} else {
			if (s < 75) { //squadnumber
				size = 23;
				firstAdr = Squads.num23 + (s * size);
			} else {
				size = 32;
				firstAdr = Squads.num32 + ((s - 75) * size); //squadnumber
			}
		}
		for (byte i = 0; num == -1 && i < 99; i++) {
			spare = true;
			for (int p = 0; spare && p < size; p++) {
				a = firstAdr + p;
				n = of.data[a];
				if (n == i) {
					spare = false;
				}
			}
			if (spare) {
				num = i;
			}
		}
		if (num == -1) {
			num = 0;
		}
		return num;
	}

	private int countPlayers(int squad) {
		int size;
		int firstAdr;
		int i;
		int count = 0;
		int a;
		if (of.version08) {
			if (squad < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.slot23 + (squad * size * 2);
			} else {
				size = 32;
				firstAdr = Squads.slot32 + ((squad - 73) * size * 2); //squadnumber
			}
		} else if (of.version6) {
			if (squad < 73) { //squadnumber
				size = 23;
				firstAdr = Squads.slot23 + (squad * size * 2);
			} else {
				size = 32;
				firstAdr = Squads.slot32 + ((squad - 73) * size * 2); //squadnumber
			}
		} else if (of.version5) {
			if (squad < 74) { //squadnumber
				size = 23;
				firstAdr = Squads.slot23 + (squad * size * 2);
			} else {
				size = 32;
				firstAdr = Squads.slot32 + ((squad - 74) * size * 2); //squadnumber
			}
		} else {
			if (squad < 75) { //squadnumber
				size = 23;
				firstAdr = Squads.slot23 + (squad * size * 2);
			} else {
				size = 32;
				firstAdr = Squads.slot32 + ((squad - 75) * size * 2); //squadnumber
			}
		}
		for (int p = 0; p < size; p++) {
			a = firstAdr + (p * 2);
			i = (of.toInt(of.data[a + 1]) << 8) | of.toInt(of.data[a]);
			if (i != 0) {
				count++;
			}
		}
		return count;
	}

	private boolean inNatSquad(int pi) {
		boolean in = false;
		if (of.version08 || of.version6 || of.version5) {
			for (int i = 0; in == false && i < 64; i++) { //squadnumber
				if (inSquad(i, pi)) {
					in = true;
				}
			}
		} else {
			for (int i = 0; in == false && i < 67; i++) { //squadnumber
				if (inSquad(i, pi)) {
					in = true;
				}
			}
		}
		return in;
	}

	private boolean inSquad(int squad, int pi) {
		boolean in = false;
		if (pi != 0) {
			int size;
			int firstAdr;
			int i;
			int a;
			if (of.version08) {
				if (squad < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot23 + (squad * size * 2);
				} else {
					size = 32;
					firstAdr = Squads.slot32 + ((squad - 73) * size * 2); //squadnumber
				}
			} else if (of.version6) {
				if (squad < 73) { //squadnumber
					size = 23;
					firstAdr = Squads.slot23 + (squad * size * 2);
				} else {
					size = 32;
					firstAdr = Squads.slot32 + ((squad - 73) * size * 2); //squadnumber
				}
			} else if (of.version5) {
				if (squad < 74) { //squadnumber
					size = 23;
					firstAdr = Squads.slot23 + (squad * size * 2);
				} else {
					size = 32;
					firstAdr = Squads.slot32 + ((squad - 74) * size * 2); //squadnumber
				}
			} else {
				if (squad < 75) { //squadnumber
					size = 23;
					firstAdr = Squads.slot23 + (squad * size * 2);
				} else {
					size = 32;
					firstAdr = Squads.slot32 + ((squad - 75) * size * 2); //squadnumber
				}
			}
			for (int p = 0; !in && p < size; p++) {
				a = firstAdr + (p * 2);
				i = (of.toInt(of.data[a + 1]) << 8) | of.toInt(of.data[a]);
				if (i == pi) {
					in = true;
				}
			}
		}
		return in;
	}

	public void dragEnter(DropTargetDragEvent event) {
	}

	public void dragExit(DropTargetEvent event) {
	}

	public void dragOver(DropTargetDragEvent event) {
		JList targetList = (JList) (event.getDropTargetContext().getComponent());
		int i = targetList.locationToIndex(event.getLocation());
		Player p;
		if (i != -1) {
			p = (Player) (targetList.getModel().getElementAt(i));
		} else {
			p = new Player(of, 0, 0);
		}
		boolean chk = checkSafeDrag(safeMode.isSelected(), targetList, p);
		targetList.setSelectedIndex(i);
		if (chk) {
			event.acceptDrag(DnDConstants.ACTION_MOVE);
		} else {
			event.rejectDrag();
		}
	}

	public void drop(DropTargetDropEvent event) {
		Transferable transferable = event.getTransferable();
		if (transferable.isDataFlavorSupported(localPlayerFlavor)) {
			JList sourceList = (JList) sourceComp;
			JList targetList = (JList) (event.getDropTargetContext()
					.getComponent());
			Player sourcePlayer = (Player) (sourceList.getModel()
					.getElementAt(sourceIndex));
			int indexS = sourcePlayer.index;
			Player targetPlayer;
			int indexT;
			if (targetList.getSelectedIndex() != -1) {
				targetPlayer = (Player) (targetList.getSelectedValue());
				indexT = targetPlayer.index;
			} else {
				targetPlayer = new Player(of, 0, 0);
				indexT = 0;
			}

			if (sourceList != freeList.freeList
					&& targetList != freeList.freeList) {
				int squadS = ((SelectByTeam) (sourceList.getParent())).teamBox
						.getSelectedIndex();
				int squadT = ((SelectByTeam) (targetList.getParent())).teamBox
						.getSelectedIndex();
				if (sourceList == targetList) {
					if (of.newVersion) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.newSquadNumber + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version13) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber13 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version12) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber12 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version11) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber11 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version10) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber10 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version09) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber09 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version08) {
						if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber08 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version6) {
						if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber6 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					} else if (of.version5) {
						if (squadS < 64 || (squadS > 73 && squadS < Squads.squadNumber5 + 1)) { //squadnumber
							if (indexS != indexT) {
								event.acceptDrop(DnDConstants.ACTION_MOVE);
								transferS(sourcePlayer, targetPlayer, squadS,
										squadT, sourceList, targetList);
							}
						}
					}
				} else if (sourceList == selectorL.squadList
						&& targetList == selectorR.squadList) {
					event.acceptDrop(DnDConstants.ACTION_MOVE);
					transferLR(sourcePlayer);
				} else if (sourceList == selectorR.squadList
						&& targetList == selectorL.squadList) {
					event.acceptDrop(DnDConstants.ACTION_MOVE);
					transferRL(sourcePlayer);
				}
			} else if (sourceList == freeList.freeList
					&& targetList == selectorL.squadList) {
				event.acceptDrop(DnDConstants.ACTION_MOVE);
				transferFL(indexS);
			} else if (sourceList == freeList.freeList
					&& targetList == selectorR.squadList) {
				event.acceptDrop(DnDConstants.ACTION_MOVE);
				transferFR(indexS);
			} else if (sourceList == selectorL.squadList
					&& targetList == freeList.freeList) {
				event.acceptDrop(DnDConstants.ACTION_MOVE);
				tranRelL(sourcePlayer, sourceIndex);
			} else if (sourceList == selectorR.squadList
					&& targetList == freeList.freeList) {
				event.acceptDrop(DnDConstants.ACTION_MOVE);
				tranRelR(sourcePlayer, sourceIndex);
			} else {
				event.rejectDrop();
			}

			event.getDropTargetContext().dropComplete(true);
		} else {
			event.rejectDrop();
		}
	}

	public void dropActionChanged(DropTargetDragEvent event) {
	}

	public void dragGestureRecognized(DragGestureEvent event) {
		sourceComp = event.getComponent();
		if (sourceComp instanceof JList) {
			JList list = (JList) sourceComp;
			sourceIndex = list.getSelectedIndex();
			Player p = (Player) list.getSelectedValue();
			if (sourceIndex != -1 && p.index != 0) {
				removeListen();
				lastIndex = 0;
				compIndex = 0;
				infoPanel.refresh(lastIndex, compIndex);
				nameEditor.setText("");
				shirtEditor.setText("");
				nameEditor.source = 0;
				shirtEditor.source = 0;
				PlayerTransferable playerTran = new PlayerTransferable(p);
				if (list != freeList.freeList) {
					int squadS = ((SelectByTeam) (list.getParent())).teamBox
							.getSelectedIndex();
					if (of.newVersion) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.newSquadNumber + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version13) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber13 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version12) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber12 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version11) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber11 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version10) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber10 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version09) {
						if (squadS < 67 || (squadS > 74 && squadS < Squads.squadNumber09 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version08) {
						if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber08 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version6) {
						if (squadS < 64 || (squadS > 72 && squadS < Squads.squadNumber6 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					} else if (of.version5) {
						if (squadS < 64 || (squadS > 73 && squadS < Squads.squadNumber5 + 1)) { //squadnumber
							if (list == selectorL.squadList) {
								selectorL.posList.selectPos(selectorL.squadList,
										selectorL.squadList.getSelectedIndex());
							} else if (list == selectorR.squadList) {
								selectorR.posList.selectPos(selectorR.squadList,
										selectorR.squadList.getSelectedIndex());
							}
						}
					}
				}
				event.getDragSource().startDrag(event, null, playerTran, this);

			}
		}
	}

	public void dragDropEnd(DragSourceDropEvent event) {
		if (!event.getDropSuccess()) {
			refreshLists();
		}
		addListen();
	}

	public void dragEnter(DragSourceDragEvent event) {
	}

	public void dragExit(DragSourceEvent event) {
	}

	public void dragOver(DragSourceDragEvent event) {
	}

	public void dropActionChanged(DragSourceDragEvent event) {
	}

	public class PlayerTransferable implements Transferable {
		Player data;

		public PlayerTransferable(Player p) {
			data = p;
		}

		public Object getTransferData(DataFlavor flavor)
				throws UnsupportedFlavorException {
			if (!isDataFlavorSupported(flavor)) {
				throw new UnsupportedFlavorException(flavor);
			}
			return data;
		}

		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] { localPlayerFlavor };
		}

		public boolean isDataFlavorSupported(DataFlavor flavor) {
			if (localPlayerFlavor.equals(flavor)) {
				return true;
			}
			return false;
		}
	}

	private boolean checkSafeDrag(boolean safe, JList targetList,
			Player targetPlayer) {
		boolean tranFL = true;
		boolean tranFR = true;
		boolean tranLR = true;
		boolean tranRL = true;
		boolean relL = true;
		boolean relR = true;
		boolean fEmpty = true;
		boolean lEmpty = true;
		boolean rEmpty = true;
		int squadL = -1;
		int squadR = -1;

		JList sourceList = (JList) sourceComp;
		int indexS = ((Player) (sourceList.getModel().getElementAt(sourceIndex))).index;
		int indexT = targetPlayer.index;
		int squadS = -1;

		int indexF = 0;
		if (sourceList == freeList.freeList) {
			indexF = indexS;
			fEmpty = false;
		} else if (targetList == freeList.freeList) {
			indexF = indexT;
			fEmpty = false;
		}
		int indexL = 0;
		if (sourceList == selectorL.squadList) {
			indexL = indexS;
			lEmpty = false;
			squadS = ((SelectByTeam) (sourceList.getParent())).teamBox
					.getSelectedIndex();
		} else if (targetList == selectorL.squadList) {
			indexL = indexT;
			lEmpty = false;
		}
		int indexR = 0;
		if (sourceList == selectorR.squadList) {
			indexR = indexS;
			rEmpty = false;
			squadS = ((SelectByTeam) (sourceList.getParent())).teamBox
					.getSelectedIndex();
		} else if (targetList == selectorR.squadList) {
			indexR = indexT;
			rEmpty = false;
		}

		squadL = selectorL.teamBox.getSelectedIndex();
		squadR = selectorR.teamBox.getSelectedIndex();
		if (safe) {
			int minSizeL = 16;
			int minSizeR = 16;
			if (of.version08) {
				if (squadL < 73) { //squadnumber
					minSizeL = 23;
				}
				if (squadR < 73) { //squadnumber
					minSizeR = 23;
				}
			} if (of.version6) {
				if (squadL < 73) { //squadnumber
					minSizeL = 23;
				}
				if (squadR < 73) { //squadnumber
					minSizeR = 23;
				}
			} if (of.version5) {
				if (squadL < 74) { //squadnumber
					minSizeL = 23;
				}
				if (squadR < 74) { //squadnumber
					minSizeR = 23;
				}
			} else {
				if (squadL < 75) { //squadnumber
					minSizeL = 23;
				}
				if (squadR < 75) { //squadnumber
					minSizeR = 23;
				}
			}

			if (indexF >= Player.firstYoung && indexF < Player.firstEdit) {
				tranFL = false;
				tranFR = false;
			}

			if (indexF >= Player.firstML && indexF < Player.firstShop) {
				tranFL = false;
				tranFR = false;
			}

			if (of.version08 || of.version6 || of.version5) {
				//if (indexF >= Player.firstEdit && indexF < 32920 && squadL > 59) {
				if (indexF >= Player.firstEdit && indexF < 32952 && squadL > 56) { //offset //squadnumber
					tranFL = false;
				}
	
				//if (indexF >= Player.firstEdit && indexF < 32920 && squadR > 59) {
				if (indexF >= Player.firstEdit && indexF < 32952 && squadR > 56) { //offset //squadnumber
					tranFR = false;
				}
			} else {
				if (indexF >= Player.firstEdit && indexF < 32952 && squadL > 59) { //offset //squadnumber
					tranFL = false;
				}
	
				if (indexF >= Player.firstEdit && indexF < 32952 && squadR > 59) { //offset //squadnumber
					tranFR = false;
				}
			}

			if (of.newVersion) {
				if (squadL > 74 && squadL < Squads.newSquadNumber + 1) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 74 && squadR < Squads.newSquadNumber + 1) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 59 && squadL < 75) || squadL > 208) { //squadnumber
					tranFL = false;
					if (squadL > 208 && squadL < 212) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 66 && squadL < 74 && squadR > 66) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 74) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 74 && squadL < 213) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 59 && squadR < 75) || squadR > 208) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR > 208 && squadR < 212) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 66 && squadR < 74 && squadL > 66) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 74) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 74 && squadR < 213) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version13) {
				if (squadL > 74 && squadL < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 74 && squadR < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 59 && squadL < 75) || squadL > 208) { //squadnumber
					tranFL = false;
					if (squadL > 208 && squadL < 212) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 66 && squadL < 74 && squadR > 66) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 74) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 74 && squadL < 213) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 59 && squadR < 75) || squadR > 208) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR > 208 && squadR < 212) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 66 && squadR < 74 && squadL > 66) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 74) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 74 && squadR < 213) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version12) {
				if (squadL > 74 && squadL < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 74 && squadR < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 59 && squadL < 75) || squadL > 208) { //squadnumber
					tranFL = false;
					if (squadL > 208 && squadL < 212) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 66 && squadL < 74 && squadR > 66) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 74) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 74 && squadL < 213) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 59 && squadR < 75) || squadR > 208) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR > 208 && squadR < 212) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 66 && squadR < 74 && squadL > 66) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 74) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 74 && squadR < 213) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version11) {
				if (squadL > 74 && squadL < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 74 && squadR < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 59 && squadL < 75) || squadL > 208) { //squadnumber
					tranFL = false;
					if (squadL > 208 && squadL < 212) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 66 && squadL < 74 && squadR > 66) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 74) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 74 && squadL < 213) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 59 && squadR < 75) || squadR > 208) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR > 208 && squadR < 212) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 66 && squadR < 74 && squadL > 66) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 74) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 74 && squadR < 213) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version10) {
				if (squadL > 74 && squadL < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 74 && squadR < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 59 && squadL < 75) || squadL > 208) { //squadnumber
					tranFL = false;
					if (squadL > 208 && squadL < 212) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 66 && squadL < 74 && squadR > 66) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 74) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 74 && squadL < 213) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 59 && squadR < 75) || squadR > 208) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR > 208 && squadR < 212) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 66 && squadR < 74 && squadL > 66) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 74) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 74 && squadR < 213) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version09) {
				if (squadL > 74 && squadL < 211) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 74 && squadR < 211) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 59 && squadL < 75) || squadL > 208) { //squadnumber
					tranFL = false;
					if (squadL > 208 && squadL < 212) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 66 && squadL < 74 && squadR > 66) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 74) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 74 && squadL < 211) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 59 && squadR < 75) || squadR > 208) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR > 208 && squadR < 212) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 66 && squadR < 74 && squadL > 66) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 74) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 74 && squadR < 211) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version08) {
				if (squadL >= 64 || squadR >= 64 || squadL > 72 && squadL < 221) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 72 && squadR < 221) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 56 && squadL < 73) || squadL > 220) { //squadnumber
					tranFL = false;
					if (squadL == 64 && squadL == 221) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 64 && squadL < 72 && squadR > 63) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 72) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 72 && squadL < 221) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 56 && squadR < 73) || squadR > 220) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR == 64 && squadR == 221) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 64 && squadR < 72 && squadL > 63) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 72) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 72 && squadR < 221) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version6) {
				if (squadL >= 64 || squadR >= 64 || squadL > 72 && squadL < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 72 && squadR < 213) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 56 && squadL < 73) || squadL > 212) { //squadnumber
					tranFL = false;
					if (squadL == 64 && squadL == 213) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 64 && squadL < 72 && squadR > 63) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 72) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 72 && squadL < 213) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 56 && squadR < 73) || squadR > 212) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR == 64 && squadR == 213) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 64 && squadR < 72 && squadL > 63) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 72) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 72 && squadR < 213) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			} else if (of.version5) {
				if (squadL >= 64 || squadR >= 64 || squadL > 73 && squadL < 212) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFL = false;
							}
						}
					} else {
						if (s != -1) {
							tranFL = false;
						}
					}
				}
	
				if (squadR > 73 && squadR < 212) { //squadnumber
					int s = clubRelease(indexF, false);
					if (autoRel.isSelected()) {
						if (s != -1) {
							int c = countPlayers(s);
							if (c <= 16) {
								tranFR = false;
							}
						}
					} else {
						if (s != -1) {
							tranFR = false;
						}
					}
				}
	
				if ((squadL > 56 && squadL < 74) || squadL > 211) { //squadnumber
					tranFL = false;
					if (squadL == 64 || squadL == 65 || squadL == 212 || squadL == 217) { //squadnumber
						tranLR = false;
					} else {
						if (squadL > 65 && squadL < 73 && squadR > 63) { //squadnumber
							tranLR = false;
						}
					}
					tranRL = false;
					relL = false;
				} else {
					int countL = countPlayers(squadL);
					if (countL <= minSizeL) {
						relL = false;
						if (indexR == 0) {
						}
						if (autoRel.isSelected() && squadL > 73) { //squadnumber
							tranLR = false;
						}
					}
					if (inSquad(squadL, indexR)) {
						tranRL = false;
						if (squadL != squadR) {
						}
					}
					if (inSquad(squadL, indexF)) {
						tranFL = false;
					}
	
					if (!autoRel.isSelected() && squadL > 73 && squadL < 212) { //squadnumber
						int s = clubRelease(indexR, false);
						if (s != -1) {
							tranRL = false;
						}
					}
	
				}
	
				if ((squadR > 56 && squadR < 74) || squadR > 211) { //squadnumber
					tranLR = false;
					tranFR = false;
					if (squadR == 64 || squadR == 65 || squadR == 212 || squadR == 217) { //squadnumber
						tranRL = false;
					} else {
						if (squadR > 65 && squadR < 73 && squadL > 63) { //squadnumber
							tranRL = false;
						}
					}
					relR = false;
				} else {
					int countR = countPlayers(squadR);
					if (countR <= minSizeR) {
						relR = false;
						if (indexL == 0) {
						}
						if (autoRel.isSelected() && squadR > 73) { //squadnumber
							tranRL = false;
						}
					}
					if (inSquad(squadR, indexL)) {
						tranLR = false;
						if (squadL != squadR) {
						}
					}
	
					if (inSquad(squadR, indexF)) {
						tranFR = false;
					}
	
					if (!autoRel.isSelected() && squadR > 73 && squadR < 212) { //squadnumber
						int s = clubRelease(indexL, false);
						if (s != -1) {
							tranLR = false;
						}
					}
				}
			}

			if (squadR == squadL) {
				tranLR = false;
				tranRL = false;
			}

			if (of.version08 || of.version6 || of.version5) {
				if (squadL < 64) { //squadnumber
					int squadNat = squadL;
					switch (squadNat) {
					case 57: //squadnumber
						squadNat = 6;
						break;
					case 58: //squadnumber
						squadNat = 8;
						break;
					case 59: //squadnumber
						squadNat = 9;
						break;
					case 60: //squadnumber
						squadNat = 13;
						break;
					case 61: //squadnumber
						squadNat = 15;
						break;
					case 62: //squadnumber
						squadNat = 44;
						break;
					case 63: //squadnumber
						squadNat = 45;
						break;
					}
	
					int nat;
					if (!of.version5) {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFL = false;
							}
						}
						if (!rEmpty) {
							nat = Stats.getValue(of, indexR, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranRL = false;
							}
						}
					} else {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFL = false;
							}
						}
						if (!rEmpty) {
							nat = Stats.getValue(of, indexR, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranRL = false;
							}
						}
					}
				}
	
				if (squadR < 64) { //squadnumber
					int squadNat = squadR;
					switch (squadNat) {
					case 57: //squadnumber
						squadNat = 6;
						break;
					case 58: //squadnumber
						squadNat = 8;
						break;
					case 59: //squadnumber
						squadNat = 9;
						break;
					case 60: //squadnumber
						squadNat = 13;
						break;
					case 61: //squadnumber
						squadNat = 15;
						break;
					case 62: //squadnumber
						squadNat = 44;
						break;
					case 63: //squadnumber
						squadNat = 45;
						break;
					}
	
					int nat;
					if (!of.version5) {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFR = false;
							}
						}
						if (!lEmpty) {
							nat = Stats.getValue(of, indexL, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranLR = false;
							}
						}
					} else {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFR = false;
							}
						}
						if (!lEmpty) {
							nat = Stats.getValue(of, indexL, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranLR = false;
							}
						}
					}
				}
			} else {
				if (squadL < 67) { //squadnumber
					int squadNat = squadL;
					switch (squadNat) {
					case 60: //squadnumber
						squadNat = 6;
						break;
					case 61: //squadnumber
						squadNat = 8;
						break;
					case 62: //squadnumber
						squadNat = 9;
						break;
					case 63: //squadnumber
						squadNat = 13;
						break;
					case 64: //squadnumber
						squadNat = 15;
						break;
					case 65: //squadnumber
						squadNat = 44;
						break;
					case 66: //squadnumber
						squadNat = 45;
						break;
					}
	
					int nat;
					if (!of.version5) {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFL = false;
							}
						}
						if (!rEmpty) {
							nat = Stats.getValue(of, indexR, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranRL = false;
							}
						}
					} else {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFL = false;
							}
						}
						if (!rEmpty) {
							nat = Stats.getValue(of, indexR, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranRL = false;
							}
						}
					}
				}
	
				if (squadR < 67) { //squadnumber
					int squadNat = squadR;
					switch (squadNat) {
					case 60: //squadnumber
						squadNat = 6;
						break;
					case 61: //squadnumber
						squadNat = 8;
						break;
					case 62: //squadnumber
						squadNat = 9;
						break;
					case 63: //squadnumber
						squadNat = 13;
						break;
					case 64: //squadnumber
						squadNat = 15;
						break;
					case 65: //squadnumber
						squadNat = 44;
						break;
					case 66: //squadnumber
						squadNat = 45;
						break;
					}
	
					int nat;
					if (!of.version5) {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFR = false;
							}
						}
						if (!lEmpty) {
							nat = Stats.getValue(of, indexL, Stats.nationality);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranLR = false;
							}
						}
					} else {
						if (!fEmpty) {
							nat = Stats.getValue(of, indexF, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranFR = false;
							}
						}
						if (!lEmpty) {
							nat = Stats.getValue(of, indexL, Stats.nationality5);
							if (nat != (Stats.nation.length - 1) && nat != squadNat) {
								tranLR = false;
							}
						}
					}
				}
			}
		}
		boolean result = false;

		if (sourceList != freeList.freeList && targetList != freeList.freeList) {
			if (sourceList == targetList) {
				if (of.newVersion) {
					if (squadS < 67 || (squadS > 74 && squadS < 213)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version13) {
					if (squadS < 67 || (squadS > 74 && squadS < 213)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version12) {
					if (squadS < 67 || (squadS > 74 && squadS < 213)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version11) {
					if (squadS < 67 || (squadS > 74 && squadS < 213)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version10) {
					if (squadS < 67 || (squadS > 74 && squadS < 213)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version09) {
					if (squadS < 67 || (squadS > 74 && squadS < 211)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version08) {
					if (squadS < 64 || (squadS > 72 && squadS < 221)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version6) {
					if (squadS < 64 || (squadS > 72 && squadS < 213)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				} else if (of.version5) {
					if (squadS < 64 || (squadS > 73 && squadS < 212)) { //squadnumber
						if (indexS != indexT) {
							result = true;
						}
					}
				}
			} else if (sourceList == selectorL.squadList
					&& targetList == selectorR.squadList && tranLR
					&& indexS != 0) {
				result = true;
			} else if (sourceList == selectorR.squadList
					&& targetList == selectorL.squadList && tranRL
					&& indexS != 0) {
				result = true;
			}
		} else if (sourceList == freeList.freeList
				&& targetList == selectorL.squadList && tranFL) {
			result = true;
		} else if (sourceList == freeList.freeList
				&& targetList == selectorR.squadList && tranFR) {
			result = true;
		} else if (sourceList == selectorL.squadList
				&& targetList == freeList.freeList && relL) {
			result = true;
		} else if (sourceList == selectorR.squadList
				&& targetList == freeList.freeList && relR) {
			result = true;
		}
		return result;
	}

	private void transferFL(int index) {
		int adr = ((Player) (selectorL.squadList.getSelectedValue())).adr;
		int ti = selectorL.teamBox.getSelectedIndex();
		int n = -1;
		if (of.newVersion) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version13) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version12) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version11) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version10) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version09) {
			if (ti >= 75 && ti < 211 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version08) {
			if (ti >= 73 && ti < 221 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version6) {
			if (ti >= 73 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version5) {
			if (ti >= 74 && ti < 212 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		}
		of.data[adr] = of.toByte(index & 0x000000FF);
		of.data[adr + 1] = of.toByte((index & 0x0000FF00) >>> 8);
		if (of.data[getNumAdr(adr)] == -1) {
			of.data[getNumAdr(adr)] = getNextNum(ti);
		}
		if (selectorL.squadList.getSelectedIndex() > 10) {
			Squads.tidy(of, ti);
		}
		refreshLists();
		if (n != -1) {
			selectorR.teamBox.setSelectedIndex(n);
			selectorR.posList.clearSelection();
			selectorR.posList.setSelectedIndex(releasedIndex);
		}
	}

	private void transferFR(int index) {
		int adr = ((Player) (selectorR.squadList.getSelectedValue())).adr;
		int ti = selectorR.teamBox.getSelectedIndex();
		int n = -1;
		if (of.newVersion) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version13) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version12) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version11) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version10) {
			if (ti >= 75 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version09) {
			if (ti >= 75 && ti < 211 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version08) {
			if (ti >= 73 && ti < 221 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version6) {
			if (ti >= 73 && ti < 213 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		} else if (of.version5) {
			if (ti >= 74 && ti < 212 && autoRel.isSelected()) { //squadnumber
				n = clubRelease(index, true);
			}
		}
		of.data[adr] = of.toByte(index & 0x000000FF);
		of.data[adr + 1] = of.toByte((index & 0x0000FF00) >>> 8);
		if (of.data[getNumAdr(adr)] == -1) {
			of.data[getNumAdr(adr)] = getNextNum(ti);
		}
		if (selectorR.squadList.getSelectedIndex() > 10) {
			Squads.tidy(of, ti);
		}
		refreshLists();
		if (n != -1) {
			selectorL.teamBox.setSelectedIndex(n);
			selectorL.posList.clearSelection();
			selectorL.posList.setSelectedIndex(releasedIndex);
		}
	}

	private void transferLR(Player player) {
		int adrR = ((Player) (selectorR.squadList.getSelectedValue())).adr;
		int index = player.index;
		if (index != 0) {
			int tiR = selectorR.teamBox.getSelectedIndex();
			int tiL = selectorL.teamBox.getSelectedIndex();
			int n = -1;
			if (of.newVersion) {
				if (tiR >= 75 && tiR < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version13) {
				if (tiR >= 75 && tiR < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version12) {
				if (tiR >= 75 && tiR < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version11) {
				if (tiR >= 75 && tiR < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version10) {
				if (tiR >= 75 && tiR < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version09) {
				if (tiR >= 75 && tiR < 211 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version08) {
				if (tiR >= 73 && tiR < 221 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version6) {
				if (tiR >= 73 && tiR < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version5) {
				if (tiR >= 74 && tiR < 212 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			}

			of.data[adrR] = of.toByte(index & 0x000000FF);
			of.data[adrR + 1] = of.toByte((index & 0x0000FF00) >>> 8);
			if (of.data[getNumAdr(adrR)] == -1) {
				of.data[getNumAdr(adrR)] = getNextNum(tiR);
			}
			if (selectorR.squadList.getSelectedIndex() > 10) {
				Squads.tidy(of, selectorR.teamBox.getSelectedIndex());
			}

			refreshLists();
			if (of.newVersion) {
				if (n != -1 && (tiL < 75 || tiL > 210)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version13) {
				if (n != -1 && (tiL < 75 || tiL > 210)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version12) {
				if (n != -1 && (tiL < 75 || tiL > 210)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version11) {
				if (n != -1 && (tiL < 75 || tiL > 210)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version10) {
				if (n != -1 && (tiL < 75 || tiL > 210)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version09) {
				if (n != -1 && (tiL < 75 || tiL > 210)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version08) {
				if (n != -1 && (tiL < 73 || tiL > 220)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version6) {
				if (n != -1 && (tiL < 73 || tiL > 212)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version5) {
				if (n != -1 && (tiL < 74 || tiL > 211)) { //squadnumber
					selectorL.teamBox.setSelectedIndex(n);
					selectorL.posList.clearSelection();
					selectorL.posList.setSelectedIndex(releasedIndex);
				}
			}
		}
	}

	private void transferRL(Player player) {
		int adrL = ((Player) (selectorL.squadList.getSelectedValue())).adr;
		int index = player.index;
		if (index != 0) {
			int tiL = selectorL.teamBox.getSelectedIndex();
			int tiR = selectorR.teamBox.getSelectedIndex();
			int n = -1;
			if (of.newVersion) {
				if (tiL >= 75 && tiL < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version13) {
				if (tiL >= 75 && tiL < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version12) {
				if (tiL >= 75 && tiL < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version11) {
				if (tiL >= 75 && tiL < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version10) {
				if (tiL >= 75 && tiL < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version09) {
				if (tiL >= 75 && tiL < 211 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version08) {
				if (tiL >= 73 && tiL < 221 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version6) {
				if (tiL >= 73 && tiL < 213 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			} else if (of.version5) {
				if (tiL >= 74 && tiL < 212 && autoRel.isSelected()) { //squadnumber
					n = clubRelease(index, true);
				}
			}

			of.data[adrL] = of.toByte(index & 0x000000FF);
			of.data[adrL + 1] = of.toByte((index & 0x0000FF00) >>> 8);
			if (of.data[getNumAdr(adrL)] == -1) {
				of.data[getNumAdr(adrL)] = getNextNum(tiL);
			}
			if (selectorL.squadList.getSelectedIndex() > 10) {
				Squads.tidy(of, selectorL.teamBox.getSelectedIndex());
			}

			refreshLists();
			if (of.newVersion) {
				if (n != -1 && (tiR < 75 || tiR > 210)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version13) {
				if (n != -1 && (tiR < 75 || tiR > 210)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version12) {
				if (n != -1 && (tiR < 75 || tiR > 210)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version11) {
				if (n != -1 && (tiR < 75 || tiR > 210)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version10) {
				if (n != -1 && (tiR < 75 || tiR > 210)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version09) {
				if (n != -1 && (tiR < 75 || tiR > 210)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version08) {
				if (n != -1 && (tiR < 73 || tiR > 220)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version6) {
				if (n != -1 && (tiR < 73 || tiR > 212)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			} else if (of.version5) {
				if (n != -1 && (tiR < 74 || tiR > 211)) { //squadnumber
					selectorR.teamBox.setSelectedIndex(n);
					selectorR.posList.clearSelection();
					selectorR.posList.setSelectedIndex(releasedIndex);
				}
			}
		}
	}

	private void transferS(Player playerS, Player playerT, int tiS, int tiT,
			JList sourceList, JList targetList) {
		int adrS = playerS.adr;
		int indexS = playerS.index;
		int adrT = playerT.adr;
		int indexT = playerT.index;

		of.data[adrS] = of.toByte(indexT & 0x000000FF);
		of.data[adrS + 1] = of.toByte((indexT & 0x0000FF00) >>> 8);
		of.data[adrT] = of.toByte(indexS & 0x000000FF);
		of.data[adrT + 1] = of.toByte((indexS & 0x0000FF00) >>> 8);

		if (tiS == tiT) {
			byte t = of.data[getNumAdr(adrT)];
			of.data[getNumAdr(adrT)] = of.data[getNumAdr(adrS)];
			of.data[getNumAdr(adrS)] = t;
		}

		if (indexS == 0 || indexT == 0) {
			if (sourceIndex > 10) {
				Squads.tidy(of, tiS);
			} else {
				if (autoRep.isSelected()) {
					Squads
							.tidy11(
									of,
									tiS,
									sourceIndex,
									((SelectByTeam) (sourceList.getParent())).posList.posNum[sourceIndex]);
				}
			}
			if (targetList.getSelectedIndex() > 10) {
				Squads.tidy(of, tiT);
			} else {
				if (autoRep.isSelected() && sourceList != targetList) {
					Squads
							.tidy11(
									of,
									tiT,
									targetList.getSelectedIndex(),
									((SelectByTeam) (targetList.getParent())).posList.posNum[targetList
											.getSelectedIndex()]);
				}
			}
		}

		refreshLists();
	}

	private void tranRelL(Player player, int si) {
		int adr = player.adr;
		of.data[adr] = 0;
		of.data[adr + 1] = 0;
		of.data[getNumAdr(adr)] = -1;
		if (si > 10) {
			Squads.tidy(of, selectorL.teamBox.getSelectedIndex());
		} else {
			if (autoRep.isSelected()) {
				Squads.tidy11(of, selectorL.teamBox.getSelectedIndex(), si,
						selectorL.posList.posNum[si]);
			}
		}
		refreshLists();
	}

	private void tranRelR(Player player, int si) {
		int adr = player.adr;
		of.data[adr] = 0;
		of.data[adr + 1] = 0;
		of.data[getNumAdr(adr)] = -1;
		if (si > 10) {
			Squads.tidy(of, selectorR.teamBox.getSelectedIndex());
		} else {
			if (autoRep.isSelected()) {
				Squads.tidy11(of, selectorR.teamBox.getSelectedIndex(), si,
						selectorR.posList.posNum[si]);
			}
		}
		refreshLists();
	}

	private void addListen() {
		selectorL.squadList.addListSelectionListener(nameEditor);
		selectorR.squadList.addListSelectionListener(nameEditor);
		freeList.freeList.addListSelectionListener(nameEditor);
		selectorL.squadList.addListSelectionListener(shirtEditor);
		selectorR.squadList.addListSelectionListener(shirtEditor);
		freeList.freeList.addListSelectionListener(shirtEditor);
		selectorL.numList.addListSelectionListener(numEditor);
		selectorR.numList.addListSelectionListener(numEditor);
	}

	private void removeListen() {
		selectorL.squadList.removeListSelectionListener(nameEditor);
		selectorR.squadList.removeListSelectionListener(nameEditor);
		freeList.freeList.removeListSelectionListener(nameEditor);
		selectorL.squadList.removeListSelectionListener(shirtEditor);
		selectorR.squadList.removeListSelectionListener(shirtEditor);
		freeList.freeList.removeListSelectionListener(shirtEditor);
		selectorL.numList.removeListSelectionListener(numEditor);
		selectorR.numList.removeListSelectionListener(numEditor);
	}

	private boolean fileNameLegal(String fileName) {
		boolean legal = true;
		if (fileName.indexOf("\\") != -1) {
			legal = false;
		}
		if (fileName.indexOf("/") != -1) {
			legal = false;
		}
		if (fileName.indexOf(":") != -1) {
			legal = false;
		}
		if (fileName.indexOf("*") != -1) {
			legal = false;
		}
		if (fileName.indexOf("?") != -1) {
			legal = false;
		}
		if (fileName.indexOf("\"") != -1) {
			legal = false;
		}
		if (fileName.indexOf("<") != -1) {
			legal = false;
		}
		if (fileName.indexOf(">") != -1) {
			legal = false;
		}
		if (fileName.indexOf("|") != -1) {
			legal = false;
		}
		return legal;
	}

	private void saveOkMsg(File dest) {
		JOptionPane.showMessageDialog(getRootPane(), dest.getName()
				+ "\nSaved in:\n" + dest.getParent(),
				"File Successfully Saved", JOptionPane.INFORMATION_MESSAGE);
	}

	private void saveFailMsg() {
		JOptionPane.showMessageDialog(getRootPane(), "Save failed", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	private void illNameMsg() {
		JOptionPane
				.showMessageDialog(
						getRootPane(),
						"File name cannot contain the following characters:\n\\ / : * ? \" < > |",
						"Error", JOptionPane.ERROR_MESSAGE);
	}

	private void openFailMsg() {
		JOptionPane.showMessageDialog(getRootPane(), "Could not open file",
				"Error", JOptionPane.ERROR_MESSAGE);
	}

	private void importOkMsg(File dest, String teamDest, int playerNumberSrc, int playerNumberDest) {
		JOptionPane.showMessageDialog(getRootPane(), dest.getName()
				+ " (" + playerNumberSrc + " players)\nImported in:\n" + teamDest + " (" + playerNumberDest + " players)" + "\n" + (playerNumberDest - playerNumberSrc) + " original player(s) left",
				"Team Successfully Imported", JOptionPane.INFORMATION_MESSAGE);
	}

	private void importLessOkMsg(File dest, String teamDest, int playerNumberSrc, int playerNumberDest) {
		JOptionPane.showMessageDialog(getRootPane(), dest.getName()
				+ " (" + playerNumberSrc + " players)\nImported in:\n" + teamDest + " (" + playerNumberDest + " players)" + "\n" + (playerNumberDest - playerNumberSrc)  * -1 + " player(s) not imported because of unavailable space",
				"Team Partially Imported", JOptionPane.INFORMATION_MESSAGE);
	}
}
