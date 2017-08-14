using System.Data.Entity;
using Microsoft.AspNet.Identity.EntityFramework;

namespace BlogCSharp.Models
{
    public class BlogDbContext : IdentityDbContext<ApplicationUser>
    {
        public BlogDbContext()
            : base("DefaultConnection", throwIfV1Schema: false)
        {
        }

        // с това казваме на Entity Framework, че имаме нов клас и ни тр нова таблица в базата
        public virtual IDbSet<Article> Articles { get; set; }

        public static BlogDbContext Create()
        {
            return new BlogDbContext();
        }
    }
}