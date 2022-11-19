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
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

public class Editor extends JFrame {
		
	/**
	 *
	 */
	private static final String PesEditorTitle = "PES Editor 5/6/08/09/10/11/12/13/14 V 9.1 PSD (Por: Fábio Vitor)";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFileChooser chooser;

	private JFileChooser chooser13;

	private JFileChooser chooser12;

	private JFileChooser chooser11;

	private JFileChooser chooser10;

	private JFileChooser chooser09;

	private JFileChooser chooser08;

	private JFileChooser chooser6;

	private JFileChooser chooser5;

	private OptionFile of;

	private OptionFile of2;

	private File currentFile = null;
	
	private JMenuItem psdItem;

	private OptionFilter filter;

	private OptionFilter13 filter13;

	private OptionFilter12 filter12;

	private OptionFilter11 filter11;

	private OptionFilter10 filter10;

	private OptionFilter09 filter09;

	private OptionFilter08 filter08;

	private OptionFilter6 filter6;

	private OptionFilter5 filter5;

	protected EmblemPanel flagPanel;

	protected LogoPanel imagePanel;

	protected TransferPanel tranPanel;

	protected WENShopPanel wenShop;

	protected StadiumPanel stadPan;

	protected TeamPanel teamPan;

	protected LeaguePanel leaguePan;

	JTabbedPane tabbedPane;

	PlayerImportDialog plImpDia;

	KitImportDialog kitImpDia;

	EmblemImportDialog flagImpDia;

	LogoImportDialog imageImpDia;

	PlayerDialog playerDia;

	EmblemChooserDialog flagChooser;

	FormationDialog teamDia;

	ImportPanel importPanel;

	LogoChooserDialog logoChooser;

	private CSVMaker csvMaker;

	private JMenuItem csvItem;

	private JMenuItem open2Item;
	
	private JMenuItem open2ItemD;
	
	private JMenuItem open2013Item;

	private JMenuItem open2012Item;

	private JMenuItem open2011Item;

	private JMenuItem open2010Item;

	private JMenuItem open2009Item;

	private JMenuItem open2008Item;

	private JMenuItem open6Item;

	private JMenuItem open5Item;

	private JMenuItem saveItem;

	private JMenuItem saveAsItem;
	
	private JMenuItem saveAsItem13;
	
	private JMenuItem saveAsItem12;
	
	private JMenuItem saveAsItem11;
	
	private JMenuItem saveAsItem10;
	
	private JMenuItem saveAsItemD;

	private JMenuItem savePara;
	
	private JMenuItem savePara13;
	
	private JMenuItem savePara12;
	
	private JMenuItem savePara11;
	
	private JMenuItem savePara10;

	private JFileChooser csvChooser;

	private CSVSwitch csvSwitch;

	private GlobalPanel globalPanel;

	private HelpDialog helpDia;

	private File settingsFile;

	private JMenuItem convertItem;

	boolean about = false;

