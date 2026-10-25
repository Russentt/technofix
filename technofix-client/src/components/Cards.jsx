import React from "react";
import { Card } from "./Card";
import { seed_trabajadores } from "/home/beck/technofix/technofix-client/src/data/trabajadores.js";

export const Cards = () => {
  const devs = seed_trabajadores["desarrolladores"];

  const developers = devs.map((dev) => (
    <Card
      rol={dev.rol}
      nombre={dev.nombre}
      imageId={dev.id}
      bio={dev.bio}
    ></Card>
  ));

  return (
    <section className="py-5">
      <div className="container">
        <div className="row justify-content-center text-center mb-2 mb-lg-4">
          <div className="col-12 col-lg-8 col-xxl-7 text-center mx-auto">
            <span className="text-white fs-4">Nuestros expertos</span>
            <h2 className="display-5 fw-bold">Conoce al equipo</h2>
            <p className="lead text-white">
              Comprometidos con la tecnología y la solución de problemas,
              nuestros especialistas trabajan en conjunto para ofrecer un
              servicio técnico confiable, eficiente y adaptado a las necesidades
              de cada cliente.
            </p>
          </div>
        </div>
        <div className="row">{developers}</div>
      </div>
    </section>
  );
};
