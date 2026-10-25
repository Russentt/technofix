import { useEffect, useState } from "react";
import { clienteService } from "../services/clienteService";

export function Clientes() {
  const [clientes, setClientes] = useState([]);

  useEffect(() => {
    loadClientes();
  }, []);

  const loadClientes = async () => {
    const data = await clienteService.getAll();
    setClientes(data);
  };

  return (
    <div
      className="flex-grow-1 p-4 bg-info text-dark overflow-y-auto vh-100"
      style={{ minWidth: 0 }}
    >
      <div className="mb-4">
        <h2 className="fw-bold">Clientes</h2>
        <p className="text-muted">
          Listado de clientes registrados en el sistema
        </p>
      </div>

      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        {clientes.map((cliente) => (
          <div className="col" key={cliente.rut}>
            <div className="card h-100 border-0 shadow-sm">
              <div className="card-body d-flex flex-column">
                <div className="d-flex align-items-center mb-3">
                  <div
                    className="rounded-circle bg-dark text-white d-flex align-items-center justify-content-center fw-bold me-3"
                    style={{ width: "45px", height: "45px" }}
                  >
                    {cliente.nombre[0]}
                    {cliente.apellido[0]}
                  </div>
                  <div>
                    <h5 className="card-title mb-0 fw-semibold text-capitalize">
                      {`${cliente.nombre} ${cliente.apellido}`}
                    </h5>
                    <small className="text-muted font-monospace">
                      RUT: {cliente.rut}-{cliente.dvRut}
                    </small>
                  </div>
                </div>

                <ul className="list-group list-group-flush border-top pt-2 mt-auto">
                  <li className="list-group-item d-flex align-items-center px-0 bg-transparent border-0 py-1">
                    <span className="text-muted small w-25">Email:</span>
                    <span className="text-truncate flex-grow-1 small">
                      {cliente.correo}
                    </span>
                  </li>
                  <li className="list-group-item d-flex align-items-center px-0 bg-transparent border-0 py-1">
                    <span className="text-muted small w-25">Fono:</span>
                    <span className="small">{cliente.telefono}</span>
                  </li>
                  <li className="list-group-item d-flex align-items-center px-0 bg-transparent border-0 py-1">
                    <span className="text-muted small w-25">Direccion:</span>
                    <span
                      className="text-truncate flex-grow-1 small"
                      title={cliente.direccion}
                    >
                      {cliente.direccion}
                    </span>
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
