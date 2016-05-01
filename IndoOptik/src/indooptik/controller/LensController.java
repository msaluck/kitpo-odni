/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.controller;

import indooptik.dao.DAOFactory;
import indooptik.dao.LensDAO;
import indooptik.internalframe.LensInternalFrame;
import indooptik.main.Main;
import indooptik.model.Lens;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Yoeda H
 */
public class LensController {

    private DefaultTableModel dtm;
    private JTable table;
    private TableRowSorter cek;
    LensInternalFrame lensInternalFrame;
    LensDAO lensDAO;

    public LensController(LensInternalFrame lensInternalFrame) {
        this.lensInternalFrame = lensInternalFrame;
        this.lensDAO = DAOFactory.create().getLensDAO();
        this.table = lensInternalFrame.getLensTabel();
        dtm = (DefaultTableModel) this.table.getModel();
        lensInternalFrame.getSearchTxt().getDocument().addDocumentListener(lensInternalFrame);
        cek = new TableRowSorter(dtm);
        lensInternalFrame.getLensTabel().setRowSorter(cek);

        addColors();
        addSph();
        addCyl();
        addAdd();
        showData();

        lensInternalFrame.getSphCmb().setEnabled(false);
        lensInternalFrame.getCylCmb().setEnabled(false);
        lensInternalFrame.getAddCmb().setEnabled(false);
    }

    public void showData() {
        List<Lens> listLens = lensDAO.retreiveALL();
        dtm.setRowCount(0);
        for (Lens lens : listLens) {
            Vector v = new Vector();
            v.add(lens.getIdLens());
            v.add(lens.getMaterialLens());
            v.add(lens.getType());
            v.add(lens.getColor());
            v.add(lens.getPrice());
            v.add(lens.getSph());
            v.add(lens.getCyl());
            v.add(lens.getAdd());
            v.add(lens.getMerk());
            v.add(lens.getStock());
            dtm.addRow(v);
        }
    }

    public void addColors() {
        List<String> listColor = lensDAO.retreiveALLColor();
        lensInternalFrame.getColorCmb().removeAllItems();
        lensInternalFrame.getColorCmb().addItem("Pilih...");
        for (String color : listColor) {
            lensInternalFrame.getColorCmb().addItem(color);
        }
    }

    public void addSph() {
        lensInternalFrame.getSphCmb().removeAllItems();
        for (String sph : Main.sph) {
            lensInternalFrame.getSphCmb().addItem(sph);
        }
        lensInternalFrame.getSphCmb().setSelectedIndex(60);
    }

    public void addCyl() {
        lensInternalFrame.getCylCmb().removeAllItems();
        lensInternalFrame.getCylCmb().addItem("Pilih...");
        for (String cyl : Main.cly) {
            lensInternalFrame.getCylCmb().addItem(cyl);
        }
        lensInternalFrame.getCylCmb().setSelectedIndex(0);
    }

    public void addAdd() {
        lensInternalFrame.getAddCmb().removeAllItems();
        lensInternalFrame.getAddCmb().addItem("Pilih...");
        for (String add : Main.add) {
            lensInternalFrame.getAddCmb().addItem(add);
        }
        lensInternalFrame.getAddCmb().setSelectedIndex(0);
    }

    public void reset() {
        lensInternalFrame.getLensMaterialTypeCmb().setSelectedIndex(0);
        lensInternalFrame.getLensTypeCmb().setSelectedIndex(0);
        lensInternalFrame.getColorCmb().setSelectedIndex(0);
        lensInternalFrame.getMerkTxt().setText("");
        lensInternalFrame.getSphCmb().setSelectedIndex(60);
        lensInternalFrame.getCylCmb().setSelectedIndex(0);
        lensInternalFrame.getAddCmb().setSelectedIndex(0);
        lensInternalFrame.getPriceTxt().setText("");
        lensInternalFrame.getStockTxt().setText("");
        lensInternalFrame.getSearchTxt().setText("");
        lensInternalFrame.getSphCmb().setEnabled(false);
        lensInternalFrame.getCylCmb().setEnabled(false);
        lensInternalFrame.getAddCmb().setEnabled(false);
        showData();
    }