	public Editor() {
		super(PesEditorTitle); //version
		setIcon();
		JProgressBar localJProgressBar = new JProgressBar(0, 4);
	    JPanel localJPanel = new JPanel(new BorderLayout());
	    setTitle("PES Editor");
	    localJPanel.add(new JLabel(getPesfanIcon()), "Center");
	    localJPanel.add(new JLabel("           Loading, please wait...       "), "North");
	    localJPanel.add(localJProgressBar, "South");
	    getContentPane().add(localJPanel);
	    pack();
	    setDefaultCloseOperation(3);
	    setResizable(false);
	    setVisible(true);
	    setCursor(Cursor.getPredefinedCursor(3));
		filter = new OptionFilter();
		filter13 = new OptionFilter13();
		filter12 = new OptionFilter12();
		filter11 = new OptionFilter11();
		filter10 = new OptionFilter10();
		filter09 = new OptionFilter09();
		filter08 = new OptionFilter08();
		filter6 = new OptionFilter6();
		filter5 = new OptionFilter5();
		tabbedPane = new JTabbedPane();
		csvMaker = new CSVMaker();
		csvChooser = new JFileChooser();
		csvSwitch = new CSVSwitch();

		of = new OptionFile();
		of2 = new OptionFile();

		csvChooser.addChoosableFileFilter(new CSVFilter());
		csvChooser.setAcceptAllFileFilterUsed(false);
		csvChooser.setAccessory(csvSwitch);
		localJProgressBar.setValue(1);
		flagChooser = new EmblemChooserDialog(this, of);
		logoChooser = new LogoChooserDialog(this, of);
		plImpDia = new PlayerImportDialog(this, of, of2);
		kitImpDia = new KitImportDialog(this, of2);
		flagImpDia = new EmblemImportDialog(this, of2);
		imageImpDia = new LogoImportDialog(this, of, of2);
		playerDia = new PlayerDialog(this, of, plImpDia);
		localJProgressBar.setValue(2);
		teamDia = new FormationDialog(this, of);

		tranPanel = new TransferPanel(playerDia, of, teamDia);
		localJProgressBar.setValue(3);
		imagePanel = new LogoPanel(of, imageImpDia);
		globalPanel = new GlobalPanel(of, tranPanel);
		teamPan = new TeamPanel(of, tranPanel, flagChooser, of2, imagePanel,
				globalPanel, kitImpDia, logoChooser);
		flagPanel = new EmblemPanel(of, flagImpDia, teamPan);
		teamPan.flagPan = flagPanel;

		wenShop = new WENShopPanel(of);
		stadPan = new StadiumPanel(of, teamPan);
		leaguePan = new LeaguePanel(of);
		importPanel = new ImportPanel(of, of2, wenShop, stadPan, leaguePan,
				teamPan, flagPanel, imagePanel, tranPanel);

		helpDia = new HelpDialog(this);

		tabbedPane.addTab("Transfers", null, tranPanel, null);
		tabbedPane.addTab("Teams", null, teamPan, null);
		tabbedPane.addTab("Emblems", null, flagPanel, null);
		tabbedPane.addTab("Logos", null, imagePanel, null);
		tabbedPane.addTab("Stadiums", null, stadPan, null);
		tabbedPane.addTab("Leagues", null, leaguePan, null);
		tabbedPane.addTab("PES / Shop", null, wenShop, null);
		tabbedPane.addTab("Adjust Ability", null, globalPanel, null);
		tabbedPane.addTab("Import from OF2", null, importPanel, null);

		settingsFile = new File("PESEditor_settings");
		
		chooser = new JFileChooser(loadSet());
		chooser13 = new JFileChooser(loadSet());
		chooser12 = new JFileChooser(loadSet());
		chooser11 = new JFileChooser(loadSet());
		chooser10 = new JFileChooser(loadSet());
		chooser09 = new JFileChooser(loadSet());
		chooser08 = new JFileChooser(loadSet());
		chooser6 = new JFileChooser(loadSet());
		chooser5 = new JFileChooser(loadSet());
		localJProgressBar.setValue(4);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser13.setAcceptAllFileFilterUsed(false);
		chooser12.setAcceptAllFileFilterUsed(false);
		chooser11.setAcceptAllFileFilterUsed(false);
		chooser10.setAcceptAllFileFilterUsed(false);
		chooser09.setAcceptAllFileFilterUsed(false);
		chooser08.setAcceptAllFileFilterUsed(false);
		chooser6.setAcceptAllFileFilterUsed(false);
		chooser5.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(filter);
		chooser13.addChoosableFileFilter(filter13);
		chooser12.addChoosableFileFilter(filter12);
		chooser11.addChoosableFileFilter(filter11);
		chooser10.addChoosableFileFilter(filter10);
		chooser09.addChoosableFileFilter(filter09);
		chooser08.addChoosableFileFilter(filter08);
		chooser6.addChoosableFileFilter(filter6);
		chooser5.addChoosableFileFilter(filter5);
		chooser.setAccessory(new OptionPreview(chooser));
		chooser13.setAccessory(new OptionPreview(chooser13));
		chooser12.setAccessory(new OptionPreview(chooser12));
		chooser11.setAccessory(new OptionPreview(chooser11));
		chooser10.setAccessory(new OptionPreview(chooser10));
		chooser09.setAccessory(new OptionPreview(chooser09));
		chooser08.setAccessory(new OptionPreview(chooser08));
		chooser6.setAccessory(new OptionPreview(chooser6));
		chooser5.setAccessory(new OptionPreview(chooser5));

		 setCursor(Cursor.getDefaultCursor());
		 setVisible(false);
		 getContentPane().remove(localJPanel);
		 buildMenu();
		 getContentPane().add(this.tabbedPane);
		 pack();
		 tabbedPane.setVisible(false);
		 setVisible(true);
		 openFile();
	}

