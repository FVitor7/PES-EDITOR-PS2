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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class PlayerDialog extends JDialog {// implements ListSelectionListener,
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// MouseListener {
	OptionFile of;

	// OptionFile of2;
	// OptionFile of2;
	// JButton cancelBut;
	// JButton importBut;
	// JLabel fileLabel;
	// JLabel oldPlLabel;
	// PlayerList plList;
	// InfoPanel2 infoPanel;
	// boolean of2Open;
	int index;
	JCheckBox[] checkBox;

	Player player;

	GeneralAbilityPanel genPanel;
	
	ExtraPanel exPanel;

	PlayerDialog thisForm;
	
	PositionPanel posPanel;

	Ability99Panel abiPanel;

	SpecialAbilityPanel spePanel;

	JButton acceptButton;

	JButton exportPlayerButton;
	JButton importPlayerButton;
	JButton psdButton;

	JButton cancelButton;

	JButton importButton;

	private File currentFile = null;

	// int replacement;

	PlayerImportDialog plImpDia;

	public PlayerDialog(final Frame owner, OptionFile opf, PlayerImportDialog pid) {
		super(owner, "Edit Player", true);
		thisForm = this;
		JPanel panel = new JPanel();
		JPanel lPanel = new JPanel(new BorderLayout());
		JPanel b1Panel = new JPanel();
		JPanel b2Panel = new JPanel();
		acceptButton = new JButton("Accept");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (check()) {
					updateStats();
					setVisible(false);
				}
			}
		});
		
		psdButton = new JButton("Paste PSD Stat");
		psdButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				new PSDStatPaste(owner,thisForm);
			}
		});
		
		exportPlayerButton = new JButton("Export .plrv");
		exportPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (check()) {
					updateStats();
					Player pl = new Player(of, index, 0);
					RandomAccessFile playerBin;
					JFileChooser chooser = new JFileChooser();
					chooser.setDialogTitle("Export Player");
					chooser.setCurrentDirectory(new File(of.filePath));
					chooser.setFileFilter(new FileNameExtensionFilter("PLRV files (*.plrv)", "plrv"));
					chooser.setSelectedFile(new File(pl.name + ".plrv"));
					int returnVal = chooser.showSaveDialog(getContentPane());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser.getSelectedFile();
						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
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
											playerBin = new RandomAccessFile(chooser.getSelectedFile(), "rw");
											playerBin.write(pl.bytes);
											playerBin.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
										setTitle("PES Editor 5/6/08/09/10/11/12/13/14 - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {
								currentFile = dest;
								try {
									playerBin = new RandomAccessFile(chooser.getSelectedFile(), "rw");
									playerBin.write(pl.bytes);
									playerBin.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
								setTitle("PES Editor 5/6/08/09/10/11/12/13/14 - " //version
										+ currentFile.getName());
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
		importPlayerButton = new JButton("Import .plrv");
		importPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Import Player");
				chooser.setCurrentDirectory(new File(of.filePath));
				chooser.setFileFilter(new FileNameExtensionFilter("PLRV files (*.plrv)", "plrv"));
				int returnVal = chooser.showOpenDialog(getRootPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dest = chooser.getSelectedFile();
					if (chooser.getSelectedFile().isFile()) {
						Player pl = new Player(of, index, 0);
						try {
							RandomAccessFile playerBin = new RandomAccessFile(chooser.getSelectedFile(), "r");
							byte[] player = new byte[124];
							playerBin.read(player);
							playerBin.close();
							if (pl.index >= Player.firstEdit)
								System.arraycopy(player, 0, of.data, Player.startAdrE + ((pl.index - Player.firstEdit) * 124), 124);
							else
								System.arraycopy(player, 0, of.data, Player.startAdr + pl.index * 124, 124);
							importOkMsg(dest, pl.name);
							chooser.setSelectedFile(null);
							setVisible(false);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						openFailMsg();
					}
				}
			}
		});
		CancelButton cancelButton = new CancelButton(thisForm);
		importButton = new JButton("Import (OF2)");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				// System.out.println(index);
				plImpDia.show(index);
				setVisible(false);
			}
		});
		of = opf;
		plImpDia = pid;
		// of2 = opf2;
		genPanel = new GeneralAbilityPanel(of);
		exPanel = new ExtraPanel(owner, of);
		posPanel = new PositionPanel(of);
		abiPanel = new Ability99Panel(of);
		spePanel = new SpecialAbilityPanel(of);

		b1Panel.add(acceptButton);
		b1Panel.add(cancelButton);
		b1Panel.add(importButton);
		b2Panel.add(exportPlayerButton);
		b2Panel.add(importPlayerButton);
		b2Panel.add(psdButton);
		lPanel.add(genPanel, BorderLayout.NORTH);
		lPanel.add(exPanel, BorderLayout.CENTER);
		//lPanel.add(posPanel, BorderLayout.NORTH);
		JSplitPane bPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, b1Panel, b2Panel);
		bPanel.setEnabled(false);
		bPanel.setUI(new BasicSplitPaneUI() {
			@SuppressWarnings("serial")
			public BasicSplitPaneDivider createDefaultDivider() {
				return new BasicSplitPaneDivider(this) {
					public void setBorder(Border b) {
					}
				};
			}
		});
		bPanel.setBorder(null);
		lPanel.add(bPanel, BorderLayout.SOUTH);
		panel.add(lPanel);
		panel.add(abiPanel);
		panel.add(posPanel);
		panel.add(spePanel);
		getContentPane().add(panel);
		pack();
		setResizable(false);
	}

	public void show(Player p) {
		index = p.index;
		player = p;
		setTitle("Edit Player - " + String.valueOf(index) + " - " + p.name);
		if (plImpDia.of2Open) {
			importButton.setVisible(true);
		} else {
			importButton.setVisible(false);
		}
		genPanel.load(index);
		exPanel.load(index);
		posPanel.load(index);
		abiPanel.load(index);
		spePanel.load(index);
		setVisible(true);
	}

	private boolean check() {
		boolean ok = true;
		int v;
		for (int i = 0; i < abiPanel.ability99.length; i++) {
			try {
				v = new Integer(abiPanel.field[i].getText()).intValue();
				if (v < 1 || v > 99) {
					ok = false;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
		}
		try {
			v = new Integer(genPanel.heightField.getText()).intValue();
			if (v < 148 || v > 211) {
				ok = false;
			}
		} catch (NumberFormatException nfe) {
			ok = false;
		}
		try {
			v = new Integer(genPanel.weightField.getText()).intValue();
			if (v < 1 || v > 127) {
				ok = false;
			}
		} catch (NumberFormatException nfe) {
			ok = false;
		}
		try
		{
			v = new Integer(genPanel.ageField.getText()).intValue();
			if (v < 15 || v > 46)
			{
				error("Age is out of range!");
				return false;
			}
		}
		catch (NumberFormatException nfe)
		{
			error("Age is not a number");
			return false;
		}
		
		try {
			v = new Integer(exPanel.callField.getText()).intValue();
			if (v < 0 || v > 65535) {
				ok = false;
			}
		} catch (NumberFormatException nfe) {
			ok = false;
		}
		
		/*try {
			v = new Integer(exPanel.cel1Field.getText()).intValue();
			if (v < 0 || v > 80) {
				ok = false;
			}
		} catch (NumberFormatException nfe) {
			ok = false;
		}
		try
	    {
	      v = new Integer(exPanel.faceTypeField.getText()).intValue();
	      if ((v < 0) || (v > 2)) {
	        ok = false;
	      
	    }
	    catch (NumberFormatException localNumberFormatException8)
	    {
	      ok = false;
	    }}
		
		try {
			v = new Integer(exPanel.cel2Field.getText()).intValue();
			if (v < 0 || v > 80) {
				ok = false;
			}
		} catch (NumberFormatException nfe) {
			ok = false;
		}*/
		return ok;
	}
	private void error(String s)
	{
		JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
	}
	private void updateStats() {
		for (int i = 0; i < Stats.roles.length; i++) {
			 Stats.setValue(of,index, Stats.roles[i], boToInt(posPanel.checkBox[i].isSelected()));
		}

		String regPos;
		for (int i = 0; i < Stats.roles.length; i++) {
			if (i != 1) {
				Stats.setValue(of, index, Stats.roles[i],
						boToInt(posPanel.checkBox[i].isSelected()));
			}
		}
		int v = 0;
		for (int i = 0; i < Stats.roles.length; i++) {
			if (((String) (posPanel.regBox.getSelectedItem()))
					.equals(Stats.roles[i].name)) {
				v = i;
			}
		}
		Stats.setValue(of, index, Stats.regPos, v);

		Stats.setValue(of, index, Stats.height, genPanel.heightField.getText());

		int item = genPanel.footBox.getSelectedIndex();
		int foot = item / 3;
		int side = item - (foot * 3);
		Stats.setValue(of, index, Stats.foot, foot);
		Stats.setValue(of, index, Stats.favSide, side);
		Stats.setValue(of, index, Stats.wfa, (String) (genPanel.wfaBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.wff, (String) (genPanel.wffBox
				.getSelectedItem()));

		for (int i = 0; i < Stats.ability99.length; i++) {
			Stats.setValue(of, index, Stats.ability99[i], abiPanel.field[i]
					.getText());
		}

		Stats.setValue(of, index, Stats.consistency, (String) (genPanel.consBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.condition, (String) (genPanel.condBox
				.getSelectedItem()));

		for (int i = 0; i < Stats.abilitySpecial.length; i++) {
			Stats.setValue(of, index, Stats.abilitySpecial[i],
					boToInt(spePanel.checkBox[i].isSelected()));
		}

		Stats.setValue(of, index, Stats.injury, (String) (genPanel.injuryBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.freekick, (String) (genPanel.fkBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.SKIN2, (String) (exPanel.skinBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.CEL1, (String) (exPanel.cel1Box
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.CEL2, (String) (exPanel.cel2Box
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.faceType, (String) (exPanel.faceBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.pkStyle, (String) (genPanel.pkBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.age, genPanel.ageField.getText());
		Stats.setValue(of, index, Stats.callName, exPanel.callField.getText());
		//Stats.setValue(of, index, Stats.fama, exPanel.famaField.getText());
		//Stats.setValue(of, index, Stats.cel1, exPanel.cel1Field.getText());
		//Stats.setValue(of, index, Stats.faceType, exPanel.faceTypeField.getText());
		Stats.setValue(of, index, Stats.FACE_TYPE, exPanel.faceField.getText());
		Stats.setValue(of, index, Stats.hair, exPanel.hairField.getText());
		//Stats.setValue(of, index, Stats.SKIN, exPanel.skinField.getText());
		Stats.setValue(of, index, Stats.SH2, boToInt(exPanel.specHairCheck.isSelected()));
		//Stats.setValue(of, index, Stats.SH2, Bits.toByte(exPanel.getSpecHairCheck().isSelected()));
		//Stats.setValue(of, index, Stats.cel2, exPanel.cel2Field.getText());
		Stats.setValue(of, index, Stats.weight, genPanel.weightField.getText());
		Stats.setValue(of, index, Stats.nationality,
				(String) (genPanel.nationBox.getSelectedItem()));
		Stats.setValue(of, index, Stats.dribSty, (String) (genPanel.dribBox
				.getSelectedItem()));
		Stats.setValue(of, index, Stats.dkSty, (String) (genPanel.dkBox
				.getSelectedItem()));

		Stats.setValue(of, index, Stats.abilityEdited, 1);
	}

	private int boToInt(boolean b) {
		int i = 0;
		if (b) {
			i = 1;
		}
		return i;
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
		JOptionPane.showMessageDialog(getContentPane(), dest.getName()
				+ "\nSaved in:\n" + dest.getParent(),
				"Player Successfully Exported", JOptionPane.INFORMATION_MESSAGE);
	}

	private void saveFailMsg() {
		JOptionPane.showMessageDialog(getContentPane(), "Export failed", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	private void illNameMsg() {
		JOptionPane
				.showMessageDialog(
						getContentPane(),
						"File name cannot contain the following characters:\n\\ / : * ? \" < > |",
						"Error", JOptionPane.ERROR_MESSAGE);
	}

	private void importOkMsg(File dest, String name) {
		JOptionPane.showMessageDialog(getRootPane(), dest.getName()
				+ "\nImported in:\n" + name,
				"Player Successfully Imported", JOptionPane.INFORMATION_MESSAGE);
	}

	private void openFailMsg() {
		JOptionPane.showMessageDialog(getContentPane(), "Could not open file",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
}