    public void save() {
        if (lensInternalFrame.getLensMaterialTypeCmb().getSelectedIndex() > 0
                && lensInternalFrame.getLensTypeCmb().getSelectedIndex() > 0
                && lensInternalFrame.getColorCmb().getSelectedIndex() > 0
                && lensInternalFrame.getStockTxt().getText().trim().length() > 0) {

            Lens lens = new Lens();
            lens.setMaterialLens(lensInternalFrame.getLensMaterialTypeCmb().getSelectedItem().toString());
            lens.setType(lensInternalFrame.getLensTypeCmb().getSelectedItem().toString());
            lens.setColor(lensInternalFrame.getColorCmb().getSelectedItem().toString());
            lens.setMerk(lensInternalFrame.getMerkTxt().getText());
            if (lensInternalFrame.getSphCmb().isEnabled() == true) {
                lens.setSph(lensInternalFrame.getSphCmb().getSelectedItem().toString());
            } else {
                lens.setSph("");
            }
            if (lensInternalFrame.getCylCmb().isEnabled() == true && lensInternalFrame.getCylCmb().getSelectedIndex() > 0) {
                lens.setCyl(lensInternalFrame.getCylCmb().getSelectedItem().toString());
            } else {
                lens.setCyl("");
            }

            if (lensInternalFrame.getAddCmb().isEnabled() == true && lensInternalFrame.getAddCmb().getSelectedIndex() > 0) {
                lens.setAdd(lensInternalFrame.getAddCmb().getSelectedItem().toString());
            } else {
                lens.setAdd("");
            }

            if (lensInternalFrame.getPriceTxt().getText().trim().length() > 0) {
                lens.setPrice(new BigDecimal(lensInternalFrame.getPriceTxt().getText()));
            }

            lens.setStock(new Integer(lensInternalFrame.getStockTxt().getText()));

            if (lensDAO.insert(lens)) {
                JOptionPane.showMessageDialog(lensInternalFrame, "Data berhasil disimpan");
                reset();
            } else {
                JOptionPane.showMessageDialog(lensInternalFrame, "Data gagal disimpan");
            }

        } else {
            JOptionPane.showMessageDialog(lensInternalFrame, "Harap lengkapi data");
        }
    }