	private void buildMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("FILE");
		JMenu help = new JMenu("HELP");
		JMenu tool = new JMenu("TOOLS");
		JMenuItem openItem = new JMenuItem("OPEN OF PES 2014");
		JMenuItem openItemD = new JMenuItem("OPEN OF PES 2014 DECRYPT");
		open2Item = new JMenuItem("OPEN OF2 PES 2014");
		open2ItemD = new JMenuItem("OPEN OF2 PES 2014 DECRYPT");
		open2013Item = new JMenuItem("OPEN OF PES 2013");
		open2012Item = new JMenuItem("OPEN OF PES 2012");
		open2011Item = new JMenuItem("OPEN OF PES 2011");
		open2010Item = new JMenuItem("OPEN OF PES 2010");
		open2009Item = new JMenuItem("OPEN OF PES 2009");
		open2008Item = new JMenuItem("OPEN OF PES 2008");
		open6Item = new JMenuItem("OPEN OF PES6");
		open5Item = new JMenuItem("OPEN OF PES5");
		saveItem = new JMenuItem("SAVE OF PES 2014");
		saveAsItem = new JMenuItem("SAVE OF PES 2014 (NEW FILE)");
		saveAsItem13 = new JMenuItem("EXPORT OF PES 2013 DECRYPT");
		saveAsItem12 = new JMenuItem("EXPORT OF PES 2012 DECRYPT");
		saveAsItem11 = new JMenuItem("EXPORT OF PES 2011 DECRYPT");
		saveAsItem10 = new JMenuItem("EXPORT OF PES 2010 DECRYPT");
		saveAsItemD = new JMenuItem("SAVE OF PES 2014 DECRYPT");
		savePara = new JMenuItem("EXPORT DATABASE PES 2014");
		savePara13 = new JMenuItem("EXPORT DATABASE PES 2013");
		savePara12 = new JMenuItem("EXPORT DATABASE PES 2012");
		savePara11 = new JMenuItem("EXPORT DATABASE PES 2011");
		savePara10 = new JMenuItem("EXPORT DATABASE PES 2010");
		JMenuItem exitItem = new JMenuItem("EXIT");
		JMenuItem helpItem = new JMenuItem("HELP: " + PesEditorTitle); //version
		JMenuItem aboutItem = new JMenuItem("ABOUT");
		convertItem = new JMenuItem("CONVERT OF2 TO OF1");

