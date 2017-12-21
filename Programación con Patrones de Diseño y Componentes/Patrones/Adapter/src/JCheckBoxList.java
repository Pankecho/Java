import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBoxList extends JList {

    DefaultListModel listModel = new DefaultListModel();

    public JCheckBoxList() {
        setModel(listModel);
        setCellRenderer(new CellRenderer());
        System.out.println("SET CELL RENDERER");
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int index = locationToIndex(e.getPoint());

                if (index != -1) {
                    JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
                    checkbox.setSelected(!checkbox.isSelected());
                    repaint();
                }
            }
        });
    }

   protected class CellRenderer implements ListCellRenderer
   {

        public CellRenderer() {
            System.out.println("CREATED RENDERER");
        }

      public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus)
      {
         JCheckBox checkbox = (JCheckBox) value;
         checkbox.setBackground(isSelected ?
                 getSelectionBackground() : getBackground());
         checkbox.setForeground(isSelected ?
                 getSelectionForeground() : getForeground());
         checkbox.setEnabled(isEnabled());
         checkbox.setFont(getFont());
         checkbox.setFocusPainted(false);
         checkbox.setBorderPainted(true);
        
         System.out.println("RETURNING A CHECKBOX");
         return checkbox;
      }
   }

    public static void main(String args[]) {
        
        JFrame frame = new JFrame("JList CheckBox Example");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);


        JPanel panel = new JPanel();
        JCheckBoxList myList = new JCheckBoxList();

        for(int i=0;i<10;i++){
            ((DefaultListModel) myList.getModel()).addElement(new JCheckBox("Box" + Integer.toString(i)));
            System.out.println("added BOX list ");
        }
  
        System.out.println("MODEL SIZE:" + ((DefaultListModel)myList.getModel()).size());
        panel.add(new JScrollPane(myList));


        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}