    public Lens chooseData() {
        resetWithoutShowData();
        int selectedRow = lensInternalFrame.getLensTabel().getSelectedRow();
        Lens lens = null;
        if (selectedRow > -1) {
            lens = new Lens();
            lens.setIdLens(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 0).hashCode());
            lens.setMaterialLens(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 1).toString());
            lens.setType(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 2).toString());
            lens.setColor(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 3).toString());
            lens.setPrice(new BigDecimal(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 4).toString()));
            lens.setSph(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 5).toString());
            lens.setCyl(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 6).toString());
            lens.setAdd(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 7).toString());
            lens.setMerk(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 8).toString());
            lens.setStock(new Integer(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 9).toString()));

            lensInternalFrame.getLensMaterialTypeCmb().setSelectedItem(lens.getMaterialLens());
            lensInternalFrame.getLensTypeCmb().setSelectedItem(lens.getType());
            lensInternalFrame.getColorCmb().setSelectedItem(lens.getColor());
            lensInternalFrame.getMerkTxt().setText(lens.getMerk());
            if (lens.getSph() != null && lens.getSph().trim().length() > 0) {
                lensInternalFrame.getSphCmb().setSelectedItem(lens.getSph());
            }
            if (lens.getCyl() != null && lens.getCyl().trim().length() > 0) {
                lensInternalFrame.getCylCmb().setSelectedItem(lens.getCyl());
            }
            if (lens.getAdd() != null && lens.getAdd().trim().length() > 0) {
                lensInternalFrame.getAddCmb().setSelectedItem(lens.getAdd());
            }
            lensInternalFrame.getPriceTxt().setText("" + lens.getPrice());
            lensInternalFrame.getStockTxt().setText(("" + lens.getStock()));
        }
        return lens;
    }

    public void edit() {
        int selectedRow = lensInternalFrame.getLensTabel().getSelectedRow();
        if (selectedRow > -1) {
            if (lensInternalFrame.getLensMaterialTypeCmb().getSelectedIndex() > 0
                    && lensInternalFrame.getLensTypeCmb().getSelectedIndex() > 0
                    && lensInternalFrame.getColorCmb().getSelectedIndex() > 0
                    && lensInternalFrame.getStockTxt().getText().trim().length() > 0) {

                Lens lens = new Lens();
                lens.setIdLens(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 0).hashCode());
                lens.setMaterialLens(lensInternalFrame.getLensMaterialTypeCmb().getSelectedItem().toString());
                lens.setType(lensInternalFrame.getLensTypeCmb().getSelectedItem().toString());
                lens.setColor(lensInternalFrame.getColorCmb().getSelectedItem().toString());
                lens.setMerk(lensInternalFrame.getMerkTxt().getText());
                if (lensInternalFrame.getSphCmb().isEnabled() == true) {
                    lens.setSph(lensInternalFrame.getSphCmb().getSelectedItem().toString());
                } else {
                    lens.setSph("");
                }
                if (lensInternalFrame.getCylCmb().isEnabled() == true && lensInternalFrame.getCylCmb().getSelectedIndex() > 0) {
                    lens.setCyl(lensInternalFrame.getCylCmb().getSelectedItem().toString());
                } else {
                    lens.setCyl("");
                }

                if (lensInternalFrame.getAddCmb().isEnabled() == true && lensInternalFrame.getAddCmb().getSelectedIndex() > 0) {
                    lens.setAdd(lensInternalFrame.getAddCmb().getSelectedItem().toString());
                } else {
                    lens.setAdd("");
                }

                if (lensInternalFrame.getPriceTxt().getText().trim().length() > 0) {
                    lens.setPrice(new BigDecimal(lensInternalFrame.getPriceTxt().getText()));
                }

                lens.setStock(new Integer(lensInternalFrame.getStockTxt().getText()));

                if (lensDAO.update(lens)) {
                    JOptionPane.showMessageDialog(lensInternalFrame, "Data berhasil diubah");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(lensInternalFrame, "Data gagal diubah");
                }

            } else {
                JOptionPane.showMessageDialog(lensInternalFrame, "Harap lengkapi data");
            }
        } else {
            JOptionPane.showMessageDialog(lensInternalFrame, "Harap pilih data yang akan di ubah");
        }
    }

    /*public void reset() {
     lensInternalFrame.getLensTypeTxt().setText("");
     lensInternalFrame.getLensVarianceTxt().setText("");
     lensInternalFrame.getLensSizeTxt().setText("");
     lensInternalFrame.getLensColorTxt().setText("");
     lensInternalFrame.getLensPriceTxt().setText("");
     lensInternalFrame.getLensPriceTxt().setText("");
     lensInternalFrame.getSphTxt().setText("");
     lensInternalFrame.getCylTxt().setText("");
     lensInternalFrame.getAddTxt().setText("");
     lensInternalFrame.getMerkTxt().setText("");        
     lensInternalFrame.getStockTxt().setText("");        
     lensInternalFrame.getSearchTxt().setText("");
     showData();
     }

     public void save() {
     if (lensInternalFrame.getLensTypeTxt().getText().trim().length() > 0 || lensInternalFrame.getLensVarianceTxt().getText().trim().length() > 0 && lensInternalFrame.getStockTxt().getText().trim().length() > 0) {
     Lens lens = new Lens();
     lens.setType(lensInternalFrame.getLensTypeTxt().getText());
     lens.setLensVariance(lensInternalFrame.getLensVarianceTxt().getText());
     lens.setSizeType(lensInternalFrame.getLensSizeTxt().getText());
     lens.setColor(lensInternalFrame.getLensColorTxt().getText());
     if (lensInternalFrame.getLensPriceTxt().getText().trim().length() > 0) {
     lens.setPrice(new BigDecimal(lensInternalFrame.getLensPriceTxt().getText()));
     }
     lens.setSph(lensInternalFrame.getSphTxt().getText());
     lens.setCyl(lensInternalFrame.getCylTxt().getText());
     lens.setAdd(lensInternalFrame.getAddTxt().getText());
     lens.setMerk(lensInternalFrame.getMerkTxt().getText());
     if(lensInternalFrame.getStockTxt().getText().trim().length() > 0){
     lens.setStock(new Integer(lensInternalFrame.getStockTxt().getText()));
     }else{
     lens.setStock(0);
     }
     lens.setCreatedDate(new Date());
     if (lensDAO.insert(lens)) {
     JOptionPane.showMessageDialog(lensInternalFrame, "Data berhasil disimpan");
     reset();
     } else {
     JOptionPane.showMessageDialog(lensInternalFrame, "Data gagal disimpan");
     }
     } else {
     JOptionPane.showMessageDialog(lensInternalFrame, "Harap lengkapi data sebelum simpan data");
     }
     }

     public Lens chooseData() {
     int selectedRow = lensInternalFrame.getLensTabel().getSelectedRow();
     Lens lens = null;
     if (selectedRow > -1) {
     lens = new Lens();
     lens.setIdLens(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 0).hashCode());
     lens.setType(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 1).toString());
     lens.setLensVariance(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 2).toString());
     lens.setSizeType(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 3).toString());
     lens.setColor(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 4).toString());
     lens.setPrice(new BigDecimal(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 5).toString()));
     lens.setSph(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 6).toString());
     lens.setCyl(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 7).toString());
     lens.setAdd(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 8).toString());
     lens.setMerk(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 9).toString());
     lens.setStock(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 10).hashCode());

     lensInternalFrame.getLensTypeTxt().setText(lens.getType());lensInternalFrame.getLensColorTxt().setText(lens.getColor());
     lensInternalFrame.getLensVarianceTxt().setText(lens.getLensVariance());
     lensInternalFrame.getLensSizeTxt().setText(lens.getSizeType());
     lensInternalFrame.getLensColorTxt().setText(lens.getColor());
     lensInternalFrame.getLensPriceTxt().setText("" + lens.getPrice());
     lensInternalFrame.getSphTxt().setText(lens.getSph());
     lensInternalFrame.getCylTxt().setText(lens.getCyl());
     lensInternalFrame.getAddTxt().setText(lens.getAdd());
     lensInternalFrame.getMerkTxt().setText(lens.getMerk());
     lensInternalFrame.getStockTxt().setText(""+lens.getStock());
     }
     return lens;
     }

     public void edit() {
     int selectedRow = lensInternalFrame.getLensTabel().getSelectedRow();
     if (selectedRow > -1) {
     if (lensInternalFrame.getLensTypeTxt().getText().trim().length() > 0 || lensInternalFrame.getLensVarianceTxt().getText().trim().length() > 0) {
     Lens lens = new Lens();
     lens.setIdLens(lensInternalFrame.getLensTabel().getValueAt(selectedRow, 0).hashCode());
     lens.setType(lensInternalFrame.getLensTypeTxt().getText());
     lens.setLensVariance(lensInternalFrame.getLensVarianceTxt().getText());
     lens.setSizeType(lensInternalFrame.getLensSizeTxt().getText());
     lens.setColor(lensInternalFrame.getLensColorTxt().getText());
     lens.setPrice(new BigDecimal(lensInternalFrame.getLensPriceTxt().getText()));
     lens.setCreatedDate(new Date());
     lens.setSph(lensInternalFrame.getSphTxt().getText());
     lens.setCyl(lensInternalFrame.getCylTxt().getText());
     lens.setAdd(lensInternalFrame.getAddTxt().getText());
     lens.setMerk(lensInternalFrame.getMerkTxt().getText());
     if(lensInternalFrame.getStockTxt().getText().trim().length() > 0){
     lens.setStock(new Integer(lensInternalFrame.getStockTxt().getText()));
     }else{
     lens.setStock(0);
     }
     if (lensDAO.update(lens)) {
     JOptionPane.showMessageDialog(lensInternalFrame, "Data berhasil diubah");
     reset();
     } else {
     JOptionPane.showMessageDialog(lensInternalFrame, "Data gagal diubah");
     }
     }else{
     JOptionPane.showMessageDialog(lensInternalFrame, "Harap lengkapi data sebelum edit data");
     }
     } else {
     JOptionPane.showMessageDialog(lensInternalFrame, "Harap pilih data yang akan di ubah");
     }
     }*/
    public void delete() {
        Lens lens = chooseData();
        if (lens == null) {
            JOptionPane.showMessageDialog(lensInternalFrame, "Harap pilih data yang akan di hapus");
        } else {
            if (JOptionPane.showConfirmDialog(lensInternalFrame, "Anda yakin akan hapus data lensa tipe " + lens.getType() + "? ",
                    "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION) == 0) {
                if (lensDAO.delete(lens)) {
                    JOptionPane.showMessageDialog(lensInternalFrame, "Data berhasil dihapus");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(lensInternalFrame, "Data gagal dihapus");
                }
            }
        }
    }

    public void search() {
        RowFilter rf = null;
        rf = RowFilter.regexFilter(lensInternalFrame.getSearchTxt().getText(), 1, 2, 3, 5, 6, 7, 8, 9);
        cek.setRowFilter(rf);
    }

    public void chooseLensType() {
        String type = lensInternalFrame.getLensTypeCmb().getSelectedItem().toString();
        if (type.equals("SINGLE")) {
            lensInternalFrame.getSphCmb().setEnabled(true);
            lensInternalFrame.getCylCmb().setEnabled(true);
            lensInternalFrame.getAddCmb().setEnabled(false);
        } else if (type.equals("KRYPTOK") || type.equals("FLATTOP") || type.equals("PROGRESSIF")) {
            lensInternalFrame.getSphCmb().setEnabled(true);
            lensInternalFrame.getCylCmb().setEnabled(true);
            lensInternalFrame.getAddCmb().setEnabled(true);
        }/* else if (type.equals("FLATTOP")) {
            lensInternalFrame.getSphCmb().setEnabled(false);
            lensInternalFrame.getCylCmb().setEnabled(true);
            lensInternalFrame.getAddCmb().setEnabled(true);
        } else if (type.equals("PROGRESSIF")) {
            lensInternalFrame.getSphCmb().setEnabled(true);
            lensInternalFrame.getCylCmb().setEnabled(true);
            lensInternalFrame.getAddCmb().setEnabled(true);
        }*/ else {
            lensInternalFrame.getSphCmb().setEnabled(false);
            lensInternalFrame.getCylCmb().setEnabled(false);
            lensInternalFrame.getAddCmb().setEnabled(false);
        }
    }

    public void resetWithoutShowData() {
        lensInternalFrame.getLensMaterialTypeCmb().setSelectedIndex(0);
        lensInternalFrame.getLensTypeCmb().setSelectedIndex(0);
        lensInternalFrame.getColorCmb().setSelectedIndex(0);
        lensInternalFrame.getMerkTxt().setText("");
        lensInternalFrame.getSphCmb().setSelectedIndex(60);
        lensInternalFrame.getCylCmb().setSelectedIndex(0);
        lensInternalFrame.getAddCmb().setSelectedIndex(0);
        lensInternalFrame.getPriceTxt().setText("");
        lensInternalFrame.getStockTxt().setText("");
        lensInternalFrame.getSearchTxt().setText("");
        lensInternalFrame.getSphCmb().setEnabled(false);
        lensInternalFrame.getCylCmb().setEnabled(false);
        lensInternalFrame.getAddCmb().setEnabled(false);
    }
}
