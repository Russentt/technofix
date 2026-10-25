import React from "react";
import { Navbar } from "../components/Navbar";
import { Clientes } from "../components/Clientes";
import { useState } from "react";
import Reparaciones from "../components/Reparaciones";

const Admin = () => {
  const [page, setPage] = useState("dashboard");

  const activar = (element)=> {
    element.classList.add("active");
  };

  return (
    <>
      <header>
        <Navbar></Navbar>
      </header>
      <main className="d-flex">
        <div className="sidebar" aria-label="sidebar">
          <div
            className="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark vh-100"
            style={{
              width: "240px",
              height: "100%",
            }}
          >
            <a
              href="/"
              class="d-flex align-items-center mb-3 mb-md-0 px-0 w-100 text-white text-decoration-none"
            >
              <svg class="bi me-2" width="40" height="32">
                <use xlink:href="#"></use>
              </svg>
              <span class="fs-4">Administracion</span>
            </a>
            <hr></hr>
            <ul class="nav nav-pills flex-column mb-auto">
              <li onClick={()=>{
                setPage("dashboard")
              }}>
                <a href="#" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#speedometer2"></use>
                  </svg>
                  Dashboard
                </a>
              </li>
              <li onClick={() => setPage("ordenes")}>
                <a href="#" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#table"></use>
                  </svg>
                  Ordenes
                </a>
              </li>
              <li onClick={() => setPage("reparaciones")}>
                <a href="#" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#grid"></use>
                  </svg>
                  Reparaciones
                </a>
              </li>
              <li onClick={() => setPage("clientes")}>
                <a href="#" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#people-circle"></use>
                  </svg>
                  Clientes
                </a>
              </li>
            </ul>
          </div>
        </div>
        {page === "dashboard" && <p>Pendiente...</p>}
        {page === "ordenes" && (
          <>
            <p>No se aun</p>
          </>
        )}
        {page === "reparaciones" && <Reparaciones/>}
        {page === "clientes" && <Clientes />}
      </main>
      <footer>
        <div>Texto footer...</div>
      </footer>
    </>
  );
};

export default Admin;
