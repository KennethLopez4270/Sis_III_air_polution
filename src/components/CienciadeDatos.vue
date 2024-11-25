<template>
  <div class="pagina-ciencia-datos">
    <!-- Encabezado con título y barra -->
    <header class="encabezado">
      <div class="barra-superior"></div>
      <div class="contenido-encabezado">
        <div class="seccion-imagen">
          <img src="@/assets/ni.jpg" alt="Ciencia de Datos" />
        </div>
        <div class="seccion-texto">
          <h1 class="animacion-deslizar">Ciencia de Datos</h1>
          <p class="animacion-desvanecer">"El poder de los datos para transformar el mundo"</p>
        </div>
      </div>
      <div class="barra-inferior"></div>
    </header>

    <!-- Contenido principal -->
    <main>
      <section class="info-section">
        <h2 class="section-title">Información clave sobre Ciencia de Datos</h2>

        <div class="info-block">
          <div class="info-text">
            <h3 class="info-title"><center>¿Qué es la Ciencia de Datos?</center></h3>
            <p>
              La ciencia de datos combina estadística, matemáticas y programación para analizar grandes volúmenes de información. Permite descubrir patrones, generar predicciones y tomar decisiones basadas en datos.
            </p>
          </div>
          <div class="image-container">
            <img src="@/assets/ni.jpg" alt="Análisis de datos" />
          </div>
        </div>

        <div class="divider"></div>

        <div class="info-block reverse">
          <div class="image-container">
            <img src="@/assets/ni.jpg" alt="Modelos predictivos" />
          </div>
          <div class="info-text">
            <h3 class="info-title"><center>Modelos Predictivos</center></h3>
            <p>
              Los modelos predictivos en ciencia de datos se utilizan para anticipar eventos futuros. Aplicaciones como la predicción de ventas o el análisis de riesgos son ejemplos claros de su utilidad.
            </p>
          </div>
        </div>

        <div class="divider"></div>

        <div class="info-block">
          <div class="info-text">
            <h3 class="info-title"><center>Impacto en la Sociedad</center></h3>
            <p>
              La ciencia de datos revoluciona industrias como la salud, finanzas y tecnología. Permite mejorar tratamientos médicos, optimizar recursos y personalizar experiencias para usuarios.
            </p>
          </div>
          <div class="image-container">
            <img src="@/assets/ni.jpg" alt="Impacto de la ciencia de datos" />
          </div>
        </div>

        <div class="divider"></div>

        <div class="info-block reverse">
          <div class="image-container">
            <img src="@/assets/ni.jpg" alt="Futuro de la ciencia de datos" />
          </div>
          <div class="info-text">
            <h3 class="info-title"><center>El Futuro de la Ciencia de Datos</center></h3>
            <p>
              Con la llegada de la inteligencia artificial y el aprendizaje automático, la ciencia de datos sigue evolucionando. Su capacidad para transformar datos en conocimiento continuará siendo clave en las próximas décadas.
            </p>
          </div>
        </div>
      </section>

      <!-- Sección de videos y archivos -->
     <section class="media-section">
 <h2>Videos & Resources</h2>
 <div class="media-columns">
   <div class="media">
     <iframe
 src="https://www.youtube.com/embed/aQeIL6SXpn4"
 frameborder="0"
 allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
 allowfullscreen
 title="What is air pollution?"
></iframe>

     <p>Que es la contaminacion del aire?</p>
   </div>
   <div class="media">
     <iframe
       src="https://www.youtube.com/embed/Fwcce8F32L8"
       frameborder="0"
       allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
       allowfullscreen
       title="Global efforts to combat pollution"
     ></iframe>
     <p>Esfuerzos mundiales para combatir la contaminación.</p>
   </div>
   <div class="media">
     <iframe
       src="https://www.youtube.com/embed/gKHP0YD8ZXQ"
       frameborder="0"
       allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
       allowfullscreen
       title="Impact of air pollution on ecosystems"
     ></iframe>
     <p>El impacto de la contaminacion al cuerpo humano</p>
   </div>
   <div class="media">
 <a href="https://www.esginnova.com/sostenibilidad/soluciones-innovadoras-para-reducir-la-contaminacion/" target="_blank">
   <img src="@/assets/tex.jpg" alt="Vista previa de soluciones innovadoras para un aire más limpio" />
 </a>
 <p>Soluciones innovadoras para un aire más limpio.</p>
