import cc.chauncy.hoi4.UI.MainFrame
import org.pushingpixels.substance.api.skin.SubstanceChallengerDeepLookAndFeel
import org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel
import org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel

import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.UIManager
import javax.swing.plaf.nimbus.NimbusLookAndFeel

SwingUtilities.invokeLater(new Runnable() {
    void run() {
        UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel())
        mf = new MainFrame()
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        mf.setVisible(true)
    }
})