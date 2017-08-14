namespace BlogCSharp.Controllers
{
    using System.Data.Entity;
    using System.Linq;
    using System.Net;
    using System.Web.Mvc;
    using BlogCSharp.Models;
    using Microsoft.AspNet.Identity;

    public class ArticleController : Controller
    {
        // GET: Article
        public ActionResult Index()
        {
            using (var db = new BlogDbContext())
            {
                var articles = db.Articles.Include(a => a.Author).ToList();

                return View(articles);
            }
        }

        // GET: Article/Create
        [Authorize]
        [HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Article/Create
        [Authorize]
        [HttpPost]
        public ActionResult Create(Article article)
        {
            if (ModelState.IsValid)
            {
                using (var db = new BlogDbContext())
                {
                    var loggedUser = this.User.Identity.GetUserId();

                    article.AuthorId = loggedUser;

                    db.Articles.Add(article);
                    db.SaveChanges();
                }

                return RedirectToAction("Index");
            }

            return View(article);
        }

        // GET: Article/Details
        [HttpGet]
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Include(a => a.Author).Where(a => a.Id == id).FirstOrDefault();

                if (article == null)
                {
                    return HttpNotFound();
                }

                return View(article);
            }
        }

        // GET: Article/Delete
        [Authorize]
        [HttpGet]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var articleToBeDeleted = db.Articles.Find(id);

                if (articleToBeDeleted == null)
                {
                    return HttpNotFound();
                }

                return View(articleToBeDeleted);
            }
        }

        // POST: Article/Delete
        [Authorize]
        [HttpPost]
        [ActionName("Delete")]
        public ActionResult DeleteConfirmed(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var articleToBeDeleted = db.Articles.Find(id);

                if (!IsUserAuthorizedToEdit(articleToBeDeleted))
                {
                    return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                }
                
                if (articleToBeDeleted == null)
                {
                    return HttpNotFound();
                }

                db.Articles.Remove(articleToBeDeleted);
                db.SaveChanges();


                return RedirectToAction("Index");
            }
        }

        // GET: Article/Edit
        [Authorize]
        [HttpGet]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var articleForEdit = db.Articles.Find(id);

                if (articleForEdit == null)
                {
                    return HttpNotFound();
                }

                var model = new ArticleViewModel();
                model.Id = articleForEdit.Id;
                model.Title = articleForEdit.Title;
                model.Content = articleForEdit.Content;

                return View(model);
            }
        }

        // POST: Article/Edit
        [Authorize]
        [HttpPost]
        public ActionResult Edit(ArticleViewModel model)
        {
            if (ModelState.IsValid)
            {
                using (var db = new BlogDbContext())
                {
                    var article = db.Articles.FirstOrDefault(a => a.Id == model.Id);

                    if (!IsUserAuthorizedToEdit(article))
                    {
                        return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                    }
                    
                    article.Title = model.Title;
                    article.Content = model.Content;

                    db.Entry(article).State = EntityState.Modified;
                    db.SaveChanges();

                    return RedirectToAction("Details", new { id = model.Id });
                }
            }

            return View(model);
        }

        private bool IsUserAuthorizedToEdit(Article article)
        {
            bool isAdmin = this.User.IsInRole("Admin");
            bool isAuthor = article.IsAuthor(this.User.Identity.Name);

            return isAdmin || isAuthor;
        }
    }
}