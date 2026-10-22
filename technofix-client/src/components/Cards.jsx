import React from "react";
import { Card } from "./Card";
import { seed_trabajadores } from "/home/beck/technofix/technofix-client/src/data/trabajadores.js";

export const Cards = () => {
  const devs = seed_trabajadores['desarrolladores'];

  const developers = devs.map((dev) => (
    <Card
      rol={dev.rol}
      nombre={dev.nombre}
      imageId={dev.id}
      bio={dev.bio}
    ></Card>
  ));

  return (
    <section class="py-5">
      <div class="container">
        <div class="row justify-content-center text-center mb-2 mb-lg-4">
          <div class="col-12 col-lg-8 col-xxl-7 text-center mx-auto">
            <span class="text-white fs-4">Nuestros expertos</span>
            <h2 class="display-5 fw-bold">Conoce al equipo</h2>
            <p class="lead text-white">
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Soluta
              harum ipsum venenatis metus sem veniam eveniet aperiam suscipit.
            </p>
          </div>
        </div>
        <div class="row">{developers}</div>
      </div>
    </section>
  );
};
