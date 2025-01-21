using OmniSharp.Extensions.LanguageServer.Server;
using SampleServer;

public abstract class Program
{
    public static async Task Main()
    {
        var server = await LanguageServer.From(
            opts =>
                opts
                    .WithInput(Console.OpenStandardInput())
                    .WithOutput(Console.OpenStandardOutput())
                    .WithHandler<SemanticTokensHandler>()
        );
        
        await server.WaitForExit;
    }
}