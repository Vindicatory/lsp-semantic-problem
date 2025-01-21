package typealiasproblem.sample
import com.intellij.execution.process.OSProcessHandler
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.intellij.platform.lsp.api.customization.LspSemanticTokensSupport
import com.intellij.openapi.editor.colors.TextAttributesKey

import com.intellij.platform.lsp.api.LspServerManager

@Suppress("UnstableApiUsage")
class SampleServerDescriptor(
   project: Project,
) : ProjectWideLspServerDescriptor(project, "Sample") {

   override fun isSupportedFile(file: VirtualFile): Boolean {
      return file.extension == "testfiletype"
   }

   override fun startServerProcess(): OSProcessHandler {
      val serverFile = File("C:\\SampleServer\\SampleServer.exe")
      // replace on any other path you want
      // and don't forget to shutdown it manually :)

      if (!serverFile.exists()) {
         throw Exception("ConfigFilesLanguageServer not found")
      }

      val fullPath = serverFile.absolutePath

      val process = ProcessBuilder(fullPath).start()
         ?: throw Exception("Unable to start lsp server process")

      return OSProcessHandler(process, "--idea")
   }

   val TestToken : String = "TestToken"

   override val lspSemanticTokensSupport = object : LspSemanticTokensSupport() {
      override val tokenTypes: List<String>
         get() = listOf(
            TestToken)

      override fun getTextAttributesKey(tokenType: String, modifiers: List<String>): TextAttributesKey? =
         when (tokenType) {
            TestToken -> DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
            else -> null
         }
   }
}
