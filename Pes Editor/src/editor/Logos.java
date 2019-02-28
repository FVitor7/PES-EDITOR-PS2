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

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Logos {
	static final byte total = 80; //offset

	//static final int startAdr = 866044;
	static final int startAdr = 857116; //offset

	static final int size = 608; //offset

	static final int paletteSize = 16; //offset

	static final int raster = 512; //offset

	static final int startAdr13 = 866044;

	static final int startAdr12 = 877172;

	static final int startAdr11 = 890804;

	static final int startAdr10 = 882340;

	static final int startAdr09 = 858024;

	static final int startAdr08 = 889896;

	static final int startAdr6 = 862492;

	static final int startAdr5 = 920540;

	static boolean isUsed(OptionFile of, int slot) {
		boolean used = false;
		if (of.newVersion) {
			if (of.data[startAdr + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version13) {
			if (of.data13[startAdr13 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version12) {
			if (of.data12[startAdr12 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version11) {
			if (of.data11[startAdr11 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version10) {
			if (of.data10[startAdr10 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version09) {
			if (of.data09[startAdr09 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version08) {
			if (of.data08[startAdr08 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version6) {
			if (of.data6[startAdr6 + (slot * size)] == 1) {
				used = true;
			}
		} else if (of.version5) {
			if (of.data5[startAdr5 + (slot * size)] == 1) {
				used = true;
			}
		}
		return used;
	}

	static BufferedImage get(OptionFile of, int slot, boolean opaque) {
		byte[] red = new byte[paletteSize];
		byte[] green = new byte[paletteSize];
		byte[] blue = new byte[paletteSize];
		byte[] alpha = new byte[paletteSize];
		byte[] pixel = new byte[raster];
		int a;
		if (slot >= 0 && slot < total && isUsed(of, slot)) {
			for (int c = 0; c < paletteSize; c++) {
				if (of.newVersion) {
					a = startAdr + 32 + (slot * size) + (c * 4);
					red[c] = of.data[a];
					green[c] = of.data[a + 1];
					blue[c] = of.data[a + 2];
					alpha[c] = of.data[a + 3];
				} else if (of.version13) {
					a = startAdr13 + 32 + (slot * size) + (c * 4);
					red[c] = of.data13[a];
					green[c] = of.data13[a + 1];
					blue[c] = of.data13[a + 2];
					alpha[c] = of.data13[a + 3];
				} else if (of.version12) {
					a = startAdr12 + 32 + (slot * size) + (c * 4);
					red[c] = of.data12[a];
					green[c] = of.data12[a + 1];
					blue[c] = of.data12[a + 2];
					alpha[c] = of.data12[a + 3];
				} else if (of.version11) {
					a = startAdr11 + 32 + (slot * size) + (c * 4);
					red[c] = of.data11[a];
					green[c] = of.data11[a + 1];
					blue[c] = of.data11[a + 2];
					alpha[c] = of.data11[a + 3];
				} else if (of.version10) {
					a = startAdr10 + 32 + (slot * size) + (c * 4);
					red[c] = of.data10[a];
					green[c] = of.data10[a + 1];
					blue[c] = of.data10[a + 2];
					alpha[c] = of.data10[a + 3];
				} else if (of.version09) {
					a = startAdr09 + 32 + (slot * size) + (c * 4);
					red[c] = of.data09[a];
					green[c] = of.data09[a + 1];
					blue[c] = of.data09[a + 2];
					alpha[c] = of.data09[a + 3];
				} else if (of.version08) {
					a = startAdr08 + 32 + (slot * size) + (c * 4);
					red[c] = of.data08[a];
					green[c] = of.data08[a + 1];
					blue[c] = of.data08[a + 2];
					alpha[c] = of.data08[a + 3];
				} else if (of.version6) {
					a = startAdr6 + 32 + (slot * size) + (c * 4);
					red[c] = of.data6[a];
					green[c] = of.data6[a + 1];
					blue[c] = of.data6[a + 2];
					alpha[c] = of.data6[a + 3];
				} else if (of.version5) {
					a = startAdr5 + 32 + (slot * size) + (c * 4);
					red[c] = of.data5[a];
					green[c] = of.data5[a + 1];
					blue[c] = of.data5[a + 2];
					alpha[c] = of.data5[a + 3];
				}
			}
			if (of.newVersion) {
				a = startAdr + 96 + (slot * size);
				System.arraycopy(of.data, a, pixel, 0, raster);
			} else if (of.version13) {
				a = startAdr13 + 96 + (slot * size);
				System.arraycopy(of.data13, a, pixel, 0, raster);
			} else if (of.version12) {
				a = startAdr12 + 96 + (slot * size);
				System.arraycopy(of.data12, a, pixel, 0, raster);
			} else if (of.version11) {
				a = startAdr11 + 96 + (slot * size);
				System.arraycopy(of.data11, a, pixel, 0, raster);
			} else if (of.version10) {
				a = startAdr10 + 96 + (slot * size);
				System.arraycopy(of.data10, a, pixel, 0, raster);
			} else if (of.version09) {
				a = startAdr09 + 96 + (slot * size);
				System.arraycopy(of.data09, a, pixel, 0, raster);
			} else if (of.version08) {
				a = startAdr08 + 96 + (slot * size);
				System.arraycopy(of.data08, a, pixel, 0, raster);
			} else if (of.version6) {
				a = startAdr6 + 96 + (slot * size);
				System.arraycopy(of.data6, a, pixel, 0, raster);
			} else if (of.version5) {
				a = startAdr5 + 96 + (slot * size);
				System.arraycopy(of.data5, a, pixel, 0, raster);
			}
			if (opaque) {
				for (int i = 0; i < paletteSize; i++) {
					alpha[i] = -1;
				}
			}
		}
		IndexColorModel colorModel = new IndexColorModel(4, paletteSize, red,
				green, blue, alpha);
		DataBufferByte dbuf = new DataBufferByte(pixel, raster, 0);
		MultiPixelPackedSampleModel sampleModel = new MultiPixelPackedSampleModel(
				DataBuffer.TYPE_BYTE, 32, 32, 4);
		WritableRaster raster = Raster.createWritableRaster(sampleModel, dbuf,
				null);
		BufferedImage image = new BufferedImage(colorModel, raster, false, null);
		return image;
	}

	static boolean set(OptionFile of, int slot, BufferedImage image) {
		boolean ok = false;
		try {
			byte[] red = new byte[256];
			byte[] green = new byte[256];
			byte[] blue = new byte[256];
			byte[] alpha = new byte[256];
			int[] pix = new int[1024];
			int a;
			Raster rast = image.getData();
			ColorModel colorMod = image.getColorModel();

			if (colorMod instanceof IndexColorModel) {
				IndexColorModel index = (IndexColorModel) colorMod;
				if (image.getWidth() == 32 && image.getHeight() == 32) {
					rast.getPixels(0, 0, 32, 32, pix);
					index.getReds(red);
					index.getGreens(green);
					index.getBlues(blue);
					index.getAlphas(alpha);

					if (alpha[0] != 0) {
						int swap = 0;
						byte tr;
						byte tg;
						byte tb;
						byte ta;
						for (int c = 1; c < 16; c++) {
							if (swap == 0 && alpha[c] == 0) {
								swap = c;
							}
						}
						if (swap != 0) {
							tr = red[0];
							tg = green[0];
							tb = blue[0];
							ta = alpha[0];
							// System.out.println(red[3] + ", " + green[3] + ",
							// " + blue[3]);
							red[0] = red[swap];
							green[0] = green[swap];
							blue[0] = blue[swap];
							alpha[0] = 0;
							red[swap] = tr;
							green[swap] = tg;
							blue[swap] = tb;
							alpha[swap] = ta;

							for (int p = 0; p < 1024; p++) {
								if (pix[p] == 0) {
									pix[p] = swap;
								} else if (pix[p] == swap) {
									pix[p] = 0;
								}
							}
							// System.out.println(swap);
						}
					}

					for (int c = 0; c < paletteSize; c++) {
						if (of.newVersion) {
							a = startAdr + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version13) {
							a = startAdr13 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version12) {
							a = startAdr12 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version11) {
							a = startAdr11 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version10) {
							a = startAdr10 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version09) {
							a = startAdr09 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version08) {
							a = startAdr08 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version6) {
							a = startAdr6 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						} else if (of.version5) {
							a = startAdr5 + 32 + (slot * size) + (c * 4);
							of.data[a] = red[c];
							of.data[a + 1] = green[c];
							of.data[a + 2] = blue[c];
							of.data[a + 3] = alpha[c];
						}
					}

					for (int p = 0; p < 1024; p = p + 2) {
						if (of.newVersion) {
							a = startAdr + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version13) {
							a = startAdr13 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version12) {
							a = startAdr12 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version11) {
							a = startAdr11 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version10) {
							a = startAdr10 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version09) {
							a = startAdr09 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version08) {
							a = startAdr08 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version6) {
							a = startAdr6 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						} else if (of.version5) {
							a = startAdr5 + 96 + (slot * size) + (p / 2);
							of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
						}
					}
					of.data[startAdr + (slot * size)] = 1;
					ok = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	static void importLogo(OptionFile ofS, int slotS, OptionFile ofD, int slotD) {
		int aS = 0;
		if (ofS.newVersion)
			aS = startAdr + (slotS * size);
		else if (ofS.version13)
			aS = startAdr13 + (slotS * size);
		else if (ofS.version12)
			aS = startAdr12 + (slotS * size);
		else if (ofS.version11)
			aS = startAdr11 + (slotS * size);
		else if (ofS.version10)
			aS = startAdr10 + (slotS * size);
		else if (ofS.version09)
			aS = startAdr09 + (slotS * size);
		else if (ofS.version08)
			aS = startAdr08 + (slotS * size);
		else if (ofS.version6)
			aS = startAdr6 + (slotS * size);
		else if (ofS.version5)
			aS = startAdr5 + (slotS * size);
		int aD = startAdr + (slotD * size);
		if (ofS.newVersion)
			System.arraycopy(ofS.data, aS, ofD.data, aD, size);
		else if (ofS.version13)
			System.arraycopy(ofS.data13, aS, ofD.data, aD, size);
		else if (ofS.version12)
			System.arraycopy(ofS.data12, aS, ofD.data, aD, size);
		else if (ofS.version11)
			System.arraycopy(ofS.data11, aS, ofD.data, aD, size);
		else if (ofS.version10)
			System.arraycopy(ofS.data10, aS, ofD.data, aD, size);
		else if (ofS.version09)
			System.arraycopy(ofS.data09, aS, ofD.data, aD, size);
		else if (ofS.version08)
			System.arraycopy(ofS.data08, aS, ofD.data, aD, size);
		else if (ofS.version6)
			System.arraycopy(ofS.data6, aS, ofD.data, aD, size);
		else if (ofS.version5)
			System.arraycopy(ofS.data5, aS, ofD.data, aD, size);
		//System.out.println(aS);
		//System.out.println(aD);
	}

	static void delete(OptionFile of, byte slot) {
		int a = startAdr + (slot * size);
		for (int i = 0; i < size; i++) {
			of.data[a + i] = 0;
		}
	}

}
