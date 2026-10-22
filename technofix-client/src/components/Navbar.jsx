import React from "react";

export const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-expand-md flex-sm-row navbar-light bg-primary">
      <div className="container-fluid ms-1">
        <span className="navbar-brand mb-0 h1 text-success fw-bolder">
          Technofix
        </span>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <div className="container-fluid">
          <ul className="navbar-nav align-items-center">
            <li className="nav-item">
              <button className="nav-link">Inicio</button>
            </li>
            <li className="nav-item">
              <button className="nav-link">Descubre</button>
            </li>
            <li className="nav-item">
              <button className="nav-link">Contacto</button>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};
