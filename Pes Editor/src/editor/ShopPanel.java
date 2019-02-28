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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OptionFile of;

	JLabel status;

	JButton lock;
	JButton unlock;

	public ShopPanel(OptionFile opf) {
		super();
		of = opf;
		JPanel pan = new JPanel(new GridLayout(0, 1));
		pan.setBorder(BorderFactory.createTitledBorder("Shop Items"));
		JPanel bpan = new JPanel();
		status = new JLabel("");
		
		 lock = new JButton("Lock"); lock.addActionListener(new
		 ActionListener() { public void actionPerformed (ActionEvent l) {
		 of.data[5144] = 0; of.data[5145] = 0; of.data[5146] = 0;
		 of.data[5148] = 0; of.data[5149] = 0; of.data[5150] = 0;
		 of.data[5151] = 0; of.data[5152] = 0; of.data[5153] = 0;
		 of.data[5154] = 0; of.data[5155] = 0; of.data[5156] = 0;
		 of.data[5157] = 0; of.data[5158] = 0; of.data[5159] = 0;
		 of.data[5160] = 0; of.data[5161] = 0; of.data[5162] = 0;
		 of.data[5163] = 0; of.data[5164] = 0; of.data[52] = 0;
		 status.setText("Locked"); } });
		 
		unlock = new JButton("Unlock");
		unlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent u) {
				for (int i = 0; i < 20; i++) {
					of.data[5144 + i] = -1;
				}
				//of.data[5164] = 56;
				of.data[5136] = 108; //offset
				//of.data[5165] = 9;
				of.data[5137] = -101; //offset
				//of.data[5166] = -2;
				of.data[5138] = 38; //offset
				//of.data[5167] = -1;
				of.data[5139] = -23; //offset
				//of.data[5168] = -49;
				of.data[5140] = 0; //offset
				//of.data[5169] = 127;
				of.data[5141] = 2; //offset
				
				of.data[5144] = (byte) 255; //offset
				of.data[5145] = (byte) 255; //offset
				of.data[5146] = (byte) 255; //offset
				of.data[5147] = (byte) 255; //offset
				of.data[5148] = (byte) 255; //offset
				of.data[5149] = (byte) 255; //offset
				of.data[5150] = (byte) 255; //offset
				of.data[5151] = (byte) 255; //offset
				of.data[5152] = (byte) 255; //offset
				of.data[5153] = (byte) 255; //offset
				of.data[5154] = (byte) 255; //offset
				of.data[5155] = (byte) 255; //offset
				of.data[5156] = (byte) 255; //offset
				of.data[5157] = (byte) 255; //offset
				of.data[5158] = (byte) 255; //offset
				of.data[5159] = (byte) 255; //offset
				of.data[5160] = (byte) 255; //offset
				of.data[5161] = (byte) 255; //offset
				of.data[5162] = (byte) 255; //offset
				of.data[5163] = (byte) 255; //offset
				of.data[5164] = 56; //offset
				of.data[5165] = 9; //offset
				of.data[5166] = (byte) 254; //offset
				of.data[5167] = (byte) 255; //offset
				of.data[5168] = 64; //offset
				of.data[5169] = 127; //offset
				
				of.data[56] = 97; //offset
				status.setText("Unlocked");
			}
		});
		bpan.add(lock);
		bpan.add(unlock);
		pan.add(bpan);
		pan.add(status);
		add(pan);
	}

}
