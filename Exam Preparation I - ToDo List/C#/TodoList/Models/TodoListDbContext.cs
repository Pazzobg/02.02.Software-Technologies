namespace TodoList.Models
{
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Linq;
    using System.Web;

    public class TodoListDbContext : DbContext
    {
        public virtual IDbSet<Task> Tasks { get; set; }

        public TodoListDbContext() : base("TodoListDb")
        {
        }
    }
}