package typealiasproblem.sample

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider


@Suppress("UnstableApiUsage")
class SampleServerSupportProvider : LspServerSupportProvider {
   override fun fileOpened(
      project: Project,
      file: VirtualFile,
      serverStarter: LspServerSupportProvider.LspServerStarter
   ) {
      val lspServerDescriptor = SampleServerDescriptor(project)
      serverStarter.ensureServerStarted(lspServerDescriptor)
   }
}
