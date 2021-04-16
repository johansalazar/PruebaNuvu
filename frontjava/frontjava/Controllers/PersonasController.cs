using frontjava.Models;
using System.Collections.Generic;
using System.Web.Mvc;

namespace frontjava.Controllers
{
    public class PersonasController : Controller
    {
        public List<Tarjeta> tarjetas()
        {
            List<Tarjeta> tarjeta = new List<Tarjeta>();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            var listaT = ws.listarTarjetas();

            if (listaT != null)
            {
                for (int i = 0; i < listaT.Length; i++)
                {
                    Tarjeta tar = new Tarjeta();
                    tar.Id = listaT[i].id;
                    tar.Numero = listaT[i].numero;
                    tar.Agno = listaT[i].agno;
                    tar.Mes = listaT[i].mes;
                    tar.Codigo = listaT[i].codigo;
                    tarjeta.Add(tar);
                }
            }
            return tarjeta;
        }

        public List<Tarjeta> tarjetasLibres()
        {
            List<Tarjeta> tarjeta = new List<Tarjeta>();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            var listaT = ws.listarTarjetasLibres();

            if (listaT != null)
            {
                for (int i = 0; i < listaT.Length; i++)
                {
                    Tarjeta tar = new Tarjeta();
                    tar.Id = listaT[i].id;
                    tar.Numero = listaT[i].numero;
                    tar.Agno = listaT[i].agno;
                    tar.Mes = listaT[i].mes;
                    tar.Codigo = listaT[i].codigo;
                    tarjeta.Add(tar);
                }
            }
            return tarjeta;
        }

        // GET: Personas
        public ActionResult Index()
        {
            List<Persona> persona = new List<Persona>();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();         
          
            var lista = ws.listarPersona();

            if (lista != null)
            {
                for (int i = 0; i < lista.Length; i++)
                {
                    Persona per = new Persona();
                    per.Id = lista[i].id;
                    per.Nombre = lista[i].nombre;
                    per.Apellidos = lista[i].apellido;
                    per.Telefono = lista[i].telefono;
                    per.Direccion = lista[i].direccion;
                    per.Correo = lista[i].correo;
                    per.IdTarjeta = lista[i].idTarjeta;
                    per.tarjetas = tarjetas();
                    persona.Add(per);
                }
            }

            return View(persona);
        }

        // GET: Personas/Details/5
        public ActionResult Details(int id)
        {
            Persona per = new Persona();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            //persona=ws.listarPersona().ToList();
            var lista = ws.personaId(id);

            per.Id = lista.id;
            per.Nombre = lista.nombre;
            per.Apellidos = lista.apellido;
            per.Telefono = lista.telefono;
            per.Direccion = lista.direccion;
            per.Correo = lista.correo;
            per.IdTarjeta = lista.idTarjeta;
            per.tarjetas = tarjetas();
            return View(per);
        }

        // GET: Personas/Create
        public ActionResult Create()
        {           
            Persona persona = new Persona();
            persona.tarjetas = tarjetasLibres(); 
            ViewBag.error = null;
            return View(persona);
        }

        // POST: Personas/Create
        [HttpPost]
        public ActionResult Create(Persona persona)
        {
            try
            {
                ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
                //persona=ws.listarPersona().ToList();
                string creado = ws.agregarPersona(persona.Nombre, persona.Apellidos, persona.Telefono, persona.Direccion, persona.Correo, persona.IdTarjeta);

                if (creado == "0")
                {
                    return RedirectToAction("Index");
                }
                else
                {
                    ViewBag.error = "Error guardando la información";
                    return View();
                }

            }
            catch
            {
                return View();
            }
        }

        // GET: Personas/Edit/5
        public ActionResult Edit(int id)
        {
            ViewBag.error = null;
            Persona per = new Persona();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            //persona=ws.listarPersona().ToList();
            var lista = ws.personaId(id);

            per.Id = lista.id;
            per.Nombre = lista.nombre;
            per.Apellidos = lista.apellido;
            per.Telefono = lista.telefono;
            per.Direccion = lista.direccion;
            per.Correo = lista.correo;
            per.IdTarjeta = lista.idTarjeta;          
            per.tarjetas = tarjetas();
            ViewBag.error = null;

            return View(per);
        }

        // POST: Personas/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Persona persona)
        {
            try
            {
                ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
                //persona=ws.listarPersona().ToList();
                string creado = ws.editarPersona(id, persona.Nombre, persona.Apellidos, persona.Telefono, persona.Direccion, persona.Correo, persona.IdTarjeta);

                if (creado == "0")
                {
                    return RedirectToAction("Index");
                }
                else
                {
                    ViewBag.error = "Error guardando la información";
                    return View();
                }
            }
            catch
            {
                return View();
            }
        }

        // GET: Personas/Delete/5
        public ActionResult Delete(int id)
        {
            ViewBag.error = null;
            Persona per = new Persona();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            //persona=ws.listarPersona().ToList();
            var lista = ws.personaId(id);

            per.Id = lista.id;
            per.Nombre = lista.nombre;
            per.Apellidos = lista.apellido;
            per.Telefono = lista.telefono;
            per.Direccion = lista.direccion;
            per.Correo = lista.correo;
            per.IdTarjeta = lista.idTarjeta;
            per.tarjetas = tarjetas();
            return View(per);
        }

        // POST: Personas/Delete/5
        [HttpPost]
        public ActionResult Delete(Persona persona)
        {
            try
            {
                ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
                //persona=ws.listarPersona().ToList();
                string creado = ws.eliminarPersona(persona.Id);

                if (creado == "0")
                {
                    return RedirectToAction("Index");
                }
                else
                {
                    ViewBag.error = "Error de procesamiento";
                    return View();
                }
            }
            catch
            {
                return View();
            }
        }
    }
}
