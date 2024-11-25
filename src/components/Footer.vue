<template>
  <footer class="footer-container">
    <!-- Sección: Información del Equipo -->
    <div class="team-section">
      <h3>Conoce a nuestro equipo</h3>
      <div class="team-grid">
        <div v-for="integrante in integrantes" :key="integrante.id" class="team-card">
          <img :src="integrante.foto" :alt="`Foto de ${integrante.nombre}`" />
          <div class="team-info">
            <h4>{{ integrante.nombre }}</h4>
            <p>Teléfono: {{ integrante.telefono }}</p>
            <p>Email: <a :href="'mailto:' + integrante.email">{{ integrante.email }}</a></p>
          </div>
        </div>
      </div>
    </div>

    <!-- Sección: Mapa y Botón en dos columnas -->
    <div class="additional-section">
      <div class="map-column">
        <h3><centar>Ubicación</centar></h3>
        <iframe
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3151.8354345086166!2d144.9630577156923!3d-37.814107979751504!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6ad642af0f11fd81%3A0xf5778b2c7c0edfb8!2sFederation%20Square!5e0!3m2!1sen!2sau!4v1619919891628!5m2!1sen!2sau"
          width="100%"
          height="250"
          style="border:0;"
          allowfullscreen=""
          loading="lazy"
        ></iframe>
      </div>
      <div class="button-column">
        <h3>Informe del Proyecto</h3>
        <button @click="openModal" class="btn btn-white btn-animate">
          Ver Informe del Proyecto
        </button>

                  <!-- Modal para mostrar PDF -->
          <div v-if="isModalOpen" class="modal">
            <div class="modal-content">
              <button class="close-button" @click="closeModal">X</button>
              <iframe
                src="/src/assets/informe.pdf"
                width="100%"
                height="100%"
                frameborder="0"
              ></iframe>
            </div>
          </div>

      </div>
    </div>

    <!-- Línea Divisoria y Derechos Reservados -->
    <div class="footer-divider"></div>
    <div class="footer-rights">
      <p>&copy; 2024 Todos los derechos reservados.</p>
    </div>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      integrantes: [
        {
          id: 1,
          nombre: "Juan Pérez",
          telefono: "123-456-7890",
          email: "juan.perez@example.com",
          foto: "https://images.vexels.com/content/136554/preview/people-contact-icon-7c2a5f.png",
        },
        {
          id: 2,
          nombre: "Ana López",
          telefono: "234-567-8901",
          email: "ana.lopez@example.com",
          foto: "https://images.vexels.com/content/136554/preview/people-contact-icon-7c2a5f.png",
        },
        {
          id: 3,
          nombre: "Carlos García",
          telefono: "345-678-9012",
          email: "carlos.garcia@example.com",
          foto: "https://images.vexels.com/content/136554/preview/people-contact-icon-7c2a5f.png",
        },
        {
          id: 4,
          nombre: "María Díaz",
          telefono: "456-789-0123",
          email: "maria.diaz@example.com",
          foto: "https://images.vexels.com/content/136554/preview/people-contact-icon-7c2a5f.png",
        },
        {
          id: 5,
          nombre: "Luis Ramírez",
          telefono: "567-890-1234",
          email: "luis.ramirez@example.com",
          foto: "https://images.vexels.com/content/136554/preview/people-contact-icon-7c2a5f.png",
        },
      ],
      isModalOpen: false, // Propiedad para controlar el modal
    };
  },
  methods: {
    openModal() {
      this.isModalOpen = true; // Abrir el modal
    },
    closeModal() {
      this.isModalOpen = false; // Cerrar el modal
    },
  },
};
</script>


<style scoped>
.footer-container {
  padding-top: 50px;
  margin-top: 50[x];
  background: linear-gradient(to bottom, #cc2c97, #630443);
  color: #ecf0f1;
  padding: 40px 20px;
  display: flex;
  flex-direction: column;
  gap: 30px;
}

.team-section h3,
.additional-section h3 {
  margin-bottom: 10px;
  font-size: 1.5rem;
}

.team-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: 20px;
}

.team-card {
  background: #f176ca;
  border-radius: 10px;
  padding: 10px;
  text-align: center;
}

.team-card img {
  width: 100%;
  max-width: 100px;
  border-radius: 50%;
  margin-bottom: 10px;
}

.team-info h4 {
  margin: 5px 0;
  font-size: 1.2rem;
}

.team-info p {
  margin: 3px 0;
  font-size: 0.9rem;
}

.team-info a {
  color: #4e0537;
  text-decoration: none;
}

.team-info a:hover {
  text-decoration: underline;
}

/* Nueva sección de mapa y botón */
.additional-section {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
  align-items: start;
}

.map-column iframe {
  border-radius: 10px;
  width: 100%;
  align-items: center;
}

.button-column {
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* Botón */
.btn {
  background-color: #89dfe0;
  color: #0d5052;
  align-items: center;
  font-family: 'Kodchasan', sans-serif;
  padding: 15px 40px;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  font-size: 1rem;
  transition: transform 0.3s ease;
  position: relative;
  text-transform: uppercase;
  text-decoration: none;
}

.btn:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.btn:active {
  transform: translateY(-1px);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
}

.btn::after {
  content: "";
  display: inline-block;
  height: 100%;
  width: 100%;
  border-radius: 100px;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;
  transition: all 0.4s;
}

.btn-white::after {
  background-color: #2d8a8b;
}

.btn:hover::after {
  transform: scaleX(1.4) scaleY(1.6);
  opacity: 0;
}

/* Línea divisoria */
.footer-divider {
  height: 1px;
  background-color: #7f8c8d;
  margin: 20px 0;
}

/* Derechos reservados */
.footer-rights {
  text-align: center;
  font-size: 0.9rem;
  color: #bdc3c7;
}
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.8);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background: white;
  width: 80%;
  height: 80%;
  border-radius: 10px;
  position: relative;
}

.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: red;
  color: white;
  border: none;
  border-radius: 50%;
  width: 30px;
  height: 30px;
  font-size: 1.2rem;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
}

.close-button:hover {
  background: darkred;
}

</style>
