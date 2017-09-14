namespace ShoppingList.Controllers
{
    using System.Linq;
    using System.Web.Mvc;
    using ShoppingList.Models;

    [ValidateInput(false)]
    public class ProductController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new ShoppingListDbContext())
            {
                var products = db.Products.ToList();
                return View(products);
            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Product product)
        {
            if (ModelState.IsValid)
            {
                using (var db = new ShoppingListDbContext())
                {
                    db.Products.Add(product);
                    db.SaveChanges();
                }

                return RedirectToAction("Index");
            }

            return View(product);
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            using (var db = new ShoppingListDbContext())
            {
                var productForEdit = db.Products.Find(id);

                if (productForEdit == null)
                {
                    return HttpNotFound();
                }

                return View(productForEdit);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Product editedProductModel)
        {
            if (ModelState.IsValid)
            {
                using (var db = new ShoppingListDbContext())
                {
                    var productFromDb = db.Products.Find(id);

                    if (productFromDb == null)
                    {
                        return HttpNotFound();
                    }

                    productFromDb.Priority = editedProductModel.Priority;
                    productFromDb.Name = editedProductModel.Name;
                    productFromDb.Quantity = editedProductModel.Quantity;
                    productFromDb.Status = editedProductModel.Status;
                    db.SaveChanges();
                }
            }

            return RedirectToAction("Index");
        }
    }
}