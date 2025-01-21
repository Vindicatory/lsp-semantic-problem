package typealiasproblem.sample

import com.intellij.lang.xml.XMLLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.ui.IconManager
import com.intellij.ui.PlatformIcons
import javax.swing.Icon

class SampleFileType : LanguageFileType(XMLLanguage.INSTANCE) { // works fine with PlainTextLanguage

    companion object {
        val INSTANCE: SampleFileType = SampleFileType()
    }

    override fun getName(): String { return "SampleFileType" }
    override fun getDescription(): String {
        return "Sample file type"
    }

    override fun getDefaultExtension(): String {
        return "testfiletype"
    }

    override fun getIcon(): Icon {
        return IconManager.getInstance().getPlatformIcon(PlatformIcons.TextFileType);
    }
}