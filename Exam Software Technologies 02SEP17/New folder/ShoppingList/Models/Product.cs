namespace ShoppingList.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.Web.Mvc;

    public class Product
    {
        public int Id { get; set; }

        [Required]
        public int Priority { get; set; }

        [Required]
        [AllowHtml]
        public string Name { get; set; }

        [Required]
        [AllowHtml]
        public int Quantity { get; set; }

        [Required]
        public string Status { get; set; }
    }
}