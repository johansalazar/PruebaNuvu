using frontjava.Models;
using System.Collections.Generic;
using System.Web.Mvc;

namespace frontjava.Controllers
{
    public class TarjetasController : Controller
    {
        // GET: Tarjetas
        public ActionResult Index()
        {
            List<Tarjeta> tarjeta = new List<Tarjeta>();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            var lista = ws.listarTarjetas();

            if (lista != null)
            {
                for (int i = 0; i < lista.Length; i++)
                {
                    Tarjeta tar = new Tarjeta();
                    tar.Id = lista[i].id;
                    tar.Numero = lista[i].numero;
                    tar.Agno = lista[i].agno;
                    tar.Mes = lista[i].mes;
                    tar.Codigo = lista[i].codigo;

                    tarjeta.Add(tar);
                }
            }
           

            return View(tarjeta);
        }


        // GET: Tarjetas/Details/5
        public ActionResult Details(int id)
        {
            Tarjeta tar = new Tarjeta();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            //tarjeta=ws.listarTarjeta().ToList();
            var lista = ws.tarjetaId(id);

            tar.Id = lista.id;
            tar.Numero = lista.numero;
            tar.Agno = lista.agno;
            tar.Mes = lista.mes;
            tar.Codigo = lista.codigo;


            return View(tar);
        }

        // GET: Tarjetas/Create
        public ActionResult Create()
        {
            ViewBag.error = null;
            return View();
        }

        // POST: Tarjetas/Create
        [HttpPost]
        public ActionResult Create(Tarjeta tarjeta)
        {
            try
            {
                ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
                //tarjeta=ws.listarTarjeta().ToList();
                string creado = ws.agregarTarjeta(tarjeta.Numero, tarjeta.Agno, tarjeta.Mes, tarjeta.Codigo);

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

        // GET: Tarjetas/Edit/5
        public ActionResult Edit(int id)
        {
            ViewBag.error = null;
            Tarjeta tar = new Tarjeta();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            //tarjeta=ws.listarTarjeta().ToList();
            var lista = ws.tarjetaId(id);

            tar.Id = lista.id;
            tar.Numero = lista.numero;
            tar.Agno = lista.agno;
            tar.Mes = lista.mes;
            tar.Codigo = lista.codigo;

            return View(tar);
        }

        // POST: Tarjetas/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Tarjeta tarjeta)
        {
            try
            {
                ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
                //tarjeta=ws.listarTarjeta().ToList();
                string creado = ws.editarTarjeta(id, tarjeta.Numero, tarjeta.Agno, tarjeta.Mes, tarjeta.Codigo);

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

        // GET: Tarjetas/Delete/5
        public ActionResult Delete(int id)
        {
            ViewBag.error = null;
            Tarjeta tar = new Tarjeta();
            ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
            //tarjeta=ws.listarTarjeta().ToList();
            var lista = ws.tarjetaId(id);

            tar.Id = lista.id;
            tar.Numero = lista.numero;
            tar.Agno = lista.agno;
            tar.Mes = lista.mes;
            tar.Codigo = lista.codigo;

            return View(tar);
        }

        // POST: Tarjetas/Delete/5
        [HttpPost]
        public ActionResult Delete(Tarjeta tarjeta)
        {
            try
            {
                ServiceReference1.ServiciosClient ws = new ServiceReference1.ServiciosClient();
                //tarjeta=ws.listarTarjeta().ToList();
                string creado = ws.eliminarTarjeta(tarjeta.Id);

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