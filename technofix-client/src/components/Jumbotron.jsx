import React from "react";

export const Jumbotron = () => {
  return (
    <div class="jumbotron text-center jumbotron-fluid">
      <div className="container bg-primary bg-opacity-50">
        <h1 className="display-2 m-0 p-3 fw-bolder text-success text-capitalize">Technofix</h1>
        <h2 className="display-8 m-0 p-2 fw-bolder text-danger -text-capitalize">Tecnología en buenas manos</h2>
        <p className="lead m-2 fs-3 text-info text-wrap lh-lg fw-bold">
          Reparamos tus dispositivos electrónicos con profesionalismo y
          confianza. En Technofix, nuestro equipo de técnicos especializados
          está preparado para diagnosticar y solucionar problemas en
          computadoras, notebooks y otros equipos electrónicos. Recupera el
          rendimiento de tus dispositivos con un servicio técnico confiable,
          rápido y adaptado a tus necesidades.
        </p>
        <hr class="my-4"></hr>
        <div className="nav-overflow">
          <ul className="nav gap-3 justify-content-center nav-pills">
            <li className="nav-item">
              <a className="nav-link bg-secondary p-3 fs-5">Diagnóstico especializado</a>
            </li>
            <li className="nav-item">
              <a className="nav-link bg-secondary p-3 fs-5">Atención personalizada</a>
            </li>
            <li className="nav-item">
              <a className="nav-link bg-secondary p-3 fs-5">Servicio técnico confiable</a>
            </li>
          </ul>
        </div>
        <hr class="my-4"></hr>
        <p className="m-2 fs-3">Quieres saber mas? Comunicate con nosotros!</p>
        <div class="d-grid gap-2 d-md-flex justify-content-center p-2">
          <button type="button" class="btn btn-primary btn-lg px-4 me-md-2">
            Solicitar servicio técnico
          </button>
          <button type="button" class="btn btn-secondary btn-lg px-4 me-md-2">
            Conocer nuestros servicios
          </button>
        </div>
      </div>
    </div>
  );
};
