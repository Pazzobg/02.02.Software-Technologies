namespace Calculator_CSharp.Controllers
{
    using Calculator_CSharp.Models;
    using System;
    using System.Web.Mvc;

    public class HomeController : Controller
    {
        public ActionResult Index(Calculator calculator)
        {
            return View(calculator);
        }

        [HttpPost]
        public ActionResult Calculate(Calculator calculator)
        {
            calculator.Result = CalculateResult(calculator);

            return RedirectToAction("Index", calculator);
        }

        private decimal CalculateResult(Calculator calculator)
        {
            decimal result = 0;

            switch (calculator.Operator)
            {
                case "+":
                    result = calculator.LeftOperand + calculator.RightOperand;
                    break;
                case "-":
                    result = calculator.LeftOperand - calculator.RightOperand;
                    break;
                case "*":
                    result = calculator.LeftOperand * calculator.RightOperand;
                    break;
                case "/":
                    if (calculator.RightOperand != 0)
                    {
                        result = calculator.LeftOperand / calculator.RightOperand;
                    }
                    else
                    {
                        result = 0;
                    }
                    break;
                case "%":
                    if (calculator.RightOperand != 0)
                    {
                        result = calculator.LeftOperand % calculator.RightOperand;
                        break;
                    }
                    else
                    {
                        result = 0;
                        break;
                    }
                case "^":
                    result = (decimal)Math.Pow((double)calculator.LeftOperand, (double)calculator.RightOperand);
                    break;
                case "√":
                    result = (decimal)Math.Sqrt((double)calculator.LeftOperand);
                    break;
                case "AND":
                    result = (int)calculator.LeftOperand & (int)calculator.RightOperand;
                    break;
                case "OR":
                    result = (int)calculator.LeftOperand | (int)calculator.RightOperand;
                    break;
                case "XOR":
                    result = (int)calculator.LeftOperand ^ (int)calculator.RightOperand;
                    break;
            }
            
            return result; 
        }
    }
}