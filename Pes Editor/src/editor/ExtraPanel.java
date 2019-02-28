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

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

public class ExtraPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OptionFile of;
	int player;

	JComboBox nationBox;

	JTextField faceField;
	
	JTextField famaField;
	
	JTextField callField;
	
	MapaCallname mapacall;
	
	JTextField faceTypeField;
	
	JComboBox faceBox;
	
	JComboBox skinBox;
	
	JComboBox cel1Box;
	
	JComboBox cel2Box;
	
	JButton callButton;
	
	JTextField FaceFieldBox;
	
	JTextField hairField;
	
	JCheckBox specHairCheck;
	GridBagConstraints localGridBagConstraints = new GridBagConstraints();
		
	public ExtraPanel(final Frame owner, OptionFile opf) {
		super(new GridLayout(0, 2));
		of = opf;
		setBorder(BorderFactory.createTitledBorder("Ajustes Extras"));
		// stats = s;
		callButton = new JButton("Mapa");
		callButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				new MapaCallname(owner,mapacall);
			}
		});
		
		nationBox = new JComboBox(Stats.nation);
		faceTypeField = new JTextField(2);
		faceField = new JTextField(2);
		faceField.setInputVerifier(new Verifierface());
		famaField = new JTextField(2);
		hairField = new JTextField(2);
		hairField.setInputVerifier(new Verifierhair());;
		callField = new JTextField(2);
		callField.setInputVerifier(new Verifiercall());
		specHairCheck = new JCheckBox("Especiais 2");
		JPanel localJPanel2 = new JPanel(new GridLayout(0, 2));
	    localJPanel2.add(hairField);
	    hairField.setToolTipText("ID: 1 (Bin 3988) / ID: 1800 (Bin 5987)");
	    localJPanel2.add(specHairCheck);
	   specHairCheck.setToolTipText("Marque essa opção para utilizar Hais Predefinidos");
	    add(localJPanel2, localGridBagConstraints);
	    JPanel localJPanel3 = new JPanel(new GridLayout(0, 2));
		faceBox = new JComboBox(Stats.MOD_FACE);
		skinBox = new JComboBox(Stats.MOD_SKIN);
		cel1Box = new JComboBox(Stats.MOD_CEL);
		cel2Box = new JComboBox(Stats.MOD_CEL);
		JPanel localJPanel4 = new JPanel(new GridLayout(0, 3));
		localJPanel4.add(faceField);
		localJPanel4.add(faceBox);
		localJPanel4.add(skinBox);
		faceField.setToolTipText("ID: 1 (Bin 1521) / ID: 1800 (Bin 3520)");
		JPanel localJPanel5 = new JPanel(new GridLayout(0, 2));
		localJPanel5.add(cel1Box);
		localJPanel5.add(cel2Box);
		JPanel localJPanel6 = new JPanel(new GridLayout(0, 2));
		localJPanel6.add(callField);
		callField.setToolTipText("Para desativar o CallName digite: 65535");
		localJPanel6.add(callButton);
		
		
		add(new JLabel("Face"));
		add(localJPanel4);
		add(new JLabel("Hair"));
		hairField.setToolTipText("ID: 1 (Bin 3988) / ID: 1800 (Bin 5987)");
		add(localJPanel2);
		add(new JLabel("Callname"));
		add(localJPanel6);
		add(new JLabel("Celebração"));
		add(localJPanel5);
		add(new JLabel("Fama"));
		famaField.setToolTipText("FamaA: 18487 / FamaB: 782 / FamaC: 49749 / FamaD: 12299 / Fama OFF: 21769");
		add(famaField);
		
		
		
		

	
		/*add(new JLabel("Growth"));
		add(growthBox);*/
	}

	public void load(int p) {
		player = p;
		//nationBox.setSelectedItem(Stats
		//		.getString(of, player, Stats.nationality));

		faceField.setText(Stats.getString(of, player, Stats.FACE_TYPE));
		famaField.setText(Stats.getString(of, player, Stats.fama));
		hairField.setText(Stats.getString(of, player, Stats.hair));
		specHairCheck.setSelected(Stats.getValue(of, player, Stats.SH2) != 0);
		callField.setText(Stats.getString(of, player, Stats.callName));
		faceBox.setSelectedItem(Stats.getString(of, player, Stats.faceType));
		skinBox.setSelectedItem(Stats.getString(of, player, Stats.SKIN2));
		cel1Box.setSelectedItem(Stats.getString(of, player, Stats.CEL1));
		cel2Box.setSelectedItem(Stats.getString(of, player, Stats.CEL2));
	}
	
	public void stateChanged(ChangeEvent evt) {
		String s;
		if (specHairCheck.isSelected()) {
			s = null;
		} 
		
	}
	
	class Verifierskin extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 1 && v <= 6) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
	
	class Verifierface extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 1 && v <= 4095) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
	
	class Verifierhair extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 1 && v <= 4095) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
	
	public JCheckBox getSpecHairCheck() {
		return specHairCheck;
	}
	class VerifierWeight extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 1 && v < 128) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}

	class VerifierAge extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 15 && v <= 46) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
	class Verifiercall extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 0 && v <= 65535) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
	class Verifierfama extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 0 && v <= 65535) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
	class Verifiercel extends InputVerifier {
		public boolean verify(JComponent input) {
			boolean ok = false;
			JTextField tf = (JTextField) input;
			try {
				int v = new Integer(tf.getText()).intValue();
				if (v >= 0 && v <= 80) {
					ok = true;
				}
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			return ok;
		}
	}
}
