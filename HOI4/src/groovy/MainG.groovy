import cc.chauncy.hoi4.UI.HOI4MainFrame
import org.pushingpixels.substance.api.skin.SubstanceDustLookAndFeel

import javax.swing.*

SwingUtilities.invokeLater(new Runnable() {
    void run() {
        UIManager.setLookAndFeel(new SubstanceDustLookAndFeel())
        mf = new HOI4MainFrame()
    }
})

