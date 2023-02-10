/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifndb;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Reale
 */
public class NonModificabileJDialog extends JDialog {
  public NonModificabileJDialog(JFrame frame, String title, boolean modal) {
    super(frame, title, modal);
  }

  @Override
  public void setModal(boolean modal) {
    super.setModal(true);
  }
}