</div>

 </div>
</section>
    </main>

    <footer class="media">
  <p>Sube un archivo CSV para procesar los datos.</p>
  
  <!-- Botón para seleccionar archivo -->
  <label for="archivo-csv" class="boton-accion">
    Seleccionar Archivo
  </label>
  <input 
    id="archivo-csv" 
    type="file" 
    @change="procesarArchivo" 
    accept=".csv" 
    class="input-csv"
  />

  <!-- Botón para subir archivo -->
  <button 
    @click="enviarArchivo" 
    class="boton-accion"
    :disabled="!archivoSeleccionado"
  >
    Subir Archivo
  </button>
</footer>

  </div>
</template>

<script>
export default {
  name: "DataScienceInfo",
  data() {
    return {
      archivoSeleccionado: null, // Guarda el archivo seleccionado
    };
  },
  mounted() {
    const infoBlocks = document.querySelectorAll(".info-block");
    infoBlocks.forEach((block, index) => {
      if (index % 2 !== 0) {
        block.classList.add("reverse");
      }
    });

    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) {
            entry.target.classList.add("visible");
          }
        });
      },
      { threshold: 0.2 }
    );

    infoBlocks.forEach((block) => observer.observe(block));
  },
  methods: {
    procesarArchivo(event) {
      // Captura el archivo seleccionado
      this.archivoSeleccionado = event.target.files[0];

      // Valida si el archivo es un CSV
      if (this.archivoSeleccionado && this.archivoSeleccionado.type !== "text/csv") {
        alert("Por favor, selecciona un archivo CSV.");
        this.archivoSeleccionado = null;
      }
    },
    enviarArchivo() {
      if (this.archivoSeleccionado) {
        const formData = new FormData();
        formData.append("archivo", this.archivoSeleccionado);

        // Simulación de envío (usa un servicio o API real aquí)
        console.log("Archivo subido:", this.archivoSeleccionado.name);
        alert("Archivo ${this.archivoSeleccionado.name} subido exitosamente.");

        // Limpia el estado después de enviar
        this.archivoSeleccionado = null;
      }
    },
    irARegistro() {
      this.$router.push("/auth/login");
    },
  },
};
</script>

<style>
/* Importar fuentes */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&family=Playfair+Display:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Kodchasan:wght@400;700&family=Gruppo&family=Raleway:wght@400;700&display=swap');

/* General Styling */
body {
  margin: 0;
  font-family: 'Poppins', sans-serif;
  color: #000000;
  background-color: #f6e9f8; /* Fondo más claro para combinar con tonos morados */
}

/* Encabezado */
.encabezado {
  position: relative;
  text-align: right; /* Título alineado a la derecha */
  overflow: hidden;
}

.barra-superior,
.barra-inferior {
  height: 25px;
  background: linear-gradient(to right, #680148, #ddfeff); /* Tonos morados degradados */
  z-index: 10;
  position: relative;
}

.contenido-encabezado {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ffffff;
  position: relative;
  z-index: 5;
}

.seccion-texto h1 {
  font-size: 4rem;
  font-family: 'Kodchasan', sans-serif;
  color: #680148;
  animation: slide-in 1.5s ease-out;
  margin-right: 10%; /* Ajustado hacia la derecha */
}

.seccion-texto p {
  font-size: 1.5rem;
  color: #467b7c; /* Texto complementario morado */
  font-family: 'Poppins', sans-serif;
  animation: fade-in 2s ease-in;
  margin-right: 60px; /* Ajustado hacia la derecha */
}

.seccion-imagen {
  position: relative;
  width: 70%;
  height: 500px;
  overflow: hidden;
}

.seccion-imagen img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  margin: 0;
  padding: 0;
}

