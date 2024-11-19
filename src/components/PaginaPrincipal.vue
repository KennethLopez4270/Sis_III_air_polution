<template>
    <div class="main-container">
      <header>
        <h1>Bienvenido a Nuestra Plataforma</h1>
        <p>La mejor experiencia digital para tus necesidades.</p>
      </header>
  
      <main>
        <img src="https://via.placeholder.com/400x300" alt="Ilustración principal" />
        <router-link to="/auth/login" class="login-button">Iniciar Sesión</router-link>
      </main>
  
      <footer>
        <p>© 2024 Nuestra Plataforma. Todos los derechos reservados.</p>
      </footer>
    </div>
  </template>
  
  <script>
  export default {};
  </script>
  
  <style scoped>
  /* Estilos generales */
  body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(135deg, #4f93d2, #1e3a8a);
    color: #fff;
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  
  /* Contenedor principal */
  .main-container {
    text-align: center;
    padding: 1rem;
  }
  
  header h1 {
    font-size: 2.5rem;
    margin-bottom: 1rem;
    animation: fadeInDown 1s ease;
  }
  
  header p {
    font-size: 1.2rem;
    margin-bottom: 2rem;
    animation: fadeInUp 1s ease;
  }
  
  /* Imagen */
  main img {
    max-width: 100%;
    height: auto;
    border-radius: 15px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
    margin-bottom: 2rem;
    animation: zoomIn 1s ease;
  }
  
  h1, p{
    color: #ddd;
  }
  /* Botón */
  .login-button {
    display: inline-block;
    background-color: #fff;
    color: #1e3a8a;
    border: none;
    border-radius: 25px;
    padding: 0.8rem 2rem;
    font-size: 1.2rem;
    font-weight: bold;
    text-decoration: none;
    transition: transform 0.3s, background-color 0.3s;
  }
  
  .login-button:hover {
    background-color: #f0f0f0;
    transform: scale(1.05);
  }
  
  /* Footer */
  footer {
    margin-top: 2rem;
    font-size: 0.9rem;
    color: #ddd;
  }
  
  /* Animaciones */
  @keyframes fadeInDown {
    from {
      opacity: 0;
      transform: translateY(-20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }
  
  @keyframes fadeInUp {
    from {
      opacity: 0;
      transform: translateY(20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }
  
  @keyframes zoomIn {
    from {
      opacity: 0;
      transform: scale(0.9);
    }
    to {
      opacity: 1;
      transform: scale(1);
    }
  }
  </style>
  