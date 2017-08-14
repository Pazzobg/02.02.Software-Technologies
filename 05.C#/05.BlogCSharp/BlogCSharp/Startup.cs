using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(BlogCSharp.Startup))]
namespace BlogCSharp
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
