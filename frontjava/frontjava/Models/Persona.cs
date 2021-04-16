using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace frontjava.Models
{
    public class Persona
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Telefono { get; set; }
        public string Direccion { get; set; }
        public string Correo { get; set; }
        [DisplayName("Numero de Tarjeta")]
        public int IdTarjeta { get; set; }        
        public List<Tarjeta>tarjetas { get; set; }
    }
}