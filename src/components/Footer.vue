<template>
  <footer class="footer">
    <div class="footer-container">
      <div class="footer-info">
        <h3>Mi Sitio</h3>
        <p>&copy; 2024 Todos los derechos reservados.</p>
      </div>

      <div class="footer-links">
        <ul>
          <li><a href="#">Sobre Nosotros</a></li>
          <li><a href="#">Política de Privacidad</a></li>
          <li><a href="#">Términos y Condiciones</a></li>
        </ul>
      </div>

      <div class="footer-contacts">
        <h4>Contactos del Equipo</h4>
        <table>
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Correo</th>
              <th>Teléfono</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Daira Arce Quisbert</td>
              <td>daira.arce@ucb.edu.bo</td>
              <td>00000000</td>
            </tr>
            <tr>
              <td>Kenneth Lopez Castillo</td>
              <td>kenneth.lopez@ucb.edu.bo</td>
              <td>00000000</td>
            </tr>
            <tr>
              <td>Zapana Pariguana Brian</td>
              <td>zapana.pariguana@ucb.edu.bo</td>
              <td>00000000</td>
            </tr>
            <tr>
              <td>Condarco Poma Fabrisio</td>
              <td>condarco.poma@ucb.edu.bo</td>
              <td>00000000</td>
            </tr>
            <tr>
              <td>Flores Moya Valdir</td>
              <td>flores.moya@ucb.edu.bo</td>
              <td>00000000</td>
            </tr>
          </tbody>
        </table>
      </div>

      <div class="footer-socials">
        <a href="#" aria-label="Facebook">
          <i class="fab fa-facebook"></i>
        </a>
        <a href="#" aria-label="Twitter">
          <i class="fab fa-twitter"></i>
        </a>
        <a href="#" aria-label="Instagram">
          <i class="fab fa-instagram"></i>
        </a>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: "Footer",
};
</script>

<style scoped>
.footer {
  background-color: #2c3e50; /* Azul oscuro */
  color: #ecf0f1; /* Gris claro */
  padding: 20px 0;
  text-align: center;
}

.footer-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}

.footer-info h3 {
  margin: 0;
  font-size: 1.5rem;
}

.footer-info p {
  margin: 5px 0 0;
  font-size: 0.9rem;
  color: #bdc3c7; /* Gris más claro */
}

.footer-links ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  gap: 15px;
}

.footer-links li {
  font-size: 0.9rem;
}

.footer-links a {
  text-decoration: none;
  color: #ecf0f1;
  transition: color 0.3s ease;
}

.footer-links a:hover {
  color: #3498db; /* Azul claro */
}

.footer-contacts {
  text-align: center;
  font-size: 0.9rem;
  width: 100%;
}

.footer-contacts h4 {
  margin-bottom: 10px;
}

.footer-contacts table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

.footer-contacts th,
.footer-contacts td {
  padding: 10px;
  border: 1px solid #ecf0f1;
}

.footer-contacts th {
  background-color: #34495e; /* Azul más oscuro */
}

.footer-contacts td {
  text-align: left;
}

.footer-socials a {
  color: #ecf0f1;
  font-size: 1.2rem;
  margin: 0 10px;
  transition: color 0.3s ease;
}

.footer-socials a:hover {
  color: #3498db; /* Azul claro */
}

@media (min-width: 768px) {
  .footer-container {
    flex-direction: row;
    justify-content: space-between;
    max-width: 1200px;
    margin: 0 auto;
  }
}
</style>
