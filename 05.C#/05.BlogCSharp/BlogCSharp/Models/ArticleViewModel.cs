namespace BlogCSharp.Models
{
    using System.ComponentModel.DataAnnotations;

    public class ArticleViewModel
    {
        public int Id { get; set; }

        [Required]
        [StringLength(255)]
        public string Title { get; set; }

        [Required]
        public string Content { get; set; }

        public string AuthorId { get; set; }
    }
}