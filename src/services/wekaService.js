import axios from "axios";

const API_BASE_URL = "http://localhost:8080"; // Cambia si tu backend corre en otro puerto

export const analyzeDataset = async (file) => {
  const formData = new FormData();
  formData.append("file", file);

  try {
    const response = await axios.post(`${API_BASE_URL}/analyze`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
    return response.data;
  } catch (error) {
    console.error("Error al analizar el dataset:", error);
    throw error;
  }
};
