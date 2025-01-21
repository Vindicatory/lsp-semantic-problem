using OmniSharp.Extensions.LanguageServer.Protocol.Client.Capabilities;
using OmniSharp.Extensions.LanguageServer.Protocol.Document;
using OmniSharp.Extensions.LanguageServer.Protocol.Models;
using Range = OmniSharp.Extensions.LanguageServer.Protocol.Models.Range;


namespace SampleServer;

public class SemanticTokensHandler : SemanticTokensHandlerBase
{
   protected override SemanticTokensRegistrationOptions CreateRegistrationOptions(SemanticTokensCapability capability,
      ClientCapabilities clientCapabilities)
   {
      return new SemanticTokensRegistrationOptions
      {
         DocumentSelector = TextDocumentSelector.ForLanguage("testfiletype"),
         Legend = new SemanticTokensLegend
         {
            TokenTypes = Container.From(new []{new SemanticTokenType("TestToken")}),
            TokenModifiers = capability.TokenModifiers
         },
         Full = true
      };
   }

   protected override Task Tokenize(SemanticTokensBuilder builder, ITextDocumentIdentifierParams identifier,
      CancellationToken cancellationToken)
   {
      var range = new Range(1, 1, 1, 10);
      builder.Push(range, "TestToken");

      return Task.CompletedTask;
   }

   protected override Task<SemanticTokensDocument> GetSemanticTokensDocument(ITextDocumentIdentifierParams @params, CancellationToken cancellationToken)
   {
      return Task.FromResult(new SemanticTokensDocument(RegistrationOptions));
   }
}