.seccion-imagen::after {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(to right, rgba(255, 255, 255, 0), rgba(255, 255, 255, 1));
  z-index: 2;
  pointer-events: none;
}

/* Animaciones */
@keyframes fade-in {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes slide-in {
  from {
    transform: translateX(50px); /* Ajustado para venir desde la izquierda */
    opacity: 0;
  }
  to {
    transform: translateX(0);
    opacity: 1;
  }
}
.boton-accion {
 background-color: #98d8d9;
 color: #000000;
 align-items: center;
 margin-top: 20px;
 font-family: 'Kodchasan', sans-serif;
 padding: 10px 20px;
 border: none;
 border-radius: 8px;
 cursor: pointer;
 font-size: 1rem;
 transition: transform 0.3s ease;
}

.boton-accion:hover {
 transform: scale(1.1);
 background-color: #7db4b5;
}
/* Sección de Información */
.info-section {
  padding: 30px;
  background-color: #fff5fd; /* Fondo más claro con tonos rosados */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.section-title {
  text-align: center;
  font-family: 'Kodchasan', sans-serif;
  font-weight: 500;
  font-size: 2.5rem;
  color: #680148;
  margin-bottom: 20px;
}

.info-block {
  display: flex;
  align-items: center;
  margin-bottom: 30px;
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.info-block.visible {
  opacity: 1;
  transform: translateY(0);
}

.info-block.reverse {
  flex-direction: row; /* Invierte el orden de los elementos */
}

.info-block img {
  width: 40%;
  height: auto;
  object-fit: cover;
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2), 0 4px 6px rgba(0, 0, 0, 0.15);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.info-text {
  width: 55%;
  padding: 0 20px;
  font-family: 'Poppins', sans-serif;
}

.info-title {
  font-size: 1.5rem;
  color: #8d4585; /* Texto complementario morado */
  font-family: 'Kodchasan', sans-serif;
  margin-bottom: 10px;
  line-height: 1.5;
  font-weight: 400;
}

.info-text p {
  font-size: 1rem;
  color: #000000;
  line-height: 1.6;
  margin-left: 50px;
  margin-right: 50px;
}

.divider {
  width: 80%;
  height: 2px;
  background: linear-gradient(to right, #dbfeff, #680148);
  margin: 20px auto;
  border-radius: 1px;
}

.image-container {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  max-width: 40%;
  height: 300px;
}

.image-container img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2), 0 4px 6px rgba(0, 0, 0, 0.15);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  border-radius: 8px;
}

.image-container img:hover {
  transform: scale(1.05);
  box-shadow: 0 12px 20px rgba(0, 0, 0, 0.3), 0 6px 10px rgba(0, 0, 0, 0.25);
}
/* Media Section */
.media-section {
 background-color: #ffffff;
 padding: 40px;
 box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.media-section h2 {
 text-align: center;
 color: #680148;
 margin-bottom: 20px;
 font-family: 'Kodchasan', sans-serif;
 font-size: 2vw;
}

.media-columns {
 display: grid;
 grid-template-columns: repeat(4, 1fr);
 gap: 20px;
}

.media {
 text-align: center;
}

.media iframe {
 width: 100%;
 height: 200px;
 border: none;
}

.media p {
 margin-top: 10px;
 font-family: 'Poppins', sans-serif;
 color: #000000;
}
.media-section {
 background-color: #ffffff;
 padding: 40px;
 box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.media-section h2 {
 text-align: center;
 color: #680148;
 margin-bottom: 20px;
 font-family: 'Kodchasan', sans-serif;
 font-size: 2vw;
}

.media-columns {
 display: grid;
 grid-template-columns: repeat(4, 1fr);
 gap: 20px;
}

.media {
 text-align: center;
}

.media iframe {
 width: 100%;
 height: 200px;
 border: none;
}

.media p {
 margin-top: 10px;
 font-family: 'Poppins', sans-serif;
 color: #000000;
}
.input-csv {
  /* Ocultamos el input file pero sigue estando en el flujo */
  display: none;
}
</style>