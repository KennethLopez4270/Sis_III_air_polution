package com.example.ciberataques.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.J48;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/analyze")
@Slf4j
public class WekaController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> analyzeDataset(@RequestParam("file") MultipartFile file) {
        Map<String, Object> results = new HashMap<>();
        try {
            // Cargar dataset CSV
            CSVLoader loader = new CSVLoader();
            InputStream fileStream = file.getInputStream();
            loader.setSource(fileStream);
            Instances data = loader.getDataSet();

            // Aplicar Clustering con K-Means
            SimpleKMeans kMeans = new SimpleKMeans();
            kMeans.setNumClusters(3);
            kMeans.buildClusterer(data);
            results.put("kMeansResult", kMeans.toString());

            // Generar Gráfica para Clustering
            BufferedImage clusterImage = generateClusterImage(kMeans, data);
            String clusterImageBase64 = encodeImageToBase64(clusterImage);
            results.put("clusterGraph", clusterImageBase64);

            // Aplicar Árbol de Decisión
            data.setClassIndex(data.numAttributes() - 1); // Última columna como atributo de clase
            J48 tree = new J48();
            tree.buildClassifier(data);
            results.put("decisionTreeResult", tree.toString());

            // Generar Gráfica del Árbol de Decisión
            String treeGraph = tree.graph();
            BufferedImage treeImage = generateTreeImage(treeGraph);
            String treeImageBase64 = encodeImageToBase64(treeImage);
            results.put("decisionTreeGraph", treeImageBase64);

            // Aplicar Redes Neuronales
            MultilayerPerceptron mlp = new MultilayerPerceptron();
            mlp.setTrainingTime(500); // Opcional: Ajustar tiempo de entrenamiento
            mlp.buildClassifier(data);
            results.put("neuralNetworkResult", mlp.toString());

            // Generar Gráfica para Redes Neuronales
            BufferedImage neuralNetworkImage = generateNeuralNetworkImage(mlp);
            String neuralNetworkImageBase64 = encodeImageToBase64(neuralNetworkImage);
            results.put("neuralNetworkGraph", neuralNetworkImageBase64);

            // Enviar resultados
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            log.error("Error al analizar el archivo", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    private BufferedImage generateTreeImage(String graph) throws Exception {
        TreeVisualizer tv = new TreeVisualizer(null, graph, new PlaceNode2());
        tv.setSize(1200, 800); // Tamaño ajustado
        BufferedImage image = new BufferedImage(tv.getWidth(), tv.getHeight(), BufferedImage.TYPE_INT_RGB);
        tv.paint(image.createGraphics());
        return image;
    }

    private BufferedImage generateClusterImage(SimpleKMeans kMeans, Instances data) throws Exception {
        int width = 1200, height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Dibujar puntos para cada cluster
        g.setColor(Color.BLUE);
        for (int i = 0; i < data.numInstances(); i++) {
            int cluster = kMeans.clusterInstance(data.instance(i));
            int x = (int) (Math.random() * width); // Posición simulada
            int y = (int) (Math.random() * height); // Posición simulada
            g.fillOval(x, y, 5, 5);
            g.drawString("C" + cluster, x, y); // Etiqueta del cluster
        }

        g.dispose();
        return image;
    }

    private BufferedImage generateNeuralNetworkImage(MultilayerPerceptron mlp) {
        int width = 1200, height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Dibujar nodos y conexiones de la red neuronal (simplificado)
        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) { // Capas
            for (int j = 0; j < 5; j++) { // Neuronas
                int x = 100 + i * 200;
                int y = 100 + j * 100;
                g.fillOval(x, y, 20, 20);
                g.drawString("N" + i + j, x, y);
                if (i > 0) {
                    g.drawLine(x - 200, y, x, y); // Conexión entre capas
                }
            }
        }

        g.dispose();
        return image;
    }

    private String encodeImageToBase64(BufferedImage image) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
