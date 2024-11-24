<template>
    <div>
      <header>
        <nav class="navbar">
          <div class="logo">Ataques Cibernéticos</div>
        </nav>
        <h1 class="main-title">Resultados del Análisis</h1>
      </header>
  
      <section class="results-section">
        <h2>Resultados Obtenidos</h2>
        <div v-if="results">
          <!-- Clustering -->
          <section>
            <h3>Clustering</h3>
            <pre class="results-text">{{ results.kMeansResult }}</pre>
            <div class="image-container">
              <div class="zoom-controls">
                <button @click="zoomIn('clusterZoom')">+</button>
                <button @click="zoomOut('clusterZoom')">-</button>
              </div>
              <div class="image-wrapper" :style="{ transform: `scale(${clusterZoom})` }">
                <img
                  :src="'data:image/png;base64,' + results.clusterGraph"
                  alt="Gráfica de Clustering"
                />
              </div>
            </div>
          </section>
  
          <!-- Árbol de Decisión -->
          <section>
            <h3>Árbol de Decisión</h3>
            <pre class="results-text">{{ results.decisionTreeResult }}</pre>
            <div class="image-container">
              <div class="zoom-controls">
                <button @click="zoomIn('treeZoom')">+</button>
                <button @click="zoomOut('treeZoom')">-</button>
              </div>
              <div class="image-wrapper" :style="{ transform: `scale(${treeZoom})` }">
                <img
                  :src="'data:image/png;base64,' + results.decisionTreeGraph"
                  alt="Gráfica del Árbol de Decisión"
                />
              </div>
            </div>
          </section>
  
          <!-- Redes Neuronales -->
          <section>
            <h3>Redes Neuronales</h3>
            <pre class="results-text">{{ results.neuralNetworkResult }}</pre>
            <div class="image-container">
              <div class="zoom-controls">
                <button @click="zoomIn('neuralNetworkZoom')">+</button>
                <button @click="zoomOut('neuralNetworkZoom')">-</button>
              </div>
              <div class="image-wrapper" :style="{ transform: `scale(${neuralNetworkZoom})` }">
                <img
                  :src="'data:image/png;base64,' + results.neuralNetworkGraph"
                  alt="Gráfica de Redes Neuronales"
                />
              </div>
            </div>
          </section>
        </div>
        <div v-else>
          <p>No se recibieron resultados. Por favor, intenta de nuevo.</p>
        </div>
      </section>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        results: null,
        clusterZoom: 1,
        treeZoom: 1,
        neuralNetworkZoom: 1,
      };
    },
    mounted() {
      const storedResults = localStorage.getItem("analysisResults");
      if (storedResults) {
        this.results = JSON.parse(storedResults);
      } else {
        alert("No se encontraron resultados. Por favor, intenta de nuevo.");
      }
    },
    methods: {
      zoomIn(zoomType) {
        this[zoomType] = Math.min(this[zoomType] + 0.1, 2); // Máximo zoom: 2x
      },
      zoomOut(zoomType) {
        this[zoomType] = Math.max(this[zoomType] - 0.1, 0.5); // Mínimo zoom: 0.5x
      },
    },
  };
  </script>
  
  <style scoped>
  /* Estilo general */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f9f9f9;
  }
  
  .navbar {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #3f51b5;
    color: white;
    padding: 1rem;
  }
  
  .logo {
    font-size: 1.5rem;
    font-weight: bold;
  }
  
  .main-title {
    text-align: center;
    margin: 1rem 0;
    color: #333;
  }
  
  .results-section {
    padding: 1.5rem;
    margin: 1rem auto;
    max-width: 800px;
    background: white;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  }
  
  .results-section h2 {
    text-align: center;
    color: #3f51b5;
    margin-bottom: 1rem;
  }
  
  section h3 {
    color: #3f51b5;
    margin-top: 1.5rem;
  }
  
  .results-text {
    background: #f4f4f4;
    padding: 1rem;
    border-radius: 6px;
    overflow-x: auto;
    font-size: 0.9rem;
    margin-bottom: 1rem;
  }
  
  .image-container {
    margin-top: 1rem;
    position: relative;
    text-align: center;
  }
  
  .image-wrapper {
    display: inline-block;
    overflow: hidden;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  
  img {
    max-width: 100%;
    height: auto;
    display: block;
  }
  
  .zoom-controls {
    display: flex;
    justify-content: center;
    gap: 0.5rem;
    margin-bottom: 0.5rem;
  }
  
  .zoom-controls button {
    background: #3f51b5;
    color: white;
    border: none;
    border-radius: 4px;
    padding: 0.5rem 1rem;
    cursor: pointer;
    font-size: 1rem;
    transition: background 0.3s;
  }
  
  .zoom-controls button:hover {
    background: #303f9f;
  }
  
  .zoom-controls button:active {
    transform: scale(0.95);
  }
  </style>
  