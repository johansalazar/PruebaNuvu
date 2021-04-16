using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace frontjava.Models
{
    public class Tarjeta
    {
        public int Id { get; set; }
        public string Numero { get; set; }
        public int Agno { get; set; }
        public int Mes { get; set; }        
        public int Codigo { get; set; }       
    }
}