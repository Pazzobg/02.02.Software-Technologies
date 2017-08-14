namespace BlogCSharp.Controllers
{
    using System.Web.Mvc;

    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return RedirectToAction("Index", "Article");
        }
    }
}