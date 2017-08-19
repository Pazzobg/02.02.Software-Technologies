namespace IMDB.Controllers
{
    using System.Linq;
    using System.Net;
    using System.Web.Mvc;
    using IMDB.Models;

    [ValidateInput(false)]
    public class FilmController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new IMDBDbContext())
            {
                var movies = db.Movies.ToList();
                return View(movies);
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
        public ActionResult Create(Film film)
        {
            if (ModelState.IsValid)
            {
                using (var db = new IMDBDbContext())
                {
                    db.Movies.Add(film);
                    db.SaveChanges();
                }

                return RedirectToAction("Index");
            }

            return View(film);
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var movieForEdit = db.Movies.Find(id);

                if (movieForEdit == null)
                {
                    return HttpNotFound();
                }

                return View(movieForEdit);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Film editedFilmModel)
        {
            if (ModelState.IsValid)
            {
                using (var db = new IMDBDbContext())
                {
                    var movieFromDb = db.Movies.Find(id);

                    if (movieFromDb == null)
                    {
                        return HttpNotFound();
                    }

                    movieFromDb.Name = editedFilmModel.Name;
                    movieFromDb.Genre = editedFilmModel.Genre;
                    movieFromDb.Director = editedFilmModel.Director;
                    movieFromDb.Year = editedFilmModel.Year;

                    db.SaveChanges();
                }
            }

            return RedirectToAction("Index");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var movieToDelete = db.Movies.Find(id);

                if (movieToDelete == null)
                {
                    return HttpNotFound();
                }

                return View(movieToDelete);
            }
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var movieToDelete = db.Movies.Find(id);

                if (movieToDelete == null)
                {
                    return HttpNotFound();
                }

                db.Movies.Remove(movieToDelete);
                db.SaveChanges();
            }

            return RedirectToAction("Index");
        }
    }
}