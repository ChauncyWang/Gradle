package cc.chauncy.hoi4.UI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
/*
 * Created by JFormDesigner on Fri May 05 23:39:40 CST 2017
 */



/**
 * @author chauncy
 */
public class MainFrame extends JFrame {
	public MainFrame() {
		initComponents();
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("1");
		node.add(new DefaultMutableTreeNode("2"));
		node.add(new DefaultMutableTreeNode("3"));
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("1");
		node1.add(new DefaultMutableTreeNode("2"));
		node1.add(new DefaultMutableTreeNode("3"));
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("top");
		top.add(node);
		top.add(node1);
		tree1.setModel(new DefaultTreeModel(top));
	}

	private void newMod(ActionEvent e) {
		// TODO add your code here
	}

	private void loadMod(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menu2 = new JMenu();
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		scrollPane2 = new JScrollPane();
		tree1 = new JTree();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("\u6587\u4ef6");

				//---- menuItem1 ----
				menuItem1.setText("\u65b0\u5efamod");
				menuItem1.addActionListener(e -> newMod(e));
				menu1.add(menuItem1);

				//---- menuItem2 ----
				menuItem2.setText("\u52a0\u8f7dmod");
				menuItem2.addActionListener(e -> loadMod(e));
				menu1.add(menuItem2);
			}
			menuBar1.add(menu1);

			//======== menu2 ========
			{
				menu2.setText("\u5e2e\u52a9");
			}
			menuBar1.add(menu2);
		}
		setJMenuBar(menuBar1);

		//======== tabbedPane1 ========
		{
			tabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane1.setTabPlacement(SwingConstants.LEFT);

			//======== panel1 ========
			{
				panel1.setLayout(null);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("mod\u4fe1\u606f", panel1);

			//======== panel2 ========
			{
				panel2.setLayout(null);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel2.getComponentCount(); i++) {
						Rectangle bounds = panel2.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel2.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel2.setMinimumSize(preferredSize);
					panel2.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("\u56fd\u5bb6\u7126\u70b9\u4e00\u89c8", panel2);

			//======== panel3 ========
			{
				panel3.setLayout(null);

				//======== scrollPane1 ========
				{
					scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane1.setViewportView(list1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(5, 5, 700, 540);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel3.getComponentCount(); i++) {
						Rectangle bounds = panel3.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel3.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel3.setMinimumSize(preferredSize);
					panel3.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("modifiter\u4e00\u89c8", panel3);

			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(tree1);
			}
			tabbedPane1.addTab("text", scrollPane2);
		}
		contentPane.add(tabbedPane1);
		tabbedPane1.setBounds(0, 0, 800, 550);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenu menu2;
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JScrollPane scrollPane1;
	private JList list1;
	private JScrollPane scrollPane2;
	private JTree tree1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
