# lsp-semantic-problem
Sample case with repro

You can use prebuilded .Net server (SampleServer\bin\Debug\net8.0\SampleServer.exe) and distribution (intellij-plugin-lsp-semantic-bug\build\distributions\intellij-plugin-lsp-semantic-bug.zip)
or build by yourself

## how to build (optionally):
1) build .Net lsp server: SampleServer\SampleServer.sln
2) move files from SampleServer\bin\Debug\net8.0\ to C:\SampleServer

## how to reproduce:
1) ensure you moved server from SampleServer\bin\Debug\net8.0\ to C:\SampleServer, or change location at SampleServerDescriptor.kt startServerProcess() func
2) open project intellij-plugin-lsp-semantic-bug and build with platform setting: create("IU", "2024.2.2")
3) ensure that highlight is working
4) build intellij-plugin-lsp-semantic-bug with setting: create("IU", "2024.3") and run
5) see that highlight is not working.
