<template>
    <div>
      <h1>Subir y analizar dataset</h1>
      <input type="file" @change="onFileChange" />
      <button @click="submitFile">Enviar</button>
  
      <div v-if="results">
        <h2>Resultados</h2>
        <p><strong>K-Means:</strong> {{ results.kMeansResult }}</p>
        <p><strong>Árbol de decisión:</strong> {{ results.decisionTreeResult }}</p>
        <img :src="'data:image/png;base64,' + results.decisionTreeGraph" alt="Árbol de decisión" />
        <p><strong>Red neuronal:</strong> {{ results.neuralNetworkResult }}</p>
      </div>
    </div>
  </template>
  
  <script>
  import { analyzeDataset } from "@/services/wekaService";
  
  export default {
    data() {
      return {
        file: null,
        results: null,
      };
    },
    methods: {
      onFileChange(event) {
        this.file = event.target.files[0];
      },
      async submitFile() {
        if (!this.file) {
          alert("Selecciona un archivo");
          return;
        }

        try {
          this.results = await analyzeDataset(this.file);
          console.log(this.results); // Verifica los datos recibidos
        } catch (error) {
          console.error("Error en el análisis:", error);
          alert("Ocurrió un error al procesar el archivo");
        }
      },
    },
  };
  </script>
  