import React, { useEffect, useState } from "react";
import { reparacion_service } from "../services/reparacionService";

function Reparaciones() {
  const [reparaciones, setReparaciones] = useState([]);

  useEffect(() => {
    cargarReparaciones();
  }, []);

  const cargarReparaciones = async () => {
    const data = await reparacion_service.getAll();
    setReparaciones(data);
  };

  return (
    <div
      className="flex-grow-1 p-4 bg-info text-dark overflow-y-auto vh-100"
      style={{ minWidth: 0 }}
    >
      <div className="mb-4">
        <h2 className="fw-bold">Reparaciones</h2>
        <p className="text-muted">
          Listado de reparaciones registradas en el sistema
        </p>
      </div>
      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        {reparaciones.map((reparacion) => (
          <div className="col" key={reparacion.id}>
            <div className="card h-100 border-0 shadow-sm">
              <div className="card-body d-flex flex-column">
                <div className="d-flex align-items-center mb-3">
                  <div>
                    <h5 className="card-title">{reparacion.diagnostico}</h5>
                  </div>
                </div>
                <ul className="list-group list-group-flush border-top pt-2 mt-auto">
                  <li className="list-group-item d-flex align-items-center px-0 bg-transparent border-0 py-1">
                    <span className="col-4 small">Descripcion: </span>
                    <span className="text-truncate col-8 small flex-grow-1">
                      {reparacion.descripcion}
                    </span>
                  </li>
                  <li className="list-group-item d-flex align-items-center px-0 bg-transparent border-0 py-1">
                    <span className="col-4 small">Fecha de inicio</span>
                    <span className="text-truncate text-dark col-8 small flex-grow-1">{reparacion.fechaInicio}</span>
                  </li>
                  <li className="list-group-item d-flex align-items-center px-0 bg-transparent border-0 py-1">
                    <span className="col-4 small">Fecha finalizacion</span>
                    <span className="text-truncate text-dark col-8 small flex-grow-1">{reparacion.fechaTermino}</span>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Reparaciones;