		psdItem = new JMenuItem("Get PSD Stats...");
		csvItem = new JMenuItem("CREATE A CSV FILE WITH THE PLAYERS' SKILLS...");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		psdItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent c)
			{
				System.out.println("PSD init");
				new PSDConnPanel();
			}
		});
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				openFile();
			}
		});
		openItemD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				openFileD();
			}
		});
		open2Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter.accept(chooser.getSelectedFile())) {
					if (chooser.getSelectedFile().isFile()
							&& of2.readXPS(chooser.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");
						if (of.fileName != null) {
							convertItem.setEnabled(true);
						} else {
							convertItem.setEnabled(false);
						}

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		
		open2ItemD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter.accept(chooser.getSelectedFile())) {
					if (chooser.getSelectedFile().isFile()
							&& of2.readXPSD(chooser.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");
						if (of.fileName != null) {
							convertItem.setEnabled(true);
						} else {
							convertItem.setEnabled(false);
						}

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		
		open2013Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser13.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter13.accept(chooser13.getSelectedFile())) {
					if (chooser13.getSelectedFile().isFile()
							&& of2.readXPS13(chooser13.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open2012Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser12.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter12.accept(chooser12.getSelectedFile())) {
					if (chooser12.getSelectedFile().isFile()
							&& of2.readXPS12(chooser12.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open2011Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser11.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter11.accept(chooser11.getSelectedFile())) {
					if (chooser11.getSelectedFile().isFile()
							&& of2.readXPS11(chooser11.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open2010Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser10.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter10.accept(chooser10.getSelectedFile())) {
					if (chooser10.getSelectedFile().isFile()
							&& of2.readXPS10(chooser10.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open2009Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser09.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter09.accept(chooser09.getSelectedFile())) {
					if (chooser09.getSelectedFile().isFile()
							&& of2.readXPS09(chooser09.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open2008Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser08.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter08.accept(chooser08.getSelectedFile())) {
					if (chooser08.getSelectedFile().isFile()
							&& of2.readXPS08(chooser08.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open6Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser6.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter6.accept(chooser6.getSelectedFile())) {
					if (chooser6.getSelectedFile().isFile()
							&& of2.readXPS6(chooser6.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2v6Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						flagImpDia.of2v6Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		open5Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o2) {
				int returnVal = chooser5.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION
						&& filter5.accept(chooser5.getSelectedFile())) {
					if (chooser5.getSelectedFile().isFile()
							&& of2.readXPS5(chooser5.getSelectedFile())) {
						Squads.fixAll(of2);
						plImpDia.refresh();
						flagImpDia.of2v5Open = true;
						imageImpDia.refresh();
						importPanel.refresh();
						flagPanel.refresh();
						teamPan.list
								.setToolTipText("Double click to import a kit from OF2");

					} else {
						teamPan.list.setToolTipText(null);
						plImpDia.of2Open = false;
						flagImpDia.of2Open = false;
						flagImpDia.of2v5Open = false;
						imageImpDia.of2Open = false;
						flagPanel.refresh();
						importPanel.refresh();

						convertItem.setEnabled(false);
						openFailMsg();
					}
				}
			}
		});
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (currentFile != null) {
					if (currentFile.delete() && of.saveXPS(currentFile)) {
						saveOkMsg(currentFile);
						chooser.setSelectedFile(null);
					} else {
						saveFailMsg();
					}
				}
			}
		});
		
		saveAsItemD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (currentFile != null) {
					int returnVal = chooser.showSaveDialog(getContentPane());
					saveSet();
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser.getSelectedFile();
						if (of.format == 0) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.xps))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".xps");
							}
						}
						if (of.format == 2) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.psu))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".psu");
							}
						}
						if (of.format == 3) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.max))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".max");
							}
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nFile already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete() && of.saveXPS(dest)) {
										currentFile = dest;
										setTitle(PesEditorTitle+ " - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (of.saveXPSD(dest)) {
									currentFile = dest;
									setTitle(PesEditorTitle + " - " //version
											+ currentFile.getName());
									saveOkMsg(dest);
									chooser.setSelectedFile(null);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		
		saveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (currentFile != null) {
					int returnVal = chooser.showSaveDialog(getContentPane());
					saveSet();
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser.getSelectedFile();
						if (of.format == 0) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.xps))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".xps");
							}
						}
						if (of.format == 2) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.psu))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".psu");
							}
						}
						if (of.format == 3) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.max))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".max");
							}
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nFile already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete() && of.saveXPS(dest)) {
										currentFile = dest;
										setTitle(PesEditorTitle + " - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (of.saveXPS(dest)) {
									currentFile = dest;
									setTitle(PesEditorTitle + " - " //version
											+ currentFile.getName());
									saveOkMsg(dest);
									chooser.setSelectedFile(null);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		
		saveAsItem13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (currentFile != null) {
					int returnVal = chooser13.showSaveDialog(getContentPane());
					saveSet();
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser13.getSelectedFile();
						if (of2.format == 0) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.xps))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".xps");
							}
						}
						if (of2.format == 2) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.psu))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".psu");
							}
						}
						if (of2.format == 3) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.max))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".max");
							}
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nFile already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete() && of2.saveXPS13(dest)) {
										currentFile = dest;
										setTitle(PesEditorTitle + " - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser13.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (of2.saveXPS13(dest)) {
									currentFile = dest;
									setTitle(PesEditorTitle + " - " //version
											+ currentFile.getName());
									saveOkMsg(dest);
									chooser13.setSelectedFile(null);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		
		saveAsItem12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (currentFile != null) {
					int returnVal = chooser12.showSaveDialog(getContentPane());
					saveSet();
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser12.getSelectedFile();
						if (of2.format == 0) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.xps))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".xps");
							}
						}
						if (of2.format == 2) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.psu))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".psu");
							}
						}
						if (of2.format == 3) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.max))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".max");
							}
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nFile already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete() && of2.saveXPS12(dest)) {
										currentFile = dest;
										setTitle(PesEditorTitle + " - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser12.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (of2.saveXPS12(dest)) {
									currentFile = dest;
									setTitle(PesEditorTitle + " - " //version
											+ currentFile.getName());
									saveOkMsg(dest);
									chooser12.setSelectedFile(null);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		
		saveAsItem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (currentFile != null) {
					int returnVal = chooser11.showSaveDialog(getContentPane());
					saveSet();
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser11.getSelectedFile();
						if (of2.format == 0) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.xps))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".xps");
							}
						}
						if (of2.format == 2) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.psu))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".psu");
							}
						}
						if (of2.format == 3) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.max))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".max");
							}
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nFile already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete() && of2.saveXPS11(dest)) {
										currentFile = dest;
										setTitle(PesEditorTitle + " - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser11.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (of2.saveXPS11(dest)) {
									currentFile = dest;
									setTitle(PesEditorTitle + " - " //version
											+ currentFile.getName());
									saveOkMsg(dest);
									chooser11.setSelectedFile(null);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		
		saveAsItem10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (currentFile != null) {
					int returnVal = chooser10.showSaveDialog(getContentPane());
					saveSet();
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = chooser10.getSelectedFile();
						if (of2.format == 0) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.xps))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".xps");
							}
						}
						if (of2.format == 2) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.psu))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".psu");
							}
						}
						if (of2.format == 3) {
							if ((PESUtils.getExtension(dest) == null)
									|| !(PESUtils.getExtension(dest)
											.equals(PESUtils.max))) {
								dest = new File(dest.getParent()
										+ File.separator + dest.getName()
										+ ".max");
							}
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nFile already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete() && of2.saveXPS10(dest)) {
										currentFile = dest;
										setTitle(PesEditorTitle + " - " //version
												+ currentFile.getName());
										saveOkMsg(dest);
										chooser10.setSelectedFile(null);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (of2.saveXPS10(dest)) {
									currentFile = dest;
									setTitle(PesEditorTitle + " - " //version
											+ currentFile.getName());
									saveOkMsg(dest);
									chooser10.setSelectedFile(null);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});
		
		savePara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (currentFile != null) {
					String dest = currentFile.getParent();
					if (of.savePara(currentFile, dest)) {
						saveParaOkMsg(currentFile);
						chooser.setSelectedFile(null);
					} else {
						saveFailMsg();
					}
				}
			}
		});
		
		savePara13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (currentFile != null) {
					String dest = currentFile.getParent();
					if (of2.savePara13(currentFile, dest)) {
						savePara13OkMsg(currentFile);
						chooser13.setSelectedFile(null);
					} else {
						saveFailMsg();
					}
				}
			}
		});
		
		savePara12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (currentFile != null) {
					String dest = currentFile.getParent();
					if (of2.savePara12(currentFile, dest)) {
						savePara12OkMsg(currentFile);
						chooser12.setSelectedFile(null);
					} else {
						saveFailMsg();
					}
				}
			}
		});
		
		savePara11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (currentFile != null) {
					String dest = currentFile.getParent();
					if (of2.savePara11(currentFile, dest)) {
						savePara11OkMsg(currentFile);
						chooser11.setSelectedFile(null);
					} else {
						saveFailMsg();
					}
				}
			}
		});
		
		savePara10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (currentFile != null) {
					String dest = currentFile.getParent();
					if (of2.savePara10(currentFile, dest)) {
						savePara10OkMsg(currentFile);
						chooser10.setSelectedFile(null);
					} else {
						saveFailMsg();
					}
				}
			}
		});

		helpItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent h) {
				helpDia.setVisible(true);
			}
		});

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent h) {
				about();
			}
		});

		csvItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				if (currentFile != null) {
					int returnVal = csvChooser.showSaveDialog(getContentPane());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File dest = csvChooser.getSelectedFile();
						boolean head = csvSwitch.head.isSelected();
						// boolean extra = false;
						boolean create = csvSwitch.create.isSelected();
						if ((PESUtils.getExtension(dest) == null)
								|| !(PESUtils.getExtension(dest)
										.equals(PESUtils.csv))) {
							dest = new File(dest.getParent() + File.separator
									+ dest.getName() + ".csv");
						}

						if (fileNameLegal(dest.getName())) {
							if (dest.exists()) {
								int n = JOptionPane
										.showConfirmDialog(
												getContentPane(),
												dest.getName()
														+ "\nO File already exists in:\n"
														+ dest.getParent()
														+ "\nDo you want to replace this file?",
												"Replace:  " + dest.getName(),
												JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null);
								if (n == 0) {
									if (dest.delete()
											&& csvMaker.makeFile(of, dest,
													head, false, create)) {
										saveOkMsg(dest);
									} else {
										saveFailMsg();
									}
								}
							} else {

								if (csvMaker.makeFile(of, dest, head, false,
										create)) {
									saveOkMsg(dest);
								} else {
									saveFailMsg();
								}

							}
						} else {
							illNameMsg();
						}
					}
				}
			}
		});

		convertItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (of2.newVersion) {
					System.arraycopy(of2.data, OptionFile.block[2], of.data,
							OptionFile.block[2], OptionFile.blockSize[2]);
					System.arraycopy(of2.data, OptionFile.block[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data, OptionFile.block[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data, OptionFile.block[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
					System.arraycopy(of2.data, OptionFile.block[6], of.data,
							OptionFile.block[6], OptionFile.blockSize[6]);
					System.arraycopy(of2.data, OptionFile.block[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data, OptionFile.block[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
					//System.arraycopy(of2.data, 654732, of.data, 654732, 828);
					System.arraycopy(of2.data, 645804, of.data, 645804, 828); //offset
				} else {
					System.arraycopy(of2.data13, OptionFile.block13[2], of.data,
							OptionFile.block[2], OptionFile.blockSize[2]);
					System.arraycopy(of2.data13, OptionFile.block13[3], of.data,
							OptionFile.block[3], OptionFile.blockSize[3]);
					System.arraycopy(of2.data13, OptionFile.block13[4], of.data,
							OptionFile.block[4], OptionFile.blockSize[4]);
					System.arraycopy(of2.data13, OptionFile.block13[5], of.data,
							OptionFile.block[5], OptionFile.blockSize[5]);
					System.arraycopy(of2.data13, OptionFile.block13[6], of.data,
							OptionFile.block[6], OptionFile.blockSize[6]);
					System.arraycopy(of2.data13, OptionFile.block13[7], of.data,
							OptionFile.block[7], OptionFile.blockSize[7]);
					System.arraycopy(of2.data13, OptionFile.block13[8], of.data,
							OptionFile.block[8], OptionFile.blockSize[8]);
					System.arraycopy(of2.data13, 654732, of.data, 645804, 828); //offset
				}

				/*
				 * if (!of.isWE() && of2.isWE()) { Convert.allKitModel(of);
				 * Convert.allPlayers(of, Convert.WE2007_PES6); } if (of.isWE()
				 * && !of2.isWE()) { Convert.allPlayers(of,
				 * Convert.PES6_WE2007); }
				 */

				flagPanel.refresh();
				imagePanel.refresh();
				tranPanel.refresh();
				stadPan.refresh();
				teamPan.refresh();
				leaguePan.refresh();
				importPanel.disableAll();
				convertItem.setEnabled(false);
			}
		});

		menu.add(openItem);
		menu.add(open2Item);
		menu.add(saveItem);
		menu.add(saveAsItem);
		menu.add(new JSeparator());
		menu.add(openItemD);
		menu.add(open2ItemD);
		menu.add(saveAsItemD);
		menu.add(savePara);
		menu.add(new JSeparator());
		menu.add(open2013Item);
		menu.add(saveAsItem13);
		menu.add(savePara13);
		menu.add(new JSeparator());
		menu.add(open2012Item);
		menu.add(saveAsItem12);
		menu.add(savePara12);
		menu.add(new JSeparator());
		menu.add(open2011Item);
		menu.add(saveAsItem11);
		menu.add(savePara11);
		menu.add(new JSeparator());
		menu.add(open2010Item);
		menu.add(saveAsItem10);
		menu.add(savePara10);
		menu.add(new JSeparator());
		menu.add(open2009Item);
		menu.add(new JSeparator());
		menu.add(open2008Item);
		menu.add(new JSeparator());
		menu.add(open6Item);
		menu.add(new JSeparator());
		menu.add(open5Item);
		menu.add(new JSeparator());
		menu.add(exitItem);
		help.add(helpItem);
		help.add(aboutItem);
		tool.add(csvItem);
		tool.add(psdItem);
		tool.add(convertItem);
		mb.add(menu);
		mb.add(tool);
		mb.add(help);
		setJMenuBar(mb);
		csvItem.setEnabled(false);
		psdItem.setEnabled(false);
		open2Item.setEnabled(false);
		open2ItemD.setEnabled(false);
		open2013Item.setEnabled(false);
		open2012Item.setEnabled(false);
		open2011Item.setEnabled(false);
		open2010Item.setEnabled(false);
		open2009Item.setEnabled(false);
		open2008Item.setEnabled(false);
		open6Item.setEnabled(false);
		open5Item.setEnabled(false);
		saveItem.setEnabled(false);
		saveAsItem.setEnabled(false);
		saveAsItem13.setEnabled(false);
		saveAsItem12.setEnabled(false);
		saveAsItem11.setEnabled(false);
		saveAsItem10.setEnabled(false);
		saveAsItemD.setEnabled(false);
		savePara.setEnabled(false);
		savePara13.setEnabled(false);
		savePara12.setEnabled(false);
		savePara11.setEnabled(false);
		savePara10.setEnabled(false);
		convertItem.setEnabled(false);
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

	private void saveFailMsg() {
		JOptionPane.showMessageDialog(getContentPane(), "Save failed!", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	private void openFailMsg() {
		JOptionPane.showMessageDialog(getContentPane(), "Unable to open file",
				"Erro", JOptionPane.ERROR_MESSAGE);
	}

	private void saveOkMsg(File dest) {
		JOptionPane.showMessageDialog(getContentPane(), dest.getName()
				+ "\nSaved in:\n" + dest.getParent(),
				"File saved successfully", JOptionPane.INFORMATION_MESSAGE);
	}

	private void saveParaOkMsg(File dest) {
		JOptionPane.showMessageDialog(getContentPane(), "Export Database from PES 2014"
				+ "\nSaved in:\n" + dest.getParent(),
				"File saved successfully", JOptionPane.INFORMATION_MESSAGE);
	}

	
	private void savePara13OkMsg(File dest) {
		JOptionPane.showMessageDialog(getContentPane(), "Export Database from PES 2013"
				+ "\nSaved in:\n" + dest.getParent(),
				"File saved successfully", JOptionPane.INFORMATION_MESSAGE);
	}
	private void savePara12OkMsg(File dest) {
		JOptionPane.showMessageDialog(getContentPane(), "Export Database from PES 2012"
				+ "\nSaved in:\n" + dest.getParent(),
				"File saved successfully", JOptionPane.INFORMATION_MESSAGE);
	}
	private void savePara11OkMsg(File dest) {
		JOptionPane.showMessageDialog(getContentPane(), "Export Database from PES 2011"
				+ "\nSaved in:\n" + dest.getParent(),
				"File saved successfully", JOptionPane.INFORMATION_MESSAGE);
	}
	private void savePara10OkMsg(File dest) {
		JOptionPane.showMessageDialog(getContentPane(), "Export Database from PES 2010"
				+ "\nSaved in:\n" + dest.getParent(),
				"File saved successfully", JOptionPane.INFORMATION_MESSAGE);
	}

	private void illNameMsg() {
		JOptionPane
				.showMessageDialog(
						getContentPane(),
						"The file name cannot contain the following characters:\n\\ / : * ? \" < > |",
						"Erro", JOptionPane.ERROR_MESSAGE);
	}

	 private void setIcon()
	  {
	    URL localURL = getClass().getResource("data/icon.png");
	    if (localURL != null)
	    {
	      ImageIcon localImageIcon = new ImageIcon(localURL);
	      setIconImage(localImageIcon.getImage());
	    }
	  }
	  
	  private ImageIcon getPesfanIcon()
	  {
	    ImageIcon localImageIcon = null;
	    URL localURL = getClass().getResource("data/icon.png");
	    if (localURL != null) {
	      localImageIcon = new ImageIcon(localURL);
	    }
	    return localImageIcon;
	  }
	  
	  private ImageIcon getIcon()
	  {
	    ImageIcon localImageIcon = null;
	    URL localURL = getClass().getResource("data/icon.png");
	    if (localURL != null) {
	      localImageIcon = new ImageIcon(localURL);
	    }
	    return localImageIcon;
	  }
	
	private void openFile() {
		int returnVal = chooser.showOpenDialog(getContentPane());
		saveSet();
		if (returnVal == JFileChooser.APPROVE_OPTION
				&& filter.accept(chooser.getSelectedFile())) {
			if (chooser.getSelectedFile().isFile()
					&& of.readXPS(chooser.getSelectedFile())) {
				currentFile = chooser.getSelectedFile();
				setTitle(PesEditorTitle + " - " + currentFile.getName()); //version
				Squads.fixAll(of);
				flagPanel.refresh();
				imagePanel.refresh();
				tranPanel.refresh();
				wenShop.wenPanel.refresh();
				wenShop.shopPanel.status.setText("");
				stadPan.refresh();
				teamPan.refresh();
				leaguePan.refresh();
				tabbedPane.setVisible(true);
				importPanel.refresh();
				csvItem.setEnabled(true);
				psdItem.setEnabled(true);
				open2Item.setEnabled(true);
				open2ItemD.setEnabled(true);
				open2013Item.setEnabled(true);
				open2012Item.setEnabled(true);
				open2011Item.setEnabled(true);
				open2010Item.setEnabled(true);
				open2009Item.setEnabled(true);
				open2008Item.setEnabled(true);
				open6Item.setEnabled(true);
				open5Item.setEnabled(true);
				saveItem.setEnabled(true);
				saveAsItem.setEnabled(true);
				saveAsItem13.setEnabled(true);
				saveAsItem12.setEnabled(true);
				saveAsItem11.setEnabled(true);
				saveAsItem10.setEnabled(true);
				saveAsItemD.setEnabled(true);
				savePara.setEnabled(true);
				savePara13.setEnabled(true);
				savePara12.setEnabled(true);
				savePara11.setEnabled(true);
				savePara10.setEnabled(true);

				if (of2.fileName != null) {
					convertItem.setEnabled(true);
				} else {
					convertItem.setEnabled(false);
				}

			} else {
				csvItem.setEnabled(false);
				psdItem.setEnabled(false);
				open2Item.setEnabled(false);
				open2ItemD.setEnabled(false);
				open2013Item.setEnabled(false);
				open2012Item.setEnabled(false);
				open2011Item.setEnabled(false);
				open2010Item.setEnabled(false);
				open2009Item.setEnabled(false);
				open2008Item.setEnabled(false);
				open6Item.setEnabled(false);
				open5Item.setEnabled(false);
				saveItem.setEnabled(false);
				saveAsItem.setEnabled(false);
				saveAsItem13.setEnabled(false);
				saveAsItem12.setEnabled(false);
				saveAsItem11.setEnabled(false);
				saveAsItem10.setEnabled(false);
				saveAsItemD.setEnabled(false);
				savePara.setEnabled(false);
				savePara13.setEnabled(false);
				savePara12.setEnabled(false);
				savePara11.setEnabled(false);
				savePara10.setEnabled(false);
				tabbedPane.setVisible(false);

				convertItem.setEnabled(false);
				setTitle(PesEditorTitle); //version
				openFailMsg();
			}
		}
	}
	
	private void openFileD() {
		int returnVal = chooser.showOpenDialog(getContentPane());
		saveSet();
		if (returnVal == JFileChooser.APPROVE_OPTION
				&& filter.accept(chooser.getSelectedFile())) {
			if (chooser.getSelectedFile().isFile()
					&& of.readXPSD(chooser.getSelectedFile())) {
				currentFile = chooser.getSelectedFile();
				setTitle(PesEditorTitle + " - " + currentFile.getName()); //version
				Squads.fixAll(of);
				flagPanel.refresh();
				imagePanel.refresh();
				tranPanel.refresh();
				wenShop.wenPanel.refresh();
				wenShop.shopPanel.status.setText("");
				stadPan.refresh();
				teamPan.refresh();
				leaguePan.refresh();
				tabbedPane.setVisible(true);
				importPanel.refresh();
				csvItem.setEnabled(true);
				psdItem.setEnabled(true);
				open2Item.setEnabled(true);
				open2ItemD.setEnabled(true);
				open2013Item.setEnabled(true);
				open2012Item.setEnabled(true);
				open2011Item.setEnabled(true);
				open2010Item.setEnabled(true);
				open2009Item.setEnabled(true);
				open2008Item.setEnabled(true);
				open6Item.setEnabled(true);
				open5Item.setEnabled(true);
				saveItem.setEnabled(true);
				saveAsItem.setEnabled(true);
				saveAsItem13.setEnabled(true);
				saveAsItem12.setEnabled(true);
				saveAsItem11.setEnabled(true);
				saveAsItem10.setEnabled(true);
				saveAsItemD.setEnabled(true);
				savePara.setEnabled(true);
				savePara13.setEnabled(true);
				savePara12.setEnabled(true);
				savePara11.setEnabled(true);
				savePara10.setEnabled(true);

				if (of2.fileName != null) {
					convertItem.setEnabled(true);
				} else {
					convertItem.setEnabled(false);
				}

			} else {
				csvItem.setEnabled(false);
				psdItem.setEnabled(false);
				open2Item.setEnabled(false);
				open2ItemD.setEnabled(false);
				open2013Item.setEnabled(false);
				open2012Item.setEnabled(false);
				open2011Item.setEnabled(false);
				open2010Item.setEnabled(false);
				open2009Item.setEnabled(false);
				open2008Item.setEnabled(false);
				open6Item.setEnabled(false);
				open5Item.setEnabled(false);
				saveItem.setEnabled(false);
				saveAsItem.setEnabled(false);
				saveAsItem13.setEnabled(false);
				saveAsItem12.setEnabled(false);
				saveAsItem11.setEnabled(false);
				saveAsItem10.setEnabled(false);
				saveAsItemD.setEnabled(false);
				savePara.setEnabled(false);
				savePara13.setEnabled(false);
				savePara12.setEnabled(false);
				savePara11.setEnabled(false);
				savePara10.setEnabled(false);
				tabbedPane.setVisible(false);

				convertItem.setEnabled(false);
				setTitle(PesEditorTitle); //version
				openFailMsg();
			}
		}
	}

	private boolean saveSet() {
		boolean done = true;
		if (chooser.getCurrentDirectory() != null) {
			try {
				if (settingsFile.exists()) {
					settingsFile.delete();
				}
				FileOutputStream out = new FileOutputStream(settingsFile);
				ObjectOutputStream s = new ObjectOutputStream(out);
				s.writeObject(chooser.getCurrentDirectory());
				s.flush();
				s.close();
				out.close();
			} catch (IOException e) {
				done = false;
			}
		}
		return done;
	}

	private File loadSet() {
		File dir = null;
		if (settingsFile.exists()) {
			try {
				FileInputStream in = new FileInputStream(settingsFile);
				ObjectInputStream s = new ObjectInputStream(in);
				dir = (File) s.readObject();

				s.close();
				in.close();
				if (dir != null && !dir.exists()) {
					dir = null;
				}
			} catch (Exception e) {
			}
		} else {
			if (!about) {
				about();
				about = true;
			}
		}
		return dir;
	}
	private void about()
	  {
		JOptionPane.showMessageDialog(getContentPane(), PesEditorTitle + "\nVersion  9.1\n\nCopyright: 2014-2022 FabVitor\n\nCriado Por: Fábio Vitor\nFacebook: www.facebook.com/Fabcr7\nGmail: fabvitor2010@gmail.com\nHotmail: fabvitor2016@outlook.com\n\nAgradecimentos especiais ao Lazanet pelo port do mod PSD para o Pes Editor  9.1\n\nAgradecimentos especiais ao Nthachus pelo mod FACE, HAIR, SKIN\n\nEste Programa tem Software Livre, Você pode redistribuir e/ou Modificar\nSob os Termos da Licença (GNU Public)\n\nTendo um certificado, registrado e comprovado Por:\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.\n\nPara mais detalhes sobre a GNU General Public License: \nVocê deve ter recebido uma cópia da GNU General Public License\njuntamente com esse programa.  Se não, acesse: www.gnu.org/licenses.\n\nAgradecimentos Especiais (Compulsion):\nRobimex2002 por sua grande ajuda com Edições Hexadecimal\nUm Obrigado a Toda a Comunidade PES por seu Apoio!", "Sobre o " + PesEditorTitle, -1, getIcon());
	  }
	  
	  public static void main(String[] paramArrayOfString)
	    throws IOException
	  {
	    System.setProperty("swing.metalTheme", "steel");
	    new Editor();
	  }
	}

