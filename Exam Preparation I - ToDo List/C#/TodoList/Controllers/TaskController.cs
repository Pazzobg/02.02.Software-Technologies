namespace TodoList.Controllers
{
    using System.Linq;
    using System.Web.Mvc;
    using TodoList.Models;

    [ValidateInput(false)]
    public class TaskController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new TodoListDbContext())
            {
                var tasks = db.Tasks.ToList();
                return View(tasks);
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
        public ActionResult Create(Task task)
        {
            if (ModelState.IsValid)
            {
                using (var db = new TodoListDbContext())
                {
                    db.Tasks.Add(task);
                    db.SaveChanges();
                }

                return RedirectToAction("Index");
            }

            return View(task);
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int id)
        {
            using (var db = new TodoListDbContext())
            {
                var taskToBeDeleted = db.Tasks.Find(id);

                if (taskToBeDeleted == null)
                {
                    return HttpNotFound();
                }

                return View(taskToBeDeleted);
            }
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int id)
        {
            using (var db = new TodoListDbContext())
            {
                var taskToBeDeleted = db.Tasks.Find(id);

                if (taskToBeDeleted == null)
                {
                    return HttpNotFound();
                }

                db.Tasks.Remove(taskToBeDeleted);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}